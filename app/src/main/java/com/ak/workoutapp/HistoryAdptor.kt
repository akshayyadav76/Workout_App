package com.ak.workoutapp

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_history.view.*


class HistoryAdptor(val context: Context, val items:ArrayList<String>) :RecyclerView.Adapter<HistoryAdptor.ViewHoder>(){

    class ViewHoder(view: View):RecyclerView.ViewHolder(view){
        val llHistoroyMainItems = view.ll_history
        val tvItem = view.tvItem
        val tvPosition = view.tv_position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoder {
        return  ViewHoder(LayoutInflater.from(context).inflate(R.layout.item_history,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHoder, position: Int) {
     val data:String = items.get(position)

        holder.tvPosition.text = (position+1).toString()
        holder.tvItem.text = data

        if(position%2 ==0){
            holder.llHistoroyMainItems.setBackgroundColor(
                Color.parseColor("#EBEBEB")
            )
        }else{
            holder.llHistoroyMainItems.setBackgroundColor(
                Color.parseColor("#FFFFFF")
            )
        }


    }

    override fun getItemCount(): Int {
        return items.size
    }
}