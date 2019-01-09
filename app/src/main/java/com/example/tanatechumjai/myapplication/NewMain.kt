package com.example.tanatechumjai.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.data.*
import kotlinx.android.synthetic.main.user_row.*
import kotlinx.android.synthetic.main.user_row.view.*

class NewMain: AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.data)

        dataText_1.apply {
            val text1 = intent.extras!!.getString("title")
            val text2 = intent.extras!!.getString("th")
            val text3 = intent.extras!!.getString("en")
            val text4 = intent.extras!!.getInt("number")
            val image1 = intent.extras!!.getInt("oov")
            if (image1%2==0){
                img2.setImageDrawable(context?.getDrawable(R.drawable.ic_camera))
            }else if(image1%2!=0){
                img2.setImageDrawable(context?.getDrawable(R.drawable.ic_old_fashion_briefcase))
            }
            text = "$text4 \n $text1 \n $text2 \n $text3"
        }

//        img1.setImageDrawable(getDrawable(R.drawable.ic_camera))

        dataButton_1.apply {
            text =  "close"
            setOnClickListener {
                finish()
            }
        }
    }

}