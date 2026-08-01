package com.example.data.repository
import com.example.model.Question
object JeeMain2022Session1Shift2QuestionsRepository {
    fun getQuestions(testId: String): List<Question> {
        return listOf(
            Question(
                id = "${testId}_s1_sh2_q1_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Physics Q1]\\nIdentify the pair of physical quantities that have same dimensions :",
                options = listOf("velocity gradient and decay constant", "wien’s constant and Stefan constant", "angular frequency and angular momentum", "wave number and Avogadro number"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nVelocity gradient = dx\ndv\n⇒ Dimensions are [T ] [L]\n[LT ] 1\n1 − −\n=\n Decay constant λ has dimensions of [T–1] \nbecause of the relation N\ndt\ndN = −λ \n⇒ Velocity gradient and decay constant have \nsame dimensions.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q2_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Physics Q2]\\nThe distance between Sun and Earth is R. The duration of year if the distance between Sun and Earth \nbecomes 3R will be :",
                options = listOf("3 years", "3 years", "9 years", "3 3 years"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nWe Know that \n T2 ∝ R3 \n⇒ \n2 3\nR\n3R\nT\nT' ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ ⎟ = ⎠\n⎞ ⎜\n⎝\n⎛\n ⇒ 3 3\nT\nT'\n=\n⇒ T'= 3 3 years",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q3_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Physics Q3]\\nA stone of mass m tied to a string is being whirled in a vertical circle with a uniform speed. The tension in \nthe string is",
                options = listOf("the same throughout the motion.", "minimum at the highest position of the circular path.", "minimum at the lowest position of the circular path.", "minimum when the rope is in the horizontal position."),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nAt any θ ; T – mg cos θ = \nR\nmv2\n⇒ T = mg cos θ + \nR\nmv2\n \nSince v is constant, \n⇒ T will be minimum when cosθ is minimum. \n⇒ θ = 180° corresponds to Tminimum.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q4_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Physics Q4]\\nTwo identical charged particles each having a mass 10 g and charge 2.0 × 10–7 C are placed on a horizontal \ntable with a separation of L between them such that they stay in limited equilibrium. If the coefficient of \nfriction between each particle and the table is 0.25, find the value of L. [Use g = 10 ms–2]",
                options = listOf("12 cm", "10 cm", "8 cm", "5 cm"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nAccording to given information : \nmg L\nkQ\n2\n2\n= μ\n Putting the values, we get \n L = 12 cm",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q5_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Physics Q5]\\nA Carnot engine takes 5000 kcal of heat from a reservoir at 727°C and gives heat to a sink at 127°C. The \nwork done by the engine is",
                options = listOf("3 × 106\n J", "Zero", "12.6 × 106\n J", "8.4 × 106\n J"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nEfficiency \nH\nL\nT\nT\nη = 1 −\n = \n1000\n400 1 −\n= 0.6 \n⇒ \nQ\nW 0.6 =\n⇒ W = 0.6Q = 3000 kcal = 12.6 × 106\n J",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q6_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Physics Q6]\\nTwo massless springs with spring constant 2 k and 9 k, carry 50 g and 100 g masses at their free ends. These \ntwo masses oscillate vertically such that their maximum velocities are equal. Then, the ratio of their \nrespective amplitude will be",
                options = listOf("1 : 2", "3 : 2", "3 : 1", "2 : 3"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nω1A1 = ω2A2 \n⇒ \n1\n2\n2\n1\nA\nA\nω\nω =\n = 2\n3\n2k\n50\n100\n9k\nk\nm\nm\nk\n1\n1\n2\n2 × = × =",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q7_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Physics Q7]\\nWhat will be the most suitable combination of three resistors A = 2 Ω, B = 4 Ω, C = 6 Ω so that ⎟\n⎠\n⎞ ⎜\n⎝\n⎛\n3\n22 Ω is \nequivalent resistance of combination?",
                options = listOf("Parallel combination of A and C connected in series with B.", "Parallel combination of A and B connected in series with C", "Series combination of A and C connected in parallel with B.", "Series combination of B and C connected in parallel with A."),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n3\n22 6\n2 6\n2 4 Req + = +\n× =\n⇒ A and B are in parallel and C is in series.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q8_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Physics Q8]\\nThe soft-iron is a suitable material for making an electromagnet. This is because soft-iron has",
                options = listOf("Low coercivity and high retentivity", "Low coercivity and low permeability", "High permeability and low retentivity", "High permeability and high retentivity"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nTheoretical.\n Electromagnet requires high permeability and low retentivity.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q9_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Physics Q9]\\nA proton, a deuteron and an α-particle with same kinetic energy enter into a uniform magnetic field at right \nangle to magnetic field. The ratio of the radii of their respective circular paths is :",
                options = listOf("1 : 2 : 2", "1 :1 : 2", "2 :1 :1", "1 : 2 :1"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n∴ \nqB\n2m(KE)\nqB\nmv\nr = =\n⇒ \n3\n3\n2\n2\n1\n1\n1 2 3\nq\nm\n:\nq\nm\n:\nq\nm\nr : r : r = \n = 2\n4\n:\n1\n2\n:\n1\n1 \n = 1 : 2 :1",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q10_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Physics Q10]\\nGiven below are two statements: \n Statement-I : The reactance of an ac circuit is zero. It is possible that the circuit contains a capacitor and an \ninductor. \n Statement-II : In ac circuit, the average power delivered by the source never becomes zero. \n In the light of the above statements, choose the correct answer from the options given below.",
                options = listOf("Both Statement I and Statement II are true", "Both Statement I and Statement II are false", "Statement I is true but Statement II is false", "Statement I is false but Statement II is true"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nX = |XC – XL| \n So, it can be zero if XC = XL And, average power in ac circuit can be zero.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q11_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Physics Q11]\\nPotential energy as a function of r is given by 10 5 r\nB\nr\nA U = − , where r is the interatomic distance, A and B are \npositive constants. The equilibrium distance between the two atoms will be:",
                options = listOf("5\n1\nB\nA ⎟\n⎠\n⎞ ⎜\n⎝\n⎛", "5\n1\nA\nB ⎟\n⎠\n⎞ ⎜\n⎝\n⎛", "5\n1\nB\n2A ⎟\n⎠\n⎞ ⎜\n⎝\n⎛", "5\n1\n2A\nB ⎟\n⎠\n⎞ ⎜\n⎝\n⎛"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nFor equilibrium \n11 6 r\n5B\nr\n10A 0\ndr\ndU − = = −\n = \nB\n2A\nr5 =\n And \n1/ 5\nB\n2A\nr ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ =",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q12_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Physics Q12]\\nAn object of mass 5 kg is thrown vertically upwards from the ground. The air resistance produces a constant \nretarding force of 10 N throughout the motion. The ratio of time of ascent to the time of descent will be equal \nto [Use g = 10 ms–2].",
                options = listOf("1 : 1", "2 : 3", "3 : 2", "2 : 3"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nLet time taken to ascent is t1 and that to descent is t2. Height will be same so \n2\n2\n2\n1 8t\n2\n1 12t\n2\n1 H = × = ×\n⇒ \n3\n2\nt\nt\n2\n1 =",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q13_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Physics Q13]\\nA fly wheel is accelerated uniformly from rest and rotates through 5 rad in the first second. The angle rotated \nby the fly wheel in the next second, will be:",
                options = listOf("7.5 rad", "15 rad", "20 rad", "30 rad"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n(2 1 1) 5rad\n2\n1 θ1 = α × − =\n⇒ α = 10 rad/sec2\nSo θ2 = \n2\n1\n× α (2 × 2 – 1) = 15 rad",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q14_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Physics Q14]\\nA 100 g of iron nail is hit by a 1.5 kg hammer striking at a velocity of 60 ms–1. What will be the rise in the \ntemperature of the nail if one fourth of energy of the hammer goes into heating the nail? [Specific heat \ncapacity of iron = 0.42 Jg–1 °C–1]",
                options = listOf("675°C", "1600°C", "16.07°C", "6.75°C"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n100 0.42 T\n4\n1 1.5 60\n2\n1 2 × × × = × × Δ\n16.07 C\n8 100 0.42\n1.5 60 T\n2\n= ° × ×\n× Δ =",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q15_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Physics Q15]\\nIf the charge on a capacitor is increased by 2 C, the energy stored in it increases by 44%. The original charge \non the capacitor is (in C)",
                options = listOf("10", "20", "30", "40"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nLet initially the charge is q so \ni\n2\nU\nC\nq\n2\n1 =\n And f\n2\nU\nC\n(q 2)\n2\n1 +\n Given 100 44\nU\nU U\ni\nf i × = −\n44\nq\n(q 2) q 2 2\n= + −\n⇒ q = 10C",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q16_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Physics Q16]\\nA long cylindrical volume contains a uniformly distributed charge of density ρ. The radius of cylindrical \nvolume is R. A charge particle (q) revolves around the cylinder in a circular path. The kinetic energy of the \nparticle is:",
                options = listOf("0\n2\n4\nqR\nε\nρ", "0\n2\n2\nqR\nε\nρ", "2 4 0R\nq\nε\nρ", "ρ\nε\nq\n4 R2\n0"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nr\n2k R q\nr\nmv2 2 ρ× π =\n⇒ \n0\n2\n2\n4\nR q mv\n2\n1\nε\nρ =",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q17_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Physics Q17]\\nAn electric bulb is rated as 200 W. What will be the peak magnetic field at 4 m distance produced by the \nradiations coming from this bulb? Consider this bulb as a point source with 3.5% efficiency.",
                options = listOf("1.19 × 10–8T", "1.71 × 10–8T", "0.84 × 10–8T", "3.36 × 10–8T"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nC\n2\nB\n100\n3.5\n4 16\n1 200\n0\n2\n0\nμ × = π× ×\n4 10 Tm/ A 7\n0 − μ = π×\n C = 3 × 108\n m/sec \n⇒ Β0 = 1.71 × 10–8 T",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q18_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Physics Q18]\\nThe light of two different frequencies whose photons have energies 3.8 eV and 1.4 eV respectively, \nilluminate a metallic surface whose work function is 0.6 eV successively. The ratio of maximum speeds of \nemitted electrons for the two frequencies respectively will be",
                options = listOf("1 : 1", "2 : 1", "4 : 1", "1 : 4"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n2 mv1 2\n1 3.8 = 0.6 +\n2 mv2 2\n1 1.4 = 0.6 +\n⇒ \n1\n4\n0.8\n3.2\nv\nv\n2\n1\n2\n1 = =\n⇒ \n1\n2\nv\nv\n2\n1 =",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q19_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Physics Q19]\\nTwo light beams of intensities in the ratio of 9 : 4 are allowed to interfere. The ratio of the intensity of \nmaxima and minima will be:",
                options = listOf("2 : 3", "16 : 81", "25 : 169", "25 : 1"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n2 2\n1 2\n1 2\nmin\nmax\n1\n5\nI I\nI I\nI\nI ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ = ⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\n−\n+ =\n = \n1\n25",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q20_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Physics Q20]\\nIn Bohr’s atomic model of hydrogen, let K, P and E are the kinetic energy, potential energy and total energy \nof the electron respectively. Choose the correct option when the electron undergoes transitions to a higher \nlevel:",
                options = listOf("All K, P and E increase", "K decreases, P and E increase", "P decreases, K and E increase", "K increases, P and E decrease"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n2\n0\n2 4\n8(nh )\nZ me T.E. ε\n− =\n2\n0\n2 4\n4(nh )\nZ me P.E. ε\n− =\n2\n0\n2 4\n8(nh )\nZ me K.E. ε\n− =\n As electron makes transition to higher level, total energy and potential energy increases (due to negative \nsign) while the kinetic energy reduces. \nSection-B: This section contains 10 questions. In Section-B, attempt any five questions out of 10. The answer \nto each of the questions is a numerical value. For each question, enter the correct numerical value (in decimal \nnotation, truncated/rounded-off to the second decimal place; e.g. 06.25, 07.00, –00.33, –00.30, 30.27, –27.30). \nEach question carries 4 marks for correct answer and –1 mark for wrong answer.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q21_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Physics Q21]\\nA body is projected from the ground at an angle of 45° with the horizontal. Its velocity after 2 s is \n20 ms–1. The maximum height reached by the body during its motion is ________ m. (use g = 10 ms–2)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 20.00\\nSolution:\\n⇒ vcos α = u cos 45° ..... (i) \n & v sin α = usin45° – gt ..... (ii) \n Solve for u we get \n u = 20 2 m/s \n⇒ 20m\n20\nu sin 45 H\n2 2\n= ° =",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q22_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Physics Q22]\\nAn antenna is placed in a dielectric medium of dielectric constant 6.25. If the maximum size of that antenna \nis 5.0 mm, it can radiate a signal of minimum frequency of __________GHz. (Given μr = 1 for dielectric \nmedium)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 6.00\\nSolution:\\nW know that v = fλ \nPutting the values, \n3\n8\nf 20 10\n6.25\n3 10 − = × × ×\n⇒ f = 6 × 109\n Hz",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q23_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Physics Q23]\\nA potentiometer wire of length 10 m and resistance 20 Ω is connected in series with a 25 V battery and an \nexternal resistance 30 Ω. A cell of emf E in secondary circuit is balanced by 250 cm long potentiometer wire. \nThe value of E (in volt) is 10\nx . The value of x is _____-",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 25.00\\nSolution:\\n∴ ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ × +\n⎟ =\n⎠\n⎞ ⎜\n⎝\n⎛ = × 4\n20\n(30 20)\n25\n4\n20 E \n = 5 2.5\n2\n1 × = volts \n = \n10\n25 volts",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q24_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Physics Q24]\\nTwo travelling waves of equal amplitudes and equal frequencies move in opposite directions along a string. \nThey interfere to produce a stationary wave whose equation is given by cm\nT\n2 t\ny 10cos xsin ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ π = π . The The \namplitude of the particle at 3\n4\nx = cm will be _____ cm .",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 5.00\\nSolution:\\nA = |10 cos (πx)| \nAt \n3\n4\nx =\n⎟\n⎠\n⎞ ⎜\n⎝\n⎛ = π× 3\n4 A 10cos\n = |– 5 cm| \n∴ Amp = 5 cm",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q25_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Physics Q25]\\nIn the given circuit, the value of current IL will be __________ mA. (When RL = 1 kΩ)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 5.00\\nSolution:\\nVL = 5 V as VZ = 5 V \n∴ 5mA\n10\n5\nR\nV I 3\nL\nL\nL = = =",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q26_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Physics Q26]\\nA sample contains 10–2 kg each of two substances A and B with half lives 4 s and 8 s respectively. The ratio of their \natomic weights is 1 : 2. The ratio of the amounts of A and B after 16 s is 100\nx . The value of x is _____.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 25.00\\nSolution:\\n4\n2\n1 2\n1\n10\nN\n⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\n=\n−\n2\n2\n2 2\n2\n10\nN\n⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\n=\n−\n⇒ \n2\n1\nN\nN\n2\n1 =\n∴ Mass ratio of A and B, \n⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛ = ×\n2\n1\n2\n1\n2\n1\nM\nM\nN\nN\nm\nm\n = ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ × 2\n1\n2\n1\n = \n4\n1 \n = \n100\n25\n∴ x = 25",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q27_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Physics Q27]\\nA ray of light is incident at an angle of incidence 60º on the glass slab of refractive index 3 . After \nrefraction, the light ray emerges out from other parallel faces and lateral shift between incident ray and \nemergent ray is 4 3 cm. The thickness of the glass slab is ______ cm.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 12.00\\nSolution:\\n1 × sin 60° = 3 × sin r\n⇒ r = 30° \n∴ I = 4 3 × 2 \n = 8 3 cm \n∴ Thickness, t = I1 cos 30° \n = \n2\n3 8 3 ×\n = 4 × 3 \n = 12 cm",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q28_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Physics Q28]\\nA circular coil of 1000 turns each with area 1 m2\n is rotated about its vertical diameter at the rate of one \nrevolution per second in a uniform horizontal magnetic field of 0.07 T. The maximum voltage generation \nwill be _______ V.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 440.00\\nSolution:\\nVmax = NABω \n = 1000 × 1 × 0.07 × (2π × 1) \n∼ 440volts",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q29_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Physics Q29]\\nA monoatomic gas performs a work of 4\nQ where Q is the heat supplied to it. The molar heat capacity of the \ngas will be ____ R during this transformation. Where R is the gas constant.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 2.00\\nSolution:\\nBy 1st law, \nQ 4\n3\n4\nQ U Q = Δ Δ Δ = Δ −\n⇒ nC T\n4\n3 nCvΔT = Δ\n⇒ 2R\n3\n4C C v = =",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q30_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Physics Q30]\\nIn an experiment to verify Newton’s law of cooling, a graph is plotted between, the temperature difference \n(ΔT) of the water and surroundings and time as shown in figure. The initial temperature of water is taken as \n80ºC. The value of t2 as mentioned in the graph will be ______.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 16.00\\nSolution:\\nTemperature of surrounding = 20° C \nFor 0 → 6 minutes, average temp. = 70°C \n→ Rate of colling ∝ 70° C – 20° C = 50°C \n For 6 → t2 minutes, average temp. = 50°C \n→ Rate of cooling ∝ 30°C \n⇒ \n3\n5 t2 − 6 = (6 minutes) \n⇒ t2 = 16 minutes",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q1_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Chemistry Q1]\\n120 g of an organic compound that contains only carbon and hydrogen gives 330 g of CO2 and 270 g of \nwater on complete combustion. The percentage of carbon and hydrogen, respectively are",
                options = listOf("25 and 75", "40 and 60", "60 and 40", "75 and 25"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nMass of organic compound = 120 g \nMass of CO2 = 330 g \nMoles of CO2 = \n330\n44\n = 7.5 \n Mass of carbon = 7.5 × 12 = 90 gm \n Percentage of C = 90 100\n120\n× = 75% \n Mass of H2O = 270 g \n Moles of H2O = 270\n18\n = 15 \n Mass of hydrogen = 15 × 2 = 30 gm \n Percentage of H = 30 100\n120\n× = 25 %",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q2_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Chemistry Q2]\\nThe energy of one mole of photons of radiation of wavelength 300 nm is (Given h = 6.63 × 10–34\nJs, NA = 6.02 × 1023 mol–1, c = 3 × 108 \nms\n–1)",
                options = listOf("235 kJ mol–1", "325 kJ mol–1", "399 kJ mol–1", "435 kJ mol–1"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nWavelength of radiation = 300 nm \n Photon energy = hc\nλ\n = \n34 8\n9\n6.63 10 3 10\n300 10\n−\n−\n× ××\n× \n = 6.63 × 10–19 J \n Energy of 1 mole of photons \n = 6.63 × 10–19 × 6.02 × 1023 × 10–3 \n = 399 kJ",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q3_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Chemistry Q3]\\nThe correct order of bond orders of 2 22 C ,N ,O 2 22\n− −− is respectively",
                options = listOf("2 22 CNO 2 22\n− −− <<", "2 22 ONC 2 22\n− −− <<", "222 CON 222\n− −− <<", "222 NCO 222\n−−− <<"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n2 C2\n− : **\nx\n2 22 22\nσσ σσ π 1s 1s 2s 2s 2p = yz\n22 πσ 2p 2p\n2 N2\n− : **\nz\n222 22\nσσ σσ σ 1s 1s 2s 2s 2p x\n2\nπ2p = y\n2 π2p *\nx\n1\n2p π = *\ny\n1\n2p π \n2 O2\n− : **\nzx\n2 2 22 22\nσσ σσ σ π 1s 1s 2s 2s 2p 2p = y\n2 π2p *\nx\n2\n2p π = *\ny\n2\n2p π\n B.O. ( 2 C2\n− ) = 3 ; B.O. ( 2 N2\n− ) = 2 ; B.O. ( 2 O2\n− ) = 1",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q4_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Chemistry Q4]\\nAt 25°C and 1 atm pressure, the enthalpies of combustion are as given below : \nSubstance H2 C(graphite) C2H6(g) \nc\n1\nDH\nkJmol\nΘ\n−\n–286.0 –394.0 –1560.0 \nThe enthalpy of formation of ethane is",
                options = listOf("+54.0 kJ mol–1", "–68.0 kJ mol–1", "–86.0 kJ mol–1", "+97.0 kJ mol–1"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n2C (graphite) + 3H2 (g) → C2H6 (g) \nΔHr = + 1560 + 2(–394) + 3 (–286) \n = – 86.0 KJ mol–1 \n Enthalpy of formation of C2H6(g) = –86.0 kJ mol–1",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q5_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Chemistry Q5]\\nFor a first order reaction, the time required for completion of 90% reaction is ‘x’ times the half life of the \nreaction. The value of ‘x’ is (Given: In 10 = 2.303 and log 2 = 0.3010)",
                options = listOf("1.12", "2.43", "3.32", "33.31"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nA → Products \nFor a first order reaction, \n t1/2 = \nln 2\nk = 0.693\nk \n Time for 90% conversion, \n t90% = \n1\nk\n In 100\n10\n = \nIn10\nk\n = \n2.303\nk\n t90% = \n2.303\n0.693\n t1/2 = 3.32t1/2",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q6_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Chemistry Q6]\\nMetals generally melt at very high temperature. Amongst the following, the metal with the highest \nmelting point will be",
                options = listOf("Hg", "Ag", "Ga", "Cs"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nMelting points of the given metals \n Hg : –38.83° C \n Ag : 961.8° C \n Ga : 29.76° C \n Cs : 28.44° C \n∴ Metal having highest melting point is Ag.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q7_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Chemistry Q7]\\nWhich of the following chemical reactions represents Hall-Heroult Process?",
                options = listOf("Cr2O3 + 2Al → Al2O3 + 2Cr", "2Al2O3 + 3C → 4Al + 3CO2", "FeO + CO → Fe + CO2", "[2Au(CN)2]\n–\n(aq) + Zn(S) → 2Au(s) + [Zn(CN4)]2–"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nHall-Herault process is used for the extraction of aluminium by electrolysis molten Al2O3 \n 2Al2O3 + 3C → 4Al + 3CO2",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q8_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Chemistry Q8]\\nIn the industrial production of which of the following, molecular hydrogen is obtained as a byproduct?",
                options = listOf("NaOH", "NaCl", "Na metal", "Na2CO3"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nMolecular hydrogen is produced as a byproduct in the industrial production of NaOH by electrolysis of \n aq NaCl solution \n NaCl → Na+\n + Cl–\n \n H2O H+\n + OH–\n \n Cathode : 2H2O + 2e → H2 + 2OH–\n \n Anode : 2Cl– → Cl2 + 2e \n NaOH is crystallised from the remaining part of electrolyte.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q9_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Chemistry Q9]\\nWhich one of the following compounds is used as a chemical in certain type of fire extinguishers?",
                options = listOf("Baking soda", "Soda ash", "Washing soda", "Caustic Soda"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nBaking soda (NaHCO3) is used in certain type of fire extinguishers because it decomposes at high \ntemperature to produce CO2 which extinguishes fire \n2NaHCO3 (S) ⎯Δ\n⎯→ Na2CO3(S) + H2O ↑+ CO2 ↑",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q10_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Chemistry Q10]\\nPCl5 is well known, but NCl5 is not. Because,",
                options = listOf("nitrogen is less reactive than phosphorous", "nitrogen doesn’t have d-orbitals in its valence shell.", "catenation tendency is weaker in nitrogen than phosphorous.", "size of phosphorous is larger than nitrogen"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nPCl5 is well known but NCl5 is not because nitrogen does not have vacant d-orbitals in its valence shell. \nSo, nitrogen cannot expand its octet. On the other hand phosphorus has vacant d-orbitals in its valence shell \nwhich enables it to expand its octet.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q11_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Chemistry Q11]\\nTransition metal complex with highest value of crystal field splitting (Δ0) will be",
                options = listOf("[Cr(H2O)6]\n3+", "[Mo(H2O)6]\n3+", "[Fe(H2O)6]\n3+", "[Os(H2O)6]\n3+"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nCrystal field splitting (Δ0) for octahedral complexes depends on oxidation state of the metal as well as to \nwhich transition series the metal belongs. For the same oxidation state, the crystal field splitting (Δ0) \nincreases as we move from 3d → 4d → 5d. Cr3+ and Fe3+ belong to 3d series, Mo3+ belongs to 4d series and \nOs3+ belongs to 5d series. Therefore crystal field splitting (Δ0) is highest for [Os(H2O)6]\n3+.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q12_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Chemistry Q12]\\nSome gases are responsible for heating of atmosphere (green house effect). Identify from the following the \ngaseous species which does not cause it.",
                options = listOf("CH4", "O3", "H2O", "N2"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nAmong the given gases, the green house gases which are responsible for heating the atmosphere \nare CH4, water vapour and ozone. Nitrogen is not a green house gas.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q13_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Chemistry Q13]\\nArrange the following carbocations in decreasing order of stability.",
                options = listOf("A > C > B", "A > B > C", "C > B > A", "C > A > B"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: Bonus\\nSolution:\\nThe given carbocation are \nCarbocation (1) is stabilised by hyperconjugation due to 4 α hydrogen atoms. Carbocation (3) is also \n stabilised by hyperconjugation due to 4 α hydrogen atoms but destabilised by –I effect of O-atom. \nCarbocation (2) is most stable as it is stabilised by resonance.\nNone of the given options is correct.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q14_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Chemistry Q14]\\nGiven below are two statements. Statement I: The presence of weaker π-bonds make alkenes less stable than \nalkanes. Statement II: The strength of the double bond is greater than that of carbon-carbon single bond. In \nthe light of the above statements, choose the correct answer from the options given below.",
                options = listOf("Both Statement I and Statement II are correct.", "Both Statement I and Statement II are incorrect.", "Statement I is correct but Statement II is incorrect.", "Statement I is incorrect but Statement II is correct."),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nThe π-bond present is alkenes is weaker than σbond present in alkenes. That makes alkenes less stable than \nalkanes. Therefore, statement-I is correct. \nCarbon-carbon double bond is stronger than Carbon-carbon single bond because more energy is required to \nbreak 1 sigma and 1 pi bond than to break 1 sigma bond only. Therefore, statement-II is also correct.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q15_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Chemistry Q15]\\nWhich of the following reagents/reactions will convert 'A' to 'B'?",
                options = listOf("PCC oxidation", "Ozonolysis", "BH3, H2O2/\n–\nOH followed by PCC oxidation", "HBr, hydrolysis followed by oxidation by K2Cr2O7."),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nThe first step involves addition of H2O to alkene according to anti-markownikoff’s rule while the second step \ninvolves oxidation of 1° alcohol to aldehyde.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q16_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Chemistry Q16]\\nHex-4-ene-2-ol on treatment with PCC gives ‘A’ on reaction with sodium hypoiodite gives ‘B’, which on \nfurther heating with soda lime gives ‘C’. The compound ‘C’ is",
                options = listOf("2-pentene", "Proponaldehyde", "2-butene", "4-methylpent-2-ene"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q17_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Chemistry Q17]\\nThe conversion of propan-1-ol to n-butylamine involves the sequential addition of reagents. The \ncorrect sequential order of reagents is",
                options = listOf("(i) SOCl2 (ii) KCN (iii) H2/Ni, Na(Hg)/C2H5OH", "(i) HCl (ii) H2/Ni, Na(Hg)/C2H5OH", "(i) SOCl2 (ii) KCN (iii) CH3NH2", "(i) HCl (ii) CH3NH2"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q18_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Chemistry Q18]\\nWhich of the following is not an example of a condensation polymer?",
                options = listOf("Nylon 6,6", "Dacron", "Buna-N", "Silicone"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nNylon 6, 6 is a condensation polymer of hexamethylene diamine and adipic acid Dacron is a condensation \npolymer of terephthalic acid and ethylene glycol. Buna-N is an addition polymer of 1, 3-butadiene and \nacrylonitrile Silicone is a condensation polymer of dialkyl silanediol.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q19_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Chemistry Q19]\\nThe structure shown below is of which well-known drug molecule?",
                options = listOf("Ranitidine", "Seldane", "Cimetidine", "Codeine"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nThe given structure is that of cimetidine which is well known antacid.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q20_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Chemistry Q20]\\nIn the flame test of a mixture of salts, a green flame with blue centre was observed. Which one of the \n following cations may be present?",
                options = listOf("Cu2+", "Sr2+", "Ba2+", "Ca2+"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nCupric salts give green flame with blue centre. The colour of other salts are \nSr2+ Crimson red \nCa2+ Brick red \nBa2+ Green\nSECTION - B \nNumerical Value Type Questions: This section contains 10 questions. In Section B, attempt any five \nquestions out of 10. The answer to each question is a NUMERICAL VALUE. For each question, enter the \ncorrect numerical value (in decimal notation, truncated/rounded-off to the second decimal place; e.g. \n06.25, 07.00, –00.33, –00.30, 30.27, –27.30) using the mouse and the on-screen virtual numeric keypad in \nthe place designated to enter the answer.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q21_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Chemistry Q21]\\nAt 300 K, a sample of 3.0 g of gas A occupies the same volume as 0.2 g of hydrogen at 200 K at the \nsame pressure. The molar mass of gas A is ______ g mol–1. (nearest integer) Assume that the behaviour of \ngases as ideal. (Given: The molar mass of hydrogen (H2) gas is 2.0 g mol–1).",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 45.00\\nSolution:\\nV1, Volume of 0.2 g H2 at 200 K = 0.2 R 200\n2P\n× ×\n× \n V2, Volume of 3.0 g of gas A at 300 K = 3.0 R 300\nMP\n× ×\n× \n V1 = V2 (Given) \n0.2 R 200\n2P\n××\n×\n = \n3.0 R 300\nMP\n××\n×\n∴ M = 45 g mol–1",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q22_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Chemistry Q22]\\nA company dissolves 'x' amount of CO2 at 298 K in 1 litre of water to prepare soda water. X = _____ × 10–3\ng. (nearest integer) \n(Given: partial pressure of CO2 at 298 K = 0.835bar. \n Henry's law constant for CO2 at 298 K = 1.67 kbar. Atomic mass of H, C and O is 1, 12, and 6 g mol–1, \nrespectively)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 1221.00\\nSolution:\\nAccording to Henry's law, partial pressure of a gas is given by \nPg = (KH) Xg \nwhere Xg is mole fraction of gas in solution \n0.835 = 1.67 × 103 () CO2 X \nCO2 X = 5 × 10–4 \nMass of CO2 in 1 L water = 1221 × 10–3 \ng",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q23_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Chemistry Q23]\\nPCl5 dissociates as \n PCl5(g)  PCl3(g) + Cl2(g) \n 5 moles of PCl5 are placed in a 200 litre vessel which contains 2 moles of N2 and is maintained at \n600 K. The equilibrium pressure is 2.46 atm. The equilibrium constant Kp for the dissociation of PCl5\nis ______ × 10–3.(nearest integer) \n(Given: R = 0.082 L atm K–1 mol–1 ; ; Assume ideal gas behaviour)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 1107.00\\nSolution:\\nPCl5 (g)  PCl3(g) + Cl2(g) \n nitial 5 \nmoles \nEquilibrium 5 – x x x \nmoles \nNumber of moles of N2 = 2 \nEquilibrium pressure = 2.46 atm \neq\n(7 x) 0.082 600 P\n200\n×× × = = 2.46 \nOn solving, x = 3 \n∴ KP = \n3P 3P\n10 10\n2P\n10\n⎛ ⎞⎛ ⎞ ⎜ ⎟⎜ ⎟ ⎝ ⎠⎝ ⎠\n⎛⎞ ⎜⎟ ⎝⎠\n = \n9 2.46\n20\n×\n = 1107 × 10–3 atm",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q24_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Chemistry Q24]\\nThe resistance of a conductivity cell containing 0.01 M KCl solution at 298 K is 1750 Ω. If the \nconductivity of 0.01 M KCl solution at 298 K is 0.152 × 10–3 S cm–1, then the cell constant of the \nconductivity cell is _______ × 10–3\ncm\n–1",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 266.00\\nSolution:\\nMolarity of KCl solution = 0.1 M \n Resistance = 1750 ohm \nConductivity = 0.152 × 10–3 S cm–1\nConductivity = Cell cons tan t\nResis tan ce\n∴ Cell constant = 0.152 × 10–3 × 1750 \n= 266 × 10–3\n cm\n–1",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q25_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Chemistry Q25]\\nWhen 200 mL of 0.2 M acetic acid is shaken with 0.6 g of wood charcoal, the final concentration of \nacetic acid after adsorption is 0.1 M. The mass of acetic acid adsorbed per gram of carbon is ________g.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 2.00\\nSolution:\\nMass of wood charcoal = 0.6 g \nInitial moles of acetic acid = 0.2 × 0.2 = 0.04 \n Final moles of acetic acid = 0.1 × 0.2 = 0.02 \n Moles of acetic acid adsorbed = 0.04 – 0.02 \n = 0.02 \n Mass of acetic acid adsorbed per gm of charcoal \n = \n0.02 60\n0.6\n× = 2.0g",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q26_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Chemistry Q26]\\n",
                options = listOf("Baryte,", "Galena,", "Zinc blende and", "Copper pyrites. How many of these minerals are \n sulphide based?"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 3.00\\nSolution:\\nBaryte BaSO4\nGalena PbS \nZinc blende ZnS \nCopper pyrites CuFeS2\nOf the given minerals, only 3 are sulphide based.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q27_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Chemistry Q27]\\nManganese (VI) has ability to disproportionate in acidic solution. The difference in oxidation states of \n two ions it forms in acidic solution is _____.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 3.00\\nSolution:\\nManganese (VI) disproportionates in acidic medium as \n2\n4 3MnO 4H −+ + → 4 22 2MnO MnO 2H O − ++ \n Difference in oxidation states of Mn in the products formed = 7 – 4 = 3",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q28_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Chemistry Q28]\\n0.2 g of an organic compound was subjected to estimation of nitrogen by Duma’s method in which \nvolume of N2 evolved (at STP) was found to be 22.400 mL. The percentage of nitrogen in the compound is \n_____. [nearest integer] (Given : Molar mass of N2 is 28 g mol–1, Molar volume of N2 at STP : 22.4L)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 14.00\\nSolution:\\nMass of organic compound = 0.2 g \nVolume of N2 gas evolved at STP = 22.4 mL \nMass of N2 gas evolved = \n3 22.4 10 28\n22.4\n− ××\n = 0.028g \nPercentage of nitrogen in the compound 0.028 100\n0.2\n× = 14%",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q29_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Chemistry Q29]\\nConsider the above reaction. The number of π electrons present in the product ‘P’ is_________.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 2.00\\nSolution:\\nThe given reaction undergoes nucleophilic substitution by SN2 mechanism at room \ntemperature \n∴ No. of π electrons present in P = 2",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q30_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Chemistry Q30]\\nIn alanylglycylleucylalanyvaline, the number of \npeptide linkages is __________.,",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 4.00\\nSolution:\\nThe given pentapeptide is \n ALA – GLY – LEU – ALA – VAL \n It has 4 peptide linkages.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q1_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Mathematics Q1]\\nLet x * y = x2\n + y3\n and (x * 1) * 1 = x * (1 * 1). Then a value of ⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\n+ +\n− + −\nx x 2\nx x 2 2sin 4 2\n4 2\n1 is",
                options = listOf("4\nπ", "3\nπ", "2\nπ", "6\nπ"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nGiven x * y = x2\n + y3\n and (x * 1) * 1 = x * (1 * 1) \n So, (x2\n + 1) * 1 = x * 2 \n⇒ (x2\n + 1)2\n + 1 = x2\n + 8 \n⇒ x\n4\n + 2x2\n + 2 = x2\n + 8 \n⇒ (x2\n)\n2\n + x2\n – 6 = 0 \n∴ (x2\n + 3)(x2\n – 2) = 0 \n∴ x 2 2 =\n Now, ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ =⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\n+ +\n− + − −\n8\n4 2sin\nx x 2\nx x 2 2sin 1\n4 2\n4 2\n1\n = \n6 3\n2 π = π\n⋅",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q2_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Mathematics Q2]\\nThe sum of all the real roots of the equation (e2x – 4)(6e2x – 5ex\n + 1) = 0 is",
                options = listOf("loge3", "–loge3", "loge6", "–loge6"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nGiven equation : (e2x – 4)(6e2x – 5ex\n + 1) = 0 \n⇒ e\n2x – 4 = 0 or 6e2x – 5ex\n + 1 = 0 \n⇒ e\n2x = 4 or 6(ex\n)\n2\n – 3ex\n – 2ex\n + 1 = 0 \n⇒ 2x = n4 or (3ex\n – 1)(2ex\n – 1) = 0 \n⇒ x = ln2 or \n3\n1\nex = or \n2\n1\nex =\n or ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ = 3\n1\nx n , –n2 \n Sum of all real roots = n2 – n3 – n2 \n = –n3",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q3_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Mathematics Q3]\\nLet the system of linear equations \n x + y + az = 2 \n 3x + y + z = 4 \n x + 2z = 1 \n have a unique solution (x*, y*, z*). If (α, x*), (y*, α) and (x*, –y*) are collinear points, then the sum of \nabsolute values of all possible values of α is",
                options = listOf("4", "3", "2", "1"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nGiven system of equations \n x + y + az = 2 …(i) \n 3x + y + z = 4 …(ii) \n x + 2z = 1 …(iii) \n Solving (i), (ii) and (iii), we get \n x = 1, y = 1, z = 0 (and for unique solution a ≠ –3) \n Now, (α, 1), (1, α) and (1, –1) are collinear \n∴ 0\n1 1 1\n1 1\n1 1\n=\n−\nα\nα\n⇒ α(α + 1) − 1(0) + 1 (−1 − α) = 0 \n ⇒ α2\n − 1 = 0 \n∴ α = ±1 \n∴ Sum of absolute values of α = 1 + 1 = 2",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q4_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Mathematics Q4]\\nLet x, y > 0. If x3\ny\n2\n = 215, then the least value of 3x + 2y is",
                options = listOf("30", "32", "36", "40"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nx, y > 0 and x3\ny\n2\n = 215\n Now, 3x + 2y = (x + x + x) + (y + y ) \n So, by A.M ≥ G.M inequality \n5 2 2 x y 5\n3x 2y ≥ ⋅ −\n∴ 5 15 3x + 2y ≥ 5 2 \n ≥ 40 \n∴ least value of 3x + 4y = 40",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q5_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Mathematics Q5]\\nLet \n⎪\n⎪\n⎩\n⎪\n⎪\n⎨\n⎧\n<\n∈ − − −\n−\n=\n1 , otherwise\nmax{2x, 3[|x|]} , |x| 1\n, x ( 2, 1)\nx [x]\nsin(x [x])\nf(x)\nWhere [t] denotes greatest integer ≤ t. If m is the number of points where f is not continuous and n is the \nnumber of points where f is not differentiable, then the ordered pair (m, n) is",
                options = listOf("(3, 3)", "(2, 4)", "(2, 3)", "(3, 4)"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n⎪\n⎪\n⎩\n⎪\n⎪\n⎨\n⎧\n<\n∈ − − −\n−\n=\n1 , otherwise\nmax{2x, 3[|x|]} , |x| 1\n, x ( 2, 1)\nx [x]\nsin(x [x])\nf(x)\n⎪\n⎪\n⎩\n⎪\n⎪\n⎨\n⎧\n∈\n∈ −\n∈ − − +\n+\n=\notherwise\nx (0, 1)\nx ( 1, 0)\nx ( 2, 1)\n,\n,\n,\n,\n1\n2x\n0\nx 2\nsin(x 2)\nf(x)\n It clearly shows that f(x) is discontinuous \n At x = –1, 1 also non differentiable \n and at x = 0, L.H.D. = 0\nh\nf(0 h) f(0) lim\nh 0\n= −\n− −\n→\n R.H.D = 2\nh\nf(0 h) f(0) lim\nh 0\n= + −\n→\n∴ f(x) is not differentiable at x = 0 \n∴ m = 2, n = 2",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q6_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Mathematics Q6]\\nThe value of the integral \n(1 e )(sin x cos x)\ndx\nx 6 6\n2\n2\n+ + ∫\nπ\n−π\n is equal to",
                options = listOf("2π", "0", "π", "2\nπ"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n(1 e )(sin x cos x)\ndx I x 6 6\n2\n2\n+ + = ∫\nπ\n−π\n .... (i) \n(1 e )(sin x cos x)\ndx I x 6 6\n2\n2\n+ + = −\nπ\n−π\n∫ .... (ii) \n From equation (i) & (ii) \nsin x cos x\ndx 2I 6 6\n2\n2\n+ = ∫\nπ\n−π\n⇒ \nsin 2x\n4\n3 1\ndx\nsin x cos x\ndx I\n2\n2\n0\n6 6\n2\n2\n−\n= + = ∫ ∫\nπ π\n−π\n⇒ dx\n4 tan 2x\n4 sec 2x 2\n4 tan 2x\n4 sec 2xdx I 2\n4 2\n0\n2\n2 2\n0 + = + = ∫ ∫\nπ π\n When x = 0, t = 0 \n Now, tan2x = t when, ,\n4\nx \nπ = t → ∞ \n2sec2\n2xdx = dt \n∴ \n∞\n−\n∞\n⎟\n⎠\n⎞ ⎜\n⎝\n⎛ = + = ∫ 0\n1\n0\n2 2\nt 2 tan\n4 t\n2dt I 2\n = = π\nπ\n2\n2",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q7_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Mathematics Q7]\\n⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\n+ +\n+\n+ +\n+\n+ +\n+ →∞ + + (n n )(n n)\nn ....... (n 9)(n 3)\nn\n(n 4)(n 2)\nn\n(n 1)(n 1)\nn lim 2 2\n2\n2\n2\n2\n2\n2\n2\nn\n is equal to",
                options = listOf("log 2\n4\n1\n8\n+ e\nπ", "log 2\n8\n1\n4\n+ e\nπ", "log 2\n8\n1\n4 − e\nπ", "log 2\n8\n1\n8\n+ e\nπ"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\n+ +\n+ +\n+ +\n+ ∞ + + (n n )(n n)\nn ...... (n 4)(n 2)\nn\n(n 1)(n 1)\nn lim 2 2\n2\n2\n2\n2\n2\nn\n = ∑= →∞ + +\nn\nr 1\n2 2\n2\nn (n r )(n r)\nn lim\n = \n⎥\n⎦\n⎤ ⎢\n⎣\n⎡ ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ +\n⎥\n⎥\n⎦\n⎤\n⎢\n⎢\n⎣\n⎡\n⎟\n⎠\n⎞ ⎜\n⎝\n⎛ +\n∑= →∞\nn\nr 1\nn\nr 1\n1\nn\n1 lim\n2\nn\nr 1 n\n = ∫ + +\n1\n0\n2 dx\n(1 x )(1 x)\n1\n = dx\n(1 x )\n(x 1)\n1 x\n1\n2\n1\n1\n0\n∫ 2 ⎥\n⎦\n⎤ ⎢\n⎣\n⎡\n+\n− − +\n = \n1\n0\n2 1 ln(1 x ) tan x\n2\n1 ln(1 x) 2\n1\n⎥\n⎦\n⎤ ⎢\n⎣\n⎡ + − + + −\n = ln2\n4\n1\n8\nln2\n2\n1\n2 4\n1\n+\nπ = ⎥\n⎦\n⎤ ⎢\n⎣\n⎡ +\nπ",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q8_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Mathematics Q8]\\nA particle is moving in the xy-plane along a curve C passing through the point (3, 3). The tangent to the \ncurve C at the point P meets the x-axis at Q. If the y-axis bisects the segment PQ, then C is a parabola with",
                options = listOf("Length of latus rectum 3", "Length of latus rectum 6", "Focus ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ , 0\n3\n4", "Focus ⎟\n⎠\n⎞ ⎜\n⎝\n⎛\n4\n3 0,"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nAccording to the question (Let P (x, y)) \n0\ndy\ndx 2x − y = ⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\n− = (y − x) dx\ndy P : y y\n∵ equation of tangent at\n∴ \nx\ndx\ny\ndy 2 =\n⇒ 2 ln y = ln x + ln c \n⇒ y\n2\n = cx ∵ this curve passes \n through (3, 3) ∴ c = 3 ∴ required parabola \n y\n2\n = 3x and L.R = 3",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q9_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Mathematics Q9]\\nLet the maximum area of the triangle that can be inscribed in the ellipse 1\n4\ny\na\nx 2\n2\n2\n+ = , a > 2, having one or \nits vertices at one end of the major axis of the ellipse and one of its sides parallel to the y-axis, be 6 3 . Then \nthe eccentricity of the ellipse is -",
                options = listOf("2\n3", "2\n1", "2\n1", "4\n3"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nGiven ellipse 1\n4\ny\na\nx 2\n2\n2\n+ = , a > 2 \n∴ Let A(θ) be the area of ΔABB' \n Then 4sin (a acos ) 2\n1 A(θ) = θ + θ\n A' (θ) = a (2cos θ + 2cos2 θ) \n For maxima A'(θ) = 0 \n⇒ cos θ = – 1, 2\n1\ncosθ =\n But for maximum area \n2\n1\ncosθ =\n∴ A(θ) = 6 3\n⇒ 6 3\n2\na\na\n2\n3 2 ⎟ =\n⎠\n⎞ ⎜\n⎝\n⎛ +\n ⇒ a = 4 \n∴ \n2\n3\n16\n4 1\na\nb\ne 1 2\n2\n= − = − =",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q10_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Mathematics Q10]\\nLet the area of the triangle with vertices A(1, α), B(α, 0) and C(0, α) be 4 sq. units. If the points (α, –α), (–\nα, α) and (α\n2\n, β) are collinear, then β is equal to",
                options = listOf("64", "–8", "–64", "512"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nA(1, α) B(α, 0) and C(0, α) are the vertices of ΔABC and area of ΔABC = 4 \n∴ 4\n0 1\n0 1\n1 1\n2\n1 =\nα\nα\nα\n ⇒ |1(1 ) ( ) | 8 2 − α − α α + α =\n⇒ α = ± 8 \n Now, (α, – α), (–α, α) and (α\n2\n, β) are collinear \n∴ \n64 1\n8 8 1\n8 8 1\n0\n64 1\n8 8 1\n8 8 1\nβ\n−\n−\n= =\nβ\n−\n−\n⇒ 8 (8 – β) + 8 (-8 - 64) + 1 (-8β - 8 × 64) = 0 \n⇒ 8 − β − 72 − β − 64 = 0 \n⇒ β = –64",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q11_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Mathematics Q11]\\nThe number of distinct real roots of the equation \n x\n7\n – 7x – 2 = 0 is",
                options = listOf("5", "7", "1", "3"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nGiven equation x7\n – 7x – 2 = 0 \n Let f(x) = x7\n – 7x – 2 \n f ′(x) = 7 x6\n – 7 = 7(x6\n – 1) \n and f ′(x) = 0 ⇒ x = +1 \n and f(–1) = –1 + 7 – 2 = 5 > 0 \n f(1) = 1 – 7 – 2 = –8 < 0 \n So, roughly sketch of f(x) will be \n So, number of real roots of f(x) = 0 and 3",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q12_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Mathematics Q12]\\nA random variable X has the following probability distribution :\nx 0 1 2 3 4 \nP(X) k 2k 4k 6k 8k \n The value of P(1< X < 4 | x ≤ 2) is equal to",
                options = listOf("7\n4", "3\n2", "7\n3", "5\n4"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nx is a random variable \n∴ k + 2k + 4k + 6k + 8k = 1 \n∴ \n21\n1 k =\n Now, P(1 < x < 4 | x ≤ 2) = 7\n4\n7k\n4k =",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q13_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Mathematics Q13]\\nThe number of solutions of the equation cos 2x\n4\n1\nx\n3\ncos\n3\ncos x 2 ⎟ =\n⎠\n⎞ ⎜\n⎝\n⎛ − π ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ π\n+ , x∈ [–3π, 3π] is",
                options = listOf("8", "5", "6", "7"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\ncos 2x\n4\n1\nx\n3\ncos\n3\ncos x 2 ⎟ =\n⎠\n⎞ ⎜\n⎝\n⎛ − π ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ π\n+ , x∈ [–3π, 3π] \n⇒ cos 2x\n2\n1\n3\n2x\ncos x cos 2 2 + =\n⇒ cos\n2\n 2x – 2 cos2x –1 = 0\n⇒ cos2x = 1 \n∴ x = –3π, –2π, – π, 0, π, 2π, 3π \n∴ Number of solutions = 7",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q14_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Mathematics Q14]\\nIf the shortest distance between the lines \nλ\n− = − = − z 3\n3\ny 2\n2\nx 1 and \n5\nz 5\n4\ny 4\n1\nx 2 − = − = − is \n3\n1 , then the \nsum of all possible values of λ is :",
                options = listOf("16", "6", "12", "15"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nLet k\nˆ j 3 ˆ i 2 ˆ a1 = + + →\n k\nˆ j 5 ˆ i 4 ˆ a2 = 2 + + →\nk\nˆ j\nˆ i 3 ˆ p = 2 + + λ →\n, k\nˆ j 5 ˆ i 4 ˆ q = + + →\n∴ k\nˆ j 5 ˆ i (10 ) ˆ p × q = (15 − 4λ) − − λ + → →\nk\nˆ j 2 ˆ i 2 ˆ a2 − a1 = + + → →\n∴ Shortest distance \n = \n3\n1\n(15 4 ) (10 ) 25\n(15 4 ) 2(10 ) 10\n2 2 =\n− λ + − λ +\n− λ − − λ +\n⇒ 3(5 – 2 λ)\n2\n = (15 – 4λ)\n2\n + (10 – λ)\n2\n + 25 \n ⇒ 5λ2 – 80λ + 275 = 0 \n∴ Sum of values of 16\n5\n80 λ = =",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q15_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Mathematics Q15]\\nLet the points on the plane P be equidistant from the points (–4, 2, 1) and (2, –2, 3). Then the acute angle \nbetween the plane P and the plane 2x + y + 3z = 1 is",
                options = listOf("6\nπ", "4\nπ", "3\nπ", "12\n5π"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nLet P(x, y, z) be any point on plane P1 \nThen (x + 4)2\n + (y – 2)2\n + (z – 1)2 \n = (x –2)2\n + (y + 2)2\n + (z – 3)2\n \n⇒ 12x – 8y + 4z + 4 = 0 \n⇒ 3x – 2y + z + 1 = 0 \n And P2 : 2x + y + 3z = 1 \n ∴ angle between P1 and P2 \n14 3\n6 2 3\ncos\nπ\n⇒ θ = − + θ",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q16_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Mathematics Q16]\\nLet aˆ and b\nˆ be two unit vectors such that b)| 2 ˆ b) 2(aˆ ˆ |(aˆ + + × = . If θ ∈(0, π) is the angle between \naˆ and b\nˆ , then among the statements : \n (S1) : b|ˆ b) |aˆ ˆ 2(aˆ × = −\n (S2) : The projection of aˆ on b)ˆ (aˆ + is \n2\n1",
                options = listOf("Only (S1) is true", "Only (S2) is true", "Both (S1) and (S2) are true", "Both (S1) and (S2) are false"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nb))| 2 ˆ b) 2(aˆ ˆ |(aˆ + + × = , θ ∈(0, π)\n⇒ b)| 4 ˆ b 2(aˆ ˆ |(aˆ 2 + + × =\n⇒ b 4 ˆ b| 2aˆ ˆ b| 4|aˆ ˆ |aˆ| | 2 2 2 + + × + ⋅ =\n∴ cosθ = cos2θ \n ∴ \n3\n2π θ =\n Where θ is angle between aˆ and b\nˆ\n∴ b|ˆ b| 3 |aˆ ˆ 2|aˆ × = = −\n (S1) is correct \n And projection of aˆ on b)ˆ (aˆ × = \n2\n1\nb|ˆ |aˆ\nb)ˆ aˆ (aˆ = +\n⋅ ×\n (S2) is correct.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q17_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Mathematics Q17]\\nIf y tan (sec x tanx ) 1 3 3 = − − , 2\n3\nx\n2\n3 π\n< <\nπ , then",
                options = listOf("xy ' + 2y ' = 0", "2\n3\nx y ' – 6 y 2 π\n+", "x y ' – 6 y 3 0 2 + π =", "xy ' – 4y ' = 0"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nLet x3\n = θ ⇒ ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ π π\n∈\nθ\n4\n3\n, 2 4\n∴ y = tan–1 (secθ – tanθ) \n = ⎟\n⎠\n⎞ ⎜\n⎝\n⎛\nθ\n− − θ\ncos\n1 sin tan 1\n ∴ \n4 2 y\nθ − π =\n 2\nx\n4 y\n3\n− π =\n∴ \n2\n3x\ny'\n2 − =\n y ' = –3x \n∴ 0\n2\n3\nx y' – 6y 2 = π\n+",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q18_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Mathematics Q18]\\nConsider the following statements: \n A : Rishi is a judge. \n B : Rishi is honest. \n C : Rishi is not arrogant. \n The negation of the statement “if Rishi is a judge \n and he is not arrogant, then he is honest” is",
                options = listOf("B → (A ∨ C)", "(~ B) ∧ (A ∧ C)", "B → ((~ A) ∨ (~ C))", "B → (A ∧ C)"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n∵ given statement is \n (A ∧ C) → B \n Then its negation is \n ~ {(A ∧ C) → B} \n or ~ {~ (A ∧ C) ∨ B} \n∴ (A ∧ C) ∧ (~ B) \n or (~ B) ∧ (A ∧ C)",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q19_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Mathematics Q19]\\nThe slope of normal at any point (x, y), x > 0, y > 0 on the curve y = y(x) is given by \n2\n22\nx\nxy x y 1 −− . Of \n the curve passes through the point (1, 1), then e· y(e) is equal to \n (1) 1 tan(1)\n1 tan(1)\n−\n+\n (2) tan (1) (3) 1 (4) 1 tan(1)\n1 tan(1)\n+\n−",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 4\\nSolution:\\n∵ – dx\ndy\n = \n2\n22\nx\nxy x y 1 −− \n∴\ndx\ndy\n = \n22\n2\nx y xy 1\nx\n−+\n Let xy = v ⇒ y + x dx\ndy = \ndv\ndx \n∴\ndv\ndx – y = \n2 (v v 1)y\nv\n−+\n ∴ \nx\nv 1\ndx\ndv 2 + =\n∵ y(1) = 1 ⇒ tan–1 (xy) = lnx + tan–1(1) \n Put x = e and y = y(e) we get \ntan–1 (e . y(e)) = 1 + tan–1 1 \ntan–1 (e . y(e)) – tan–1 1 = 1 \n∴ e(y(e)) = 1 tan(1)\n1 tan(1)\n+\n−",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q20_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Mathematics Q20]\\nLet λ∗\n be the largest value of λ for which the function fλ(x) = 4λx\n3\n – 36λx\n2 + 36x + 48 is increasing for all \nx ∈ R. Then fλ\n∗\n (1) + fλ\n∗\n (–1) is equal to \n (1) 36 (2) 48 (3) 64 (4) 72",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 4\\nSolution:\\n∵ fλ(x) = 4λx\n3\n – 36λx\n2\n + 36x + 48 \n∴ f 'λ(x) = 12 (λx\n2\n – 6λx + 3) \n For fλ(x) increasing : (6λ)\n2\n – 12λ ≤ 0 \n∴ λ ∈\n1 0, 3\n⎡⎤\n⎢⎥ ⎣⎦ \n∴ λ*\n = \n1\n3\n \n Now, f*\nλ (x) = 4\n3\n x\n3\n – 12x2\n + 36x + 48 \n∴ f *\nλ(1) + f *\nλ(–1) = 73 1\n2\n – 1 1\n2 \n = 72 \nSection-B: This section contains 10 questions. In Section-B, attempt any five questions out of 10. The answer \nto each of the questions is a numerical value. For each question, enter the correct numerical value (in decimal \nnotation, truncated/rounded-off to the second decimal place; e.g. 06.25, 07.00, –00.33, –00.30, 30.27, –27.30). \nEach question carries 4 marks for correct answer and –1 mark for wrong answer.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q21_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Mathematics Q21]\\nLet S = { Z ∈ C : |Z – 3| ≤1 and z(4 + 3i) + Z (4 – 3i) ≤ 24}. If α + iβ is the point in S which is \n closest to 4i, then 25(α + β) is equal to ______.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 80.00\\nSolution:\\nHere |z – 3| < 1 \n ⇒ (x – 3)2\n + y < 1 \nand z = (4 + 3i) + Z (4 – 3i) ≤ 24 \n⇒ 4x – 3y ≤ 12 \ntanθ = 4\n3\n \n∴ Coordinate of P = (3 – cosθ, sinθ) \n = \n34 3, 55\n⎛⎞ − ⎜⎟ ⎝⎠ \n∴ α + iβ = \n12\n5\n + \n4\n5\n i \n∴ 25(α + β) = 80",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q22_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Mathematics Q22]\\nLet S = \n1a\n0b\n⎛⎞ −\n⎜⎟ ⎝⎠\n1a\n;a, b {1,2,3,.....100} 0b\n⎧⎫ ⎪⎪ ⎛⎞ − ⎨⎬ ⎜⎟ ∈\n⎪⎪ ⎩⎭ ⎝⎠\n and let Tn = \n{A ∈ S : An(n+ 1) = l}. Then the number of elements \n100\nin\nn1\n∩\n= Tn is ––––",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 100.00\\nSolution:\\nS = \n1a\n;a, b {1,2,3,.....100} 0b\n⎧⎫ ⎪⎪ ⎛⎞ − ⎨⎬ ⎜⎟ ∈\n⎪⎪ ⎩⎭ ⎝⎠\n∵ A = \n1a\n0b\n⎛⎞ −\n⎜⎟ ⎝⎠\n then even power of \n A as \n10\n01\n⎛⎞ ⎜⎟ ⎝⎠\n , if b = 1 and a ∈ {1, ....., 100} \n Here, n(n + 1) is always even. \n∴ T1, T2, T3 ....., Tn are all I for b = 1 and each \n value of a. \n ∴ \n100\nn1\n∩\n= Tn = 100",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q23_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Mathematics Q23]\\nThe number of 7-digit numbers which are multiples of 11 and are formed using all the digits 1, 2, 3, 4, \n 5, 7 and 9 is _____.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 576.00\\nSolution:\\nSum of all given numbers = 31 \nDifference between odd and even positions must be 0, 11 or 22, but 0 and 22 are not possible. \n∴ Only difference 11 is possible \nThis is possible only when either 1, 2, 3, 4 is filled in odd position in some order and remaining in other \norder. Similar arrangements of 2, 3, 5 or 7, 2, 1 or 4, 5, 1 at even positions. \n∴ Total possible arrangements = (4! × 3!) × 4 = 576",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q24_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Mathematics Q24]\\nThe sum of all the elements of the set {α ∈ {1, 2, …, 100} : HCF(α, 24) = 1} is",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 1633.00\\nSolution:\\nThe numbers upto 24 which gives g.c.d. with 24 \nequals to 1 are 1, 5, 7, 11, 13, 17, 19 and 23. \n Sum of these numbers = 96 \nThere are four such blocks and a number 97 is there upto 100. \n ∴ Complete sum \n = 96 + (24 × 8 + 96) + (48 × 8 + 96) + (72 × 8 + 96) + 97 \n = 1633",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q25_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Mathematics Q25]\\nThe remainder on dividing 1 + 3 + 32\n + 33\n + … + 32021 by 50 ____ is",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 4.00\\nSolution:\\n1 + 3 + 32\n + ...... + 32021\n = \n2022 31\n2\n−\n = {} 1 1011 (10 1) 1 2 −−\n = \n1 {100k 10110 1 1}\n2\n+ −− \n= 50 k1 + 4 \n∴ Remainder = 4",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q26_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Mathematics Q26]\\nThe area (in sq. units) of the region enclosed between the parabola y2 = 2x and the line x + y = 4 is _______.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 18.00\\nSolution:\\nThe required area = \n2 2\n4\ny 4y − 2\n⎛⎞ ⎜⎟ −−\n⎝⎠ ∫ dy \n = \n2 23\n4\nyy 4y 26 −\n⎡⎤\n⎢⎥ −−\n⎣⎦\n = 18 square units",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q27_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Mathematics Q27]\\nLet a circle C : (x – h)2\n + (y – k)2\n = r\n2\n, k > 0, touch \nthe x-axis at (1, 0). If the line x + y = 0 intersects the circle C at P and Q such that the length of the chord PQ\nis 2, then the value of h + k + r is equal to ____.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 7.00\\nSolution:\\nHere, OM2\n = OP2\n – PM2\n \n2 1r\n2\n⎛⎞ + ⎜⎟ ⎝⎠\n = r\n2\n – 1 \n∴ r\n2\n – 2r – 3 = 0 \n∴ r = 3 \n∴ Equation of circle is \n (x – 1)2\n + (y – 3)2\n = 32\n \n∴ h = 1, k = 3, r = 3 \n∴ h + k + r = 7",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q28_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Mathematics Q28]\\nIn an examination, there are 10 true-false type questions. Out of 10, a student can guess the answer of 4 \nquestions correctly with probability 3\n4 and the remaining 6 questions correctly with probability 1\n4\n. If the \nrobability that the student guesses the answers of exactly 8 questions correctly out of 10 is 10\n27k\n4 , \n then k is equal to",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 479.00\\nSolution:\\nStudent guesses only two wrong. So there are three possibilities \n(i) Student guesses both wrong from 1st section \n(ii) Student guesses both wrong from 2nd section \n(iii) Student guesses two wrong one from each section\nRequired probabilities = \n226\n4\n2\n311 C\n444\n⎛ ⎞⎛ ⎞⎛ ⎞ ⎜ ⎟⎜ ⎟⎜ ⎟ ⎝ ⎠⎝ ⎠⎝ ⎠ + \n2 4 4\n2\n6\n4\n3\n4\n1\n4\n3 C ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ + 4\nC1. \n35\n6\n2\n313 1 C\n444 4\n⎛ ⎞⎛ ⎞⎛ ⎞ ⎛ ⎞ ⎜ ⎟⎜ ⎟⎜ ⎟ ⎜ ⎟ ⎝ ⎠⎝ ⎠⎝ ⎠ ⎝ ⎠\n = \n42\n10\n1 [6 9 15 9 24 9 ] 4\n×+ × + ×\n = 10\n27\n4 [2 + 27 × 15 + 72] \n = 10\n27 479\n4\n×",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q29_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Mathematics Q29]\\nLet the hyperbola H: \n2\n2\nx\na\n–y\n2\n = 1 and the ellipse \nE : 3x2\n + 4y2\n = 12 be such that the length of latus rectum of H is equal to the length of latus rectum of \n E. If eH and eE are the eccentricities of H and E respectively, then the value of 12 ( 22\nHE ee + ) is equal to",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 42.00\\nSolution:\\nH : \n22\n2\nxy\na 1 − = 1 \n∴ Length of latus rectum = 2\na\n \n E : \n22\nxy\n43\n+ = 1 \n Length of latus rectum = 6\n2\n= 3 \n∵\n2 3\na = ⇒ a = \n2\n3\n \n∴ 12 (e e ) 2\nE\n2\nH + =12 9 1\n4\n⎛⎞ + ⎜⎟ ⎝⎠\n3 1\n4\n⎛⎞ − ⎜⎟ ⎝⎠ = 42",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q30_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 2 - Mathematics Q30]\\nLet P1 be a parabola with vertex (3, 2) and focus(4, 4) and P2 be its mirror image with respect to the line x + \n2y = 6. Then the directrix of P2 is x + 2y = _______.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 10.00\\nSolution:\\nFocus = (4, 4) and vertex = (3, 2) \n ∴ Point of intersection of directrix with axis of \n parabola = A = (2, 0) \nImage of A(2, 0) with respect to line \nx + 2y = 6 is B(x2, y2) \n2 x2\n1\n− = 2 y0\n2\n− = 2(2 0 6)\n5\n− +− \n∴ B(x2, y2) = 18 16 , 55\n⎛⎞ ⎜⎟ ⎝⎠ \nPoint B is point of intersection of direction with axes \nof parabola P2 \n∴ x + 2y = λ must have point 18 16 , 55\n⎛⎞ ⎜⎟ ⎝⎠\n ∴ x + 2y = 10",
                difficulty = "Medium"
            )
        )
    }
}