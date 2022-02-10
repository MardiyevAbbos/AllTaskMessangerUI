package com.example.alltaskmessangerui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alltaskmessangerui.R
import com.example.alltaskmessangerui.model.Message
import com.example.alltaskmessangerui.model.Room
import com.google.android.material.imageview.ShapeableImageView

class MessageAdapter(var context: Context, var items: ArrayList<Message>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_ROOM_ITEM = 0
    private val VIEW_MESSAGE_ITEM = 1

    override fun getItemViewType(position: Int): Int {
        if (position == 0) return VIEW_ROOM_ITEM
        return VIEW_MESSAGE_ITEM
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == VIEW_ROOM_ITEM) {
            val view = LayoutInflater.from(context).inflate(R.layout.item_chat_room, parent, false)
            return RoomViewHolder(view)
        }
        val view = LayoutInflater.from(context).inflate(R.layout.item_chat_message, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is RoomViewHolder) {
            val recyclerView = holder.recyclerView
            recyclerView.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

            val adapter = RoomAdapter(context, prepareOnlineUserList())
            recyclerView.adapter = adapter
        }

        if (holder is MessageViewHolder) {
            val messages = items[position]
            holder.apply {
                profile.setImageResource(messages.profile)
                fullName.text = messages.fullName
                message.text = messages.message
                if (messages.isOnline) {
                    isOnline.visibility = View.VISIBLE
                } else {
                    isOnline.visibility = View.GONE
                }
            }
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }


    inner class RoomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView_chatRoom)
    }

    inner class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val profile = view.findViewById<ShapeableImageView>(R.id.iv_chatMessage_profile)
        val isOnline = view.findViewById<LinearLayout>(R.id.is_online)
        val fullName = view.findViewById<TextView>(R.id.tv_chatMessage_fullName)
        val message = view.findViewById<TextView>(R.id.tv_chatMessage_message)
    }

    private fun prepareOnlineUserList(): ArrayList<Room> {
        val rooms: ArrayList<Room> = ArrayList()
        rooms.add(Room(R.drawable.ic_baseline_video_call_24, "Create room"))
        for (messageItem in items) {
            if (messageItem.isOnline) {
                rooms.add(Room(messageItem.profile, messageItem.fullName))
            }
        }
        return rooms
    }

}