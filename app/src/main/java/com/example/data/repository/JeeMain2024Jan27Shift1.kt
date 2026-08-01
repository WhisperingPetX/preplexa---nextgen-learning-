package com.example.data.repository

import com.example.data.local.CustomQuestionEntity

object JeeMain2024Jan27Shift1 {
    val questions = listOf(
        CustomQuestionEntity(
            id = "2024_s1_sh1_q1",
            category = "PYQ",
            subject = "Physics",
            topicOrYear = "2024_s1_sh1",
            questionText = "Given below are two statements:\nStatement-I: Viscosity of gases is greater than that of liquids.\nStatement-II: Surface tension of a liquid decreases due to the presence of insoluble impurities.\nIn the light of the above statements, choose the most appropriate answer from the options given below:",
            optionA = "Statement-I is incorrect but statement-II is correct",
            optionB = "Statement-I is correct but statement-II is incorrect",
            optionC = "Both Statement-I and Statement-II are incorrect",
            optionD = "Both Statement-I and Statement-II are correct",
            correctOptionIndex = 0,
            explanation = "Viscosity of liquids is greater than gas.\nSurface tension decreases due to the presence of impurities."
        ),
        CustomQuestionEntity(
            id = "2024_s1_sh1_q2",
            category = "PYQ",
            subject = "Physics",
            topicOrYear = "2024_s1_sh1",
            questionText = "0.08 kg air is heated at constant volume through 5°C. The specific heat of air at constant volume is 0.17 kcal/kg°C and J = 4.18 joule/cal. The change in its internal energy is approximately.",
            optionA = "284 J",
            optionB = "298 J",
            optionC = "318 J",
            optionD = "142 J",
            correctOptionIndex = 0,
            explanation = "ΔU = mCΔT\n= 0.08 × 0.17 × 4.18 × 10³ × 5\n= 284 J"
        ),
        CustomQuestionEntity(
            id = "2024_s1_sh1_q3",
            category = "PYQ",
            subject = "Physics",
            topicOrYear = "2024_s1_sh1",
            questionText = "Identify the physical quantity that cannot be measured using spherometer:",
            optionA = "Radius of curvature of convex surface",
            optionB = "Radius of curvature of concave surface",
            optionC = "Specific rotation of liquids",
            optionD = "Thickness of thin plates",
            correctOptionIndex = 2,
            explanation = "Spherometer cannot measure specific rotation of liquids."
        ),
        CustomQuestionEntity(
            id = "2024_s1_sh1_q4",
            category = "PYQ",
            subject = "Physics",
            topicOrYear = "2024_s1_sh1",
            questionText = "Position of an ant (S in metres) moving in Y-Z plane is given by S = 2t² ĵ + 5 k̂ (where t is in second). The magnitude and direction of velocity of the ant at t = 1 s will be :",
            optionA = "4 m/s in y-direction",
            optionB = "9 m/s in z-direction",
            optionC = "16 m/s in y-direction",
            optionD = "4 m/s in x-direction",
            correctOptionIndex = 0,
            explanation = "v = dS/dt\nv = 4t ĵ\nAt t = 1 s\nv = 4 ĵ"
        ),
        CustomQuestionEntity(
            id = "2024_s1_sh1_q5",
            category = "PYQ",
            subject = "Physics",
            topicOrYear = "2024_s1_sh1",
            questionText = "An electric charge 10⁻⁶ μC is placed at origin (0, 0) m of X – Y co-ordinate system. Two points P and Q are situated at (√3, √3) m and (√6, 0) m respectively. The potential difference between the points P and Q will be :",
            optionA = "√6 V",
            optionB = "0 V",
            optionC = "3 V",
            optionD = "√3 V",
            correctOptionIndex = 1,
            explanation = "V = KQ/r\nat P : r1 = √6\nat Q : r2 = √6\n∴ VP = VQ\n⇒ ΔV = 0"
        )
    )
}
