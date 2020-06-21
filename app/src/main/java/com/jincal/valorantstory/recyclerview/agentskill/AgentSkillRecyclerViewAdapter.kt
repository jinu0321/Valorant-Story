package com.jincal.valorantstory.recyclerview.agentskill

import android.os.Build
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jincal.valorantstory.R
import com.jincal.valorantstory.ResourceAccessor
import com.jincal.valorantstory.`object`.ScreenSizeHolder
import com.jincal.valorantstory.recyclerview.Agent
import kotlinx.android.synthetic.main.recyclerview_item_agent_skill.view.*

class AgentSkillRecyclerViewAdapter(private val agentSkillArray: Array<Agent.AgentSkill>): RecyclerView.Adapter<AgentSkillRecyclerViewAdapter.AgentSkillViewHolder>() {
    inner class AgentSkillViewHolder(val view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgentSkillViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_agent_skill, parent, false)
        return AgentSkillViewHolder(view)
    }

    override fun getItemCount(): Int = agentSkillArray.size

    override fun onBindViewHolder(holder: AgentSkillViewHolder, position: Int) {
        val agentSkill = agentSkillArray[position]
        holder.view.apply {
            ItemAgentSkillName.text = agentSkill.skillName
            ItemAgentSkillCostTextView.text = agentSkill.skillCost
            ItemAgentSkillChargeTextView.text = agentSkill.skillCharge
            ItemAgentSkillDescriptionTextView.text = agentSkill.skillDescription
            ItemAgentSkillCommandTextView.text = agentSkill.skillCommand
            ItemAgentSkillImage.setImageResource(agentSkill.skillImage)
            if (agentSkillArray[position].skillCost.contains('초') || agentSkillArray[position].skillCost.contains("sec")
                || agentSkillArray[position].skillCost.contains("처치")|| agentSkillArray[position].skillCost.contains("kill")) {
                ItemAgentSkillCredTextView.text = ""
            }
            if (agentSkill == agentSkillArray[3]) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    ItemAgentSkillName.typeface = resources.getFont(R.font.font_jsarirangfont)
                }
                ItemAgentSkillCredTextView.text = ResourceAccessor.res!!.getString(R.string.point)
            }
        }
    }
}