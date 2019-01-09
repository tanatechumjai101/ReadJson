package com.example.tanatechumjai.myapplication

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.user_row.view.*
import org.json.JSONObject

class MainAdapter(
    var context: Context?=null,
    var Arraylist: ArrayList<String>,
    var Arraylist2: ArrayList<JSONObject>

    ): RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return Arraylist.size

    }

    override fun onCreateViewHolder(parant: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        var view: View = LayoutInflater.from(parant.context).inflate(R.layout.user_row, parant, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.data.text = "\n ${Arraylist[position]} \n ${Arraylist2[position].getString("th")} \n ${Arraylist2[position].getString("en")}"


        holder.itemView.setOnClickListener {
            val intent = Intent(context, NewMain::class.java)
            intent.putExtra("title",Arraylist[position])
            intent.putExtra("th",Arraylist2[position].getString("th"))
            intent.putExtra("en",Arraylist2[position].getString("en"))
            context?.startActivity(intent)

        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        var Listview_1: ListView = itemView.findViewById(R.id.Listview_1)
    }
}
