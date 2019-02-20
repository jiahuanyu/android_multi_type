package me.jiahuan.android.multitype

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

abstract class ItemViewBinder<T, VH : RecyclerView.ViewHolder> {
    abstract fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): VH

    abstract fun onBindViewHolder(holder: VH, item: T)

    open fun onBindViewHolder(holder: VH, item: T, payloads: List<Any>) {
        onBindViewHolder(holder, item)
    }

    fun getPosition(holder: RecyclerView.ViewHolder): Int {
        return holder.adapterPosition
    }
}