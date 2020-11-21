package com.ak.workoutapp

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_exersice_status.view.*
import java.util.zip.Inflater


class ExersiceStatusAdaptor(val items:ArrayList<ExerciseModel>,val context:Context)
    : RecyclerView.Adapter<ExersiceStatusAdaptor.ViewHolder>() {


    class  ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val tvItem = view.tvItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      return  ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_exersice_status,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model: ExerciseModel = items[position]
        holder.tvItem.text = model.getId().toString()
        if(model.getIsSelected()){
            holder.tvItem.background = ContextCompat.getDrawable(context,R.drawable.item_cicular_thine)
         holder.tvItem.setTextColor(Color.parseColor("#212121"))
        }else if(model.getIsCompleted()){
            holder.tvItem.background = ContextCompat.getDrawable(context,R.drawable.item_circular_accent_bg)
            holder.tvItem.setTextColor(Color.parseColor("#FFFFFF"))
        }else{
            holder.tvItem.background = ContextCompat.getDrawable(context,R.drawable.item_circular_gray_bg)
            holder.tvItem.setTextColor(Color.parseColor("#212121"))
        }

    }

    override fun getItemCount(): Int {
       return items.size
    }

}