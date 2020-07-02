package com.jincal.valorantstory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_agent_full_image.*

class AgentFullImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agent_full_image)

        AgentFullImageView.setImageResource(intent.getIntExtra("imageId", R.drawable.breach))

        AgentFullImageView.setOnClickListener {
            finish()
        }
    }
}