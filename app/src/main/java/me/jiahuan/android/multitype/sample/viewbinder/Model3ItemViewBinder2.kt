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

class Model3ItemViewBinder2: ItemViewBinder<Model3, Model3ItemViewBinder2.Model3ViewHolder2>() {
    override fun onBindViewHolder(holder: Model3ViewHolder2, item: Model3) {
    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): Model3ViewHolder2 {
        return Model3ViewHolder2(inflater.inflate(R.layout.layout_model3_2, parent, false))
    }

    class Model3ViewHolder2(itemView:View):RecyclerView.ViewHolder(itemView) {
    }
}