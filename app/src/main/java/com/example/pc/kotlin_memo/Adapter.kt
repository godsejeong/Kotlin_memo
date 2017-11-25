package com.example.pc.kotlin_memo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import org.w3c.dom.Text

import java.util.ArrayList

/**
 * Created by pc on 2017-11-25.
 */

class Adapter(context: Context, data_items: ArrayList<Data>,data_layout: Int) : BaseAdapter() {
    private val inflater: LayoutInflater
    private var items = ArrayList<Data>()
    private var layout : Int = 0

    init {
        inflater = LayoutInflater.from(context)
        items = data_items
        layout = data_layout
    }

    override fun getView(i: Int, convertview: View?, viewGroup: ViewGroup): View {
        var view:View?=null

        view =  inflater?.inflate(R.layout.items,viewGroup,false)

        var title : TextView

        title = view?.findViewById<TextView>(R.id.item_text) as TextView

        var data : Data
        data = getItem(i)!!

        title.setText(data.title)

        return view!!
    }

    override fun getCount(): Int {
        return items!!.size
    }

    override fun getItem(i: Int): Data? {
        return items?.get(i)
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }


}

