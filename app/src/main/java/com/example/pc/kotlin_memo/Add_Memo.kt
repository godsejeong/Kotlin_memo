package com.example.pc.kotlin_memo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.pc.kotlin_memo.R.id.content
import com.example.pc.kotlin_memo.R.id.title
import kotlinx.android.synthetic.main.add_memo.*


/**
 * Created by pc on 2017-11-25.
 */
class Add_Memo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_memo)
        val intent = intent
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.getItemId()
        when (id) {
            R.id.send -> {

                intent.putExtra("content",content.text.toString())
                intent.putExtra("title",add_title.text.toString())
                setResult(RESULT_OK, intent)
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}