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
import com.example.alltaskmessangerui.model.Message
import com.google.android.material.imageview.ShapeableImageView

class StoriesAdapter(var context: Context, var stories: ArrayList<Message>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_stories_view, parent, false)
        return StoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is StoriesViewHolder) {
            val story = stories[position]
            holder.apply {
                if (position == 0) {
                    image.setImageResource(R.drawable.my_photo)
                    icon.setImageResource(R.drawable.ic_baseline_add_24)
                    icon.scaleType = ImageView.ScaleType.CENTER
                    fullName.text = "Add to story"
                    circle.setBackgroundColor(0)
                    storyCount.visibility = View.GONE
                } else {
                    image.setImageResource(story.profile)
                    icon.setImageResource(story.profile)
                    fullName.text = story.fullName
                    if (story.isOnline) {
                        circle.setBackgroundResource(R.drawable.shape_stories_circle_online)
                    } else {
                        circle.setBackgroundResource(R.drawable.shape_stories_circle_offline)
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return stories.size
    }

    inner class StoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ShapeableImageView = view.findViewById(R.id.iv_stories_image)
        val circle: LinearLayout = view.findViewById(R.id.stories_icon_blue_circle)
        val icon: ShapeableImageView = view.findViewById(R.id.iv_stories_icon)
        val fullName: TextView = view.findViewById(R.id.tv_stories_fullName)
        val storyCount: TextView = view.findViewById(R.id.tv_storiesCount)
    }

}