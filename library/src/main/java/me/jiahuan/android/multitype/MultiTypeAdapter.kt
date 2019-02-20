package me.jiahuan.android.multitype

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class MultiTypeAdapter @JvmOverloads constructor(
    var items: List<Any> = emptyList(),
    private val typePool: TypePool = TypePool()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    fun <T> register(clazz: Class<T>, binder: ItemViewBinder<T, *>) {
        typePool.register(Type(clazz, binder, DefaultLink()))
    }

    fun <T> register(
        clazz: Class<T>,
        linker: (Int, T) -> Class<out ItemViewBinder<T, *>>,
        vararg binders: ItemViewBinder<T, *>
    ) {
        for (binder in binders) {
            typePool.register(Type(clazz, binder, OneToManyLink(binders.toList(), linker)))
        }
    }

    override fun getItemViewType(position: Int): Int {
        return indexOfViewType(position)
    }

    // viewType == item position
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binder = typePool.getType<Any>(viewType).binder
        return binder.onCreateViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        onBindViewHolder(holder, position, emptyList())
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int, payloads: List<Any>) {
        val item = items[position]
        val binder = typePool.getType<Any>(holder.itemViewType).binder as ItemViewBinder<Any, RecyclerView.ViewHolder>
        binder.onBindViewHolder(holder, item, payloads)
    }

    private fun indexOfViewType(position: Int): Int {
        val index = typePool.firstIndexOf(items[position].javaClass)
        if (index != -1) {
            val linker = typePool.getType<Any>(index).link
            return index + linker.index(position, items[position])
        }
        return 0
    }
}