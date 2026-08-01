package com.example.data.repository
import com.example.model.Question
object JeeMain2023Session1Shift2QuestionsRepository {
    fun getQuestions(testId: String): List<Question> {
        return listOf(
            Question(
                id = "${testId}_s1_sh2_q1_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Physics Q1]\\nThe electric potential at the centre of two concentric half rings of radii R1 and R2, having same linear charge \ndensity  is:\n \nR2\nR1\nO\n\n\n \n\n\n\n\n\n \n\n\n\n\n\n\n\n\n\n\n\n\n \n\n\n\n\n\n \n   ",
                options = listOf("0\n4\n", "0\n2\n", "0\n2\n\n", "0\n\n"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n1\n1\n0\n1\nR\n( R )\n4\n1\nv\n \n\n\n\n2\n2\n0\n2\nR\n( R )\n4\n1\nv\n \n\n\n\nVnet  V1  V2\n= \n\n\n0\n4\n1\n2\n= \n0\n2\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q2_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Physics Q2]\\nA body of mass 200 g is tied to a spring of spring constant 12.5 N/m, while the other end of spring is fixed at \npoint O. If the body moves about O in a circular path on a smooth horizontal surface with constant angular \nspeed 5 rad/s. Then the ratio of extension in the spring to its natural length will be:",
                options = listOf("1 : 1", "1 : 2", "2 : 3", "2 : 5"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nkx = mw2\n ( + x)\n12.5(x) = (5) ( x)\n5\n1 2\n \n x x\n2\n5\n  \n x  \n2\n3\n\n3\nx 2\n\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q3_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Physics Q3]\\nThe electric field and magnetic field components of an electromagnetic wave going through vacuum is \ndescribed by\nEx = E0 sin (kz –t)\nBy = B0 sin(kz – t)\nThen the correct relation between E0 and B0 is given by",
                options = listOf("E0 = kB0", "E0 = kB0", "kE0 = B0", "E0B0 = k"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nEx = E0sin(kz - t)\nBy = B0sin (kz – t) \n velocity = \n0\n0\nB\nE\n0\n0\nB\nE\nk\n\n\n0 0 B  kE",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q4_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Physics Q4]\\nIn an Isothermal change, the change in pressure and volume of a gas can be represented for three different \ntemperature; T3 > T2 > T1 as:",
                options = listOf("", "", "", ""),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nCorrect graph is\nBecause at constant volume V\nP3 > P2 > P1\n T3 > T2 > T1",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q5_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Physics Q5]\\nGiven below are two statements:\nStatement I: Acceleration due to earth’s gravity decreases as you go ‘up’ or ‘down’ from earth’s surface.\nStatement II: Acceleration due to earth’s gravity is same at a height ‘h’ and depth ‘d’ from earth’s surface, if \nh = d. In the light of above statements, choose the most appropriate answer from the options given below.",
                options = listOf("Both Statement I and II are correct", "Statement I is correct but statement II is incorrec", "Both Statement I and Statement II are incorrect", "Statement I is incorrect but statement II is correct"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nStatement I is correct as\nStatement II is incorrect as Eabove and Ebelow the surface have different relation with height and depth \nrespectively.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q6_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Physics Q6]\\nMatch List I with List II\n List I List II\nA. AM Broadcast I. 88-108 MHz\nB. FM Broadcast II. 540-1600 kHz\nC. Television III. 3.7-4.2 GHz\nD. Satellite Communication IV. 54 MHz-890 MHz\nChoose the correct answer from the options given below:",
                options = listOf("A-I, B-III, C-II, D-IV", "A-IV, B-III, C-I, D-II", "A-II, B-III, C-I, D-IV", "A-II, B-I, C-IV, D-III"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nAM band is in kHz A-II\nFM is in 88-108 MHz B-I\nTV frequency in 54-890 MHz C-IV\nSatellite Communication is in GHz D-III",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q7_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Physics Q7]\\nIf two vectors k mˆ\nj mˆ\ni 2\nˆ P   \n\n and k mˆ\nj\nˆ\ni 2\nˆ Q  4  \n\n are perpendicular to each other Then, the value of m \nwill be :",
                options = listOf("–1", "2", "3", "1"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n\nP and \n\nQ are perpendicular\n\n\nP \n\nQ = 0\n 4 – 4m + m2\n = 0\n= m = 2",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q8_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Physics Q8]\\nA photon is emitted in transition from n = 4 to n = 1 level in hydrogen atom. The corresponding wavelength \nfor this transition is (given, h = 4 × 10–15 eVs) :",
                options = listOf("941 nm", "99.3 nm", "94.1 nm", "974 nm"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n\n\n\n\n\n\n  \n\n2\n4\n1\n1\n1\n13.6eV hc\n \n\n\n\n\n\n\n\n  \n \n16\n15 13.6\n4 10 3 10 15 8\n = 94.1 nm",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q9_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Physics Q9]\\nThe velocity-time graph of a body moving in a straight line is shown in figure.\nThe ratio of displacement to distance travelled by the body in time 0 to 10 s is :",
                options = listOf("1 : 4", "1 : 2", "1 : 3", "1 : 1"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nFrom v-t graph\nDisplacement = Area under curve considering sign also.\nDistance = Area under curve considering only magnitude\nDistance = 48\nDisplacement = 16 m\nDisplacement : distance = 1 : 3",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q10_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Physics Q10]\\nLet 1 be the ratio of molar specific heat at constant pressure and molar specific heat at constant volume of a \nmonoatomic gas and 2 be the similar ratio of diatomic gas. Considering the diatomic gas molecule as a rigid \nrotator, the ratio, \n2\n\n\n is",
                options = listOf("35\n27", "27\n35", "21\n25", "25\n21"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n3\n5\nC\nC\nV mono atomic gas\nP\n1  \n\n5\n7\nC\nC\nV di atomic gas\nP\n 2  \n\n21\n25\n2\n1 \n\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q11_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Physics Q11]\\nA long solenoid is formed by winding 70 turns cm–1\n. If 2.0 A current flows, then the magnetic field produced \ninside the solenoid is _______ (0 = 4 × 10–7\n TmA–1\n)",
                options = listOf("88 × 10–4\n T", "352 × 10–4\n T", "1232 × 10–4\n T", "176 × 10–4\n T"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nNumber of turns per meter = 7000 turns per m\ni = 2 A\nB = 0ni = 4 × 10–7\n × 7000 × 2\n= 56 × 10–4 T\n= 10 T\n7\n22 56 4\n \n= 176 × 10–4 T",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q12_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Physics Q12]\\nGiven below are two statements: one is labelled as Assertion A and the other is labelled as Reason R\nAssertion A : Steel is used in the construction of buildings and bridges.\nReason R : Steel is more elastic and its elastic limit is high. In the light of above statements, choose the most\nappropriate answer from the options given below.",
                options = listOf("Both A and R are correct and R is the correct explanation of A", "A is correct but R is not correct", "Both A and R are correct but R is not the correct explanation of A", "A is not correct but R is correct"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nSteel is more elastic and has high elastic limit.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q13_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Physics Q13]\\nIf the distance of the earth from Sun is 1.5 × 106\n km. Then the distance of an imaginary planet from Sun, if \nits period of revolution is 2.83 years is:",
                options = listOf("6 × 106\n km", "3 × 107\n km", "3 × 106\n km", "6 × 107\n km"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n2\n3\nT  r\n2\n3\np\ne\np\ne\nr\nr\nT\nT\n\n\n\n\n\n\n\n\n\n \n\n\n\n\n\n\n \n\n\n\n\n\n\n\n\n\np\n6\n3\n2\nr\n1.5 10 km\n2.83year\n1 year\n\np\n6\nr\n1.5 10 km\n2\n1 \n\nrp = 3 × 106\n km",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q14_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Physics Q14]\\nThe frequency () of an oscillating liquid drop may depend upon radius (r) of the drop, density () of liquid \nand the surface tension (s) of the liquid as : = r\na\n\nb\n s\nc\n. The values of a, b and c respectively are",
                options = listOf("\n\n\n\n\n\n\n2\n1\n,\n2\n1\n,\n2\n3", "\n\n\n\n\n\n\n2\n1\n,\n2\n1\n,\n2\n3", "\n\n\n\n\n\n \n2\n1\n,\n2\n1\n,\n2\n3", "\n\n\n\n\n\n\n2\n1\n,\n2\n1\n,\n2\n3"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n[] = [T–1\n]\n[r] = L \n\n\n\n\n\n\n\nL\nMLT [s]\n2\n[ML ]\nL\nM [ ]\n3\n3\n\n\n\n\n\n\n\n \n  = r\na\n\nb\ns\nc\n T–1\n= La\n Mb\n L–3b Mc\n T–2c\n T–1\n = M(b + c) L(a – 3b) T–2c\n–\n2\n1\n 2c  1 c \nb + c = 0\n\n2\n1\nb  \na–3b = 0  3b = a \n2\n3\na  \n(a, b, c) = \n\n\n\n\n\n \n2\n1\n,\n2\n1\n,\n2\n3",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q15_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Physics Q15]\\nA cell of emf 90 V is connected across series combination of two resistors each of 100 resistance. A \nvoltmeter of resistance 400  is used to measure the potential difference across each resistor. The reading of \nthe voltmeter will be :",
                options = listOf("45V", "40V", "80V", "90V"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n\n\n\n\n\n\n  A\n2\n1\n180\n90 \nReading of voltmeter = 90 – 50 = 40V",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q16_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Physics Q16]\\nWhen a beam of white light is allowed to pass through convex lens parallel to principal axis, the different \ncolours of light converge at different point on the principle axis after refraction. This is called",
                options = listOf("Spherical aberration", "Chromatic aberration", "Polarisation", "Scattering"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nThe phenomena is known as chromatic aberration.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q17_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Physics Q17]\\nAn -particle, a proton and an electron have the same kinetic energy. Which one of the following is correct \nin case of their de-Broglie wavelength?",
                options = listOf(" > p < e", " = p = e", " > p > e", " < p < e"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n2mk\nh\nmv\nh\n  \nSo, \nm\n1\n \ne > p > ",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q18_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Physics Q18]\\nThe logic gate equivalent to the given circuit diagram is",
                options = listOf("NAND", "NOR", "AND", "OR"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nThe truth table for the circuit will be given as below\nThe above truth table is of NAND Gate.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q19_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Physics Q19]\\nGiven below are two statements: One is labelled as Assertion A and the other is labelled as Reason R.\nAssertion A: A pendulum clock when taken to Mount Everest becomes fast.\nReason R: The value of g (acceleration due to gravity) is less at Mount Everest than its value on the surface \nof earth. In the light of the above statements, choose the most appropriate answer from the options given \nbelow.",
                options = listOf("A is not correct but R is correct", "A is correct but R is not correct", "Both A and R are correct but R is NOT the correct explanation of A", "Both A and R are correct and R is the correct explanation of A"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nWhen we go on the Mount Everest the value of gravitational acceleration decreases\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n 2\ne\n0\nR\nh\n1\ng\ng Therefore, the time period of oscillation \n\n\n\n\n\n\n\n \ng\nT 2\n\n increases and the pendulum clock \nbecomes slow thus the assertion is wrong but reason is correct.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q20_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Physics Q20]\\nA metallic rod of length ‘L’ is rotated with an angular speed of ‘’ normal to a uniform magnetic field ‘B’ \nabout an axis passing through one end of rod as shown in figure. The induced emf will be",
                options = listOf("\n2 2 B L\n2\n1", "\n2 BL\n2\n1", "\n2 BL\n4\n1", "B L\n4\n1 2"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nVelocity of centre of rod \n2\nL\nv\n\n\nSo, emf = BvL = \n2\nB L\n2 \nSection-B: Numerical Value Type Questions: This section contains 10 questions. In Section B, attempt any \nfive questions out of 10. The answer to each question is a NUMERICAL VALUE. For each question, enter the \ncorrect numerical value (in decimal notation, truncated/rounded-off to the second decimal place; \ne.g. 06.25, 07.00, –00.33, –00.30, 30.27, –27.30) using the mouse and the on-screen virtual numeric keypad in \nthe place designated to enter the answer..",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q21_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Physics Q21]\\nA spherical ball of radius 1 mm and density 10.5 g/cc is dropped in glycerine of coefficient of viscosity 9.8 \npoise and density 1.5 g/cc. Viscous force on the ball when it attains constant velocity is 3696 × 10–x\n N. The \nvalue of x is (Given, g = 9.8 m/s2 and \n7\n22\n ",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 7\\nSolution:\\nAt state of terminal speed, net force on the ball is zero\n Fv = w – FB\n\n\n\n\n\n\n  \n\n\n\n\n\n    g\n3\ng\n3 R\n3\n4\nR\n3\n4\nb \n= R ( )g\n3\n4\nb\n3\n   \n= (10 ) [9 10 ] 9.8\n7\n22\n3\n4 3 3 3\n   \n\n= 3696 × 10–7\n x  7",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q22_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Physics Q22]\\nA parallel plate capacitor with air between the plate has a capacitance of 15 pF. The separation between the \nplate becomes twice and the space between them is filled with a medium of dielectric constant 3.5. Then the \ncapacitance becomes pF\n4\nx\n. The value of x is _____",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 105\\nSolution:\\nInitially\n15 10 F\nd\n0A 12\n \n\nFinally\n10 F\n4\nx\n2d\n3.5 0A 12\n \n\n\n4\nx\n15\n2\n3.5\n \n 105\n2\n3.5 15 4\nx \n \n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q23_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Physics Q23]\\nA mass m attached to free end of a spring executes SHM with a period of 1 s. If the mass is increased by 3 kg \nthe period of oscillation increases by one second, the value of mass m is ______ kg",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 1\\nSolution:\\n 1\nk\nm\n2  ..... (1)\nFinally\n1 1 2\nk\nm 3\n2   \n\n ..... (2)\nEquation \n(2)\n(1)\n gives\n2\n1\nm 3\nm\n\n\n m 1 kg",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q24_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Physics Q24]\\nA single turn current loop in the shape of a right angle triangle with sides 5 cm, 12 cm, 13 cm is carrying a \ncurrent of 2 A. The loop is in a uniform magnetic field of magnitude 0.75 T whose direction is parallel to the \ncurrent in the 13 cm side of the loop. The magnitude of the magnetic force on the 5 cm side will be N\n130\nx\n. \nThe value of x is _______",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 9\\nSolution:\\nForce on 5 cm side = IB sin\n\n13\n12 0.75\n100\n5\n2  \n= \n130\n9\nX = 9",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q25_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Physics Q25]\\nA uniform solid cylinder with radius R and length L has moment of inertia I1, about the axis of the cylinder. \nA concentric solid cylinder of radius \n2\nR\nR' and length \n2\nL\nL' is carved out of the original cylinder. If I2 is \nthe moment of inertia of the carved out portion of the cylinder then \n2\n1\nI\nI\n = ______ . (Both 1 and 2 are about \nthe axis of the cylinder)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 32\\nSolution:\\n2\n( R L)R\nI\n2 2\n1\n\n (: density of cylinder)\n2\n2\nR\n2\nL\n2\nR\nI\n2 2\n2\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n1\n32\nI\nI\n2\n1 ",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q26_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Physics Q26]\\nA convex lens of refractive index 1.5 and focal length 18 cm in air is immersed in water. The change in focal \nlength of the lens will be __________ cm. (Given refractive index of water = \n3\n4",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 54\\nSolution:\\nFrom lens makers formula\n\n\n\n\n\n\n \n\n\n\n\n\n\n\n\n\n\n\nmedium 1 2\nterms\nR\n1\nR\n1\n1\nf\n1\nWhen in air\n\n\n\n\n\n\n \n\n\n\n\n\n \n1 R2\n1\nR\n1\n1\n1\n1.5\n18\n1\n..... (1)\nlense = 1.5, air = 1.\nwhen in water\n\n\n\n\n\n\n \n\n\n\n\n\n \nR2\n1\nR\n1\n1\n4/ 3\n1.5\nf\n1\n..... (2)\nfrom (1) & (2)\nf = 72\nChange in focal length = 72 – 18 = 54",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q27_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Physics Q27]\\nA body of mass 1 kg begins to move under the action of a time dependent force F (ti\nˆ 3t\nˆ\nj)N\n2\n \n\n where i\nˆ\nand j\nˆ\n are the unit vectors along x and y axis. The power developed by above force, at the time t = 2 s, will be \n________ W.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 100\\nSolution:\\nj\nˆ\ni 3t\nˆ F t\n2\n \n\nj\nˆ\ni 3t\nˆ\nt\nm\nF\na\n2\n  \n\n\n(m = 1)\nj\nˆ\ni 8\nˆ v a dt 2\n2\n0\n  \n\n \n(\n\nv at t = 2s)\nP  F  v  F (t  2s) v(t  2s)\n   \nj) (2i 8j)\nˆ\ni 12 ˆ\n(2   \n= 4 + 96\n= 100W",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q28_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Physics Q28]\\nThree identical resistors with resistance R = 12  and two identical inductors with self-inductance L = 5 mH \nare connected to an ideal battery with emf of 12 V as shown in figure. The current through the battery long \nafter the switch has been closed will be __________ A.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 03\\nSolution:\\nAfter long time, inductors are shorted.\nEffective circuit becomes\nCurrent through battery =\n\n\n4\n12V\nR\nV\neq\n = 3A\nwhere Req = 3 resistors in parallel.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q29_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Physics Q29]\\nThe energy released per fission of nucleus of 240X is 200 MeV. The energy released if all the atoms in 120 g \nof pure 240X undergo fission is ______ × 1025 MeV. (Given NA = 6 × 1023)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 6\\nSolution:\\n120 g of 240X will have \n2\n1\n mole of X\nNumber of atom of 23\nA N 3 10\n2\n1\nX     atom\nEnergy released = 3 × 1023 × 200 MeV\n= 6 × 1025 MeV",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q30_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Physics Q30]\\nIf a copper wire is stretched to increase its length by 20%. The percentage increase in resistance of the wire is \n___________ %.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 44\\nSolution:\\nlet 0 be its initial length and A0 be initial area.\nConsidering volume to be conserved\nVol. = 0A0 = (1.2 0)A\n1.2\nA\nA\n0\nfinal \n0\n0\nin A\nR\n\n\n2\n0\n0\n0\n0\nfinal (1.2)\nA\n1.2\nA\n1.2\nR\n \n\n\n\n= Rin (1.44)\nHence increase = 44%",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q31_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Chemistry Q31]\\nIn which of the following reactions the hydrogen peroxide acts as a reducing agent?",
                options = listOf("HOCl + H2O2 → H3O\n+\n + Cl–\n + O2", "PbS + 4H2O2 → PbSO4 + 4H2O", "2Fe2+ + H2O2 → 2Fe3+ + 2OH–", "Mn2+ + H2O2 → Mn4+ + 2OH–"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nHOCl + H2O2  H3O\n\n ClΘ\n + O2\nIn this reaction H2O2 is acting as a reducing agent as Cl is undergoing a change in oxidation state from +1 to – 1.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q32_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Chemistry Q32]\\nChoose the correct colour of the product for the following reaction.",
                options = listOf("Blue", "Red", "Yellow", "White"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q33_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Chemistry Q33]\\nWhich one amongst the following are good oxidizing agents?\nA. Sm2+ B. Ce2+ C. Ce4+ D. Tb4+\nChoose the most appropriate answer from the options given below.",
                options = listOf("C only", "A and B only", "D only", "C and D only"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nCe+4 and Tb+4 are strong oxidising agents as the common oxidation state of Lanthanides is (+3).",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q34_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Chemistry Q34]\\nGiven below are two statements:\nStatement-I : Pure Aniline and other arylamines are usually colourless.\nStatement-II : Arylamines get coloured on storage due to atmospheric reduction.\nIn the light of the above statements, choose the most appropriate answer from the options given below:",
                options = listOf("Statement-I is correct but Statement-II is incorrect", "Both Statement-I and Statement-II are incorrect", "Statement-I is incorrect but Statement-II is correct", "Both Statement-I and Statement-II are correct"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nBoth Statement-I and Statement-II is incorrect as arylamines get coloured due to atmospheric oxidation.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q35_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Chemistry Q35]\\nThe metal which is extracted by oxidation and subsequent reduction from its ore is",
                options = listOf("Al", "Cu", "Fe", "Ag"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nAg is first extracted by oxidation and then subsequent reduction is carried out to obtain\n4Ag + 8NaCN + 2H2O + O2 Oxidation 4Na [Ag (CN)2] + 4NaOH\n2Na[Ag(CN)2] + Zn reduction  Na2[Zn(CN)4] + 2Ag",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q36_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Chemistry Q36]\\nGiven below are two statements, one is labelled as\nAssertion A and the other is labelled as Reason R. \nAssertion A : Benzene is more stable than hypothetical cyclohexatriene. \nReason R : The delocalized π electron cloud is attracted more strongly by nuclei of carbon atoms. \nIn the light of the above statements, choose the correct answer from the options given below.",
                options = listOf("Both A and R are correct but R is NOT the correct explanation of A", "Both A and R are correct and R is the correct explanation of A", "A is true but R is false", "A is true but R is false"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nBenzene is more stable than hypothetical cyclohexatriene due to resonance.\nSo, 1st statement is correct. \nAs the delocalised π-electron cloud is attracted more strongly by the nuclei of carbon atoms, therefore \nbenzene is resonance stabilized. It is also aromatic in character.\nHence, the correct answer is (2)",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q37_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Chemistry Q37]\\nGiven below are two statements, one is labelled as \nAssertion A : and the other is labelled as Reason R.\nAssertion A : Beryllium has less negative value of reduction potential compared to the other alkaline earth \nmetals. \nReason R: Beryllium has large hydration energy due to small size of Be2+ but relatively large value of \natomization enthalpy. \nIn the light of the above statements, choose the most appropriate answer from the options given below.",
                options = listOf("Both A and R are correct but R is NOT the correct explanation of A", "A is correct but R is not correct", "Both A and R are correct and R is the correct explanation of A", "A is not correct but R is correct"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n1\nst statement is correct as Be has least negative value of reduction potential among alkaline earth metals. \n2\nnd statement is also correct.\nThe reducing nature is indeed less due to high atomisation enthalpy and ionisation enthalpy while having \nlarge hydration enthalpy of Be+2. Correct answer is (3)",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q38_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Chemistry Q38]\\nWhich of the following cannot be explained by crystal field theory?",
                options = listOf("Stability of metal complexes", "The order of spectrochemical series", "Magnetic properties of transition metal complexes", "Colour of metal complexes"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nCFT does not explain the order of spectrochemical series because as per CFT, anionic ligands should exert \ngreatest splitting effect. However, they lie on lower end of the spectrochemical series.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q39_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Chemistry Q39]\\nWhat is the number of unpaired electron(s) in the highest occupied molecular orbital of the following \nspecies: N2 ;  N2\n; O ;  O2\n ?",
                options = listOf("0, 1, 0, 1", "0, 1, 2, 1", "2, 1, 2, 1", "2, 1, 0, 1"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nMolecule No. of unpaired electron in\nhighest occupied\nmolecular orbital\nN2 0\n N2\n1\nO2 2\n O2\n1\nCorrect answer is (2)",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q40_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Chemistry Q40]\\nChoose the correct representation of conductometric titration of benzoic acid vs sodium hydroxide.",
                options = listOf("VNaOH \nConductance", "VNaOH \nConductance", "VNaOH\nConductance", "VNaOH \nConductance"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nCorrect graph is : \nVNaOH \nConductance",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q41_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Chemistry Q41]\\nWhich will undergo deprotonation most readily in basic medium\nO O O O\na b\nMeO OMe\nc\nOMe\nO O",
                options = listOf("c only", "a only", "Both a and c", "b only"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n(a) Since most readily is asked, deprotonation will be easily possible for (a).\n∴ The correct answer is (2)\nIn (b) and (c), tendency for deprotonation is less due to cross conjugation.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q42_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Chemistry Q42]\\nIdentify the correct statements about alkali metals.\nA. The order of standard reduction potential (M+ | M) for alkali metal ions is Na > Rb > Li. \nB. CsI is highly soluble in water.\nC. Lithium carbonate is highly stable to heat.\nD. Potassium dissolved in concentrated liquid ammonia is blue in colour and paramagnetic.\nE. All the alkali metal hydrides are ionic solids.\nChoose the correct answer from the options given below.",
                options = listOf("A, B and E only", "A, B, D only", "C and E only", "A and E only"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nA. The order given is correct \nB. CsI is less soluble in water due to less hydration enthalpy.\nC. Li2CO3  Li2O + CO2\nD. In concentrated liquid ammonia, solution becomes diamagnetic\nE. Alkali metal hydrides are ionic solids.\nThe correct answer is (A and E) only.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q43_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Chemistry Q43]\\nThe hybridization and magnetic behaviour of cobalt ion in [Co(NH3)6]\n3+ complex, respectively is",
                options = listOf("d\n2\nsp\n3\n and paramagnetic", "sp\n3\nd\n2\n and diamagnetic", "sp\n3\nd\n2\n and paramagnetic", "d\n2\nsp\n3\n and diamagnetic"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n[Co(NH3)6]\n3+ is diamagnetic with d2\nsp\n3\nhybridisation of Co3+\n.\nThis is because NH3 is a strong field ligand and forces electrons to pair up in a d6\n configuration.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q44_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Chemistry Q44]\\nCorrect statement is:",
                options = listOf("An average human being consumes nearly 15 times more air than food", "An average human being consumes more food than air", "An average human being consumes 100 times more air than food", "An average human being consumes equal amount of food and air"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nAn average human being consumes 15 times more air than food.\nThe correct answer is (1).",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q45_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Chemistry Q45]\\nFind out the major products from the following reactions.",
                options = listOf("", "", "", ""),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nThe correct answer is (2).",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q46_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Chemistry Q46]\\nMatch List-I with List-II\nList-I\nType\nList-II\nName\nA. Antifertility drug I. Norethindrone\nB. Tranquilizer II. Meprobomate\nC. Antihistamine III. Seldane\nD. Antibiotic IV. Ampicillin\nChoose the correct answer from the options given below",
                options = listOf("A-II, B-I, C-III, D-IV", "A-I, B-II, C-III, D-IV", "A-I, B-III, C-II, D-IV", "A-IV, B-III, C-II, D-I"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nCorrect match is \nA. Antifertility drug (I) Norethindrone\nB. Tranquilizer (II) Meprobomate\nC. Antihistamine (III) Seldane\nD. Antibiotic (IV) Ampicillin",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q47_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Chemistry Q47]\\nK2Cr2O7 paper acidified with dilute H2SO4 turns green when exposed to",
                options = listOf("Hydrogen sulphide", "Carbon dioxide", "Sulphur dioxide", "Sulphur trioxide"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nSO2 gets oxidised in presence of K2Cr2O7 and it converts to Cr+3 in presence of dil. H2SO4.\nSimilarly, H2S can also get oxidized to sulphur. \nHowever, most appropriate is (3).",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q48_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Chemistry Q48]\\nGiven below are two statements:\nStatement I : \nunder Clemmensen reduction conditions will give \nStatement II:\nunder Wolff- Kishner reduction condition will give\nIn the light of the above statements, choose the correct answer from the options given below:",
                options = listOf("Statement I is true but Statement II is false", "Both Statement I and Statement II are false", "Both Statement I and Statement II are true", "Statement I is false but Statement II is true"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n∴ Statement I is true but statement II is false.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q49_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Chemistry Q49]\\nThe number of s-electrons present in an ion with 55 protons in its unipositive state is",
                options = listOf("10", "8", "9", "12"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n55 protons are present in Cs\n Number of s-electrons = 10",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q50_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Chemistry Q50]\\nA student has studied the decomposition of a gas AB3 at 25ºC. He obtained the following data.\np (mm Hg) 50 100 200 400\nrelative t1/2 (s) 4 2 1 0.5\nThe order of the reaction is",
                options = listOf("1", "0(Zero)", "2", "0.5"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nAB3(g)  A(g) + 3B(g) or \n2\n3\nB2(g)\nAs decomposition reaction of AB3(g) is not given, we assume that p(mm Hg) is for AB3(g) only.\n t1/2  (p)1–n\n Order of reaction is 2 as t1/2 \np\n1\nSection-B: Numerical Value Type Questions: This section contains 10 questions. In Section B, attempt any \nfive questions out of 10. The answer to each question is a NUMERICAL VALUE. For each question, enter the \ncorrect numerical value (in decimal notation, truncated/rounded-off to the second decimal place; e.g. 06.25, \n07.00, –00.33, –00.30, 30.27, –27.30) using the mouse and the on-screen virtual numeric keypad in the place \ndesignated to enter the answer.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q51_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Chemistry Q51]\\nMaximum number of isomeric monochloro derivatives which can be obtained from 2,2,5,\n5-tetramethylhexane by chlorination is_______",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 3\\nSolution:\\nTotal isomers = 3\n(considering stereoisomers)",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q52_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Chemistry Q52]\\nTotal number of tripeptides possible by mixing of valine and proline is________",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 8\\nSolution:\\nConsidering only linear tripeptides, total number of tripeptides are 8 or 23\n.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q53_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Chemistry Q53]\\nSum of π - bonds present in peroxodisulphuric acid and pyrosulphuric acid is ________",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 8\\nSolution:\\n(H2S2O8) (peroxodi sulphuric acid)\n(H2S2O7) (pyro sulphuric acid)\nNumber of π-bonds = 8",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q54_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Chemistry Q54]\\nThe total pressure observed by mixing two liquids A and B is 350 mm Hg when their mole fractions are 0.7\nand 0.3 respectively.\nThe total pressure becomes 410 mm Hg if the mole fractions are changed to 0.2 and 0.8 respectively for A\nand B. The vapour pressure of pure A is _______mm Hg. (Nearest integer). Consider the liquids and \nsolutions behave ideally.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 314\\nSolution:\\n350 = º PA\n(0.7) + º PB\n(0.3)\n410 = º PA\n (0.2) + º PB\n(0.8)\n–21700 = –\nº PB\n(50)\nº PB = 434 mmHg\nº PA = 314 mmHg",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q55_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Chemistry Q55]\\nIf the pKa of lactic acid is 5, then the pH of 0.005 M calcium lactate solution at 25° C is ______× 10–1\n(Nearest integer)\nLactic acid",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 85\\nSolution:\\npH = 7 + \n2\n1\n(pka + log c)\n= 7 + \n2\n1\n (5 – 2)\n= 7 + 1.5 = 8.5",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q56_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Chemistry Q56]\\nThe number of statement/s which are the characteristics of physisorption is _________\nA. It is highly specific in nature\nB. Enthalpy of adsorption is high\nC. It decreases with increases in temperature\nD. It results into unimolecular layer\nE. No activation energy in needed",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 2\\nSolution:\\nA. It is non-specific\nB. It is low\nC. Extent of adsorption decreases with increase of temperature\nD. It results in multimolecular layer\nE. No activation energy is needed\nNo. of correct statements = 2",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q57_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Chemistry Q57]\\nFollowing figure shows spectrum of an ideal black body at four different temperatures. The number of\ncorrect statement/s from the following is ________\nWavelength \nEnergy distribution \n\nT4\nT3\nT2\nT1\nA. T4 > T3 > T2 > T1\nB. The black body consists of particles performing simple harmonic motion.\nC. The peak of the spectrum shifts to shorter wavelength as temperature increases.\nD. \n3\n3\n2\n2\n1\nT1 T T\n\n\n\n\n\nconstant \nE. The given spectrum could be explained using quantisation of energy.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 2\\nSolution:\\nA. T1 > T2 > T3 > T4\nB. It is incorrect as particles do not undergo simple harmonic motion.\nC. It is correct\nD. It is incorrect\nE. It is correct",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q58_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Chemistry Q58]\\nThe number of statement/s, which are correct with respect to the compression of carbon dioxide from point \n(a) in the Andrews isotherm from the following is ________\nVolume \nPressure \n\na\nc b\nd\nA. Carbon dioxide remains as a gas upto point (b)\nB. Liquid carbon dioxide appears at point (c)\nC. Liquid and gaseous carbon dioxide coexist between points (b) and (c)\nD. As the volume decreases from (b) to (c), the amount of liquid decreases",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 2\\nSolution:\\nA. It is correct\nB. It is incorrect as it appears at point (b)\nC. It is also correct\nD. It is incorrect.\nNumber of correct statements = 2",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q59_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Chemistry Q59]\\nOne mole of an ideal monoatomic gas is subjected to changes as shown in the graph. The magnitude of the \nwork done (by the system or on the system) is________ J (nearest integer)\n3\n2\n1\n1.0\n0.5\n20 40\nVolume (L)\nPressure (bar) \n\nGiven: log 2 = 0.3\n ln 10 = 2.3",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 620\\nSolution:\\nW3  1 = – 2.3\n40\n20 20log  \n\n\n\n\n\n= +20 × 0.3 × 100 × 2.3 J\n= 1.38 kJ\nW2→3 = 0\nW1→2 = –1 × 20 × 100 = –2 kJ\nW1→2 + W2→3 + W3→1 = 1.38 – 2 = – 0.62 kJ\n|W| = 620 J",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q60_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Chemistry Q60]\\nThe number of units, which are used to express concentration of solutions from the following is______\nMass percent, Mole, Mole fraction, Molarity, ppm, Molality",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 5\\nSolution:\\nMass percent, mole fraction, molarity, ppm & molality are used to express concentration. So, number of units \n= 5",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q61_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Mathematics Q61]\\nThe set of all values of a for which\nx a\nlim\n\n([x – 5] – [2x + 2]) = 0, where [] denotes the greatest integer less \nthan or equal to  is equal to",
                options = listOf("[–7.5, –6.5)", "(–7.5, –6.5]", "[–7.5, –6.5]", "(–7.5, –6.5)"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nx a\nlim\n\n([x – 5] – [2x + 2]) = 0\n [x – 5] = [2x + 2]\n [x] –5 = [2x] + 2\n [x] = [2x] + 7 …(i)\nif x  Z we have\nx = – 7\nalso 2x  Z if x is of form z \n2\n1\n\nHence, if x  ( –7.5, –7) eq. (1) become\n–8 = –15 + 7  7 = 7\nSimilarly, if x  ( –7, – 6.5) in eq. (1)\n–7 = – 14 + 7  7 = 7\nAt x = –6.5 in eq. (1)\n–7 = –13 + 7  –14  –13 not possible\nAt x = –7.5 in eq. (1)\n–8 = –15+7  8 = 8\nBut x → a a  –6.5 or – 7.5\n a  ( –7.5, –6.5)",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q62_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Mathematics Q62]\\nLet p and q be two statements. Then ~ (p  (p  ~q) is equivalent to",
                options = listOf("(~p)  q", "p  ((~p)  q)", "p  (p  q)", "p  (p ( q))"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nMaking truth table (E  (p  (p  q))\n &\n ~ (p  (p  q)) is equivalent to ~ p  q",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q63_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Mathematics Q63]\\nThe locus of the mid points of the chords of the circle C1 : (x – 4)2\n + (y – 5)2\n = 4 which subtend an angle i at \nthe centre of the circle C1, is a circle of radius ri. If  = \n3\n\n,  =\n3\n2\n and 2\n3\n2\n2\n2\n1\nr  r  r , then 2 is equal to",
                options = listOf("4\n3", "4\n", "6\n", "2\n"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n\n2\nr\n2\ncos 1 i\n \n\n\n\n\n \n ri\n = 2cos \n\n\n\n\n \n2\ni\nGiven 2\n3\n2\n2\n2\n1\nr  r  r\n\n2\n1\n2\ncos \n\n\n\n\n\n\n\n\n\n\n\n\n \n= \n2\n2\n2\ncos \n\n\n\n\n\n\n\n\n\n\n\n\n \n+\n2\n3\n2\ncos \n\n\n\n\n\n\n\n\n\n\n\n\n \n\n4\n3\n= \n4\n1\n2\ncos2 2\n \n\n\n\n\n \n\n2\n1\n2\ncos2 2\n \n\n\n\n\n \n\n2 4\n2 \n\n\n\n2\n2\n\n ",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q64_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Mathematics Q64]\\nIf \n2 2\n2\nf(x)\n2x\n2x\n\n , x  R , then \n\n\n\n\n\n  \n\n\n\n\n\n \n\n\n\n\n\n2023\n2022\n....... f\n2023\n2\nf\n2023\n1\nf is equal to",
                options = listOf("1010", "2011", "1011", "2010"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n2 2\n2\nf(x)\n2x\n2x\n\n and \n2 2\n2\nf(1 x)\n2(1 x)\n2(1 x)\n\n  \n\n f(x) + f(1 – x) = 1\nPairs\n1 1\n........ 1011\n2022\n2021 f\n2022\n2\nf\n2023\n2022 f\n2022\n1\nf\n2022\nK\nf\n2022\nK 1\n  \n\n\n\n\n\n \n\n\n\n\n\n \n\n\n\n\n\n \n\n\n\n\n\n \n\n\n\n\n   \n = 1011",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q65_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Mathematics Q65]\\nIf the system of equations\nx + 2y + 3z = 3\n4x + 3y – 4z = 4\n8x + 4y – z = 9 + \nhas infinitely many solutions, then the ordered pair (, ) is equal to :",
                options = listOf("\n\n\n\n\n\n\n5\n21\n,\n5\n72", "\n\n\n\n\n\n\n5\n21\n,\n5\n72", "\n\n\n\n\n\n5\n21\n,\n5\n72", "\n\n\n\n\n\n \n5\n21\n,\n5\n72"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nD =\n \n\n8 4\n4 3 4\n1 2 3\n = 0  = \n5\n72\nDz = \n8 4 9  \n4 3 4\n1 2 3\n = \n5\n21",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q66_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Mathematics Q66]\\nLet the plane containing the line of intersection of the planes P1: x + ( + 4) y + z = 1 and P2 : 2x + y + z = 2 \npass through the points (0, 1, 0) and (1, 0, 1). Then the distance of the point (2  − ) from the plane P2 is",
                options = listOf("4 6", "3 6", "5 6", "2 6"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nEquation of plane :\n(x + ( + 4) y + z −1) + k (2x + y + z − 2) = 0\nPasses through (0, 1, 0) and (1, 0, 1)\n  + 4 −1+ k (−1) = 0\nl  k    …(i)\n& (1 + 0 + 0) + k (1) = 0\nk = −1   = −4\nP2 : 2x + y + z = 2, Point (−8, − 4, 4)\nDistance = \n\n\n\n\n   \n6\n16 4 4 2\n= 3 6 units",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q67_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Mathematics Q67]\\nIf         2\n2\n30\n30 2\n3\n30 2\n2\n30 2\n1\n30\n(30!)\n60!\nC 2 C 3 C ....... 30 C\n\n     = then  is equal to :",
                options = listOf("60", "30", "15", "10"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n   \n\n\n\n30\nr 1\nr\n30\nr 1\n29\n30\nr 1\n2\nr\n30 r. C 30. C . C\n= \n \n30\nr 1\n30 r\n30\nr 1\n29 30. C . C\n= 30\n59 30. C\n= \n30\n30\n.\n30!.29!\n59!\n30.\n= 2\n(30!)\n15.60!",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q68_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Mathematics Q68]\\nIf the foot of the perpendicular drawn from (1, 9, 7) to the line passing through the point (3, 2, 1) and parallel \nto the planes x + 2y + z = 0 and 3y – z = 3 is (, , ), then  +  +  is equal to",
                options = listOf("–1", "1", "3", "5"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nDirection of line\nb\n\n = \n0 3 1\n1 2 1\nk\nˆ\nj\nˆ\ni\nˆ\n\n= k(3)\nˆ\nj( 1)\nˆ\ni( 5)\nˆ    \n= k\nˆ\nj 3\nˆ\ni\nˆ  5  \nEquation of line\n3\nz 1\n1\ny 2\n5\nx 3 \n\n\n\n\n\nLet foot of perpendicular be = (–5k + 3, k + 2, 3k + 1)\n (−5k + 2)(−5) + (k − 7)(1) + (3k − 6)(3) = 0\nOr 25k – 10 + k – 7 + 9k – 18 = 0\nOr k = 1\n +  +  = –k + 6 = 5",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q69_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Mathematics Q69]\\nLet A be a 3 × 3 matrix such that |adj (adj (adj A))| = 124\n. Then |A\n–1\n adj A| is equal to",
                options = listOf("12", "2 3", "6", "1"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n3\n(n 1)\n| A |\n\n= 124\n|A|8\n = 124\n|A| = 12\n|A–1\n adjA| = |A–1\n| . |A|2\n= |A|",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q70_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Mathematics Q70]\\nThe value of\n3\n9\ni cos\n9\n1 sin\n9\ni cos\n9\n1 sin\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n is -",
                options = listOf("( 3 i)\n2\n1\n", "(1 i 3)\n2\n1\n ", "(1 i 3)\n2\n1\n", "( 3 i)\n2\n1\n "),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nz = \n3\n9\ni cos\n9\n1 sin\n9\ni cos\n9\n1 sin\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n1 + sin\n9\n2\n + i cos\n9\n2\n= 1 + cos\n18\n5\n+ i sin\n18\n5\n= 1 + 2 cos2\n36\n5\n– 1 + 2i sin\n36\n5\ncos\n36\n5\n= 2cos\n36\n5\n\n\n\n\n\n \n\n\n36\n5\nisin\n36\n5\ncos = 2 cos 36\n5\ni\ne\n36\n5\n\n\n z = \n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n \n\n\n\n\n\n \n\n\n\n36\n5\ni\n36\n5\ni\ne\n36\n5\n2cos\ne\n36\n5\n2cos\n = 6\n5\ni\ne\n\nz = – i\n2\n1\n2\n3\n = (i 3)\n2\n1\n = ( 3 i)\n2\n1\n ",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q71_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Mathematics Q71]\\nThe number of square matrices of order 5 with entries from the set {0, 1}, such that the sum of all the \nelements in each row is 1 and the sum of all the elements in each column is also 1, is",
                options = listOf("120", "225", "150", "125"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n    \n    \n    \n    \n    \n In every row and every column there would be exactly one 1 and four zeroes.\nNumber of matrices = 5C1\n4C1\n3C1\n2C1\n1C1=120\nOption (1) is correct.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q72_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Mathematics Q72]\\n\n\n4\n3 3\n4\n3 2 2\ndx\n9 4x\n48 is equal to",
                options = listOf("6\n", "2\n", "3\n", "2"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nI = \n\n4\n3 3\n4\n3 2 2\ndx\n9 4x\n48\n = \n4\n3 3\n4\n3 2\n1\n2\n1\n.\n3\n2x\n48.sin \n\n\n\n\n\n\n\n\n\n\n \n= \n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n2\n1\nsin\n2\n3\n24 sin 1 –1\n= \n\n\n\n\n \n\n\n3 4\n24 = 24.\n12\n\n= 2\nOption (4) is correct.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q73_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Mathematics Q73]\\nThe number of real solutions of the equation 5 0\nx\n1\n2 x\nx\n1\n3 x\n2\n2\n  \n\n\n\n\n\n  \n\n\n\n\n\n , is",
                options = listOf("3", "0", "2", "4"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n5 0\nx\n1\n2 x\nx\n1\n3 x\n2\n2\n  \n\n\n\n\n\n  \n\n\n\n\n\n\n5 0\nx\n1\n2 2 x\nx\n1\n3 x\n2\n  \n\n\n\n\n\n \n\n\n\n\n\n\n\n\n \n\n\n\n\n\n\nPut x + \nx\n1\n= t  t  (–, –2]  [2, )\n3t\n2\n– 2t – 1 = 0\n3t\n2\n– 3t + t – 1 = 0\n 3t(t – 1) +1 (t – 1) = 0  t = 1, –\n3\n1\n t = 1, –\n3\n1\n t  (–, –2]  [2, )\nNo real value of t  no real value of x.\nOption (2) is correct.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q74_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Mathematics Q74]\\nLet k\nˆ\nj 5\nˆ\ni 3\nˆ   4  \n\n and k\nˆ\nj 4\nˆ\ni 2\nˆ    \n\n. Let 1\n\nbe parallel to \n\nand 2\n\nbe perpendicular to \n\n. If\n\n\n= 1\n\n+2\n\n, then the value of 2\n5\n\n. k)\nˆ\nj\nˆ\ni\nˆ\n(   is",
                options = listOf("7", "9", "6", "11"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nk)\nˆ\nj 5\nˆ\ni 3\nˆ\n(4 1    \n\n=   \n\n \n, .\n2\n = 0\n   1  2    2\n \n  \n\n\n\n. = .\n2\n |  |\n\n+ 0  = \n5\n1\n50\n10\n \n\n2\n5\n1\n     \n \n\nk)\nˆ\nj 15 ˆ\ni 13 ˆ 5 5 (9 2       \n \n\nk)\nˆ\nj\nˆ\ni\nˆ 5 .( 2  \n\n = 9 + 13 – 15 = 7\nOption (1) is correct.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q75_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Mathematics Q75]\\nLet f(x) be a function such that f(x + y) = f(x)f(y) for all x, y . If f(1) = 3 and \nn\nk 1\nf(k) = 3279, then the\nvalue of n is\n(1) 8 (2) 9 (3) 6 (4) 7",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 4\\nSolution:\\nf (x + y ) = f (x) · f (y)\n f (x) = a\nx\n f (1) = 3\n f (x) = 3\nx\n\nn\nk 1\nf(x)\n\n2\n3(3 1)\nn\n\n= 3279\n 3\nn\n = 2187 \n n = 7",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q76_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Mathematics Q76]\\nThe number of integers, greater than 7000 that can be formed, using the digits 3, 5, 6, 7, 8 without repetition, \nis",
                options = listOf("48", "168", "220", "120"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n7\nNumber of integers = 4 × 3 × 2 = 24\n8\n4 × 3 × 2 = 24\n 24 + 24 = 48\n5 digit integers = 5! = 120\n 120 + 48 = 168",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q77_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Mathematics Q77]\\nIf f (x) = x\n3\n− x\n2\nf (1) + xf  (2) − f (3), x R, then\n(1) 2f (0) − f (1) + f (3) = f (2) (2) f (3) − f (2) = f (1)\n(3) 3f (1) + f (2) = f (3) (4) f (1) + f (2) + f (3) = f (0)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 1\\nSolution:\\nf (x) = x\n3\n− x\n2\n f (1) + xf  (2) − f (3) …(i)\nf (x) = 3x\n2\n− 2xf (1) + f (2) …(ii)\nf (x) = 6x − 2f (1) …(iii)\nf (x) = 6\n f (3) = 6\nfrom (iii) : f (2) = 12 − 2f (1) …(iv)\nfrom (ii) : f (1) = 3 − 2f (1) + f (2)\n f (2) = 3f (1) − 3 …(v)\nfrom (iv) and (v)\nf (2) = 6, f (1) = 3\nf (x) = x\n3\n− 3x\n2\n+ 6x − 6\nf (0) = − 6, f (1) = −2, f (2) = 2, f (3) = 12",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q78_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Mathematics Q78]\\nThe equations of the sides AB and AC of a triangle ABC are ( + 1)x + y = 4 and x + (1 – )y +  = 0\nrespectively. Its vertex A is on the y-axis and its orthocentre is (1, 2). The length of the tangent from the point \nC to the part of the parabola y\n2\n = 6x in the first quadrant is :",
                options = listOf("2 2", "6", "2", "4"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nLet point A be \n\n\n\n\n\n\n4\n9, or \n\n\n\n\n\n \n \n1\n0,\n \n\n\n 1\n4\n  = 2\nNow,\nAB : 3x + 2y = 4\nAC : 2x – y = –2\nMAB = −\n2\n3\n MOC =\n3\n2\nLet C(h, 2h + 2)\nMOC= \nh 1\n2h\n\n\n3\n2\n= \nh 1\n2h\n\n h = −\n2\n1\n \n\n\n\n\n \n,1\n2\n1\nC\nNow, ty = x + \n2\n3\nt\n2\nis tangent passing through \n\n\n\n\n\n ,1\n2\n1\nC\n t = 1  POC is \n\n\n\n\n\n, 3\n2\n3\n Length = 2 2",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q79_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Mathematics Q79]\\nLet y = y(x) be the solution of the differential equation (x\n2\n− 3y\n2\n)dx + 3xy dy = 0, y(1) = 1. Then 6y\n2\n(e) is \nequal to\n(1) 3e\n2\n(2) \n2\n3\ne\n2\n(3) e\n2\n(4) 2e\n2",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 4\\nSolution:\\n(x\n2\n− 3y\n2\n)dx + 3xy dy = 0, y(1) = 1\n 3xy \ndx\ndy\n− 3y2\n= − x\n2\n y\n3\nx\nx\ny\ndx\ndy 2\n\n \n 2y\n3\n2x\nx\n2y\ndx\ndy 2\n\n \nLet y\n2\n = t  2y \ndx\ndy\n= \ndx\ndt\ndx\ndt\n–\nx\n2t\n=\n3\n2x\nIF = 2\nx\n1\n\n3\n2\nx\ny\n2\n2\n\n In |x| + c\nx = 1, y = 1  c = 1\n y\n2\n = \n3\n2\nx\n2\n ln |x| + c\nx =1, y = 1,  c = \n y\n2\n = \n3\n2\nx\n2\n In |x| + x2\nNow, x = e\ny\n2 \n=\n3\n2e\n2\n\n+ e2\n = \n3\ne\n2\n 6y\n2\n = 2e\n2",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q80_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Mathematics Q80]\\nLet the six numbers a1, a2, a3, a4, a5, a6 be in A.P. and a1 + a3 = 10. If the mean of these six numbers is\n2\n19 and \ntheir variance is \n2\n, then 8\n2\n is equal to:",
                options = listOf("200", "105", "220", "210"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nGiven : a1, a2, a3, a4, a5, a6 _______ A.P.\nand a1 + a3 = 10 \nLet the common difference be d\nthen, 2a1 + 2d = 10\n a1 + d = 5 …(i)\nand \n6\na a ..... a 1  2   6 =\n2\n19\n 2a1+ 5d = 19 …(ii)\nBy (i) and (ii)\nd  3 and a1 = 2 \n a2 = 5, a3 =8, a4=11, a5=14, a6 = 17\n Variance =\n4\n105\n4\n361\n2\n233\n  = \n2\n 8 = 210\nSection-B: Numerical Value Type Questions: This section contains 10 questions. In Section B, attempt \nany five questions out of 10. The answer to each question is a NUMERICAL VALUE. For each question, \nenter the correct numerical value (in decimal notation, truncated/rounded-off to the second decimal place; \ne.g. 06.25, 07.00, –00.33, –00.30, 30.27, –27.30) using the mouse and the on-screen virtual numeric \nkeypad in the place designated to enter the answer.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q81_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Mathematics Q81]\\nLet f be a differentiable function defined on \n\n\n\n\n \n2\n0, , such that f(x) > 0 and\nf(x) + \n \nx\n0\n2\ne\nf(t) 1 (log f(t)) dt e , \n\n\n\n\n \n \n2\nx 0, . Then\n2\ne\n6\n6log f\n\n\n\n\n\n\n\n\n\n\n\n\n\n \nis equal to ___________.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 27\\nSolution:\\nf(x) + \n \nx\n0\n2\ne\nf(t) 1 (log f(t)) dt e ......(1)\nSo, f(0) = e\nNow differentiate w.r. to x\nf ' (x) + f (x)\n2\ne 1 (log f(x) = 0 \n2\ne\nf(x) 1 (log f(x))\nf'(x)\n\n= – 1\nLet logef(x) = t  \n\n2\n1 t\ndt\n = −x + c \n sin–1\nt = –x + c\nNow f(0) = e  t 1 So, \n2\nc\n\n\n t = sin \n\n\n\n\n\n\n\nx\n2\n= cosx \n\n\n\n\n\n\n\n\n\n\n\n\n \n\n2\nx 0,\n\n2\ne\n6\n6log f\n\n\n\n\n\n\n\n\n\n\n\n\n\n \n= 27",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q82_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Mathematics Q82]\\nIf\n1.3 2.5 3.7 ......up to n terms\n1 2 3 ......up to n terms 3 3 3\n  \n  \n= \n3\n9\n, then the value of n is",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 05\\nSolution:\\nGiven\n1.3 2.5 3.7 ......up to n terms\n1 2 3 ......up to n terms 3 3 3\n  \n  \n= \n3\n9\n....(1)\nNow\nLet S = 1.3 + 2.5 + 3.7 + …\nTn = n. (2n + 1)\n S = \n2\nn(n 1)\n6\n2n(n 1)(2n 1) \n\n \n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n \n2\n1\n3\n2n 1\nn(n 1)\n2\nn(n 1)\n2\n= \n5\n9\n 5n\n2\n– 19n – 30 = 0\n (5n + 6)(n – 5) = 0\n n  5",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q83_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Mathematics Q83]\\nThe equations of the sides AB, BC and CA of a triangle ABC are : 2x + y = 0, x + py = 21a, (a  0) and x – y = \n3 respectively. Let P(2, a) be the centroid of ABC. Then (BC)\n2\n is equal to",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 122\\nSolution:\\n\np 1\n3p 21a\n1\n1 2p\n21a\n\n\n \n\n= 6\n 4p\n2\n– 21ap + 8p + 42a – 5 = 0 …(1)\nAnd\np 1\n21a 3\n2\n1 2p\n42a\n\n\n \n\n\n= 3a\n 4p\n2\n– 81ap + 6ap\n2\n– 24a + 8p – 5 = 0 …(2)\nFrom equation (1) –equation (2) we get;\n60ap + 66a – 6ap\n2\n = 0\n a  0  p\n2\n– 10p – 11 = 0\np = –1 or 11  p = 11.\nWhen p = 11 then a = 3\nCoordinate of B = (–3, 6)\nAnd coordinate of C = (8, 5)\n BC2\n = 122",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q84_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Mathematics Q84]\\nThe minimum number of elements that must be added to the relation R = {(a, b), (b, c), (b, d)} on the set {a, \nb, c, d} so that it is an equivalence relation, is _____.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 13\\nSolution:\\nR = {(a, b)(b, c)(b, d)}\nS : {a, b, c, d}\nAdding (a, a), (b, b), (c, c), (d, d) make reflexive.\nAdding (b, a), (c, b), (d, b) make Symmetric\nAnd adding (a, d), (a, c) to make transitive\nFurther (d, a) & (c, a) to be added to make\nSymmetricity.\nFurther (c, d) & (d, c) also be added.\nSo total 13 elements to be added to make equivalence.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q85_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Mathematics Q85]\\nLet S = {[0, 2) : tan(cos) + tan( sin) = 0}. Then \n\n\n\n\n\n\n \n \nS\n2\n4\nsin is equal to _________.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 02\\nSolution:\\nS =   [0, ) : tan(cos) + tan( sin) = 0\ntan(cos) + tan(sin ) = 0\ntan(cos) = tan(− sin)\ncos = n −  sin n  I\nsin  + cos = n\n sin + cos = {−1, 0, 1}\n\n2\n3\n, ,\n4\n7\n,\n4\n3\n,\n2\n\n\n  \nNow \n\n\n\n\n\n\n \n \nS\n2\n4\nsin\n= \n\n\n\n\n \n\n\n \n\n\n\n\n \n   \n\n\n\n\n \n\n\n \n\n\n\n\n \n\n\n \n\n\n\n\n \n\n\n \n\n\n\n\n \n4 4\n3\nsin\n4\nsin\n4 4\n7\nsin\n4 4\n3\nsin\n2 4\nsin\n4\nsin2 2 2 2 2 2\n= \n2\n1\n2\n1\n0 0\n2\n1\n2\n1\n     = 2",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q86_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Mathematics Q86]\\nIf the area of the region bounded by the curves y\n2\n– 2y = –x, x + y = 0 is A, then 8 A is equal to ________.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 36\\nSolution:\\nArea enclosed by\ny\n2\n– 2y = –x\nx + y = 0\nArea = \n  \n3\n2\n2\n(2y y ) ( y)dy = \n\n3\n2\n2\n(3y y )dy\n= \n3\n0\n2 3\n3\ny\n2\n3y\n\n\n\n = \n2\n27\n– 9 = \n2\n27 18\n= \n2\n9\n= A",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q87_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Mathematics Q87]\\nIf the shortest between the lines\n4\nz 6\n3\ny 6\n2\nx 6 \n\n\n\n\n and \n5\nz 2 6\n4\ny 2 6\n3\nx \n\n\n\n \nis 6, then the \nsquare of sum of all possible values of  is",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 384\\nSolution:\\nShortest distance between\n4\nz 6\n3\ny 6\n2\nx 6 \n\n\n\n\n and \n5\nz 2 6\n4\ny 2 6\n3\nx \n\n\n\n \nis 6\nk\nˆ\nj 4\nˆ\ni 3\nˆ b 2 1   \n\nk\nˆ\nj 5\nˆ\ni 4\nˆ b 3 2   \n\nk\nˆ\nj 3 6\nˆ\ni 6\nˆ a a ( 6)\n2  1     \n \nd = \n| b b |\n(a a ).b b\n1 2\n2 1 1 2\n\n \n \n = 6\n6\n   6  2 6  3 6\n = 6\n|–  + 4 6 | = 6 6\n–  + 4 6 | = 6 6\n2 6 10 6\n4 6 6 6 4 6 6 6\n1   2 \n        \n \n2\n1  2\n =  \n2\n8 6 = 384",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q88_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Mathematics Q88]\\nLet the sum of the coefficients of the first three terms in the expansion of\nn\n2\nx\n3\nx \n\n\n\n\n\n , x  0. n  N, be 376. \nThen the coefficient of x\n4\n is ________.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 405\\nSolution:\\nS = 1 – 3n + \n2\n9n(n 1)\n= 376\n3n2\n– 5n – 250 = 0 \nn = 10, \n3\n25 (Rejected)\nTr1\n = \nnCr\n.x\nn–r\nr\n2\nx\n3\n\n\n\n\n\n \n= \nnCr\n x\nn–3r\n(–3)\nr\n= \n10Cr\n x\n10–3r\n(–3)\nr\nHere r = 2\nRequired coefficient = 10C2 (–3)2\n= 45 × 9\n= 405",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q89_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Mathematics Q89]\\nThree urns A, B and C contain 4 red, 6 black; 5 red, 5 black, and  red, 4 black balls respectively. One of the \nurns is selected at random and a ball is drawn. If the ball drawn is red and the probability that it is drawn \nfrom urn C is 0.4 then the square of the length of the side of the largest equilateral triangle, inscribed in the \nparabola y\n2\n = x with one vertex at the vertex of the parabola, is",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 432\\nSolution:\\nE1 : Ball is drawn from urn A (4R + 6B)\nE2 : Ball is drawn from urn B (5R + 5B)\nE3 : Ball is drawn from urn C (R + 4B)\nA → Ball drawn is red.\nRequired probability = P \n\n\n\n\n\nA\nE3\n= \n3 4\n1\n10\n5\n3\n1\n1\n4\n3\n1\n3 4\n1\n \n\n    \n \n\n\n= \n5\n2\n\n19 36\n10\n \n\n= \n5\n2\n = 6\nParabola: y\n2\n = 6x = 4ax\nLet length of side = l\nPoint \n\n\n\n\n\n\n\n2\n,\n2\n3 \n lies on parabola\n4\n2\n\n= 4a \n\n\n\n\n\n\n\n\n2\n3\n  = 8a 3\n  = 12 3\n \n2\n = 432",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q90_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 1 Shift 2 - Mathematics Q90]\\nLet k\nˆ\nj\nˆ\ni 2\nˆ a    \n\n, k\nˆ\nj\nˆ\ni 5\nˆ b  3   \n\n, a.c  7\n \n, 2b.c  43  0,\n\n\na c b c\n\n  \n   . Then a.b\n \nis equal to",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 08\\nSolution:\\nk\nˆ\nj\nˆ\ni 2\nˆ a    \n\nk\nˆ\nj\nˆ\ni 5\nˆ b  3   \n\na c b c\n\n  \n  \n (a b)\n \n × c\n\n = 0 \n c\n\n|| a b\n \n\n c\n\n=  (a b)\n \n\n c\n\n= ( k\nˆ\nj 2\nˆ\ni 7\nˆ  2    )\n a.c\n \n= (12 2 )\n2    = 7 …(i)\n b.c\n\n\n= ( 41 2 )\n2     = \n2\n43 …(ii)\n(i) and (ii)\n 2\n2\n41 2\n12 2\n \n \n= \n43\n14\n \n2\n = 1\n | a.b |\n \n = |3 – 10 – \n2\n| = 8",
                difficulty = "Medium"
            )
        )
    }
}