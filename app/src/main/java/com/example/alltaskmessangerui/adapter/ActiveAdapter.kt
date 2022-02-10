package com.example.alltaskmessangerui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alltaskmessangerui.R
import com.example.alltaskmessangerui.model.Room
import com.google.android.material.imageview.ShapeableImageView

class ActiveAdapter(var context: Context, var actives: ArrayList<Room>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_active_view, parent, false)
        return ActiveViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ActiveViewHolder) {
            val active = actives[position]
            holder.apply {
                image.setImageResource(active.profile)
                fullName.text = active.fullName
            }
        }
    }

    override fun getItemCount(): Int {
        return actives.size
    }

    class ActiveViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ShapeableImageView>(R.id.iv_active_image)
        val fullName = view.findViewById<TextView>(R.id.tv_active_fullName)
    }

}