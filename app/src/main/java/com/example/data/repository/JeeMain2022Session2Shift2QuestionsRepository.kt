package com.example.data.repository
import com.example.model.Question
object JeeMain2022Session2Shift2QuestionsRepository {
    fun getQuestions(testId: String): List<Question> {
        return listOf(
            Question(
                id = "${testId}_s2_sh2_q1_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Physics Q1]\\nIn AM modulation, a signal is modulated on a carrier wave such that maximum and minimum amplitudes are found to be 6 V and 2 V respectively. The modulation index is",
                options = listOf("100%", "80%", "60%", "50%"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q2_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Physics Q2]\\nThe electric current in a circular coil of 2 turns produces a magnetic induction B1 at its centre. The coil is unwound and is rewound into a circular coil of 5 turns and the same current produces a magnetic induction B2 at its centre. The ratio of B2 / B1 is-",
                options = listOf("5/2", "25/4", "5/4", "25/2"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q3_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Physics Q3]\\nA drop of liquid of density p is floating half immersed in a liquid of density o and surface tension 7.5 x 10^-4 N cm^-1. The radius of drop in cm will be (g = 10 ms^-2)",
                options = listOf("15 / sqrt(2p - o)", "15 / sqrt(p - o)", "3 / (2sqrt(p - o))", "3 / (20sqrt(2p - o))"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q4_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Physics Q4]\\nTwo billiard balls of mass 0.05 kg each moving in opposite directions with 10 ms^-1 collide and rebound with the same speed. If the time duration of contact is t = 0.005 s, then what is the force exerted on the ball due to each other ?",
                options = listOf("100 N", "200 N", "300 N", "400 N"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q5_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Physics Q5]\\nFor a free body diagram shown in the figure, the four forces are applied in the 'x' and 'y' directions. What additional force must be applied and at what angle with positive x-axis so that net acceleration of body is zero?\n(1) sqrt(2) N, 45deg (2) sqrt(2) N, 135deg (3) 2/sqrt(3) N, 30deg (4) 2 N, 45deg",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q6_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Physics Q6]\\nCapacitance of an isolated conducting sphere of radius R1 becomes n times when it is enclosed by a concentric conducting sphere of radius R2 connected to earth. The ratio of their radii (R2/R1) is-",
                options = listOf("n / (n - 1)", "2n / (2n + 1)", "(n + 1) / n", "(2n + 1) / n"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q7_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Physics Q7]\\nThe ratio of wavelengths of proton and deuteron accelerated by potential Vp and Vd is 1 : sqrt(2). Then, the ratio of Vp to Vd will be:\n(1) 1 : 1 (2) sqrt(2) : 1 (3) 2 : 1 (4) 4 : 1",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 4\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q8_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Physics Q8]\\nFor an object placed at a distance 2.4 m from a lens, a sharp focused image is observed on a screen placed at a distance 12 cm form the lens. A glass plate of refractive index 1.5 and thickness 1 cm is introduced between lens and screen such that the glass plate plane faces parallel to the screen. By what distance should the object be shifted so that a sharp focused image is observed again on the screen?",
                options = listOf("0.8 m", "3.2 m", "1.2 m", "5.6 m"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q9_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Physics Q9]\\nLight wave traveling in air along x-direction is given by Ey = 540 sin pi x 10^4 (x - ct) Vm^-1. Then, the peak value of magnetic field of wave will be (Given c = 3 x 10^8 ms^-1)",
                options = listOf("18 x 10^-7 T", "54 x 10^-7 T", "54 x 10^-8 T", "18 x 10^-8 T"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q10_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Physics Q10]\\nWhen you walk through a metal detector carrying a metal object in your pocket, it raises an alarm. This phenomenon works on:",
                options = listOf("Electromagnetic induction", "Resonance in ac circuits", "Mutual induction in ac circuits", "Interference of electromagnetic waves"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q11_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Physics Q11]\\nAn electron with energy 0.1 keV moves at right angle to the earth's magnetic field of 1 x 10^-4 Wbm^-2. The frequency of revolution of the electron will be (Take mass of electron = 9.0 x 10^-31 kg)",
                options = listOf("1.6 x 10^5 Hz", "5.6 x 10^5 Hz", "2.8 x 10^6 Hz", "1.8 x 10^6 Hz"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q12_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Physics Q12]\\nA current of 15 mA flows in the circuit as shown in figure. The value of potential difference between the points A and B will be",
                options = listOf("50 V", "75 V", "150 V", "275 V"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q13_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Physics Q13]\\nThe length of a seconds pendulum at a height h = 2R from earth surface will be (Given R = Radius of earth and acceleration due to gravity at the surface of earth, g = pi^2 ms^-2)",
                options = listOf("2/9 m", "4/9 m", "8/9 m", "1/9 m"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q14_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Physics Q14]\\nSound travels in a mixture of two moles of helium and n moles of hydrogen. If rms speed of gas molecules in the mixture is sqrt(2) times the speed of sound, then the value of n will be\n(1) 1 (2) 2 (3) 3 (4) 4",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q15_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Physics Q15]\\nLet n1 is the efficiency of an engine at T1 = 447degC and T2 = 147degC while n2 is the efficiency at T1 = 947degC and T2 = 47degC. The ratio n1/n2 will be",
                options = listOf("0.41", "0.56", "0.73", "0.70"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q16_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Physics Q16]\\nAn object is taken to a height above the surface of earth at a distance 5/4 R from the centre of the earth. Where radius of earth, R = 6400 km. The percentage decrease in the weight of the object will be",
                options = listOf("36%", "50%", "64%", "25%"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q17_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Physics Q17]\\nA bag of sand of mass 9.8 kg is suspended by a rope. A bullet of 200 g travelling with speed 10 ms^-1 gets embedded in it, then loss of kinetic energy will be",
                options = listOf("4.9 J", "9.8 J", "14.7 J", "19.6 J"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q18_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Physics Q18]\\nA ball is projected from the ground with a speed 15 ms^-1 at an angle 0 with horizontal so that its range and maximum height are equal, then 'tan 0' will be equal to",
                options = listOf("1/4", "1/2", "2", "4"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q19_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Physics Q19]\\nThe maximum error in the measurement of resistance, current and time for which current flows in an electrical circuit are 1%, 2% and 3% respectively. The maximum percentage error in the detection of the dissipated heat will be",
                options = listOf("2", "4", "6", "8"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q20_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Physics Q20]\\nHydrogen atom from excited state comes to the ground state by emitting a photon of wavelength l. The value of principal quantum number 'n' of the excited state will be, (R: Rydberg constant)",
                options = listOf("sqrt(lR / (l - 1))", "sqrt(lR / (lR - 1))", "sqrt(l / (lR - 1))", "sqrt(lR^2 / (lR - 1))"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q21_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Physics Q21]\\nA particle is moving in a straight line such that its velocity is increasing at 5 ms^-1 per meter. The acceleration of the particle is _______ms^-2 at a point where its velocity is 20 ms^-1.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 100.00\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q22_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Physics Q22]\\nThree identical spheres each of mass M are placed at the corners of a right angled triangle with mutually perpendicular sides equal to 3 m each. Taking point of intersection of mutually perpendicular sides as origin, the magnitude of position vector of centre of mass of the system will be sqrt(x) m. The value of x is _______",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 2.00\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q23_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Physics Q23]\\nA block of ice of mass 120 g at temperature 0degC is put in 300 g of water at 25degC. The x g of ice melts as the temperature of the water reaches 0degC. The value of x is _______. [Use specific heat capacity of water = 4200 Jkg^-1K^-1, Latent heat of ice = 3.5 x10^5 Jkg^-1]",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 90.00\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q24_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Physics Q24]\\n(x+4)/x is the ratio of energies of photons produced due to transition of an electron of hydrogen atom from its (i) Third permitted energy level to the second level and (ii) The highest permitted energy level to the second permitted level. The value of x will be ______.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 5.00\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q25_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Physics Q25]\\nIn a potentiometer arrangement, a cell of emf 1.20 V gives a balance point at 36 cm length of wire. This cell is now replaced by another cell of emf 1.80 V. The difference in balancing length of potentiometer wire in above conditions will be _______ cm.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 18.00\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q26_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Physics Q26]\\nTwo ideal diodes are connected in the network as shown is figure. The equivalent resistance between A and B is ___ O.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 25.00\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q27_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Physics Q27]\\nTwo waves executing simple harmonic motions travelling in the same direction with same amplitude and frequency are superimposed. The resultant amplitude is equal to the sqrt(3) times of amplitude of individual motions. The phase difference between the two motions is____ (degree).",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 60.00\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q28_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Physics Q28]\\nTwo parallel plate capacitors of capacity C and 3C are connected in parallel combination and charged to a potential difference 18 V. The battery is then disconnected and the space between the plates of the capacitor of capacity C is completely filled with a material of dielectric constant 9. The final potential difference across the combination of capacitors will be ____ V.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 6.00\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q29_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Physics Q29]\\nA convex lens of focal length 20 cm is placed in front of a convex mirror with principal axis coinciding each other. The distance between the lens and mirror is 10 cm. A point object is placed on principal axis at a distance of 60 cm from the convex lens. The image formed by combination coincides the object itself. The focal length of the convex mirror is_______cm.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 10.00\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q30_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Physics Q30]\\nMagnetic flux (in weber) in a closed circuit of resistance 20 O varies with time t(s) as p = 8t^2 - 9t + 5. The magnitude of the induced current at t = 0.25 s will be _____ mA.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 250.00\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q31_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Chemistry Q31]\\nMatch List-I with List-II :\nList-I (Molecule) List-II (Hybridization, shape)\n(a) XeO3 (I) sp^3d; linear\n(b) XeF2 (II) sp^3; pyramidal\n(c) XeOF4 (III) sp^3d^3; distorted octahedral\n(d) XeF6 (IV) sp^3d^2; square pyramidal\nChoose the correct answer from the options given below:",
                options = listOf("a-II, b-I, c-IV, d-III", "a-II, b-IV, c-III, d-I", "a-IV, b-II, c-III, d-I", "a-IV, b-II, c-I, d-III"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q32_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Chemistry Q32]\\nTwo solutions A and B are prepared by dissolving 1 g of non-volatile solutes X and Y, respectively in 1 kg of water. The ratio of depression in freezing points for A and B is found to be 1 : 4. The ratio of molar masses of X and Y is",
                options = listOf("1 : 4", "1 : 0.25", "1 : 0.20", "1 : 5"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q33_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Chemistry Q33]\\nKa1, Ka2 and Ka3 are the respective ionization constants for the following reactions (a), (b) and (c).\n(a) H2C2O4 <=> H+ + HC2O4-\n(b) HC2O4- <=> H+ + C2O4^2-\n(c) H2C2O4 <=> 2H+ + C2O4^2-\nThe relationship between Ka1, Ka2 and Ka3 is given as",
                options = listOf("Ka3 = Ka1 + Ka2", "Ka3 = Ka1 - Ka2", "Ka3 = Ka1 / Ka2", "Ka3 = Ka1 x Ka2"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q34_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Chemistry Q34]\\nThe molar conductivity of a conductivity cell filled with 10 moles of 20 mL NaCl solution is L_m1 and that of 20 moles another identical cell having 80 mL NaCl solution is L_m2, The conductivities exhibited by these two cells are same. The relationship between L_m2 and L_m1 is",
                options = listOf("L_m2 = 2L_m1", "L_m2 = L_m1 / 2", "L_m2 = L_m1", "L_m2 = 4L_m1"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q35_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Chemistry Q35]\\nFor micelle formation, which of the following statements are correct?\na. Micelle formation is an exothermic process.\nb. Micelle formation is an endothermic process.\nc. The entropy change is positive\nd. The entropy change is negative",
                options = listOf("a and d only", "a and c only", "b and c only", "b and d only"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q36_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Chemistry Q36]\\nThe first ionization enthalpies of Be, B, N and O follow the order",
                options = listOf("O < N < B < Be", "Be < B < N < O", "B < Be < N < O", "B < Be < O < N"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q37_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Chemistry Q37]\\nGiven below are two statements.\nStatement-I : Pig iron is obtained by heating cast iron with scrap iron.\nStatement-II : Pig iron has a relatively lower carbon content than that of cast iron. \nIn the light of the above statements, choose the correct answer from the options given below.",
                options = listOf("Both Statement-I and Statement-II are correct", "Both Statement-I and Statement-II are not correct.", "Statement-I is correct but Statement-II is not correct", "Statement-I is not correct but Statement-II is correct"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q38_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Chemistry Q38]\\nHigh purity (>99.95%) dihydrogen is obtained by",
                options = listOf("Reaction of zinc with aqueous alkali", "Electrolysis of acidified water using platinum electrodes", "Electrolysis of warm aqueous barium hydroxide solution between nickel electrodes", "Reaction of zinc with dilute acid"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q39_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Chemistry Q39]\\nThe correct order of density is",
                options = listOf("Be > Mg > Ca > Sr", "Sr > Ca > Mg > Be", "Sr > Be > Mg > Ca", "Be > Sr > Mg > Ca"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q40_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Chemistry Q40]\\nThe total number of acidic oxides from the following list is\nNO, N2O, B2O3, N2O5, CO, SO3, P4O10",
                options = listOf("3", "4", "5", "6"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q41_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Chemistry Q41]\\nThe correct order of energy of absorption for the following metal complexes is\nA : [Ni(en)3]^2+, B : [Ni(NH3)6]^2+, C : [Ni(H2O)6]^2+",
                options = listOf("C < B < A", "B < C < A", "C < A < B", "A < C < B"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q42_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Chemistry Q42]\\nMatch List-I with List-II :\nList-I List-II\n(a) Sulphate (I) Pesticide\n(b) Fluoride (II) Bending of bones\n(c) Nicotine (III) Laxative effect\n(d) Sodium arsinite (IV) Herbicide\nChoose the correct answer from the options given below:",
                options = listOf("a-II, b-III, c-IV, d-I", "a-IV, b-III, c-II, d-I", "a-III, b-II, c-I, d-IV", "a-III, b-II, c-IV, d-I"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q43_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Chemistry Q43]\\nMajor product of the following reaction is\n(Reactant: ethyl pent-4-enoate + 2 HBr)",
                options = listOf("...", "...", "...", "..."),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q44_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Chemistry Q44]\\nWhat is the major product of the following reaction?\n(Reactant with -OH/H2O)",
                options = listOf("...", "...", "...", "..."),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q45_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Chemistry Q45]\\nArrange the following in decreasing acidic strength\na (p-nitrophenol), b (m-nitrophenol), c (m-methoxyphenol), d (p-methoxyphenol)",
                options = listOf("a > b > c > d", "b > a > c > d", "d > c > a > b", "d > c > b > a"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q46_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Chemistry Q46]\\nCH3 - CH2 - CN --(CH3MgBr/Ether)--> A --(H3O+)--> B --(Zn-Hg/HCl)--> C\nThe correct structure of C is",
                options = listOf("CH3 - CH2 - CH2 - CH3", "CH3 - CH2 - C(=O) - CH3", "CH3 - CH2 - CH(OH) - CH3", "CH3 - CH2 - CH = CH2"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q47_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Chemistry Q47]\\nMatch List-I with List-II\nList-I (Polymer) List-II (Used for items)\n(a) Nylon 6, 6 (I) Buckets\n(b) Low density polythene (II) Non-stick utensils\n(c) High density polythene (III) Bristles of brushes\n(d) Teflon (IV) Toys\nChoose the correct answer from the options given below:",
                options = listOf("a-III, b-I, c-IV, d-II", "a-III, b-IV, c-I, d-II", "a-II, b-I, c-IV, d-III", "a-II, b-IV, c-I, d-III"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q48_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Chemistry Q48]\\nGlycosidic linkage between C1 of a-glucose and C2 of b-fructose is found in",
                options = listOf("maltose", "sucrose", "lactose", "amylose"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q49_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Chemistry Q49]\\nSome drugs bind to a site other than the active site of an enzyme. This site is known as",
                options = listOf("non-active site", "allosteric site", "competitive site", "therapeutic site"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q50_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Chemistry Q50]\\nIn base vs. acid titration, at the end point methyl orange is present as",
                options = listOf("quinonoid form", "heterocyclic form", "phenolic form", "benzenoid form"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q51_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Chemistry Q51]\\n56.0 L of nitrogen gas is mixed with excess of hydrogen gas and it is found that 20 L of ammonia gas is produced. The volume of unused nitrogen gas is found to be ____ L.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 46\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q52_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Chemistry Q52]\\nA sealed flask with a capacity of 2 dm^3 contains 11 g of propane gas. The flask is so weak that it will burst if the pressure becomes 2 MPa. The minimum temperature at which the flask will burst is _______degC. [Nearest integer] (Given: R = 8.3 JK^-1 mol^-1, Atomic masses of C and H are 12u and 1u, respectively.) (Assume that propane behaves as an ideal gas.)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 1655\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q53_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Chemistry Q53]\\nWhen the excited electron of a H atom from n = 5 drops to the ground state, the maximum number of emission lines observed are ____.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 10\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q54_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Chemistry Q54]\\nWhile performing a thermodynamics experiment, a student made the following observations.\nHCl + NaOH -> NaCl + H2O; dH = - 57.3 kJ mol^-1\nCH3COOH + NaOH -> CH3COONa + H2O; dH = -55.3 kJ mol^-1\nThe enthalpy of ionization of CH3COOH as calculated by the student is ______ kJ mol-1. [nearest integer]",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q55_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Chemistry Q55]\\nFor the decomposition of azomethane, CH3N2CH3(g) -> CH3CH3(g) + N2(g), a first order reaction, the variation in partial pressure with time at 600 K is given as Slope = -3.465 x 10^5 in ln(p/p0) vs t. The half life of the reaction is ______ x 10^-5 s. [Nearest integer]",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q56_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Chemistry Q56]\\nThe sum of number of lone pairs of electrons present on the central atoms of XeO3, XeOF4 and XeF6, is_______ .",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 3\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q57_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Chemistry Q57]\\nThe spin-only magnetic moment value of M3+ ion (in gaseous state) from the pairs Cr3+/Cr2+, Mn3+/Mn2+, Fe3+/Fe2+ and Co3+/Co2+ that has negative standard electrode potential, is____ B.M. [Nearest integer]",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 4\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q58_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Chemistry Q58]\\nA sample of 4.5 mg of an unknown monohydric alcohol, R-OH was added to methylmagnesium iodide. A gas is evolved and is collected and its volume measured to be 3.1 mL. The molecular weight of the unknown alcohol is___ g/mol. [Nearest integer]",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 33\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q59_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Chemistry Q59]\\nThe separation of two coloured substances was done by paper chromatography. The distances travelled by solvent front, substance A and substance B from the base line are 3.25 cm, 2.08 cm and 1.05 cm, respectively. The ratio of Rf values of A to B is_____.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q60_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Chemistry Q60]\\nThe total number of monobromo derivatives formed by the alkanes with molecular formula C5H12 is (excluding stereo isomers)____.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 8\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q61_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Mathematics Q61]\\nFor z in C if the minimum value of (|z - 3sqrt(2)| + |z - psqrt(2) i|) is 5sqrt(2), then a value of p is .........\n(1) 3 (2) 7/2 (3) 4 (4) 9/2",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 3\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q62_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Mathematics Q62]\\nThe number of real values of l, such that the system of linear equations\n2x - 3y + 5z = 9\nx + 3y - z = -18\n3x - y + (l^2 - |l|)z = 16\nhas no solution, is",
                options = listOf("0", "1", "2", "4"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q63_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Mathematics Q63]\\nThe number of bijective functions f : {1, 3, 5, 7, ...., 99} -> {2, 4, 6, 8, ....., 100) such that f(3) >= f(9) >= f(15) >= f(21) >= ..... >= f(99), is ............\n(1) 50P17 (2) 50P33 (3) 33! x 17! (4) 50!/2",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q64_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Mathematics Q64]\\nThe remainder when (11)^1011 + (1011)^11 is divided by 9 is",
                options = listOf("1", "4", "6", "8"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q65_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Mathematics Q65]\\nThe sum sum_{n=1}^21 3 / ((4n - 1)(4n + 3)) is equal to",
                options = listOf("7/87", "7/29", "14/87", "21/29"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q66_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Mathematics Q66]\\nlim_{x->pi/4} (8sqrt(2) - (cos x + sin x)^7) / (sqrt(2) - sqrt(2) sin 2x) is equal to \n(1) 14 (2) 7 (3) 14sqrt(2) (4) 7sqrt(2)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q67_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Mathematics Q67]\\nlim_{n->inf} (1/2^n) (1/sqrt(1 - 1/2^n) + 1/sqrt(1 - 2/2^n) + 1/sqrt(1 - 3/2^n) + ... + 1/sqrt(1 - (2^n - 1)/2^n)) is equal to",
                options = listOf("1/2", "1", "2", "-2"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q68_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Mathematics Q68]\\nIf A and B are two events such that P(A) = 1/3, P(B) = 1/5 and P(A U B) = 1/2, then P(A|B') + P(B|A') is equal to",
                options = listOf("3/4", "5/8", "5/4", "7/8"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q69_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Mathematics Q69]\\nLet [t] denote the greatest integer less than or equal to t. Then the value of the integral integral_{-3}^101 ([sin(pi x)] + e^[cos(2pi x)]) dx is equal to",
                options = listOf("52(1 - e) / e", "52/e", "52(2 + e) / e", "104/e"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q70_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Mathematics Q70]\\nLet the point P(a, b) be at a unit distance from each of the two lines L1 : 3x - 4y + 12 = 0 and L2 : 8x + 6y + 11 = 0. If P lies below L1 and above L2, then 100(a + b) is equal to",
                options = listOf("-14", "42", "-22", "14"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q71_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Mathematics Q71]\\nLet a smooth curve y = f(x) be such that the slope of the tangent at any point (x, y) on it is directly proportional to (-y/x). If the curve passes through the points (1, 2) and (8, 1) then y(1/8) is equal to",
                options = listOf("2 loge 2", "4", "1", "4 loge 2"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q72_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Mathematics Q72]\\nIf the ellipse x^2/a^2 + y^2/b^2 = 1 meets the line x/7 + y/(2sqrt(6)) = 1 on the x-axis and the line x/7 - y/(2sqrt(6)) = 1 on the y-axis, then the eccentricity of the ellipse is",
                options = listOf("5/7", "2sqrt(6)/7", "3/7", "2sqrt(5)/7"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q73_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Mathematics Q73]\\nThe tangents at the points A(1, 3) and B(1, -1) on the parabola y^2 - 2x - 2y = 1 meet at the point P. Then the area (in unit^2) of the triangle PAB is",
                options = listOf("4", "6", "7", "8"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q74_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Mathematics Q74]\\nLet the foci of the ellipse x^2/16 + y^2/7 = 1 and the hyperbola x^2/144 - y^2/a = 1/25 coincide. Then the length of the latus rectum of the hyperbola is :",
                options = listOf("32/9", "18/5", "27/4", "27/10"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q75_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Mathematics Q75]\\nA plane E is perpendicular to the two planes 2x - 2y + z = 0 and x - y + 2z = 4, and passes through the point P(1, -1, 1). If the distance of the plane E from the point Q(a, a, 2) is 3sqrt(2), then (PQ)^2 is equal to \n(1) 9 (2) 12 (3) 21 (4) 33",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 3\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q76_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Mathematics Q76]\\nThe shortest distance between the lines (x + 7)/-6 = (y - 6)/7 = z and (7 - x)/2 = y - 2 = z - 6 is",
                options = listOf("2sqrt(29)", "1", "sqrt(37/29)", "sqrt(29)/2"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q77_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Mathematics Q77]\\nLet a = i - j + 2k and let b be a vector such that a x b = 2i - k and a.b = 3. Then the projection of b on the vector a - b is",
                options = listOf("2/sqrt(21)", "2sqrt(3/7)", "2/3 sqrt(7/3)", "2/3"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q78_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Mathematics Q78]\\nIf the mean deviation about median for the number 3, 5, 7, 2k, 12, 16, 21, 24 arranged in the ascending order, is 6 then the median is",
                options = listOf("11.5", "10.5", "12", "11"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q79_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Mathematics Q79]\\n2 sin(pi/22) sin(3pi/22) sin(5pi/22) sin(7pi/22) sin(9pi/22) is equal to",
                options = listOf("3/16", "1/16", "1/32", "9/32"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q80_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Mathematics Q80]\\nConsider the following statements :\nP : Ramu is intelligent\nQ : Ramu is rich.\nR : Ramu is not honest\nThe negation of the statement \"Ramu is intelligent and honest if and only if Ramu is not rich\" can be expressed as :",
                options = listOf("((P ^ (~R) ^ Q) ^ ((~Q) ^ ((~P) v R))", "((P ^ (R) ^ Q) v ((~Q) ^ ((~P) v (~R)))", "((P ^ R) ^ Q) ^ ((~Q) ^ ((~P) v (~R)))", "((P ^ (~R) ^ Q) v ((~Q) ^ ((~P) v R))"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q81_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Mathematics Q81]\\nLet A = {1, 2, 3, 4, 5, 6, 7}. Define B = {T subset A : either 1 not in T or 2 in T} and C = {T subset A : the sum of all the elements of T is a prime number}. Then the number of elements in the set B U C is .........",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 107\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q82_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Mathematics Q82]\\nLet f(x) be a quadratic polynomial with leading coefficient 1 such that f(0) = p, p != 0, and f(1) = 1/3. If the equations f(x) = 0 and fo fof(x) = 0 have a common real root. then f(-3) is equal to ...........",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 25\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q83_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Mathematics Q83]\\nLet A = [0 0 1; 0 1 b; 1 a a], a, b in R. If for some n in N, A^n = [0 0 1; 0 1 96; 1 48 2160] then n + a + b is equal to ..........",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 24\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q84_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Mathematics Q84]\\nThe sum of the maximum and minimum values of the function f(x) = |5x - 7| + [x^2 + 2x] in the interval [5/4, 2], where [t] is the greatest integer <= t, is ...........",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 15\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q85_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Mathematics Q85]\\nLet y = y(x) be the solution of the differential equation dy/dx = (4y^3 + 2yx^2)/(3xy^2 + x^3), y(1) = 1. If for some n in N, y(2) in [n - 1, n), then n is equal to .......",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 3\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q86_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Mathematics Q86]\\nLet f be a twice differentiable functions on R. If f'(0) = 4 and f(x) + integral_0^x (x - t) f'(t) dt = (e^2x + e^-2x) cos 2x + (2/a)x, then (2a + 1)^5 a^2 is equal to ...........",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 8\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q87_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Mathematics Q87]\\nLet an = integral_{-1}^1 (1 + x/2 + x^2/3 + ..... + x^(n-1)/n) dx for every n in N. Then the sum of all the elements of the set {n in N : an in (2, 30)} is .........",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 5\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q88_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Mathematics Q88]\\nIf the circles x^2 + y^2 + 6x + 8y + 16 = 0 and x^2 + y^2 + 2(3 - sqrt(3))x + 2(4 - sqrt(6))y = k + 6sqrt(3) + 8sqrt(6), k > 0, touch internally at the point P(a, b), then (a + sqrt(3))^2 + (b + sqrt(6))^2 is equal to .........",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 25\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q89_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Mathematics Q89]\\nThe sum of diameters of the circles that touch (i) the parabola 75x^2 = 64(5y - 3) at the point (8/5, 6/5) and (ii) the y-axis, is equal to ----",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 10\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q90_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 2 - Mathematics Q90]\\nThe line of shortest distance between the lines x/0 = (y-1)/1 = z/1 and (x-3)/2 = (y-5)/2 = (z-1)/1 makes an angle of cos^-1(sqrt(2/27)) with the plane P : ax - y - z = 0, (a > 0). If the image of the point (1, 1, -5) in the plane P is (a, b, y), then a + b - y is equal to ----.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 3\\nSolution:\\n",
                difficulty = "Medium"
            )
        )
    }
}