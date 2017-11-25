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
import com.example.pc.kotlin_memo.R.layout.items
import android.R.id.edit
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.example.pc.kotlin_memo.R.layout.items
import com.google.gson.reflect.TypeToken
import com.example.pc.kotlin_memo.R.layout.items






class MainActivity : AppCompatActivity() {
    var items: ArrayList<Data> = ArrayList()
    lateinit var adapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = Adapter(this, items, R.layout.items)
        list_view.adapter=adapter
        load()

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
                save()
            }
        }
    }

    fun save(){
        val pref = getSharedPreferences("pref", Context.MODE_PRIVATE)
        val editor = pref.edit()
        val json = Gson().toJson(items)
        editor.putString("save", json)
        editor.commit()

    }

    fun load(){
        val gson = Gson()
        val pref = getSharedPreferences("pref", Context.MODE_PRIVATE)
        val json = pref.getString("save", "")
        var items_: ArrayList<Data>? = ArrayList()
        items_ = gson.fromJson<Any>(json, object : TypeToken<ArrayList<Data>>() {

        }.type) as ArrayList<Data>?
        if (items_ != null) items.addAll(items_)
    }
}

