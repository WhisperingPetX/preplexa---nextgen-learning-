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

data class MonthlyDailyBadge(
    val dayOfMonth: Int, // 1 to 30
    val monthName: String, // e.g. "August"
    val year: Int, // e.g. 2026
    val title: String,
    val description: String,
    val emojiIcon: String,
    val isUnlocked: Boolean,
    val isToday: Boolean,
    val badgeColorHex: String
)

object MonthlyBadgeManager {
    private val DAILY_BADGE_PRESETS = listOf(
        Triple("Pioneer Badge", "Unlocked on Day 1 login 🌱", Pair("🌱", "#10B981")),
        Triple("Rocket Velocity", "Unlocked on Day 2 login 🚀", Pair("🚀", "#3B82F6")),
        Triple("Panda Power", "Unlocked on Day 3 login 🐼", Pair("🐼", "#F59E0B")),
        Triple("Med Wizard", "Unlocked on Day 4 login 🩺", Pair("🩺", "#8B5CF6")),
        Triple("Clever Monkey", "Unlocked on Day 5 login 🐒", Pair("🐒", "#EC4899")),
        Triple("Night Owl", "Unlocked on Day 6 login 🦉", Pair("🦉", "#06B6D4")),
        Triple("Grand Legend", "Unlocked on Day 7 login 🏆", Pair("🏆", "#EAB308")),
        Triple("Thunder Titan", "Unlocked on Day 8 login ⚡", Pair("⚡", "#FF6D00")),
        Triple("Apex Conqueror", "Unlocked on Day 9 login 👑", Pair("👑", "#AA00FF")),
        Triple("Bullseye Focus", "Unlocked on Day 10 login 🎯", Pair("🎯", "#FF1744")),
        Triple("Bio Genius", "Unlocked on Day 11 login 🧬", Pair("🧬", "#00E676")),
        Triple("Diamond Grit", "Unlocked on Day 12 login 💎", Pair("💎", "#00B0FF")),
        Triple("Flame Scholar", "Unlocked on Day 13 login 🔥", Pair("🔥", "#FF3D00")),
        Triple("Aegis Shield", "Unlocked on Day 14 login 🛡️", Pair("🛡️", "#7C4DFF")),
        Triple("Formula Wand", "Unlocked on Day 15 login 🪄", Pair("🪄", "#E040FB")),
        Triple("Deep Cosmos", "Unlocked on Day 16 login 🌌", Pair("🌌", "#2979FF")),
        Triple("Synapse Master", "Unlocked on Day 17 login 🧠", Pair("🧠", "#D500F9")),
        Triple("Vector Ruler", "Unlocked on Day 18 login 📐", Pair("📐", "#00C853")),
        Triple("Panther Sprint", "Unlocked on Day 19 login 🐅", Pair("🐅", "#FF6F00")),
        Triple("Lion Heart", "Unlocked on Day 20 login 🦁", Pair("🦁", "#FFAB00")),
        Triple("Sky Eagle", "Unlocked on Day 21 login 🦅", Pair("🦅", "#3D5AFF")),
        Triple("Volcano Power", "Unlocked on Day 22 login 🌋", Pair("🌋", "#FF3D00")),
        Triple("Superstar", "Unlocked on Day 23 login 🌟", Pair("🌟", "#FFD700")),
        Triple("Champion Punch", "Unlocked on Day 24 login 🥊", Pair("🥊", "#FF1744")),
        Triple("Oracle Crystal", "Unlocked on Day 25 login 🔮", Pair("🔮", "#AA00FF")),
        Triple("Target Archer", "Unlocked on Day 26 login 🏹", Pair("🏹", "#00E676")),
        Triple("Saturn Ring", "Unlocked on Day 27 login 🪐", Pair("🪐", "#00B0FF")),
        Triple("Gold Medalist", "Unlocked on Day 28 login 🥇", Pair("🥇", "#FFD600")),
        Triple("Final Lap", "Unlocked on Day 29 login 🏁", Pair("🏁", "#3B82F6")),
        Triple("Month Apex Topper", "Unlocked on Day 30 login 🏅", Pair("🏅", "#FFD700"))
    )

    fun getCurrentMonth30Badges(): List<MonthlyDailyBadge> {
        val cal = java.util.Calendar.getInstance()
        val todayDay = cal.get(java.util.Calendar.DAY_OF_MONTH).coerceIn(1, 30)
        val monthFormat = java.text.SimpleDateFormat("MMMM", java.util.Locale.getDefault())
        val monthName = monthFormat.format(cal.time)
        val year = cal.get(java.util.Calendar.YEAR)

        return (1..30).map { day ->
            val preset = DAILY_BADGE_PRESETS[(day - 1) % DAILY_BADGE_PRESETS.size]
            MonthlyDailyBadge(
                dayOfMonth = day,
                monthName = monthName,
                year = year,
                title = "Day $day: ${preset.first}",
                description = preset.second,
                emojiIcon = preset.third.first,
                isUnlocked = day <= todayDay,
                isToday = day == todayDay,
                badgeColorHex = preset.third.second
            )
        }
    }

    fun getTodayBadge(): MonthlyDailyBadge {
        val cal = java.util.Calendar.getInstance()
        val todayDay = cal.get(java.util.Calendar.DAY_OF_MONTH).coerceIn(1, 30)
        return getCurrentMonth30Badges().firstOrNull { it.dayOfMonth == todayDay }
            ?: getCurrentMonth30Badges()[0]
    }
}

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
