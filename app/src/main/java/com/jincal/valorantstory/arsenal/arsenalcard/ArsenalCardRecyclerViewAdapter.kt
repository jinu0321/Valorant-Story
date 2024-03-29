package com.jincal.valorantstory.arsenal.arsenalcard

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.InterstitialAd
import com.jincal.valorantstory.AgentDetailActivity
import com.jincal.valorantstory.ArsenalDetailActivity
import com.jincal.valorantstory.R
import com.jincal.valorantstory.`object`.AdManager
import com.jincal.valorantstory.`object`.ScreenSizeHolder
import com.jincal.valorantstory.arsenal.Arsenal
import kotlinx.android.synthetic.main.recyclerview_item_agent_card.view.*
import kotlinx.android.synthetic.main.recyclerview_item_arsenal_card.view.*
import org.jetbrains.anko.support.v4.startActivity

class ArsenalCardRecyclerViewAdapter(val arsenals: Array<Arsenal>, val fragment: Fragment, val interstitialAd: InterstitialAd):
    RecyclerView.Adapter<ArsenalCardRecyclerViewAdapter.ArsenalViewHolder>() {
    inner class ArsenalViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        init {
            view.setOnClickListener {
                if (AdManager.viewed5Pages() && interstitialAd.isLoaded) {
                    interstitialAd.show()
                } else {
                    Log.d("interstitial", "The interstitial ad wasn't loaded yet.")
                    AdManager.viewCount ++
                    fragment.startActivity<ArsenalDetailActivity>("identifier" to arsenals[adapterPosition].identifier)
                }
                runAdEvents()
            }
        }
        private fun runAdEvents() {
            interstitialAd.adListener = object : AdListener() {
                // If user closes the ad, s/he is directed to DetailActivity.
                override fun onAdClosed() {
                    AdManager.viewCount ++
                    fragment.startActivity<ArsenalDetailActivity>("identifier" to arsenals[adapterPosition].identifier)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArsenalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_arsenal_card, parent, false)
        view.layoutParams.height = ScreenSizeHolder.screenHeight / 8
        view.ItemArsenalCardImageView.layoutParams.height = ScreenSizeHolder.screenHeight / 8
        return ArsenalViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arsenals.size
    }

    override fun onBindViewHolder(holder: ArsenalViewHolder, position: Int) {
        with(holder.view) {
            val arsenal = arsenals[position]
            ItemArsenalCardImageView.setImageResource(arsenal.imageId)
            ItemArsenalCardNameTextView.text = arsenal.name
            ItemArsenalCardTypeTextView.text = arsenal.type
            ArsenalItemEdgeImageView1.layoutParams.height = ScreenSizeHolder.screenHeight / 80
            ArsenalItemEdgeImageView1.layoutParams.width = ScreenSizeHolder.screenHeight / 80
            ArsenalItemEdgeImageView2.layoutParams.height = ScreenSizeHolder.screenHeight / 80
            ArsenalItemEdgeImageView2.layoutParams.width = ScreenSizeHolder.screenHeight / 80
            ArsenalItemEdgeImageView3.layoutParams.height = ScreenSizeHolder.screenHeight / 80
            ArsenalItemEdgeImageView3.layoutParams.width = ScreenSizeHolder.screenHeight / 80
            ArsenalItemEdgeImageView4.layoutParams.height = ScreenSizeHolder.screenHeight / 80
            ArsenalItemEdgeImageView4.layoutParams.width = ScreenSizeHolder.screenHeight / 80
        }

    }
}