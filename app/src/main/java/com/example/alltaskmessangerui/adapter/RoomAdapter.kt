package com.example.alltaskmessangerui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alltaskmessangerui.R
import com.example.alltaskmessangerui.model.Room
import com.google.android.material.imageview.ShapeableImageView

class RoomAdapter(var context: Context, var items: ArrayList<Room>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return 0;
        }
        return 1;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == 0) {
            val view =
                LayoutInflater.from(context).inflate(R.layout.item_create_room_view, parent, false)
            return CreateRoomViewHolder(view)
        }
        val view = LayoutInflater.from(context).inflate(R.layout.item_room_view, parent, false)
        return RoomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is RoomViewHolder) {
            val room = items[position]
            holder.apply {
                profile.setImageResource(room.profile)
                fullName.text = room.fullName
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class RoomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val profile = view.findViewById<ShapeableImageView>(R.id.iv_roomView_profile)
        val fullName = view.findViewById<TextView>(R.id.tv_roomView_fullName)
        val isOnline = view.findViewById<LinearLayout>(R.id.is_online)
    }

    class CreateRoomViewHolder(view: View) : RecyclerView.ViewHolder(view)

}