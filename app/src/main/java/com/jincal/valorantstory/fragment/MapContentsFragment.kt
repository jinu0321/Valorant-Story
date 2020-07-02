package com.jincal.valorantstory.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.jincal.valorantstory.R
import com.jincal.valorantstory.ResourceAccessor
import com.jincal.valorantstory.map.Map
import com.jincal.valorantstory.map.mapcard.MapCardRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_contents_map.view.*

class MapContentsFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_contents_map, container, false)
        val interstitialAd = InterstitialAd(activity)
        interstitialAd.adUnitId = ResourceAccessor.res!!.getString(R.string.id_ad_interstitial)
        interstitialAd.loadAd(AdRequest.Builder().build())
        val maps = arrayOf(
            Map("ascent"),
            Map("bind"),
            Map("heaven"),
            Map("split"))
        with(view.MapContentsFragmentRecyclerView) {
            adapter = MapCardRecyclerViewAdapter(maps, this@MapContentsFragment, interstitialAd)
            layoutManager = LinearLayoutManager(activity)
        }
        return view
    }
}