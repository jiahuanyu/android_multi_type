package me.jiahuan.android.multitype

data class Type<T>(
    val clazz: Class<T>,
    val binder: ItemViewBinder<T, *>,
    val link: Link<T>
)