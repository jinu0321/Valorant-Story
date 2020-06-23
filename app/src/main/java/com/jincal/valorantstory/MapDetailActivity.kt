package com.jincal.valorantstory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jincal.valorantstory.`object`.StatusBarManager
import com.jincal.valorantstory.map.Map
import kotlinx.android.synthetic.main.activity_map_detail.*

class MapDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_detail)
        StatusBarManager.changeStausBarColor(this, R.color.backgroundMap)
        val map = Map(intent.getStringExtra("identifier")!!)
        MapDetailMapNameTextView.text = map.name
        MapDetailMapImageView.setImageResource(map.fullImageId)
    }
}