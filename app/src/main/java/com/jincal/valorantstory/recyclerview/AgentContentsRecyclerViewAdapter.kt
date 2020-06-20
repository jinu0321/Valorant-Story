package com.jincal.valorantstory.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.jincal.valorantstory.AgentInfoActivity
import com.jincal.valorantstory.R
import com.jincal.valorantstory.`object`.ScreenSizeHolder
import kotlinx.android.synthetic.main.recyclerview_item_agent.view.*
import org.jetbrains.anko.support.v4.startActivity

class AgentContentsRecyclerViewAdapter(private val agents: Array<Agent>, val fragment: Fragment): RecyclerView.Adapter<AgentContentsRecyclerViewAdapter.AgentViewHolder>() {
    inner class AgentViewHolder(val view: View): RecyclerView.ViewHolder(view), View.OnClickListener {
        init {
            view.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            fragment.startActivity<AgentInfoActivity>("name" to agents[adapterPosition].name)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AgentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item_agent, parent, false)
        view.layoutParams.height = ScreenSizeHolder.screenHeight / 8
        return AgentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return agents.size
    }

    override fun onBindViewHolder(holder: AgentViewHolder, position: Int) {
        holder.view.AgentItemImageView.layoutParams.height = ScreenSizeHolder.screenHeight / 9
        holder.view.AgentItemImageView.layoutParams.width = ScreenSizeHolder.screenHeight / 9
        holder.view.AgentItemImageView.setImageResource(agents[position].iconImageAddress)
        holder.view.AgentItemNameTextView.text = agents[position].name
        holder.view.AgentItemRoleImageView.setImageResource(agents[position].roleImageAddress)
        holder.view.AgentItemRoleImageView.layoutParams.height = ScreenSizeHolder.screenHeight / 22
        holder.view.AgentItemRoleImageView.layoutParams.width = ScreenSizeHolder.screenHeight / 22
    }
}