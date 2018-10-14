package com.katakin.mvp.di.base

class TreeComponent(var component: BaseComponent?) {
    private var parent: TreeComponent? = null
    private var children: MutableList<TreeComponent> = mutableListOf()

    fun addChild(tree: TreeComponent) {
        children.add(tree)
        tree.parent = this
    }

    fun remove() {
        children.clear()
        parent?.children?.remove(this)
    }

    fun find(simpleName: String): TreeComponent? {
        if (component?.javaClass?.simpleName?.contains(simpleName, true) == true) {
            return this
        } else {
            children.forEach {
                val result = it.find(simpleName)
                if (result != null) {
                    return result
                }
            }
        }
        return null
    }

    fun toIndentedString(builder: StringBuilder = StringBuilder(), level: Int = 0): StringBuilder {
        if (component != null) {
            for (i in 0 until level) {
                builder.append("   ")
            }
            builder.append("${component?.javaClass?.simpleName}")
            if (children.isNotEmpty()) {
                builder.append(": [\n")
                children.forEach {
                    it.toIndentedString(builder, level + 1)
                }
                for (i in 0 until level) {
                    builder.append("   ")
                }
                builder.append("]")
            }
            builder.append("\n")
        }
        return builder
    }
}