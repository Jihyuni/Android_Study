package com.sopt.recyclerviewpractice.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.sopt.recyclerviewpractice.R
import com.sopt.recyclerviewpractice.data.kakaoroomData
import com.sopt.recyclerviewpractice.data.memoData
import java.text.FieldPosition

class MemoRecyclerViewAdapter(val ctx : Context, val dataList : ArrayList<memoData>)  : RecyclerView.Adapter<MemoRecyclerViewAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        var view : View = LayoutInflater.from(ctx).inflate(R.layout.rv_map_item,parent,false)
        return Holder(view)
    }

    override fun getItemCount(): Int = dataList.size


    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.title.text = dataList[position].title
        holder.content.text = dataList[position].content
        holder.item.setOnClickListener({
            try {
                dataList.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position, dataList.size)
            } catch (e : IndexOutOfBoundsException){ Log.e("Index error", e.toString())
            }

        })

    }


    inner class Holder(itemview : View) : RecyclerView.ViewHolder(itemview) {
        val title: TextView = itemView.findViewById(R.id.tv_rv_item_memo_title) as TextView
        val content: TextView = itemView.findViewById(R.id.tv_rv_item_memo_content) as TextView

        val item: RelativeLayout = itemview.findViewById(R.id.btn_memo_item) as RelativeLayout
    }

}