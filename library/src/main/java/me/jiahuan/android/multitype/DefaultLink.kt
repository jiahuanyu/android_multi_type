package me.jiahuan.android.multitype

internal class DefaultLink<T> : Link<T> {
    override fun index(position: Int, item: T): Int = 0
}