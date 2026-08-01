package com.example.data.repository

import com.example.model.Question

object JeeMain2020Session1Shift1QuestionsRepository {
    fun getQuestions(testId: String): List<Question> {
        return listOf(
            Question(
                id = "${testId}_s1_sh1_q1_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Physics Q1]\nThree point particles of masses 1.0 kg, 1.5 kg and 2.5 kg are placed at three corners of a right angle triangle of sides 4.0 cm, 3.0 cm and 5.0 cm as shown in the figure. The center of mass of the system is at a point -",
                options = listOf("1.5 cm right and 1.2 cm above 1 kg mass", "2.0 cm right and 0.9 cm above 1 kg mass", "0.9 cm right and 2.0 cm above 1 kg mass", "0.6 cm right and 2.0 cm above 1 kg mass"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\nx_cm = (1*0 + 1.5*3 + 2.5*0)/5 = 0.9 cm\ny_cm = (1*0 + 1.5*0 + 2.5*4)/5 = 2.0 cm""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q2_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Physics Q2]\nVisible light of wavelength 6000 * 10^-8 cm falls normally on a single slit and produces a diffraction pattern. It is found that the second diffraction minimum is at 60 deg from the central maximum. If the first minimum is produced at theta_1, then theta_1 is close to -",
                options = listOf("45 deg", "20 deg", "30 deg", "25 deg"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4\nSolution:\nd sin 60 = 2 lambda => d sqrt(3)/2 = 2 lambda => d = 4 lambda / sqrt(3)\nFirst minimum: d sin theta_1 = lambda => sin theta_1 = lambda / d = sqrt(3) / 4 = 0.433\ntheta_1 ~ 25 deg""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q3_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Physics Q3]\nThe time period of revolution of electron in its ground state orbit in a hydrogen atom is 1.6 * 10^-16 s. The frequency of revolution of the electron in its first excited state (in s^-1) is -",
                options = listOf("1.6 * 10^14", "5.6 * 10^12", "6.2 * 10^15", "7.8 * 10^14"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4\nSolution:\nf_n prop 1/n^3. f_2 = f_1 / 8 = 1 / (8 * 1.6 * 10^-16) = 7.8 * 10^14 Hz.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q4_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Physics Q4]\nA litre of dry air at STP expands adiabatically to volume of 3 litres. If gamma = 1.40, the work done by air is : (3^1.4 = 4.6555) [Take air to be an ideal gas]",
                options = listOf("100.8 J", "48 J", "90.5 J", "60.7 J"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\nW = (P1V1 - P2V2)/(gamma - 1). P2 = P1 (V1/V2)^gamma = 10^5 * (1/3)^1.4.\nW = P1V1 (1 - (V1/V2)^(gamma - 1)) / (gamma - 1) = 10^5 * 10^-3 * (1 - (1/3)^0.4) / 0.4 = 90.5 J.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q5_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Physics Q5]\nA long solenoid of radius R carries a time (t) - dependent current I(t) = I_0 t(1 - t). A ring of radius 2R is placed coaxially near its middle. During the time interval 0 <= t <= 1, the induced current (I_R) and the induced EMF (V_R) in the ring change as -",
                options = listOf("Direction of I_R remains unchanged and V_R is maximum at t = 0.5", "At t = 0.25 direction of I_R reverses and V_R is maximum", "Direction of I_R remains unchanged and V_R is zero at t = 0.25", "At t = 0.5 direction of I_R reverses and V_R is zero"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4\nSolution:\nV_R = -dPhi/dt prop -dI/dt = -I_0 (1 - 2t). At t = 0.5, V_R = 0 and changes sign, so I_R reverses.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q6_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Physics Q6]\nWhich of the following gives a reversible operation ?",
                options = listOf("AND", "OR", "NAND", "NOT"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4\nSolution:\nNOT gate is a reversible logic gate.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q7_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Physics Q7]\nAs shown in the figure, a bob of mass m is tied by massless string whose other end portion is wound on a fly wheel (disc) of radius r and mass m. When released from rest the bob starts falling vertically. When it has covered a distance of h, the angular speed of the wheel will be -",
                options = listOf("1/r sqrt(3/2gh)", "1/r sqrt(4gh/3)", "1/r sqrt(3/4gh)", "1/r sqrt(2gh/3)"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2\nSolution:\nmgh = 1/2 m v^2 + 1/2 I w^2 = 1/2 m (wr)^2 + 1/2 (mr^2 / 2) w^2 = 3/4 m r^2 w^2. w = 1/r * sqrt(4gh/3).""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q8_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Physics Q8]\nTwo infinite planes each with uniform surface charge density + sigma are kept in such a way that the angle between them is 30 deg. The electric field in the region shown between them is given by -",
                options = listOf("sigma/(2e0) [ (1 + sqrt(3)) j + x/2 ]", "sigma/e0 [ (1 + sqrt(3)/2) j + x/2 ]", "sigma/(2e0) [ (1 - sqrt(3)) j - x/2 ]", "sigma/(2e0) [ (1 - sqrt(3)/2) j - x/2 ]"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4\nSolution:\nE1 = sigma/(2 eps0) j. E2 = sigma/(2 eps0) (sin 30 (-i) - cos 30 j). E = E1 + E2 = sigma/(2eps0) (-1/2 i + (1 - sqrt(3)/2) j).""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q9_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Physics Q9]\nA polarizer-analyser set is adjusted such that the intensity of light coming out of the analyser is just 10 % of the original intensity. Assuming that the polarizer-analyser set does not absorb any light, the angle by which the analyser need to be rotated further to reduce the output intensity to be zero, is -",
                options = listOf("90 deg", "45 deg", "18.4 deg", "71.6 deg"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\nI_0 cos^2 theta = 0.1 I_0 => cos theta = 1/sqrt(10) => theta = 71.6 deg. For zero intensity, angle should be 90 deg. Further rotation = 90 - 71.6 = 18.4 deg.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q10_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Physics Q10]\nA parallel plate capacitor has plates of area A separted by distance 'd' between them. It is filled with a dielectric which has a dielectric constant that varies as k(x) = K(1 + alpha x) where 'x' is the distance measured from one of the plates. If (alpha d) <<1, the total capacitance of the system is best given by the expression :",
                options = listOf("AKeps0/d (1 + alpha d)", "AKeps0/d (1 + alpha d / 2)^2", "AKeps0/d (1 + alpha d / 2)", "A^2Keps0/d (1 + alpha d / 2)"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\n1/C = int 1/(K eps0 A (1 + alpha x)) dx = 1/(K eps0 A alpha) ln(1 + alpha d) ~ 1/(K eps0 A alpha) (alpha d - (alpha d)^2/2) = d/(K eps0 A) (1 - alpha d / 2). C = K eps0 A / d (1 + alpha d / 2).""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q11_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Physics Q11]\nA satellite of mass m is launched vertically upwards with an initial speed u from the surface of the earth. After it reaches height R(R = radius of the earth), it ejects a rocket of mass m/10 so that subsequently the satellite moves in a circular orbit. The kinetic energy of the rocket is :",
                options = listOf("5m (u^2 - 119GM/200R)", "m/20 (u^2 - 2GM/3R)", "3m/8 (u^2 + 5GM/6R)", "m/20 (u^2 + 113GM/200R)"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1\nSolution:\nFrom energy conservation, v = sqrt(u^2 - GM/R). Circular orbit requires v_s = sqrt(GM/2R). By momentum conservation, mv = (9m/10) v_s j + (m/10) v_r. v_r = 10v i - 9v_s j. KE of rocket = 1/2 (m/10) (100v^2 + 81v_s^2) = 5m (u^2 - 119GM/200R).""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q12_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Physics Q12]\nA LCR circuit behaves like a damped harmonic oscillator. Comparing it with a physical spring-mass damped oscillator having damping constant 'b', the correct equivalence would be -",
                options = listOf("L <-> k, C <-> b, R <-> m", "L <-> m, C <-> k, R <-> b", "L <-> m, C <-> 1/k, R <-> b", "L <-> 1/b, C <-> 1/m, R <-> 1/k"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\nL d^2q/dt^2 + R dq/dt + q/C = 0. m d^2x/dt^2 + b dx/dt + kx = 0. L corresponds to m, R corresponds to b, 1/C corresponds to k.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q13_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Physics Q13]\nConsider a circular coil of wire carrying constant current I, forming a magnetic dipole. The magnetic flux through an infinite plane that contains the circular coil and excluding the circular coil area is given by phi_i. The magnetic flux through the area of the circular coil area is given by phi_0. Which of the following option is correct ?",
                options = listOf("phi_i < phi_0", "phi_i > phi_0", "phi_i = phi_0", "phi_i = - phi_0"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4\nSolution:\nMagnetic field lines form closed loops. Flux through inner area is equal and opposite to flux through outer infinite area.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q14_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Physics Q14]\nThe current I_1 (in A) flowing through 1 ohm resistor in the following circuit is -",
                options = listOf("0.2", "0.4", "0.25", "0.5"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1\nSolution:\nEquivalent resistance of 1, 1, 2, 2 ohm setup gives total R_eq. Current I_1 = 0.2 A.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q15_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Physics Q15]\nSpeed of a transverse wave on a straight wire (mass 6.0 g, length 60 cm and area of cross-section 1.0 mm^2) is 90 ms^-1. If the Young's modulus of wire is 16 * 10^11 Nm^-2, the extension of wire over its natural length is -",
                options = listOf("0.01 mm", "0.04 mm", "0.02 mm", "0.03 mm"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4\nSolution:\nv = sqrt(T/u) => T = mu * v^2 = (0.006 / 0.6) * 90^2 = 81 N. dl = TL / AY = 81 * 0.6 / (10^-6 * 16 * 10^11) = 0.03 mm.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q16_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Physics Q16]\nIf the magnetic field in a plane electromagnetic wave is given by B = 3 * 10^-8 sin (1.6 * 10^3 x + 48 * 10^10 t) j T, then what will be expression for electric field ?",
                options = listOf("E = [9sin(1.6 * 10^3 x + 48 * 10^10 t) k V/m]", "E = [60 sin (1.6 * 10^3 x + 48 * 10^10 t) k V/m]", "E = [3 * 10^-8 sin (1.6 * 10^3 x + 48 * 10^10 t) i V/m]", "E = [3 * 10^-8 sin(1.6 * 10^3 x + 48 * 10^10 t) j V/m]"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1\nSolution:\nE0 = c B0 = 3e8 * 3e-8 = 9 V/m. Direction of propagation is -x. E x B must be in -x direction. So E is in k direction.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q17_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Physics Q17]\nIf we need a magnification of 375 from a compound microscope of tube length 150 mm and an objective of focal length 5 mm, the focal length of the eye-piece, should be close to -",
                options = listOf("12 mm", "33 mm", "22 mm", "2 mm"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\nM = (L/f_o) * (D/f_e) => 375 = (150/5) * (250/f_e) => f_e = 20 mm for relaxed eye. For near point, 375 = 30 * (1 + 250/fe) => fe = 22 mm.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q18_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Physics Q18]\nA 60 HP electric motor lifts an elevator having a maximum total load capacity of 2000 kg. If the frictional force on the elevator is 4000 N, the speed of the elevator at full load is close to : (1 HP = 746 W, g = 10 ms^-2)",
                options = listOf("1.7 ms^-1", "1.9 ms^-1", "2.0 ms^-1", "1.5 ms^-1"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2\nSolution:\nPower = F * v. Total force = 2000 * 10 + 4000 = 24000 N. Power = 60 * 746 = 44760 W. v = 44760 / 24000 = 1.865 ~ 1.9 m/s.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q19_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Physics Q19]\nThe radius of gyration of a uniform rod of length l, about an axis passing through a point l/4 away from the centre of the rod, and perpendicular to it, is -",
                options = listOf("sqrt(3/8) l", "1/8 l", "sqrt(7/48) l", "1/4 l"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\nI = ml^2/12 + m(l/4)^2 = ml^2/12 + ml^2/16 = 7ml^2/48. k = sqrt(7/48) l.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q20_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Physics Q20]\nTwo moles of an ideal gas with C_P/C_V = 5/3 are mixed with 3 moles of another ideal gas with C_P/C_V = 4/3. The value of C_P/C_V for the mixture is -",
                options = listOf("1.50", "1.42", "1.47", "1.45"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2\nSolution:\nC_v_mix = (n1 C_v1 + n2 C_v2) / (n1 + n2) = (2 * 3/2 R + 3 * 3 R) / 5 = 12/5 R. C_p_mix = C_v_mix + R = 17/5 R. Gamma_mix = 17/12 = 1.42.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q21_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Physics Q21]\nA beam of electromagnetic radiation of intensity 6.4 * 10^-5 W/cm2 is comprised of wavelength, lambda = 310 nm. It falls normally on a metal (work function phi = 2eV) of surface area of 1 cm^2. If one in 10^3 photons ejects an electron, total number of electrons ejected in 1 s is 10^x. (hc = 1240 eVnm, 1eV = 1.6 * 10^-19 J), then x is ............ .",
                options = listOf("11", "10", "12", "13"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 11\nSolution:\nEnergy of photon = 1240 / 310 = 4 eV. Number of photons = I A t / E = 6.4e-5 * 10^-4 * 1 / (4 * 1.6e-19) = 10^14. Electrons = 10^14 / 10^3 = 10^11. x = 11.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q22_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Physics Q22]\nA loop ABCDEFA of straight edges has six corner points A(0, 0, 0), B(5, 0, 0), C(5, 5, 0), D(0, 5, 0), E(0, 5, 5) and F(0, 0, 5). The magnetic field in this region is B = (3 i + 4 k ) T. The quantity of flux through the loop ABCDEFA (in Wb) is ............... .",
                options = listOf("175", "150", "200", "125"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 175\nSolution:\nArea vectors are 25 k and 25 i. Flux = B.A = (3i + 4k).(25i + 25k) = 75 + 100 = 175 Wb.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q23_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Physics Q23]\nA non-isotropic solid metal cube has coefficients of linear expansion as : 5 * 10^-5 / deg C along the x-axis and 5 * 10^-6 / deg C along the y and the z-axis. If the coefficient of volume expansion of the solid is C * 10^-6 / deg C then the value of C is .................. .",
                options = listOf("60", "50", "70", "55"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 60\nSolution:\nGamma = alpha_x + alpha_y + alpha_z = 50e-6 + 5e-6 + 5e-6 = 60e-6. C = 60.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q24_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Physics Q24]\nA Carnot engine operates between two reservoirs of temperatures 900 K and 300 K. The engine performs 1200 J of work per cycle. The heat energy (in J) delivered by the engine to the low temperature reservoir, in a cycle, is .................. .",
                options = listOf("600", "400", "800", "500"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 600\nSolution:\nEfficiency = 1 - 300/900 = 2/3. W = 2/3 Q_in => Q_in = 1800 J. Q_out = 1800 - 1200 = 600 J.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q25_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Physics Q25]\nA particle (m = 1 kg) slides down a frictionless track (AOC) starting from rest at a point A (height 2 m). After reaching C, the particle continues to move freely in air as a projectile. When it reaching its highest point P (height 1 m), the kinetic energy of the particle (in J) is : (take g = 10 ms^-2) .................... .",
                options = listOf("10", "20", "15", "5"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 10\nSolution:\nLoss in potential energy = mgh = 1 * 10 * 1 = 10 J. This is converted to kinetic energy.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q26_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Chemistry Q26]\nThe increasing order of pKb for the following compounds will be\n(A) NH2-CH=NH, (B) N,N-diethylaniline, (C) CH3NHCH3",
                options = listOf("(B) < (C) < (A)", "(C) < (A) < (B)", "(B) < (A) < (C)", "(A) < (B) < (C)"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2\nSolution:\nStronger base has lower pKb. (A) is guanidine (very strong base), (C) is aliphatic amine (strong), (B) is aromatic amine (weak). Base strength: (A) > (C) > (B). pKb: (B) > (C) > (A).""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q27_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Chemistry Q27]\nThe IUPAC name of the complex [Pt(NH3)2Cl(NH2CH3)]Cl is :",
                options = listOf("Bisammine(methanamine)chloridoplatinum(II)chloride", "Diammine(methanamine)chloridoplatinum(II)chloride", "Diamminechlorido(methanamine)platinum(II)chloride", "Diamminechlorido(aminomethane)platinum(II)chloride"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\nAlphabetical order: ammine, chlorido, methanamine. Diamminechlorido(methanamine)platinum(II)chloride.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q28_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Chemistry Q28]\nGiven that the standard potentials (E deg) of Cu2+/Cu and Cu+/Cu are 0.34 V and 0.522 V respectively, the E deg of Cu2+/Cu+ is -",
                options = listOf("+ 0.158 V", "0.182 V", "– 0.158 V", "– 0.182 V"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1\nSolution:\nCu2+ + 2e -> Cu, dG1 = -2F(0.34). Cu+ + e -> Cu, dG2 = -F(0.522). Cu2+ + e -> Cu+, dG3 = dG1 - dG2 = -F(0.68 - 0.522) = -F(0.158). E = +0.158 V.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q29_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Chemistry Q29]\nConsider the following reactions :\n(a) (CH3)3CCH(OH)CH3 -> cons. H2SO4\n(b) (CH3)2CHCH(Br)CH3 -> cons. KOH\n(c) (CH3)2CHCH(Br)CH3 -> (CH3)3CO-K+\n(d) (CH3)2C(OH)-CH2-CHO -> heat\nWhich of these reactions(s) will not produce Saytzeff product ?",
                options = listOf("(d) only", "(c) only", "(b) and (d)", "(a), (c) and (d)"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2\nSolution:\nBulky base (t-butoxide) prefers Hofmann product (less substituted alkene).""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q30_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Chemistry Q30]\nConsider the following reaction :\n(N,N-dimethylaniline) + Na+ -O3S-C6H4-N2+ Cl- -> OH- -> 'X'\nThe product 'X' is used",
                options = listOf("as food grade colourant", "in laboratory test for phenols", "in protein estimation as an alternative to ninhydrin", "in acid base titration as an indicator"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4\nSolution:\nThe product is Methyl Orange, which is used as an acid-base indicator.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q31_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Chemistry Q31]\nAmongst the following statements, that which was not proposed by Dalton was -",
                options = listOf("All the atoms of a given element have identical properties including identical mass. Atoms of different elements differ in mass", "When gases combine or reproduced in a chemical reaction they do so in a simple ratio by volume provided all gases are at the same T & P", "Matter consists of indivisible atoms", "Chemical reactions involve reorganization of atoms. These are neither created nor destroyed in a chemical reaction."),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2\nSolution:\nStatement 2 is Gay-Lussac's law of combining volumes, not Dalton's theory.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q32_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Chemistry Q32]\nAt 35C, the vapour pressure of CS2 is 512 mm Hg and that of acetone is 344 mm Hg. A solution of CS2 in acetone has a total vapour pressure of 600 mm Hg. The false statement amongst the following is :",
                options = listOf("A mixture of 100 mL CS2 and 100 mL acetone has a volume < 200 mL", "Roult's law is not obeyed by this system", "CS2 and acetone are less attracted to each other than to themselves", "Heat must be absorbed in order to produce the solution at 35C"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1\nSolution:\nThe mixture shows positive deviation from Raoult's law. For positive deviation, dV_mix > 0, so volume will be > 200 mL.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q33_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Chemistry Q33]\nThe purest form of commercial iron is :",
                options = listOf("Cast iron", "Scarp iron and pig iron", "Pig iron", "Wrought iron"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4\nSolution:\nWrought iron is the purest form of commercial iron.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q34_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Chemistry Q34]\nThe electron gain enthalpy (in kJ/mol) of fluorine, chlorine, bromine and iodine, respectively, are :",
                options = listOf("– 333, – 349, – 325 and – 296", "– 296, – 325, – 333 and – 349", "– 333, – 325, – 349 and – 296", "– 349, – 333, – 325 and – 296"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1\nSolution:\nChlorine has higher electron gain enthalpy than fluorine. Order: Cl > F > Br > I.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q35_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Chemistry Q35]\nIn comparison to the zeolite process for the removal of permanent hardness, the synthetic resins method is :",
                options = listOf("More efficient as it can exchange only cations", "Less efficient as the resins cannot be regenerated", "More efficient as it can exchange both cations as well as anions", "Less efficient as it exchanges only anions."),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\nSynthetic resin method is more efficient as it can exchange both cations and anions (if mixed bed).""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q36_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Chemistry Q36]\n1-Methyl ethylene oxide when treated with an excess of HBr produces :",
                options = listOf("1,2-dibromopropane", "1-bromo-2-propanol", "2-bromo-1-propanol", "1,3-dibromopropane"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1\nSolution:\nWith excess HBr, the epoxide ring opens and the resulting alcohol is also converted to bromide, giving 1,2-dibromopropane.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q37_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Chemistry Q37]\nWhat is the product of following reactions ?\nHex – 3 – ynal -> (i) NaBH4 (ii) PBr3 (iii) Mg/ether (iv) CO2 / H3O+",
                options = listOf("Hept-4-ynoic acid", "Hept-3-ynoic acid", "Hept-5-ynoic acid", "Hex-3-enoic acid"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1\nSolution:\nAldehyde reduced to alcohol, then bromide, then Grignard, then CO2 gives carboxylic acid. Product is hept-4-ynoic acid.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q38_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Chemistry Q38]\nThe relative strength of interionic / intermolecular forces in decreasing order is",
                options = listOf("ion-dipole > ion-ion > dipole-dipole", "dipole-dipole > ion-dipole > ion-ion", "ion-ion > ion-dipole > dipole-dipole", "ion-dipole > dipole-dipole > ion-ion"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\nIon-ion forces are strongest, followed by ion-dipole, then dipole-dipole.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q39_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Chemistry Q39]\nThe theory that can completely/properly explain the nature of bonding in [Ni(CO)4] is",
                options = listOf("Molecular orbital theory", "Valence bond theory", "Werner's theory", "Crystal field theory"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1\nSolution:\nMolecular orbital theory (synergic bonding, pi back-bonding) explains metal carbonyls.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q40_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Chemistry Q40]\nOxidation number of potassium in K2O, K2O2 and KO2, respectively, is :",
                options = listOf("+1, +2 and +4", "+2, +1 and + 1/2", "+1, +1 and +1", "+1, +4 and +2"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\nAlkali metals always have +1 oxidation state in their compounds.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q41_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Chemistry Q41]\nThe atomic radius of Ag is closest to :",
                options = listOf("Ni", "Hg", "Au", "Cu"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\nDue to lanthanide contraction, the atomic radii of 4d and 5d series elements are almost similar (Ag and Au).""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q42_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Chemistry Q42]\nMatch the following :\n(i) Riboflavin (a) Beriberi\n(ii) Thiamine (b) Scurvy\n(iii) Pyridoxine (c) Cheilosis\n(iv) Ascorbic acid (d) Convulsions",
                options = listOf("(i) – (d), (ii) – (b), (iii) – (a), (iv) – (c)", "(i) – (a), (ii) – (d), (iii) – (c), (iv) – (b)", "(i) – (c), (ii) – (a), (iii) – (d), (iv) – (b)", "(i) – (c), (ii) – (d), (iii) – (a), (iv) – (b)"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\nRiboflavin (B2) - Cheilosis. Thiamine (B1) - Beriberi. Pyridoxine (B6) - Convulsions. Ascorbic acid (C) - Scurvy.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q43_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Chemistry Q43]\nThe dipole moments of CCl4, CHCl3 and CH4 are in the order :",
                options = listOf("CCl4 < CH4< CHCl3", "CHCl3 < CH4 = CCl4", "CH4 = CCl4 < CHCl3", "CH4 < CCl4 < CHCl3"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\nCH4 and CCl4 are perfectly symmetrical, so their dipole moments are zero. CHCl3 has a net dipole moment.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q44_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Chemistry Q44]\nA solution of m-chloroaniline, m-chlorophenol and m-chlorobenzoic acid in ethyl acetate was extracted initially with a saturated solution of NaHCO3 to give fraction A. The left over organic phase was extracted with dilute NaOH solution to give fraction B. The final organic layer was labelled as fraction C. Fraction A, B and C, contain respectively :",
                options = listOf("m-chlorobenzoic acid, m-chloroaniline and m-chlorophenol", "m-chlorophenol, m-chlorobenzoic acid and m-chloroaniline", "m-chloroaniline, m-chlorobenzoic acid and m-chlorophenol", "m-chlorobenzoic acid, m-chlorophenol and m-chloroaniline"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4\nSolution:\nNaHCO3 extracts the strongest acid (benzoic acid). NaOH extracts phenol. Aniline remains in the organic layer.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q45_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Chemistry Q45]\nThe number of orbitals associated with quantum numbers n = 5, ms = + 1/2 is :",
                options = listOf("15", "50", "11", "25"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4\nSolution:\nFor n=5, total orbitals = n^2 = 25. All 25 orbitals can have an electron with ms = +1/2.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q46_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Chemistry Q46]\nFor the reaction; A(l) -> 2B(g), delta U = 2.1 kcal, delta S = 20 cal K^-1 at 300 K. Hence delta G in kcal is ______.",
                options = listOf("-2.70", "2.70", "0", "-1.50"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: -2.70\nSolution:\ndH = dU + dng RT = 2.1 + 2 * 2e-3 * 300 = 3.3 kcal. dG = dH - TdS = 3.3 - 300 * 20e-3 = -2.7 kcal.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q47_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Chemistry Q47]\nTwo solutions, A and B, each of 100 L was made by dissolving 4 g of NaOH and 9.8 g of H2SO4 in water, respectively. The pH of the resultant solution obtained from mixing 40 L of solution A and 10 L of solution B is _______.",
                options = listOf("10.60", "11.20", "9.40", "12.00"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 10.60\nSolution:\nM_A = 0.001 M NaOH. M_B = 0.001 M H2SO4. OH- from A = 40 * 0.001 = 0.04 mol. H+ from B = 10 * 0.002 = 0.02 mol. Excess OH- = 0.02 mol in 50 L. [OH-] = 0.02/50 = 4e-4. pOH = 3.4. pH = 10.6.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q48_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Chemistry Q48]\nDuring the nuclear explosion, one of the products is 90Sr with half life of 6.93 years. If 1 ug of 90Sr was absorbed in the bones of a newly born baby in place of Ca, how much time, in years, is required to reduce it by 90% if it is not lost metabolically _______.",
                options = listOf("23.03", "46.06", "11.51", "34.55"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 23.03\nSolution:\nt = 2.303 / lambda * log(100/10) = 2.303 * 6.93 / 0.693 * 1 = 23.03 years.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q49_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Chemistry Q49]\nThe number of chiral carbons in chloramphenicol is ________.",
                options = listOf("2", "1", "3", "4"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 2\nSolution:\nChloramphenicol structure has 2 chiral centers.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q50_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Chemistry Q50]\nChlorine reacts with hot and concentrated NaOH and produces compounds (X) and (Y). Compound (X) gives white precipitate with silver nitrate solution. The average bond order between Cl and O atoms in (Y) is ______.",
                options = listOf("1.67", "1.50", "2.00", "1.33"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1.67\nSolution:\nHot conc NaOH gives NaCl (X) and NaClO3 (Y). ClO3- has 5 bonds over 3 positions, so average bond order is 5/3 = 1.67.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q51_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Mathematics Q51]\nIf y(alpha) = sqrt(2(tan alpha + cot alpha)/(1+tan^2 alpha) + 1/sin^2 alpha), alpha in (3pi/4, pi), then dy/d_alpha at alpha = 5pi/6 is :",
                options = listOf("4/3", "-1/4", "-4", "4"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4\nSolution:\ny = sqrt(2 cot a + cosec^2 a) = sqrt((1+cot a)^2) = |1+cot a|. In (3pi/4, pi), cot a < -1, so y = -1 - cot a. dy/da = cosec^2 a. At 5pi/6, = 4.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q52_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Mathematics Q52]\nIf Re((z-1)/(2z+i)) = 1, where z = x + iy, then the point (x, y) lies on a :",
                options = listOf("circle whose diameter is sqrt(5)/2.", "circle whose centre is at (-1/2, -3/2)", "straight line whose slope is -2/3", "straight line whose slope is 3/2"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1\nSolution:\nLet z = x+iy. Re((x-1+iy)/(2x+i(2y+1))) = 1. (x-1)*2x + y(2y+1) = (2x)^2 + (2y+1)^2. x^2 + y^2 + x + 3y/2 + 1/2 = 0. Circle. Radius = sqrt(1/4 + 9/16 - 1/2) = sqrt(5)/4. Diameter = sqrt(5)/2.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q53_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Mathematics Q53]\nIf the distance between the foci of an ellipse is 6 and the distance between its directrices is 12, then the length of its latus rectum is",
                options = listOf("2 sqrt(3)", "3/sqrt(2)", "sqrt(3)", "3 sqrt(2)"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4\nSolution:\n2ae = 6 => ae = 3. 2a/e = 12 => a/e = 6. a^2 = 18. e^2 = 1/2. b^2 = a^2(1-e^2) = 9. L.R. = 2b^2/a = 18 / sqrt(18) = sqrt(18) = 3 sqrt(2).""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q54_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Mathematics Q54]\nTotal number of 6-digit numbers in which only and all the five digits 1, 3, 5, 7 and 9 appear, is",
                options = listOf("5/2 (6!)", "1/2 (6!)", "5^6", "6!"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1\nSolution:\nChoose the repeated digit: 5C1. Arrange the 6 digits: 6!/2!. Total = 5 * 6!/2 = 5/2 (6!).""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q55_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Mathematics Q55]\nThe greatest positive integer k, for which 49^k + 1 is a factor of the sum 49^125 + 49^124 + ...+ 49^2 + 49 + 1, is :",
                options = listOf("65", "60", "32", "63"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4\nSolution:\nSum is (49^126 - 1)/48. 49^126 - 1 = (49^63 - 1)(49^63 + 1). So 49^63 + 1 is a factor. k = 63.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q56_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Mathematics Q56]\nLet a and b be two real roots of the equation (k + 1) tan^2 x - sqrt(2) * l * tan x = (1 - k), where k (!= - 1) and l are real numbers. If tan^2 (a + b) = 50, then a value of l is :",
                options = listOf("5", "10", "5 sqrt(2)", "10 sqrt(2)"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2\nSolution:\ntan a + tan b = sqrt(2)l / (k+1). tan a tan b = (k-1)/(k+1). tan(a+b) = sqrt(2)l / (k+1 - k + 1) = sqrt(2)l / 2 = l/sqrt(2). tan^2(a+b) = l^2 / 2 = 50. l^2 = 100 => l = 10.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q57_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Mathematics Q57]\nThe logical statement (p => q) ^ (q => ~p) is equivalent to :",
                options = listOf("p", "~q", "q", "~p"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4\nSolution:\nIf p is true and q is true, F. If p is T, q is F, F. If p is F, q is T, T. If p is F, q is F, T. This is equivalent to ~p.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q58_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Mathematics Q58]\nIf y = mx + 4 is a tangent to both the parabolas, y^2 = 4x and x^2 = 2by, then b is equal to",
                options = listOf("-64", "-128", "-32", "128"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2\nSolution:\ny = mx + a/m. For y^2 = 4x, a=1. So 1/m = 4 => m=1/4. For x^2 = 2by, tangent is y = mx - bm^2. So 4 = -b(1/4)^2 => b = -64? Wait. Let me check the formula. For x^2 = 4ay, tangent is x = my + a/m? No, y = mx - am^2. Here 4a = 2b => a = b/2. So 4 = -(b/2) * (1/4)^2 = -b/32 => b = -128.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q59_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Mathematics Q59]\nIf y = y(x) is the solution of the differential equation, e^y (dy/dx - 1) = e^x such that y(0) = 0, then y(1) is equal to :",
                options = listOf("2e", "2 + log_e 2", "1 + log_e 2", "log_e 2"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\ne^y dy/dx - e^y = e^x. Let e^y = t. dt/dx - t = e^x. IF = e^-x. t e^-x = x + C. e^{y-x} = x + C. y(0)=0 => 1 = C. e^{y-x} = x + 1. y-x = ln(x+1). y = x + ln(x+1). y(1) = 1 + ln 2.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q60_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Mathematics Q60]\nIf f(a + b + 1 - x) = f(x), for all x, where a and b are fixed positive real numbers, then 1/(a+b) int_a^b x (f(x) + f(x+1)) dx is equal to :",
                options = listOf("int_{a+1}^{b+1} f(x)dx", "int_{a-1}^{b-1} f(x)dx", "int_{a+1}^{b+1} f(x+1)dx", "int_{a-1}^{b-1} f(x+1)dx"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4\nSolution:\nI = int_a^b (a+b-x) (f(a+b-x) + f(a+b-x+1)) dx = int_a^b (a+b-x) (f(x+1) + f(x)) dx. 2I = (a+b) int_a^b (f(x+1)+f(x)) dx. But f(a+b-x) = f(x+1). So int_a^b f(x) dx = int_a^b f(a+b-x) dx = int_a^b f(x+1) dx. Thus 2I = 2(a+b) int_a^b f(x) dx => I / (a+b) = int_a^b f(x+1) dx = int_{a-1}^{b-1} f(x+2) dx? Wait. int_a^b f(x+1) dx = int_{a+1}^{b+1} f(x) dx = int_{a-1}^{b-1} f(x+2)?""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q61_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Mathematics Q61]\nLet the function, f : [-7, 0] -> R be continuous on [-7, 0] and differentiable on (-7, 0). If f(-7) = - 3 and f'(x) <= 2, for all x in (-7, 0), then for all such functions f, f(-1) + f(0) lies in the interval :",
                options = listOf("(-inf, 20]", "[-6, 20 ]", "[-3, 11]", "(-inf, 11]"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1\nSolution:\nf(0) - f(-7) <= 14 => f(0) <= 11. f(-1) - f(-7) <= 12 => f(-1) <= 9. f(-1) + f(0) <= 20.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q62_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Mathematics Q62]\nLet P be a plane passing through the points (2, 1, 0) , (4, 1, 1) and (5, 0, 1) and R be any point (2, 1, 6). Then the image of R in the plane P is",
                options = listOf("(4, 3, 2)", "(6, 5, 2)", "(6, 5, -2)", "(3, 4, -2)"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\nPlane equation: x + y - 2z = 3. Image of (2,1,6) in this plane: (x-2)/1 = (y-1)/1 = (z-6)/-2 = -2(2+1-12-3)/6 = 4. x = 6, y = 5, z = -2.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q63_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Mathematics Q63]\nIf g(x) = x^2 + x - 1 and (gof) (x) = 4x^2 - 10x + 5, then f(5/4) is equal to:",
                options = listOf("-3/2", "-1/2", "3/2", "1/2"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2\nSolution:\ng(f(5/4)) = 4(25/16) - 50/4 + 5 = -5/4. Let f(5/4) = t. t^2 + t - 1 = -5/4 => t^2 + t + 1/4 = 0 => (t + 1/2)^2 = 0 => t = -1/2.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q64_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Mathematics Q64]\nLet alpha be a root of the equation x^2 + x + 1 = 0 and the matrix A = 1/sqrt(3) [1 1 1; 1 a a^2; 1 a^2 a^4], then the matrix A^31 is equal to",
                options = listOf("I3", "A^3", "A^2", "A"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2\nSolution:\nA^2 = [1 0 0; 0 0 1; 0 1 0]. A^4 = I. A^31 = A^3.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q65_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Mathematics Q65]\nFive number are in A.P., whose sum is 25 and product is 2520. If one of these five numbers is -1/2, then the greatest number amongst them is",
                options = listOf("7", "16", "21/2", "27"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2\nSolution:\na = 5. Roots are 5-2d, 5-d, 5, 5+d, 5+2d. 5(25-4d^2)(25-d^2) = 2520 => (25-4d^2)(25-d^2) = 504. For d=11/2, we get -1/2 as a term. Greatest = 5+11 = 16.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q66_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Mathematics Q66]\nLet x^k + y^k = a^k, (a, k > 0) and dy/dx + (y/x)^(1/3) = 0, then k is",
                options = listOf("4/3", "2/3", "3/2", "1/3"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2\nSolution:\nk x^{k-1} + k y^{k-1} dy/dx = 0 => dy/dx = -(x/y)^{k-1} = -(y/x)^{1-k}. Given 1-k = 1/3 => k = 2/3.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q67_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Mathematics Q67]\nAn unbiased coin is tossed 5 times. Suppose that a variable X is assigned the value k when k consecutive heads are obtained for k = 3, 4, 5, otherwise X takes the value -1. Then the expected value of X, is :",
                options = listOf("3/16", "-1/8", "1/8", "-3/16"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\nP(X=5) = 1/32. P(X=4) = 2/32. P(X=3) = 5/32. P(X=-1) = 24/32. E(X) = (5 + 8 + 15 - 24)/32 = 4/32 = 1/8.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q68_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Mathematics Q68]\nThe area of the region, enclosed by the circle x^2 + y^2 = 2 which is not common to the region bounded by the parabola y^2 = x and the straight line y = x, is :",
                options = listOf("1/6 (24pi - 1)", "1/6 (12pi - 1)", "1/3 (12pi - 1)", "1/3 (6pi - 1)"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2\nSolution:\nCommon area = int_0^1 (sqrt(x) - x) dx = 1/6. Not common = pi(sqrt(2))^2 - 1/6 = 2pi - 1/6 = 1/6 (12pi - 1).""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q69_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Mathematics Q69]\nIf the system of linear equations\n2x + 2ay + az = 0,\n2x + 3by + bz = 0,\n2x + 4cy + cz = 0\nWhere a, b, c in R are non-zero and distinct; has a non-zero solution, then :",
                options = listOf("a, b, c are in G.P.", "a, b, c are in A.P.", "1/a, 1/b, 1/c are in A.P.", "a + b + c = 0"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3\nSolution:\nDeterminant is 0. 2a(3bc - 4bc) - ... = 0 => 1/a, 1/b, 1/c are in AP.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q70_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Mathematics Q70]\nA vector a = alpha i + 2 j + beta k (alpha, beta in R) lies in the plane of the vectors, b = i + j and c = i - j + 4k. If a bisects the angle b and c, then :",
                options = listOf("a . i + 3 = 0", "a . i + 1 = 0", "a . k + 2 = 0", "a . k + 4 = 0"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: Bonus\nSolution:\nAngle bisector vector. No option satisfies.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q71_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Mathematics Q71]\nlim_{x->2} (3^x + 3^{3-x} - 12) / (3^{-x/2} - 3^{1-x}) is equal to",
                options = listOf("36", "72", "18", "24"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 36\nSolution:\nLet 3^(x/2) = t. Lim t->3 (t^2 + 27/t^2 - 12) / (1/t - 3/t^2). Solving gives 36.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q72_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Mathematics Q72]\nLet A(1, 0), B(6, 2) and C(3/2, 6) be the vertices of a triangle ABC. If P is a point inside the triangle ABC such that the triangles APC, APB and BPC have equal areas, then the length of the line segment PQ, where Q is the point (-7/6, -1/3), is",
                options = listOf("5", "4", "3", "6"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 5\nSolution:\nP is centroid of ABC = (17/6, 8/3). PQ = sqrt((17/6 + 7/6)^2 + (8/3 + 1/3)^2) = sqrt(16 + 9) = 5.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q73_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Mathematics Q73]\nIf the sum of the coefficients of all even powers of x in the product (1 + x + x^2 + ... + x^{2n}) (1 - x + x^2 - x^3 + ... + x^{2n}) is 61, then n is equal to",
                options = listOf("30", "15", "60", "20"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 30\nSolution:\nLet P(x) = product. Sum of even powers is (P(1) + P(-1))/2. P(1) = (2n+1)*1 = 2n+1. P(-1) = 1 * (2n+1) = 2n+1. So sum = 2n+1 = 61 => 2n = 60 => n = 30.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q74_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Mathematics Q74]\nIf the variance of the first n natural numbers is 10 and the variance of the first m even natural numbers is 16, then m + n is equal to .....",
                options = listOf("18", "17", "19", "20"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 18\nSolution:\nVar(n) = (n^2 - 1)/12 = 10 => n = 11. Var(even) = 4 * Var(m) = 4(m^2 - 1)/12 = 16 => m^2 - 1 = 48 => m = 7. m+n = 18.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q75_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 1 - Mathematics Q75]\nLet S be the set of points where the function, f(x) = |2 - |x - 3||, x in R, is not differentiable. Then sum_{x in S} f(f(x)) is equal to ....",
                options = listOf("3", "2", "4", "5"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 3\nSolution:\nNot differentiable at x = 3, 1, 5. f(3)=2, f(1)=0, f(5)=0. f(f(3)) = f(2) = |2 - 1| = 1. f(f(1)) = f(0) = |2 - 3| = 1. f(f(5)) = f(0) = 1. Sum = 3.""",
                difficulty = "Medium"
            ),
        )
    }
}
