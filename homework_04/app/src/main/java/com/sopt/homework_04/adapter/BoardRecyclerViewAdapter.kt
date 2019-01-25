package com.sopt.homework_04.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sopt.homework_04.DetailedBoardActivity
import com.sopt.homework_04.data.BoardData
import com.sopt.homework_04.R
import org.jetbrains.anko.startActivity

class BoardRecyclerViewAdapter(val ctx: Context, val dataList: ArrayList<BoardData>) :
        RecyclerView.Adapter<BoardRecyclerViewAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(ctx).inflate(R.layout.rv_item_board, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int = dataList.size
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.title.text = dataList[position].b_title
        holder.like_cnt.text = dataList[position].b_like.toString()
        holder.date.text = dataList[position].b_date
        holder.whole.setOnClickListener {
            ctx.startActivity<DetailedBoardActivity>("b_id" to dataList[position].b_id)
        }
        val requestOptions = RequestOptions()
        requestOptions.placeholder(R.drawable.ic_launcher_background)
        requestOptions.error(R.drawable.ic_launcher_foreground)
        requestOptions.override(150)
        Glide.with(ctx)
                .setDefaultRequestOptions(requestOptions)
                .load(dataList[position].b_photo)
                .thumbnail(0.5f)
                .into(holder.image)
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tv_rv_item_board_title) as TextView
        val like_cnt: TextView = itemView.findViewById(R.id.tv_rv_item_board_like_cnt) as TextView
        val date: TextView = itemView.findViewById(R.id.tv_rv_item_board_date) as TextView
        val image: ImageView = itemView.findViewById(R.id.iv_rv_item_board_image) as ImageView
        val whole: RelativeLayout = itemView.findViewById(R.id.lo_board_item) as RelativeLayout
    }
}