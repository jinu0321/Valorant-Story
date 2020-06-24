package com.jincal.valorantstory.`object`

import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.InterstitialAd
import com.jincal.valorantstory.R
import com.jincal.valorantstory.ResourceAccessor

object AdManager {
    var viewCount = 2
    fun viewed5Pages(): Boolean {
        if (viewCount >= 5) {
            viewCount = 0
            return true
        } else {
            return false
        }
    }
    fun setAd(adView: AdView) {
        adView.loadAd(AdRequest.Builder().build())
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