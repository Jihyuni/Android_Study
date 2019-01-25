package com.sopt.seminar_04.adapter

import android.content.Context


import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.sopt.seminar_04.R
import com.sopt.seminar_04.dataclass.MemoData
import kotlinx.android.synthetic.main.rv_item_memo.view.*

class MemoRecyclerViewAdapter(val ctx : Context, var dataList : ArrayList<MemoData>) : RecyclerView.Adapter<MemoRecyclerViewAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType : Int): Holder {
        val view : View = LayoutInflater.from(ctx).inflate(R.layout.rv_item_memo, parent,false)
        return Holder(view)
    }

    override fun getItemCount(): Int = dataList.size

    fun addNewItem(memoData: MemoData){
        val positon : Int = dataList.size
        dataList.add(memoData)
        notifyItemInserted(positon)
    }

    override fun onBindViewHolder(holder : Holder, position : Int) {
        holder.title.text = dataList[position].title
        holder.content.text = dataList[position].content
        holder.whole_btn.setOnClickListener {
            try{
            dataList.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,dataList.size)
            }

            catch(e : IndexOutOfBoundsException){
                Log.e("item 제거 중에 오류 뜸", e.toString())
            }
        }
    }




    inner class Holder(itemView: View):RecyclerView.ViewHolder(itemView){
        val title : TextView = itemView.findViewById(R.id.tv_rv_memo_title) as TextView
        val content : TextView = itemView.findViewById(R.id.tv_rv_memo_content) as TextView
        val whole_btn : RelativeLayout = itemView.findViewById(R.id.btn_rv_item_memo_whole_box) as RelativeLayout
    }
}