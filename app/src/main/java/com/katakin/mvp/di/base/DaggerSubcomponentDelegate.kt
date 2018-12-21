package com.katakin.mvp.di.base

import com.katakin.mvp.di.AppComponent
import com.katakin.mvp.di.ComponentManager
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun <T : BaseComponent, P : BaseComponent> subcomponent(
        componentClazz: Class<T>,
        parentComponentClazz: Class<P>,
        block: P.() -> T
): ReadWriteProperty<Any?, T?> = DaggerSubcomponentDelegate(
        componentClazz,
        ComponentManager.getTreeComponent().find(parentComponentClazz)!!,
        block
)

fun <T : BaseComponent> subcomponent(
        componentClazz: Class<T>,
        block: AppComponent.() -> T
): ReadWriteProperty<Any?, T?> = DaggerSubcomponentDelegate(
        componentClazz,
        ComponentManager.getTreeComponent(),
        block
)

private class DaggerSubcomponentDelegate<in Any, T : BaseComponent, P : BaseComponent>(
        private val componentClazz: Class<T>,
        private val parentTree: TreeComponent,
        private val initializer: P.() -> T
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
    }

    @Suppress("UNCHECKED_CAST")
    private fun makeTree(): TreeComponent {
        var componentTree = parentTree.find(componentClazz)
        if (componentTree == null) {
            val value = (parentTree.component as P).initializer()
            componentTree = TreeComponent(value).also {
                parentTree.addChild(it)
            }
        }
        return componentTree
    }
}