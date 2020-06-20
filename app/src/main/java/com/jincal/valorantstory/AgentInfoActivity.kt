package com.jincal.valorantstory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.jincal.valorantstory.databinding.ActivityAgentInfoBinding
import com.jincal.valorantstory.recyclerview.Agent

class AgentInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityAgentInfoBinding = DataBindingUtil.setContentView(this, R.layout.activity_agent_info)
        Log.d("mememe", intent.getStringExtra("name"))
        binding.agent = Agent(intent.getStringExtra("name"))
    }

}
