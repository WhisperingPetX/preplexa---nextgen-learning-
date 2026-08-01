package com.example.data.repository
import com.example.model.Question
object JeeMain2021Session1Shift2QuestionsRepository {
    fun getQuestions(testId: String): List<Question> {
        return listOf(
            Question(
                id = "${testId}_s1_sh2_q1_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Physics Q1]\\nWhen a particle executes SHM, the nature of\ngraphical representation of velocity as a \nfunction of displacement is :",
                options = listOf("circular", "elliptical", "parabolic", "straight line"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2
Solution:
For a particle executing SHM,
x = Asin(wt + p)
v = wAcos(wt+ p)
=> v^2 / (w^2 A^2) + x^2 / A^2 = 1 => equation of ellipse
between v and x
Hence option (2)""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q2_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Physics Q2]\\nTwo electrons each are fixed at a distance '2d'.\nA third charge proton placed at the midpoint is \ndisplaced slightly by a distance x (x << d)\nperpendicular to the line joining the two fixed\ncharges. Proton will execute simple harmonic\nmotion having angular frequency : (m = mass\nof charged particle)",
                options = listOf("sqrt(2q^2 / (pi e_0 m d^3))", "sqrt(pi e_0 m d^3 / (2q^2))", "sqrt(q^2 / (2 pi e_0 m d^3))", "sqrt(2 pi e_0 m d^3 / q^2)"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3
Solution:
From the given condition, we have
Fnetq = - [2Fq/q cos0]
Fnetq = - 2 . 1/(4 pi e0) q^2 / (sqrt(d^2 + x^2))^2 . x / sqrt(d^2 + x^2)
= - q^2 / (2 pi e0 (d^2 + x^2)^3/2) x
For x << d,
Fnet q = - q^2 / (2 pi e0 d^3) x
:. a = - q^2 / (2 pi e0 m d^3) x
Comparing with equation of SHM (a = -w^2 x)
:. w = sqrt(q^2 / (2 pi e0 m d^3))
Hence option (3) is correct""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q3_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Physics Q3]\\nOn the basis of kinetic theory of gases, the gas\nexerts pressure because its molecules :",
                options = listOf("continuously lose their energy till it \nreaches wall.", "are attracted by the walls of container.", "continuously stick to the walls of container.", "suffer change in momentum when impinge\non the walls of container."),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4
Solution:
From the assumption of KTG, the molecules of
gas collide with the walls and suffers
momentum change which results in force on
the wall and hence pressure.
Hence option (4) is correct""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q4_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Physics Q4]\\nA soft ferromagnetic material is placed in an\nexternal magnetic field. The magnetic domains",
                options = listOf("increase in size but no change in\norientation.", "have no relation with external magnetic\nfield.", "decrease in size and changes orientation.", "may increase or decrease in size and \nchange its orientation."),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4
Solution:
Soft ferromagnetic materials are materials
which can be easily magnetised and
demagnetised by external magnetic field. When
external field is applied, the domains experiences a net torque hence change its
orientation.
Hence option (4) is correct""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q5_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Physics Q5]\\nThe logic circuit shown above is equivalent to :",
                options = listOf("...", "...", "...", "..."),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4
Solution:
Truth table of the given gate :
A B C
0 0 0
0 1 1
1 0 0
1 1 0
Truth table of option (1)
A B C
0 0 1
0 1 1
1 0 0
1 1 1
Truth table of option (2)
A B C
0 0 1
0 1 0
1 0 1
1 1 1
Truth table of option (3)
A B C
0 0 1
0 1 0
1 0 0
1 1 0
Truth table of option (4)
A B C
0 0 0
0 1 1
1 0 0
1 1 0
Since option (1) has same truth table, hence
answer is option (4) is correct.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q6_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Physics Q6]\\nThe period of oscillation of a simple pendulum\nis T = 2pi sqrt(L/g). Measured value of 'L' is 1.0 m\nfrom meter scale having a minimum division of \n1 mm and time of one complete oscillation is \n1.95 s measured from stopwatch of 0.01 s\nresolution. The percentage error in the\ndetermination of 'g' will be :",
                options = listOf("1.13%", "1.03%", "1.33%", "1.30%"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1
Solution:
T = 2pi sqrt(l / g)
g = 4 pi^2 l / T^2
dg / g = dl / l + 2 dT / T
dg / g = (1 * 10^-3) / 1 + 2 * 0.01 / 1.95
dg / g = 0.0113 or 1.13%
option (1) is correct""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q7_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Physics Q7]\\nGiven below are two statements :\nStatement I : PN junction diodes can be used\nto function as transistor, simply by connecting\ntwo diodes, back to back, which acts as the \nbase terminal.\nStatement II : In the study of transistor, the\namplification factor b indicates ratio of the\ncollector current to the base current. In the light \nof the above statements, choose the correct \nanswer from the options given below :",
                options = listOf("Statement I is false but Statement II is true", "Both Statement I and Statement II are true", "Both Statement I and Statement II are false", "Statement I is true but Statement II is false"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1
Solution:
Back to back diode will not the make a transistor
B = ic / ib""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q8_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Physics Q8]\\nIn the given figure, a body of mass M is held\nbetween two massless springs, on a smooth\ninclined plane. The free ends of the springs are\nattached to firm supports. If each spring has\nspring constant k, the frequency of oscillation\nof given body is :",
                options = listOf("1/2pi sqrt(k/2M)", "1/2pi sqrt(2k/Mg sin a)", "1/2pi sqrt(2k/M)", "1/2pi sqrt(k/Mg sin a)"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3
Solution:
Keq = K1 + K2 = K + K = 2K
T = 2pi sqrt(m / Keq) = 2pi sqrt(m / 2K)
f = 1 / T = 1 / 2pi sqrt(2K / m)
(Option 3) is correct""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q9_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Physics Q9]\\nFigure shows a circuit that contains four \nidentical resistors with resistance R = 2.0 O, \ntwo identical inductors with inductance L = 2.0 \nmH and an ideal battery with emf E = 9 V. The \ncurrent 'i' just after the switch 'S' is closed will \nbe",
                options = listOf("2.25 A", "3.0 A", "3.37 A", "9 A"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1
Solution:
Just after the switch is closed, inductor will
behave like infinite resistance (open circuit) so
the circuit will look like
i = 9 / (R + R) = 9 / 4 = 2.25
Option (1) is correct.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q10_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Physics Q10]\\nThe de Broglie wavelength of a proton and\na-particle are equal. The ratio of their \nvelocities is :",
                options = listOf("4 : 3", "4 : 1", "4 : 2", "1 : 4"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2
Solution:
l = h / mv
lp = l_alpha
m_p v_p = m_alpha v_alpha
m_p v_p = 4m_p v_alpha (m_alpha = 4m_p)
v_p / v_alpha = 4
(Option 2) is correct""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q11_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Physics Q11]\\nIf one mole of an ideal gas at (P1, V1) is \nallowed to expand reversibly and isothermally \n(A to B) its pressure is reduced to one-half of \nthe original pressure (see figure). \nThis is followed by a constant volume cooling \ntill its pressure is reduced to one-fourth of the \ninitial value (B -> C). Then it is restored to its \ninitial state by a reversible adiabatic \ncompression \n(C to A). The net workdone by the gas is equal \nto :",
                options = listOf("RT (ln 2 - 1/(y - 1))", "- RT / (2(y - 1))", "0", "RT ln 2"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1
Solution:
A -> B = isothermal process
WAB = P1V1 ln(2V1 / V1) = P1V1 ln(2)
B -> C -> Isochoric process
WBC = 0
C -> A -> Adiabatic process
WCA = (P1/4 * 2V1 - P1V1) / (1 - y) = P1V1 / 2(1 - y) - P1V1 / (1 - y) = - P1V1 / 2(1 - y)
Wnet = WAB + WBC + WCA {P1V1 = RT}
= P1V1ln(2) + 0 - P1V1 / 2(y - 1) 
Option (1) is correct.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q12_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Physics Q12]\\nAn X-ray tube is operated at 1.24 million volt.\nThe shortest wavelength of the produced\nphoton will be :",
                options = listOf("10^-3 nm", "10^-1 nm", "10^-2 nm", "10^-4 nm"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1
Solution:
l_min = 1240 / dV (nm)
= 1240 / (1.24 * 10^6) = 10^-3 nm
Option (1) is correct.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q13_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Physics Q13]\\nWhich of the following equations represents a\ntravelling wave ?",
                options = listOf("y = Asin (15x - 2t)", "y = Ae^(-x^2) (vt + 0)", "y = Ae^x cos(wt - 0)", "y = Asinx coswt"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1
Solution:
y = F(x, t)
For travelling wave y should be linear function
of x and t and they must exist as (x +/- vt)
y = Asin(15x - 2t) -> linear function in x and t
Option (1) is correct.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q14_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Physics Q14]\\nAccording to Bohr atom model, in which of the\nfollowing transitions will the frequency be\nmaximum ?",
                options = listOf("n = 4 to n = 3", "n = 2 to n = 1", "n = 5 to n = 4", "n = 3 to n = 2"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2
Solution:
dE = 13.6 [1/n1^2 - 1/n2^2] = hv
It is maximum if n1 = 1 and n2 = 2
n = 5 ............................................ -0.544 eV
n = 4 ............................................ -0.850 eV
n = 3 ............................................ -1.511 eV
n = 2 ............................................ -3.4 eV
n = 1 ............................................ -13.6 eV
Option (2) is correct.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q15_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Physics Q15]\\nIf the source of light used in a Young's double\nslit experiment is changed from red to violet :",
                options = listOf("consecutive fringe lines will come closer.", "the central bright fringe will become a dark\nfringe.", "the fringes will become brighter.", "the intensity of minima will increase."),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1
Solution:
B = lD / d
lR > lV
BR = lR D / d and BV = lV D / d
BR > BV
Fringe pattern will shrink.
Option (1) is correct.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q16_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Physics Q16]\\nA circular hole of radius a/2 is cut out of a\ncircular disc of radius 'a' as shown in figure. \nThe centroid of the remaining circular portion \nwith respect to point 'O' will be :",
                options = listOf("1/6 a", "10/11 a", "5/6 a", "2/3 a"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3
Solution:
Let o be the uniform mass density of disc then
XCOM = (o pi a^2) a - o pi (a/2)^2 (3a/2) / (o pi a^2 - o pi (a/2)^2)
= (a - 3a/8) / (1 - 1/4) = 5a/6
Option (2) is correct.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q17_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Physics Q17]\\nZener breakdown occurs in a p-n junction\nhaving p and n both :",
                options = listOf("lightly doped and have wide depletion \nlayer.", "heavily doped and have narrow depletion\nlayer.", "lightly doped and have narrow depletion\nlayer.", "heavily doped and have wide depletion\nlayer."),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2
