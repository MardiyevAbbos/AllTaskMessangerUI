package com.example.alltaskmessangerui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alltaskmessangerui.R
import com.example.alltaskmessangerui.adapter.MessageAdapter
import com.example.alltaskmessangerui.model.Message

class ChatsFragment : Fragment() {

    private val KEY = "the_key"

    fun newInstance(items: ArrayList<Message>): Fragment {
        val fragment = ChatsFragment()
        val bundle = Bundle()
        bundle.putSerializable(KEY, items)

        fragment.arguments = bundle
        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chats, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 1)

        val items: ArrayList<Message> = arguments?.getSerializable(KEY) as ArrayList<Message>
        val adapter = MessageAdapter(requireContext(), items)
        recyclerView.adapter = adapter
    }

}