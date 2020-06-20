package com.jincal.valorantstory

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.jincal.valorantstory.`object`.FragmentManager
import com.jincal.valorantstory.`object`.ScreenSizeHolder
import com.jincal.valorantstory.`object`.ViewManager
import com.jincal.valorantstory.fragment.AgentContentsFragment
import com.jincal.valorantstory.fragment.MapContentsFragment
import com.jincal.valorantstory.fragment.WeaponContentsFragment
import com.jincal.valorantstory.recyclerview.Agent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ScreenSizeHolder.getPixelInfo(this)
        ViewManager.setHeightOf(MainTabSelectLayout, ScreenSizeHolder.screenHeight/8)

        MainTabAgents.setOnClickListener {
            ViewManager.changeTheTabColorAndSize(it as TextView, this, MainTabWeapons, MainTabMaps)
            FragmentManager.replaceFragmentInContainer(R.id.MainContentsFragmentContainer, AgentContentsFragment(), this)
        }
        MainTabWeapons.setOnClickListener {
            ViewManager.changeTheTabColorAndSize(it as TextView, this, MainTabAgents, MainTabMaps)
            FragmentManager.replaceFragmentInContainer(R.id.MainContentsFragmentContainer, WeaponContentsFragment(), this)
        }
        MainTabMaps.setOnClickListener {
            ViewManager.changeTheTabColorAndSize(it as TextView, this, MainTabWeapons, MainTabAgents)
            FragmentManager.replaceFragmentInContainer(R.id.MainContentsFragmentContainer, MapContentsFragment(), this)
        }
    }
}