Solution:
Zener diode is heavily doped and have narrow
depletion layer.
Option (2) is correct.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q18_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Physics Q18]\\nMatch List-I with List-II\nList-I List-II\n(a) Source of microwave frequency (i) Radioactive decay on nucleus\n(b) Source of infrared frequency (ii) Magnetron\n(c) Source of Gamma Rays (iii) Inner shell electrons\n(d) Source of X-rays (iv) Vibration of atoms and molecules\n(v) LASER\n(vi) RC circuit\nChoose the correct answer from the options\ngiven below :",
                options = listOf("(a)-(vi), (b)-(iv), (c)-(i), (d)-(v)", "(a)-(vi), (b)-(v), (c)-(i), (d)-(iv)", "(a)-(ii), (b)-(iv), (c)-(vi), (d)-(iii)", "(a)-(ii), (b)-(iv), (c)-(i), (d)-(iii)"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4
Solution:
(a) Source of microwave frequency is magnetron.
(b) Source of infrared frequency is vibration of atoms and molecules.
(c) Source of Gamma rays is radioactive decay of nucleus
(d) Source of X-rays inner shell electron transition.
Option (4) is correct.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q19_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Physics Q19]\\nA particle is projected with velocity v0 along\nx-axis. A damping force is acting on the \nparticle which is proportional to the square of \nthe distance from the origin i.e., ma = -ax^2. \nThe distance at which the particle stops :",
                options = listOf("(3v_0^2 / 2a)^(1/2)", "(2v_0 / 3a)^(1/3)", "(2v_0^2 / 3a)^(1/2)", "(3v_0^2 / 2a)^(1/3)"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4
Solution:
F = -ax^2
ma = -ax^2
a = -ax^2 / m
v dv / dx = -ax^2 / m
integral_v0^0 v dv = integral_0^x -ax^2 / m dx
[v^2 / 2]_v0^0 = -a/m [x^3 / 3]_0^x
- v0^2 / 2 = -a x^3 / 3m
x = (3m v0^2 / 2a)^1/3
Option(4) is most suitable option as (m) is not given in any option""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q20_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Physics Q20]\\nA body weighs 49 N on a spring balance at the\nnorth pole. What will be its weight recorded on\nthe same weighing machine, if it is shifted to\nthe equator ? (Use g = GM/R^2 = 9.8 ms^-2 and \nradius of earth, R = 6400 km.]",
                options = listOf("49 N", "48.83 N", "49.83 N", "49.17 N"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2
Solution:
Weight of pole = mg = 49 N
At equator due to rotation = ge = g - Rw^2
so W = mge = m(g - Rw^2)
:. WP > We
WP = 49 N
So, We = 48.83 N. 
We < 49 N
Option (2) is correct.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q21_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Physics Q21]\\nA uniform metallic wire is elongated by 0.04 m \nwhen subjected to a linear force F. The \nelongation, if its length and diameter is doubled \nand subjected to the same force will be _____ cm.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 2
Solution:
F = Y.A. dl / l
dl = F * l / (Y.A.)
dl = F * l / (Y. pi r^2)
dl proportional to l / r^2
dl2 / dl1 = (l2 / l1) * (r1 / r2)^2
= (2) * (1/2)^2 = 1/2
dl2 = dl1 / 2 = 0.04 / 2 = 0.02 m
dl2 = 2cm
Ans.=2""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q22_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Physics Q22]\\nA cylindrical wire of radius 0.5 mm and\nconductivity 5 x 10^7 S/m is subjected to an\nelectric field of 10 mV/m. The expected value\nof current in the wire will be x^3 pi mA. The \nvalue of x is ____.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 5
Solution:
Conductivity s = 5 * 10^7 S/m
Radius r = 0.5 mm = 5 * 10^-4 m
E = 10 * 10^-3 V/m
J = sE = 10 * 10^-3 * 5 * 10^7
J = 5 * 10^5
i/A = 5 * 10^5
i = 5 * 10^5 * pi r^2
= 5 * 10^5 * pi * (5 * 10^-4)^2
= 125 pi * 10^-3 Amp
i = 125 pi mA
x = 5
Ans. 5""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q23_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Physics Q23]\\nA uniform thin bar of mass 6 kg and length 2.4 \nmeter is bent to make an equilateral hexagon. \nThe moment of inertia about an axis passing \nthrough the centre of mass and perpendicular to \nthe plane of hexagon is ____ x 10^-1 kg m^2.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 8
Solution:
6l = 2.4, l = 0.4 m
sin 60 = r/l => r = l sin 60 = l sqrt(3) / 2
MOI, I = [ m l^2 / 12 + m r^2 ] 6
= [ m l^2 / 12 + m (l sqrt(3) / 2)^2 ] 6
= 5 m l^2
= 5 * 1 * 0.16 = 0.8
I = 8 * 10^-1 kg m^2 Ans. (2)""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q24_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Physics Q24]\\nTwo solids A and B of mass 1 kg and 2 kg\nrespectively are moving with equal linear\nmomentum. The ratio of their kinetic energies\n(K.E.)A : (K.E.)B will be A/1, so the value of \nA will be ___.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 2
Solution:
Kinetic energy K = P^2 / 2m , (PA = PB)
K proportional to 1/m
KA / KB = mB / mA = 2 / 1
Ans. 2""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q25_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Physics Q25]\\nThe root mean square speed of molecules of a\ngiven mass of a gas at 27degC and 1 atmosphere\npressure is 200 ms^-1. The root mean square\nspeed of molecules of the gas at 127degC and\n2 atmosphere pressure is x/sqrt(3) ms^-1. The value\nof x will be _____.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 400
Solution:
vrms = sqrt(3RT / M)
vrms proportional to sqrt(T)
(vrms)2 / (vrms)1 = sqrt(T2 / T1) = sqrt(400 / 300) = 2 / sqrt(3)
(vrms)2 = 2 / sqrt(3) * 200 sqrt(3) = 400 m/s""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q26_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Physics Q26]\\nA point charge of +12 uC is at a distance 6 cm\nvertically above the centre of a square of side\n12 cm as shown in figure. The magnitude of the \nelectric flux through the square will be ______ \nx 10^3 Nm^2/C.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 226
Solution:
From symmetry p = 1/6 (q / e0)
= 12 * 10^-6 / (6 * 8.85 * 10^-12)
= 225.98 * 10^3 Nm^2 / s
~ 226 * 10^3 Nm^2 / C""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q27_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Physics Q27]\\nA signal of 0.1 kW is transmitted in a cable. \nThe attenuation of cable is -5 dB per km and \ncable length is 20 km. The power received at \nreceiver is 10^-x W. The value of x is ______.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 8
Solution:
Sound level decreases by 5dB every km so
sound level decreased in 20 km = 100 dB
B2 - B1 = 10 log10 (I2 / I1)
-100 = 10log10 (I2 / I1) => I1 / I2 = 10^10
I2 = 10^-10 I1 => P2 = 10^-10 P1 = 10^-8 W
x = 8 Ans. 8""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q28_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Physics Q28]\\nA series LCR circuit is designed to resonate at\nan angular frequency w0 = 10^5 rad/s. The circuit\ndraws 16 W power from 120 V source at\nresonance. The value of resistance 'R' in the\ncircuit is ___W.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 900
Solution:
At resonance
P = V^2 / R
R = V^2 / P = (120)^2 / 16 = 900 ohms""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q29_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Physics Q29]\\nTwo cars are approaching each other at an \nequal speed of 7.2 km/hr. When they see each \nother, both blow horns having frequency of 676 \nHz. The beat frequency heard by each driver \nwill be _____ Hz. [Velocity of sound in air is \n340 m/s.]",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 8
Solution:
Frequency of sound heard by car-1, which comes by reflection from car-2
f1 = f0 ((340 + 2)/(340 - 2)) * ((340 + 2)/(340 - 2)) = f0 (342/338)^2
Frequency of sound coming directly from car-2
f2 = f0 ((340 + 2)/(340 - 2))
= f1 - f2 = f0 ( (342/338)(342/338) - 1 ) = 8.09 ~ 8""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q30_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Physics Q30]\\nAn electromagnetic wave of frequency 3 GHz\nenters a dielectric medium of relative electric\npermittivity 2.25 from vacuum. The wavelength\nof this wave in that medium will be ____ x 10^-2\ncm.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 667
Solution:
l in vaccum = c / f = 3*10^8 / 3*10^9 = 0.1m
:. l in medium = 0.1 / u
Where refractive index u = sqrt(ur er)
Assuming non-magnetic material ur = 1
:. u = sqrt(2.25) = 1.5
lm = 0.1 / 1.5 m = 1/15 m = 6.67 cm
= 667 * 10^-2 cm
Ans. 667

