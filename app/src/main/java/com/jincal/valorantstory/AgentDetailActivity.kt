package com.jincal.valorantstory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.jincal.valorantstory.`object`.ScreenSizeHolder
import com.jincal.valorantstory.agent.Agent
import com.jincal.valorantstory.agent.agentcard.RecyclerViewDecoration
import com.jincal.valorantstory.agent.agentskill.AgentSkillRecyclerViewAdapter
import com.jincal.valorantstory.databinding.ActivityAgentDetailBinding
import kotlinx.android.synthetic.main.activity_agent_detail.*

class AgentDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityAgentDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_agent_detail)
        val agent = Agent(intent.getStringExtra("identifier")!!)
        binding.agent = agent

        AgentInfoStandingImageView.layoutParams.width = ScreenSizeHolder.screenWidth / 2
        AgentInfoStandingImageView.layoutParams.height = ScreenSizeHolder.screenHeight * 2 / 5

        AgentInfoRoleImageView.layoutParams.height = ScreenSizeHolder.screenHeight / 10
        AgentInfoRoleImageView.layoutParams.width = ScreenSizeHolder.screenWidth / 10

        AgentInfoNameTextView.layoutParams.height = ScreenSizeHolder.screenHeight / 16
        AgentInfoRoleTextView.layoutParams.height = ScreenSizeHolder.screenHeight / 26

        AgentInfoCommentTextView.layoutParams.height = ScreenSizeHolder.screenHeight / 24
        AgentInfoBiographyTextView.movementMethod = ScrollingMovementMethod()

        binding.AgentInfoSkillsRecyclerView.apply {
            adapter = AgentSkillRecyclerViewAdapter(agent.getAgentSkillArray())
            layoutManager = LinearLayoutManager(this@AgentDetailActivity)
            addItemDecoration(RecyclerViewDecoration(0, 3))
        }
    }
}
@BindingAdapter("app:srcCompat")
fun setImageResource(imageView: ImageView, resource: Int) {
    imageView.setImageResource(resource)
}
