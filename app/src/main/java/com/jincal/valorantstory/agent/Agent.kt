package com.jincal.valorantstory.agent

import com.jincal.valorantstory.R
import com.jincal.valorantstory.ResourceAccessor
import java.util.*

class Agent(val identifier: String) {
    var name = ""
    var biography = ""
    var comment = ""
    var role = ""
    var roleDescription = ""
    var skill1Name = ""
    var skill1Cost = ""
    var skill1Charge = ""
    var skill1Description = ""
    var skill2Name = ""
    var skill2Cost = ""
    var skill2Charge = ""
    var skill2Description = ""
    var skill3Name = ""
    var skill3Cost = ""
    var skill3Charge = ""
    var skill3Description = ""
    var skill4Name = ""
    var skill4Cost = ""
    var skill4Charge = ""
    var skill4Description = ""
    var iconImageId = 0
    var standingImageId = 0
    var roleImageId = 0
    var skill1Image = 0
    var skill2Image = 0
    var skill3Image = 0
    var skill4Image = 0

    inner class AgentSkill(var skillName: String,
                           var skillCost: String,
                           var skillCharge: String,
                           var skillDescription: String,
                           var skillImage: Int,
                           var skillCommand: String)

    fun getAgentSkillArray(): Array<AgentSkill> = arrayOf(
        AgentSkill(skill1Name, skill1Cost, skill1Charge, skill1Description, skill1Image, "C"),
        AgentSkill(skill2Name, skill2Cost, skill2Charge, skill2Description, skill2Image, "Q"),
        AgentSkill(skill3Name, skill3Cost, skill3Charge, skill3Description, skill3Image, "E"),
        AgentSkill(skill4Name, skill4Cost, skill4Charge, skill4Description, skill4Image, "X"))

    fun getRandomAgentImageId(): Int {
        return when (Random().nextInt(11)) {
            0 -> R.drawable.breach
            1 -> R.drawable.brimstone
            2 -> R.drawable.cypher
            3 -> R.drawable.jett
            4 -> R.drawable.omen
            5 -> R.drawable.phoenix
            6 -> R.drawable.raze
            7 -> R.drawable.reyna
            8 -> R.drawable.sage
            9 -> R.drawable.sova
            else -> R.drawable.viper
        }
    }

