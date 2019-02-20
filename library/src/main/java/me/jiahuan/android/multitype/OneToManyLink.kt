package me.jiahuan.android.multitype

class OneToManyLink<T> constructor(
    val binders: List<ItemViewBinder<T, *>>,
    val linker: (Int, T) -> Class<out ItemViewBinder<T, *>>
) : Link<T> {
    override fun index(position: Int, item: T): Int {
        val binderClazz = linker(position, item)
        for (i in binders.indices) {
            if (binders[i].javaClass == binderClazz) {
                return i
            }
        }
        return 0
    }
}