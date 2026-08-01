package com.example.data.repository
import com.example.model.Question
object JeeMain2023Session1Shift1QuestionsRepository {
    fun getQuestions(testId: String): List<Question> {
        return listOf(
            Question(
                id = "${testId}_s1_sh1_q1_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Physics Q1]\\nA travelling wave is described by the equation y(x, t) = [0.05 sin (8x – 4t)] m The velocity of the wave is: [all \nthe quantities are in SI unit]",
                options = listOf("8 ms–1", "0.5 ms–1", "4 ms–1", "2 ms–1"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n y(x, t) = [0.05sin(8x – 4t)] m\nSpeed of wave = \nCoefficient of x\nCoefficient of t\n= 0.5\n8\n4\n ms\n–1",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q2_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Physics Q2]\\nA circular loop of radius r is carrying current I A. The ratio of magnetic field at the center of circular loop \nand at a distance r from the center of the loop on its axis is:",
                options = listOf("2 2 :1", "1: 3 2", "3 2 : 2", "1: 2"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n2r\nI\nB\n0\nP1\n\n\n2 r\nI\n2(r r )\nIr B 5 / 2\n0\n2 2 3/ 2\n2\n0\nP2\n\n\n\n\n\n\n1\n2 2\n2 r\nI\n2r\nI\nB\nB\n5 / 2\n0\n0\nP\nP\n2\n1 \n\n\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q3_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Physics Q3]\\nConsider the following radioactive decay process\n1 2 3 4 5 6\n218\n84 A A A A A A A\n     \n \nThe mass number and the atomic number of A6 are given by:",
                options = listOf("210 and 80", "210 and 82", "210 and 84", "211 and 80"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n6\n210\n80 5\n210\n4 80\n210\n3 81\n214\n2 83\n214\n1 83\n214\n82\n218\n84 A  A  A  A  A  A  A\n     \n \nMass number = 210\nAtomic number = 80",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q4_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Physics Q4]\\nThe weight of a body at the surface of earth is 18 N. The weight of the body at an altitude of 3200 km above \nthe earth’s surface is (given, radius of earth Re = 6400 km):",
                options = listOf("8 N", "19.6 N", "9.8 N", "4.9 N"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nWearth = 18 N\nmgearth = 18\nAlso mgn = mgearth \n2\nR h\nR\n\n\n\n\n\n\n\n= \n2\n6400 3200\n6400 18 \n\n\n\n\n\n\n= 8\n9\n4\n18 ",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q5_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Physics Q5]\\nGiven below are two statements : one is labelled as Assertion A and the other is labelled as Reason R.\nAssertion A : Photodiodes are preferably operated in reverse bias condition for light intensity measurement.\nReason R : The current in the forward bias is more than the current in the reverse bias for a p – n junction \ndiode. \nIn the light of the above statements, choose the correct answer from the options given below:",
                options = listOf("Both A and R are true and R is the correct explanation of A", "A is false but R is true", "A is true but R is false", "Both A and R are true but R is NOT the correct explanation of A"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nPhotodiodes are preferably operated in reverse bias condition for light intensity measurement because it \nincreases the width of depletion layer, therefore both are correct but not the correct explanation.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q6_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Physics Q6]\\nGiven below are two statements :\nStatement I : If the Brewster's angle for the light propagating from air to glass is B, then the Brewster's \nangle for the light propagating from glass to air is B\n2\n \n\nStatement II : The Brewster's angle for the light propagating from glass to air is tan–1\n (μg) where μg is the \nrefractive index of glass. In the light of the above statements, choose the correct answer from the options \ngiven below:",
                options = listOf("Both statement I and Statement II are true", "Both statement I and statement II are false", "Statement I is true but statement II is false", "Statement I is false but statement Il is true"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nCase I :\nTransmitted is  to reflected\ni + r = 90°\nSnell's law\nasin i = gsin r\na\ng\ntan i\n\n\n\nB\na\n1 g\ni tan  \n\n\n\n\n\n\n\n\n\n\n\n\nCase II : \ni + r = 90° as transmitted is  to reflected.\ntan i = B\ng\n1 a\ng\na\n2\ni tan  \n\n\n\n  \n\n ",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q7_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Physics Q7]\\nA modulating signal is a square wave, as shown in the figure.\nIf the carrier wave is given as c(t) = 2 sin (8t) volts, the modulation index is:",
                options = listOf("2\n1", "4\n1", "1", "3\n1"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nAm = Amplitude of modulating wave = 1 volt\nAc = Amplitude of carrier wave = 2 volt\nModulation index = \n2\n1\n2\n1\nA\nA\nc\nm  ",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q8_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Physics Q8]\\nAs shown in the figure, a network of resistors is connected to a battery of 24V with an internal resistance of \n3. The currents through the resistors R4 and R5 are I4 and I5 respectively. The values of I4 and I5 are:",
                options = listOf("A\n5\n8\nI\n4  and A\n5\n2\nI\n5 ", "A\n5\n24 I\n4  and A\n5\n6\nI\n5 ", "A\n5\n2\nI\n4  and A\n5\n8\nI\n5 ", "A\n5\n6\nI\n4  and A\n5\n24 I\n5 "),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nR r\nR R\nR R\nR\nR R\nR R\nR 6\n5 4\n4 5\n3\n1 2\n1 2\neq  \n\n \n\n\n= (1 + 2 + 4 + 2 + 3) = 12\n2A\n12\n24 I  \nA\n5\n2\n2\n25\n5\nI\nR R\nR\nI\n4 5\n5\n4    \n\n\n\n\n\n\n\n\n\nA\n5\n8\nI\n25\n20\nR R\nR I\nI\n4 5\n4\n5    \n\n\n\n\n\n\n\n\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q9_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Physics Q9]\\nGiven below are two statements :\nStatement I : The temperature of a gas is –73°C. When the gas is heated to 527°C, the root mean square \nspeed of the molecules is doubled. \nStatement II : The product of pressure and volume of an ideal gas will be equal to translational kinetic \nenergy of the molecules. \nIn the light of the above statements, choose the correct answer from the options given below:",
                options = listOf("Both statement I and statement II are true", "Statement I is false but statement Il is true", "Both statement I and statement II are false", "Statement I is true but statement II is false"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nTi\n = 200K Vrms  T\nTf\n = 800K\n2\n1\n4\n1\n800\n200\nT\nT\nV\nV\nf\ni\nf\ni    \nVf\n = 2Vi\nTranslational K.E. = PV\n2\n3\n\n\n\n\n\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q10_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Physics Q10]\\nTwo long straight wires P and Q carrying equal current 10A each were kept parallel to each other at 5 cm \ndistance. Magnitude of magnetic force experienced by 10 cm length of wire P is F1. If distance between wires \nis halved and currents on them are doubled, force F2 on 10 cm length of wire P will be:",
                options = listOf("10F1", "8F1", "10\nF1", "8\nF1"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n2 r\ni i\ni\n2 r\nF i\n0 1 2\n2\n1 0 1\n\n\n\n\n\n\n\nIf i1 and i2 both are doubled, if \n\n\n\n\n\n\n2\nr\nr\nf\n2 r\n8 i i\n2\nr\n2\nFf (2i )(2i )\n0 1 2 0 1 2\n\n\n\n\n\n\n\n\n\n\n\n\n\nF1 = 8F1",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q11_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Physics Q11]\\nA conducting circular loop of radius cm\n10\n\n is placed perpendicular to a uniform magnetic field of 0.5 T. \nThe magnetic field is decreased to zero in 0.5 s at a steady rate. The induced emf in the circular loop at 0.25 s \nis:",
                options = listOf("emf = 1 mV", "emf = 5 mV", "emf = 100 mV", "emf = 10 mV"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\ndt\nd\nind\n\n  \n= A\ndt\ndB \n\n\n\n\n\n= \n2\n10\n1\n0.5\n0.5\n\n\n\n\n\n\n\n\n\n \n\n\n\n\n\n= V\n100\n1\n1\n= 0.01 V\n= 10 mV",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q12_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Physics Q12]\\n1 g of a liquid is converted to vapour at 3 × 105\n Pa pressure. If 10% of the heat supplied is used for increasing \nthe volume by 1600 cm3\n during this phase change, then the increase in internal energy in the process will be:",
                options = listOf("4800 J", "432000 J", "4.32 × 108\n J", "4320 J"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nQ = U + W\n10 W = W + W\nU = 9 W\n= 9 × (3 × 105\n) \n\n\n\n\n\n 6\n10\n1\n1600\n= 4320 J",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q13_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Physics Q13]\\nIf two charges q1 and q2 are separated with distance ‘d’ and placed in a medium of dielectric constant K. \nWhat will be the equivalent distance between charges in air for the same electrostatic force?",
                options = listOf("2d k", "d k", "1.5d k", "k d"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\ndielectric constant = K\n2\n1 2\n0\nmedium d\nq q\n4 (K )\n1\nF \n \n\nFair = Fmedium\n2\n1 2\n0\n2\n0 air d\nq q\n4 (K )\n1\n4 (d )\n1\n \n\n\n d Kd air ",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q14_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Physics Q14]\\nGiven below are two statements:\nStatement I: An elevator can go up or down with uniform speed when its weight is balanced with the \ntension of its cable.\nStatement II: Force exerted by the floor of an elevator on the foot of a person standing on it is more than \nhis/her weight when the elevator goes down with increasing speed. \nIn the light of the above statements, choose the correct answer from the options given below:",
                options = listOf("Statement I is true but Statement II is false", "Both Statement I and Statement II are true", "Statement I is false but Statement II is true", "Both statement I and Statement II are false"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nStatement I is correct, because lift is moving with zero acceleration.\nStatement II is incorrect as force exerted will be less than the weight.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q15_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Physics Q15]\\nIn \n\nE and \n\nK represent electric field and propagation vectors of the EM waves in vacuum, then magnetic \nfield vector is given by: (ω – angular frequency):",
                options = listOf("(K E)\n1\n\n", "(E  K)", "(K  E)", "(K  E)"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n\nE electric field\n\nK propagation vector\n(K E)\n1\nB\n  \n\n\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q16_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Physics Q16]\\nAs per given figure, a weightless pulley P is attached on a double inclined frictionless surfaces. The tension \nin the string (massless) will be (if g = 10 m/s2\n)",
                options = listOf("(4 3 1)N", "(4 3 1)N", "4( 3 1)N", "4( 3 1)N"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nLet’s consider T tension in string and a acceleration of blocks.\nFBD of 4kg\n4gsin – T = 4a\nT 4a\n2\n4g 3\n  .... (1)\nFBD of 1kg\nT – gsin30° = a\na\n2\ng\nT   .... (2)\nFrom (1) and (2)\nT= 4 (1 3)N",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q17_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Physics Q17]\\nMatch List I with List II\nList-I List-II\n(A) Planck's constant (h) (I) [M1\nL\n2\nT\n–2\n]\n(B) Stopping potential (Vs) (II) [M1\nL\n1\nT\n–1\n]\n(C) Work function () (III) [M1\nL\n2\nT\n–1\n]\n(D) Momentum (p) (IV) [M1\nL\n2\nT\n–3A\n–1\n]\nChoose the correct answer from the options given below:",
                options = listOf("A-III, B-IV, C-I, D-II", "A-I, B-III, C-IV, D-II", "A-II, B-IV, C-III, D-I", "A-III, B-I, C-II, D-IV"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n[h] = [ML2\nT\n–1\n] → A–III\n[Vs] = [ML2\nT\n–3A\n–1\n] → B–IV\n[φ] = [ML2\nT\n–2\n] → C–I\n[p] = [MLT–1\n] → D–II",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q18_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Physics Q18]\\nFrom the photoelectric effect experiment, following observations are made. Identify which of these are \ncorrect.\nA. The stopping potential depends only on the work function of the metal.\nB. The saturation current increases as the intensity of incident light increases.\nC. The maximum kinetic energy of a photo electron depends on the intensity of the incident light.\nD. Photoelectric effect can be explained using wave theory of light.\nChoose the correct answer from the options given below:",
                options = listOf("A, B, D only", "A, C, D only", "B only", "B, C only"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n(A) From Einstein’s equation\nKmax = eVs\n = hν – \nForm the stopping potential (Vs) depends on  & ν.\n(B) Saturation current is proportional to intensity, i.e., number of incident photons.\n(C) Kmax only depends on nature of photon and φ.\n(D) Einstein used particle behaviour of photon to explain photon electric effect.\nOnly B is correct.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q19_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Physics Q19]\\nThe maximum vertical height to which a man can throw a ball is 136 m. The maximum horizontal distance \nupto which he can throw the same ball is:",
                options = listOf("272 m", "68 m", "192 m", "136 m"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nFor vertical throw, \n2g\nv\nh\n2\n\nv  2gh  2g 136 ..... (1)\nFor max range,  = 45°\ng\nv\nR\n2\nmax  ..... (2)\nFrom (1) and (2)\nRmax = \ng\n2g 136\ng\nv\n2\n\n\n= 272 m",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q20_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Physics Q20]\\nA 100 m long wire having cross-sectional area 6.25 × 10–4\n m\n2\n and Young's modulus is 1010 Nm–2 is subjected \nto a load of 250 N, then the elongation in the wire will be:",
                options = listOf("6.25 × 10–5\n m", "6.25 × 10–3\n m", "4 × 10–3\n m", "4 × 10–4\n m"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nAY\nF\n \nF = 250 N\n = 100 m\nA = 6.25 × 10–4\n m\n2\n = 4 × 10–3\n m\nSection-B: Numerical Value Type Questions: This section contains 10 questions. In Section B, attempt any \nfive questions out of 10. The answer to each question is a NUMERICAL VALUE. For each question, enter the \ncorrect numerical value (in decimal notation, truncated/rounded-off to the second decimal place; \ne.g. 06.25, 07.00, –00.33, –00.30, 30.27, –27.30) using the mouse and the on-screen virtual numeric keypad in \nthe place designated to enter the answer..",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q21_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Physics Q21]\\nA hole is drilled in a metal sheet. At 27°C, the diameter of hole is 5 cm. When the sheet is heated to 177°C, \nthe change in the diameter of hole is d × 10–3\n cm. The value of d will be ______ if coefficient of linear \nexpansion of the metal is 1.6 × 10–5\n/°C.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 12\\nSolution:\\nD = Dαt\n= 5 × 1.6 × 10–5 (177 – 27)\n= 0.012 cm\n= 12 × 10–3\n cm\nso, d = 12",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q22_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Physics Q22]\\nA block of a mass 2 kg is attached with two identical springs of spring constant 20 N/m each. The block is \nplaced on a frictionless surface and the ends of the springs are attached to rigid supports (see figure). When \nthe mass is displaced from its equilibrium position, it executes a simple harmonic motion. The time period of \noscillation is \nx\n\nin SI unit. the value of x is ____ .",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 5\\nSolution:\\nBoth the springs are in parallel so net spring\nconstant is Knet = K1 + K2 = 40 N/m\nSo, \nKnet\nm\nT  2\n= \n40\n2\n2\n= \n5\n\nx = 5",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q23_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Physics Q23]\\nIn the circuit shown in the figure, the ratio of the quality factor and the band width is _______ s.\n10\n230V ~ 27F\n3.0 H",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 10\\nSolution:\\nBandwidth \nL\nR\n \nQuality factor \nC\nL\nR\n1\nQ \nSo \nL\nR\nC\nL\nR\n1\nQ\n\n\n= \nR C\nL\n2\n2\n3\n= \n2\n1\n2 6\n2\n3\n10 (27 10 )\n3\n\n\n= \n100(3 3 10 )\n3 3\n3\n\n= 10",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q24_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Physics Q24]\\nAs shown in the figure, a combination of a thin plano concave lens and a thin plano convex lens is used to \nimage an object placed at infinity. The radius of curvature of both the lenses is 30 cm and refraction index of \nthe material for both the lenses is 1.75. Both the lenses are placed at distance of 40 cm from each other. Due \nto the combination, the image of the object is formed at distance x = ____ cm, from concave lens.\n \nO x\n40 cm",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 120\\nSolution:\\n30\n0.75\n30\n1 1\n(1.75 1)\nf\n1\nconcave\n \n\n\n\n\n\n\n\n\n \nfconcave = –40 cm\n30\n1 0.75\n30\n1\n(1.75 1)\nf\n1\nconcave\n \n\n\n\n\n\n\n  \nfconcave = 40 cm\nLet the first image is formed at v1 so\n40\n1\nf\n1 1\nv\n1\n1 concave\n  \n\n\nv1 = –40 cm\nfor second image\n40\n1\n80\n1\nx 40\n1\n\n\n\n\nx = 120 cm",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q25_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Physics Q25]\\nA spherical body of mass 2 kg starting from rest acquires a kinetic energy of 10000 J at the end of 5th \nsecond. The force acted on the body is _____N.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 40\\nSolution:\\nLet the force be F so acceleration \nm\nF\na \nSo displacement \n2\n1\nS  at2 \n= \n2m\nFt 2\nSo work done W = F.S. = \n2m\nF t\n2 2\nFrom work energy Theorem\nKE = W\n10000\n2m\nF t W\n2 2\n \n2\n5\n10000 2 2\nF\n \n\nF = 40N",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q26_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Physics Q26]\\nA stream of a positively charged particles having \nkg\nC\n2 10\nm\nq 11\n  and velocity i\nˆ v 3 107\n0  \n\nm/s is \ndeflected by an electric field 1.8\nˆ\njkV / m The electric field exists in a region of 10 cm along x direction. Due \nto the electric field, the deflection of the charge particles in the y direction is ____ mm.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 2\\nSolution:\\nm\nqE\nF\ny\ny \nay = 2 × 1011 × 1800\n= 36 × 1013 m/s2\nTime = \n\n\n\n\n\n \n\n\n \n\n8\n7\n0\n2\n10\n3\n1\n3 10\n0.1\nv\n10 10\n sec\n 2\nat\n2\n1\ny \n\n2\n13 8\n10\n3\n1\n36 10\n2\n1\ny \n\n\n\n\n\n    \n\n= 2 × 10–3\n m\n= 2 mm",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q27_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Physics Q27]\\nA hollow cylindrical conductor has length of 3.14 m, while its inner and outer diameters are 4 mm and 8 mm \nrespectively. The resistance of the conductor is n × 10–3 . If the resistivity of the material is 2.4 × 10–8 m. \nhe value of n is ______.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 2\\nSolution:\\n\n6\n8\n(16 4) 10\n2.4 10 3.14\nA\nR \n\n  \n \n\n\n\n\n= \n2\n10\n12\n2.4 \n\n= 2 ×10–3\nValue of n is 2.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q28_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Physics Q28]\\nAssume that protons and neutrons have equal masses. Mass of a nucleon is 1.6 × 10–27 kg and radius of \nnucleus is 1.5 × 10–15 A1/3 m. The approximate ratio of the nuclear density and water density is n × 1013. The \nvalue of n is _____.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 11\\nSolution:\\nRadius = 1.5 × 10–15 A1/3\nVolume = 3\nr\n3\n4\nMass of nucleus = (1.6 × 10–27) A kg\nDensity of nucleus = 3\n3\n1\n15\n27\n1.5 10 A\n3\n4\n1.6 10 A\n\n\n\n\n\n\n\n\n  \n \n\n\n= \n4 27\n1.6 3 8 1018\n\n  \n= \n17 10\n9\n32\n\n\nDensity of water = 1000 kg/m3\n1000\n10\n9\n32\nDensity of water\nDensity of nucleus\n17 \n \n= \n13 10\n9\n320\n\n\n= 11.32 × 1013\nvalue of n = 11",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q29_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Physics Q29]\\nSolid sphere A is rotating about an axis PQ. If the radius of the sphere is 5 cm then its radius of gyration \nabout PQ will be x cm. The value of x is ______.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 110\\nSolution:\\nI = Icm + Md2\n 2 2 2 MR Md\n5\n2 MK  \n2 2 R d\n5\n2\nK  \n2 2\n5 10\n5\n2\nK   cm\nK  110 cm\nValue of x  110",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q30_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Physics Q30]\\nVectors k\nˆ\nj\nˆ\ni b\nˆ a   and k\nˆ\nj 4\nˆ\ni 3\nˆ 2   are perpendicular to each other when 3a + 2b = 7, the ratio of a to b is \n2\nx\n. The value of x is _______.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 1\\nSolution:\\nk)\nˆ\nj\nˆ\ni b\nˆ\n(a    k) 0\nˆ\nj 4\nˆ\ni 3\nˆ\n(2   \n2a – 3b + 4 = 0\n(2a – 3b = –4 ×) 7 … (1)\nalso, (3a + 2b = 7 ×) 4 … (2)\nadding (1) and (2)\n14a + 12a – 21b + 8b = 0\n26a – 13b = 0\n2\n1\n26\n13\nb\na\n \nValue of x  1",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q31_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Chemistry Q31]\\nGiven below are two statements:\nStatement I : Noradrenaline is a neurotransmitter.\nStatement II : Low level of noradrenaline is not the cause of depression in human.\nIn the light of the above statements, choose the correct answer from the options given below.",
                options = listOf("Statement I is correct but Statement II is incorrect", "Statement I is incorrect but Statement II is correct", "Both statement I and Statement II are incorrect", "Both statement I and Statement II are correct"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n• Noradrenaline is a neurotransmitter.\n• Low level of noradrenaline is a cause for depression in human.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q32_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Chemistry Q32]\\nReaction of BeO with ammonia and hydrogen fluoride gives A which on thermal decomposition gives BeF2 \nand NH4F. What is ‘A’?",
                options = listOf("H3NBeF3", "(NH4)BeF3", "(NH4)Be2F5", "(NH4)2BeF4"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nBeO + NH3 + HF  (NH4)2\n(A)\nBeF4  BeF2 + NH4F\nCompound A is (NH4)2BeF4",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q33_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Chemistry Q33]\\nStatement I : For colloidal particles, the values of colligative properties are of small order as compared to \nvalues shown by true solutions at same concentration.\nStatement II : For colloidal particles, the potential difference between the fixed layer and the diffused layer \nof same charges is called the electrokinetic potential or zeta potential. \nIn the light of the above statements, choose the correct answer from the options given below",
                options = listOf("Both statement I and Statement II are true", "Both statement I and Statement II are false", "Statement I is true but Statement II is false", "Statement I is false but Statement II is true"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nFor colloidal particles value of colligative properties is less as compared to true solutions at same \nconcentration as number of particles are less.\nBut fixed layer and diffused layer have opposite charges.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q34_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Chemistry Q34]\\nIn the depression of freezing point experiment\nA. Vapour pressure of the solution is less than that of pure solvent \nB. Vapour pressure of the solution is more than that of pure solvent \nC. Only solute molecules solidify at the freezing point\nD. Only solvent molecules solidify at the freezing point \nChoose the most appropriate answer from the options given below:",
                options = listOf("A and D only", "B and C only", "A only", "A and C only"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nA and D are correct \nas (vp)solution < (vp)solvent\nand only solvent particles undergoes solidification.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q35_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Chemistry Q35]\\n‘A’ and ‘B’ formed in the following set of reactions are:",
                options = listOf("", "", "", ""),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q36_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Chemistry Q36]\\nThe primary and secondary valencies of cobalt respectively in [Co(NH3)5Cl]Cl2 are :",
                options = listOf("3 and 5", "2 and 6", "2 and 8", "3 and 6"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n[Co(NH3)5Cl]Cl2\nOxidation no. = primary valencies = 3\nCo-ordination no. = secondary valencies = 6",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q37_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Chemistry Q37]\\n‘R’ formed in the following sequence of reactions is",
                options = listOf("", "", "", ""),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q38_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Chemistry Q38]\\nIt is observed that characteristic X-ray spectra of elements show regularity. When frequency to the power “n” \ni.e. \nn of X-rays emitted is plotted against atomic number “Z”, following graph is obtained.",
                options = listOf("1", "2", "3", "2\n1"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nh = E = 13.6 × Z2\n\n\n\n\n\n\n\n\n2\n2\n2\n1\nn\n1\n–\nn\n1\nZ\n2\n ()\n1/2\nZ \n\n\n\n\n\n\n2\n1\nn",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q39_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Chemistry Q39]\\nThe magnetic moment of a transition metal compound has been calculated to be 3.87 B.M. The metal ion is",
                options = listOf("Ti2+", "Mn2+", "Cr2+", "V\n2+"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n = 3.87\nn = 3\nV23 = 4s2\n3d3\nV\n2+ = 4s0\n3d3 (n = 3)",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q40_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Chemistry Q40]\\nWhich of the following is true about freons?",
                options = listOf("These are chemicals causing skin cancer", "These are radicals of chlorine and chlorine monoxide", "All radicals are called freons", "These are chlorofluorocarbon compounds"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nFreons are chlorofluorocarbons",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q41_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Chemistry Q41]\\nIncreasing order of stability of the resonance structures is:\nA. B. \nC. D. \nChoose the correct answer from the options given below:",
                options = listOf("C, D, A, B", "D, C, B, A", "D, C, A, B", "C, D, B, A"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: Not given in the options\\nSolution:\\nCorrect stabilising order is\n C < A < B < D\n(This question should be given bonus)",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q42_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Chemistry Q42]\\nAssertion A: Hydrolysis of an alkyl chloride is a slow reaction but in the presence of NaI, the rate of the \nhydrolysis increases. \nReason R: I\n–\n is a good nucleophile as well as a good leaving group. \nIn the light of the above statements, choose the correct answer from the options given below.",
                options = listOf("Both A and R are true and R is the correct explanation of A", "A is false but R is true", "A is true but R is false", "Both A and R are true but R is NOT the correct explanation of A"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nCH3 –Cl H2O CH3OH (slow process) .... (r1)\nCH3 –Cl \n\n\n\n\n\n\n\nNucleophile\nI beingaGood\nNaI\n–\nCH3–I \n\n\n\n\n\n\n \nleaving group\nI being aGood\nH O\n–\n2 CH3 –OH .... (r2)\nr2 >> r1\nas I–\n is a good nucleophile as well as good leaving group.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q43_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Chemistry Q43]\\nMatch List-I with List-II\nList-I List-II\nA. Chlorophyll I. Na2CO3\nB. Soda ash II. CaSO4\nC. Dentistry, Ornamental work III. Mg2+\nD. Used in white washing IV. Ca(OH)2\nChoose the correct answer from the options given below",
                options = listOf("A-II, B-I, C-III, D-IV", "A-III, B-IV, C-I, D-II", "A-II, B-III, C-IV, D-I", "A-III, B-I, C-II, D-IV"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nChlorophyll contains Mg2+ Ions (A – III)\nSoda ash is Na2Co3 (B – I)\nDentistry; ornamental work – CaSO4 (C – II)\nUsed in white washing – Ca(OH)2 (D – IV)",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q44_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Chemistry Q44]\\nIn the following given reaction, ‘A’ is\n‘A’\nCH3\nC = CH2\n+ HBr major product",
                options = listOf("", "", "", ""),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q45_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Chemistry Q45]\\nMatch List-I with List-II\nList-I List-II\nA. Reverberatory furnace I. Pig Iron\nB. Electrolytic cell II. Aluminum\nC. Blast furnace III. Silicon\nD. Zone refining furnace IV. Copper\nChoose the correct answer from the options given below:",
                options = listOf("A-I, B-IV, C-II, D-III", "A-I, B-III, C-II, D-IV", "A-IV, B-II, C-I, D-III", "A-III, B-IV, C-I, D-II"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n(A) Reverberatory furnance is used for extraction of copper.\n(B) Electrolytic cell is used for obtaining highly reactive metals like aluminium.\n(C) Blast furnace is used for extraction of Iron. \n(D) Zone refining furnace is used for silicon.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q46_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Chemistry Q46]\\nCompound (X) undergoes following sequence of reactions to give the Lactone (Y).\nCompound (X)\n(i) HCHO, KOH\n(ii) KCN(alc)\n(iii) H3O\n+\nOH\nH\nH3C\nCH3\nO Lactone (Y)\nO\nCompound (X) is",
                options = listOf("CH3\nH—C—CHO\n|\n|\nCH3", "H2C—CH2—CH2—CH2—CHO\n|\nOH", "H2C—CH2—CHO\n|\nCH3", "CH3\nHOH2C—C—CHO\n|\n|\nCH3"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nCH3\nCH3—C—CHO\n|\n|\nH\nHCHO, KOH\nCH3\nCH3—C—CHO\n|\nHCHO\nCH3OH\nCH3—C—CH2\n|\n|\nCHO\n|\nKCN\nCH3\nCH3—C—CH2\n|\n|\nOH—CH\n|\nOH\n|\nCN\nH\n+\nCH3\nCH3—C—CH2\n|\n|\nCH\nC—OH\nO H\nOH\n||\nO\nH3O\n+\n–H2O\nCH3\nCH\nCH3 CH2\nO\nOH C\n||\nO\nLactone (Y)\nΘ",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q47_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Chemistry Q47]\\nWhich of the phosphorus oxoacid can create silver mirror from AgNO3 solution?",
                options = listOf("H4P2O5", "(HPO3)n", "H4P2O7", "H4P2O6"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nH4P2O5 can act as a reducing agent due to (P – H) bond.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q48_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Chemistry Q48]\\nDecreasing order of the hydrogen bonding in following forms of water is correctly represented by\nA. Liquid water\nB. Ice\nC. Impure water\nChoose the correct answer from the options given below:",
                options = listOf("A > B > C", "B > A > C", "A = B > C", "C > B > A"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nExtent of hydrogen bonding :\nIce > liquid water > impure water \n• In ice, 4 molecules of H2O are connected to H2O molecule. \n• Impure water will have less hydrogen bonding.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q49_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Chemistry Q49]\\nAn ammoniacal metal salt solution gives a brilliant red precipitate on addition of dimethylglyoxime. The \nmetal ion is",
                options = listOf("Ni2+", "Cu2+", "Fe+2", "Co2+"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nNi2+ forms cherry red ppt with dmg",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q50_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Chemistry Q50]\\nOrder of covalent bond :\nA. KF > KI; LiF > KF\nB. KF < KI; LiF > KF\nC. SnCl4 > SnCl2; CuCl > NaCl\nD. LiF > KF; CuCl < NaCl\nE. KF < KI; CuCl > NaCl\nChoose the correct answer from the options given below:",
                options = listOf("B, C only", "C, E only", "B, C, E only", "A, B only"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nB is correct KF < KI; LiF > KF \nC is correct \n4\nSnCl 4\n\n>\n2\nSnCl 2\n\n; CuCl > NaCl\nE is correct KF < KI; CuCl > NaCl\nSection-B: Numerical Value Type Questions: This section contains 10 questions. In Section B, attempt any \nfive questions out of 10. The answer to each question is a NUMERICAL VALUE. For each question, enter the \ncorrect numerical value (in decimal notation, truncated/rounded-off to the second decimal place; e.g. 06.25, \n07.00, –00.33, –00.30, 30.27, –27.30) using the mouse and the on-screen virtual numeric keypad in the place \ndesignated to enter the answer.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q51_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Chemistry Q51]\\nThe d-electronic configuration of [CoCl4]\n2–\n in tetrahedral crystal field is e\nm\nt2\nn\n. Sum of “m” and “number of \nunpaired electrons” is _______",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 7\\nSolution:\\n[CoCl4]\n2–\nNumber of unpaired electrons = 3",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q52_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Chemistry Q52]\\nThe dissociation constant of acetic acid is x × 10–5\n. When 25 mL of 0.2 M CH3COONa solution is mixed\nwith 25 mL of 0.02 M CH3COOH solution, the pH of the resultant solution is found to be equal to 5. The\nvalue of x is _______.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 10\\nSolution:\\npH = pKa + log \n\n\n\n\n\n\n\n25 0.02\n25 0.2\n5 = pKa + log10\npKa = 4  Ka = 10–4\n = 10 × 10–5\nx = 10",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q53_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Chemistry Q53]\\nUracil is a base present in RNA with the following structure. % of N in uracil is ________.\nGiven :\nMolar mass N = 14 g mol–1\nO = 16 g mol–1\nC = 12 g mol–1\nH = 1 g mol–1",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 25\\nSolution:\\nUracil is C4H4N2O2\n% by mass of N = \n112\n14 2\n× 100 = 25%",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q54_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Chemistry Q54]\\nThe number of correct statement/s from the following is __________.\nA. Larger the activation energy, smaller is the value of the rate constant.\nB. The higher is the activation energy, higher is the value of the temperature coefficient.\nC. At lower temperatures, increase in temperature causes more change in the value of k than at higher \ntemperature.\nD. A plot of ln k vs \nT\n1\nis a straight line with slope equal to –\nR\nEa\n.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 3\\nSolution:\\n(A) k = RT\nEa\n–\nAe (Ea k )\n(B) ln k = ln A –\nRT\nEa\ndT\ndk\n.\nk\n1\n = 2\na\nRT\nE\nEa  temp. coefficient \n(C)\n(D) ln k = ln A –\nRT\nEa\nSlope of ln k vs \nT\n1\n is \n\n\n\n\n\nR\n– Ea",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q55_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Chemistry Q55]\\nAt 298 K, a 1 litre solution containing 10 mmol of Cr2O7\n2–\nand 100 mmol of Cr3+ shows a pH of 3.0. \nGiven : Cr2O7\n2–  Cr3+; E° = 1.330V and \nF\n2.303RT = 0.059 V\nThe potential for the half cell reaction is x × 10–3\n V.\nThe value of x is _____________ .",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 917\\nSolution:\\n6e–\n + \n10 m\n–3\n14H\n\n+ \n10 m\n2–\n7\n–2\nCrO \n10 m\n3\n–1\n2Cr \n+ 7H2O\nEcell = 1.330 –\n6\n0.059 log \n(log )(log )\n10\n–2 –42\n–2\n= 1.330 –\n6\n0.059 (42)\n= 1.330 – 0.413\n= 0.917 = 917 × 10–3\nx = 917",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q56_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Chemistry Q56]\\n5 g of NaOH was dissolved in deionized water to prepare a 450 mL stock solution. What volume (in mL) of\nthis solution would be required to prepare 500 mL of 0.1 M solution?________ \nGiven : Molar Mass of Na, O and H is 23, 16 and 1 g mol–1\n respectively",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 180\\nSolution:\\nMolarity of solution = \n(450)\n(1000)\n(40)\n5\n M × V = 500 × .1\n\n450\n1000\n450\n5\n × V = 500 × .1\nV 180mL",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q57_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Chemistry Q57]\\nFor independent processes at 300 K\nProcess H/kJ mol–1\nS/J K–1\nA –25 –80\nB –22 40\nC 25 –50\nD 22 20\nThe number of non-spontaneous processes from the following is______",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 2\\nSolution:\\n– C is non –spontaneous as (H > 0, S < 0)\nD is Non – spontaneous\nFor D, \nG = H – TS\n= 22,000 – (300) (20) \n= (22,000 – 6000) > 0\nNon-spontaneous as (G > 0)",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q58_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Chemistry Q58]\\nWhen Fe0.93O is heated in presence of oxygen, it converts to Fe2O3. The number of correct statement/s from\nthe following is______\nA. The equivalent weight of Fe0.93O is \n0.79\nMolecular weight\nB. The number of moles of Fe2+ and Fe in 1 mole of Fe0.93O is 0.79 and 0.14 respectively.\nC. Fe0.93O is metal deficient with lattice comprising of cubic closed packed arrangement of O2–\n ions.\nD. The % composition of Fe2+ and Fe in Fe0.93O is 85% and 15% respectively.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 4\\nSolution:\\nA : Fe0.93O  Fe2O3\nnF = \n\n\n\n\n\n93\n200 3 – × .93\n = .79\n.79\nmw\neq.wt \nB : Fe0.93 Fe93O100\n100\n3\n(93–x)\n2\nFex Fe O\n \n2x + 3 (93 – x) = 200\nx = 79\n% of Fe2+\n = \n93\n79 × 100 = 85%\n% of Fe3+\n = \n93\n14\n× 100 = 15%\nA, B, C, D are correct.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q59_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Chemistry Q59]\\nIf wavelength of the first line of the Paschen series of hydrogen atom is 720 nm, then the wavelength of the \nsecond line of this series is______ nm. (Nearest integer)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 492\\nSolution:\\n\n\n\n\n\n\n \n16\n1\n–\n9\n1\nR\n720\n1\n R = \n720 7\n9 16\n\n\n\n\n\n\n\n\n\n\n\n\n 25\n1\n–\n9\n1\n720 7\n1 9 16\n = 492.18 nm\n  492nm (nearest integer)",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q60_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Chemistry Q60]\\nNumber of moles of AgCl formed in the following reaction is_____\n(A) + X AgCl ",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 2\\nSolution:\\nCircled Cl will get precipitated",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q61_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Mathematics Q61]\\nLet N denote the number that turns up when a fair die is rolled. If the probability that the system of equations\nx + y + z = 1\n2x + Ny + 2z = 2\n3x + 3y + Nz = 3\nhas unique solution is \n6\nk\nthen the sum of value of k and all possible values of N is",
                options = listOf("18", "20", "21", "19"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nFor unique solution  \ni.e. \n3 3 N\n2 N 2\n1 1 1\n 0\n (N\n2\n– 6) – (2N – 6) + (6 – 3N)  0\n N\n2\n– 5N + 6  0\n N  2 and N  3\n Probability of not getting 2 or 3 in a throw of dice =\n3\n2\nAs given\n6\nk\n3\n2\n  k = 4\n Required value = 1 + 4 + 5 + 6 + 4 = 20",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q62_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Mathematics Q62]\\nLet k,\nˆ\nj 2\nˆ\ni\nˆ u   \n\nk,\nˆ\nj\nˆ\ni\nˆ v  2  \n\nv.w\n \n = 2 and v w u v\n   \n    . Then uˆ.wˆ is equal to",
                options = listOf("2", "1", "2\n3", "3\n2\n"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nGiven v w u v\n   \n    ...(i)\nTaking dot with v\n\nwe get\n[v vw]\n  \n= | v |\n 2\n + u.v\n \nSubstituting values we have\n63 = 0   = −\n2\n1\n Equation (i) becomes\n2\nv\nv w u\n\n  \n   ...(ii)\nTaking dot with w of (ii) we get\n0 = \n2\nv.w\nu.w\n \n \n\n\n2\n2\nu.w \n \n= 1 (as v.w\n \n= 2 given)",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q63_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Mathematics Q63]\\nThe distance of the point (–1, 9, –16) from the plane 2x + 3y – z = 5 measured parallel to the line\n3\nx  4\n= \n4\n2  y\n= \n12\nz  3\nis",
                options = listOf("20 2", "13 2", "26", "31"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n3\nx  4\n= \n4\ny 2\n\n\n= \n12\nz  3\n2x+3y–z = 5\n Equation of line AP\n3\nx 1\n= \n4\ny 9\n\n\n= \n12\nz 16\nPoint A(3 – 1, –4 + 9, 12 – 16) lies on 2x + 3y – z = 5, \n 6 – 2 – 12 + 27 – 12 + 16 = 5   = 2\n Point A(5, 1, 8)\n AP2\n = 62\n + 82\n + 242\n = 4(9 + 16 + 144) = 4 × 169\nAP = 26\nOption (3) is correct.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q64_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Mathematics Q64]\\nLet y = y(x) be the solution of the differential equation x\n3\ndy + (xy – 1)dx = 0, x > 0, y \n\n\n\n\n\n2\n1\n= 3 – e\nThen y(1) is equal to\n(1) e (2) 2 – e (3) 3 (4) 1",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 4\\nSolution:\\nx\n3\ndy + xy dx – dx = 0\n 3\nx\n1 xy\ndx\ndy \n\n 2 3\nx\n1\nx\ny\ndx\ndy\n \nI.F. = \n\n2\nx\ndx\ne = x\n1\ne\n\n x\n1\n–\nye = \n\ndx\nx\ne\n3\nx\n1\nFor RHS put\nx\n1\n = t  2\nx\ndx\n= dt\n x\n1\n–\nye = \n te dt t\n x\n1\n–\nye = –  \nt t\nte  e + c\n x\n1\n–\nye = e c\nx\ne x\n1\nx\n1\n \n\n\n........(i) \n\n\n\n\n\n\n\n2\n1\ny = 3 – e\n (3 – e)e\n–2\n = 2e\n–2\n + e\n–2\n + c\n\ne\n1\nc   ........(ii)\nFor y(1) put x = 1, c = –e\n–1\n in equation (i) we get\nye\n–1\n = e\n–1\n + e\n–1\n– e\n–1\n y = 1",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q65_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Mathematics Q65]\\n. If A and B are two non-zero n × n matrices such that A\n2\n + B = A\n2\nB, then",
                options = listOf("A\n2\nB = BA2", "A\n2\nB = I", "A\n2\n = I or B = I", "AB = I"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nGiven : A\n2\n + B = A\n2\nB ...(i)\n A\n2\n + B – I = A\n2\nB – I\n A\n2\nB – A\n2\n– B + I = I\n A\n2\n(B – I) – I(B – I) = I\n (A\n2\n– I)(B – I) = I\n A\n2\n– I is the inverse matrix of B – I and vice versa.\nSo, (B – I)(A\n2\n– I) = I\n BA2\n– B – A\n2\n + I = I\n A\n2\n + B = BA2\n...(ii)\nSo, by (i) and (ii)\nA\n2\nB = BA2\n Option (1) is correct.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q66_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Mathematics Q66]\\nLet PQR be a triangle. The points A, B and C are on the sides QR, RP and PQ respectively such that\nBP\nRB\nAR\nQA\n =\nCQ\nPC\n= \n2\n1\n. Then \nArea( ABC)\nArea ( PQR)\n\n\nis equal to",
                options = listOf("2\n5", "4", "3", "2"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nBy PSY formula\nPQR\nABC\n\n\n= \nPQ QR RP\n(PC QA RB) (CQ AR BP)\n \n    \n = \n3 3 3\n8 1\n \n\n= \n3\n1",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q67_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Mathematics Q67]\\nFor three positive integers p, q, r, \n2\npq\nx = \nqr y = \np r\n2\nz and r = pq+1 such that 3, 3 logy x, 3logz\n y, 7 logx z are in \nA.P with common difference\n2\n1\n. Then r – p – q is equal to",
                options = listOf("12", "2", "–6", "6"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n2\npq\nx = \nqr y = \np r\n2\nz\n3logy x = \n2\n7\n, 3 logz y = 4,7 logxz = \n2\n9\n x = 6\n7\ny ,y = 3\n4\nz , z = 14\n9\nx\n \n2\npq\n6\n7\ny = y\nqr\n = \nq r\n4\n3 2\ny\n p r\n4\n3\npq qr\n6\n7 2 2\n \n 7pq = 6r, 4q = 3p\n2\nr = pq + 1\nr = \n7\n6r\n+ 1  r = 7\npq = 6\np\n\n\n\n\n\n\n\n\n4\n3p\n2\n = 6\np = 2, q = 3\nr – p – q = 7 – 5 = 2",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q68_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Mathematics Q68]\\nThe relation R = (a, b) : gcd (a, b) = 1,2a  b, a, b  is",
                options = listOf("Reflexive but not symmetric", "Neither symmetric nor transitive", "Symmetric but not transitive", "Transitive but not reflexive"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\ngcd (a, a) = a so (a, a) so  R  not reflexive\nIf gcd (a, b) = 1  gcd (b, a) = 1\n (b, a) R  Symmetric\nIf gcd (a, b) = 1 and gcd (b, c) = 1\n gcd (a, c) = 1\n R is not transitive",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q69_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Mathematics Q69]\\nThe area enclosed by the curves y\n2\n + 4x = 4 and y – 2x = 2 is",
                options = listOf("3\n23", "3\n22", "3\n25", "9"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nRequired area = \n\n\n\n\n\n\n\n \n\n2 \n4\n2\ndy\n2\ny 2\n4\n4 y\n= \n2  \n4\n2\ndy\n4\n8 2y y\n= \n2\n4\n3\n2\n3\ny\n8y y\n4\n1\n\n\n\n\n\n\n \n= 9 square units",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q70_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Mathematics Q70]\\nsin t\n2 2 2 t 0\n2\nnsin t\n1\n.......\n2sin t\n1\n1sin t\n1\nlim \n\n\n\n\n\n  \n\nis equal to",
                options = listOf("n\n2", "n\n2\n + n", "2\nn(n 1)", "n"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nsin t\ncos ec t\n2\nt 0\n2\n2\n..... 1\nn\n2\ncosec t\nn\n1\nlimn\n\n\n\n\n\n\n\n\n  \n\n\n\n\n\n \n\n\n\n\n\n\nl = n\n\ncos ec t\nt 0\n2\nn\nr\nlim \n\n\n\n\n\n\n = 0,  1 < r < n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q71_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Mathematics Q71]\\nThe value of \n22\nr 0\nr\n23\nr\n22C C is",
                options = listOf("44C22", "45C24", "44C23", "45C23"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n(1 + x)\n22\n= \n22C0 + 22C1x + 22C2x\n2\n+ ...... + 22C21x\n21 + 22C22x\n22 ...(i)\n(x +1)23\n= \n23C0x\n23 + 23C1x\n22 + 23C2x\n21 + ...... + 23C21x\n2\n+ 23C22x + 23C23 …(ii)\nMultiplying (i) & (ii) and comparing coefficients of x\n23 on both sides\n43C23 = \n22C0· \n23C0 + 22C1· \n23C1 + 22C2· \n23C2 + ...... + 22C22· \n23C22\n\n22\nr 0\nr\n23\nr\n22C C = \n45C23",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q72_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Mathematics Q72]\\nLet a tangent to the curve y\n2\n = 24x meet the curve xy = 2 at the points A and B. Then the mid points of such \nline segments AB lie on a parabola with the",
                options = listOf("Directrix 4x = 3", "Length of latus rectum\n2\n3", "Length of latus rectum 2", "Directrix 4x = –3"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\ny\n2\n = 24x, xy = 2\nLet the equation of tangent to y\n2\n = 24x is ty = x + 6t\n2\nty = x + 6t\n2\n meet the curve xy = 2 at points A and B.\nLet mid-point of AB is P(h, k).\n2\n1 2\n2 2\n2\n1 2\n2 2\n2\nx x 6t\nx 6t x 2t 0\nx 6t\ny\n2\nt.\ny y 6t\nty 6t y 2 0\n6t\ny\n2\nty\n  \n  \n \n \n  \n \n Mid-point P is (–3t\n2\n, 3t)\n h = –3t\n2\n, k = 3t\n\n2\n3\nk\n3\nh\n\n\n\n\n\n\n \n\n\n\n\n\n\n y\n2\n = –3x\n Length of L.R. = 3\nEquation of directrix is x =\n4\n3",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q73_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Mathematics Q73]\\nThe equation x\n2\n– 4x + [x] + 3 = x[x], where [x] denotes the greatest integer function, has",
                options = listOf("Exactly two solutions in (–, )", "No solution", "A unique solution in (–, 1)", "A unique solution in (–, )"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nx\n2\n– 4x + [x] + 3 = x[x]\n(x – 1)(x – 3) = (x – 1)[x]\n(x – 1)(x – 3 – [x]) = 0\nx = 1 or x – 3 – [x] = 0\n{x} = 3\nx = \n a unique solution in (–, )",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q74_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Mathematics Q74]\\nThe distance of a point (7, –3, –4) from the plane passing through the points (2, –3, 1), (–1, 1, –2) and (3, –4, \n2) is",
                options = listOf("4 2", "4", "5 2", "5"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nA(2, –3, 1), B(–1, 1, –2), C(3, –4, 2)\nAB= − k\nˆ\nj 3\nˆ\ni 4\nˆ  3   AC = k\nˆ\nj\nˆ\ni\nˆ  \nn\n\n = \n1 1 1\n3 4 3\nk\nˆ\nj\nˆ\ni\nˆ\n\n  = k\nˆ\ni\nˆ \nLet equation of plane is x – z +  = 0 passes through point A(2, –3, 1)   = –1\nEquation of plane is x – z – 1 = 0\nDistance of point (7, –3, –4) from the plane x – z – 1 = 0 is 5 2",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q75_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Mathematics Q75]\\nThe compound statement (~ (P Q))  ((~ P) Q)  ((~ P)  (~Q)) is equivalent to",
                options = listOf("((~ P)Q)(~Q)", "(~Q) P", "(~P) Q", "((~ P) Q)  ((Q)  P)"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n(~ (P  Q))  ((~ P)  Q)  ((~ P)  (~ Q))\n(~ P  ~ Q)  (~ P  Q)  (~ P ~ Q)\n (~ P  ~ Q  ~ P)  (~ P  ~ Q  Q)  (~ P ~ Q)\n (~ P  ~ Q)  (T )  (~ P  ~ Q)\n (~ P  ~ Q)  (~ P  ~ Q)\n ~ (~ P  ~ Q)  (~ P  ~ Q)\n (P  Q)  (~ P ~Q)  (~ P  Q)  (• Q  P)",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q76_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Mathematics Q76]\\nLet  be the sample space and A   be an event.\nGiven below are two statements:\n(S1) : If P(A) = 0, then A = \n(S2) : If P(A) = 1, then A = \nThen",
                options = listOf("Both (S1) and (S2) are false", "Only (S1) is true", "Only (S2) is true", "Both (S1) and (S2) are true"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nBoth statements are correct",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q77_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Mathematics Q77]\\nLet  be a root of the equation (a – c)x2 + (b – a) x + (c – b) = 0 where a, b, c are distinct real numbers such \nthat the matrix\n\n\n\n\n\n\n\n\n\n \na b c\n1 1 1\n1\n2\nis singular. Then, the value of\n(a c)(b a)\n(c b)\n(a c)(c b)\n(b a)\n(b a)(c b)\n(a c)\n2 2 2\n \n\n\n \n\n\n \n\nis",
                options = listOf("12", "6", "9", "3"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n(a c)(c b)(b a)\n(a c) (b a) (c a)\n3 3 3\n  \n    \n = \n(a c)(b a)(c b)\n3(a c) (b a) (c a)\n  \n    \n= 3",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q78_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Mathematics Q78]\\nLet f(x) = \n\n\n\n\n\n\n \n\n\n\n\n\n0, x 0\n, x 0\nx\n1\nx sin 2\n, Then at x = 0",
                options = listOf("f is continuous but not differentiable", "f and f ' both are continuous", "f ' is continuous but not differentiable", "f is continuous but f ' is not continuous"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nf(x) = \n\n\n\n\n\n\n \n\n\n\n\n\n0, x 0\n, x 0\nx\n1\nx sin 2\nlim f(x) lim f(x) f(0) 0\nx 0 x 0\n  \n   \n f is continuous at x = 0\nNow, R.H.D. = 0\nh\nh\n1\nh sin\nh\nf(h) f (0)\nlim\n2\nh 0\n \n\n\nat x = 0\nand LHD\n= 0\nh\n)\nh\n1\nh sin(\nh\nf( h) f(0)\nlim\n2\nh 0\n\n\n\n\n\n \n\n RHD = LHD  f is differentiable at x = 0\n f '(x) = \n\n\n\n\n\n\n \n\n\n\n\n\n \n\n\n\n\n\n0, x 0\n, x 0\nx\n1\ncos\nx\n1\n2xsin\n \nh 0\nlim f '(x) is oscillatory\n f is continuous but f ' is not at x = 0",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q79_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Mathematics Q79]\\n. \n\n\n\n\n\n\n\n\n \n3 3\n1 3\ntan 1\n+ sec–1\n\n\n\n\n\n\n\n\n\n\n6 3 3\n8 4 3\nis equal to :",
                options = listOf("3\n", "6\n", "2\n", "4\n"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n\n\n\n\n\n\n\n\n\n \n3 3\n1 3\ntan 1\n = \n\n\n\n\n\n\n \n3\n1\ntan 1\n=\n6\n\nand sec–1\n\n\n\n\n\n\n\n\n\n\n3(2 3)\n4(2 3)\n= \n\n\n\n\n\n\n \n3\n2\nsec 1\n=\n6\n\n \n\n\n\n\n\n\n\n\n \n3 3\n1 3\ntan 1\n+ sec–1\n\n\n\n\n\n\n\n\n\n\n6 3 3\n8 4 3\n= \n6\n\n+\n6\n\n = \n3\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q80_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Mathematics Q80]\\nLet p, q  R and  \n200\n1 3i = 2\n199 (p + iq), i = 1 , then p + q + q\n2\nand p – q + q\n2\n are roots of the equation.",
                options = listOf("x\n2\n– 4x + 1 = 0", "x\n2\n– 4x – 1 = 0", "x\n2\n + 4x – 1 = 0", "x\n2\n + 4x + 1 = 0"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nGiven  \n200\n1 3i = 2\n199 (p + iq) …(1)\nL.H.S =\n200\n200\n3\n5\nisin\n3\n5\n2 cos \n\n\n\n\n \n \n\n\n\n\n \n = \n\n\n\n\n \n\n\n3\n1000 isin\n3\n1000 2 cos 200\n = \n\n\n\n\n\n\n\n\n  i\n2\n3\n2\n1\n2\n200\nSo, by (1)\nP = – 1, q = − 3\n p + q + q\n2\n= −1− 3 + 3 = 2 − 3 = \nand p − q + q\n2\n= −1 + 3 + 3 = 2 + 3 = \n quadratic equation whose roots are  and \nx\n2\n– 4x + 1 = 0\nOption (1) is correct.\nSection-B: Numerical Value Type Questions: This section contains 10 questions. In Section B, attempt \nany five questions out of 10. The answer to each question is a NUMERICAL VALUE. For each question, \nenter the correct numerical value (in decimal notation, truncated/rounded-off to the second decimal place; \ne.g. 06.25, 07.00, –00.33, –00.30, 30.27, –27.30) using the mouse and the on-screen virtual numeric \nkeypad in the place designated to enter the answer.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q81_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Mathematics Q81]\\nSuppose \n2023\nr 0\n2\nr\n2023Cr\n = 2023 ×  × 22022\n, the value of  is ___________",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 1012\\nSolution:\\n (1 + x)2023\n = \n2023\nr 0\nr\nr\n2023C x\n (2023)(1 + x)2022\n = \n\n2023\nr 0\nr 1\nr\n2023C rx\n (2023)(1 + x)2022\n = \n2023\nr 0\nr\nr\n2023 r C x\n 2023[x2022(1 + x)2021 + (1 + x)2022] = \n\n2023\nr 0\nr 1\nr\n22023 r C x\nPut x = 1\n 2023[2022.22021 + 22022] = \n2023\nr 0\nr\n22023 r C\n \n2023\nr 0\nr\n22023 r C = 2023.22022(1012)\n82. Let C be the largest circle centred at (2, 0) and inscribed in the ellipse\n16\ny\n36\nx\n2 2\n =1\nIf (1, ) lies on C, then 10\n2\n is equal to _________\nAns. [118.00]\nSol.\n16\ny\n36\nx\n2 2\n = 1\nr\n2\n = (x – 2)2\n + y\n2\nSolving simultaneously\n– 5x\n2\n + 36x + (9r\n2\n– 180) = 0\nD = 0\nr\n2\n=\n10\n128\nDistance between (1, ) and (2, 0) should be r\n1 + \n\n =\n10\n128\n\n\n =\n10\n118 = 118.00",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q83_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Mathematics Q83]\\nThe number of 9 digit numbers, that can be formed using all the digits of the number 123412341 so that the \neven digits occupy only even places, is ___________",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 60\\nSolution:\\nGiven number 123412341\n-------------------------------\n    \nTotal number = \n3!2!\n5!\n2!2!\n4!\n = 6 × 10 = 60",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q84_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Mathematics Q84]\\nLet a tangent to the curve 9x\n2\n + 16y\n2\n = 144 intersect the coordinate axes at the points A and B. Then, the\nminimum length of the line segment AB is ____________",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 07\\nSolution:\\nGiven curve : 9x\n2\n + 16y\n2\n = 144\n\n9\ny\n16\nx\n2 2\n = 1\nLet P(4cos, 3sin) be any point on it.\nNow tangent at P\n3\nysin\n4\nx cos \n\n\n = 1\n A  (4sec, 0) B  (0, 3cosec)\nAB =   \n2 2\n16sec 9cosec =     \n2 2\n16 9 16 tan 9cot\nABmin = 25  212 = 7\n85. A boy needs to select five courses from 12 available courses, out of which 5 courses are language courses. If \nhe can choose at most two language courses, then the number of ways he can choose five courses is \n_____________\nAns. [546]\nSol. Case 1 If no language course is selected.\n= \n7C5\nCase 2 If one language course is selected.\n7C4 . \n5C1\nCase 3 If two language course is selected.\n7C3.\n5C2\nTotal = 7C5 + 7C4 \n5C1 + 7C3 \n5C2\n= 21 + 175 + 350\n= 546",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q86_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Mathematics Q86]\\nThe value of 12 \n \n3\n0\n2\nx 3x 2 dx is _______.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 22\\nSolution:\\n\n \n3\n0\n2\n12 x 3x 2 dx\nLet I = \n \n3\n0\n(x 2)(x 1)dx\n = \n \n1\n0\n(x 1)(x 2)dx –\n\n \n2\n1\n(x 1)(x 2)dx + \n \n3\n2\n(x 1)(x 2)dx\n =\n1\n0\n3 3\n2x\n2\n3x\n3\nx\n\n\n\n\n\n\n  –\n2\n1\n3 2\n2x\n2\n3x\n3\nx\n\n\n\n\n\n\n  +\n3\n2\n3 2\n2x\n2\n3x\n3\nx\n\n\n\n\n\n\n \n = \n\n\n\n\n\n  2\n2\n3\n3\n1\n–\n\n\n\n\n\n\n\n\n\n\n\n\n   \n\n\n\n\n\n  2\n2\n3\n3\n1\n6 4\n3\n8\n+ \n\n\n\n\n\n\n\n\n\n\n\n\n   \n\n\n\n\n\n  6 4\n3\n8\n6\n2\n27 9\n = \n6\n11\n 12I = \n6\n11 × 12 = 22",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q87_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Mathematics Q87]\\nThe 4th term of GP is 500 and its common ratio is\nm\n1\n, m  Let Sn denote the sum of the first n terms of \nthis GP. If S6 > S5 + 1 and S7 < S6 + \n2\n1\n, then the number of possible values of m is",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 12\\nSolution:\\nT4 = 500\nar\n3\n = 500  a 3\nr\n500\nNow,\nS6 > S5 + 1\n1 r\na(1 r )\n6\n\n\n–\n1 r\na(1 r )\n5\n\n\n > 1\nar\n5\n > 1\nNow, r = \nm\n1\n and a = 3\nr\n500\n m\n2\n 500\n m > 0  m  (0, 10 5 ) ...(i)\nS7 < S6 + \n2\n1\n1 r\na(1 r )\n6\n\n\n< \n1 r\na(1 r )\n6\n\n\n + \n2\n1\nar\n6\n < \n2\n1\n r = \nm\n1\nand a = 5\nr\n500\n1000\n1\nm\n1\n3\n\n m  ...(ii)\nPossible values of m is {11, 12, .........22}\n m  N\nTotal 12 values",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q88_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Mathematics Q88]\\nThe shortest distance between the lines\n2\nz 6\n2\ny 1\n3\nx 2 \n\n\n\n\n and \n0\nz 8\n2\n1 y\n3\nx 6 \n\n\n\n\nis equal to",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 14\\nSolution:\\nk\nˆ\nj 6\nˆ\ni\nˆ a 2 1   \n\nk\nˆ\nj 8\nˆ\ni\nˆ a 6 2   \n\nk\nˆ\nj 2\nˆ\ni 2\nˆ a  3  \n\nk\nˆ\nj 0\nˆ\ni 2\nˆ b  3  \n\nS.D = \n \n| a b |\na a a b 2 1\n \n   \n\n\na a a b  2 1\n   \n = \n3 2 0\n3 2 2\n4 2 14\n\n\n= 4× (4) – 2 (–6) – 14 (–12)\n= 16 + 12 + 168 = 196\na b\n \n = \n3 2 0\n3 2 2\nk\nˆ\nj\nˆ\ni\nˆ\n\n= k\nˆ\nj 12 ˆ\ni 6\nˆ 4  \na b\n \n = 16  36 _144 = 196 =14\nS.D = \n14\n196 = 14",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q89_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Mathematics Q89]\\nLet R and let the equation E be |x|2\n– 2|x| + | – 3| = 0 . Then the largest element in the set S = {x + : x is \nan integer solution of E} is ________.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 05\\nSolution:\\nD  0  4 – 4 | – 3|  0\n|  – 3| \n–1   –3 \n2    2\n|x| = \n2\n2  4  4 |   3 |\n = 1 1 |   3 |\nxlargest = 1 + 1 = 2, when  = 3\nLargest element of S = 2 + 3 = 5",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q90_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 1 - Mathematics Q90]\\nThe value of \n\n \n2\n0\n2023 2023\n2023\ndx\n(sin x) (cos x)\n8 (cos x)\nis __________.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 02\\nSolution:\\nI =\n\n\n \n2\n0\n2023 2023\n2023\ndx\n(sin x) (cos x)\n8 (cos x)\n.....(i)\nI = \n\n \n2\n0\n2023 2023\n2023\ndx\n(sin x) (cos x)\n8 (sin x)\n.....(ii)\n\n\n\n\n\n\n\n\n \n \nb\na\nb\na\n f(x)dx f(a b – x)dx\n(i) + (ii)  2I = \n2\n8\n1dx 8\n2\n0\n\n\n\n\n\n\n\n= 4\nI = 2",
                difficulty = "Medium"
            )
        )
    }
}