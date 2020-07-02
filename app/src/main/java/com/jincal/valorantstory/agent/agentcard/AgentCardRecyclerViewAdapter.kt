package com.jincal.valorantstory.agent.agentcard

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.InterstitialAd
import com.jincal.valorantstory.AgentDetailActivity
import com.jincal.valorantstory.R
import com.jincal.valorantstory.`object`.AdManager
import com.jincal.valorantstory.`object`.ScreenSizeHolder
import com.jincal.valorantstory.agent.Agent
import kotlinx.android.synthetic.main.recyclerview_item_agent_card.view.*
import org.jetbrains.anko.support.v4.startActivity
import kotlin.math.ceil

class AgentCardRecyclerViewAdapter(private val agents: Array<Agent>, val fragment: Fragment, val interstitialAd: InterstitialAd) :
    RecyclerView.Adapter<AgentCardRecyclerViewAdapter.AgentViewHolder>() {
    inner class AgentViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.setOnClickListener {
                if (AdManager.viewed5Pages() && interstitialAd.isLoaded) {
                    interstitialAd.show()
                } else {
                    Log.d("interstitial", "The interstitial ad wasn't loaded yet.")
                    AdManager.viewCount ++
                    if (agents[adapterPosition].identifier != "questionmark") fragment.startActivity<AgentDetailActivity>("identifier" to agents[adapterPosition].identifier)
                }
                runAdEvents()
            }
        }
        private fun runAdEvents() {
            interstitialAd.adListener = object : AdListener() {
                // If user closes the ad, s/he is directed to DetailActivity.
                override fun onAdClosed() {
                    AdManager.viewCount ++
                    if (agents[adapterPosition].identifier != "questionmark") fragment.startActivity<AgentDetailActivity>("identifier" to agents[adapterPosition].identifier)
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AgentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item_agent_card, parent, false)
        view.layoutParams.height = ScreenSizeHolder.screenHeight / 8
        return AgentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return agents.size
    }

    override fun onBindViewHolder(holder: AgentViewHolder, position: Int) {
        holder.view.AgentItemImageView.setImageResource(agents[position].iconImageId)
        holder.view.AgentItemImageView.layoutParams.height = (ScreenSizeHolder.screenHeight / 8) - ceil(ScreenSizeHolder.pxToDp(fragment, 6.0f)).toInt()
        holder.view.AgentItemImageView.layoutParams.width = (ScreenSizeHolder.screenHeight / 8) - ceil(ScreenSizeHolder.pxToDp(fragment, 6.0f)).toInt()
        holder.view.AgentItemEdgeImageView1.layoutParams.height = ScreenSizeHolder.screenHeight / 80
        holder.view.AgentItemEdgeImageView1.layoutParams.width = ScreenSizeHolder.screenHeight / 80
        holder.view.AgentItemEdgeImageView2.layoutParams.height = ScreenSizeHolder.screenHeight / 80
        holder.view.AgentItemEdgeImageView2.layoutParams.width = ScreenSizeHolder.screenHeight / 80
        holder.view.AgentItemEdgeImageView3.layoutParams.height = ScreenSizeHolder.screenHeight / 80
        holder.view.AgentItemEdgeImageView3.layoutParams.width = ScreenSizeHolder.screenHeight / 80
        holder.view.AgentItemEdgeImageView4.layoutParams.height = ScreenSizeHolder.screenHeight / 80
        holder.view.AgentItemEdgeImageView4.layoutParams.width = ScreenSizeHolder.screenHeight / 80
        if (agents[position].identifier == "questionmark") {
            holder.view.AgentItemComingSoonTextView.visibility = View.VISIBLE
            holder.view.AgentItemNameTextView.visibility = View.GONE
            holder.view.AgentItemRoleImageView.visibility = View.GONE
        } else {
            holder.view.AgentItemNameTextView.text = agents[position].name
            holder.view.AgentItemRoleImageView.setImageResource(agents[position].roleImageId)
            holder.view.AgentItemRoleImageView.layoutParams.height = ScreenSizeHolder.screenHeight / 20
            holder.view.AgentItemRoleImageView.layoutParams.width = ScreenSizeHolder.screenHeight / 20
        }
    }
}