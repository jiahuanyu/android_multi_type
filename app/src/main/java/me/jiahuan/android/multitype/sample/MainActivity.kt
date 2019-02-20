package me.jiahuan.android.multitype.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import me.jiahuan.android.multitype.MultiTypeAdapter
import me.jiahuan.android.multitype.sample.model.Model1
import me.jiahuan.android.multitype.sample.model.Model2
import me.jiahuan.android.multitype.sample.model.Model3
import me.jiahuan.android.multitype.sample.viewbinder.Model1ItemViewBinder
import me.jiahuan.android.multitype.sample.viewbinder.Model2ItemViewBinder
import me.jiahuan.android.multitype.sample.viewbinder.Model3ItemViewBinder1
import me.jiahuan.android.multitype.sample.viewbinder.Model3ItemViewBinder2

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val items = ArrayList<Any>()
        items.add(Model1("name", 10))
        items.add(Model2("title", "url", "content"))
        items.add(Model3("2"))
        items.add(Model3("1"))
        val adapter = MultiTypeAdapter(items)
        adapter.register(Model1::class.java, Model1ItemViewBinder())
        adapter.register(Model2::class.java, Model2ItemViewBinder())
        adapter.register(Model3::class.java, { _, item ->
            when (item.name) {
                "1" -> Model3ItemViewBinder1::class.java
                else -> Model3ItemViewBinder2::class.java
            }
        }, Model3ItemViewBinder1(), Model3ItemViewBinder2())
        id_rv.layoutManager = LinearLayoutManager(this)
        id_rv.adapter = adapter
    }
}
