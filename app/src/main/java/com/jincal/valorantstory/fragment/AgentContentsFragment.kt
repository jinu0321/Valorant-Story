package com.jincal.valorantstory.fragment

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

class AgentContentsFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val agents = arrayOf(
            Agent("Breach", this),
            Agent("Brimstone", this),
            Agent("Cypher", this),
            Agent("Jett", this),
            Agent("Omen", this),
            Agent("Phoenix", this),
            Agent("Raze", this),
            Agent("Reyna", this),
            Agent("Sage", this),
            Agent("Sova", this),
            Agent("Viper", this)
        )
        val view = inflater.inflate(R.layout.fragment_contents_agent, container, false)
        view.AgentContentsRecyclerView.layoutManager = GridLayoutManager(activity, 2)
        view.AgentContentsRecyclerView.adapter = AgentContentsRecyclerViewAdapter(agents)
        view.AgentContentsRecyclerView.addItemDecoration(RecyclerViewDecoration(2, 2))
        return view
    }
}