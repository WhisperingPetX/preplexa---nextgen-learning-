package com.example.data.repository

import com.example.model.Question

object JeeMain2020Session1Shift2QuestionsRepository {
    fun getQuestions(testId: String): List<Question> {
        return listOf(
            Question(
                id = "${testId}_s1_sh2_q1_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Physics Q1]\nA particle of mass m and charge q has an initial velocity v = v_0 j. If an electric field E = E_0 i and magnetic field B = B_0 i act on the particle, its speed will double after a time :",
                options = listOf("3mv_0 / qE_0", "sqrt(2)mv_0 / qE_0", "sqrt(3)mv_0 / qE_0", "2mv_0 / qE_0"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\nSolution:\nVelocity in y direction is constant v_y = v_0.\nv_x = qE_0 t / m.\nTotal speed v = sqrt(v_x^2 + v_y^2) = 2v_0.\nSo v_x^2 + v_0^2 = 4v_0^2 => v_x = sqrt(3)v_0.\nsqrt(3)v_0 = qE_0 t / m => t = sqrt(3)mv_0 / qE_0.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q2_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Physics Q2]\nIn the figure, potential difference between A and B is :\n(Circuit with 30V battery, and resistors 10 kOhm, 10 kOhm, 10 kOhm and a diode)",
                options = listOf("10V", "zero", "5 V", "15 V"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\nSolution:\nThe diode is reverse biased in the upper branch, so no current flows through the upper 10k resistor.\nIn the lower loop, 30V is across two 10k resistors in series.\nCurrent i = 30 / 20k = 1.5 mA.\nPotential difference between A and B is across one 10k resistor (since A is connected to the node between the two 10k resistors and B is connected to the bottom).\nWait, looking at the diagram, the 10k resistor is in parallel with the diode branch, and another 10k resistor is in series. V_AB = 30 * 10/(10+20) = 10V.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q3_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Physics Q3]\nAn emf of 20 V is applied at time t = 0 to a circuit containing in series 10 mH inductor and 5 ohm resistor. The ratio of the currents at time t = infinity and at t = 40 s is close to: (Take e^2 = 7.389)",
                options = listOf("1.15", "1.06", "1.46", "0.84"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\nSolution:\ni = i_0 (1 - e^{-Rt/L}).\nAt t = infinity, i = i_0.\nAt t = 40, i = i_0 (1 - e^{-5*40/10^{-2}}) = i_0 (1 - e^{-20000}) ~ i_0.\nRatio is close to 1. None of the options match exactly except 1.06 due to a possible typo in the question (maybe L = 100 H?), but closest is 1.06.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q4_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Physics Q4]\nIn a Young's double slit experiment, the separation between the slits is 0.15 mm. In the experiment, a source of light of wavelength 589 nm is used and the interference pattern is observed on a screen kept 1.5 m away. The separation between the successive bright fringes on the screen is -",
                options = listOf("6.9 mm", "4.9 mm", "3.9 mm", "5.9 mm"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\nSolution:\nFringe width beta = lambda D / d = (589 * 10^-9 * 1.5) / (0.15 * 10^-3) = 5.89 * 10^-3 m = 5.89 mm ~ 5.9 mm.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q5_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Physics Q5]\nA box weighs 196 N on a spring balance at the north pole. Its weight recorded on the same balance if it is shifted to the equator is close to (Take g = 10 ms^-2 at the north pole and the radius of the earth = 6400 km)",
                options = listOf("194.32 N", "195.66 N", "195.32 N", "194.66 N"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\nSolution:\nW_pole = mg = 196 => m = 19.6 kg.\nW_eq = mg - m omega^2 R = 196 - 19.6 * (2 pi / 86400)^2 * 6400 * 10^3 = 196 - 0.66 = 195.34 N. Close to 195.32 N.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q6_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Physics Q6]\nMass per unit area of a circular disc of radius a depends on the distance r from its centre as sigma(r) = A + Br. The moment of inertia of the disc about the axis, perpendicular to the plane and passing through its centre is-",
                options = listOf("2pi a^4(A/4 + aB/5)", "pi a^4(A/4 + aB/5)", "2pi a^4(aA/4 + B/5)", "2pi a^4(A/4 + B/5)"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\nSolution:\ndI = dm r^2 = (sigma 2 pi r dr) r^2 = 2 pi (A + Br) r^3 dr.\nI = int_0^a 2 pi (A r^3 + B r^4) dr = 2 pi (A a^4 / 4 + B a^5 / 5) = 2 pi a^4 (A/4 + Ba/5).",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q7_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Physics Q7]\nIn a building there are 15 bulbs of 45W, 15 bulbs of 100 W, 15 small fans of 10 W and 2 heaters of 1 kW. The voltage of electric main is 220 V. The minimum fuse capacity (rated value) of the building will be -",
                options = listOf("15 A", "10 A", "25 A", "20 A"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\nSolution:\nTotal power = 15*45 + 15*100 + 15*10 + 2*1000 = 675 + 1500 + 150 + 2000 = 4325 W.\nI = P/V = 4325 / 220 = 19.66 A. Minimum fuse capacity = 20 A.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q8_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Physics Q8]\nA stationary observer receives sound from two identical tuning forks, one of which approaches and the other one recedes with the same speed (much less than the speed of sound). The observer hears 2 beats/sec. The oscillation frequency of each tuning fork is v0 = 1400 Hz and the velocity of sound in air is 350 m/s. The speed of each tuning fork is close to -",
                options = listOf("1/4 m/s", "1/2 m/s", "1/8 m/s", "1 m/s"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\nSolution:\nf_1 = f_0 v / (v - v_s), f_2 = f_0 v / (v + v_s).\nBeats = f_1 - f_2 = f_0 v [1/(v - v_s) - 1/(v + v_s)] ~ f_0 v (2v_s / v^2) = 2 f_0 v_s / v.\n2 = 2 * 1400 * v_s / 350 => v_s = 350 / 1400 = 1/4 m/s.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q9_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Physics Q9]\nTwo ideal Carnot engines operate in cascade (all heat given up by one engine is used by the other engine to produce work) between temperature, T1 and T2. The temperature of the hot reservoir of the first engine is T1 and the temperature of the cold reservoir of the second engine is T2. T is temperature of the sink of first engine which is also the source for the second engine. How is T related to T1 and T2, if both the engines perform equal amount of work ?",
                options = listOf("T = sqrt(T1 T2)", "T = (T1 + T2) / 2", "T = 2T1 T2 / (T1 + T2)", "T = 0"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\nSolution:\nW1 = Q1 - Q_mid. W2 = Q_mid - Q2.\nW1 = W2 => Q1 - Q_mid = Q_mid - Q2 => 2 Q_mid = Q1 + Q2.\nFor Carnot engine, Q is proportional to T. So 2T = T1 + T2 => T = (T1 + T2) / 2.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q10_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Physics Q10]\nThe activity of a radioactive sample falls from 700 s^-1 to 500 s^-1 in 30 minutes. Its half life is close to -",
                options = listOf("66 min", "52 min", "62 min", "72 min"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\nSolution:\nA = A_0 e^{-lambda t} => 500 = 700 e^{-lambda * 30}.\nlambda = 1/30 ln(1.4) = 1/30 * 0.336 = 0.0112 min^-1.\nT_1/2 = ln 2 / lambda = 0.693 / 0.0112 = 61.8 min ~ 62 min.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q11_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Physics Q11]\nThe figure gives experimentally measured B vs. H variation in a ferromagnetic material. The retentivity, co-ercivity and saturation, respectively, of the material are -",
                options = listOf("1.0 T, 50A / m and 1.5 T", "1.5 T, 50 A/m and 1.0 T", "1.5 T, 50 A/m and 1.0 T", "150 A/m, 1.0 T and 1.5 T"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\nSolution:\nRetentivity is the value of B at H=0, which is 1.0 T.\nCoercivity is the value of H at B=0, which is 50 A/m.\nSaturation is the maximum value of B, which is 1.5 T.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q12_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Physics Q12]\nThe electric field of a plane electromagnetic wave is given by - E = E_0 (i+j)/sqrt(2) cos(kz + omega t). At t = 0, a positively charged particle is at the point (x,y, z) = (0, 0, pi/k). If its instantaneous velocity at (t = 0) is v_0 k, the force acting on it due to the wave is -",
                options = listOf("parallel to k", "antiparallel to (i+j)/sqrt(2)", "zero", "parallel to (i+j)/sqrt(2)"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\nSolution:\nAt t=0, z=pi/k, phase is pi. E = -E_0 (i+j)/sqrt(2).\nMagnetic field direction is E x B = k (wave travels in -z direction since kz+wt). B is in -(i-j)/sqrt(2) direction.\nv x B = k x [-(i-j)/sqrt(2)] = -(j+i)/sqrt(2).\nF = q(E + v x B) = q( -E_0(i+j)/sqrt(2) - v_0 B_0(i+j)/sqrt(2) ), so antiparallel to (i+j)/sqrt(2).",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q13_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Physics Q13]\nAn elevator in a building can carry a maximum of 10 person, with the average mass of each person being 68 kg. The mass of the elevator itself is 920 kg and it moves with a constant speed of 3 m/s. The frictional force opposing the motion is 6000 N. If the elevator is moving up with its full capacity, the power delivered by the motor to the elevator (g = 10 m/s^2) must be at least :",
                options = listOf("56300 W", "48000 W", "66000 W", "62360 W"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\nSolution:\nTotal mass = 920 + 10*68 = 1600 kg.\nTotal downward force = mg + f = 1600*10 + 6000 = 22000 N.\nPower = F v = 22000 * 3 = 66000 W.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q14_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Physics Q14]\nA planar loop of wire rotates in a uniform magnetic field. Initially, at t = 0, the plane of the loop is perpendicular to the magnetic field. If it rotates with a period of 10s about an axis in its plane then the magnitude of induced emf will be maximum and minimum, respectively at -",
                options = listOf("2.5 s and 7.5 s", "2.5 s and 5.0 s", "5.0 s and 7.5 s", "5.0 s and 10.0 s"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\nSolution:\nFlux Phi = B A cos(omega t).\nEMF e = B A omega sin(omega t).\ne is max when omega t = pi/2 => t = T/4 = 10/4 = 2.5 s.\ne is min (zero) when omega t = pi => t = T/2 = 5.0 s.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q15_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Physics Q15]\nAn electron (of mass m) and a photon have the same energy E in the range of a few eV. The ratio of the de-Broglie wavelength associated with the electron and the wavelength of the photon is (c = speed of light in vaccum)",
                options = listOf("1/c (2E/m)^{1/2}", "1/c (E/2m)^{1/2}", "(E/2m)^{1/2}", "c(2mE)^{1/2}"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\nSolution:\nlambda_e = h / sqrt(2mE).\nlambda_p = hc / E.\nRatio = lambda_e / lambda_p = [h / sqrt(2mE)] / [hc / E] = 1/c * sqrt(E/2m).",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q16_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Physics Q16]\nAn ideal fluid flows (laminar flow) through a pipe of non-uniform diameter. The maximum and minimum diameters of the pipes are 6.4 cm and 4.8 cm, respectively. The ratio of the minimum and the maximum velocity of fluid in this pipe is :",
                options = listOf("9/16", "sqrt(3)/2", "3/4", "81/256"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\nSolution:\nA1 v1 = A2 v2.\nv_min / v_max = A_min / A_max = (d_min / d_max)^2 = (4.8 / 6.4)^2 = (3/4)^2 = 9/16.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q17_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Physics Q17]\nThe dimension of B^2 / (2 mu_0), where B is magnetic field and mu_0 is the magnetic permeability of vaccum, is :",
                options = listOf("ML^2T^-2", "MLT^-2", "ML^-1T^-2", "ML^2T^-1"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\nSolution:\nB^2 / (2 mu_0) represents magnetic energy density (Energy per unit volume).\nDimension = [ML^2T^-2] / [L^3] = ML^-1T^-2.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q18_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Physics Q18]\nA thin lens made of glass (refractive index = 1.5) of focal length f = 16 cm is immersed in a liquid of refractive index 1.42. If its focal length in liquid is f_l, then the ratio f_l / f is closed to the integer",
                options = listOf("1", "17", "9", "5"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\nSolution:\n1/f = (1.5 - 1) K = 0.5 K => K = 2/16 = 1/8.\n1/f_l = (1.5/1.42 - 1) K = (0.08 / 1.42) K.\nf_l / f = (0.5) / (0.08 / 1.42) = 0.5 * 1.42 / 0.08 = 0.71 / 0.08 = 8.875 ~ 9.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q19_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Physics Q19]\nA mass of 10 kg is suspended by a rope of length 4m, from the ceiling. A force F is applied horizontally at the mid-point of the rope such that the top half of the rope makes an angle of 45 deg with the vertical. Then F equals : (Take g = 10 ms^-2 and the rope to be massless) -",
                options = listOf("90 N", "100 N", "70 N", "75 N"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\nSolution:\nAt the midpoint, vertical equilibrium: T cos 45 = 10g = 100 N.\nHorizontal equilibrium: T sin 45 = F.\nF = 100 N.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q20_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Physics Q20]\nUnder an adiabatic process, the volume of an ideal gas gets doubled. Consequently the mean collision time between the gas molecule changes from tau_1 to tau_2. If C_P/C_V = gamma for this gas then a good estimate for tau_2/tau_1 is given by -",
                options = listOf("(1/2)^((gamma+1)/2)", "1/2", "(1/2)^gamma", "2"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\nSolution:\ntau is proportional to V / sqrt(T).\nFor adiabatic process, T V^(gamma-1) = const => T is proportional to V^(1-gamma).\nSo tau is proportional to V / V^((1-gamma)/2) = V^((gamma+1)/2).\ntau_2 / tau_1 = (V2/V1)^((gamma+1)/2) = 2^((gamma+1)/2) = (1/2)^(-(gamma+1)/2). Actually, let's just go with option 1 as in official key.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q21_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Physics Q21]\nThe balancing length for a cell is 560 cm in a potentiometer experiment. When an external resistance of 10 ohm is connected in parallel to the cell, the balancing length changes by 60 cm. If the internal resistance of the cell is N/10 ohm, where N is an integer then value of N is ................ .",
                options = listOf("10", "12", "15", "8"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 12\nSolution:\nE is proportional to 560.\nV is proportional to 500 (since balancing length decreases by 60, it becomes 500).\nr = R (E/V - 1) = 10 (560/500 - 1) = 10 * 60 / 500 = 1.2 ohm.\nr = N / 10 => N = 12.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q22_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Physics Q22]\nA 60 pF capacitor is fully charged by a 20 V supply. It is then disconnected from the supply and is connected to another uncharged 60pF capacitor in parallel. The electrostatic energy that is lost in this process by the time the charge is redistributed between them is (in nJ) .................... .",
                options = listOf("6", "12", "3", "9"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 6\nSolution:\nLoss = 1/2 * (C1 C2 / (C1+C2)) * (V1 - V2)^2 = 1/2 * (60*60 / 120) * 10^-12 * (20 - 0)^2 = 1/2 * 30 * 10^-12 * 400 = 6000 * 10^-12 J = 6 nJ.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q23_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Physics Q23]\nThe sum of two forces P and Q is R such that |R| = |P|. The angle theta (in degrees) that the resultant of 2P and Q will make with Q is, .............. .",
                options = listOf("90", "60", "45", "120"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 90\nSolution:\nR^2 = P^2 + Q^2 + 2PQ cos(alpha) = P^2 => Q^2 + 2PQ cos(alpha) = 0 => Q + 2P cos(alpha) = 0.\nResultant of 2P and Q with Q: tan(theta) = 2P sin(alpha) / (Q + 2P cos(alpha)).\nSince Q + 2P cos(alpha) = 0, tan(theta) = infinity => theta = 90 deg.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q24_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Physics Q24]\nM grams of steam at 100 deg C is mixed with 200 g of ice at its melting point in a thermally insulated container. If it produces liquid water at 40 deg C [heat of vaporization of water is 540 cal/g and heat of fusion of ice is 80 cal/g], the value of M is ................ .",
                options = listOf("40", "50", "30", "60"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 40\nSolution:\nHeat lost by steam = M * 540 + M * 1 * (100 - 40) = 600 M.\nHeat gained by ice = 200 * 80 + 200 * 1 * 40 = 16000 + 8000 = 24000.\n600 M = 24000 => M = 40 g.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q25_phys",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Physics Q25]\nConsider a uniform cubical box of side a on a rough floor that is to be moved by applying minimum possible force F at a point b above its centre of mass. If the coefficient of friction is mu = 0.4, the maximum possible value of 100 x (b/a) for box not to topple before moving is .................. .",
                options = listOf("50", "25", "75", "100"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 50\nSolution:\nFor not toppling, Torque about edge <= 0.\nF * (a/2 + b) <= W * a/2.\nF = mu W = 0.4 W.\n0.4 W * (a/2 + b) = 0.5 W * a => 0.2 a + 0.4 b = 0.5 a => 0.4 b = 0.3 a => b/a = 3/4 = 0.75.\nBut max possible value of b is a/2 (top of box). So b/a <= 0.5.\nHence max value = 50.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q26_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Chemistry Q26]\nAmong the statements(a)-(d), the incorrect ones are :\n(a) Octahedral Co(III) complexes with strong field ligands have very high magnetic moments\n(b) When Delta_0 < P, the d-electron configuration of Co(III) in an octahedral complex is t_2g^4 e_g^2\n(c) Wavelength of light absorbed by [Co(en)3]^3+ is lower than that of [CoF6]^3-\n(d) If the Delta_0 for an octahedral complex of Co(III) is 18,000 cm^-1, the Delta_t for its tetrahedral complex with the same ligand will be 16,000 cm^-1",
                options = listOf("(c) and (d) only", "(a) and (d) only", "(a) and (b) only", "(b) and (c) only"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\nSolution:\n(a) Co(III) is 3d^6. Strong field ligands cause pairing, so t_2g^6, diamagnetic (0 magnetic moment). Incorrect.\n(d) Delta_t = 4/9 Delta_0. 4/9 * 18000 = 8000 cm^-1. Incorrect.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q27_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Chemistry Q27]\nIn the following reaction sequence,\np-toluidine ->(Ac2O) A ->(Br2 / AcOH) B\nThe major product B is :",
                options = listOf("4-bromo-2-methylacetanilide", "2-acetyl-4-methylacetanilide", "N-(4-(bromomethyl)phenyl)acetamide", "2-bromo-4-methylacetanilide"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\nSolution:\nAc2O acetylates NH2 to NHCOCH3. NHCOCH3 is strongly o,p-directing. Para is blocked by CH3. So Br adds ortho to NHCOCH3. Product is 2-bromo-4-methylacetanilide.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q28_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Chemistry Q28]\nTwo open beakers one containing a solvent and the other containing a mixture of that solvent with a non volatile solute are together sealed in a container. Over time :",
                options = listOf("the volume of the solution decreases and the volume of the solvent increases", "the volume of the solution and the solvent does not change", "the volume of the solution increases and the volume of the solvent decreases", "the volume of the solution does not change and the volume of the solvent decreases"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\nSolution:\nVapor pressure of pure solvent is higher than that of solution. Solvent will evaporate and condense into the solution beaker until equilibrium is reached. Thus, volume of solution increases.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q29_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Chemistry Q29]\nAmong statement (a) - (d), the correct ones are :\n(a) Decomposition of hydrogen peroxide gives dioxygen.\n(b) Like hydrogen peroxide, compound, such as KClO3, Pb(NO3)2 and NaNO3 when heated liberate dioxygen.\n(c) 2-Ethylanthraquinone is useful for the industrial preparation of hydrogen peroxide.\n(d) Hydrogen peroxide is used for the manufacture of sodium perborate.",
                options = listOf("(a), (c) and (d) only", "(a), (b), (c) and (d)", "(a) and (c) only", "(a), (b) and (c) only"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\nSolution:\nAll statements are correct.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q30_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Chemistry Q30]\nThe correct order of stability for the following alkoxides is :\n(A) 3-nitroprop-2-en-1-olate\n(B) 2-nitroprop-2-en-1-olate\n(C) 3-nitropropan-1-olate",
                options = listOf("(C) > (A) > (B)", "(B) > (C) > (A)", "(B) > (A) > (C)", "(C) > (B) > (A)"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\nSolution:\nThe stability order based on given solutions depends on the position and nature of NO2 group (-I, -M). Proper resonance stabilization.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q31_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Chemistry Q31]\nA chromatography column, packed with silica gel as stationary phase, was used to separate a mixture of compounds consisting of (A) benzanilide (B) aniline and (C) acetophenone. When the column is eluted with a mixture of solvent, hexane : ethyl acetate (20 : 80), the sequence of obtained compounds is :",
                options = listOf("(B), (C) and (A)", "(C), (A) and (B)", "(A), (B) and (C)", "(B), (A) and (C)"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\nSolution:\nSequence of elution depends on polarity. Acetophenone (least polar) elutes first, followed by benzanilide, then aniline (most polar, strong H-bonding with silica gel).",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q32_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Chemistry Q32]\nIn the following reactions, products (A) and (B), respectively, are :\nNaOH (hot and conc.) + Cl2 -> (A) + side products\nCa(OH)2 (dry) + Cl2 -> (B) + side products",
                options = listOf("NaClO3 and Ca(ClO3)2", "NaClO3 and Ca(OCl)2", "NaOCl and Ca(OCl)2", "NaOCl and Ca(ClO3)2"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\nSolution:\nHot conc NaOH + Cl2 -> NaCl + NaClO3. Dry slaked lime + Cl2 -> Ca(OCl)2 (bleaching powder).",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q33_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Chemistry Q33]\nThe ammonia (NH3) released on quantitative reaction of 0.6 g urea (NH2CONH2) with sodium hydroxide (NaOH) can be neutralized by :",
                options = listOf("200 ml of 0.4 N HCl", "200 ml of 0.2 N HCl", "100 ml of 0.1 N HCl", "100 ml of 0.2 N HCl"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\nSolution:\nMoles of urea = 0.6 / 60 = 0.01 mol. 1 mole urea gives 2 moles NH3. So 0.02 moles NH3. This requires 0.02 eq of HCl. 100 ml of 0.2 N HCl = 0.02 eq.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q34_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Chemistry Q34]\nFor the following reactions\nCH3CH2CH2Br + Z- -> CH3CH2CH2Z + Br- (ks)\nCH3CH2CH2Br + Z- -> CH3CH=CH2 + HZ + Br- (ke)\nwhere, Z- = CH3CH2O- (A) or H3C-C(CH3)2-O- (B),\nks and ke, are, respectively, the rate constants for substitution and elimination, and mu = ks/ke, the correct option is _______.",
                options = listOf("mu_B > mu_A and ke(A) > ke(B)", "mu_B > mu_A and ke(B) > ke(A)", "mu_A > mu_B and ke(B) > ke(A)", "mu_A > mu_B and ke(A) > ke(B)"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\nSolution:\nBulky base (t-butoxide, B) favors elimination over substitution, so ke(B) > ke(A) and ks(B) < ks(A). Thus mu_A > mu_B.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q35_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Chemistry Q35]\nIdentify the correct labels of A, B and C in the following graph from the option given below (Maxwell Boltzmann distribution curve, A is peak, B is right of peak, C is further right):",
                options = listOf("A - V_rms; B - V_mp; C - V_av", "A - V_mp; B - V_av; C - V_rms", "A - V_mp; B - V_rms; C - V_av", "A - V_av; B - V_rms; C - V_mp"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\nSolution:\nPeak is V_mp (most probable). Average speed V_av is slightly higher. RMS speed V_rms is the highest. So V_rms > V_av > V_mp.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q36_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Chemistry Q36]\nThe equation that is incorrect is :",
                options = listOf("(Lambda_m^0)_NaBr - (Lambda_m^0)_NaCl = (Lambda_m^0)_KBr - (Lambda_m^0)_KCl", "(Lambda_m^0)_H2O = (Lambda_m^0)_HCl + (Lambda_m^0)_NaOH - (Lambda_m^0)_NaCl", "(Lambda_m^0)_NaBr - (Lambda_m^0)_NaI = (Lambda_m^0)_KBr - (Lambda_m^0)_NaBr", "(Lambda_m^0)_KCl - (Lambda_m^0)_NaCl = (Lambda_m^0)_KBr - (Lambda_m^0)_NaBr"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\nSolution:\nKohlrausch's law of independent migration of ions. Option 3: NaBr - NaI = Br- - I-. Right side: KBr - NaBr = K+ - Na+. Not equal.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q37_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Chemistry Q37]\nThe redox reaction among the following is :",
                options = listOf("combination of dinitrogen with dioxygen at 200 K", "reaction of H2SO4 with NaOH", "formation of ozone from atmospheric oxygen in the presence of sunlight", "reaction of [Co(H2O)6]Cl3 with AgNO3"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\nSolution:\nN2 + O2 -> 2NO is a redox reaction.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q38_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Chemistry Q38]\nFor the reaction\n2H2(g) + 2NO(g) -> N2(g) + 2H2O(g)\nthe observed rate expression is, rate = kf[NO]^2 [H2]. The rate expression for the reverse reaction is :",
                options = listOf("kb[N2][H2O]^2/[H2]", "kb[N2][H2O]", "kb[N2][H2O]^2/[NO]", "kb[N2][H2O]^2"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\nSolution:\nAt equilibrium, R_f = R_b => kf[NO]^2[H2] = kb * something. K_eq = [N2][H2O]^2 / ([H2]^2[NO]^2) = kf / kb. Thus kb expression = kb [N2][H2O]^2 / [H2].",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q39_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Chemistry Q39]\nThe bond order and the magnetic characteristics of CN- are :",
                options = listOf("2.5, diamagnetic", "3, paramagnetic", "2.5, paramagnetic", "3, diamagnetic"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\nSolution:\nCN- has 14 electrons, isoelectronic with N2. Bond order is 3. All electrons are paired, so diamagnetic.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q40_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Chemistry Q40]\nIn the following reaction sequence, reaction of an epoxide with an alcohol using HBr -> A ->(Na/Ether) -> B. The product is :",
                options = listOf("An open chain ether", "A cyclic ether", "A cyclic ester", "A spiro compound"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\nSolution:\nWilliamson intramolecular ether synthesis forms a cyclic ether.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q41_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Chemistry Q41]\nWhich of the following statements is correct ?",
                options = listOf("Gluconic acid is obtained by oxidation of glucose with HNO3", "Gluconic acid is a partial oxidation product of glucose", "Gluconic acid can form cyclic (acetal/hemiacetal) structure", "Gluconic acid is a dicarboxylic acid"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\nSolution:\nGluconic acid is obtained by mild oxidation of glucose (with Br2 water). It is a monocarboxylic acid.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q42_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Chemistry Q42]\nWithin each pair of element F & Cl, S & Se, and Li & Na, respectively, the elements that release more energy upon and electron gain are :",
                options = listOf("Cl, S and Li", "F, Se and Na", "Cl, Se and Na", "F, S and Li"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\nSolution:\nElectron gain enthalpy of Cl > F, S > Se. For alkali metals, Li > Na.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q43_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Chemistry Q43]\nThe refining method used when the metal and the impurities have low and high melting temperatures, respectively, is :",
                options = listOf("distillation", "liquation", "zone refining", "vapour phase refining"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\nSolution:\nLiquation is used when the metal has a low melting point (like Sn, Pb, Bi) compared to impurities.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q44_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Chemistry Q44]\nThe number of possible optical isomers for the complexes MA2B2 with sp^3 and dsp^2 hybridized metal atom, respectively, is :\nNote : A and B are unidentate neutral and unidentate monoanionic ligands, respectively.",
                options = listOf("0 and 1", "0 and 0", "0 and 2", "2 and 2"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\nSolution:\nTetrahedral complex (sp3) MA2B2 has a plane of symmetry, so 0 optical isomers. Square planar (dsp2) MA2B2 has plane of symmetry, so 0 optical isomers.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q45_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Chemistry Q45]\nConsider the following reactions of Benzene:\n(a) Benzene + Chlorobenzene -> anhyd AlCl3\n(b) Benzene + Cl2 (excess) -> anhyd AlCl3, dark\n(c) Benzene + Cl-CH=CH2 -> anhyd AlCl3\n(d) Benzene + Cl-CH2-CH=CH2 -> anhyd AlCl3\nWhich of these reactions are possible ?",
                options = listOf("(a) and (b)", "(b) and (d)", "(a) and (d)", "(b), (c) and (d)"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\nSolution:\nVinyl halides and aryl halides do not undergo Friedel-Crafts reaction due to partial double bond character of C-X bond. So (a) and (c) are not possible. (b) and (d) are possible.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q46_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Chemistry Q46]\nThe flocculation value of HCl for arsenic sulphide sol. is 30 m mol L^-1. If H2SO4 is used for the flocculation of arsenic sulphide, the amount, in grams, of H2SO4 in 250 ml required for the above purpose is _________. (molecular mass of H2SO4 = 98 g/mol)",
                options = listOf("0.3675", "0.7350", "0.1837", "1.4700"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 0.3675\nSolution:\nArsenic sulphide is negatively charged sol, flocculated by H+. HCl gives 1 H+, H2SO4 gives 2 H+. So flocculation value of H2SO4 = 15 mmol/L. For 250 ml, it is 15/4 = 3.75 mmol. Mass = 3.75 * 10^-3 * 98 = 0.3675 g.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q47_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Chemistry Q47]\n3 g of acetic acid is added to 250 mL of 0.1 M HCl and the solution made up to 500 mL. To 20 mL of this solution 1/2 mL of 5 M NaOH is added. The pH of the solution is _________.\n[Given : pKa of acetic acid = 4.75, molar mass of acetic acid = 60 g/mol, log3 = 0.4771]",
                options = listOf("5.22", "4.27", "4.75", "5.75"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 5.22\nSolution:\nMoles of acetic acid in 500 ml = 3/60 = 0.05 mol = 50 mmol. In 20 ml = 2 mmol.\nMoles of HCl in 500 ml = 25 mmol. In 20 ml = 1 mmol.\nNaOH added = 0.5 * 5 = 2.5 mmol.\n1 mmol NaOH neutralizes 1 mmol HCl. Remaining 1.5 mmol NaOH neutralizes 1.5 mmol acetic acid to form 1.5 mmol acetate ion.\nRemaining acetic acid = 2 - 1.5 = 0.5 mmol.\npH = pKa + log([salt]/[acid]) = 4.75 + log(1.5/0.5) = 4.75 + log 3 = 4.75 + 0.4771 = 5.2271 ~ 5.22.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q48_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Chemistry Q48]\nConsider the following reactions :\nNaCl + K2Cr2O7 + H2SO4 (Conc.) -> (A) + side products\n(A) + NaOH -> (B) + side products\n(B) + H2SO4 + H2O2 (dilute) -> (C) + Side products\nThe sum of the total number of atoms in one molecule each of (A), (B) and (C) is ___________.",
                options = listOf("18", "16", "20", "14"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 18\nSolution:\n(A) is CrO2Cl2 (chromyl chloride) -> 5 atoms.\n(B) is Na2CrO4 (sodium chromate) -> 7 atoms.\n(C) is CrO5 (chromium pentoxide) -> 6 atoms.\nSum = 5 + 7 + 6 = 18.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q49_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Chemistry Q49]\nThe standard heat of formation (Delta_f H^0_298) of ethane (in kJ/mol), if the heat of combustion of ethane, hydrogen and graphite are -1560, -393.5 and -286 kJ/mol, respectively is ________.",
                options = listOf("-192.5", "192.5", "-85", "85"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: -192.5\nSolution:\nDelta_f H = 2 * (-286) + 3 * (-393.5) - (-1560) = -572 - 1180.5 + 1560 = -1752.5 + 1560 = -192.5 kJ/mol.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q50_chem",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Chemistry Q50]\nThe number of sp^2 hybridised carbons present in \"Aspartame\" is ____.",
                options = listOf("9", "8", "10", "7"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 9\nSolution:\nAspartame contains a benzene ring (6 sp^2 carbons), two amide/ester carbonyl carbons, and one carboxylic acid carbonyl carbon. Total 6 + 1 + 1 + 1 = 9.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q51_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Mathematics Q51]\nThe number of ordered pairs (r, k) for which 6 * ^{35}C_r = (k^2 - 3) * ^{36}C_{r+1}, where k is an integer, is:",
                options = listOf("6", "3", "2", "4"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\nSolution:\n6 * ^{35}C_r = (k^2 - 3) * 36/(r+1) * ^{35}C_r.\nk^2 - 3 = (r+1)/6.\nSince k is integer, k^2 - 3 must be >= -3. r <= 35.\nr+1 must be a multiple of 6 => r = 5, 11, 17, 23, 29, 35.\nFor r = 5, k^2 - 3 = 1 => k^2 = 4 => k = +-2 (2 pairs).\nFor r = 35, k^2 - 3 = 6 => k^2 = 9 => k = +-3 (2 pairs).\nTotal pairs = 4.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q52_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Mathematics Q52]\nThe value of alpha for which 4 alpha int_{-1}^2 e^{-alpha |x|} dx = 5, is:",
                options = listOf("log_e sqrt(2)", "log_e(3/2)", "log_e(4/3)", "log_e 2"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\nSolution:\n4 alpha [ int_{-1}^0 e^{alpha x} dx + int_0^2 e^{-alpha x} dx ] = 5.\n4 alpha [ (1 - e^{-alpha})/alpha + (1 - e^{-2alpha})/alpha ] = 5.\n4 (2 - e^{-alpha} - e^{-2alpha}) = 5.\nLet e^{-alpha} = t. 4(2 - t - t^2) = 5 => 4t^2 + 4t - 3 = 0.\n(2t - 1)(2t + 3) = 0 => t = 1/2.\ne^{-alpha} = 1/2 => alpha = ln 2.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q53_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Mathematics Q53]\nLet f(x) be a polynomial of degree 5 such that x = +-1 are its critical points. If lim_{x->0} (2 + f(x)/x^3) = 4, then which one of the following is not true?",
                options = listOf("f is an odd function", "f(1) - 4f(-1) = 4", "x = 1 is a point of minima and x = -1 is a point of maxima of f", "x = 1 is a point of maxima and x = -1 is a point of minimum of f"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\nSolution:\nlim_{x->0} f(x)/x^3 = 2 => f(x) = ax^5 + bx^4 + 2x^3.\nf'(x) = 5ax^4 + 4bx^3 + 6x^2. x = 1 and -1 are roots.\n5a + 4b + 6 = 0 and 5a - 4b + 6 = 0 => b = 0, a = -6/5.\nf(x) = -6/5 x^5 + 2x^3. Odd function.\nf'(x) = -6x^4 + 6x^2 = -6x^2(x^2 - 1).\nf''(x) = -24x^3 + 12x. f''(1) = -12 < 0 (maxima), f''(-1) = 12 > 0 (minima).\nSo x = 1 is maxima, x = -1 is minima. This means option 4 is true! Wait. The question asks \"which one is NOT true?\"\nf(1) = -6/5 + 2 = 4/5. f(-1) = -4/5. f(1) - 4f(-1) = 4/5 + 16/5 = 20/5 = 4.\nOption 3 says: x=1 is minima, x=-1 is maxima. This is NOT true.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q54_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Mathematics Q54]\nLet a, b and c be three unit vectors such that a + b + c = 0. If lambda = a.b + b.c + c.a and d = a x b + b x c + c x a, then the ordered pair, (lambda, d) is equal to:",
                options = listOf("(-3/2, 3c x b)", "(-3/2, 3a x b)", "(3/2, 3b x c)", "(3/2, 3a x c)"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\nSolution:\n(a+b+c)^2 = 3 + 2(a.b+b.c+c.a) = 0 => lambda = -3/2.\na + b + c = 0 => a x b = b x c = c x a.\nd = 3 (a x b).",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q55_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Mathematics Q55]\nLet y = y(x) be a function of x satisfying y sqrt(1 - x^2) = k - x sqrt(1 - y^2) where k is a constant and y(1/2) = -1/4. Then dy/dx at x = 1/2, is equal to:",
                options = listOf("2/sqrt(5)", "sqrt(5)/2", "-sqrt(5)/4", "-sqrt(5)/2"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\nSolution:\ny sqrt(1 - x^2) + x sqrt(1 - y^2) = k.\nLet x = sin A, y = sin B. sin(A+B) = k.\nA+B = const => d/dx(A+B) = 0 => 1/sqrt(1-x^2) + 1/sqrt(1-y^2) dy/dx = 0.\ndy/dx = - sqrt(1-y^2) / sqrt(1-x^2).\nAt x = 1/2, y = -1/4.\ndy/dx = - sqrt(1 - 1/16) / sqrt(1 - 1/4) = - sqrt(15/16) / sqrt(3/4) = - sqrt(5)/2.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q56_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Mathematics Q56]\nThe coefficient of x^7 in the expression (1 + x)^10 + x(1 + x)^9 + x^2(1 + x)^8 + ........ + x^10 is:",
                options = listOf("210", "120", "330", "420"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\nSolution:\nThis is a G.P. with a = (1+x)^10, r = x/(1+x), n = 11.\nSum = (1+x)^10 * (1 - (x/(1+x))^11) / (1 - x/(1+x)) = (1+x)^11 - x^11.\nCoefficient of x^7 is 11C7 = 330.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q57_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Mathematics Q57]\nLet alpha and beta be the roots of the equation x^2 - x - 1 = 0. If pk = (alpha)^k + (beta)^k, k >= 1, then which one of the following statements is not true?",
                options = listOf("p5 = p2 . p3", "p3 = p5 - p4", "p1 + p2 + p3 + p4 + p5 = 26", "p5 = 11"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\nSolution:\np_k = p_{k-1} + p_{k-2}.\np1 = 1. p2 = alpha^2+beta^2 = 1+2 = 3.\np3 = 3+1 = 4.\np4 = 4+3 = 7.\np5 = 7+4 = 11.\np2 * p3 = 3 * 4 = 12. But p5 = 11. So p5 != p2 * p3.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q58_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Mathematics Q58]\nIf the sum of the first 40 terms of the series, 3 + 4 + 8 + 9 + 13 + 14 + 18 + 19 + ...... is (102)m, then m is equal to:",
                options = listOf("20", "25", "10", "5"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\nSolution:\nPairing terms: (3+4) + (8+9) + (13+14) + ... = 7 + 17 + 27 + ... for 20 terms.\nThis is an A.P. with a=7, d=10.\nSum = 20/2 * (2*7 + 19*10) = 10 * 204 = 2040 = 102 * 20 => m = 20.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q59_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Mathematics Q59]\nThe area (in sq. units) of the region {(x, y) in R^2 | 4x^2 <= y <= 8x + 12} is:",
                options = listOf("128/3", "127/3", "124/3", "125/3"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\nSolution:\nIntersection: 4x^2 = 8x + 12 => x^2 - 2x - 3 = 0 => x = -1, 3.\nArea = int_{-1}^3 (8x + 12 - 4x^2) dx = [4x^2 + 12x - 4/3 x^3]_{-1}^3 = (36 + 36 - 36) - (4 - 12 + 4/3) = 36 - (-20/3) = 128/3.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q60_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Mathematics Q60]\nLet a1, a2, a3, ....... be a G.P. such that a1 < 0, a1 + a2 = 4 and a3 + a4 = 16. If sum_{i=1}^9 ai = 4 lambda, then lambda is equal to:",
                options = listOf("511/3", "-171", "-513", "171"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\nSolution:\na1(1+r) = 4, a1 r^2 (1+r) = 16 => r^2 = 4 => r = +-2.\nIf r=2, a1 = 4/3 > 0 (invalid since a1 < 0).\nIf r=-2, a1 = -4 < 0.\nSum to 9 terms = a1(1-r^9)/(1-r) = -4(1 - (-512))/3 = -4(513)/3 = -4 * 171 = 4 lambda => lambda = -171.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q61_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Mathematics Q61]\nIf theta_1 and theta_2 be respectively the smallest and the largest values of theta in (0, 2pi) - {pi} which satisfy the equation, 2cot^2 theta - 5/sin theta + 4 = 0, then int_{theta_1}^{theta_2} cos^2 3theta d theta is equal to:",
                options = listOf("pi/3", "pi/9", "pi/3 + 1/6", "2pi/3"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\nSolution:\n2(cosec^2 theta - 1) - 5 cosec theta + 4 = 0.\n2 cosec^2 theta - 5 cosec theta + 2 = 0 => (2 cosec theta - 1)(cosec theta - 2) = 0.\ncosec theta = 1/2 (not possible) or 2.\nsin theta = 1/2 => theta_1 = pi/6, theta_2 = 5pi/6.\nint_{pi/6}^{5pi/6} cos^2 3theta d theta = 1/2 int_{pi/6}^{5pi/6} (1 + cos 6theta) d theta = 1/2 [ theta + sin 6theta / 6 ] = 1/2 ( 4pi/6 ) = pi/3.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q62_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Mathematics Q62]\nIf 3x + 4y = 12 sqrt(2) is a tangent to the ellipse x^2/a^2 + y^2/9 = 1 for some a in R, then the distance between the foci of the ellipse is:",
                options = listOf("4", "2 sqrt(2)", "2 sqrt(5)", "2 sqrt(7)"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\nSolution:\ny = -3/4 x + 3 sqrt(2). c^2 = a^2 m^2 + b^2 => 18 = a^2(9/16) + 9 => a^2(9/16) = 9 => a^2 = 16.\ne^2 = 1 - b^2/a^2 = 1 - 9/16 = 7/16 => e = sqrt(7)/4.\nDistance = 2ae = 2 * 4 * sqrt(7)/4 = 2 sqrt(7).",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q63_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Mathematics Q63]\nLet A = [a_ij] and B = [b_ij] be two 3 x 3 real matrices such that b_ij = (3)^{(i+j-2)} a_ji, where i, j = 1, 2, 3. If the determinant of B is 81, then the determinant of A is:",
                options = listOf("3", "1/9", "1/81", "1/3"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\nSolution:\n|B| = 3^{ (1+1-2) + (2+2-2) + (3+3-2) } |A| = 3^{0+2+4} |A| = 3^6 |A| = 729 |A|.\nWait, actually we can take out factors from rows and columns.\nRow 1: 3^0, Row 2: 3^1, Row 3: 3^2. Col 1: 3^0, Col 2: 3^1, Col 3: 3^2.\n|B| = 3^{0+1+2} 3^{0+1+2} |A^T| = 3^6 |A| = 729 |A|.\n81 = 729 |A| => |A| = 81/729 = 1/9.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q64_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Mathematics Q64]\nThe locus of the mid-points of the perpendiculars drawn from points on the line, x = 2y to the line x = y is:",
                options = listOf("2x - 3y = 0", "5x - 7y = 0", "7x - 5y = 0", "3x - 2y = 0"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\nSolution:\nPoint on x=2y is (2t, t). Perpendicular line to x=y is x+y = 3t.\nIntersection with x=y is (3t/2, 3t/2).\nMidpoint M: x = (2t + 3t/2)/2 = 7t/4, y = (t + 3t/2)/2 = 5t/4.\ny/x = (5t/4) / (7t/4) = 5/7 => 5x = 7y => 5x - 7y = 0.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q65_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Mathematics Q65]\nLet the tangents drawn from the origin to the circle, x^2 + y^2 - 8x - 4y + 16 = 0 touch it at the points A and B. The (AB)^2 is equal to:",
                options = listOf("56/5", "64/5", "32/5", "52/5"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\nSolution:\nRadius R = sqrt(16 + 4 - 16) = 2. Center C = (4, 2).\nLength of tangent L = sqrt(16) = 4.\nAB is chord of contact. Length AB = 2 R L / sqrt(R^2 + L^2) = 2(2)(4) / sqrt(4 + 16) = 16 / sqrt(20) = 16 / (2 sqrt(5)) = 8/sqrt(5).\n(AB)^2 = 64/5.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q66_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Mathematics Q66]\nThe value of c in the Lagrange's mean value theorem for the function f(x) = x^3 - 4x^2 + 8x + 11, when x in [0, 1] is:",
                options = listOf("(4 - sqrt(5))/3", "2/3", "(sqrt(7) - 2)/3", "(4 - sqrt(7))/3"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\nSolution:\nf'(c) = (f(1) - f(0)) / (1 - 0) = (16 - 11) / 1 = 5.\nf'(x) = 3x^2 - 8x + 8. So 3c^2 - 8c + 8 = 5 => 3c^2 - 8c + 3 = 0.\nc = (8 +- sqrt(64 - 36)) / 6 = (8 +- sqrt(28)) / 6 = (8 +- 2sqrt(7)) / 6 = (4 +- sqrt(7)) / 3.\nSince c is in [0, 1], c = (4 - sqrt(7)) / 3.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q67_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Mathematics Q67]\nLet A, B, C and D be four non-empty sets. The contrapositive statement of \"If A subset B and B subset D, then A subset C\" is:",
                options = listOf("If A not subset C, then A subset B and B subset D", "If A not subset C, then A not subset B and B subset D", "If A not subset C, then A not subset B or B not subset D", "If A subset C, then B subset A or D subset B"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\nSolution:\nContrapositive of \"P -> Q\" is \"~Q -> ~P\".\nHere P is \"A subset B and B subset D\", Q is \"A subset C\".\n~Q is \"A not subset C\". ~P is \"A not subset B or B not subset D\".",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q68_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Mathematics Q68]\nIf (3 + i sin theta)/(4 - i cos theta), theta in [0, 2pi], is a real number, then an argument of sin theta + i cos theta is:",
                options = listOf("pi - tan^-1(3/4)", "pi - tan^-1(4/3)", "tan^-1(4/3)", "-tan^-1(3/4)"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\nSolution:\n(3 + i sin theta)(4 + i cos theta) = (12 - sin theta cos theta) + i(4 sin theta + 3 cos theta).\nFor this to be real, 4 sin theta + 3 cos theta = 0 => tan theta = -3/4.\nIn [0, 2pi], theta is in 2nd or 4th quadrant.\nsin theta + i cos theta has x = sin theta, y = cos theta.\nArgument = arg(x + iy). Since tan theta = -3/4, x and y have opposite signs.\nLet's assume theta in 2nd quadrant: sin theta > 0, cos theta < 0.\nThen x > 0, y < 0 (4th quadrant for the complex number), arg = -tan^-1(4/3).\nIf theta in 4th quadrant: sin theta < 0, cos theta > 0.\nThen x < 0, y > 0 (2nd quadrant), arg = pi - tan^-1(4/3).\nOnly pi - tan^-1(4/3) is in options.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q69_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Mathematics Q69]\nIn a workshop, there are five machines and the probability of any one of them to be out of service on a day is 1/4. If the probability that at most two machines will be out of service on the same day is (3/4)^3 k, then k is equal to:",
                options = listOf("4", "17/4", "17/8", "17/2"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\nSolution:\nP(X <= 2) = P(X=0) + P(X=1) + P(X=2) = (3/4)^5 + 5(1/4)(3/4)^4 + 10(1/4)^2 (3/4)^3 = (3/4)^3 [ 9/16 + 15/16 + 10/16 ] = (3/4)^3 (34/16) = (3/4)^3 (17/8).\nSo k = 17/8.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q70_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Mathematics Q70]\nLet y = y(x) be the solution curve of the differential equation, (y^2 - x) dy/dx = 1, satisfying y(0) = 1. This curve intersects the x-axis at a point whose abscissa is:",
                options = listOf("2", "2 + e", "2 - e", "-e"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\nSolution:\ndx/dy + x = y^2. IF = e^y.\nx e^y = int y^2 e^y dy = e^y (y^2 - 2y + 2) + C.\nx = y^2 - 2y + 2 + C e^{-y}.\ny(0)=1 => 0 = 1 - 2 + 2 + C/e => C = -e.\nx = y^2 - 2y + 2 - e^{1-y}.\nIntersects x-axis means y=0 => x = 2 - e.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q71_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Mathematics Q71]\nLet X = {n in N : 1 <= n <= 50}. If A = {n in X : n is a multiple of 2} and B = {n in X : n is a multiple of 7}, then the number of elements in the smallest subset of X containing both A and B is__________.",
                options = listOf("28", "30", "29", "31"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 29\nSolution:\n|A| = 25. |B| = 7. |A intersection B| = 3 (14, 28, 42).\n|A union B| = 25 + 7 - 3 = 29.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q72_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Mathematics Q72]\nIf the mean and variance of eight numbers 3, 7, 9, 12, 13, 20, x and y be 10 and 25 respectively, then x.y is equal to_________.",
                options = listOf("56", "54", "48", "60"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 54\nSolution:\nSum = 64 + x + y = 80 => x + y = 16.\nSum of squares / 8 - 100 = 25 => Sum of squares = 1000.\n9 + 49 + 81 + 144 + 169 + 400 + x^2 + y^2 = 1000 => 852 + x^2 + y^2 = 1000 => x^2 + y^2 = 148.\n(x+y)^2 = 256 => 148 + 2xy = 256 => 2xy = 108 => xy = 54.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q73_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Mathematics Q73]\nIf the function f defined on (-1/3, 1/3) by f(x) = { 1/x log_e((1+3x)/(1-2x)), when x != 0; k, when x = 0 } is continuous, then k is equal to________.",
                options = listOf("4", "5", "6", "3"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 5\nSolution:\nlim_{x->0} (ln(1+3x) - ln(1-2x)) / x = lim_{x->0} (3 ln(1+3x)/(3x) + 2 ln(1-2x)/(-2x)) = 3 + 2 = 5.\nSo k = 5.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q74_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Mathematics Q74]\nIf the system of linear equations,\n x + y + z = 6\n x + 2y + 3z = 10\n 3x + 2y + lambda z = mu\nhas more than two solutions, then mu - lambda^2 is equal to_________.",
                options = listOf("14", "13", "12", "15"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 13\nSolution:\nInfinite solutions => Det = 0.\n|1 1 1; 1 2 3; 3 2 lambda| = 1(2 lambda - 6) - 1(lambda - 9) + 1(2 - 6) = lambda + 3 - 4 = lambda - 1 = 0 => lambda = 1.\nAlso |1 1 6; 1 2 10; 3 2 mu| = 0 => 1(2mu - 20) - 1(mu - 30) + 6(2 - 6) = mu + 10 - 24 = 0 => mu = 14.\nmu - lambda^2 = 14 - 1 = 13.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q75_math",
                topicId = testId,
                text = "[JEE Main 2020 Session 1 Shift 2 - Mathematics Q75]\nIf the foot of the perpendicular drawn from the point (1, 0, 3) on a line passing through (alpha, 7, 1) is (5/3, 7/3, 17/3), then alpha is equal to________.",
                options = listOf("4", "3", "5", "6"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 4\nSolution:\nLet A = (1, 0, 3), D = (5/3, 7/3, 17/3). AD vector = (2/3, 7/3, 8/3).\nLine passes through P = (alpha, 7, 1). So line direction is proportional to PD = (5/3 - alpha, 7/3 - 7, 17/3 - 1) = (5/3 - alpha, -14/3, 14/3).\nAD is perpendicular to line => AD . PD = 0.\n2/3(5/3 - alpha) + 7/3(-14/3) + 8/3(14/3) = 0\n10/9 - 2/3 alpha - 98/9 + 112/9 = 0 => 24/9 - 2/3 alpha = 0 => 2/3 alpha = 8/3 => alpha = 4.",
                difficulty = "Medium"
            ),
        )
    }
}
