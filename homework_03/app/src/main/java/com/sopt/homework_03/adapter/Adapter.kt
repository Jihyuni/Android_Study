package com.sopt.homework_03.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.sopt.homework_03.MainActivity
import com.sopt.homework_03.R
import com.sopt.homework_03.data.Viewdata
import org.jetbrains.anko.toast

class rvAdapter(val ctx : Context, val dataList : ArrayList<Viewdata>)
    : RecyclerView.Adapter<rvAdapter.Holder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType : Int): Holder {
        var view : View = LayoutInflater.from(ctx).inflate(R.layout.rv_item,parent,false)
        return(Holder(view))


    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.count.text = dataList[position].count.toString()


           // if (dataList[position].isLike)
           // {
           //     holder.isLike.setImageResource(R.drawable.ic_favorite_border_black_24dp)

           // }




        holder.item.setOnClickListener {
            ctx.toast("${dataList[position].count}")

            if(dataList[position].isLike)
            {
                dataList[position].isLike=false
                holder.isLike.setImageResource(0)
                ctx.toast("${dataList[position].isLike}")

            }
            else
            {
                dataList[position].isLike=true
                holder.isLike.setImageResource(R.drawable.ic_favorite_border_black_24dp)
                ctx.toast("${dataList[position].isLike}}")
            }
        }



    }






    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var count : TextView =itemView.findViewById(R.id.tv_main_act_number) as TextView
        var isLike : ImageView = itemView.findViewById(R.id.iv_main_act_islike) as ImageView
        var item : RelativeLayout = itemView.findViewById(R.id.btn_rv_item) as RelativeLayout
    }

}