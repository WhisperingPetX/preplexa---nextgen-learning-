package com.example.data.repository
import com.example.model.Question
object JeeMain2024Session2Shift2QuestionsRepository {
    fun getQuestions(testId: String): List<Question> {
        return listOf(
            Question(
                id = "${testId}_s2_sh2_q1_phys",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Physics Q1]\\nThe translational degrees of freedom (ft) and rotational degrees of freedom (fr) of CH4 molecule are :",
                options = listOf("ft\n = 2 and fr\n = 2", "ft\n = 3 and fr\n = 3", "ft\n = 3 and fr\n = 2", "ft\n = 2 and fr\n = 3"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nSince CH4 is polyatomic Non-Linear\nD.O.F of CH4\nT. DOF = 3\nR DOF = 3",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q2_phys",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Physics Q2]\\nA cyclist starts from the point P of a circular ground of radius 2 km and travels along its circumference to the \npoint S. The displacement of a cyclist is :",
                options = listOf("6 km", "8 km", "4 km", "8 km"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n Displacement = R 2 = 2 2 = 8 km",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q3_phys",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Physics Q3]\\nThe magnetic moment of a bar magnet is 0.5 Am2\n. It is suspended in a uniform magnetic field of 8 × 10–2\n T. \nThe work done in rotating it from its most stable to most unstable position is :",
                options = listOf("16 × 10–2\n J", "8 × 10–2\n J", "4 × 10–2\n J", "Zero"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nAt stable equilibrium\nU = –mB cos 0° = –mB\nAt unstable equilibrium\nU = –mB cos 180° = + mB\nW = U\nW.D. = 2 mB\n= 2 (0.5) 8 × 10–2\n = 8 × 10–2\n J",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q4_phys",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Physics Q4]\\nWhich of the diode circuit shows correct biasing used for the measurement of dynamic resistance of p-n \njunction diode :",
                options = listOf("", "", "", ""),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nDiode should be in forward biased to calculate dynamic resistance\nHence correct answer would be 2.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q5_phys",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Physics Q5]\\nArrange the following in the ascending order of wavelength :\n(A) Gamma rays (1) \n(B) x-ray (2)\n(C) Infrared waves (3) \n(D) Microwaves (4)\nChoose the most appropriate answer from the options given below :",
                options = listOf("4 < 3 < 1 < 2", "4 < 3 < 2 < 1", "1 < 2 < 3 < 4", "2 < 1 < 4 < 3"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n1 < 2 < 3 < 4",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q6_phys",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Physics Q6]\\nIdentify the logic gate given in the circuit :",
                options = listOf("NAND - gate", "OR – gate", "AND gate", "NOR gate"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nY = A.B\nBy De-Morgan Law\nY = A  B\nY = A + B\nHence OR gate",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q7_phys",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Physics Q7]\\nThe width of one of the two slits in a Young's double slit experiment is 4 times that of the other slit. The ratio \nof the maximum of the minimum intensity in the interference pattern is :",
                options = listOf("9 :1", "16 : 1", "1 : 1", "4 : 1"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nSince, Intensity  width of slit ()\nso, I1 = I, I2 = 4I\nImin. =  \n2\n1 2\nI  I = I\nImax. =  \n2\n1 2\nI  I = 9I\nmin\nmax\nI\nI\n = \nI\n9I\n = \n1\n9",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q8_phys",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Physics Q8]\\nCorrect formula for height of a satellite from earths surface is :",
                options = listOf("1/ 2\n2 2\n4\nT R g\n\n\n\n\n\n\n\n\n\n– R", "1/ 3\n2\n2 2\n4\nT R g\n\n\n\n\n\n\n\n\n\n– R", "1/ 3\n2\n2 2\n4 g\nT R\n\n\n\n\n\n\n\n\n\n– R", "1/3\n2\n2 2\n4\nT R\n\n\n\n\n\n\n\n\n\n\n+ R"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n 2\n(R h)\nGMm\n\n = \n(R h)\nmv2\n\n\n(R h)\nGM\n\n = v\n2\n....(1)\n v = (R + h)\n v = (R + h) \nT\n2\n....(2)\n 2 R\nGM\n = g\n GM = gR2\n....(3)\nPut value from (2) and (3) in eq. (1)\n\n(R h)\ngR2\n\n = (R + h)2\n2\nT\n2\n\n\n\n\n\n \n 2\n2 2\n(2 )\nT R g\n\n = (R + h)3\n1/ 3\n2\n2 2\n(2 )\nT R g\n\n\n\n\n\n\n\n– R = h",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q9_phys",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Physics Q9]\\nMatch List I with List II\nList–I List–II\nA. Purely\ncapacitive\ncircuit\nI.\nB. Purely\ninductive\ncircuit\nII.\nC. LCR\nseries at\nresonance\nIII.\nD. LCR\nseries\ncircuit\nIV.\nChoose the correct answer from the options given below :",
                options = listOf("A-I, B-IV, C-III, D-II", "A-IV, B-I, C-III, D-II", "A-IV, B-I, C-II, D-III", "A-I, B-IV, C-II, D-III"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nA – V lags by 90° from I hence option (I) is correct.\nB – V lead by 90° from I hence option (IV) is correct\nC – In LCR resonance XL = XC. Hence circuit is purely resistive so option (II) is correct\nD – In LCR series V is at some angle from I hence (III) is correct\nHence option (4) is correct.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q10_phys",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Physics Q10]\\nGiven below are two statements :\nStatement I : The contact angle between a solid and a liquid is a property of the material of the solid and \nliquid as well.\nStatement II : The rise of a liquid in a capillary tube does not depend on the inner radius of the tube.\nIn the light of the above statements, choose the correct answer from the options given below :",
                options = listOf("Both Statement I and Statement II are false", "Statement I is false but Statement II is true.", "Statement I is true but Statement II is false.", "Both Statement I and Statement II are true."),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nStatement I is correct as we know contact angle depends on cohesive and adhesive forces.\nStatement II is incorrect because height of liquid is given by h =\ngr\n2Tcos C\n\n\nwhere r is radius of Tube \n(assuming length of capillary is sufficient)\nHence option (3) is correct.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q11_phys",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Physics Q11]\\nA body of m kg slides from rest along the curve of vertical circle from point A to B in friction less path. The \nvelocity of the body at B is :\n(given, R = 14 m, g = 10 m/s2\n and 2 = 1.4)",
                options = listOf("19.8 m/s", "21.9 m/s", "16.7 m/s", "10.6 m/s"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nApply W.E.T. from A to B\n Wmg = KB – KA\n mg × \n\n\n\n\n\n\n\n R\n2\nR\n = \n2 mvB\n2\n1\n– 0 {vA = 0 rest}\n\n2\n( 2 1)\nmgR \n = \n2 mvB\n2\n1\n vB = \n2\n2( 2 1)\ngR \n vB =\n1.4\n1014 2(2.4)\n vB = 21.9",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q12_phys",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Physics Q12]\\nAn electric bulb rated 50 W – 200 V is connected across a 100 V supply. The power dissipation of the bulb \nis:",
                options = listOf("12.5 W", "25 W", "50 W", "100 W"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nRated power & voltage gives resistance\nR = \nP\nV\n2\n = \n50\n(200)\n2\n = \n50\n40000\nR = 800\nP = \nR\n(V )\n2\napplied\n = \n800\n(100)\n2\nP = 12.5 watt\nHence option 1 is correct.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q13_phys",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Physics Q13]\\nA 2 kg brick begins to slide over a surface which is inclined at an angle of 45° with respect to horizontal axis. \nThe co-efficient of static friction between their surfaces is :",
                options = listOf("1", "3\n1", "0.5", "1.7"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nmg sin 45º = fL\nmg cos 45º = N\nfL = μsN\nμs = tan 45º = 1\nor\ntan  = μs\n ( is angle of repose)\ntan 45º = μs\n = 1\ncorrect option (1)",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q14_phys",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Physics Q14]\\nIn simple harmonic motion, the total mechanical energy of given system is E. If mass of oscillating particle P \nis doubled then the new energy of the system for same amplitude is :",
                options = listOf("2\nE", "E", "E 2", "2E"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nT.E. = \n2\nkA\n2\n1\nsince A is same T.E. will be same\ncorrect option (2)",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q15_phys",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Physics Q15]\\nGiven below are two statements : one is labelled as Assertion A and the other is labelled as Reason R.\nAssertion A : Number of photons increases with increase in frequency of light.\nReason R : Maximum kinetic energy of emitted electrons increases with the frequency of incident radiation.\nIn the light of the above statements, choose the most appropriate answer from the options given below :",
                options = listOf("Both A and R are correct and R is NOT the correct explanation of A.", "A is correct but R is not correct.", "Both A and R are correct and R is the correct explanation of A.", "A is not correct but R is correct."),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nIntensity of light I =\nA\nnh\nHere n is no. of photons per unit time.\nn = \nh\nIA so on increasing frequency , n decreases taking intensity constant.\nkmax = h – \nSo on increasing , kinetic energy increases.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q16_phys",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Physics Q16]\\nAccording to Bohr's theory, the moment of momentum of an electron revolving in 4th orbit of hydrogen \natom is :",
                options = listOf("\nh\n8", "\nh", "\nh\n2", "2\nh"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nMoment of momentum is r P\n \n\nL\n\n = r mv\n \n\nL = mvr = \n2\nnh\n = \n2\n4h\n = \n\n2h",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q17_phys",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Physics Q17]\\nA sample of gas at temperature T is adiabatically expanded to double its volume. Adiabatic constant for the \ngas is  = 3/2. The work done by the gas in the process is : (μ = 1 mole)",
                options = listOf("RT [ 2  2]", "RT[1 – 2 2 ]", "RT [ 2 2 – 1]", "RT[2 – 2 ]"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nW = \n \n\n1\nnR T\nTV – 1 = costant = Tf(2V) – 1\nTf\n = \n1/ 2\n2\n1\nT \n\n\n\n\n\n = \n2\nT\nW = \n2\n3\n1\nT\n2\nT\nR\n\n\n\n\n\n\n\n\n\n\n = 2RT \n2\n( 2 1)\n= RT(2 – 2 ]",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q18_phys",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Physics Q18]\\nA charge q is placed at the center of one of the surface of a cube. The flux linked with the cube is :-",
                options = listOf("0\n4\nq\n", "0\n2\nq\n", "0\n8\nq\n", "Zero"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nFrom\n \n2 = \n0\nq\n\n = \n0\n2\nq\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q19_phys",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Physics Q19]\\nApplying the principle of homogeneity of dimensions, determine which one is correct. where T is time \nperiod, G is gravitational constant, M is mass, r is radius of orbit.",
                options = listOf("T2\n = 2\n2\nGM\n4 r", "T2\n = 4\n2\nr\n3", "T2\n = \nGM\n4 r\n2 3\n", "T2\n = \nGM\n4 r\n2 2\n"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nAccording to principle of homogeneity dimension of LHS should be equal to dimensions of RHS so option \n(3) is correct.\nT\n2\n = \nGM\n4 r\n2 3\n\n[T2\n] = \n[M L T ][M]\n[L ]\n1 3 2\n3\n \n(Dimension of G is [M–1\nL\n3\nT\n–2\n]\n[T2\n] = \n[L T ]\n[L ]\n3 2\n3\n\n = [T2\n]",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q20_phys",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Physics Q20]\\nA 90 kg body placed at 2R distance from surface of earth experiences gravitational pull of :\n(R = Radius of earth, g = 10 ms–2\n)",
                options = listOf("300 N", "225 N", "120 N", "100 N"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nValue of g = \n2\ns\nR\nh\ng 1\n\n\n\n\n\n\n\n\n= gs(1 + 2)–2\n = \n9\ngs\nHere gs\n = gravitational acceleration at surface\nForce = mg = 90 × \n9\ngs\n = 100 N\nSection-B: Numerical Value Type Questions: This section contains 10 Numerical based questions. Attempt \nany 5 questions out of 10. The answer to each question should be rounded-off to the nearest integer.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q21_phys",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Physics Q21]\\nThe displacement of a particle executing SHM is given by x = 10 sin \n\n\n\n\n \n \n3\nt m. The time period of motion \nis 3.14 s. The velocity of the particle at t = 0 is _______ m/s.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 10\\nSolution:\\nGiven,\nT = 3.14 = \n\n2\n = 2 rad/s\nx = 10 sin \n\n\n\n\n \n \n3\nt\nv = \ndt\ndx = 10 cos \n\n\n\n\n \n \n3\nt\nat t = 0\nv = 10cos \n\n\n\n\n \n3\n = 10 × 2 × \n2\n1\n [using  = 2 rad/s]\nv = 10 m/s",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q22_phys",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Physics Q22]\\nA bus moving along a straight highway with speed of 72 km/h is brought to halt within 4s after applying the \nbrakes. The distance travelled by the bus during this time (Assume the retardation is uniform) is _______m.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 40\\nSolution:\\nInitial velocity = u = 72 km/h = 20 m/s\nv = u + at\n 0 = 20 + a × 4\na = –5 m/s2\nv\n2\n– u\n2\n = 2as\n 02\n– 202\n = 2(–5).s\ns = 40 m",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q23_phys",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Physics Q23]\\nA parallel plate capacitor of capacitance 12.5 pF is charged by a battery connected between its plates to \npotential difference of 12.0 V. The battery is now disconnected and a dielectric slab (r\n = 6) is inserted \nbetween the plates. The change in its potential energy after inserting the dielectric slab is _______× 10–12 J.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 750\\nSolution:\\nBefore inserting dielectric capacitance is given C0 = 12.5 pF and charge on the capacitor Q = C0V\nAfter inserting dielectric capacitance will become rC0.\nChange in potential energy of the capacitor = Ei – Ef\n=\nf\n2\ni\n2\n2C\nQ\n2C\nQ\n = \n\n\n\n\n\n\n\n0 r\n2\n1\n1\n2C\nQ\n= \n\n\n\n\n\n\n\n0 r\n2\n0 1\n1\n2C\n(C V)\n = \n\n\n\n\n\n\n\nr\n2\n0\n1\nC V 1\n2\n1\nUsing C0 = 12.5 pF, V = 12 V, r\n = 6\n= \n2\n1\n(12.5) × 122\n\n\n\n\n\n\n\n6\n1\n1 = \n2\n1\n(12.5) × 122\n × \n6\n5\n= 750 pJ = 750 × 10–12 J",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q24_phys",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Physics Q24]\\nIn a system two particles of masses m1 = 3kg and m2 = 2kg are placed at certain distance from each other. \nThe particle of mass m1 is moved towards the center of mass of the system through a distance 2cm. In order \nto keep the center of mass of the system at the original position, the particle of mass m2 should move towards \nthe center of mass by the distance ____ cm.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 3\\nSolution:\\nXC.O.M. = \n1 2\n1 1 2 2\nm m\nm x m x\n\n  \n 0 = \n3 2\n3 2 2( x)\n\n  \n x = 3 cm",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q25_phys",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Physics Q25]\\nThe disintegration energy Q for the nuclear fission of 235U  140Ce + 94Zr + n is ____MeV.\nGiven atomic masses of\n235U : 235.0439u, 140Ce ; 139.905u.\n94Zr : 93.9063u; n : 1.0086u ,\nValue of c2\n = 931 MeV/u.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 208\\nSolution:\\n235U  140Ce + 94Zr + n\nDisintegration energy\nQ = (mR – mP).c2\nmR = 235.0439 u\nmP = 139.9054u + 93.9063u + 1.0086 u\n = 234.8203u\nQ = (235.0439u – 234.8203u)c2\n = 0.2236 c2\n = 0.2236 × 931\nQ = 208.1716",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q26_phys",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Physics Q26]\\nA light ray s incident on a glas slab of thickness 4 3 cm and refractive index 2 . The angle of incidence \nis equal the cricital angle for the glass slab with air. The lateral displacement of ray after passing through \nglass slab is ______ cm. (Given sin15º = 0.25)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 2\\nSolution:\\ni = C\n i = sin–1\n\n\n\n\n\n\n\n\nµ\n1\n i = 45º\nand according to snell's law\n1 sin45º = 2 sin r\n r = 30º\nLateral displacement  = \ncosr\ntsin(i  r)\n  = \ncos 30º\n4 3  sin15º\n  = 2 cm",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q27_phys",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Physics Q27]\\nA rod of length 60 cm rotates with a uniform angular velocity 20 rad s–1\n about its perpendicular bisector, in a \nuniform magnetic field 0.5 T. The direction of magnetic field is parallel to the axis of rotation. The potential \ndifference between the two ends of the rod is ____V.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 0\\nSolution:\\n V0 – VA = \n2\nB\n2 \nV0 – VB = \n2\nB\n2 \n VA = VB  VA – VB = 0",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q28_phys",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Physics Q28]\\nTwo wires A and B are made up of the same material and have the same mass. Wire A has radius of 2.0 mm \nand wire B has radius of 4.0 mm. The resistance of wire B is 2. The resistance of wire A is _____.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 32\\nSolution:\\n R = \nA\n\n = 2 A\nV\n\nB\nA\nR\nR\n = 2\nA\n2\nB\nA\nA\n = 4\nA\n4\nB\nr\nr\n\n2\nR A\n = \n4\n3\n3\n2 10\n4 10 \n\n\n\n\n\n\n\n\n\n RA = 32 .",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q29_phys",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Physics Q29]\\nTwo parallel long current carrying wire separated by a distance 2r are shown in the figure. The ratio of \nmagnetic field at A to the magnetic field produced at C is\n7\nx\n. The value of x is ___.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 5\\nSolution:\\nBA = \n2 (3r)\nµ (2i)\n2 r\nµ i\n0 0\n\n\n\n = \n6 r\n5µ i\n0\n\nBC = \n2 (3r)\nµ i\n2 r\nµ (2i)\n0 0\n\n\n\n = \n6 r\n7µ i\n0\n\n\nC\nA\nB\nB\n = \n7\n5\n x = 5",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q30_phys",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Physics Q30]\\nMercury is filled in a tube of radius 2 cm up to a height of 30 cm. The force exerted by mercury on the \nbottom of the tube is ___N.\n(Given, atmospheric pressure = 105\n Nm–2\n, density of mercury = 1.36 × 104\n kg m–3\n, g = 10 ms–2\n,  = \n7\n22 )",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 177\\nSolution:\\nF = P0A + mghA\n= 105\n × \n7\n22 × (2 × 10–2\n)\n2\n + 1.36 × 104\n × 10 × (30 × 10–2\n) \n\n\n\n\n\n \n2 2\n(2 10 )\n7\n22\nF = 51.29 + 125.71 = 177 N",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q31_chem",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Chemistry Q31]\\nThe equilibrium constant for the reaction\nSO3 (g) SO2(g) + \n2\n1\nO2 (g) is KC = 4.9 × 10–2\n. \nThe value of KC for the reaction given below is\n2SO2(g) + O2 (g) 2SO3 (g) is",
                options = listOf("4.9", "41.6", "49", "416"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nKC = \n2\nKC\n1\n\n\n\n\n\n\n\n\n = \n2\n2\n4.9 10\n1\n\n\n\n\n\n\n\n\nKC = 416.49",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q32_chem",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Chemistry Q32]\\nFind out the major product formed from the following reaction. [Me: –CH3]",
                options = listOf("", "", "", ""),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nThe above mechanism valid for both cis and trans isomers. So the products are same for both cis and trans \nisomers.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q33_chem",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Chemistry Q33]\\nWhen MnO2 and H2SO4 is added to a salt (A), the greenish yellow gas liberated as salt (A) is :",
                options = listOf("NaBr", "CaI2", "KNO3", "NH4Cl"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n2NH4Cl + MnO2 + 2H2SO4  MnSO4 + (NH4)2SO4 + 2H2O + \nsoluton\nyellow\ngreenish\nCl2",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q34_chem",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Chemistry Q34]\\nThe correct statement/s about Hydrogen bonding is/are :\nA. Hydrogen bonding exists when H is covalently bonded to the highly electro negative atom.\nB. Intermolecular H bonding is present in o-nitro phenol\nC. Intramolecular H bonding is present in HF.\nD. The magnitude of H bonding depends on the physical state of the compound.\nE. H-bonding has powerful effect on the structure and properties of compounds.\nChoose the correct answer from the options given below :",
                options = listOf("A only", "A, D, E only", "A, B, D only", "A, B, C only"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n(A) Generally hydrogen bonding exists when H is covalently bonded to the highly electronegative atom like \nF, O, N.\n(B) Intramolecular H bonding is present in\n(C) Intermolecular Hydrogen bonding is present in HF\n(D) The magnitude has Hydrogen bonding in solid state is greater than liquid state.\n(E) Hydrogen bonding has powerfull effect on the structure & properties of compound like melting point, \nboiling point, density etc.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q35_chem",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Chemistry Q35]\\nIn the above chemical reaction sequence “A’’ and “B” respectively are :",
                options = listOf("O3, Zn/H2O and NaOH(alc.) / I2", "H2O, H+\n and NaOH(alc.) / I2", "H2O, H+\n and KMnO4", "O3, Zn/H2O and KMnO4"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q36_chem",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Chemistry Q36]\\nCommon name of Benzene-1, 2-diol is",
                options = listOf("quinol", "resorcinol", "catechol", "o-cresol"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nIUPAC name : Benzene-1,2-diol\nCommon name : catechol",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q37_chem",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Chemistry Q37]\\nCH3 – CH2 – CH2 – Br + NaOH C2H5OH Product 'A'\nConsider the above reactions, identify product B and product C.",
                options = listOf("B = C = 2-Propanol", "B = 2-Propanol C = 1-Propanol", "B = 1-Propanol C = 2-Propanol", "B = C = 1-Propanol"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q38_chem",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Chemistry Q38]\\nThe adsorbent used in adsorption chromatography is/are\nA. silica gel B. alumina\nC. quick lime D. magnesia\nChoose the most appropriate answer from the options given below :",
                options = listOf("B only", "C and D only", "A and B only", "A only"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nThe most common polar and acidic support used is adsorption chromatography is silica. The surface silanol \ngroups on their supported to adsorb polar compound and work particularly well for basic substances. \nAlumina is the example of polar and basic adsorbent that is used in adsorption chromatography.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q39_chem",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Chemistry Q39]\\n\nKOH (alc.)  major product \"P\"\nProduct P is",
                options = listOf("", "", "", ""),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nH",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q40_chem",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Chemistry Q40]\\nCorrect order of stability of carbanion is",
                options = listOf("c > b > d > a", "a > b > c > d", "d > a > c > b", "d > c > b > a"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nAs we know compound (d) is aromatic and the compound (a) is anti-aromatic. Hence compound (d) is most \nstable and compound (a) is least stable among these in compound (b) and (c) carbon atom of that positive \ncharge is sp\n3\n hybridised they on the basis of angle strain theory compound (c) is more stable than compound \n(b).",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q41_chem",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Chemistry Q41]\\nThe correct order of the first ionization enthalpy is",
                options = listOf("Al > Ga > Tl", "Ga > Al > B", "B > Al > Ga", "Tl > Ga > Al"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n(i) due to lanthanide contraction T has more I.E. as compared to Ga and A\n(ii) due to scandide contraction Ga has more I.E. as compared to A",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q42_chem",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Chemistry Q42]\\nIf an iron (III) complex with the formula [Fe(NH3)x (CN)y]\n–\nhas no electron in its eg orbital, then the value of \nx + y is",
                options = listOf("5", "6", "3", "4"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nComplex is \n[Fe(NH ) (CN) ]\n3 2 4\nIII\nx = 2\ny = 4\nso x + y = 6",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q43_chem",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Chemistry Q43]\\nFuel cell, using hydrogen and oxygen as fuels,\nA. has been used in spaceship\nB. has as efficiency of 40% to produce electricity\nC. uses aluminium as catalysts\nD. is eco-friendly\nE. is actually a type of Galvanic cell only",
                options = listOf("A,B,C only", "A,B,D only", "A,B,D,E only", "A,D,E only"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nFuel cell is used in spaceship and it is type of galvanic cell.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q44_chem",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Chemistry Q44]\\nChoose the Incorrect Statement about Dalton's Atomic Theory",
                options = listOf("Compounds are formed when atoms of different elements combine in any ratio", "All the atoms of a given element have identical properties including identical mass", "Matter consists of indivisible atoms", "Chemical reactions involve recorganization of atoms"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nIn compound atoms of different elements combine in fixed ratio by mass.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q45_chem",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Chemistry Q45]\\nMatch List-I with List-II\nLIST I LIST II\nA. -Glucose and -Galactose I. Functional isomers\nB. -Glucose and -Glucose II. Homologous\nC. -Glucose and -Fructose III. Anomers\nD. -Glucose and -Ribose IV. Epimers\nChoose the correct answer from the options given below:",
                options = listOf("A-III, B-IV, C-II, D-I", "A-III, B-IV, C-I, D-II", "A-IV, B-III, C-I, D-II", "A-IV, B-III, C-II, D-I"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nBased on biomolecules theory and structure of these named compounds –\n(A) -Glucose and -Galactose (IV) Epimers.\n(B) -Glucose and -Glucose (III) Anomers\n(C) -Glucose and -Fructose (I) Functional isomers\n(D) -Glucose and -Ribose (II) Homologous",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q46_chem",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Chemistry Q46]\\nGiven below are two statements:\nStatement I : The correct order of first ionization enthalpy values of Li, Na, F and Cl is Na < Li < Cl < F.\nStatement II : The correct order of negative electron gain enthalpy values of Li, Na, F and Cl is\nNa < Li < F < Cl\nIn the light of the above statements, choose the correct answer from the options given below :",
                options = listOf("Both Statement I and Statement II are true", "Both Statement I and Statement II are false", "Statement I is false but Statement II is true", "Statement I is true but Statement II is false"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n(i) Na < Li < Cl < F \n\nI.E. in kJ/mol 496 520 1256 1681\n(ii) Na < Li < F < Cl \n\neg H in kJ/mol –53 –60 –328 –349",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q47_chem",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Chemistry Q47]\\nFor a strong electrolyte, a plot of molar conductivity against (concentration)1/2 is a straight line, with a\nnegative slope, the correct unit for the slope is",
                options = listOf("S cm2\n mol–3/2 L1/2", "S cm2\n mol–1 L\n1/2", "S cm2\n mol–3/2 L", "S cm2\n mol–3/2 L–1/2"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nm  mº A C\nUnits of A C = S cm2\n mole–1\nUnits of A = S cm2\n mole–3/2 L1/2",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q48_chem",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Chemistry Q48]\\nA first row transition metal in its +2 oxidation state has a spin-only magnetic moment value of 3.86 BM. The \natomic number of the metal is",
                options = listOf("25", "26", "22", "23"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n22Ti+2  [Ar]3d2\n23V\n+2  [Ar]3d3\n25Mn\n+2  [Ar]3d5\n26Fe+2  [Ar]3d6",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q49_chem",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Chemistry Q49]\\nThe number of unpaired d-electrons in [Co(H2O)6]\n3+ is______",
                options = listOf("4", "2", "0", "1"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n [Co(H2O)6]\n+3\nNo unpaired electrons",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q50_chem",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Chemistry Q50]\\nThe number of species from the following that have pyramidal geometry around the central atom is________\n2\nS2O3\n, \n2\nSO4\n, \n2\nSO3\n,\n2\nS2O7",
                options = listOf("4", "3", "1", "2"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nSection-B: Numerical Value Type Questions: This section contains 10 Numerical based questions. Attempt \nany 5 questions out of 10. The answer to each question should be rounded-off to the nearest integer.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q51_chem",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Chemistry Q51]\\nThe maximum number of orbitals which can be identified with n = 4 and m\n = 0 is_____",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 4\\nSolution:\\nSo answer is 4.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q52_chem",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Chemistry Q52]\\nNumber of compounds/species from the following with non-zero dipole moment is_____\nBeCl2, BCl3, NF3, XeF4, CCl4, H2O H2S, HBr, CO2, H2, HCl",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 5\\nSolution:\\nPolar molecule : NF3, H2O, H2S, HBr, HCl\n (µ0)\nNon Polar molecule : BeCl2,BCl3, XeF4, CCl4, CO2, H2\n (µ = 0)\nSo answer is 5.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q53_chem",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Chemistry Q53]\\nThree moles of an ideal gas are compressed isothermally from 60 L to 20 L using constant pressure of 5 atm. \nHeat exchange Q for the compression is – ____ Lit. atm.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 200\\nSolution:\\nAs isothermal U = 0\nand process is irreversible\nQ = –W = – [– Pext (V2 – V1)]\nQ = 5 (20 – 60) = – 200 atm-L",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q54_chem",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Chemistry Q54]\\nFrom 6.55 g of aniline, the maximum amount of acetanilide that can be prepared will be___× 10–1\n g.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 95\\nSolution:\\n93 g aniline form 135 gm acetanlide\nso 6.55 g aniline form\n93\n135 × 6.55 = 9.5 g = 95 × 10–1\ng",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q55_chem",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Chemistry Q55]\\nConsider the following reaction, the rate expression of which is given below A + B  C\nrate = k [A]1/2 [B]1/2\nThe reaction is initiated by taking 1 M concentration A and B each. If the rate constant (k) is 4.6 × 10–2\n s\n–1\n, \nthen the time taken for A to become 0.1 M is_____sec. (nearest integer)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 50\\nSolution:\\nK = \n0.1\n1\nlog\nt\n2.303\n4.6 × 10–2\n = \nt\n2.303\nt = 50 sec.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q56_chem",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Chemistry Q56]\\nPhthalimide is made to undergo following sequence of reactions.\nPhthalimide \n(ii)Benzylchloride\n(i)KOH\n 'P'\nTotal number of  bonds present in product 'P' is/are",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 8\\nSolution:\\nTotal number of -bonds present in product P is 8",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q57_chem",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Chemistry Q57]\\nThe total number of 'sigma' and 'Pi' bonds in 2-oxohex-4-ynoic acid is____.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 18\\nSolution:\\n2-Oxohex-4-ynoic acid\nNumber of -bonds = 14\nNumber of -bonds = 4\n = 18",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q58_chem",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Chemistry Q58]\\nA first row transition metal with highest enthalpy of atomisation, upon reaction with oxygen at high\ntemperature forms oxides of formula M2On (where n = 3,4,5). The 'spin-only' magnetic moment value of the \namphoteric oxide from the above oxides is___ BM (near integer) (Given atomic number : Sc : 21, Ti : 22, V : \n23, Cr : 24, Mn : 25, Fe : 26, Co : 27, Ni : 28 ,Cu : 29, Zn : 30)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 0\\nSolution:\\n'V' has highest enthalpy of atomisation (515 kJ/mol) among first row transition elements.\nV2O5\nHere 'V' is in +5 oxidation state\nV\n+5  1s2\n 2s2\n 2p6\n 3s2\n 3p6\n (no unpaired electrons)",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q59_chem",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Chemistry Q59]\\n2.7 Kg of each of water and acetic acid are mixed, The freezing point of the solution will be –x °C. Consider \nthe acetic acid does not dimerise in water, nor dissociates in water x = ______(nearest integer)\n[Given : Molar mass of water = 18 g mol–1\n, acetic acid = 60 g mol–1\n]\nKf H2O: 1.86 K kg mol–1\nKf acetic acid : 3.90 K kg mol–1\nfreezing point : H2O = 273 K, acetic acid = 290 K]",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 31\\nSolution:\\nAs moles of water > moles of CH3COOH\nwater is solvent.\nT°F – (TF)S = KF × M\n0 – (TF)S = 1.86 ×\n2700/1000\n2700/ 60\n(TF)s\n = –31°C.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q60_chem",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Chemistry Q60]\\nVanillin compound obtained from vanilla beans, has total sum of oxygen atoms and  electrons is____",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 11\\nSolution:\\nVanillin compound is an organic compound molecular formula C8H8O3. It is a phenolic aldehyde.\nIts functional compounds include aldehyde, hydroxyl and ether. It is the primary component of the extract of \nthe vanilla beans.\n \nTotal sum of oxygen atoms and -electrons is 3 + 8 = 11\nTotal number of oxygen atoms = 3\nTotal number of -bonds = 4\n Total number of -electrons = 8",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q61_math",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Mathematics Q61]\\nIf the function f(x) = \n\n\n\n\n\n\n\n \n  \na log 2log 3 , x 0\n, x 0\n2 1 cos x\n72 9 8 1\ne e\nx x x\nis continuous at x = 0, then the value of a2\n is equal to",
                options = listOf("968", "1152", "746", "1250"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nlimf(x)\nx0\n= an2n3\nx 0\nlim\n 2 1 cos x\n72 9 8 1\nx x x\n \n  \n = \nx 0\nlim\n 2 1 cos x\n(8 1)(9 1)\nx x\n \n \nx 0\nlim\n\n 2 1 cos x \n1 cos x\nx\nx\n9 1\nx\n8 1\nx x 2\n  \n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n \n\n\n\n\n\n\n\n \n n8  n9  2  2 2 = 24 2 n2n3\n a = 24 2 , a\n2\n = 576 × 2 = 1152",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q62_math",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Mathematics Q62]\\nIf  > 0, let  be the angle between the vectors k\nˆ\nj 3\nˆ\ni\nˆ a    \n\nand k\nˆ\nj 2\nˆ\ni\nˆ b  3  \n\n. If the vectors a b\n \n and \na b\n \n are mutually perpendicular, then the value of (14 cos )\n2\n is equal to",
                options = listOf("25", "20", "50", "40"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n( a b\n \n ).( a b\n \n ) = 0,  > 0\n2 2\n| a | | b |\n \n = 0  1 + \n2\n + 9 = 9 + 1 + 4\n = 2, cos  = \n14 · 14\n3 6\n| a |·| b |\na ·b   \n\n \n \n14cos = 3 – 8 = –5\n (14 cos)\n2\n = 25",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q63_math",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Mathematics Q63]\\nLet C be a circle with radius 10 units and centre at the origin. Let the line x + y = 2 intersects the circle C \nat the points P and Q. Let MN be a chord of C of length 2 unit and slope –1. Then, a distance (in units) \nbetween the chord PQ and the chord MN is",
                options = listOf("2 – 3", "3 – 2", "2 – 1", "2 + 1"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nC : x2\n + y2\n = 10\nAN =\n2\nMN = 1\n In OAN  (ON)2\n = (OA)2\n + (AN)2\n10 = (OA)2\n + 1  OA = 3\nPerpendicular distance of center from PQ = \n2\n| 0  0  2 |\n = 2\nPerpendicular distance between MN and PQ = OA + 2 or |OA – 2 |\n= 3 + 2 or 3 – 2",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q64_math",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Mathematics Q64]\\nLet a relation R on N  N be defined as :\n(x1, y1) R(x2, y2) if and only if x1  x2 or y1  y2\nConsider the two statements :\n(I) R is reflexive but not symmetric.\n(II) R is transitive\nThen which one of the following is true ?",
                options = listOf("Only (II) is correct.", "Only (I) is correct.", "Both (I) and (II) are correct.", "Neither (I) nor (II) is correct."),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nAll ((x1y1), (x1,y1)) are in R where\nx1, y1  N  R is reflexive\n((1,1), (2,3))  R but ((2,3), (1,1))  R\n R is not symmetric\n((2,4), (3,3))  R and ((3,3), (1,3))  R but ((2,4), (1,3))  R\n R is not transitive",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q65_math",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Mathematics Q65]\\nLet three real numbers a, b, c be in arithmetic progression and a + 1, b, c + 3 be in geometric progression. If \na > 10 and the arithmetic mean of a, b and c is 8, then the cube of the geometric mean of a, b and c is",
                options = listOf("120", "312", "316", "128"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n2b = a + c, b2\n = (a + 1) (c + 3),\n3\na  b  c\n = 8 b = 8, a + c = 16\n64 = (a + 1) (19 – a) = 19 + 18a – a\n2\na\n2\n– 18a – 45 = 0  (a – 15) (a + 3) = 0, (a > 10)\na = 15, c = 1, b = 8\n((abc)1/3)\n3\n = abc = 120",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q66_math",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Mathematics Q66]\\nLet A = \n\n\n\n\n\n0 1\n1 2\nand B = I + adj(A) + (adj A)2\n+…+ (adj A)10. Then, the sum of all the elements of the matrix \nB is :",
                options = listOf("–110", "22", "–88", "–124"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nAdj(A) = \n\n\n\n\n \n0 1\n1 2\n(AdjA)2\n = \n\n\n\n\n \n0 1\n1 4\n|\n|\n(AdjA)10\n = \n\n\n\n\n \n0 1\n1 20\nB = \n\n\n\n\n\n0 1\n1 0\n+ \n\n\n\n\n \n0 1\n1 2\n + \n\n\n\n\n \n0 1\n1 4\n + …. + \n\n\n\n\n \n0 1\n1 20\nB = \n\n\n\n\n \n0 11\n11 110\n sum of elements of B\n = –88",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q67_math",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Mathematics Q67]\\nThe value of \n1 2 2 3 ... 100 101\n1 2 2 3 ... 100 (101)\n2 2 2\n2 2 2\n     \n     \nis",
                options = listOf("305\n306", "301\n305", "31\n32", "30\n31"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n1 2 2 3 ...100 101\n1 2 2 3 ... 100 (101)\n2 2 2\n2 2 2\n    \n     \n = \n\n\n\n\n\n\n100\nr 1\n2\n100\nr 1\n2\nr (r 1)\nr(r 1)\n\n\n\n\n\n \n100\nr 1\n3 2\n100\nr 1\n3 2\n(r r )\n(r 2r r)\n= \n6\nn(n 1)(2n 1)\n2\nn(n 1)\n2\nn(n 1)\n6\n2.n(n 1)(2n 1)\n2\nn(n 1)\n2\n2\n \n \n\n\n\n\n \n\n\n \n\n\n\n\n\n\n\n\n \n= \n\n\n\n\n\n \n\n \n\n\n\n\n\n\n  \n \n3\n(2n 1)\n2\nn(n 1)\n2\nn(n 1)\n.(2n 1) 1\n3\n2\n2\nn(n 1)\n2\nn(n 1)\n; Put n = 100\n= \n301\n305\n5117\n5185\n3\n201\n2\n100 101\n(201) 1\n3\n2\n2\n(100)(101)\n \n\n\n ",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q68_math",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Mathematics Q68]\\nLet f(x) = \n  \nx\n0\nt\n(t sin (1 e ))dt, x R . Then 3 x 0 x\nf(x)\nlim\n\nis equal to",
                options = listOf("6\n1", "–\n6\n1", "–\n3\n2", "3\n2"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n3 x 0 x\nf(x)\nlim\n\nUsing L Hopital Rule.\n2 x 0 3x\nf'(x)\nlim\n\n= 2\nx\nx 0 3x\nx sin(1 e )\nlim  \n\n (Again L Hopital)\n6x\n1 cos(1 e )( e )\nlim\nx x\nx 0\n  \n\nUsing L.H. Rule\n= \nx 0\nlim\n 6\n[sin(1 e )( e ).e cos(1 e ).e ]\nx x x x x     \n= –\n6\n1",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q69_math",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Mathematics Q69]\\nThe area (in sq. units) of the region described by {(x,y) : y2\n 2x, and y  4x –1} is",
                options = listOf("32\n11", "9\n8", "12\n11", "32\n9"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nShaded area = \n\n\n1\n2\n1\nRight Left (x x ) dy\nSolve\n2\n1\ny 1, y\ny 4x 1\ny 2x\n2\n  \n \n\nShaded area = \n\n\n\n\n\n\n\n\n\n\n\n1\n2\n1\n2\n2\ny\n4\ny 1\ndy\n32\n9\n6\ny\ny\n2\ny\n4\n1\n1\n2\n1\n2 3\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q70_math",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Mathematics Q70]\\nThe area (in sq. units) of the region S = {z C;| z 1|  2;(z  z)  i(z  z)  2,lm(z)  0} is",
                options = listOf("3\n7", "2\n3", "8\n17", "4\n7"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nPut z = x + iy\n|z – 1| 2  (x – 1)2\n + y2\n 4 …(1)\n(z  z)  i(z  z)  2  2x  i(2iy)  2\n x – y  1 …(2)\nIm(z)  0  y  0 …(3)\nRequired area = Area of semi-circle – area of sector A\n2\n3\n2\n(2)\n2\n1 2\n\n\n\n ",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q71_math",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Mathematics Q71]\\nIf the value of the integral \n\n\n\n1\n1\nx 1 3\ncos x\ndx is \n\n2\n. Then, a value of  is",
                options = listOf("6\n", "2\n", "3\n", "4\n"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nLet I = \n\n\n\n\n1\n1\nx 1 3\ncos x\ndx …(i)\nI = \n\n\n \n\n1\n1\nx 1 3\ncos x\ndx\n\n\n\n\n\n\n\n\n \n \nb\na\nb\na\nusing f(x) dx f(a b – x) dx …(ii)\nAdd (i) and (ii)\n2I =  \n  \n 1\n0\n1\n–1\ncos ( x) dx 2 cos ( x) dx\nI = \n\n\n\nsin 2\n (given)\n = \n2\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q72_math",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Mathematics Q72]\\nLet f(x) = 3 x  2  4  x be a real valued function. If  and  are respectively the minimum and the \nmaximum values of f, then \n2\n + 2\n2\n is equal to",
                options = listOf("44", "42", "24", "38"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nf(x) = 3 x  2  4  x\nx – 2  0 & 4 – x  0\n x  [2, 4]\nLet x = 2sin2\n + 4cos2\n\n f(x) = 3 2 |cos| + 2 |sin|\n 2  3 2 |cos| + 2 |sin|  9 2  2\n2  3 2 |cos| + 2 |sin|  20\n = 2  = 20\n\n2\n + 2\n2\n = 2 + 40 = 42",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q73_math",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Mathematics Q73]\\nIf the coefficients of x4\n, x\n5\n and x6\n in the expansion of (1 + x)n\n are in the arithmetic progression, then the \nmaximum value of n is :",
                options = listOf("14", "21", "28", "7"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nCoeff. of x4\n = \nnC4\nCoeff. of x5\n = \nnC5\nCoeff. of x6\n = \nnC6\nnC4, \nnC5, \nnC6 …. AP\n2.nC5 = \nnC4 + nC6\n2 = \n\n\n\n\n\n  \n \n r\nn r 1\nC\nC\nC\nC\nC\nC\nr 1\nn\nr\nn\n5\nn\n6\nn\n5\nn\n4\nn\n2 = \n6\nn 5\nn 4\n5 \n\n\n12(n – 4) = 30 + n2\n– 9n + 20\nn\n2\n– 21n + 98 = 0\n(n – 14) (n – 7) = 0\nnmax = 14 nmin = 7",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q74_math",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Mathematics Q74]\\nConsider a hyperbola H having centre at the origin and foci and the x-axis. Let C1 be the circle touching the \nhyperbola H and having the centre at the origin. Let C2 be the circle touching the hyperbola H at its vertex \nand having the centre at one of its foci. If areas (in sq. units) of C1 and C2 are 36 and 4, respectively, then \nthe length (in units) of latus rectum of H is",
                options = listOf("3\n28", "3\n14", "3\n10", "3\n11"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nLet H : 2\n2\n2\n2\nb\ny\na\nx\n = 1 (b2\n = a\n2\n(e2\n– 1))\n eq\nn\n of C1 = x\n2\n + y2\n = a\n2\nAr. = 36\na\n2\n = 36\na = 6\nNow radius of C2 can be a(e – 1) or a(e + 1)\nfor r = a(e – 1) for r = a(e + 1)\nAr. = 4 r\n2\n = 4\na\n2\n(e – 1)2\n = 4 a\n2\n(e + 1)2\n = 4\n36(e – 1)2\n = 4 36(e + 1)2\n = 4\ne – 1 = \n3\n1\ne + 1 = \n3\n1\ne = \n3\n4\n–\n3\n2\nNot possible\n b2\n = 36 \n\n\n\n\n\n1\n9\n16 = 28\n LR =\n3\n28\n6\n2 28\na\n2b\n2\n\n\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q75_math",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Mathematics Q75]\\nIf the mean of the following probability distribution of a random variable X;\nX 0 2 4 6 8\nP(X) a 2a a + b 2b 3b\nis\n9\n46\n, then the variance of the distribution is",
                options = listOf("81\n581", "81\n566", "27\n173", "27\n151"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nP1 = 1\na + 2a + a + b + 2b + 3b = 1\n4a + 6b = 1 ….(I)\nE(x) = mean =\n9\n46\nPiXi\n = \n9\n46\n 4a + 4a + 4b + 12b + 24b =\n9\n46\n8a + 40b =\n9\n46\n4a + 20b =\n9\n23 ….(II)\nSubtract (I) from (II) we get\nb = \n9\n1\n& a = \n12\n1\nVariance = E(xi\n2\n) – E(xi)\n2\nE(xi\n2\n) = 02\n × 92\n + 22\n × 2a + 42\n(a + b) + 62\n(2b) + 82\n(3b) = 24a + 280b\nPut a =\n12\n1\nb = \n9\n1\nE(xi\n2\n) = 2 +\n9\n298\n9\n280\n\n \n2\n = E(xi\n2\n) – E(xi)\n2\n= \n2\n9\n46\n9\n298 \n\n\n\n\n\n\n\n2\n = \n81\n2116\n9\n298\n = \n81\n566",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q76_math",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Mathematics Q76]\\nLet PQ be a chord of the parabola y2\n = 12x and the midpoint of PQ be at (4, 1). Then, which of the following \npoint lies on the line passing through the points P and Q ?",
                options = listOf("(3, –3)", "\n\n\n\n\n\n,16\n2\n3", "(2, –9)", "\n\n\n\n\n\n, 20\n2\n1"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n(4, 1)\nT = S1\ny – 6(x + 4)\n= 1 – 48\n6x – y = 23\nOption-4 \n\n\n\n\n\n, 20\n2\n1\nwill satisfy",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q77_math",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Mathematics Q77]\\nGiven the inverse trigonometric function assumes principal values only. Let x, y be any two real numbers in \n[–1, 1] such that cos\n–1\nx – sin–1\n y = ,\n2\n\n. Then, the minimum value of x2\n + y2\n + 2xy sin is",
                options = listOf("–1", "0", "2\n1", "2\n1"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\ncos\n–1\nx – \n\n\n\n\n\n\n \ncos y\n2\n1 = \ncos\n–1\nx + cos\n–1\n y = \n2\n\n + \n \n\n\n\n\n \n  \n\n\n\n\n\n\n\n\n\n\n2\n3\n0,\n2\n, ,\n2\ncos\n–1\n(xy 1 x 1 y )\n2 2    = \n2\n\n + \nxy –\n2 2 1 x 1 y = –sin\n(xy + sin)\n2\n = (1 – x\n2\n) (1 – y\n2\n)\nx\n2\ny\n2\n + 2xysina + sin2\na = 1 – x\n2\n– y\n2\n + x2\ny\n2\nx\n2\n + y2\n + 2xy sin = 1 – sin2\n\nx\n2\n + y2\n + 2xy sin = cos\n2\n\nMin. value of cos2\n = 0\nAt \n2\n\n \nOption (2) is correct",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q78_math",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Mathematics Q78]\\nLet y = y(x) be the solution of the differential equation (x2\n + 4)2\ndy + (2x3\ny + 8xy – 2)dx = 0. If y(0) = 0, then \ny(2) is equal to\n(1)\n8\n\n(2)\n16\n\n(3) 2 (4)\n32\n",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 4\\nSolution:\\n2 2 2 2\n3\n(x 4)\n2\n(x 4)\n2x 8x\ny\ndx\ndy\n\n\n\n\n\n\n\n\n\n\n\n\n2 2 2\n(x 4)\n2\nx 4\n2x\ny\ndx\ndy\n\n \n\n\n\n\n\n\n\nIF = \n\ndx\nx 4\n2x\n2\ne\nIF = x2\n + 4\ny × (x2\n + 4) =  \n2 2\n(x 4)\n2\n× (x2\n + 4) \n y (x2\n + 4) =  \n2 2\nx 2\ndx 2\ny (x2\n + 4) = c\n2\nx\ntan\n2\n2 1\n \n\n\n\n\n \n0 = 0 + c  c = 0\ny(x2\n + 4) = tan–1\n\n\n\n\n\n\n2\nx\ny at x = 2\ny(4 + 4) = tan–1\n(1)\n32\ny(2)\n\n\nOption (4) is correct",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q79_math",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Mathematics Q79]\\nLet k\nˆ\nj\nˆ\ni\nˆ a   \n\n, k\nˆ\nj 5\nˆ\ni 4\nˆ b  2  \n\nand k\nˆ\nj 3\nˆ\ni 2\nˆ c  x  \n\n, x  R. If d\n\n is the unit vector in the direction of b\n\n+ c\n\nsuch that a\n\n. d\n\n = 1, then ( a\n\n× b\n\n). c\n\nis equal to",
                options = listOf("9", "6", "3", "11"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nd\n\n=  b\n\n+ c\n\n\na\n\n. d\n\n =  b\n\n. a\n\n+ c\n\n. a\n\n\n1 = (1 + x + 5)\n1 = (x + 6) ….(1)\n| d\n\n| = 1 x 6\n1\n \n\n|( b\n\n+ c\n\n)| = 1\n|((x + 2) k\nˆ\nj 2\nˆ\ni 6\nˆ   )| = 1\n\n2\n((x + 2)2\n + 62\n + 22\n) = 1\nx\n2\n + 4x + 4 + 36 + 4 = (x + 6)2\nx\n2\n + 4x + 44 = x2\n + 12x + 36\n8x = 8, x = 1\nx 2 3\n2 4 5\n1 1 1\n = ( a\n\n× b\n\n). c\n\nx 2 1 3\n2 9 5\n0 0 1\n \n  = 2 – 9(x – 2) \n= 20 – 9x\nat x = 1\n20 – 9 = 11\nOption 4 is correct",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q80_math",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Mathematics Q80]\\nLet P the point of intersection of the lines \n1\nz 2\n5\ny 4\n1\nx 2 \n\n\n\n\nand \n2\nz 3\n3\ny 2\n2\nx 3 \n\n\n\n\n. Then, the \nshortest distance of P from the line 4x = 2y = z is",
                options = listOf("7\n5 14", "7\n14", "7\n3 14", "7\n6 14"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nL1 \n1\nz 2\n5\ny 4\n1\nx 2 \n\n\n\n\n= \nP( + 2, 5 + 4,  + 2)\nL2 \n2\nz 3\n3\ny 2\n2\nx 3 \n\n\n\n\nP(2 + 3, 3 + 2, 2 + 3)\n + 2 = 2 + 3 3 + 2 = 5 + 4\n = 2 + 1 3 = 5 + 2\n3 = 5(2 + 1) + 2\n3 = 10 + 7\n = –1  = –1\nBoth satisfies (P)\nP(1, –1, 1)\nL3 \n1\nz\n1/ 2\ny\n1/ 4\nx\n \nL3 =\n4\nz\n2\ny\n1\nx\n  = k\nCoordinates of Q(k, 2k, 4k)\nDR’s of PQ = <k – 1, 2k + 1, 4k – 1>\nPQ  to L3\n(k – 1) + 2(2k + 1) + 4(4k – 1) = 0\nk – 1 + 4k + 2 + 16k – 4 = 0\nk = \n7\n1\nQ \n\n\n\n\n\n7\n4\n,\n7\n2\n,\n7\n1\nPQ = \n2 2 2\n7\n4\n1\n7\n2\n1\n7\n1\n1 \n\n\n\n\n\n  \n\n\n\n\n\n   \n\n\n\n\n\n\n= \n7\n126\n49\n9\n49\n81\n49\n36\n  \nPQ = \n7\n3 14\nOption-3 will satisfy\nSection-B: Numerical Value Type Questions: This section contains 10 Numerical based questions. Attempt \nany 5 questions out of 10. The answer to each question should be rounded-off to the nearest integer.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q81_math",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Mathematics Q81]\\nLet S = {sin2\n2 : (sin4\n + cos4\n)x2\n + (sin2)x + (sin6\n + cos6\n) = 0 has real roots}. If  and  be the smallest \nand largest elements of the set S, respectively, then 3(( – 2)2\n + ( – 1)2\n) equals…..",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 4\\nSolution:\\nD  (sin 2)\n2\n– 4 \n\n\n\n\n\n  \n\n\n\n\n\n\n \n sin 2\n4\n3\n1\n2\nsin 2\n1\n2\n2\n= (sin 2)\n2\n– 4 \n\n\n\n\n\n   sin 2\n8\n3\nsin 2\n4\n5\n1\n2 4\nD = –\n2\n3\nsin4\n 2 + 6 sin2\n2 – 4 > 0\n3sin4\n 2 –12sin2\n 2 + 8 < 0\nsin2\n 2 = \n3\n6 2 3\n6\n12 4 3\n6\n12 12 12.8\n2 \n\n\n\n \nsin2\n 2 = 2 ± \n3\n2\n, but sin2\n 2 [0, 1]\n= 2 –\n3\n2\n,  = 1  ( – 2)\n2\n = \n3\n4\n, ( – 1)2\n = 0\n3( 2) ( 1) 4\n2 2      ",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q82_math",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Mathematics Q82]\\nIf \n   \n\n\n\n\n\n   C\n2\nx\nlog tan\n2\n3\ncos ec xdx cot x cos ecx cos ec x e\n5 2 where  R and C is constant of \nintegration, then the value of 8( + ) equals …..",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 1\\nSolution:\\n\ncosec\n3\n x  cosec\n2\n xdx = I\nBy applying integration by parts\nI = –cot x cosec\n3\nx + \ncot x(–3cosec2\n xcot xcosecx) dx\nI = –cot x cosec\n3\nx – 3 \ncosec\n3\nx (cosec\n2\nx – 1) dx\nI = –cot x cosec\n3\nx – 3I + 3\n\ncosec\n3\nxdx\nLet\nI1 = \ncosec\n3\n xdx = –cosecxcot x –\n\ncot2\n xcosecxdx\nI1 = –cosecxcotx –\n\ncosec\n2\nx – 1) cosecxdx\n2I1 = –cosecx cotx + n\n2\nx\ntan\nI1 = –\n2\n1\ncosecx cot x + \n2\n1\nn\n2\nx\ntan\n4I = –cot xcosec3\nx –\n2\n3\ncos ecx cot x + \n2\n3\nn\n2\nx\ntan + 4c\nI = –\n4\n1\ncosecx cot x \n\n\n\n\n\n\n2\n3\ncos ex x\n2\n +\n8\n3\nn\n2\nx\ntan + c\n = \n4\n1\n, \n8\n3\n 8( ) 1",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q83_math",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Mathematics Q83]\\nLet f : R R be a thrice differentiable function such that f(0) = 0, f",
                options = listOf("= 1, f", "= –1, f", "= 2 and f", "= –2. \nThen, the minimum number of zeros of (3f ' f '' + ff\"') (x) is ….."),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 5\\nSolution:\\n(3f 'f '' + ff ''') (x) = ((ff '' + (f ')\n2\n) (x))'\n(ff '' + (f ')\n2\n) (x) = ((ff ') (x))'\n (3f 'f '' + f ''') (x) = (f(x)f '(x))''\nmin. roots of f(x)  4\n min. roots of f '(x)  3\n min. roots of (f(x)f '(x)) 7\nmin. roots of (f(x)·f '(x)''5",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q84_math",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Mathematics Q84]\\nConsider the function f : R  R defined by f(x) =\n2 1 9x\n2x\n\n. If the composition of f, \n10 times\n(f o f o f o...o f) (x) = \n2\n10\n1 9 x\n2 x\n \n, then the value of 3 1 is equal to …..",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 1024\\nSolution:\\nf (f (x)) = \n2 2 2 2 1 9x 9.2 x\n4x\n1 9f (x)\n2f(x)\n \n\n\nf (f (f(x))) = \n1 9x (1 2 2 )\n2 x\n1 9x\n2 x\n1 9(1 2 )\n2 x / 1 9x\n2 2 4\n3\n2\n2 2\n2\n3 2\n  \n\n\n \n\n By observation\n = 1 + 22\n + 24\n + … + 218 = 1 \n\n\n\n\n\n\n\n\n\n2 1\n(2 ) 1\n2\n2 10\n = \n3\n2 1\n20 \n3 + 1 = 2\n20  3 1 = 2\n10\n = 1024",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q85_math",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Mathematics Q85]\\nLet A be a 2 × 2 symmetric matrix such that A \n\n\n\n\n\n\n\n\n\n\n\n7\n3\n1\n1\nand the determinant of A be 1. If A–1\n = A + I,\nwhere I is an identity matrix of order 2 × 2, then  +  equals …..",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 5\\nSolution:\\nLet A = \n\n\n\n\n\nb d\na b\n\n\n\n\n\n\nb d\na b\n\n\n\n\n\n\n1\n1\n = \n\n\n\n\n\n7\n3\n, ad – b2\n = 1\na + b = 3, b + d = 7, (3 – b) (7 – b) – b2\n = 1\n21 – 10b = 1  b = 2, a = 1, d = 5\nA = \n\n\n\n\n\n2 5\n1 2\n, A–1\n = \n\n\n\n\n\n\n\n2 1\n5 2\nA\n–1\n = A+ I \n\n\n\n\n\n\n\n\n2 1\n5 2\n = \n\n\n\n\n\n   \n   \n2 5\n2\n = –1,  = 6      5",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q86_math",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Mathematics Q86]\\nThere are 4 men and 5 women in Group A, and 5 men and 4 women in Group B. If 4 persons are selected \nfrom each group, then the number of ways of selecting 4 men and 4 women is …..",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 5626\\nSolution:\\nFrom Group A From Group B Ways of selection\n4M 4W 4C4\n4C4 = 1\n3M 1W 1M 3W 4C3\n5C1 \n5C1\n4C3 = 400\n2M 2W 2M 2W 4C2\n5C2 \n5C2\n4C2 = 3600\n1M 3W 3M 1W 4C1\n5C3 \n5C3\n4C1 =1600\n4W 4M 5C4\n5C4 = 25\nTotal 5626",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q87_math",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Mathematics Q87]\\nIn a tournament, a team plays 10 matches with probabilities of winning and losing each match as\n3\n1\nand\n3\n2\nrespectively. Let x be the number of matches that the team wins, and y be the number of matches that team \nloses. If the probability P(|x – y|  2) is p, then 39\np equals……",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 8288\\nSolution:\\nP(W) = \n3\n1\nP(L) = \n3\n2\nx = number of matches that team wins\ny = number of matches that team loses\n|x – y|  2 and x + y = 10\n|x – y| = 0,1,2 x, y  N\nCase-I : |x – y| = 0  x = y\n x + y = 10  x = 5 = y\nP(|x – y| = 0) = 10C5\n5\n3\n1\n\n\n\n\n\n\n5\n3\n2\n\n\n\n\n\n\nCase-II : |x – y| = 1  x – y = ±1\nx = y + 1 x = y –1\n x + y =10  x + y =10\n2y = 9 2y = 11\nNot possible Not possible\nCase-III : |x – y| = 2 x – y = ±2\nx – y = 2 OR x – y = –2\n x + y = 10  x + y = 10\nx = 6, y = 4 x = 4, y = 6\nP(|x – y| = 2) = 10C6\n6\n3\n1\n\n\n\n\n\n\n4\n3\n2\n\n\n\n\n\n\n+ 10C4\n4\n3\n1\n\n\n\n\n\n\n6\n3\n2\n\n\n\n\n\n\np = \n10C5\n10\n5\n3\n2\n + 10C6\n10\n4\n3\n2\n + 10C4\n10\n6\n3\n2\n3\n9\n p = \n3\n1\n(\n10C5 25\n+ 10C6 24\n+ 10C4 26\n)\n = 8288",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q88_math",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Mathematics Q88]\\nConsider a triangle ABC having the vertices A(1, 2), B(, ) and C(, ) and angles ABC = \n6\n\nand BAC\n= \n3\n2\n. If the points B and C lie on the line y = x + 4, then \n2\n + \n2\n is equal to …..",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 14\\nSolution:\\nEquation of line passes through point A(1, 2) which makes angle\n6\n\nfrom y = x + 4 is\ny – 2 = (x 1)\n6\n1 tan\n6\n1 tan\n\n\n\n\n\ny – 2 = (x 1)\n3 1\n3 1\n\n\n\n \ny – 2 = (2 + 3 ) (x – 1) y – 2 = (2 – 3 ) (x – 1)\nsolve with y = x + 4 solve with y = x + 4\nx + 2 = (2 + 3 )x – 2 – 3 x + 2 = (2 – 3 )x – 2 + 3\nx = \n1 3\n4 3\n\n\nx = \n1 3\n4 3\n\n\n\n2\n + \n2\n = \n2\n1 3\n4 3\n\n\n\n\n\n\n\n\n\n\n + \n2\n1 3\n4 3\n\n\n\n\n\n\n\n\n\n\n\n2\n+ \n2\n= 14",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q89_math",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Mathematics Q89]\\nConsider a line L passing through the points P(1, 2, 1) and Q(2, 1, –1). If the mirror image of the point \nA(2, 2, 2) in the line L is (, , ), then  +  + 6 is equal to …..",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 6\\nSolution:\\nDR's of Line L  –1 : 1 : 2\nDR's of AB  – 2 :  – 2 :  – 2\nAB ar L  2 –  +  – 2 + 2 – 4 = 0\n2 +  –  = 4 ...(1)\nLet C is mid-point of AB\nC \n\n\n\n\n      \n2\n2\n,\n2\n2\n,\n2\n2\nDR's of PC =\n2\n:\n2\n2\n:\n2\n   \nline L | | PC \n2 2\n2\n2\n\n\n \n\n\n = K(let)\n = – 2K\n = 2K + 2\n = 4K\nuse in (1)  K = \n6\n1\nvalue of  +  + 6 = 24K + 2 = 6",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q90_math",
                topicId = testId,
                text = "[JEE Main 2024 Session 2 Shift 2 - Mathematics Q90]\\nLet y = y(x) be the solution of the differential equation (x + y + 2)2\ndx = dy, y(0) = –2. Let the maximum and \nminimum values of the function y = y(x) in \n\n\n\n\n \n3\n0, be  and , respectively. If (3 + )\n2\n + \n2\n=  +  3 , , \n Z, then  +  equals …..",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 31\\nSolution:\\ndx\ndy\n= (x + y + 2)2\n ...(1), y(0) = –2\nLet x + y + 2 = v\n1 + \ndx\ndy\n = \ndx\ndv\nfrom (1) \ndx\ndv\n = 1 + v\n2\n \n\n\ndx\n1 v\ndv\n2\ntan–1\n(v) = x + C\ntan–1\n(x + y + 2) = x + C\nat x = 0 y = – 2  C = 0\n tan–1\n(x + y + 2) = x\ny = tanx – x – 2\nf(x) = tanx – x – 2, x  \n\n\n\n\n \n3\n0,\nf '(x) = sec2\nx – 1 > 0  f(x)\nfmin = f(0) = –2 = \nfmax = f\n3\n3\n3\n\n  \n\n\n\n\n \n– 2 = \nnow (3 + )\n2\n + \n2\n =  +  3\n (3 + )\n2\n + \n2\n = (3 3 – 6)2\n + 4\n +  3 = 67 – 36 3\n  = 67 and  = –36   +  = 31",
                difficulty = "Medium"
            )
        )
    }
}