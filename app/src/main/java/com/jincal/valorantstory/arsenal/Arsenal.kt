package com.jincal.valorantstory.arsenal

import android.app.Activity
import com.jincal.valorantstory.`object`.ResourceGetterWithIdentifier

class Arsenal(val identifier: String, activity: Activity) {
    var type = ""
    var name = ""
    var detailName = ""
    var cost = ""
    var magazine = ""
    var wallPenetration = ""
    var primaryMode = ""
    var primaryFireRate = ""
    var alternateDescription = ""
    var alternateFireRate = ""
    var distance1 = ""
    var distance1Head = ""
    var distance1Body = ""
    var distance1Leg = ""
    var distance2 = ""
    var distance2Head = ""
    var distance2Body = ""
    var distance2Leg = ""
    var distance3 = ""
    var distance3Head = ""
    var distance3Body = ""
    var distance3Leg = ""
    var imageId = 0

    init {
        with(activity) {
            type = ResourceGetterWithIdentifier.getStringWithIdentifier("arsenal_${identifier}_type", this)
            name = ResourceGetterWithIdentifier.getStringWithIdentifier("arsenal_${identifier}_name", this)
            detailName = ResourceGetterWithIdentifier.getStringWithIdentifier("arsenal_${identifier}_detailname", this)
            cost = ResourceGetterWithIdentifier.getStringWithIdentifier("arsenal_${identifier}_cost", this)
            magazine = ResourceGetterWithIdentifier.getStringWithIdentifier("arsenal_${identifier}_magazine_one", this) + " / " + ResourceGetterWithIdentifier.getStringWithIdentifier("arsenal_${identifier}_magazine_whole", this)
            wallPenetration = ResourceGetterWithIdentifier.getStringWithIdentifier("arsenal_${identifier}_wall_penetration", this)
            primaryMode = ResourceGetterWithIdentifier.getStringWithIdentifier("arsenal_${identifier}_primary_mode", this)
            primaryFireRate = ResourceGetterWithIdentifier.getStringWithIdentifier("arsenal_${identifier}_primary_firerate", this)
            alternateDescription = ResourceGetterWithIdentifier.getStringWithIdentifier("arsenal_${identifier}_alternate_description", this)
            alternateFireRate = ResourceGetterWithIdentifier.getStringWithIdentifier("arsenal_${identifier}_alternate_firerate", this)
            distance1 = ResourceGetterWithIdentifier.getStringWithIdentifier("arsenal_${identifier}_distance1", this)
            distance1Head = ResourceGetterWithIdentifier.getStringWithIdentifier("arsenal_${identifier}_distance1_head", this)
            distance1Body = ResourceGetterWithIdentifier.getStringWithIdentifier("arsenal_${identifier}_distance1_body", this)
            distance1Leg = ResourceGetterWithIdentifier.getStringWithIdentifier("arsenal_${identifier}_distance1_leg", this)
            distance2 = ResourceGetterWithIdentifier.getStringWithIdentifier("arsenal_${identifier}_distance2", this)
            distance2Head = ResourceGetterWithIdentifier.getStringWithIdentifier("arsenal_${identifier}_distance2_head", this)
            distance2Body = ResourceGetterWithIdentifier.getStringWithIdentifier("arsenal_${identifier}_distance2_body", this)
            distance2Leg = ResourceGetterWithIdentifier.getStringWithIdentifier("arsenal_${identifier}_distance2_leg", this)
            distance3 = ResourceGetterWithIdentifier.getStringWithIdentifier("arsenal_${identifier}_distance3", this)
            distance3Head = ResourceGetterWithIdentifier.getStringWithIdentifier("arsenal_${identifier}_distance3_head", this)
            distance3Body = ResourceGetterWithIdentifier.getStringWithIdentifier("arsenal_${identifier}_distance3_body", this)
            distance3Leg = ResourceGetterWithIdentifier.getStringWithIdentifier("arsenal_${identifier}_distance3_leg", this)
            imageId = ResourceGetterWithIdentifier.getImageIdWithIdentifier(identifier, this)
        }
    }
}