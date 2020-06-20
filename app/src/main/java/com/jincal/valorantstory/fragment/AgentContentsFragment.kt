package com.jincal.valorantstory.fragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.jincal.valorantstory.R
import com.jincal.valorantstory.recyclerview.Agent
import com.jincal.valorantstory.recyclerview.AgentContentsRecyclerViewAdapter
import com.jincal.valorantstory.recyclerview.RecyclerViewDecoration
import kotlinx.android.synthetic.main.fragment_contents_agent.*
import kotlinx.android.synthetic.main.fragment_contents_agent.view.*

class AgentContentsFragment(): Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val agents = arrayOf(
            Agent("Breach"),
            Agent("Brimstone"),
            Agent("Cypher"),
            Agent("Jett"),
            Agent("Omen"),
            Agent("Phoenix"),
            Agent("Raze"),
            Agent("Reyna"),
            Agent("Sage"),
            Agent("Sova"),
            Agent("Viper")
        )
        val view = inflater.inflate(R.layout.fragment_contents_agent, container, false)
        view.AgentContentsRecyclerView.layoutManager = GridLayoutManager(activity, 2)
        view.AgentContentsRecyclerView.adapter = AgentContentsRecyclerViewAdapter(agents, this)
        view.AgentContentsRecyclerView.addItemDecoration(RecyclerViewDecoration(3, 3))
        return view
    }
}