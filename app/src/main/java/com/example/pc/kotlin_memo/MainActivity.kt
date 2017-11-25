package com.example.pc.kotlin_memo

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var items: ArrayList<Data> = ArrayList()
    lateinit var adapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fab.setOnClickListener {
            val intent = Intent(this, Add_Memo::class.java)
            startActivityForResult(intent, 555)
        }


        list_view.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, l ->

            val data = adapter.getItem(position) as Data

            var intent = Intent(this,View_Memo::class.java)
            intent.putExtra("title",data.title)
            intent.putExtra("content",data.content)
            startActivity(intent)
        }
    }




//    fun ListView.itemClick(itemClick: (Int) -> Any): ListView {
//        this.setOnItemClickListener (object:OnItemClickListener{
//            override fun onItemClick(parent: AdapterView<out Adapter?>?, view: View?, position: Int, id: Long) {
//                itemClick(position)
//            }
//
//        })
//        return this
//    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {

            if (requestCode == 555) {
                var title = data?.getStringExtra("title")
                var content = data?.getStringExtra("content")
                Log.d("title",title)

                items.add(Data(title,content))
                adapter = Adapter(this, items, R.layout.items)
                list_view.adapter=adapter
            }
        }
    }
}

