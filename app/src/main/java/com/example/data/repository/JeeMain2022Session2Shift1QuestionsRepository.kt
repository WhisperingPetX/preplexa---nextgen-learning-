package com.example.data.repository
import com.example.model.Question
object JeeMain2022Session2Shift1QuestionsRepository {
    fun getQuestions(testId: String): List<Question> {
        return listOf(
            Question(
                id = "${testId}_s2_sh1_q1_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Physics Q1]\\nIf momentum [P], area [A] and time [T] are taken as fundamental quantities, then the dimensional formula for coefficient of viscosity is",
                options = listOf("[PA^-1T^0]", "[PAT^-1]", "[PA^-1T]", "[PA^-1T^-1]"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q2_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Physics Q2]\\nWhich of the following physical quantities have the same dimensions ?",
                options = listOf("Electric displacement (D) and surface charge density", "Displacement current and electric field", "Current density and surface charge density", "Electric potential and energy"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q3_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Physics Q3]\\nA person moved from A to B on a circular path as shown in figure. If the distance travelled by him is 60 m, then the magnitude of displacement would be (Given cos135° = –0.7)",
                options = listOf("42 m", "47 m", "19 m", "40 m)"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q4_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Physics Q4]\\nA body of mass 0.5 kg travels on straight line path with velocity v = (3x^2 + 4) m/s. The net workdone by the force during its displacement from x = 0 to x = 2 m is",
                options = listOf("64 J", "60 J", "120 J", "128 J"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q5_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Physics Q5]\\nA solid cylinder and a solid sphere, having same mass M and radius R, roll down the same inclined plane from top without slipping. They start from rest. The ratio of velocity of the solid cylinder to that of the solid sphere, with which they reach the ground, will be",
                options = listOf("sqrt(5/3)", "sqrt(4/5)", "sqrt(3/5)", "sqrt(14/15)"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q6_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Physics Q6]\\nThree identical particles A, B and C of mass 100 kg each are placed in a straight line with AB = BC = 13 m. The gravitational force on a fourth particle P of the same mass is F, when placed at a distance 13 m from the particle B on the perpendicular bisector of the line AC. The value of F will be approximately",
                options = listOf("21G", "100G", "59G", "42G"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q7_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Physics Q7]\\nA certain amount of gas of volume V at 27°C temperature and pressure 2 × 10^7 Nm–2 expands isothermally until its volume gets doubled. Later it expands adiabatically until its volume gets redoubled. The final pressure of the gas will be (Use, γ = 1.5)",
                options = listOf("3.536 × 10^5 Pa", "3.536 × 10^6 Pa", "1.25 × 10^6 Pa", "1.25 × 10^5 Pa"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q8_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Physics Q8]\\nFollowing statements are given:\n(A) The average kinetic energy of a gas molecule decreases when the temperature is reduced.\n(B) The average kinetic energy of a gas molecule increases with increase in pressure at constant temperature.\n(C) The average kinetic energy of a gas molecule decreases with increase in volume.\n(D) Pressure of a gas increases with increase in temperature at constant pressure.\n(E) The volume of gas decreases with increase in temperature.\nChoose the correct answer from the options given below:",
                options = listOf("(A) and (D) only", "(A), (B) and (D) only", "(B) and (D) only", "(A), (B) and (E) only"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q9_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Physics Q9]\\nIn figure (A), mass '2 m' is fixed on mass 'm' which is attached to two springs of spring constant k. In figure (B), mass 'm' is attached to two springs of spring constant 'k' and '2k'. If mass 'm' in (A) and in (B) are displaced by distance' x' horizontally and then released, then time period T1 and T2 corresponding to (A) and (B) respectively follow the relation.\n(1) T1/T2 = 3/sqrt(2) (2) T1/T2 = sqrt(3/2) (3) T1/T2 = sqrt(2/3) (4) T1/T2 = sqrt(2)/3",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q10_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Physics Q10]\\nA condenser of 2μF capacitance is charged steadily from 0 to 5 C. Which of the following graph represents correctly the variation of potential difference (V) across it's plates with respect to the charge (Q) on the condenser ?",
                options = listOf("Graph 1", "Graph 2", "Graph 3", "Graph 4"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q11_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Physics Q11]\\nTwo charged particles, having same kinetic energy, are allowed to pass through a uniform magnetic field perpendicular to the direction of motion. If the ratio of radii of their circular path is 6 : 5 and their respective masses ratio is 9 : 4. Then, the ratio of their charges will be :",
                options = listOf("8 : 5", "5 : 4", "5 : 3", "8 : 7"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q12_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Physics Q12]\\nTo increase the resonant frequency in series LCR circuit,",
                options = listOf("Source frequency should be increased.", "Another resistance should be added in series with the first resistance.", "Another capacitor should be added in series with the first capacitor.", "The source frequency should be decreased."),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q13_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Physics Q13]\\nA small square loop of wire of side l is placed inside a large square loop of wire L(L >> l). Both loops are coplanar and their centres coincide at point O as shown in figure. The mutual inductance of the system is :\n(1) 2sqrt(2)mu_0 L^2 / (pi l) (2) mu_0 l^2 / (2sqrt(2)pi L) (3) 2sqrt(2)mu_0 l^2 / (pi L) (4) mu_0 L^2 / (2sqrt(2)pi l)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 3\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q14_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Physics Q14]\\nThe rms value of conduction current in a parallel plate capacitor is 6.9 μA. The capacity of this capacitor, if it is connected to 230 V ac supply with an angular frequency of 600 rad/s, will be :",
                options = listOf("5 pF", "50 pF", "100 pF", "200 pF"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q15_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Physics Q15]\\nWhich of the following statement is correct ?",
                options = listOf("In primary rainbow, observer sees red colour on the top and violet on the bottom", "In primary rainbow, observer sees violet colour on the top and red on the bottom", "In primary rainbow, light wave suffers total internal reflection twice before coming out of water drops", "Primary rainbow is less bright than secondary rainbow"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q16_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Physics Q16]\\nTime taken by light to travel in two different materials A and B of refractive indices μA and μB of same thickness is t1 and t2 respectively. If t2 – t1 = 5 × 10–10 s and the ratio of μA to μB is 1 : 2. Then, the thickness of material, in meter is: (Given vA and vB are velocities of light in A and B materials respectively.)",
                options = listOf("5 × 10–10 vA m", "5 × 10–10 m", "1.5 × 10–10 m", "5 × 10–10 vB m"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q17_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Physics Q17]\\nA metal exposed to light of wavelength 800 nm and emits photoelectrons with a certain kinetic energy. The maximum kinetic energy of photo-electron doubles when light of wavelength 500 nm is used. The workfunction of the metal is : (Take hc = 1230 eV-nm)",
                options = listOf("1.537 eV", "2.46 eV", "0.615 eV", "1.23 eV"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q18_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Physics Q18]\\nThe momentum of an electron revolving in nth orbit is given by : (Symbols have their usual meanings)",
                options = listOf("nh / (2pi r)", "nh / 2r", "nh / 2pi", "2pi r / nh"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q19_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Physics Q19]\\nThe magnetic moment of an electron (e) revolving in an orbit around nucleus with an orbital angular momentum is given by :",
                options = listOf("mu_L = eL / 2m", "mu_L = -eL / 2m", "mu_L = -eL / m", "mu_L = 2eL / m"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q20_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Physics Q20]\\nIn the circuit, the logical value of A = 1 or B = 1 when potential at A or B is 5V and the logical value of A = 0 or B = 0 when potential at A or B is 0.V. The truth table of the given circuit will be :",
                options = listOf("A B Y: 0 0 0, 1 0 0, 0 1 0, 1 1 1", "A B Y: 0 0 0, 1 0 1, 0 1 1, 1 1 1", "A B Y: 0 0 0, 1 0 0, 0 1 0, 1 1 0", "A B Y: 0 0 1, 1 0 1, 0 1 1, 1 1 0"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q21_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Physics Q21]\\nA car is moving with speed of 150 km/h and after applying the break it will move 27 m before it stops. If the same car is moving with a speed of one third the reported speed then it will stop after travelling ___ m distance.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 3\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q22_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Physics Q22]\\nFor forces are acting at a point P in equilibrium as shown in figure. The ratio of force F1 to F2 is 1 : x where x =___.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 3\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q23_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Physics Q23]\\nA wire of length L and radius r is clamped rigidly at one end. When the other end of the wire is pulled by a force F, its length increases by 5 cm. Another wire of the same material of length 4L and radius 4r is pulled by a force 4F under same conditions. The increase in length of this wire is ___ cm.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 5\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q24_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Physics Q24]\\nA unit scale is to be prepared whose length does not change with temperature and remains 20 cm, using a bimetallic strip made of brass and iron each of different length. The length of both components would change in such a way that difference between their lengths remains constant. If length of brass is 40 cm and length of iron will be ___ cm. (αiron = 1.2 × 10–5 K–1 and αbrass = 1.8 × 10–5 K–1).",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 60\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q25_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Physics Q25]\\nAn observer is riding on a bicycle and moving towards a hill at 18 kmh–1. He hears a sound from a source at some distance behind him directly as well as after its reflection from the hill. If the original frequency of the sound as emitted by source is 640 Hz and velocity of the sound in air is 320 m/s, the beat frequency between the two sounds heard by observer will be ___ Hz.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 20\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q26_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Physics Q26]\\nThe volume charge density of a sphere of radius 6 m is 2 μC cm–3. The number of lines of force per unit surface area coming out from the surface of the sphere is _______ × 10^10 NC–1. [Given : Permittivity of vacuum e0 = 8.85 × 10–12 C^2 N–1 – m–2).",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 45\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q27_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Physics Q27]\\nIn the given figure, the value of V0 will be _________V.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 4\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q28_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Physics Q28]\\nEight copper wire of length l and diameter d are joined in parallel to form a single composite conductor of resistance R. If a single copper wire of length 2l have the same resistance (R) then its diameter will be ________ d.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 4\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q29_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Physics Q29]\\nThe energy band gap of semiconducting material to produce violet (wavelength = 4000 Å) LED is _________ eV. (Round off to the nearest integer).",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 3\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q30_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Physics Q30]\\nThe required height of a TV tower which can cover the population of 6.03 lakh is h. If the average population density is 100 per square km and the radius of earth is 6400 km, then the value of h will be ________ m.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 150\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q31_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Chemistry Q31]\\nSO2Cl2 on reaction with excess of water results into acidic mixture. SO2Cl2 + 2H2O -> H2SO4 + 2HCl. 16 moles of NaOH is required for the complete neutralisation of the resultant acidic mixture. The number of moles of SO2Cl2 used is",
                options = listOf("16", "8", "4", "2"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q32_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Chemistry Q32]\\nWhich of the following sets of quantum numbers is not allowed?",
                options = listOf("n = 3, l = 2, ml = 0, s = +1/2", "n = 3, l = 2, ml = -2, s = +1/2", "n = 3, l = 3, ml = -3, s = -1/2", "n = 3, l = 0, ml = 0, s = -1/2"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q33_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Chemistry Q33]\\nThe depression in freezing point observed for a formic acid solution of concentration 0.5 mL L–1 is 0.0405°C. Density of formic acid is 1.05 g mL–1. The Van’t Hoff factor of the formic acid solution is nearly (Given for water kf = 1.86 k kg mol–1)",
                options = listOf("0.8", "1.1", "1.9", "2.4"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q34_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Chemistry Q34]\\n20 mL of 0.1 M NH4OH is mixed with 40 mL of 0.05 M HCl. The pH of the mixture is nearest to (Given : Kb(NH4OH) = 1 × 10–5, log2 = 0.30, log3 = 0.48, log5 = 0.69, log7 = 0.84, log11 = 1.04)",
                options = listOf("3.2", "4.2", "5.2", "6.2"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q35_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Chemistry Q35]\\nMatch List-I with List-II.\nList-I List-II\n(A) N2(g) + 3H2(g) -> 2NH3(g) (I) Cu\n(B) CO(g) + 3H2(g) -> CH4(g) + H2O(g) (II) Cu/ZnO – Cr2O3\n(C) CO(g) + H2(g) -> HCHO(g) (III) FexOy + K2O + Al2O3\n(D) CO(g) + 2H2(g) -> CH3OH(g) (IV) Ni\nChoose the correct answer from the options given below :",
                options = listOf("(A) - (II), (B) - (IV), (C) - (I), (D) - (III)", "(A) - (II), (B) - (I), (C) - (IV), (D) - (III)", "(A) - (III), (B) - (IV), (C) - (I), (D) - (II)", "(A) - (III), (B) - (I), (C) - (IV), (D) - (II)"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q36_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Chemistry Q36]\\nThe IUPAC nomenclature of an element with electronic configuration [Rn] 5f14 6d1 7s2 is",
                options = listOf("Unnilbium", "Unnilunium", "Unnilquadium", "Unniltrium"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q37_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Chemistry Q37]\\nThe compound(s) that is(are) removed as slag during the extraction of copper is\n(A) CaO \n(B) FeO \n(C) Al2O3\n(D) ZnO \n(E) NiO\nChoose the correct answer from the options given below :",
                options = listOf("(C), (D) only", "(A), (B), (E) only", "(A), (B) only", "(B) only"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q38_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Chemistry Q38]\\nThe reaction of H2O2 with potassium permanganate in acidic medium leads to the formation of mainly",
                options = listOf("Mn2+", "Mn4+", "Mn3+", "Mn6+"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q39_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Chemistry Q39]\\nChoose the correct order of density of the alkali metals.",
                options = listOf("Li < K < Na < Rb < Cs", "Li < Na < K < Rb < Cs", "Cs < Rb < K < Na < Li", "Li < Na < K < Cs < Rb"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q40_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Chemistry Q40]\\nThe geometry around boron in the product ‘B’ formed from the following reaction is\nBF3 + NaH -> A + NaF ; A + NMe3 -> B",
                options = listOf("Trigonal planar", "Tetrahedral", "Pyramidal", "Square planar"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q41_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Chemistry Q41]\\nThe interhalogen compound formed from the reaction of bromine with excess of fluorine is a :",
                options = listOf("hypohalite", "halate", "perhalate", "halite"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q42_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Chemistry Q42]\\nThe photochemical smog does not generally contain :",
                options = listOf("NO", "NO2", "SO2", "HCHO"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q43_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Chemistry Q43]\\nA compound 'A' on reaction with 'X’ and 'Y' produces the same major product but different by product 'a' and 'b'. Oxidation of 'a' gives a substance produced by ants.\n'X' and 'Y' respectively are",
                options = listOf("KMnO4/H+ and dil. KMnO4, 273 K", "KMnO4(dilute), 273 K and KMnO4/H+", "KMnO4/H+ and O3, H2O/Zn", "O3, H2O/Zn and KMnO4/H+"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q44_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Chemistry Q44]\\nMost stable product of the following reaction is : (Reaction of alcohol with SOCl2, Pyridine followed by NaCN, DMF)",
                options = listOf("CN inverted", "CN retained", "CN other", "CN other"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q45_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Chemistry Q45]\\nWhich one of the following reactions does not represent correct combination of substrate and product under the given conditions?",
                options = listOf("Acid chloride + H2/Pd-BaSO4 -> Aldehyde", "Nitrile + DIBAL-H -> Aldehyde", "Ester + AlH(i-Bu)2 -> Aldehyde", "Primary alcohol + Na2Cr2O7/H2SO4 -> Aldehyde"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q46_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Chemistry Q46]\\nAn organic compound ‘A’ on reaction with NH3 followed by heating gives compound B. Which on further strong heating gives compound C(C8H5NO2). Compound C on sequential reaction with ethanolic KOH, alkyl chloride and hydrolysis with alkali gives a primary amine. The compound A is :",
                options = listOf("o-phthalaldehyde", "Phthalic acid", "Phthalic acid (represented as image)", "another"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q47_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Chemistry Q47]\\nMelamine polymer is formed by the condensation of :",
                options = listOf("Melamine + HCHO", "...", "...", "..."),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q48_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Chemistry Q48]\\nDuring the denaturation of proteins, which of these structures will remain intact?",
                options = listOf("Primary", "Secondary", "Tertiary", "Quaternary"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q49_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Chemistry Q49]\\nDrugs used to bind to receptors, inhibiting its natural function and blocking a message are called:",
                options = listOf("Agonists", "Antagonists", "Allosterists", "Anti histaminists"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q50_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Chemistry Q50]\\nGiven below are two statements:\nStatement I: On heating with KHSO4, glycerol is dehydrated and acrolein is formed.\nStatement II: Acrolein has fruity odour and can be used to test glycerol’s presence.\nChoose the correct option.",
                options = listOf("Both Statement I and Statement II are correct", "Both Statement I and Statement II are incorrect.", "Statement I is correct but Statement II is incorrect.", "Statement I is incorrect but Statement II is correct."),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q51_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Chemistry Q51]\\nAmong the following species N2, N2+, N2-, N2^2-, O2, O2+, O2-, O2^2- the number of species showing diamagnetism is __________ .",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q52_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Chemistry Q52]\\nThe enthalpy of combustion of propane, graphite and dihydrogen at 298 K are –2220.0 kJ mol–1, – 393.5 kJ mol–1 and –285.8 kJ mol–1 respectively. The magnitude of enthalpy of formation of propane (C3H8) is __________ kJ mol–1. (Nearest integer)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 104\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q53_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Chemistry Q53]\\nThe pressure of a moist gas at 27°C is 4 atm. The volume of the container is doubled at the same temperature. The new pressure of the moist gas is __________ × 10–1 atm. (Nearest integer) (Given: The vapour pressure of water at 27°C is 0.4 atm.)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 22\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q54_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Chemistry Q54]\\nThe cell potential for Zn|Zn2+(aq)||Snx+|Sn is 0.801 V at 298 K. The reaction quotient for the above reaction is 10–2. The number of electrons involved in the given electrochemical cell reaction is _________ . (Given : E°_Zn2+|Zn = – 0.763 V, E°_Snx+|Sn = +0.008 V and 2.303RT/F = 0.06 V)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 4\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q55_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Chemistry Q55]\\nThe half-life for the decomposition of gaseous compound A is 240 s when the gaseous pressure was 500 torr initially. When the pressure was 250 torr, the half-life was found to be 4.0 min. The order of the reaction is _________ . (Nearest integer)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q56_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Chemistry Q56]\\nConsider the following metal complexes: [Co(NH3)6]3+, [CoCl(NH3)5]2+, [Co(CN)6]3–, [Co(NH3)5(H2O)]3+. The spin-only magnetic moment value of the complex that absorbs light with shortest wavelength is __________ B.M. (Nearest integer)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 0\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q57_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Chemistry Q57]\\nAmong Co3+, Ti2+, V2+ and Cr2+ ions, one if used as a reagent cannot liberate H2 from dilute mineral acid solution, its spin-only magnetic moment in gaseous state is _________ B.M. (Nearest integer)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 5\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q58_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Chemistry Q58]\\nWhile estimating the nitrogen present in an organic compound by Kjeldahl’s method, the ammonia evolved from 0.25 g of the compound neutralized 2.5 mL of 2 M H2SO4. The percentage of nitrogen present in organic compound is _________ .",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 56\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q59_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Chemistry Q59]\\nThe number of sp3 hybridised carbons in an acyclic neutral compound with molecular formula C4H5N is _______ .",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q60_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Chemistry Q60]\\nIn the given reaction, ethyl 1-methylcyclopentane-1-carboxylate + OHCH2COCH3 -> OEt- -> A. The number of chiral carbon(s) in product A is ___________ .",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q61_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Mathematics Q61]\\nThe total number of functions, f : {1, 2, 3, 4} -> {1, 2, 3, 4, 5, 6} Such that f(1) + f(2) = f(3), is equal to : \n(1) 60 (2) 90 (3) 108 (4) 126",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q62_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Mathematics Q62]\\nIf α, β, γ, δ are the roots of the equation x^4 + x^3 + x^2 + x + 1 = 0, then α^2021 + β^2021 + γ^2021 + δ^2021 is equal to.",
                options = listOf("– 4", "– 1", "1", "4"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q63_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Mathematics Q63]\\nFor n in N, let Sn = {z in C : |z - 3 + 2i| = n/4} and Tn = {z in C : |z - 2 + 3i| = 1/n}. Then the number of elements in the set {n in N : Sn intersect Tn = phi} is :",
                options = listOf("0", "2", "3", "4"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q64_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Mathematics Q64]\\nThe number of θ in (0, 4pi) for which the system of linear equations 3(sin 3θ) x – y + z = 2, 3(cos 2 θ) x + 4y+ 3z = 3, 6x + 7y + 7z = 9 has no solution is :",
                options = listOf("6", "7", "8", "9"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q65_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Mathematics Q65]\\nIf lim_{n->inf} (sqrt(n^2 - n - 1) + nα + β) = 0 then 8(α + β) is equal to :",
                options = listOf("4", "– 8", "– 4", "8"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q66_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Mathematics Q66]\\nIf the absolute maximum value of the function f(x) = (x^2 – 2x + 7) e^(4x^2 - 12x^2 - 180x + 31) in the interval [– 3, 0] is f(α) , then :",
                options = listOf("α = 0", "α = – 3", "α in (– 1, 0)", "α in ( – 3, – 1)"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q67_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Mathematics Q67]\\nThe curve y(x) = ax^3 + bx^2 + cx + 5 touches the x-axis at the point P(–2, 0) and cuts the y-axis at the point Q, where y' is equal to 3. Then the local maximum value of y(x) is :",
                options = listOf("27/4", "29/4", "37/4", "9/2"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q68_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Mathematics Q68]\\nThe area of the region given by A = {(x, y) : x^2 <= y <= min{x + 2, 4 – 3x}} is :",
                options = listOf("31/8", "17/6", "19/6", "27/8"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q69_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Mathematics Q69]\\nFor any real number x, let [x] denote the largest integer less than equal to x. Let f be a real valued function defined on the interval [– 10, 10] by f (x) = x - [x] if(x) is odd, 1 + [x] - x if(x) is even. Then the value of pi^2/10 integral_-10^10 f(x) cos pi x dx is :",
                options = listOf("4", "2", "1", "0"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q70_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Mathematics Q70]\\nThe slope of the tangent to a curve C : y = y(x) at any point (x, y) on it is (2e^2x - 6e^-x + 9) / (2 + 9e^-2x). If C Passes through the points (0, 1/2 + pi/(2sqrt(2))) and (α, 1/2 e^2α) then e^α is equal to : \n(1) (3+sqrt(2))/(3-sqrt(2))\n(2) sqrt((3+sqrt(2))/(3-sqrt(2)))\n(3) 1/sqrt(2) ((sqrt(2)+1)/(sqrt(2)-1))\n(4) (sqrt(2)+1)/(sqrt(2)-1)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q71_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Mathematics Q71]\\nThe general solution of the differential equation (x – y^2) dx + y(5x + y^2) dy = 0 is :",
                options = listOf("(y^2 + x)^4 = C|(y^2 + 2x)^3|", "(y^2 + 2x)^4 = C|(y^2 + x)^3|", "|(y^2 + x)^3| = C(2y^2 + x)^4", "|(y^2 + 2x)^3| = C(2y^2 + x)^4"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q72_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Mathematics Q72]\\nA line, with the slope greater than one, passes through the point A(4,3) and intersects the line x – y – 2 = 0 at the point B. If the length of the line segment AB is sqrt(29)/3, then B also lies on the line :",
                options = listOf("2x + y = 9", "3x – 2y = 7", "x + 2y = 6", "2x – 3y = 3"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q73_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Mathematics Q73]\\nLet the locus of the centre (α, β), β > 0, of the circle which touches the circle x^2 + (y – 1)^2 = 1 externally and also touches the x-axis be L. Then the area bounded by L and the line y = 4 is : \n(1) 32sqrt(2)/3 (2) 40sqrt(2)/3 (3) 64/3 (4) 32/3",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 3\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q74_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Mathematics Q74]\\nLet P be the plane containing the straight line (x - 3)/9 = (y + 4)/-1 = (z - 7)/-5 and perpendicular of the plane containing the straight lines x/2 = y/3 = z/5 and x/3 = y/7 = z/8. If d is the distance of P from the point (2, – 5, 11) then d^2 is equal to :",
                options = listOf("147/2", "96", "32/3", "54"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q75_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Mathematics Q75]\\nLet ABC be a triangle such that BC = a, CA = b, AB = c, |a| = 6sqrt(2), |b| = 2sqrt(3) and b . c = 12. Consider the statements : (S1) : | ( a × b ) + ( c × b ) | – | c | = 6 (2sqrt(2) – 1) (S2) : angle ABC = cos^-1(sqrt(2)/3). Then \n(1) both (S1) and (S2) are true (2) only (S1) is true\n(3) only (S2) is true (4) both (S1) and (S2) are false",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 3\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q76_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Mathematics Q76]\\nIf the sum and the product of mean and variance of a binomial distribution are 24 and 128 respectively, then the probability of one or two successes is",
                options = listOf("33/2^32", "33/2^29", "33/2^28", "33/2^27"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q77_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Mathematics Q77]\\nIf the numbers appeared on the two throws of a fair six faced die are α and β, then the probability that x^2 + αx + β > 0, for all x in R, is :",
                options = listOf("17/36", "4/9", "1/2", "19/36"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q78_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Mathematics Q78]\\nThe number of solutions of |cos x| = sin x, such that – 4pi <= x <= 4pi is :",
                options = listOf("4", "6", "8", "12"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q79_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Mathematics Q79]\\nA tower PQ stands on a horizontal ground with base Q on the ground. The point R divides the tower in two parts such that QR = 15 m. If from a point A on the ground the angle of elevating of R is 60º and the part PR of the tower subtends an angle of 15º at, A, then the height of the tower is : \n(1) 5(2sqrt(3) + 3) m (2) 5(sqrt(3) + 3) m (3) 10(sqrt(3) + 1) m (4) 10(2sqrt(3) + 1) m",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q80_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Mathematics Q80]\\nWhich of the following statements is a tautology ?",
                options = listOf("((~p) v q) -> p", "p -> ((~ p) v q)", "((~p) v q) -> q", "q -> ((~p) v q)"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q81_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Mathematics Q81]\\nLet A = [2 -1 -1; 1 0 -1; 1 -1 0] and B = A - I. If w = (sqrt(3)i - 1)/2, then the number of elements in the set {n in {1, 2, ....100} : A^n + (wB)^n = A + B} is equal to ------.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 17\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q82_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Mathematics Q82]\\nThe letters of the word ''MANKIND' are written in all possible orders and arranged in serial order as in an English dictionary. Then the serial number of the word 'MANKIND' is-----",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 1492\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q83_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Mathematics Q83]\\nIf the maximum value of the term independent of t in the expansion of (t^2 x^(1/5) + (1-x)^(1/10)/t)^15, x >= 0, is K, then 8K is equal to ------",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 6006\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q84_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Mathematics Q84]\\nLet a, b be two non-zero real numbers. If p and r are the roots of the equation x^2 – 8ax + 2a = 0 and q and s are the roots of the equation x^2 + 12bx + 6b = 0, such that 1/p, 1/q, 1/r, 1/s are in A.P. , then a–1 – b–1 is equal to __",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 38\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q85_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Mathematics Q85]\\nLet a1 = b1 = 1, an = an–1 + 2 and bn = an + bn–1 for every natural number n >= 2. Then sum_{n=1}^15 an.bn is equal to --",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 27560\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q86_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Mathematics Q86]\\nLet f(x) = |4x^2 - 8x + 5| if 8x^2 - 6x + 1 >= 0, [4x^2 - 8x + 5] if 8x^2 - 6x + 1 < 0 where [a] denotes the greatest integer less than or equal to a. Then the number of points in R where f is not differentiable is ------",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 3\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q87_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Mathematics Q87]\\nIf lim_{n->inf} ((n+1)^(k-1) / n^(k+1)) [(nk + 1) + (nk + 2) + ...+ (nk + n)] = 33. lim_{n->inf} (1 / n^(k+1)) [1^k + 2^k + 3^k + ...+ n^k], Then the integral value of k is equal to ------",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 5\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q88_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Mathematics Q88]\\nLet the equation of two diameters of a circle x^2 + y^2 – 2x + 2fy + 1 = 0 be 2px – y = 1 and 2x + py = 4p. Then the slope m in (0, inf) of the tangent to the hyperbola 3x^2 – y^2 = 3 passing through the centre of the circle is equal to ______.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q89_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Mathematics Q89]\\nThe sum of diameters of the circles that touch (i) the parabola 75x^2 = 64(5y – 3) at the point (8/5, 6/5) and (ii) the y-axis, is equal to ----",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 10\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q90_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 2 Shift 1 - Mathematics Q90]\\nThe line of shortest distance between the lines x/0 = (y-1)/1 = z/1 and (x-3)/2 = (y-5)/2 = (z-1)/1 makes an angle of cos^-1(sqrt(2/27)) with the plane P : ax - y - z = 0, (a > 0). If the image of the point (1, 1, -5) in the plane P is (a, b, y), then a + b - y is equal to ----.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 3\\nSolution:\\n",
                difficulty = "Medium"
            )
        )
    }
}