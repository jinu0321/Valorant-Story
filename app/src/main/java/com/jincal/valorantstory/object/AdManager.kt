package com.jincal.valorantstory.`object`

import android.content.Context
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.jincal.valorantstory.R

object AdManager {
    fun setAd(adView: AdView) {
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
    }
    fun onPause(adView: AdView) {
        adView.pause()
    }

    fun onResume(adView: AdView) {
        adView.resume()
    }

    fun onDestroy(adView: AdView) {
        adView.destroy()
    }
}