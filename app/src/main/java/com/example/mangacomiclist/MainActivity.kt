package com.example.mangacomiclist

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun toastMe(view: View) {
        val my_toast = Toast.makeText(this, "T O A S T E D", Toast.LENGTH_SHORT)
        my_toast.show()
    }

    fun countMe(view: View) {
        val show_count_textview =  findViewById<TextView>(R.id.textView)
        var count: Int = Integer.parseInt(show_count_textview.text.toString())
        count++
        show_count_textview.text = count.toString()
    }

    fun randomMe(view: View) {
        val count_value = findViewById<TextView>(R.id.textView)
        var count: Int = Integer.parseInt(count_value.text.toString())
        val random_intent = Intent(this, Main2Activity::class.java)
        random_intent.putExtra(Main2Activity.TOTAL_COUNT, count)
        startActivity(random_intent)
    }
}
