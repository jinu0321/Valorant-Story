package com.jincal.valorantstory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.InterstitialAd
import com.jincal.valorantstory.`object`.AdManager
import com.jincal.valorantstory.`object`.ScreenSizeHolder
import com.jincal.valorantstory.`object`.StatusBarManager
import com.jincal.valorantstory.agent.Agent
import com.jincal.valorantstory.agent.agentskill.AgentSkillRecyclerViewAdapter
import com.jincal.valorantstory.databinding.ActivityAgentDetailBinding
import kotlinx.android.synthetic.main.activity_agent_detail.*
import org.jetbrains.anko.startActivity

class AgentDetailActivity : AppCompatActivity() {

    private var adView: AdView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarManager.changeStausBarColor(this, R.color.backgroundAgent)
        var binding: ActivityAgentDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_agent_detail)
        val agent = Agent(intent.getStringExtra("identifier")!!)
        binding.agent = agent
        adView = AgentDetailAdView
        val interstitialAd = InterstitialAd(this)
        AdManager.setAd(adView!!)

        AgentDetailStandingImageView.layoutParams.width = ScreenSizeHolder.screenWidth / 2
        AgentDetailStandingImageView.layoutParams.height = ScreenSizeHolder.screenHeight * 2 / 5

        AgentDetailRoleImageView.layoutParams.height = ScreenSizeHolder.screenHeight / 10
        AgentDetailRoleImageView.layoutParams.width = ScreenSizeHolder.screenWidth / 10

        AgentDetailNameTextView.layoutParams.height = ScreenSizeHolder.screenHeight / 16
        AgentDetailRoleTextView.layoutParams.height = ScreenSizeHolder.screenHeight / 26

        AgentDetailCommentTextView.layoutParams.height = ScreenSizeHolder.screenHeight / 24
        AgentDetailBiographyTextView.movementMethod = ScrollingMovementMethod()

        binding.AgentDetailSkillsRecyclerView.apply {
            adapter = AgentSkillRecyclerViewAdapter(agent.getAgentSkillArray())
            layoutManager = LinearLayoutManager(this@AgentDetailActivity)
            addItemDecoration(
                RecyclerViewDecoration(
                    0,
                    3
                )
            )
        }

        AgentDetailStandingImageView.setOnClickListener {
            startActivity<AgentFullImageActivity>("imageId" to agent.standingImageId)
        }
    }

    override fun onResume() {
        AdManager.onResume(adView!!)
        super.onResume()
    }

    override fun onPause() {
        AdManager.onPause(adView!!)
        super.onPause()
    }

    override fun onDestroy() {
        AdManager.onDestroy(adView!!)
        super.onDestroy()
    }

}
@BindingAdapter("app:srcCompat")
fun setImageResource(imageView: ImageView, resource: Int) {
    imageView.setImageResource(resource)
}
