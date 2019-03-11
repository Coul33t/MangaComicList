package com.example.mangacomiclist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlin.random.Random

class Main2Activity : AppCompatActivity() {

    companion object {
        const val TOTAL_COUNT = "total_count"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        showRandomNumber()
    }

    fun showRandomNumber() {
        val count =  intent.getIntExtra(TOTAL_COUNT, 0)
        var randomInt = 0

        if (count > 0) {
            randomInt = Random.nextInt(count + 1)
        }

        findViewById<TextView>(R.id.random_number).text = Integer.toString(randomInt)
        findViewById<TextView>(R.id.textView3).text = getString(R.string.num_0_val, count)
    }
}
