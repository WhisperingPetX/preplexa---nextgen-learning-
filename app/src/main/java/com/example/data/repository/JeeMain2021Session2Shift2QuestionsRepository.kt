package com.example.data.repository

import com.example.model.Question

object JeeMain2021Session2Shift2QuestionsRepository {
    fun getQuestions(testId: String): List<Question> {
        return listOf(
            Question(
                id = "${testId}_s2_sh2_q1_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Physics Q1]\nThe following logic gate is equivalent to :\n(Logic gate with A, B inputs to a NOR gate, followed by a NOT gate (made of NOR))",
                options = listOf("NOR Gate", "OR Gate", "AND Gate", "NAND Gate"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1\nSolution:\nThe truth table is similar to that of a NOR gate.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q2_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Physics Q2]\nA large block of wood of mass M = 5.99 kg is hanging from two long massless cords. A bullet of mass m = 10g is fired into the block and gets embedded in it. The (block + bullet) then swing upwards, their centre of mass rising a vertical distance h = 9.8 cm before the pendulum comes momentarily to rest at the end of its arc. The speed of the bullet just before collision is : (Take g = 9.8 ms^-2)",
                options = listOf("841.4 m/s", "811.4 m/s", "831.4 m/s", "821.4 m/s"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\nFrom energy conservation, 1/2 (M + m) v1^2 = (M + m)g h => v1 = sqrt(2gh)\nApplying momentum conservation, mv = (M + m)v1\nv = (M + m)/m * sqrt(2gh) = (6 / 0.01) * sqrt(2 * 9.8 * 0.098) = 831.55 m/s""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q3_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Physics Q3]\nA charge Q is moving dI distance in the magnetic field B. Find the value of work done by B.",
                options = listOf("1", "Infinite", "Zero", "–1"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\nSince force on a point charge by magnetic field is always perpendicular to velocity, work done is zero.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q4_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Physics Q4]\nWhat will be the nature of flow of water from a circular tap, when its flow rate increased from 0.18 L/min to 0.48 L/min ? The radius of the tap and viscosity of water are 0.5 cm and 10^-3 Pa.s, respectively.\n(Density of water : 10^3 kg/m^3)",
                options = listOf("Unsteady to steady flow", "Remains steady flow", "Remains turbulent flow", "Steady flow to unsteady flow"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4\nSolution:\nRe = rho v D / eta\nRe_initial = 382.16 (steady)\nRe_final = 1019.09 (unsteady)\nSo flow changes from steady to unsteady.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q5_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Physics Q5]\nA mosquito is moving with a velocity v = 0.5t^2 i + 3t j + 9 k m/s and accelerating in uniform conditions. What will be the direction of mosquito after 2s ?",
                options = listOf("tan^-1(2/3) from x-axis", "tan^-1(2/3) from y-axis", "tan^-1(5/2) from y-axis", "tan^-1(5/2) from x-axis"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2\nSolution:\nv at t=2 is 2i + 6j + 9k\nAngle with y-axis = tan^-1(sqrt(4+81)/6) = tan^-1(sqrt(85)/6). None of the options match exactly, question was a bonus.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q6_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Physics Q6]\nFind out the surface charge density at the intersection of point x = 3 m plane and x-axis, in the region of uniform line charge of 8 nC/m lying along the z-axis in free space.",
                options = listOf("0.424 nC m^-2", "47.88 C/m", "0.07 nC m^-2", "4.0 nC m^-2"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1\nSolution:\nE = lambda / (2 pi eps0 r) = sigma / eps0\nsigma = lambda / (2 pi r) = 8e-9 / (2 * pi * 3) = 0.424 nC/m^2""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q7_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Physics Q7]\nThe de-Broglie wavelength associated with an electron and a proton were calculated by accelerating them through same potential of 100 V. What should nearly be the ratio of their wavelengths ?\n(mp = 1.00727 u, me = 0.00055u)",
                options = listOf("1860 : 1", "(1860)^2 : 1", "41.4 : 1", "43 : 1"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4\nSolution:\nlambda = h / sqrt(2mqV)\nlambda_e / lambda_p = sqrt(m_p / m_e) = sqrt(1831.4) = 42.79 ~ 43:1""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q8_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Physics Q8]\nFor the given circuit, comment on the type of transformer used :\nInput 220V, output 60W, i_L = 0.11A",
                options = listOf("Auxilliary transformer", "Auto transformer", "Step-up transformer", "Step down transformer"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\nVs = P / i_L = 60 / 0.11 = 545.45 V\nSince Vs > Vp (220V), it is a step-up transformer.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q9_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Physics Q9]\nThe half-life of Au198 is 2.7 days. The activity of 1.50 mg of Au198 if its atomic weight is 198 g mol^-1 is, (NA = 6 * 10^23/mol)",
                options = listOf("240 Ci", "357 Ci", "535 Ci", "252 Ci"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2\nSolution:\nA = lambda N = (ln 2 / t_1/2) * (w / M * NA)\nA = (0.693 / (2.7 * 24 * 3600)) * (1.5e-3 / 198 * 6e23) = 357 Ci""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q10_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Physics Q10]\nCalculate the value of mean free path (lambda) for oxygen molecules at temperature 27C and pressure 1.01 * 10^5 Pa. Assume the molecular diameter 0.3 nm and the gas is ideal.",
                options = listOf("58 nm", "32 nm", "86 nm", "102 nm"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4\nSolution:\nlambda = kT / (sqrt(2) pi d^2 P) = 102 nm""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q11_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Physics Q11]\nThe refractive index of a converging lens is 1.4. What will be the focal length of this lens if it is placed in a medium of same refractive index ?",
                options = listOf("1", "Infinite", "(R1 R2) / (R1 - R2)", "Zero"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2\nSolution:\n1/f = (u_L / u_S - 1)(1/R1 - 1/R2). If u_L = u_S, 1/f = 0 => f = infinite.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q12_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Physics Q12]\nIn order to determine the Young's Modulus of a wire of radius 0.2 cm (least count = 0.001 cm) and length 1m (least count = 1 mm), a weight of mass 1kg (least count = 1g) was hanged to get the elongation of 0.5 cm (least count 0.001 cm). What will be the fractional error in the value of Young's Modulus ?",
                options = listOf("0.14%", "0.9%", "9%", "1.4%"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4\nSolution:\nY = mgL / (pi r^2 l)\ndY/Y = dm/m + dL/L + 2dr/r + dl/l\n= 1/1000 + 0.1/100 + 2(0.001/0.2) + 0.001/0.5 = 0.014 = 1.4%""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q13_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Physics Q13]\nA bimetallic strip consists of metals A and B. The metal A has higher coefficient of expansion compared to metal B. When placed in a cold bath, it will :",
                options = listOf("Bend towards the right", "Not bend but shrink", "Neither bend nor shrink", "Bend towards the left"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4\nSolution:\nA has higher alpha, so it will shrink more in a cold bath. Since it is on the left side, the strip bends towards the left.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q14_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Physics Q14]\nA resistor develops 500 J of thermal energy in 20s when a current of 1.5 A is passed through it. If the current is increased from 1.5 A to 3A, what will be the energy developed in 20 s.",
                options = listOf("1500 J", "1000 J", "500 J", "2000 J"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4\nSolution:\nE = I^2 R t. Current doubles, energy becomes 4 times = 4 * 500 = 2000 J.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q15_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Physics Q15]\nStatement I : A cyclist is moving on an unbanked road with a speed of 7 kmh^-1 and takes a sharp circular turn along a path of radius 2m. static friction is 0.2. The cyclist will not slip.\nStatement II : If the road is banked at 45 deg, cyclist can cross with 18.5 kmh^-1 without slipping.",
                options = listOf("Statement I is incorrect and statement II is correct", "Statement I is correct and statement II is incorrect", "Both statement I and statement II are false", "Both statement I and statement II are true"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2\nSolution:\nv_max = sqrt(u R g) = 1.97 m/s = 7.1 km/h. Will not slip.\nBanked at 45: v_max = sqrt(Rg tan 45) = 4.42 m/s = 15.9 km/h. 18.5 > 15.9, will slip.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q16_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Physics Q16]\nTwo identical antennas mounted on identical towers are separated from each other by a distance of 45 km. What should nearly be the minimum height of receiving antenna ?",
                options = listOf("19.77 m", "39.55 m", "79.1 m", "158.2 m"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2\nSolution:\nd = 2 sqrt(2 R h) => 45 = 2 sqrt(2 * 6400 * h) => h = 39.55 m""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q17_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Physics Q17]\nThe magnetic field in a region is given by B = B0(x/a) k. A square loop of side d is placed with edges along x and y axes. Moved with velocity v0 i. emf induced is:",
                options = listOf("B0 v0 d^2 / 2a", "B0 v0 d / 2a", "B0 v0 d^2 / a", "B0 v0 d^2 / 2a"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\nE = B l v. E_net = B_right d v0 - B_left d v0 = B0(x+d)/a d v0 - B0 x/a d v0 = B0 d^2 v0 / a""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q18_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Physics Q18]\nAmplitude of a mass-spring system executing SHM decreases with time. mass = 500g, Decay constant = 20 g/s. Time for amplitude to drop to half ?",
                options = listOf("34.65 s", "17.32 s", "0.034 s", "15.01 s"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1\nSolution:\nA = A0 e^{-bt/2m}. bt/2m = ln 2 => t = 2m ln2 / b = 2*500*0.693 / 20 = 34.65 s.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q19_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Physics Q19]\nCalculate the time interval between 33% decay and 67% decay if half-life of a substance is 20 minutes.",
                options = listOf("60 minutes", "20 minutes", "40 minutes", "13 minutes"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2\nSolution:\nRemaining amounts are 67% and 33%, which is approx a factor of 2 (half life). Time = 20 min.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q20_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Physics Q20]\nRed light differs from blue light as they have :",
                options = listOf("Different frequencies & different wavelengths", "Different frequencies and same wavelengths", "Same frequencies and same wavelengths", "Same frequencies and different wavelengths"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1\nSolution:\nRed and blue light have different frequencies and different wavelengths.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q21_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Physics Q21]\nThe energy dissipated by a resistor is 10 mJ in 1s when an electric current of 2 mA flows through it. The resistance is _______ ohm.",
                options = listOf("2500", "5000", "1250", "2000"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 2500\nSolution:\nE = I^2 R t => 10e-3 = (2e-3)^2 * R * 1 => R = 2500""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q22_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Physics Q22]\nIn a parallel plate capacitor set up, plate area is 2 m^2, separated by 1m. Dielectric of thickness 0.5 m, area 2m^2, constant 3.2 is inserted. New capacitance is ______ eps0.",
                options = listOf("3.04", "2", "4.04", "1.52"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 3.04\nSolution:\nC = eps0 A / (d - t + t/k) = eps0 * 2 / (1 - 0.5 + 0.5/3.2) = 3.04 eps0.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q23_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Physics Q23]\nA force F = 4i + 3j + 4k is applied on an intersection point of x = 2 plane and x-axis. The magnitude of torque of this force about a point (2, 3, 4) is ________.",
                options = listOf("20", "16", "25", "10"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 20\nSolution:\nr = (2,0,0) - (2,3,4) = (0,-3,-4). tau = r x F = -16j + 12k. |tau| = 20.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q24_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Physics Q24]\nIf one wants to remove all the mass of the earth to infinity in order to break it up completely. The amount of energy that needs to be supplied will be x GM^2 / 5 R where x is ____",
                options = listOf("3", "2", "4", "5"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 3\nSolution:\nU = -3/5 GM^2 / R. Energy required = 3/5 GM^2 / R => x = 3.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q25_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Physics Q25]\nA deviation of 2 deg is produced in yellow ray when prism of crown and flint glass are achromatically combined. Dispersive powers 0.02, 0.03. Refractive indices 1.5, 1.6. Refracting angle for crown glass prism is ________ deg",
                options = listOf("12", "6", "10", "8"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 12\nSolution:\nw1 d1 = w2 d2 => 0.02 d1 = 0.03 d2 => d1 = 1.5 d2. d1 - d2 = 2 => d1 = 6. A1 = d1 / (u-1) = 6 / 0.5 = 12 deg.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q26_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Physics Q26]\nA body of mass 2kg moves under a force of (2i + 3j + 5k) N. It starts from rest. After 4s, its new coordinates are (8, b, 20). The value of b is __________.",
                options = listOf("12", "16", "10", "8"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 12\nSolution:\na = F/m = (i + 1.5j + 2.5k). s = 1/2 a t^2 = 1/2 * a * 16 = 8 a = 8i + 12j + 20k. b = 12.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q27_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Physics Q27]\nA swimmer can swim with velocity 12 km/h in still water. River velocity 6 km/h. The direction with respect to the direction of flow of river he should swim to reach opposite point is _________ deg.",
                options = listOf("120", "150", "90", "135"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 120\nSolution:\nsin theta = 6/12 = 1/2 => theta = 30. Angle = 90 + 30 = 120.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q28_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Physics Q28]\nA closed organ pipe of length L and open organ pipe vibrating in their first overtone with same frequency. L_open = x L/3 sqrt(rho_1 / rho_2) where x is ________.",
                options = listOf("4", "2", "3", "5"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 4\nSolution:\n3V_C / 4L = 2V_O / 2L' => L' = 4L/3 (V_O / V_C) = 4L/3 sqrt(rho_1 / rho_2) => x = 4.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q29_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Physics Q29]\nA solid disc rolls down an inclined plane. Acceleration is 2/b g sin theta where b is ______.",
                options = listOf("3", "5", "4", "2"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 3\nSolution:\na = g sin theta / (1 + k^2/r^2) = g sin theta / (1 + 1/2) = 2/3 g sin theta => b = 3.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q30_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Physics Q30]\nFor an ideal heat engine, source temp is 127 C. For 60% efficiency, sink temp should be _______ C.",
                options = listOf("-113", "-100", "-73", "-50"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: -113\nSolution:\neff = 1 - T_L / T_H => 0.6 = 1 - T_L / 400 => T_L = 160 K = -113 C.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q31_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Chemistry Q31]\nThe green house gas/es is (are) :\n(A) Carbon dioxide (B) Oxygen (C) Water vapour (D) Methane",
                options = listOf("(A) and (C) only", "(A) only", "(A), (C) and (D) only", "(A) and (B) only"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\nCO2, H2O, and CH4 are greenhouse gases.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q32_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Chemistry Q32]\n2,4-dimethoxytoluene + reagent 'A' -> 2,4-dimethoxybenzoic acid. The reagent 'A' is :",
                options = listOf("NaBH4, H3O+", "LiAlH4", "Alkaline KMnO4, H+", "HCl, Zn-Hg"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\nAlkaline KMnO4 oxidizes the methyl group to a carboxylic acid group.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q33_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Chemistry Q33]\nWhich of the following reduction reaction CANNOT be carried out with coke ?",
                options = listOf("Al2O3 -> Al", "ZnO -> Zn", "Fe2O3 -> Fe", "Cu2O -> Cu"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1\nSolution:\nReduction of Al2O3 to Al is carried out by electrolytic reduction, not with coke.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q34_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Chemistry Q34]\nIdentify elements X and Y:\nX: IE1=495, IE2=4563\nY: IE1=731, IE2=1450",
                options = listOf("X = Na ; Y = Mg", "X = Mg ; Y = F", "X = Mg ; Y = Na", "X = F ; Y = Mg"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1\nSolution:\nX has very high IE2, so it's an alkali metal (Na).\nY has moderate IE1 and IE2, so it's an alkaline earth metal (Mg).""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q35_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Chemistry Q35]\nIdentify reagent A and conditions for converting cyclohexene to 3-chlorocyclohexene :",
                options = listOf("A = HCl; Anhydrous AlCl3", "A = HCl, ZnCl2", "A = Cl2; UV light", "A = Cl2; dark, Anhydrous AlCl3"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\nAllylic halogenation occurs with Cl2 in presence of UV light.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q36_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Chemistry Q36]\nThe secondary structure of protein is stabilised by:",
                options = listOf("Peptide bond", "glycosidic bond", "Hydrogen bonding", "van der Waals forces"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\nSecondary structures (alpha helix and beta pleated sheet) are stabilized by hydrogen bonding.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q37_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Chemistry Q37]\nFex2 and Fey3 are known when x and y are :",
                options = listOf("x = F, Cl, Br, I and y = F, Cl, Br", "x = F, Cl, Br and y = F, Cl, Br, I", "x = Cl, Br, I and y = F, Cl, Br, I", "x = F, Cl, Br, I and y = F, Cl, Br, I"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1\nSolution:\nFeI3 is not stable because I- is a strong reducing agent and reduces Fe3+ to Fe2+.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q38_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Chemistry Q38]\nWhich of the following polymer is used in the manufacture of wood laminates ?",
                options = listOf("cis-poly isoprene", "Melamine formaldehyde resin", "Urea formaldehyde resin", "Phenol and formaldehyde resin"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\nUrea formaldehyde resin is used in the manufacture of wood laminates.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q39_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Chemistry Q39]\nStatement I : Sodium hydride can be used as an oxidising agent.\nStatement II : The lone pair of electrons on nitrogen in pyridine makes it basic.",
                options = listOf("Both statement I and statement II are false", "Statement I is true but statement II is false", "Statement I is false but statement II is true", "Both statement I and statement II are true"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\nNaH is a reducing agent (hydride donor). Pyridine is basic due to the lone pair on N.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q40_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Chemistry Q40]\nThe INCORRECT statement regarding the structure of C60 is :",
                options = listOf("The six-membered rings are fused to both six and five-membered rings.", "Each carbon atom forms three sigma bonds.", "The five-membered rings are fused only to six-membered rings.", "It contains 12 six-membered rings and 24 five-membered rings."),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4\nSolution:\nC60 contains 20 hexagons and 12 pentagons. Option 4 is incorrect.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q41_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Chemistry Q41]\nThe correct statements about H2O2 are :\n(A) used in the treatment of effluents.\n(B) used as both oxidising and reducing agents.\n(C) the two hydroxyl groups lie in the same plane.\n(D) miscible with water.",
                options = listOf("(A), (B), (C) and (D)", "(A), (B) and (D) only", "(B), (C) and (D) only", "(A), (C) and (D) only"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2\nSolution:\nH2O2 has a non-planar open book structure, so (C) is false. It is used in effluents, acts as oxidising/reducing agent, and is miscible in water.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q42_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Chemistry Q42]\nAmmonolysis of Alkyl halides followed by the treatment with NaOH solution can be used to prepare primary, secondary and tertiary amines. The purpose of NaOH in the reaction is :",
                options = listOf("to remove basic impurities", "to activate NH3 used in the reaction", "to remove acidic impurities", "to increase the reactivity of alkyl halide"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\nNaOH is added to neutralize the hydrogen halide formed and remove acidic impurities.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q43_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Chemistry Q43]\nAn unsaturated hydrocarbon X on ozonolysis gives A. Compound A when warmed with ammonical silver nitrate forms a bright silver mirror. The unsaturated hydrocarbon X is :",
                options = listOf("2,3-dimethyl-2-butene", "2-methyl-2-butene", "1-pentyne", "2-butyne"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\nTerminal alkynes on ozonolysis produce formic acid, which gives a positive Tollens' test (silver mirror).""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q44_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Chemistry Q44]\nWhich of the following is least basic ?",
                options = listOf("(CH3CO) NHC2H5", "(C2H5)3N", "(CH3CO)2NH", "(C2H5)2NH"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\nIn (CH3CO)2NH, the lone pair on nitrogen is delocalized over two carbonyl groups, making it the least basic.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q45_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Chemistry Q45]\nThe characteristics of elements X, Y and Z with atomic numbers 33, 53 and 83 are :",
                options = listOf("X and Y are metalloids and Z is a metal.", "X is a metalloid, Y is a non-metal and Z is a metal.", "X, Y and Z are metals.", "X and Z are non-metals and Y is a metalloid"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2\nSolution:\n33 (As) is a metalloid, 53 (I) is a non-metal, 83 (Bi) is a metal.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q46_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Chemistry Q46]\nMatch List-I with List-II\n(a) Lassaigne's Test -> (i) Carbon\n(b) Cu(II) oxide -> (ii) Sulphur\n(c) Silver nitrate -> (iii) N, S, P, and halogen\n(d) Sodium fusion extract with lead acetate -> (iv) Halogen Specifically",
                options = listOf("(a)-(iii), (b)-(i), (c)-(ii), (d)-(iv)", "(a)-(i), (b)-(iv), (c)-(iii), (d)-(ii)", "(a)-(iii), (b)-(i), (c)-(iv), (d)-(ii)", "(a)-(i), (b)-(ii), (c)-(iv), (d)-(iii)"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\nLassaigne's test detects N,S,P, halogens. Cu(II) oxide is used to detect Carbon. AgNO3 detects halogens. Sodium fusion extract with lead acetate detects Sulphur.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q47_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Chemistry Q47]\nThe INCORRECT statements below regarding colloidal solutions is :",
                options = listOf("A colloidal solution shows colligative properties.", "An ordinary filter paper can stop the flow of colloidal particles.", "The flocculating power of Al3+ is more than that of Na+.", "A colloidal solution shows Brownian motion of colloidal particles."),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2\nSolution:\nColloidal particles can pass through ordinary filter paper, so it cannot stop their flow.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q48_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Chemistry Q48]\nArrange in increasing order of spin only magnetic moment:\n(a) (NH4)2[Ce(NO3)6]\n(b) Gd(NO3)3\n(c) Eu(NO3)3",
                options = listOf("(b) < (a) < (c)", "(c) < (a) < (b)", "(a) < (b) < (c)", "(a) < (c) < (b)"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4\nSolution:\nCe(IV) has 0 unpaired electrons. Eu(III) has 6 unpaired electrons. Gd(III) has 7 unpaired electrons. So a < c < b.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q49_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Chemistry Q49]\nThe exact volumes of 1 M NaOH solution required to neutralise 50 mL of 1 M H3PO3 solution and 100 mL of 2 M H3PO2 solution, respectively, are :",
                options = listOf("100 mL and 100 mL", "100 mL and 50 mL", "100 mL and 200 mL", "50 mL and 50 mL"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\nH3PO3 is dibasic, so 50 * 1 * 2 = 100 mmol NaOH = 100 mL.\nH3PO2 is monobasic, so 100 * 2 * 1 = 200 mmol NaOH = 200 mL.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q50_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Chemistry Q50]\n2-cyanoanisole reacts with C6H5MgBr, followed by hydrolysis. The major product X is :",
                options = listOf("2-aminomethylanisole", "2-benzoylphenol", "2-benzoylanisole", "2-benzylphenol"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\nGrignard reagent reacts with the cyano group to form an imine salt, which on hydrolysis yields a ketone (benzoyl group). So 2-benzoylanisole.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q51_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Chemistry Q51]\nGa (atomic mass 70) crystallizes in a hexagonal close packed structure. The total number of voids in 0.581 g of Ga is _______ * 10^21.",
                options = listOf("10", "15", "20", "25"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 15\nSolution:\nMoles = 0.581/70. Voids = 3 * Moles * N_A = 3 * 0.581/70 * 6.022e23 = 14.99e21 ~ 15.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q52_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Chemistry Q52]\nA 5.0 m mol dm^-3 aqueous solution of KCl has a conductance of 0.55 mS when measured in a cell constant 1.3 cm^-1. The molar conductivity of this solution is _______ mSm^2 mol^-1.",
                options = listOf("143", "71", "105", "215"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 143\nSolution:\nk = G * l/A = 0.55 * 1.3 = 0.715 mS cm^-1. Lambda_m = k * 1000 / M = 0.715 * 1000 / 5.0 = 143.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q53_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Chemistry Q53]\nA and B decompose via first order kinetics with half-lives 54.0 min and 18.0 min respectively. Starting from an equimolar non reactive mixture of A and B, the time taken for the concentration of A to become 16 times that of B is ______ min.",
                options = listOf("108", "54", "36", "72"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 108\nSolution:\n(1/2)^{t/54} = 16 * (1/2)^{t/18} => 2^{-t/54} = 2^{4 - t/18} => -t/54 = 4 - t/18 => 2t/54 = 4 => t = 108 min.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q54_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Chemistry Q54]\nIn Duma's method of estimation of nitrogen, 0.1840 g of an organic compound gave 30 mL of nitrogen collected at 287 K and 758 mm of Hg pressure. The percentage composition of nitrogen in the compound is ______. (Aqueous tension = 14 mm Hg)",
                options = listOf("19", "25", "15", "22"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 19\nSolution:\nP_N2 = 758 - 14 = 744 mm. V_STP = (744 * 30 / 287) * (273 / 760) = 27.94 mL. Mass = 28 * 27.94 / 22400 = 0.0349 g. % = 0.0349 / 0.184 * 100 = 18.97% ~ 19%.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q55_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Chemistry Q55]\nThe number of orbitals with n = 5, m_l = + 2 is______.",
                options = listOf("3", "4", "2", "5"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 3\nSolution:\nFor n=5, l can be 0, 1, 2, 3, 4. m_l = +2 is possible for l = 2, 3, 4. So there are 3 orbitals.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q56_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Chemistry Q56]\nAt 363 K, the vapour pressure of A is 21 kPa and that of B is 18 kPa. One mole of A and 2 moles of B are mixed. Assuming ideal solution, the vapour pressure of the mixture is ________ kPa.",
                options = listOf("19", "20", "18", "21"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 19\nSolution:\nP_T = X_A P_A^0 + X_B P_B^0 = 1/3 * 21 + 2/3 * 18 = 7 + 12 = 19 kPa.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q57_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Chemistry Q57]\nSulphurous acid (H2SO3) has Ka1 = 1.7 * 10^-2 & Ka2 = 6.4 * 10^-8. The pH of 0.588 M H2SO3 is _______.",
                options = listOf("1", "2", "3", "4"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1\nSolution:\nKa1 = x^2 / (c - x). x^2 + 0.017x - 0.01 = 0 => x = 0.0918. pH = -log(0.0918) = 1.03 ~ 1.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q58_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Chemistry Q58]\nWhen 35 mL of 0.15 M lead nitrate solution is mixed with 20 mL of 0.12 M chromic sulphate solution, ________ * 10^-5 moles of lead sulphate precipitate out.",
                options = listOf("525", "250", "300", "400"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 525\nSolution:\nMmoles of Pb2+ = 35 * 0.15 = 5.25. Mmoles of SO4 2- = 20 * 0.12 * 3 = 7.2. Pb2+ is limiting. Moles of PbSO4 = 5.25 mmol = 525 * 10^-5.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q59_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Chemistry Q59]\nAt 25C, 50 g of iron reacts with HCl to form FeCl2. The evolved hydrogen gas expands against a constant pressure of 1 bar. The work done by the gas during this expansion is _______ J. (Assume, hydrogen is an ideal gas)",
                options = listOf("2218", "1500", "1200", "2500"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 2218\nSolution:\nMoles of H2 = moles of Fe = 50 / 55.85 = 0.895 mol. Work done BY gas = P dV = n R T = 0.895 * 8.314 * 298 = 2218 J.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q60_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Chemistry Q60]\n[Ti(H2O)6]^3+ absorbs light of wavelength 498 nm during a d-d transition. The octahedral splitting energy for the above complex is _____ * 10^-19 J.",
                options = listOf("4", "3", "5", "6"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 4\nSolution:\nE = hc / lambda = 6.626e-34 * 3e8 / 498e-9 = 3.99e-19 ~ 4 * 10^-19 J.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q61_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Mathematics Q61]\nThe number of elements in the set {x in R : (|x| . 3) |x + 4| = 6} is equal to",
                options = listOf("3", "2", "4", "1"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2\nSolution:\nIf x >= 0, (x-3)(x+4)=6 => x^2+x-18=0 => x = (-1+sqrt(73))/2 (1 root).\nIf x < 0, (-x-3)(-x+4)=6 => (x+3)(x-4)=-6 => x^2-x-6=0 => (x-3)(x+2)=0 => x=-2 (1 root).\nTotal 2 roots.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q62_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Mathematics Q62]\nLet a vector alpha i + beta j be obtained by rotating the vector sqrt(3) i + j by an angle 45 deg about the origin in counterclockwise direction in the first quadrant. Then the area of triangle having vertices (alpha, beta), (0, beta) and (0, 0) is equal to-",
                options = listOf("1/2", "1", "1/sqrt(2)", "2 sqrt(2)"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1\nSolution:\nArea = 1/2 * alpha * beta = 1/2 * (2 cos 75) * (2 sin 75) = sin 150 = 1/2.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q63_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Mathematics Q63]\nIf for a > 0, the feet of perpendiculars from the points A(a, -2a, 3) and B(0, 4, 5) on the plane lx +my + nz = 0 are points C(0, -a, -1) and D respectively, then the length of line segment CD is equal to :",
                options = listOf("sqrt(31)", "sqrt(41)", "sqrt(55)", "sqrt(66)"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4\nSolution:\nC lies on plane: -ma-n=0. Plane turns out to be x - y + 2z = 0. Foot D of B on this plane is (-1, 5, 3). Length CD = sqrt(1^2 + (-7)^2 + (-4)^2) = sqrt(66).""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q64_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Mathematics Q64]\nConsider three observations a, b and c such that b = a + c. If the standard deviation of a + 2, b + 2, c + 2 is d, then which of the following is true ?",
                options = listOf("b^2 = 3(a^2 + c^2) + 9d^2", "b^2 = a^2 + c^2 + 3d^2", "b^2 = 3(a^2 + c^2 + d^2)", "b^2 = 3(a^2 + c^2) - 9d^2"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4\nSolution:\nd^2 = Var(a,b,c) = (a^2+b^2+c^2)/3 - (2b/3)^2 => 9d^2 = 3(a^2+b^2+c^2) - 4b^2 => b^2 = 3(a^2+c^2) - 9d^2.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q65_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Mathematics Q65]\nIf for x in (0, pi/2), log10 sinx + log10 cosx = -1 and log10(sinx + cosx) = 1/2 (log10 n - 1), n > 0, then the value of n is equal to :",
                options = listOf("20", "12", "9", "16"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2\nSolution:\nsinx cosx = 1/10. (sinx+cosx)^2 = n/10 => 1 + 2 sinx cosx = n/10 => 1 + 2/10 = n/10 => n=12.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q66_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Mathematics Q66]\nLet, A = [i -i; -i i], i = sqrt(-1). Then the system of linear equations A^8 [x; y] = [8; 64] has -",
                options = listOf("A unique solution", "Infinitely many solutions", "No solution", "Exactly two solutions"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\nA^2 = 2A, A^8 = 2^7 A = 128 A. This gives 128 i (x - y) = 8 and -128 i (x - y) = 64, which is a contradiction. Hence, no solution.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q67_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Mathematics Q67]\nIf the three normals drawn to the parabola, y^2 = 2x pass through the point (a, 0) a != 0, then 'a' must be greater than :",
                options = listOf("1/2", "-1/2", "-1", "1"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4\nSolution:\nFor three real normals to pass through (a, 0), a > L.R./2 = 2/2 = 1. So a > 1.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q68_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Mathematics Q68]\nLet P and Q have pos vectors 3i - j + 2k and i + 2j - 4k. Lines PR and QS intersect at T, with direction ratios (4, -1, 2) and (-2, 1, -2). If TA is perpendicular to both lines and |TA| = sqrt(5), modulus of position vector of A is :",
                options = listOf("sqrt(482)", "sqrt(171)", "sqrt(5)", "sqrt(227)"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2\nSolution:\nT is found to be (11, -3, 6). Normal direction is 2j + k. A = T +/- (2j+k). |A|^2 = 121 + 1 + 49 = 171.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q69_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Mathematics Q69]\nLet f(x) = {x+2, x<0; x^2, x>=0} and g(x) = {x^3, x<1; 3x-2, x>=1}. The number of points where fog(x) is NOT differentiable is:",
                options = listOf("3", "1", "0", "2"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2\nSolution:\nfog(x) is continuous and differentiable everywhere except at x=0, where left limit is 2 and right limit is 0 (discontinuous).""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q70_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Mathematics Q70]\nWhich of the following Boolean expression is a tautology ?",
                options = listOf("(p ^ q) v (p v q)", "(p ^ q) v (p -> q)", "(p ^ q) ^ (p -> q)", "(p ^ q) -> (p -> q)"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4\nSolution:\n(p ^ q) -> (p -> q) is always true since p ^ q implies p, which implies p -> q.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q71_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Mathematics Q71]\nLet a complex number z, |z| != 1, satisfy log_{1/sqrt(2)} ((|z| + 11) / (|z| - 1)^2) <= 2. Then, the largest value of |z| is equal to _____ .",
                options = listOf("8", "7", "6", "5"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2\nSolution:\n(|z|+11)/(|z|-1)^2 >= 1/2 => |z|^2 - 4|z| - 21 <= 0 => (|z|-7)(|z|+3) <= 0 => |z| <= 7.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q72_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Mathematics Q72]\nIf n is the number of irrational terms in the expansion of (3^{1/4} + 5^{1/8})^{60}, then (n-1) is divisible by :",
                options = listOf("26", "30", "8", "7"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1\nSolution:\nRational terms require r to be a multiple of 8. There are 8 such terms. Irrational terms = 61 - 8 = 53 = n. n-1 = 52, which is divisible by 26.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q73_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Mathematics Q73]\nLet P be a plane lx + my + nz = 0 containing the line (1-x)/1 = (y+4)/2 = (z+2)/3. If plane P divides the line segment AB joining A(-3,-6,1) and B(2,4,-3) in ratio k:1, then k is:",
                options = listOf("1.5", "3", "2", "4"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\nPlane P is 8x + y + 2z = 0. A(-3,-6,1) gives -24-6+2 = -28. B(2,4,-3) gives 16+4-6 = 14. k = 28/14 = 2.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q74_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Mathematics Q74]\nThe range of a in R for which f(x) = (4a - 3) (x + ln 5) + 2(a - 7) cot(x/2) sin^2(x/2) has critical point, is -",
                options = listOf("(-3, 1)", "[-4/3, 2)", "[1, inf)", "[-inf,-1)"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2\nSolution:\nf'(x) = 4a-3 + (a-7)cosx = 0. cosx = (3-4a)/(a-7). Since cosx in [-1, 1), we get a in [-4/3, 2).""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q75_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Mathematics Q75]\nA pack of cards has one card missing. Two cards are drawn randomly and are found to be spades. The probability that the missing card is not a spade, is :",
                options = listOf("3/4", "52/867", "39/50", "22/425"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\nBy Bayes theorem, P = (3/4 * 13C2 / 51C2) / (1/4 * 12C2 / 51C2 + 3/4 * 13C2 / 51C2) = 39/50.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q76_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Mathematics Q76]\nLet (1 - x + x^3)^n = sum_{j=0}^{3n} a_j x^j. Then sum a_{2j} + 4 sum a_{2j+1} is equal to -",
                options = listOf("2", "2^{n-1}", "1", "n"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\nx=1 gives sum a_j = 1. x=-1 gives sum (-1)^j a_j = 1. Adding gives 2 sum a_{2j} = 2 => sum a_{2j} = 1. Subtracting gives sum a_{2j+1} = 0. Result is 1 + 0 = 1.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q77_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Mathematics Q77]\nIf y = y(x) is the solution of the differential equation, dy/dx + 2y tan x = sin x, y(pi/3) = 0, then the maximum value of the function y(x) over R is equal to :",
                options = listOf("8", "1/2", "-15/4", "1/8"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4\nSolution:\nIF = sec^2 x. y = cos x - 2 cos^2 x. Max value occurs when cos x = 1/4, y_max = 1/4 - 2(1/16) = 1/8.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q78_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Mathematics Q78]\nThe locus of the midpoints of the chord of the circle, x^2 + y^2 = 25 which is tangent to the hyperbola, x^2/9 - y^2/16 = 1 is :",
                options = listOf("(x^2 + y^2)^2 - 16x^2 + 9y^2 = 0", "(x^2 + y^2)^2 - 9x^2 + 144y^2 = 0", "(x^2 + y^2)^2 - 9x^2 - 16y^2 = 0", "(x^2 + y^2)^2 - 9x^2 + 16y^2 = 0"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4\nSolution:\nChord midpoint (h,k) gives eq hx + ky = h^2 + k^2. Condition for tangency to hyperbola yields (h^2+k^2)^2 = 9h^2 - 16k^2.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q79_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Mathematics Q79]\nThe number of roots of the equation, (81)^{sin^2 x} + (81)^{cos^2 x} = 30 in the interval [0, pi] is equal to :",
                options = listOf("3", "4", "8", "2"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2\nSolution:\nLet 81^{sin^2 x} = t. t + 81/t = 30 => t^2 - 30t + 81 = 0. t = 3, 27. sin^2 x = 1/4 or 3/4. x = pi/6, 5pi/6, pi/3, 2pi/3. Total 4 roots.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q80_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Mathematics Q80]\nLet S_k = sum_{r=1}^k tan^{-1} (6^r / (2^{2r+1} + 3^{2r+1})). then lim_{k->inf} S_k is equal to -",
                options = listOf("tan^-1(3/2)", "pi/2", "cot^-1(3/2)", "tan^-1(3)"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\nLimiting sum simplifies to cot^-1(3/2).""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q81_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Mathematics Q81]\nConsider an AP and a GP having four initial terms from {11, 8, 21, 16, 26, 32, 4}. If last terms are maximum possible 4-digit numbers, number of common terms is ______ .",
                options = listOf("2", "3", "4", "5"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 3\nSolution:\nGP: 4, 8, 16, 32... AP: 11, 16, 21, 26... Common terms are 16, 256, 4096. Total 3 terms.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q82_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Mathematics Q82]\nLet f : (0, 2) -> R be defined as f(x) = log2 (1 + tan(pi x / 4)). Then, lim_{n->inf} 2/n (f(1/n) + f(2/n) + ..... + f(1)) is equal to _______ .",
                options = listOf("0.5", "1", "1.5", "2"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 1\nSolution:\nf(x) + f(1-x) = 1. By pairing terms, the sum limits to 1.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q83_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Mathematics Q83]\nLet ABCD be a square of unit length. Circle C1 at A has radius 1. Circle C2 touches C1, AD, AB. Tangent from C to C2 meets AB at E. Length of EB is alpha + 3 beta. alpha + beta is ______.",
                options = listOf("0", "1", "2", "3"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 1\nSolution:\nEB = 2 - sqrt(3). alpha = 2, beta = -1. alpha + beta = 1.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q84_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Mathematics Q84]\nIf lim_{x->0} (ae^x - b cos x + ce^{-x}) / (x sin x) = 2, then a + b + c is equal to _______.",
                options = listOf("2", "3", "4", "5"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 4\nSolution:\na - b + c = 0, a - c = 0, a/2 + b/2 + c/2 = 2. Solving gives a + b + c = 4.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q85_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Mathematics Q85]\nThe total number of 3 x 3 matrices A having entries from {0, 1, 2, 3} such that sum of diagonal entries of A A^T is 9, is _____",
                options = listOf("500", "766", "1024", "256"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 766\nSolution:\nSum of squares of elements = 9. Total matrices = 1 (all 1s) + 9 (one 3) + 504 (one 2, five 1s) + 252 (two 2s, one 1) = 766.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q86_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Mathematics Q86]\nLet P and A be defined. det((P^{-1} A P - I3)^2) = alpha w^2. value of alpha is ______ .",
                options = listOf("36", "18", "12", "24"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 36\nSolution:\ndet((A - I)^2) = 36 w^2. So alpha = 36.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q87_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Mathematics Q87]\nIf the normal to y(x) = int_0^x (2t^2 - 15t + 10) dt at (a, b) is parallel to x + 3y = -5, a > 1, then |a + 6b| is ________ .",
                options = listOf("400", "406", "412", "420"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 406\nSolution:\ny'(a) = 3 => 2a^2 - 15a + 10 = 3 => a = 7. b = y(7) = -413/6. |a + 6b| = |7 - 413| = 406.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q88_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Mathematics Q88]\nLet y(x) solve dy/dx = 2(x + 1). Area bounded by curve and x-axis is 4 sqrt(8) / 3. value of y(1) is _______ .",
                options = listOf("1", "2", "3", "4"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2\nSolution:\ny = (x+1)^2 + C. Area = 4/3 (-C)^{3/2} = 4/3 8^{1/2} => C = -2. y(1) = 2^2 - 2 = 2.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q89_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Mathematics Q89]\nLet f(x) + f(x + 1) = 2. I1 = int_0^8 f(x) dx, I2 = int_{-1}^3 f(x) dx, then I1 + 2I2 is _______ .",
                options = listOf("12", "16", "20", "24"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 16\nSolution:\nI1 = 4 * 2 = 8. I2 = 2 * 2 = 4. I1 + 2I2 = 8 + 8 = 16.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q90_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 2 Shift 2 - Mathematics Q90]\nLet w = z z_bar - 2z + 2, |(z + i) / (z - 3i)| = 1 and Re(w) has minimum value. Then minimum n in N for which w^n is real is ______ .",
                options = listOf("2", "3", "4", "5"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 4\nSolution:\nz = x + i. w = x^2 - 2x + 3 - 2i. Re(w) minimum at x=1. w = 2 - 2i. w^n is real for min n=4.""",
                difficulty = "Medium"
            ),
        )
    }
}
