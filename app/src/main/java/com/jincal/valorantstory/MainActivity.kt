package com.jincal.valorantstory

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.jincal.valorantstory.`object`.FragmentManager
import com.jincal.valorantstory.`object`.ScreenSizeHolder
import com.jincal.valorantstory.`object`.StatusBarManager
import com.jincal.valorantstory.`object`.ViewManager
import com.jincal.valorantstory.arsenal.Arsenal
import com.jincal.valorantstory.fragment.AgentContentsFragment
import com.jincal.valorantstory.fragment.MapContentsFragment
import com.jincal.valorantstory.fragment.WeaponContentsFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ScreenSizeHolder.getPixelInfo(this)
        ViewManager.setHeightOf(MainTabSelectLayout, ScreenSizeHolder.screenHeight/8)

        MainTabAgents.setOnClickListener {
            ViewManager.highlightSelectedTab(it as TextView, MainTabWeapons, MainTabMaps)
            MainBackgroundConstraintLayout.background = getDrawable(R.drawable.background_main_agent)
            StatusBarManager.changeStausBarColor(this, R.color.backgroundAgent)
            FragmentManager.replaceFragmentInContainer(R.id.MainContentsFragmentContainer, AgentContentsFragment(), this)
        }
        MainTabWeapons.setOnClickListener {
            ViewManager.highlightSelectedTab(it as TextView, MainTabAgents, MainTabMaps)
            MainBackgroundConstraintLayout.background = getDrawable(R.drawable.background_main_arsenal)
            StatusBarManager.changeStausBarColor(this, R.color.backgroundArsenal)
            FragmentManager.replaceFragmentInContainer(R.id.MainContentsFragmentContainer, WeaponContentsFragment(), this)
        }
        MainTabMaps.setOnClickListener {
            ViewManager.highlightSelectedTab(it as TextView, MainTabWeapons, MainTabAgents)
            MainBackgroundConstraintLayout.background = getDrawable(R.drawable.background_main_map)
            StatusBarManager.changeStausBarColor(this, R.color.backgroundMap)
            FragmentManager.replaceFragmentInContainer(R.id.MainContentsFragmentContainer, MapContentsFragment(), this)
        }
        // select agent tab initially
        ViewManager.highlightSelectedTab(MainTabAgents as TextView, MainTabWeapons, MainTabMaps)
        FragmentManager.replaceFragmentInContainer(R.id.MainContentsFragmentContainer, AgentContentsFragment(), this)
    }
}
