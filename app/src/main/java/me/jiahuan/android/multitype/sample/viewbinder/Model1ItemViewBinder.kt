package me.jiahuan.android.multitype.sample.viewbinder

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import me.jiahuan.android.multitype.ItemViewBinder
import me.jiahuan.android.multitype.sample.R
import me.jiahuan.android.multitype.sample.model.Model1

class Model1ItemViewBinder : ItemViewBinder<Model1, Model1ItemViewBinder.Model1ViewHolder>() {
    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): Model1ViewHolder {
        return Model1ViewHolder(inflater.inflate(R.layout.layout_model1, parent, false))
    }

    override fun onBindViewHolder(holder: Model1ViewHolder, item: Model1) {
        holder.name.text = item.name
        holder.age.text = item.age.toString()
    }

    class Model1ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.id_model1_name)
        val age = itemView.findViewById<TextView>(R.id.id_model1_age)
    }
}