package com.jincal.valorantstory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.ads.AdView
import com.jincal.valorantstory.`object`.AdManager
import com.jincal.valorantstory.`object`.StatusBarManager
import com.jincal.valorantstory.map.Map
import kotlinx.android.synthetic.main.activity_arsenal_detail.*
import kotlinx.android.synthetic.main.activity_map_detail.*

class MapDetailActivity : AppCompatActivity() {

    private var adView: AdView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_detail)
        adView = MapDetailAdView
        AdManager.setAd(adView!!)
        StatusBarManager.changeStausBarColor(this, R.color.backgroundMap)

        val map = Map(intent.getStringExtra("identifier")!!)
        MapDetailMapNameTextView.text = map.name
        MapDetailMapImageView.setImageResource(map.fullImageId)
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