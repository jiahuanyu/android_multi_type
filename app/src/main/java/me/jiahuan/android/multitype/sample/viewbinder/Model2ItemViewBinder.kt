package me.jiahuan.android.multitype.sample.viewbinder

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import me.jiahuan.android.multitype.ItemViewBinder
import me.jiahuan.android.multitype.sample.R
import me.jiahuan.android.multitype.sample.model.Model2

class Model2ItemViewBinder: ItemViewBinder<Model2, Model2ItemViewBinder.Model2ViewHolder>() {
    override fun onBindViewHolder(holder: Model2ViewHolder, item: Model2) {
        holder.title.text = item.title
    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): Model2ViewHolder {
        return Model2ViewHolder(inflater.inflate(R.layout.layout_model2, parent, false))
    }

    class Model2ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.id_model2_title)
    }
}