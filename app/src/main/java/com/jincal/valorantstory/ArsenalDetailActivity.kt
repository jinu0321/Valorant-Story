package com.jincal.valorantstory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.jincal.valorantstory.`object`.StatusBarManager
import com.jincal.valorantstory.arsenal.Arsenal
import kotlinx.android.synthetic.main.activity_arsenal_detail.*
import org.jetbrains.anko.toast

class ArsenalDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_arsenal_detail)
        StatusBarManager.changeStausBarColor(this, R.color.backgroundArsenal)

        // set upper constraint layout
        val arsenal = Arsenal(intent.getStringExtra("identifier")!!, this)
        ArsenalDetailImageView.setImageResource(arsenal.imageId)
        ArsenalDetailNameTextView.text = arsenal.name
        ArsenalDetailTypeTextView.text = arsenal.type
        ArsenalDetailAmmoTextView.text =
            if (arsenal.identifier != "tacticalknife") arsenal.magazine else "∞"
        ArsenalDetailCostTextView.text = arsenal.cost
        ArsenalDetailWallPenetrationTextView.text = arsenal.wallPenetration

        // set middle constraint layout
        ArsenalDetailPrimaryAttackTextView.text = getString(R.string.primary_attack)
        ArsenalDetailPrimaryModeTextView.text = arsenal.primaryMode
        ArsenalDetailPrimaryFirerateTextView.text = arsenal.primaryFireRate + getString(R.string.unit_fire_rate)
        if (arsenal.alternateDescription == "") ArsenalDetailAlternateLayout.visibility =
            View.GONE else {
            ArsenalDetailAlternateLayout.visibility = View.VISIBLE
            ArsenalDetailAlternateAttackTextView.text = getString(R.string.alternate_attack)
            ArsenalDetailAlternateDescriptionTextView.text = arsenal.alternateDescription
            ArsenalDetailAlternateFirerateTextView.text =
                arsenal.alternateFireRate + getString(R.string.unit_fire_rate)
        }
        if (arsenal.identifier == "tacticalknife") {
            ArsenalDetailPrimaryAttackTextView.text = getString(R.string.primary_attack_knife) + " (${getString(R.string.arsenal_tacticalknife_primary_firerate)}${getString(R.string.unit_fire_rate_knife)})"
            ArsenalDetailPrimaryModeTextView.text = getString(R.string.arsenal_tacticalknife_frontal_attack) + ": " + getString(R.string.arsenal_tacticalknife_primary_damage_forward)
            ArsenalDetailPrimaryFirerateTextView.text = getString(R.string.arsenal_tacticalknife_rear_attack) + ": " + getString(R.string.arsenal_tacticalknife_primary_damage_backward)
            ArsenalDetailAlternateLayout.visibility = View.VISIBLE
            ArsenalDetailAlternateAttackTextView.text = getString(R.string.alternate_attack_knife) + " (${getString(R.string.arsenal_tacticalknife_alternate_firerate)}${getString(R.string.unit_fire_rate_knife)})"
            ArsenalDetailAlternateDescriptionTextView.text = getString(R.string.arsenal_tacticalknife_frontal_attack) + ": " + getString(R.string.arsenal_tacticalknife_alternate_damage_forward)
            ArsenalDetailAlternateFirerateTextView.text =getString(R.string.arsenal_tacticalknife_rear_attack) + ": " + getString(R.string.arsenal_tacticalknife_alternate_damage_backward)
        }

        // set lower constraint layout
        ArsenalDetailDistance2Layout.visibility = View.VISIBLE
        ArsenalDetailDistance3Layout.visibility = View.VISIBLE
        ArsenalDetailDistance1DistanceTextView.text = arsenal.distance1
        ArsenalDetailDistance1HeadTextView.text = arsenal.distance1Head
        ArsenalDetailDistance1BodyTextView.text = arsenal.distance1Body
        ArsenalDetailDistance1LegTextView.text = arsenal.distance1Leg
        ArsenalDetailDistance2DistanceTextView.text = arsenal.distance2
        ArsenalDetailDistance2HeadTextView.text = arsenal.distance2Head
        ArsenalDetailDistance2BodyTextView.text = arsenal.distance2Body
        ArsenalDetailDistance2LegTextView.text = arsenal.distance2Leg
        ArsenalDetailDistance3DistanceTextView.text = arsenal.distance3
        ArsenalDetailDistance3HeadTextView.text = arsenal.distance3Head
        ArsenalDetailDistance3BodyTextView.text = arsenal.distance3Body
        ArsenalDetailDistance3LegTextView.text = arsenal.distance3Leg
        if (arsenal.distance2 == "") ArsenalDetailDistance2Layout.visibility = View.GONE
        if (arsenal.distance3 == "") ArsenalDetailDistance3Layout.visibility = View.GONE
        if (arsenal.identifier == "tacticalknife") {
            ArsenalDetailManikinImageView.visibility = View.GONE
            ArsenalDetailDistance2Layout.visibility = View.GONE
            ArsenalDetailDistance3Layout.visibility = View.GONE
            ArsenalDetailDistance1HeadTextView.text = getString(R.string.thankyou)
            ArsenalDetailDistance1DistanceTextView.visibility = View.GONE
            ArsenalDetailDistance1BodyTextView.visibility = View.GONE
            ArsenalDetailDistance1LegTextView.visibility = View.GONE
        }
    }
}