    // below init...... completely bad(aspect of time wasting).. look at the Arsenal class' init!
    init {
        fun getString(address: Int) = ResourceAccessor.res!!.getString(address)
        when (identifier) {
            "Breach" -> {
                name = getString(R.string.agent_breach_name)
                biography = getString(R.string.agent_breach_biography)
                comment = getString(R.string.agent_breach_comment)
                role = getString(R.string.agent_breach_role)
                roleDescription = getString(R.string.agent_breach_role_description)
                skill1Name = getString(R.string.agent_breach_skill1_name)
                skill1Cost = getString(R.string.agent_breach_skill1_cost)
                skill1Charge = getString(R.string.agent_breach_skill1_charge)
                skill1Description = getString(R.string.agent_breach_skill1_description)
                skill2Name = getString(R.string.agent_breach_skill2_name)
                skill2Cost = getString(R.string.agent_breach_skill2_cost)
                skill2Charge = getString(R.string.agent_breach_skill2_charge)
                skill2Description = getString(R.string.agent_breach_skill2_description)
                skill3Name = getString(R.string.agent_breach_skill3_name)
                skill3Cost = getString(R.string.agent_breach_skill3_cost)
                skill3Charge = getString(R.string.agent_breach_skill3_charge)
                skill3Description = getString(R.string.agent_breach_skill3_description)
                skill4Name = getString(R.string.agent_breach_skill4_name)
                skill4Cost = getString(R.string.agent_breach_skill4_cost)
                skill4Charge = getString(R.string.agent_breach_skill4_charge)
                skill4Description = getString(R.string.agent_breach_skill4_description)
                iconImageId = R.drawable.breach_icon
                standingImageId = R.drawable.breach
                roleImageId = R.drawable.role_initiator
                skill1Image = R.drawable.breach_1_aftershock
                skill2Image = R.drawable.breach_2_flashpoint
                skill3Image = R.drawable.breach_3_faultline
                skill4Image = R.drawable.breach_4_rollingthunder
            }

            "Brimstone" -> {
                name = getString(R.string.agent_brimstone_name)
                biography = getString(R.string.agent_brimstone_biography)
                comment = getString(R.string.agent_brimstone_comment)
                role = getString(R.string.agent_brimstone_role)
                roleDescription = getString(R.string.agent_brimstone_role_description)
                skill1Name = getString(R.string.agent_brimstone_skill1_name)
                skill1Cost = getString(R.string.agent_brimstone_skill1_cost)
                skill1Charge = getString(R.string.agent_brimstone_skill1_charge)
                skill1Description = getString(R.string.agent_brimstone_skill1_description)
                skill2Name = getString(R.string.agent_brimstone_skill2_name)
                skill2Cost = getString(R.string.agent_brimstone_skill2_cost)
                skill2Charge = getString(R.string.agent_brimstone_skill2_charge)
                skill2Description = getString(R.string.agent_brimstone_skill2_description)
                skill3Name = getString(R.string.agent_brimstone_skill3_name)
                skill3Cost = getString(R.string.agent_brimstone_skill3_cost)
                skill3Charge = getString(R.string.agent_brimstone_skill3_charge)
                skill3Description = getString(R.string.agent_brimstone_skill3_description)
                skill4Name = getString(R.string.agent_brimstone_skill4_name)
                skill4Cost = getString(R.string.agent_brimstone_skill4_cost)
                skill4Charge = getString(R.string.agent_brimstone_skill4_charge)
                skill4Description = getString(R.string.agent_brimstone_skill4_description)
                iconImageId = R.drawable.brimstone_icon
                standingImageId = R.drawable.brimstone
                roleImageId = R.drawable.role_controller
                skill1Image = R.drawable.brimstone_1_stimbeacon
                skill2Image = R.drawable.brimstone_2_incendiary
                skill3Image = R.drawable.brimstone_3_skysmoke
                skill4Image = R.drawable.brimstone_4_orbitalstrike
            }

            "Cypher" -> {
                name = getString(R.string.agent_cypher_name)
                biography = getString(R.string.agent_cypher_biography)
                comment = getString(R.string.agent_cypher_comment)
                role = getString(R.string.agent_cypher_role)
                roleDescription = getString(R.string.agent_cypher_role_description)
                skill1Name = getString(R.string.agent_cypher_skill1_name)
                skill1Cost = getString(R.string.agent_cypher_skill1_cost)
                skill1Charge = getString(R.string.agent_cypher_skill1_charge)
                skill1Description = getString(R.string.agent_cypher_skill1_description)
                skill2Name = getString(R.string.agent_cypher_skill2_name)
                skill2Cost = getString(R.string.agent_cypher_skill2_cost)
                skill2Charge = getString(R.string.agent_cypher_skill2_charge)
                skill2Description = getString(R.string.agent_cypher_skill2_description)
                skill3Name = getString(R.string.agent_cypher_skill3_name)
                skill3Cost = getString(R.string.agent_cypher_skill3_cost)
                skill3Charge = getString(R.string.agent_cypher_skill3_charge)
                skill3Description = getString(R.string.agent_cypher_skill3_description)
                skill4Name = getString(R.string.agent_cypher_skill4_name)
                skill4Cost = getString(R.string.agent_cypher_skill4_cost)
                skill4Charge = getString(R.string.agent_cypher_skill4_charge)
                skill4Description = getString(R.string.agent_cypher_skill4_description)
                iconImageId = R.drawable.cypher_icon
                standingImageId = R.drawable.cypher
                roleImageId = R.drawable.role_sentinel
                skill1Image = R.drawable.cypher_1_trapwire
                skill2Image = R.drawable.cypher_2_cybercage
                skill3Image = R.drawable.cypher_3spycam
                skill4Image = R.drawable.cypher_4_neuraltheft
            }

            "Jett" -> {
                name = getString(R.string.agent_jett_name)
                biography = getString(R.string.agent_jett_biography)
                comment = getString(R.string.agent_jett_comment)
                role = getString(R.string.agent_jett_role)
                roleDescription = getString(R.string.agent_jett_role_description)
                skill1Name = getString(R.string.agent_jett_skill1_name)
                skill1Cost = getString(R.string.agent_jett_skill1_cost)
                skill1Charge = getString(R.string.agent_jett_skill1_charge)
                skill1Description = getString(R.string.agent_jett_skill1_description)
                skill2Name = getString(R.string.agent_jett_skill2_name)
                skill2Cost = getString(R.string.agent_jett_skill2_cost)
                skill2Charge = getString(R.string.agent_jett_skill2_charge)
                skill2Description = getString(R.string.agent_jett_skill2_description)
                skill3Name = getString(R.string.agent_jett_skill3_name)
                skill3Cost = getString(R.string.agent_jett_skill3_cost)
                skill3Charge = getString(R.string.agent_jett_skill3_charge)
                skill3Description = getString(R.string.agent_jett_skill3_description)
                skill4Name = getString(R.string.agent_jett_skill4_name)
                skill4Cost = getString(R.string.agent_jett_skill4_cost)
                skill4Charge = getString(R.string.agent_jett_skill4_charge)
                skill4Description = getString(R.string.agent_jett_skill4_description)
                iconImageId = R.drawable.jett_icon
                standingImageId = R.drawable.jett
                roleImageId = R.drawable.role_duelist
                skill1Image = R.drawable.jett_1_cloudburst
                skill2Image = R.drawable.jett_2_updraft
                skill3Image = R.drawable.jett_3_tailwind
                skill4Image = R.drawable.jett_4_bladestorm
            }

            "Omen" -> {
                name = getString(R.string.agent_omen_name)
                biography = getString(R.string.agent_omen_biography)
                comment = getString(R.string.agent_omen_comment)
                role = getString(R.string.agent_omen_role)
                roleDescription = getString(R.string.agent_omen_role_description)
                skill1Name = getString(R.string.agent_omen_skill1_name)
                skill1Cost = getString(R.string.agent_omen_skill1_cost)
                skill1Charge = getString(R.string.agent_omen_skill1_charge)
                skill1Description = getString(R.string.agent_omen_skill1_description)
                skill2Name = getString(R.string.agent_omen_skill2_name)
                skill2Cost = getString(R.string.agent_omen_skill2_cost)
                skill2Charge = getString(R.string.agent_omen_skill2_charge)
                skill2Description = getString(R.string.agent_omen_skill2_description)
                skill3Name = getString(R.string.agent_omen_skill3_name)
                skill3Cost = getString(R.string.agent_omen_skill3_cost)
                skill3Charge = getString(R.string.agent_omen_skill3_charge)
                skill3Description = getString(R.string.agent_omen_skill3_description)
                skill4Name = getString(R.string.agent_omen_skill4_name)
                skill4Cost = getString(R.string.agent_omen_skill4_cost)
                skill4Charge = getString(R.string.agent_omen_skill4_charge)
                skill4Description = getString(R.string.agent_omen_skill4_description)
                iconImageId = R.drawable.omen_icon
                standingImageId = R.drawable.omen
                roleImageId = R.drawable.role_controller
                skill1Image = R.drawable.omen_1_shroudedstep
                skill2Image = R.drawable.omen_2_paranoia
                skill3Image = R.drawable.omen_3_darkcover
                skill4Image = R.drawable.omen_4_fromtheshadows
            }

            "Phoenix" -> {
                name = getString(R.string.agent_phoenix_name)
                biography = getString(R.string.agent_phoenix_biography)
                comment = getString(R.string.agent_phoenix_comment)
                role = getString(R.string.agent_phoenix_role)
                roleDescription = getString(R.string.agent_phoenix_role_description)
                skill1Name = getString(R.string.agent_phoenix_skill1_name)
                skill1Cost = getString(R.string.agent_phoenix_skill1_cost)
                skill1Charge = getString(R.string.agent_phoenix_skill1_charge)
                skill1Description = getString(R.string.agent_phoenix_skill1_description)
                skill2Name = getString(R.string.agent_phoenix_skill2_name)
                skill2Cost = getString(R.string.agent_phoenix_skill2_cost)
                skill2Charge = getString(R.string.agent_phoenix_skill2_charge)
                skill2Description = getString(R.string.agent_phoenix_skill2_description)
                skill3Name = getString(R.string.agent_phoenix_skill3_name)
                skill3Cost = getString(R.string.agent_phoenix_skill3_cost)
                skill3Charge = getString(R.string.agent_phoenix_skill3_charge)
                skill3Description = getString(R.string.agent_phoenix_skill3_description)
                skill4Name = getString(R.string.agent_phoenix_skill4_name)
                skill4Cost = getString(R.string.agent_phoenix_skill4_cost)
                skill4Charge = getString(R.string.agent_phoenix_skill4_charge)
                skill4Description = getString(R.string.agent_phoenix_skill4_description)
                iconImageId = R.drawable.phoenix_icon
                standingImageId = R.drawable.phoenix
                roleImageId = R.drawable.role_duelist
                skill1Image = R.drawable.phoenix_1_blaze
                skill2Image = R.drawable.phoenix_2_curveball
                skill3Image = R.drawable.phoenix_3_hothands
                skill4Image = R.drawable.phoenix_4_runitback
            }

            "Raze" -> {
                name = getString(R.string.agent_raze_name)
                biography = getString(R.string.agent_raze_biography)
                comment = getString(R.string.agent_raze_comment)
                role = getString(R.string.agent_raze_role)
                roleDescription = getString(R.string.agent_raze_role_description)
                skill1Name = getString(R.string.agent_raze_skill1_name)
                skill1Cost = getString(R.string.agent_raze_skill1_cost)
                skill1Charge = getString(R.string.agent_raze_skill1_charge)
                skill1Description = getString(R.string.agent_raze_skill1_description)
                skill2Name = getString(R.string.agent_raze_skill2_name)
                skill2Cost = getString(R.string.agent_raze_skill2_cost)
                skill2Charge = getString(R.string.agent_raze_skill2_charge)
                skill2Description = getString(R.string.agent_raze_skill2_description)
                skill3Name = getString(R.string.agent_raze_skill3_name)
                skill3Cost = getString(R.string.agent_raze_skill3_cost)
                skill3Charge = getString(R.string.agent_raze_skill3_charge)
                skill3Description = getString(R.string.agent_raze_skill3_description)
                skill4Name = getString(R.string.agent_raze_skill4_name)
                skill4Cost = getString(R.string.agent_raze_skill4_cost)
                skill4Charge = getString(R.string.agent_raze_skill4_charge)
                skill4Description = getString(R.string.agent_raze_skill4_description)
                iconImageId = R.drawable.raze_icon
                standingImageId = R.drawable.raze
                roleImageId = R.drawable.role_duelist
                skill1Image = R.drawable.raze_1_boombot
                skill2Image = R.drawable.raze_2_painshells
                skill3Image = R.drawable.raze_3_blastlpack
                skill4Image = R.drawable.raze_4_showstopper
            }

            "Reyna" -> {
                name = getString(R.string.agent_reyna_name)
                biography = getString(R.string.agent_reyna_biography)
                comment = getString(R.string.agent_reyna_comment)
                role = getString(R.string.agent_reyna_role)
                roleDescription = getString(R.string.agent_reyna_role_description)
                skill1Name = getString(R.string.agent_reyna_skill1_name)
                skill1Cost = getString(R.string.agent_reyna_skill1_cost)
                skill1Charge = getString(R.string.agent_reyna_skill1_charge)
                skill1Description = getString(R.string.agent_reyna_skill1_description)
                skill2Name = getString(R.string.agent_reyna_skill2_name)
                skill2Cost = getString(R.string.agent_reyna_skill2_cost)
                skill2Charge = getString(R.string.agent_reyna_skill2_charge)
                skill2Description = getString(R.string.agent_reyna_skill2_description)
                skill3Name = getString(R.string.agent_reyna_skill3_name)
                skill3Cost = getString(R.string.agent_reyna_skill3_cost)
                skill3Charge = getString(R.string.agent_reyna_skill3_charge)
                skill3Description = getString(R.string.agent_reyna_skill3_description)
                skill4Name = getString(R.string.agent_reyna_skill4_name)
                skill4Cost = getString(R.string.agent_reyna_skill4_cost)
                skill4Charge = getString(R.string.agent_reyna_skill4_charge)
                skill4Description = getString(R.string.agent_reyna_skill4_description)
                iconImageId = R.drawable.reyna_icon
                standingImageId = R.drawable.reyna
                roleImageId = R.drawable.role_duelist
                skill1Image = R.drawable.reyna_1_dismiss
                skill2Image = R.drawable.reyna_2_leer
                skill3Image = R.drawable.reyna_3_devour
                skill4Image = R.drawable.reyna_4_empress
            }

            "Sage" -> {
                name = getString(R.string.agent_sage_name)
                biography = getString(R.string.agent_sage_biography)
                comment = getString(R.string.agent_sage_comment)
                role = getString(R.string.agent_sage_role)
                roleDescription = getString(R.string.agent_sage_role_description)
                skill1Name = getString(R.string.agent_sage_skill1_name)
                skill1Cost = getString(R.string.agent_sage_skill1_cost)
                skill1Charge = getString(R.string.agent_sage_skill1_charge)
                skill1Description = getString(R.string.agent_sage_skill1_description)
                skill2Name = getString(R.string.agent_sage_skill2_name)
                skill2Cost = getString(R.string.agent_sage_skill2_cost)
                skill2Charge = getString(R.string.agent_sage_skill2_charge)
                skill2Description = getString(R.string.agent_sage_skill2_description)
                skill3Name = getString(R.string.agent_sage_skill3_name)
                skill3Cost = getString(R.string.agent_sage_skill3_cost)
                skill3Charge = getString(R.string.agent_sage_skill3_charge)
                skill3Description = getString(R.string.agent_sage_skill3_description)
                skill4Name = getString(R.string.agent_sage_skill4_name)
                skill4Cost = getString(R.string.agent_sage_skill4_cost)
                skill4Charge = getString(R.string.agent_sage_skill4_charge)
                skill4Description = getString(R.string.agent_sage_skill4_description)
                iconImageId = R.drawable.sage_icon
                standingImageId = R.drawable.sage
                roleImageId = R.drawable.role_sentinel
                skill1Image = R.drawable.sage_1_barrierorb
                skill2Image = R.drawable.sage_2_sloworb
                skill3Image = R.drawable.sage_3_healingorb
                skill4Image = R.drawable.sage_4_resurrection
            }

            "Sova" -> {
                name = getString(R.string.agent_sova_name)
                biography = getString(R.string.agent_sova_biography)
                comment = getString(R.string.agent_sova_comment)
                role = getString(R.string.agent_sova_role)
                roleDescription = getString(R.string.agent_sova_role_description)
                skill1Name = getString(R.string.agent_sova_skill1_name)
                skill1Cost = getString(R.string.agent_sova_skill1_cost)
                skill1Charge = getString(R.string.agent_sova_skill1_charge)
                skill1Description = getString(R.string.agent_sova_skill1_description)
                skill2Name = getString(R.string.agent_sova_skill2_name)
                skill2Cost = getString(R.string.agent_sova_skill2_cost)
                skill2Charge = getString(R.string.agent_sova_skill2_charge)
                skill2Description = getString(R.string.agent_sova_skill2_description)
                skill3Name = getString(R.string.agent_sova_skill3_name)
                skill3Cost = getString(R.string.agent_sova_skill3_cost)
                skill3Charge = getString(R.string.agent_sova_skill3_charge)
                skill3Description = getString(R.string.agent_sova_skill3_description)
                skill4Name = getString(R.string.agent_sova_skill4_name)
                skill4Cost = getString(R.string.agent_sova_skill4_cost)
                skill4Charge = getString(R.string.agent_sova_skill4_charge)
                skill4Description = getString(R.string.agent_sova_skill4_description)
                iconImageId = R.drawable.sova_icon
                standingImageId = R.drawable.sova
                roleImageId = R.drawable.role_initiator
                skill1Image = R.drawable.sova_1_owldrone
                skill2Image = R.drawable.sova_2_shockbolt
                skill3Image = R.drawable.sova_3_reconbolt
                skill4Image = R.drawable.sova_4_huntersfury
            }

            "Viper" -> {
                name = getString(R.string.agent_viper_name)
                biography = getString(R.string.agent_viper_biography)
                comment = getString(R.string.agent_viper_comment)
                role = getString(R.string.agent_viper_role)
                roleDescription = getString(R.string.agent_viper_role_description)
                skill1Name = getString(R.string.agent_viper_skill1_name)
                skill1Cost = getString(R.string.agent_viper_skill1_cost)
                skill1Charge = getString(R.string.agent_viper_skill1_charge)
                skill1Description = getString(R.string.agent_viper_skill1_description)
                skill2Name = getString(R.string.agent_viper_skill2_name)
                skill2Cost = getString(R.string.agent_viper_skill2_cost)
                skill2Charge = getString(R.string.agent_viper_skill2_charge)
                skill2Description = getString(R.string.agent_viper_skill2_description)
                skill3Name = getString(R.string.agent_viper_skill3_name)
                skill3Cost = getString(R.string.agent_viper_skill3_cost)
                skill3Charge = getString(R.string.agent_viper_skill3_charge)
                skill3Description = getString(R.string.agent_viper_skill3_description)
                skill4Name = getString(R.string.agent_viper_skill4_name)
                skill4Cost = getString(R.string.agent_viper_skill4_cost)
                skill4Charge = getString(R.string.agent_viper_skill4_charge)
                skill4Description = getString(R.string.agent_viper_skill4_description)
                iconImageId = R.drawable.viper_icon
                standingImageId = R.drawable.viper
                roleImageId = R.drawable.role_controller
                skill1Image = R.drawable.viper_1_snakesite
                skill2Image = R.drawable.viper_2_poisoncloud
                skill3Image = R.drawable.viper_3_toxicscreen
                skill4Image = R.drawable.viper_4_viperspit
            }

            "questionmark" -> {
                iconImageId = R.drawable.question_mark
            }
        }
    }
}