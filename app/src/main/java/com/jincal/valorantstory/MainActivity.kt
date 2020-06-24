package com.jincal.valorantstory

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import com.jincal.valorantstory.`object`.*
import com.jincal.valorantstory.fragment.AgentContentsFragment
import com.jincal.valorantstory.fragment.MapContentsFragment
import com.jincal.valorantstory.fragment.ArsenalContentsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var adView: AdView? = null
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adView = MainAdView
        AdManager.setAd(adView!!)
        firebaseAnalytics = Firebase.analytics
        ScreenSizeHolder.getPixelInfo(this)
        ViewManager.setHeightOf(MainTabSelectLayout, ScreenSizeHolder.screenHeight/8)

        MainTabAgent.setOnClickListener {
            ViewManager.highlightSelectedTab(it as TextView, MainTabArsenal, MainTabMap, "#00897B")
            MainBackgroundConstraintLayout.background = getDrawable(R.drawable.background_main_agent)
            FragmentManager.replaceFragmentInContainer(R.id.MainContentsFragmentContainer, AgentContentsFragment(), this)
            MainContentsFragmentContainer.setBackgroundResource(R.drawable.background_main_agent)
        }
        MainTabArsenal.setOnClickListener {
            ViewManager.highlightSelectedTab(it as TextView, MainTabAgent, MainTabMap, "#7C46EA")
            MainBackgroundConstraintLayout.background = getDrawable(R.drawable.background_main_arsenal)
            FragmentManager.replaceFragmentInContainer(R.id.MainContentsFragmentContainer, ArsenalContentsFragment(), this)
            MainContentsFragmentContainer.setBackgroundResource(R.drawable.background_main_arsenal)
        }
        MainTabMap.setOnClickListener {
            ViewManager.highlightSelectedTab(it as TextView, MainTabArsenal, MainTabAgent, "#F19E36")
            MainBackgroundConstraintLayout.background = getDrawable(R.drawable.background_main_map)
            FragmentManager.replaceFragmentInContainer(R.id.MainContentsFragmentContainer, MapContentsFragment(), this)
            MainContentsFragmentContainer.setBackgroundResource(R.drawable.background_main_map)
        }
        // select agent tab initially
        ViewManager.highlightSelectedTab(MainTabAgent as TextView, MainTabArsenal, MainTabMap, "#00897B")
        FragmentManager.replaceFragmentInContainer(R.id.MainContentsFragmentContainer, AgentContentsFragment(), this)
        MainContentsFragmentContainer.setBackgroundResource(R.drawable.background_main_agent)
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
