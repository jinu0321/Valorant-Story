package com.jincal.valorantstory.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.jincal.valorantstory.R
import com.jincal.valorantstory.agent.Agent
import com.jincal.valorantstory.agent.agentcard.AgentCardRecyclerViewAdapter
import com.jincal.valorantstory.agent.agentcard.RecyclerViewDecoration
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
            Agent("Viper"),
            Agent("questionmark")
        )
        val view = inflater.inflate(R.layout.fragment_contents_agent, container, false)
        view.AgentContentsFragmentRecyclerView.layoutManager = GridLayoutManager(activity, 2)
        view.AgentContentsFragmentRecyclerView.adapter =
            AgentCardRecyclerViewAdapter(
                agents,
                this
            )
        view.AgentContentsFragmentRecyclerView.addItemDecoration(
            RecyclerViewDecoration(
                3,
                3
            )
        )
        return view
    }
}