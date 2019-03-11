package com.example.mangacomiclist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class Main2Activity : AppCompatActivity() {

    companion object {
        const val TOTAL_COUNT = "total_count"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    fun showRandomNumber() {
        val count =  intent.getIntExtra(TOTAL_COUNT, 0)
        val random = Random()
        var randomInt = 0
    }
}
