package com.example.tanatechumjai.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.data.*

class NewMain: AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.data)

        dataText_1.apply {
            val text1 = intent.extras!!.getString("title")
            val text2 = intent.extras!!.getString("th")
            val text3 = intent.extras!!.getString("en")

            text = "$text1 \n $text2 \n $text3"
        }

        dataButton_1.apply {
            text =  "close"
            setOnClickListener {
                finish()
            }
        }
    }

}