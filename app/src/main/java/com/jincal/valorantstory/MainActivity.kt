package com.jincal.valorantstory

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.jincal.valorantstory.`object`.FragmentManager
import com.jincal.valorantstory.`object`.ScreenSizeHolder
import com.jincal.valorantstory.`object`.StatusBarManager
import com.jincal.valorantstory.`object`.ViewManager
import com.jincal.valorantstory.fragment.AgentContentsFragment
import com.jincal.valorantstory.fragment.MapContentsFragment
import com.jincal.valorantstory.fragment.ArsenalContentsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ScreenSizeHolder.getPixelInfo(this)
        ViewManager.setHeightOf(MainTabSelectLayout, ScreenSizeHolder.screenHeight/8)

        MainTabAgent.setOnClickListener {
            ViewManager.highlightSelectedTab(it as TextView, MainTabArsenal, MainTabMap, "#00897B")
            MainBackgroundConstraintLayout.background = getDrawable(R.drawable.background_main_agent)
            StatusBarManager.changeStausBarColor(this, R.color.backgroundAgent)
            FragmentManager.replaceFragmentInContainer(R.id.MainContentsFragmentContainer, AgentContentsFragment(), this)
            MainContentsFragmentContainer.setBackgroundResource(R.drawable.background_main_agent)
        }
        MainTabArsenal.setOnClickListener {
            ViewManager.highlightSelectedTab(it as TextView, MainTabAgent, MainTabMap, "#7C46EA")
            MainBackgroundConstraintLayout.background = getDrawable(R.drawable.background_main_arsenal)
            StatusBarManager.changeStausBarColor(this, R.color.backgroundArsenal)
            FragmentManager.replaceFragmentInContainer(R.id.MainContentsFragmentContainer, ArsenalContentsFragment(), this)
            MainContentsFragmentContainer.setBackgroundResource(R.drawable.background_main_arsenal)
        }
        MainTabMap.setOnClickListener {
            ViewManager.highlightSelectedTab(it as TextView, MainTabArsenal, MainTabAgent, "#F19E36")
            MainBackgroundConstraintLayout.background = getDrawable(R.drawable.background_main_map)
            StatusBarManager.changeStausBarColor(this, R.color.backgroundMap)
            FragmentManager.replaceFragmentInContainer(R.id.MainContentsFragmentContainer, MapContentsFragment(), this)
            MainContentsFragmentContainer.setBackgroundResource(R.drawable.background_main_map)
        }
        // select agent tab initially
        ViewManager.highlightSelectedTab(MainTabAgent as TextView, MainTabArsenal, MainTabMap, "#00897B")
        FragmentManager.replaceFragmentInContainer(R.id.MainContentsFragmentContainer, AgentContentsFragment(), this)
        MainContentsFragmentContainer.setBackgroundResource(R.drawable.background_main_agent)
    }
}
