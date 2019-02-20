package me.jiahuan.android.multitype

interface Link<T> {
    fun index(position: Int, item: T): Int
}