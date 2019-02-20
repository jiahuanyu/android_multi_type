package me.jiahuan.android.multitype

class TypePool(
    private val initializeCapacity: Int = 0,
    private val types: MutableList<Type<*>> = ArrayList(initializeCapacity)
) {

    val size: Int
        get() = types.size

    fun <T> register(type: Type<T>) {
        types.add(type)
    }

    fun unregister(clazz: Class<*>): Boolean {
        return types.removeAll {
            it.clazz == clazz
        }
    }

    fun <T> getType(index: Int): Type<T> = types[index] as Type<T>

    fun firstIndexOf(clazz: Class<*>): Int {
        return types.indexOfFirst {
            it.clazz == clazz
        }
    }

}