CHEMISTRY""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q31_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Chemistry Q31]\\nWhat is the correct sequence of reagents \nused for converting nitrobenzene into \nm-dibromobenzene ?",
                options = listOf("NaNO2/HCl / KBr / H+", "Br2/Fe / Sn/HCl / NaNO2/HCl / CuBr/HBr", "Sn/HCl / KBr / Br2 / H+", "Sn/HCl / Br2 / NaNO2 / NaBr"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2
Solution:
Both are tautologies""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q32_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Chemistry Q32]\\nMost suitable salt which can be used for \nefficient clotting of blood will be :-",
                options = listOf("NaHCO3", "FeSO4", "Mg(HCO3)2", "FeCl3"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4
Solution:
P(9, 6, 9)
(x - 3)/7 = (y - 2)/5 = (z - 1)/-9 = l
x = 7l + 3
y = 5l + 2
z = -9l + 1
The mirror image is (20, b, -a -9)
Midpoint is (29/2, (b+6)/2, (-a)/2)
(29/2 - 3)/7 = ((b+6)/2 - 2)/5 = (-a/2 - 1)/-9
(23/2)/7 = (b+2)/10 = (a+2)/18
Wait, point is (a,6,9). The mirror image is (20,b,-a-9). Midpoint is ((a+20)/2, (b+6)/2, -a/2).
((a+20)/2 - 3)/7 = ((b+6)/2 - 2)/5 = (-a/2 - 1)/-9 = l
(a+14)/14 = (b+2)/10 = (a+2)/18
=> 18(a+14) = 14(a+2) => 18a + 252 = 14a + 28 => 4a = -224 => a = -56
(b+2)/10 = (-56+2)/18 = -54/18 = -3 => b+2 = -30 => b = -32
=> |a + b| = |-56 - 32| = 88""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q33_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Chemistry Q33]\\nThe correct order of the following compounds\nshowing increasing tendency towards\nnucleophilic substitution reaction is-\n(i) Chlorobenzene (ii) 2,4-Dinitrochlorobenzene (iii) 1,3,5-trinitrochlorobenzene (iv) p-nitrochlorobenzene",
                options = listOf("(iv) < (iii) < (ii) < (i)", "(iv) < (i) < (ii) < (iii)", "(iv) < (i) < (iii) < (ii)", "(i) < (iv) < (ii) < (iii)"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4
Solution:
r.(i + j + k) = 1
r.(i - 2j) = -2
point (1, 0, 2)
Equation of plane
r.(i + j + k) - 1 + l{r.(i - 2j) + 2} = 0
r.{(1 + l)i + (1 - 2l)j + k} - 1 + 2l = 0
point i + 0j + 2k = r
:. (i + 2k).{(1 + l)i + (1 - 2l)j + k} - 1 + 2l = 0
1 + l + 2 - 1 + 2l = 0
3l + 2 = 0 => l = -2/3
:. r.[(1 - 2/3)i + (1 + 4/3)j + k] = 1 - 2(-2/3)
r.[1/3 i + 7/3 j + k] = 7/3
r.[i + 7j + 3k] = 7
Ans. 3""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q34_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Chemistry Q34]\\nAccording to Bohr's atomic theory :-\n(A) Kinetic energy of electron is proportional to Z^2/n^2\n(B) The product of velocity (v) of electron and\nprincipal quantum number (n), 'vn' proportional to Z^2.\n(C) Frequency of revolution of electron in an\norbit is proportional to Z^3/n^3\n(D) Coulombic force of attraction on the\nelectron is proportional to Z^3/n^4\nChoose the most appropriate answer from the\noptions given below :",
                options = listOf("(C) Only", "(A) Only", "(A), (C) and (D) only", "(A) and (D) only"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4
Solution:
P : y = x^2 + 4 => P(h, h^2+4)
L : y = 4x - 1 => 4x - y - 1 = 0
d = |4h - (h^2+4) - 1| / sqrt(16+1) = |h^2 - 4h + 5| / sqrt(17)
d(d) / dh = (2h - 4) / sqrt(17) = 0 => h = 2
:. k = 2^2 + 4 = 8
:. Point (2, 8)""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q35_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Chemistry Q35]\\nMatch list - I and List - II.\nList-I List-II\n(a) R-C(=O)-Cl -> R-CHO (i) Br2 /NaOH\n(b) R-CH2-COOH -> R-CH(Cl)-COOH (ii) H2 / Pd-BaSO4\n(c) R-C(=O)-NH2 -> R-NH2 (iii) Zn(Hg)/Conc.HCl\n(d) R-C(=O)-CH3 -> R-CH2-CH3 (iv) Cl2 /Red P, H2O\nChoose the correct answer from the options\ngiven below :",
                options = listOf("(a)-(ii), (b)-(i), (c)-(iv), (d)-(iii)", "(a)-(iii), (b)-(iv), (c)-(i), (d)-(ii)", "(a)-(ii), (b)-(iv), (c)-(i), (d)-(iii)", "(a)-(iii), (b)-(i), (c)-(iv), (d)-(ii)"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3
Solution:
tan60 = h/y => h = y sqrt(3)
tan30 = h/(x+y) => 1/sqrt(3) = h/(x+y) => sqrt(3)h = x + y
Speed 432 km/h => 432 * (5/18) m/s = 120 m/s => 120 * 20 = 2400 m
sqrt(3)h = 2400 + h/sqrt(3)
3h = 2400 sqrt(3) + h
2h = 2400 sqrt(3)
h = 1200 sqrt(3) m""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q36_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Chemistry Q36]\\nThe calculated magnetic moments (spin only\nvalue) for species [FeCl4]^2-, [Co(C2O4)3]^3- and\nMnO4^2- respectively are :",
                options = listOf("5.82, 0 and 0 BM", "4.90, 0 and 1.73 BM", "5.92, 4.90 and 0 BM", "4.90, 0 and 2.83 BM"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2
Solution:
n+1C2 + 2 (2C2 + 3C2 + 4C2 + ...... + nC2)
= n+1C2 + 2(n+1C3)
= n+1C2 + n+1C3 + n+1C3
= n+2C3 + n+1C3
= n(n+1)(n+2)/6 + (n-1)n(n+1)/6
= n(n+1)/6 [n+2 + n-1] = n(n+1)(2n+1)/6""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q37_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Chemistry Q37]\\nMatch List-I with List-II :\nList-I (Salt) List-II (Flame colour wavelength)\n(a) LiCl (i) 455.5 nm\n(b) NaCl (ii) 670.8 nm\n(c) RbCl (iii) 780.0 nm\n(d) CsCl (iv) 589.2 nm\nChoose the correct answer from the options\ngiven below :",
                options = listOf("(a)-(iv), (b)-(ii), (c)-(iii), (d)-(i)", "(a)-(ii), (b)-(i), (c)-(iv), (d)-(iii)", "(a)-(i), (b)-(iv), (c)-(ii), (d)-(iii)", "(a)-(ii), (b)-(iv), (c)-(iii), (d)-(i)"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4
Solution:
f'(x) = 55 , x < -5
f'(x) = 6x^2 - 6x - 120 = 6(x^2 - x - 20) = 6(x-5)(x+4) , -5 < x < 4
f'(x) = 6x^2 - 72x - 336 = 6(x^2 - 12x - 56) (Wait, 2x^3 - 3x^2 - 36x - 336 => 6x^2 - 6x - 36 = 6(x-3)(x+2)) , x > 4
f(x) is increasing in 
x in (-inf, -4) U (4, inf)""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q38_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Chemistry Q38]\\nWhich one of the following carbonyl compounds\ncannot be prepared by addition of water on an \nalkyne in the presence of HgSO4 and H2SO4 ?",
                options = listOf("CH3-C(=O)-H", "Ph-C(=O)-CH3", "CH3-CH2-C(=O)-H", "CH3-C(=O)-CH2CH3"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3
Solution:
f(x)f''(x) - (f'(x))^2 = 0
d/dx [f'(x) / f(x)] = 0
ln (f'(x)) = ln f(x) + lnc
f'(x) = cf(x)
ln f(x) = cx + k1
f(x) = ke^cx
f(0) = 1 = k
f'(0) = c = 2
f(x) = e^2x
f(1) = e^2 in (6, 9)""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q39_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Chemistry Q39]\\nIn polymer Buna-S: 'S' stands for :-",
                options = listOf("Sulphonation", "Strength", "Sulphur", "Styrene"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4
Solution:
m = -1/sqrt(3) , c = 2
(1) c = a sqrt(1+m^2) => 2 = sqrt(7) sqrt(1+1/3) (incorrect)
(2) c = a/m => 2 = (1/6sqrt(3)) / (-1/sqrt(3)) = -1/6 (incorrect)
(3) c = sqrt(a^2 m^2 - b^2) => 2 = sqrt(9/2 * 1/3 - 1/2) = 1 (incorrect)
(4) c = sqrt(a^2 m^2 + b^2) => 2 = sqrt(9 * 1/3 + 1) = 2 (correct)""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q40_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Chemistry Q40]\\nWhich of the following reagent is suitable for \nthe preparation of the product in the above\nreaction ? (Ketone to alkane keeping double bond)",
                options = listOf("NaBH4", "NH2-NH2/ C2H5ONa", "Ni/H2", "Red P + Cl2"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2
Solution:
integral_1^3 [x^2 - 2x - 2] dx
= integral_1^3 [(x-1)^2 - 3] dx
= integral_1^sqrt(2) 1.dx + integral_sqrt(2)^sqrt(3) 2.dx + integral_sqrt(3)^2 3.dx - 6
= sqrt(2) - 1 + 2(sqrt(3) - sqrt(2)) + 3(2 - sqrt(3)) - 6
= -sqrt(2) - sqrt(3) - 1""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q41_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Chemistry Q41]\\nMatch List-I and List-II.\nList-I List-II\n(a) Valium (i) Antifertility drug\n(b) Morphine (ii) Pernicious anaemia\n(c) Norethindrone (iii) Analgesic\n(d) Vitamin B12 (iv) Tranquilizer",
                options = listOf("(a)-(iv), (b)-(iii), (c)-(ii), (d)-(i)", "(a)-(iv), (b)-(iii), (c)-(i), (d)-(ii)", "(a)-(ii), (b)-(iv), (c)-(iii), (d)-(i)", "(a)-(i), (b)-(iii), (c)-(iv), (d)-(ii)"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2
Solution:
Let 1/4 sin^-1(sqrt(63)/8) = 0
sin 4(0) = sqrt(63)/8
cos 4(0) = 1/8
2cos^2 2(0) - 1 = 1/8
cos^2 2(0) = 9/16
cos 2(0) = 3/4
2cos^2(0) - 1 = 3/4
cos^2(0) = 7/8
cos(0) = sqrt(7) / 2sqrt(2)
tan(0) = 1 / sqrt(7)""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q42_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Chemistry Q42]\\nMatch List-I with List-II.\nList-I (Metal) List-II (Ores)\n(a) Aluminium (i) Siderite\n(b) Iron (ii) Calamine\n(c) Copper (iii) Kaolinite\n(d) Zinc (iv) Malachite\nChoose the correct answer from the options\ngiven below :",
                options = listOf("(a)-(iv), (b)-(iii), (c)-(ii), (d)-(i)", "(a)-(ii), (b)-(iv), (c)-(i), (d)-(iii)", "(a)-(i), (b)-(ii), (c)-(iii), (d)-(iv)", "(a)-(iii), (b)-(i), (c)-(iv), (d)-(ii)"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4
Solution:
~(~P ^ (p v q))
p v (~ p ^ ~q)
(p v ~ p) ^ (p v ~ q)
t ^ (p v ~q)
p v ~q""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q43_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Chemistry Q43]\\nWhich one of the following compounds is \nnonaromatic ?",
                options = listOf("cyclobutadiene", "furan", "cyclopropenyl cation", "anthracene"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1
Solution:
a + b + c = 2 .....(1)
and (dy/dx)_(0,0) = 1
2ax + b |_(0, 0) = 1 => b = 1
Curve passes through origin 
So, c = 0
and a = 1""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q44_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Chemistry Q44]\\nWhat is the correct order of the following\nelements with respect to their density ?",
                options = listOf("Cr < Zn < Co < Cu < Fe", "Zn < Cu < Co < Fe < Cr", "Zn < Cr < Fe < Co < Cu", "Cr < Fe < Co < Cu < Zn"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3
Solution:
Required area = 2 integral_0^sqrt(3) (2x^2 + 9 - 5x^2)dx
= 2 [9x - x^3]_0^sqrt(3)
= 2[9 sqrt(3) - 3 sqrt(3)] = 12 sqrt(3)""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q45_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Chemistry Q45]\\nGiven below are two statements :-\nStatement I : The value of the parameter\n\"Biochemical Oxygen Demand (BOD)\" is\nimportant for survival of aquatic life.\nStatement II : The optimum value of BOD is\n6.5 ppm. In the light of the above statements, \nchoose the most appropriate answer from the \noptions given below :",
                options = listOf("Statement I is false but Statement II is true", "Both Statement I and Statement II are true", "Statement I is true but Statement II is false", "Both Statement I and Statement II are false"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3
Solution:
dy/dx + y/x = bx^3
I.F. = e^(integral 1/x dx) = x
So, solution of D.E. is given by 
y.x = integral b.x^4 dx + c
y = b.x^4 / 5 + c/x
Passes through (1, 2)
2 = b/5 + c ..... (1)
integral_1^2 f(x)dx = 62/5
[b.x^5 / 25 + c ln x]_1^2 = 62/5
c ln 2 + 31b/25 = 62/5 ..... (2)
By equation (1) & (2)
c = 0 and b = 10""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q46_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Chemistry Q46]\\nThe incorrect statement among the following is",
                options = listOf("VOSO4 is a reducing agent", "Cr2O3 is an amphoteric oxide", "RuO4 is an oxidizing agent", "Red colour of ruby is due to the presence \nof Co3+"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4
Solution:
f'(x) = f'(2 -x)
f(x) = -f(2 - x) + c
put x = 0
f'(0) = - f'(2) + c => c = f(0) + f(2) = 1 + e^2
so, f(x) + f(2 - x) = 1 + e^2
I = integral_0^2 f(x)dx
I = integral_0^2 f(2 - x)dx
2I = integral_0^2 (f(x) + f(2 - x))dx
2I = integral_0^2 (1 + e^2) dx = (1+e^2) * 2
I = 1 + e^2""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q47_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Chemistry Q47]\\nThe correct shape and I-I-I bond angles\nrespectively in I3- ion are :-",
                options = listOf("Distorted trigonal planar; 135deg and 90deg", "T-shaped; 180deg and 90deg", "Trigonal planar; 120deg", "Linear; 180deg"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4
Solution:
Let A^T = A and B^T = -B
C = A^2 B^2 - B^2 A^2
C^T = (A^2 B^2)^T - (B^2 A^2)^T
= (B^2)^T (A^2)^T - (A^2)^T (B^2)^T
= B^2 A^2 - A^2 B^2
C^T = -C
C is skew symmetric
So det(C) = 0
so system have infinite solutions""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q48_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Chemistry Q48]\\nGiven below are two statements : one is \nlabelled as Assertion A and the other is labelled \nas Reason R.\nAssertion A : Hydrogen is the most abundant\nelement in the Universe, but it is not the most\nabundant gas in the troposphere.\nReason R : Hydrogen is the lightest element. In \nthe light of the above statements, choose the\ncorrect answer from the options given below :",
                options = listOf("A is true but R is false", "Both A and R are true and R is the correct\nexplanation of A", "A is false but R is true", "Both A and R are true but R is NOT the\ncorrect explanation of A"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2
Solution:
(a + 2 + a)/3 = 10/3 => 2a + 2 = 10 => a = 4
(c + b + b)/3 = 7/3 => c + 2b = 7
also 2b = a + c => 2b = 4 + c => c = 2b - 4
2b - 4 + 2b = 7 => 4b = 11 => b = 11/4
now 4x^2 + 11/4 x + 1 = 0 => 16x^2 + 11x + 4 = 0
a^2 + b^2 - ab = (a + b)^2 - 3ab
= (-11/16)^2 - 3(4/16) = 121/256 - 48/256 = 73/256
Wait, the solution says:
= (-11/16)^2 - 3(1/4)
= 121/256 - 3/4 = 121/256 - 192/256 = -71/256""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q49_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Chemistry Q49]\\nThe diazonium salt of which of the following\ncompounds will form a coloured dye on\nreaction with b-Naphthol in NaOH ?",
                options = listOf("aniline", "N-methylaniline", "p-toluidine", "benzylamine"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3
Solution:
D = |1 -2 0; 1 -1 k; 0 k 4| = 1(-4-k^2) + 2(4) = 4 - k^2
so, A is correct and B,C, E are incorrect 
If k = 2
D1 = |1 -2 0; -2 -1 2; 6 2 4| = 1(-4-4) + 2(-8-12) = -8 - 40 = -48 != 0
So no solution 
D is correct""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q50_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Chemistry Q50]\\nThe correct set from the following in which \nboth pairs are in correct order of melting point \nis :",
                options = listOf("LiF > LiCl ; MgO > NaCl", "LiCl > LiF ; NaCl > MgO", "LiF > LiCl ; NaCl > MgO", "LiCl > LiF ; MgO > NaCl"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1
Solution:
Total subsets = 2^5 = 32
Probability = 5C2 * 3^3 / (32 * 32) = 10 * 27 / 1024 = 270 / 1024 = 135 / 512""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q51_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Chemistry Q51]\\nThe total number of amines among the\nfollowing which can be synthesized by Gabriel\nsynthesis is _______.",
                options = listOf("i-butylamine", "ethylamine", "benzylamine", "aniline"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3
Solution:
Official Answer by NTA [12]""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q52_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Chemistry Q52]\\nAmong the following allotropic forms of\nsulphur, the number of allotropic forms, which\nwill show paramagnetism is ________.\n(A) a-sulphur (B) b-sulphur\n(C) S2-form (4) None of these",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 1
Solution:
(x - l)/1 = (y - 1/2)/1/2 = (z - 0)/-1/2
x - 0 = (y + 2l)/1 = (z - l)/1
Shortest distance = |(a2 - a1).(b1 x b2)| / |b1 x b2|
b1 x b2 = |i j k; 1 1/2 -1/2; 1 1 1| = i(1) - j(3/2) + k(1/2) = i - 3/2 j + 1/2 k
|b1 x b2| = sqrt(1 + 9/4 + 1/4) = sqrt(14)/2
|(a2 - a1).(b1 x b2)| = |(-l i - (2l + 1/2)j + l k) . (i - 3/2 j + 1/2 k)|
= |-l + 3l + 3/4 + l/2| = |5l/2 + 3/4|
Wait, the solution says:
= |-l i + (-2l + 1/2)j + l k| . (2i - 3j + k)/sqrt(14)
= |-2l + 6l - 3/2 + l| / sqrt(14) = |5l - 3/2| / sqrt(14)
= sqrt(7) / 2sqrt(2) = sqrt(14) / 4
|5l - 3/2| / sqrt(14) = sqrt(14)/4 => |5l - 3/2| = 14/4 = 7/2
5l = 3/2 +/- 7/2 = 5, -2
l = 1, -2/5""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q53_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Chemistry Q53]\\nThe formula of a gaseous hydrocarbon which\nrequires 6 times of its own volume of O2 for\ncomplete oxidation and produces 4 times its\nown volume of CO2 is CxHy. The value of y is\n_______.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 8
Solution:
a + b + c = 2 (Wait, a+a=1=>a=1/2. b+B=2)
f(x) + f(1/x) = x(b+B) + (b+B) * 1/x = 2x + 2/x = 2(x + 1/x)
So f(x) + f(1/x) / (x + 1/x) = 2""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q54_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Chemistry Q54]\\nThe volume occupied by 4.75 g of acetylene\ngas at 50degC and 740 mmHg pressure is _____ \nL. (Rounded off to the nearest integer) [Given \nR = 0.0826 L atm K-1 mol-1]",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 5
Solution:
Let point is (h, k)
So, sqrt((h - 5)^2 + k^2) = 3 sqrt((h + 5)^2 + k^2)
8h^2 + 8k^2 + 100h + 200 = 0
h^2 + k^2 + 25/2 h + 25 = 0
r^2 = (25/4)^2 - 25
4r^2 = 25^2 / 4 - 100 = 625/4 - 100 = 225/4 = 56.25
After round of 4r^2 = 56""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q55_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Chemistry Q55]\\nC6H6 freezes at 5.5degC. The temperature at \nwhich a solution 10 g of C4H10 in 200 g of \nC6H6 freeze is _______ degC. (The molal freezing \npoint depression constant of C6H6 is 5.12degC/m.)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 1
Solution:
Official Answer by NTA [1225]""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q56_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Chemistry Q56]\\nThe magnitude of the change in oxidising\npower of the MnO4^- / Mn^2+ couple is x x 10^-4\nV, if the H+ concentration is decreased from 1 \nM to 10^-4 M at 25degC. (Assume concentration of\nMnO4^- and Mn^2+ to be same on change in H+\nconcentration). The value of x is _______.\n(Rounded off to the nearest integer) [Given : \n2.303RT / F = 0.059 ]",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 3776
Solution:
var = sum x^2 / n - (sum x / n)^2
= (9 + k^2)/10 - ((9+k)/10)^2 < 10
90 + 10k^2 - 81 - k^2 - 18k < 1000
9k^2 - 18k - 991 < 0
k^2 - 2k < 991/9 => (k-1)^2 < 1000/9
-sqrt(1000)/3 < k - 1 < sqrt(1000)/3
-31.6/3 < k - 1 < 31.6/3
-10.5 < k - 1 < 10.5
k < 11.5
Maximum value of k is 11""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q57_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Chemistry Q57]\\nThe solubility product of PbI2 is 8.0 x 10^-9. The\nsolubility of lead iodide in 0.1 molar solution of \nlead nitrate is x x 10^-6 mol/L. The value of x is \n__________. (Rounded off to the nearest\ninteger) [Given : sqrt(2) = 1.41]",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 141
Solution:
a(r^4 - 1) / (r - 1) = 65/12
1/a (1/r^4 - 1) / (1/r - 1) = 65/18 => 1/a * (1 - r^4) / r^3(1 - r) = 65/18 => 1/ar^3 * (r^4-1)/(r-1) = 65/18
Divide them: a^2 r^3 = 18/12 = 3/2
and a^3 r^3 = 1 => ar = 1
So a(1/a^3) = 3/2 => 1/a^2 = 3/2 => a^2 = 2/3?
No, a^2 r^3 = a^2 r^2 * r = r = 3/2
=> a = 2/3
So third term = ar^2 = (2/3) * (9/4) = 3/2
2a = 3""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q58_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Chemistry Q58]\\nSucrose hydrolyses in acid solution into\nglucose and fructose following first order rate\nlaw with a half-life of 3.33 h at 25degC. After 9 h, \nthe fraction of sucrose remaining is f. The value \nof log10(1/f) is _______ x 10^-2. (Rounded off to \nthe nearest integer) [Assume : ln 10 = 2.303, ln \n2 = 0.693]",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 81
Solution:
If group C has one student then number of groups 10C1[2^9 - 2] = 5100
If group C has two students then number of groups 10C2[2^8 - 2] = 11430
If group C has three students then number of groups = 10C3 * [2^7 - 2] = 15120
So total groups = 31650""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q59_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Chemistry Q59]\\n1.86 g of aniline completely reacts to form\nacetanilide. 10% of the product is lost during\npurification. Amount of acetanilide obtained\nafter purification (in g) is _______ x 10^-2.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 243
Solution:
k = (-1 + i sqrt(3))^21 / (1-i)^24 + (1 + i sqrt(3))^21 / (1+i)^24
= 2^21(w)^21 / (1-i)^24 + 2^21(-w^2)^21 / (1+i)^24
= 2^21 / (-2i)^12 + 2^21 / (2i)^12
= 2^21 / 2^12 + 2^21 / 2^12 = 2^9 + 2^9 = 2^10 = 1024 ?
Wait, solution says: K = 1/512 [e^(i(14pi+6pi)) + e^(i(7pi-6pi))]
K = 1/512 [1 + (-1)] = 0
n = [|k|] = 0
sum_{j=0}^5 (j+5)^2 - sum_{j=0}^5 (j+5)
= sum (j^2 + 10j + 25 - j - 5) = sum (j^2 + 9j + 20)
= 55 + 9(15) + 20(6) = 55 + 135 + 120 = 310""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q60_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Chemistry Q60]\\nAssuming ideal behaviour, the magnitude of\nlog K for the following reaction at 25degC is\nx x 10^-1. The value of x is ____. (Integer answer)\n3HC = CH(g) <=> C6H6(l)\n[Given: dfG^o (HC = CH) = -2.04 x 10^5 J mol^-1;\ndfG^o (C6H6) = -1.24 x 10^5 J mol^-1; \nR = 8.314 J K^-1 mol^-1]",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 855
Solution:
Case-I x <= 5
(x + 1)^2 - (x - 5) = 27/4
x^2 + 2x + 1 - x + 5 = 27/4 => x^2 + x + 6 - 27/4 = 0 => x^2 + x - 3/4 = 0
=> 4x^2 + 4x - 3 = 0 => (2x + 3)(2x - 1) = 0 => x = 1/2, -3/2
Case-II x > 5
(x + 1)^2 + (x - 5) = 27/4
x^2 + 2x + 1 + x - 5 = 27/4 => x^2 + 3x - 4 - 27/4 = 0 => x^2 + 3x - 43/4 = 0 => 4x^2 + 12x - 43 = 0
x = (-12 +/- sqrt(144 + 688))/8 = (-12 +/- sqrt(832))/8 = (-3 +/- sqrt(52))/2
sqrt(52) ~ 7.2 => (-3 + 7.2)/2 = 2.1 < 5 (rejected)
So, the equation have two real root""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q61_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Mathematics Q61]\\nFor the statements p and q, consider the \nfollowing compound statements :\n(a) (~q ^ (p -> q)) -> ~p\n(b) ((p v q) ^ ~p) -> q\nThen which of the following statements is \ncorrect?",
                options = listOf("(a) and (b) both are not tautologies.", "(a) and (b) both are tautologies.", "(a) is a tautology but not (b).", "(b) is a tautology but not (a)."),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q62_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Mathematics Q62]\\nLet a, b in R. If the mirror image of the point \nP(a, 6, 9) with respect to the line\n(x - 3)/7 = (y - 2)/5 = (z - 1)/(-9) is (20, b, -a - 9), then \n|a + b| is equal to :",
                options = listOf("88", "86", "84", "90"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q63_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Mathematics Q63]\\nThe vector equation of the plane passing \nthrough the intersection of the planes \nr.(i + j + k) = 1 and r.(i - 2j) = -2, and the \npoint (1, 0, 2) is :",
                options = listOf("r.(i + 7j + 3k) = 7/3", "r.(3i + 7j + 3k) = 7", "r.(i + 7j + 3k) = 7", "r.(i - 7j + 3k) = 7/3"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q64_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Mathematics Q64]\\nIf P is a point on the parabola y = x^2 + 4 which\nis closest to the straight line y = 4x - 1, then the\nco-ordinates of P are :",
                options = listOf("(3, 13)", "(1, 5)", "(-2, 8)", "(2, 8)"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q65_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Mathematics Q65]\\nThe angle of elevation of a jet plane from a \npoint A on the ground is 60deg. After a flight of\n20 seconds at the speed of 432 km/hour, the \nangle of elevation changes to 30deg. If the jet \nplane is flying at a constant height, then its \nheight is :\n(1) 1800 sqrt(3) m (2) 3600 sqrt(3) m\n(3) 2400 sqrt(3) m (4) 1200 sqrt(3) m",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 4
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q66_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Mathematics Q66]\\nIf n >= 2 is a positive integer, then the sum of the\nseries n+1C2 + 2(2C2 + 3C2 + 4C2 +....+ nC2) is:",
                options = listOf("n(n-1)(2n+1)/6", "n(n+1)(2n+1)/6", "n(2n+1)(3n+1)/6", "n(n+1)^2(n+2)/12"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q67_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Mathematics Q67]\\nLet f : R -> R be defined as,\nf(x) = { -55x, x < -5\n2x^3 - 3x^2 - 120x, -5 <= x <= 4\n2x^3 - 3x^2 - 36x - 336, x > 4\nLet A = {x in R : f is increasing}. Then A is \nequal to :",
                options = listOf("(-inf, -5) U (4, inf)", "(-5, inf)", "(-inf, -5) U (-4, inf)", "(-5, -4) U (4, inf)"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q68_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Mathematics Q68]\\nLet f be a twice differentiable function defined\non R such that f(0) = 1, f '(0) = 2 and f '(x) != 0 \nfor all x in R. If det([f(x) f'(x); f'(x) f''(x)]) = 0 for all \nx in R, then the value of f(1) lies in the interval:\n(1) (9, 12) (2) (6, 9)\n(3) (0, 3) (4) (3,6)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 2
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q69_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Mathematics Q69]\\nFor which of the following curves, the line\nx+ sqrt(3) y = 2sqrt(3) is the tangent at the point\n(3sqrt(3)/2, 1/2) ?\n(1) x^2 + y^2 = 7 (2) y^2 = 1/(6sqrt(3)) x\n(3) 2x^2 - 18y^2 = 9 (4) x^2 + 9y^2 = 9",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 4
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q70_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Mathematics Q70]\\nThe value of the integral, integral_1^3 [x^2 - 2x - 2] dx\nwhere [x] denotes the greatest integer less than\nor equal to x, is :\n(1) -sqrt(2) - sqrt(3) + 1 (2) -sqrt(2) - sqrt(3) - 1\n(3) -5 (4) -4",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 2
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q71_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Mathematics Q71]\\nA possible value of tan(1/4 sin^-1(sqrt(63)/8)) is\n(1) 1/sqrt(7) (2) 2sqrt(2) - 1\n(3) sqrt(7) - 1 (4) 1/(2sqrt(2))",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 1
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q72_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Mathematics Q72]\\nThe negative of the statement ~p ^ (p v q) is",
                options = listOf("~p v q", "p v ~q", "~p ^ q", "p ^ ~q"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q73_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Mathematics Q73]\\nIf the curve y = ax^2 + bx + c, x in R, passes \nthrough the point (1, 2) and the tangent line to \nthis curve at origin is y = x, then the possible \nvalues of a, b, c are :",
                options = listOf("a = 1/2, b = 1/2, c = 1", "a = 1, b = 0, c = 1", "a = 1, b = 1, c = 0", "a = -1, b = 1, c = 1"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q74_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Mathematics Q74]\\nThe area of the region :\nR = {(x, y) : 5x^2 <= y <= 2x^2 + 9} is :\n(1) 11sqrt(3) square units (2) 12sqrt(3) square units\n(3) 9sqrt(3) square units (4) 6sqrt(3) square units",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 4
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q75_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Mathematics Q75]\\nIf a curve y = f(x) passes through the point \n(1, 2) and satisfies x(dy/dx) + y = bx^4, then for \nwhat value of b, integral_1^2 f(x) dx = 62/5 ?",
                options = listOf("5", "10", "62/5", "31/5"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q76_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Mathematics Q76]\\nLet f(x) be a differentiable function defined \non [0, 2] such that f '(x) = f '(2 - x) for all \nx in (0, 2), f(0) = 1 and f(2) = e^2. Then the value \nof integral_0^2 f(x) dx is :\n(1) 1 - e^2 (2) 1 + e^2\n(3) 2(1 - e^2) (4) 2(1 + e^2)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 2
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q77_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Mathematics Q77]\\nLet A and B be 3 x 3 real matrices such that A\nis symmetric matrix and B is skew-symmetric\nmatrix. Then the system of linear equations\n(A^2B^2 - B^2A^2)X = O, where X is a 3 x 1 \ncolumn matrix of unknown variables and O is a\n3 x l null matrix, has :",
                options = listOf("no solution", "exactly two solutions", "infinitely many solutions", "a unique solution"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q78_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Mathematics Q78]\\nLet a, b, c be in arithmetic progression. Let the\ncentroid of the triangle with vertices (a, c),\n(2, b) and (a, b) be (10/3, 7/3). If a, b are the \nroots of the equation ax^2 + bx + 1 = 0, then the \nvalue of a^2 + b^2 - ab is :",
                options = listOf("71/256", "69/256", "-69/256", "-71/256"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q79_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Mathematics Q79]\\nFor the system of linear equations :\nx - 2y = 1, x - y + kz = -2, ky + 4z = 6, k in R,\nconsider the following statements :\n(A) The system has unique solution if k != 2,\nk != -2.\n(B) The system has unique solution if k = -2.\n(C) The system has unique solution if k = 2.\n(D) The system has no-solution if k = 2.\n(E) The system has infinite number of solutions\nif k != -2.\nWhich of the following statements are correct ?",
                options = listOf("(C) and (D) only", "(B) and (E) only", "(A) and (E) only", "(A) and (D) only"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q80_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Mathematics Q80]\\nThe probability that two randomly selected \nsubsets of the set {1, 2, 3, 4, 5} have exactly \ntwo elements in their intersection, is :",
                options = listOf("65/2^7", "65/2^8", "135/2^9", "35/2^7"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q81_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Mathematics Q81]\\nFor integers n and r, \nlet (n r) = nCr if n >= r >= 0, else 0.\nThe maximum value of k for which the sum\nsum_{i=0}^k (10 i) (15 k-i) + sum_{i=0}^{k+1} (12 i) (13 k+1-i) exists, is \nequal to _______.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: BONUS\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q82_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Mathematics Q82]\\nLet a be an integer. If the shortest distance\nbetween the lines x - a = 2y - 1 = -2z and\nx = y + 2a = z - a is sqrt(7)/(2sqrt(2)), then the value of |a| \nis _______.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 1
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q83_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Mathematics Q83]\\nIf a + a = 1, b + B = 2 and \naf(x) + a f(1/x) = bx + B/x, x != 0, then the value of \nexpression (f(x) + f(1/x)) / (x + 1/x) is _______.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 2
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q84_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Mathematics Q84]\\nLet a point P be such that its distance from the \npoint (5, 0) is thrice the distance of P from the \npoint (- 5, 0). If the locus of the point P is a \ncircle of radius r, then 4r^2 is equal to ________.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 56
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q85_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Mathematics Q85]\\nIf the area of the triangle formed by the positive\nx-axis, the normal and the tangent to the circle\n(x - 2)^2 + (y - 3)^2 = 25 at the point (5, 7) is A,\nthen 24A is equal to_______.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 1225
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q86_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Mathematics Q86]\\nIf the variance of 10 natural numbers 1, 1, \n1, ...., 1, k is less than 10, then the maximum \npossible value of k is _______.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 11
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q87_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Mathematics Q87]\\nThe sum of first four terms of a geometric\nprogression (G.P.) is 65/12 and the sum of their\nrespective reciprocals is 65/18. If the product of \nfirst three terms of the G.P. is 1, and the third \nterm is a, then 2a is _______.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 3
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q88_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Mathematics Q88]\\nThe students S1, S2, ..... , S10 are to be divided \ninto 3 groups A, B and C such that each group \nhas at least one student and the group C has at \nmost 3 students. Then the total number of\npossibilities of forming such groups is _____.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 31650
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q89_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Mathematics Q89]\\nLet i = sqrt(-1). If k = ( (-1+i sqrt(3))^21 / (1-i)^24 ) + ( (1+i sqrt(3))^21 / (1+i)^24 ), \nand n = [|k|] be the greatest integral part of |k|. \nThen sum_{j=0}^{n+5} (j+5)^2 - sum_{j=0}^{n+5} (j+5) is equal to \n_______.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 310
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh2_q90_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 2 - Mathematics Q90]\\nThe number of the real roots of the equation\n(x + 1)^2 + |x - 5| = 27/4 is ________.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 2
Solution:
""",
                difficulty = "Medium"
            )
        )
    }
}