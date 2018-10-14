package com.katakin.mvp.di.base

import com.katakin.mvp.di.AppComponent
import com.katakin.mvp.di.ComponentManager
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun <T : BaseComponent, P : BaseComponent> subcomponent(
        componentSimpleName: String,
        parentComponentSimpleName: String,
        block: P.() -> T,
        afterChange: () -> Unit
): ReadWriteProperty<Any?, T?> = DaggerSubcomponentDelegate(
        componentSimpleName,
        ComponentManager.getComponents().find(parentComponentSimpleName)!!,
        block,
        afterChange
)

fun <T : BaseComponent> subcomponent(
        componentSimpleName: String,
        block: AppComponent.() -> T,
        afterChange: () -> Unit
): ReadWriteProperty<Any?, T?> = DaggerSubcomponentDelegate(
        componentSimpleName,
        ComponentManager.getComponents(),
        block,
        afterChange
)

private class DaggerSubcomponentDelegate<in Any, T : BaseComponent, P : BaseComponent>(
        private val componentName: String,
        private val parentTree: TreeComponent,
        private val initializer: P.() -> T,
        private val afterChange: () -> Unit
) : ReadWriteProperty<Any?, T?> {

    private var tree: TreeComponent? = null

    @Suppress("UNCHECKED_CAST")
    override fun getValue(thisRef: Any?, property: KProperty<*>): T? {
        if (tree == null) {
            tree = makeTree()
        }
        return tree?.component as? T
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T?) {
        if (tree == null) {
            tree = makeTree()
        }
        if (value != null) {
            tree!!.component = value
        } else {
            tree?.remove()
            tree = null
        }
        afterChange()
    }

    @Suppress("UNCHECKED_CAST")
    private fun makeTree(): TreeComponent {
        var componentTree = parentTree.find(componentName)
        if (componentTree == null) {
            val value = (parentTree.component as P).initializer()
            componentTree = TreeComponent(value).also {
                parentTree.addChild(it)
            }
        }
        return componentTree
    }
}