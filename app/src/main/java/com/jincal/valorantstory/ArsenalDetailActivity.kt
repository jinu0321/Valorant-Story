package com.jincal.valorantstory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jincal.valorantstory.arsenal.Arsenal
import kotlinx.android.synthetic.main.activity_arsenal_detail.*
import org.jetbrains.anko.toast

class ArsenalDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_arsenal_detail)

        // set layout!
        val arsenal = Arsenal(intent.getStringExtra("identifier")!!, this)
        ArsenalDetailImageView.setImageResource(arsenal.imageId)
        ArsenalDetailNameTextView.text = arsenal.name
        ArsenalDetailTypeTextView.text = arsenal.type
        ArsenalDetailAmmoTextView.text = if (arsenal.identifier != "tacticalknife") arsenal.magazine else "∞"
        ArsenalDetailCostTextView.text = arsenal.cost
        ArsenalDetailWallPenetrationTextView.text = arsenal.wallPenetration
    }
}