package com.example.tanatechumjai.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.user_row.*
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import android.content.Intent



class MainActivity : AppCompatActivity() {

    var arrayone = arrayListOf<String>()
    var arrayTwo = arrayListOf<JSONObject>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Readjson()
    }



    fun Readjson(){


        var json : String? = null
        try {

            val inputStream: InputStream = assets.open("json.json")
            json = inputStream.bufferedReader().use { it.readText() }
            val js = JSONObject(json)

            IDJSON.text = "ID "+js.getString("Id")
            FirstName.text = "FirstName "+js.getString("firstName")
            LastName.text = "LastName "+js.getString("lastName")

            val jsonrr = js.getJSONArray("data")

            for (i in 0 until jsonrr.length()){

                val jsonobj = jsonrr.getJSONObject(i)
                arrayone.add(jsonobj.getString("docType"))
                arrayTwo.add(jsonobj.getJSONObject("description"))

            }

            Listview_1.adapter = MainAdapter(this,arrayone,arrayTwo)
            Listview_1.layoutManager = LinearLayoutManager(this)


        }catch (e: IOException){

        }




    }
}
