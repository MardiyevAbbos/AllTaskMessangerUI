package com.example.alltaskmessangerui.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alltaskmessangerui.R
import com.example.alltaskmessangerui.adapter.ActiveAdapter
import com.example.alltaskmessangerui.adapter.StoriesAdapter
import com.example.alltaskmessangerui.model.Message
import com.example.alltaskmessangerui.model.Room

class PeopleFragment : Fragment() {

    private val KEY = "the_key"
    private lateinit var items: ArrayList<Message>
    private lateinit var recyclerView: RecyclerView
    private lateinit var tvStories: TextView
    private lateinit var tvActive: TextView
    private var helper: Boolean = false

    fun newInstance(stories: ArrayList<Message>): Fragment {
        var fragment = PeopleFragment()
        val bundle = Bundle()
        bundle.putSerializable(KEY, stories)

        fragment.arguments = bundle
        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_people, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recyclerView_people)
        items = arguments?.getSerializable(KEY) as ArrayList<Message>
        tvStories = view.findViewById(R.id.tv_stories_count)
        tvStories.text = "Stories (${items.size - 1})"
        tvActive = view.findViewById(R.id.tv_active_count)
        tvActive.text = "Active (${prepareActiveList().size})"

        openStoriesList()

        tvStories.setOnClickListener {
            if (helper) {
                openStoriesList()
            }
        }

        tvActive.setOnClickListener {
            if (!helper) {
                openActiveList()
            }
        }
    }


    private fun openStoriesList() {
        tvStories.setTextColor(Color.WHITE)
        tvStories.setBackgroundResource(R.drawable.shape_rounded_button)
        tvActive.setTextColor(Color.GRAY)
        tvActive.setBackgroundResource(0)

        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        val adapter = StoriesAdapter(requireContext(), items)
        recyclerView.adapter = adapter
        helper = false
    }

    private fun openActiveList() {
        tvStories.setTextColor(Color.GRAY)
        tvStories.setBackgroundResource(0)
        tvActive.setTextColor(Color.WHITE)
        tvActive.setBackgroundResource(R.drawable.shape_rounded_button)

        recyclerView.layoutManager = GridLayoutManager(requireContext(), 1)
        val adapter = ActiveAdapter(requireContext(), prepareActiveList())
        recyclerView.adapter = adapter
        helper = true
    }

    private fun prepareActiveList(): ArrayList<Room> {
        val actives: ArrayList<Room> = ArrayList()
        for (active in items) {
            if (active.isOnline) {
                actives.add(Room(active.profile, active.fullName))
            }
        }
        return actives
    }

}