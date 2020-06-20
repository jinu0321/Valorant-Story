package com.jincal.valorantstory.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jincal.valorantstory.R
import com.jincal.valorantstory.`object`.ScreenSizeHolder
import kotlinx.android.synthetic.main.recyclerview_item_agent.view.*

class AgentContentsRecyclerViewAdapter(private val agents: Array<Agent>): RecyclerView.Adapter<AgentContentsRecyclerViewAdapter.AgentViewHolder>() {
    class AgentViewHolder(val view: View): RecyclerView.ViewHolder(view)

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