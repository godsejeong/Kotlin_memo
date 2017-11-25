package com.example.pc.kotlin_memo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.view_memo.*
import android.widget.Toast
import kotlinx.android.synthetic.main.add_memo.*


/**
 * Created by pc on 2017-11-25.
 */
class View_Memo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_memo)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        var intent = getIntent() as Intent
        var title = intent.getStringExtra("title") as String
        var content = intent.getStringExtra("content") as String

        view_title.setText(title)
        view_content.setText(content)

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.getItemId()
        when (id) {
            R.id.home -> {
            onSupportNavigateUp()
            return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

}