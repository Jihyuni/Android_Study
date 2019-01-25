package com.sopt.recyclerviewpractice.adapter

import android.content.Context
import android.provider.ContactsContract
import android.support.v7.widget.RecyclerView
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sopt.recyclerviewpractice.R
import com.sopt.recyclerviewpractice.SubActivity
import com.sopt.recyclerviewpractice.data.kakaoroomData
import org.jetbrains.anko.image
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import java.text.FieldPosition

class KakaoRecyclerViewAdapter(val ctx : Context, val dataList : ArrayList<kakaoroomData>)  : RecyclerView.Adapter<KakaoRecyclerViewAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        var view: View = LayoutInflater.from(ctx).inflate(R.layout.rv_item, parent, false)
        return Holder(view)

    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.username.text = dataList[position].username
        holder.place.text = dataList[position].place

        val requestOptions = RequestOptions()
        Glide.with(ctx)
                .setDefaultRequestOptions(requestOptions)
                .load(dataList[position].photo)
                .thumbnail(0.5f)
                .into(holder.photo)

        Glide.with(ctx)
                .setDefaultRequestOptions(requestOptions)
                .load(dataList[position].userimage)
                .thumbnail(0.5f)
                .into(holder.userimage)

    }

    inner class Holder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val username: TextView = itemView.findViewById(R.id.tv_rv_item_user_name) as TextView
        val place: TextView = itemView.findViewById(R.id.tv_rv_item_place) as TextView
        val userimage: ImageView = itemView.findViewById(R.id.iv_rv_user_picture) as ImageView
        val photo: ImageView = itemView.findViewById(R.id.iv_rv_photo) as ImageView


    }
}
