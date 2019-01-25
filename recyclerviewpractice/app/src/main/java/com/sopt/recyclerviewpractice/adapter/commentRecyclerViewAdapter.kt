package com.sopt.recyclerviewpractice.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.sopt.recyclerviewpractice.R
import com.sopt.recyclerviewpractice.data.commentData
import com.sopt.recyclerviewpractice.data.kakaoroomData

class commentRecyclerViewAdapter(val ctx : Context, val dataList : ArrayList<commentData>)  : RecyclerView.Adapter<commentRecyclerViewAdapter.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): commentRecyclerViewAdapter.Holder {

        var view : View = LayoutInflater.from(ctx).inflate(R.layout.rv_item,parent,false)
        return Holder(view)

    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position : Int) {

        holder.comment.text = dataList[position].comment
        holder.commentname.text = dataList[position].commentname
    }

    inner class Holder(itemview : View) : RecyclerView.ViewHolder(itemview){
        val commentname : TextView = itemview.findViewById(R.id.tv_rv_comment_commentname) as TextView
        val comment : TextView = itemview.findViewById(R.id.tv_rv_comment_comment) as TextView




    }
}