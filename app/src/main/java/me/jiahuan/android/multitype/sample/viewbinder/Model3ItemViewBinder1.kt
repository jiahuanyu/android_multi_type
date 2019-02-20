package me.jiahuan.android.multitype.sample.viewbinder

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import me.jiahuan.android.multitype.ItemViewBinder
import me.jiahuan.android.multitype.sample.R
import me.jiahuan.android.multitype.sample.model.Model2
import me.jiahuan.android.multitype.sample.model.Model3

class Model3ItemViewBinder1: ItemViewBinder<Model3, Model3ItemViewBinder1.Model3ViewHolder1>() {
    override fun onBindViewHolder(holder: Model3ViewHolder1, item: Model3) {
    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): Model3ViewHolder1 {
        return Model3ViewHolder1(inflater.inflate(R.layout.layout_model3_1, parent, false))
    }

    class Model3ViewHolder1(itemView:View):RecyclerView.ViewHolder(itemView) {
    }
}