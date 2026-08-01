package com.example.model

import androidx.compose.ui.graphics.Color

data class BadgeItem(
    val id: String,
    val dayMilestone: Int, // e.g. 10, 20, 30... 365
    val title: String,
    val description: String,
    val emojiIcon: String,
    val isUnlocked: Boolean,
    val progressPercent: Int, // 0 to 100
    val progressText: String,
    val badgeColorHex: String
)

object BadgeRepository {
    fun getAll36Badges(currentStreakDays: Int = 25): List<BadgeItem> {
        val rawBadges = listOf(
            Triple(10, "Genesis Starter", "Completed first 10 days of study 🌱") to Pair("🌱", "#FFAB00"),
            Triple(20, "Routine Builder", "20 days continuous study streak ⚙️") to Pair("⚙️", "#FF6D00"),
            Triple(30, "Monthly Titan", "30 days uninterrupted learning 📅") to Pair("📅", "#00C853"),
            Triple(40, "Focus Master", "40 days disciplined preparation 🎯") to Pair("🎯", "#00B0FF"),
            Triple(50, "Half Century", "50 days study milestone 🏏") to Pair("🏏", "#651FFF"),
            Triple(60, "Bi-Monthly Champion", "60 days study streak hero ⚡") to Pair("⚡", "#D500F9"),
            Triple(70, "Concept Crusher", "70 days topic practice master 📚") to Pair("📚", "#FF4081"),
            Triple(80, "Physics Pioneer", "80 days problem solver 🌌") to Pair("🌌", "#3D5AFF"),
            Triple(90, "Quarter Master", "90 days exam preparation 🏆") to Pair("🏆", "#FFC107"),
            Triple(100, "Century Scholar", "100 days unstoppable streak 💯") to Pair("💯", "#FF3D00"),
            Triple(110, "Chem Alchemist", "110 days active learning 🧪") to Pair("🧪", "#00E676"),
            Triple(120, "Tri-Monthly Vanguard", "120 days preparation streak 🚀") to Pair("🚀", "#00B0FF"),
            Triple(130, "Bio Botanist", "130 days dedicated study 🧬") to Pair("🧬", "#76FF03"),
            Triple(140, "Speed Demon", "140 days mock speed master ⏱️") to Pair("⏱️", "#FF9100"),
            Triple(150, "Iron Will", "150 days consistent effort 🛡️") to Pair("🛡️", "#7C4DFF"),
            Triple(160, "Formula Wizard", "160 days memory recaller 🪄") to Pair("🪄", "#E040FB"),
            Triple(170, "Revision Maverick", "170 days constant review 🔄") to Pair("🔄", "#00E5FF"),
            Triple(180, "Half Year Hero", "180 days study streak 🌗") to Pair("🌗", "#FFD600"),
            Triple(190, "Accuracy Ace", "190 days precision tracker 🎯") to Pair("🎯", "#FF1744"),
            Triple(200, "Double Century", "200 days legend status 🔥") to Pair("🔥", "#FF5722"),
            Triple(210, "Maths Commander", "210 days problem solving 📐") to Pair("📐", "#2979FF"),
            Triple(220, "Endurance Beast", "220 days daily grit 🐅") to Pair("🐅", "#FF6F00"),
            Triple(230, "Strategic Brain", "230 days smart revision 🧠") to Pair("🧠", "#AA00FF"),
            Triple(240, "2/3rd Conqueror", "240 days journey completed 🗺️") to Pair("🗺️", "#00B8D4"),
            Triple(250, "Quarter Thousand", "250 days milestone achieved 💎") to Pair("💎", "#00E5FF"),
            Triple(260, "Mock Titan", "260 days exam readiness 📝") to Pair("📝", "#FFC400"),
            Triple(270, "Three Quarter Knight", "270 days unbroken streak ⚔️") to Pair("⚔️", "#D500F9"),
            Triple(280, "Peak Performer", "280 days top gear practice 🏔️") to Pair("🏔️", "#00C853"),
            Triple(290, "Concept General", "290 days mastery reached 🎖️") to Pair("🎖️", "#FF3D00"),
            Triple(300, "Triple Century", "300 days incredible grit 👑") to Pair("👑", "#FFD700"),
            Triple(310, "Final Lap Runner", "310 days NTA exam sprint 🏃") to Pair("🏃", "#00E676"),
            Triple(320, "Rank Booster", "320 days top tier scoring 📈") to Pair("📈", "#2979FF"),
            Triple(330, "Unshakable Mind", "330 days calm & focused 🧘") to Pair("🧘", "#7C4DFF"),
            Triple(340, "Grandmaster Aspirant", "340 days legendary streak 🌟") to Pair("🌟", "#FFAB00"),
            Triple(350, "Summit Specialist", "350 days near peak prep 🦅") to Pair("🦅", "#FF1744"),
            Triple(365, "Ultimate Topper", "365 days full year champion 🏆") to Pair("🏆", "#FFD700")
        )

        return rawBadges.mapIndexed { index, (info, style) ->
            val day = info.first
            val isUnlocked = currentStreakDays >= day
            val progressPercent = when {
                isUnlocked -> 100
                index == 0 -> ((currentStreakDays.toFloat() / day) * 100).toInt().coerceAtMost(99)
                else -> {
                    val prevDay = rawBadges[index - 1].first.first
                    if (currentStreakDays > prevDay) {
                        (((currentStreakDays - prevDay).toFloat() / (day - prevDay)) * 100).toInt().coerceAtMost(99)
                    } else 0
                }
            }

            val progressText = if (isUnlocked) "UNLOCKED" else "$currentStreakDays/$day Days"

            BadgeItem(
                id = "badge_${day}",
                dayMilestone = day,
                title = info.second,
                description = info.third,
                emojiIcon = style.first,
                isUnlocked = isUnlocked,
                progressPercent = progressPercent,
                progressText = progressText,
                badgeColorHex = style.second
            )
        }
    }
}
