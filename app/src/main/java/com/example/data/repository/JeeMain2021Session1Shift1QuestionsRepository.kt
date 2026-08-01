package com.example.data.repository
import com.example.model.Question
object JeeMain2021Session1Shift1QuestionsRepository {
    fun getQuestions(testId: String): List<Question> {
        return listOf(
            Question(
                id = "${testId}_s1_sh1_q1_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Physics Q1]\\nn mole a perfect gas undergoes a cyclic process \nABCA (see figure) consisting of the following \nprocesses.\nA ->B : Isothermal expansion at temperature\nT so that the volume is doubled from\nV1 to V2 = 2V1 and pressure changes\nfrom P1 to P2\nB -> C : Isobaric compression at pressure P2\nto initial volume V1. \nC -> A : Isochoric change leading to change\nof pressure from P2 to P1. \nTotal workdone in the complete cycle ABCA\nis :",
                options = listOf("0", "nRT (In2 + 1/2)", "nRTIn2", "nRT (In2 - 1/2)"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4
Solution:
WIsothermal = nRTIn(V2/V1)
WIsobaric = PΔV = nΔT 
WIsochoric = 0 
W1= 1nRT In(V/2V) = nRT In2
W2 = nR (T/2 - T) = -nR T/2
W3 = 0
=> Wnet = W1 + W2 + W3 
=> Wnet = nRT (In2 - 1/2)""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q2_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Physics Q2]\\nThe focal length f is related to the radius of\ncurvature r of the spherical convex mirror by:",
                options = listOf("f = + 1/2 r", "f = -r", "f = - 1/2 r", "f = r"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1
Solution:
For convex mirror, focus is behind the mirror.
f = + r/2""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q3_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Physics Q3]\\nIn a Young's double slit experiment, the width \nof the one of the slit is three times the other slit. \nThe amplitude of the light coming from a slit is \nproportional to the slit-width. Find the ratio of \nthe maximum to the minimum intensity in the \ninterference pattern.",
                options = listOf("1 : 4", "3 : 1", "4 : 1", "2 : 1"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3
Solution:
Amplitude ∝ Width of slit
=> A2 = 3A1
Imax / Imin = (|I1 + I2| / |I1 - I2|)^2
Intensity I ∝ A^2
=> Imax / Imin = ((A1 + A2) / |A1 - A2|)^2 = ((A1 + 3A1) / |A1 - 3A1|)^2
= (4A1 / 2A1)^2 = 4 : 1""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q4_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Physics Q4]\\nTwo stars of masses m and 2m at a distance d \nrotate about their common centre of mass in \nfree space. The period of revolution is :",
                options = listOf("1/2pi sqrt(d^3 / 3Gm)", "2pi sqrt(d^3 / 3Gm)", "1/2pi sqrt(3Gm / d^3)", "2pi sqrt(3Gm / d^3)"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2
Solution:
F = G(2m)m / d^2 = (2m)ω^2(d/3)
Gm / d^2 = ω^2 d/3
=> ω^2 = 3Gm / d^3 => ω = sqrt(3Gm / d^3)
=> T = 2pi / ω = 2pi sqrt(d^3 / 3Gm)""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q5_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Physics Q5]\\nA current through a wire depends on time as\ni = a0 t + bt^2 where a0 = 20 A/s and b = 8 As^-2.\nFind the charge crossed through a section of the \nwire in 15 s.",
                options = listOf("2250 C", "11250 C", "2100 C", "260 C"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2
Solution:
i = 20t + 8t^2
i = dq / dt => q = integral idt
=> q = integral_0^15 (20t + 8t^2)dt
q = [20t^2 / 2 + 8t^3 / 3]_0^15
q = 10 * (15)^2 + 8(15)^3 / 3
q = 2250 + 9000
q = 11250 C""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q6_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Physics Q6]\\nMoment of inertia (M.I.) of four bodies, having \nsame mass and radius, are reported as ;\nI1 = M.I. of thin circular ring about its diameter.\nI2 = M.I. of circular disc about an axis\nperpendicular to the disc and going through the \ncentre,\nI3 = M.I. of solid cylinder about its axis and\nI4 = M.I. of solid sphere about its diameter.\nThen :",
                options = listOf("I1 + I3 < I2 + I4", "I1 + I2 = I3 + 2/5 I4", "I1 = I2 = I3 > I4", "I1 = I2 = I3 < I4"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3
Solution:
Ring I1 = MR^2 / 2 about diameter 
Disc I2 = MR^2 / 2
Solid cylinder I3 = MR^2 / 2
solid sphere I4 = 2/5 MR^2
I1 = I2 = I3 > I4""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q7_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Physics Q7]\\nGiven below are two statements :\nStatement-I : Two photons having equal linear \nmomenta have equal wavelengths.\nStatement-II : If the wavelength of photon is\ndecreased, then the momentum and energy of a \nphoton will also decrease.\nIn the light of the above statements, choose the \ncorrect answer from the options given below.",
                options = listOf("Both Statement I and Statement II are true", "Statement I is false but Statement II is true", "Both Statement I and Statement II are false", "Statement I is true but Statement II is false"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4
Solution:
If linear momentum are equal then wavelength also equal
P = h / l , E = hc / l
On decreasing wavelength, momentum and energy of photon increases.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q8_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Physics Q8]\\nIn the given figure, a mass M is attached to a\nhorizontal spring which is fixed on one side to \na rigid support. The spring constant of the\nspring is k. The mass oscillates on a frictionless \nsurface with time period T and amplitude A. \nWhen the mass is in equilibrium position, as \nshown in the figure, another mass m is gently \nfixed upon it. The new amplitude of oscillation \nwill be :",
                options = listOf("A sqrt(M / (M+m))", "A sqrt((M+m) / M)", "A sqrt(M / (M+m))", "A sqrt((M-m) / M)"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2
Solution:
Momentum of system remains conserved.
pi = pf
MAω = (m + M) A'ω'
MA sqrt(k / M) = (m + M) A' sqrt(k / (m + M))
A' = A sqrt(M / (m + M))""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q9_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Physics Q9]\\nIf Y, K and n are the values of Young's\nmodulus, bulk modulus and modulus of rigidity \nof any material respectively. Choose the correct \nrelation for these parameters.",
                options = listOf("Y = 9Kn / (3K - n) N/m^2", "n = 3YK / (9K + Y) N/m^2", "Y = 9Kn / (2n + 3K) N/m^2", "K = Yn / (9n - 3Y) N/m^2"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4
Solution:
Y- Younge modulus, K- Bulk modulus, n- modulus of rigidity 
We know that
y = 3k (1 - 2o)
o = 1/2 (1 - y/3k) ......(i)
y = 2n (1 + o) 
o = y / 2n - 1 ......(ii)
From Eq. (i) and Eq. (ii)
1/2 (1 - y/3k) = y / 2n - 1
1 - y/3k = y/n - 2
y/3k = 3 - y/n
y/3k = (3n - y) / n
ny/3k = 3n - y
k = ny / (9n - 3y)""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q10_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Physics Q10]\\nIn the given figure, the energy levels of\nhydrogen atom have been shown along with\nsome transitions marked A, B, C, D and E. The \ntransitions A, B and C respectively represent :",
                options = listOf("The ionization potential of hydrogen,\nsecond member of Balmer series and third \nmember of Paschen series.", "The first member of the Lyman series, \nthird member of Balmer series and second \nmember of Paschen series.", "The series limit of Lyman series, third\nmember of Balmer series and second\nmember of Paschen series.", "The series limit of Lyman series, second\nmember of Balmer series and second\nmember of Paschen series."),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3
Solution:
A -> Series limit of Lymen series.
B -> Third member of Balmer series.
C -> Second member of Paschen series.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q11_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Physics Q11]\\nFour identical particles of equal masses 1kg\nmade to move along the circumference of a\ncircle of radius 1 m under the action of their\nown mutual gravitational attraction. The speed \nof each particle will be :\n(1) sqrt(G/2 (1 + 2sqrt(2)))\n(2) sqrt(G(1 + 2sqrt(2)))\n(3) sqrt(G/2 (2sqrt(2) - 1))\n(4) sqrt((1 + 2sqrt(2))G / 2)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 4
Solution:
F1 = Gmm / (2R)^2 = Gm^2 / 4R^2
F2 = Gmm / (sqrt(2)R)^2 = Gm^2 / 2R^2
F3 = Gmm / (sqrt(2)R)^2 = Gm^2 / 2R^2
=> Fnet = F1 + F2 cos 45deg + F3 cos 45deg
= Gm^2 / 4R^2 + (Gm^2 / 2R^2) * (1/sqrt(2)) + (Gm^2 / 2R^2) * (1/sqrt(2))
= Gm^2 / R^2 (1/4 + 1/(2sqrt(2)) + 1/(2sqrt(2)))
= Gm^2 / R^2 (1/4 + 1/sqrt(2)) = Gm^2 / 4R^2 (1 + 2sqrt(2))
Fnet = Gm^2 / 4R^2 (1 + 2sqrt(2)) = mv^2 / R
=> v = sqrt(G(1 + 2sqrt(2)) / 2)""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q12_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Physics Q12]\\nIf the velocity-time graph has the shape AMB, \nwhat would be the shape of the corresponding \nacceleration-time graph ?",
                options = listOf("Option 1", "Option 2", "Option 3", "Option 4"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2
Solution:
Slope of v-t graph gives acceleration
Acceleration will be""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q13_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Physics Q13]\\nTwo equal capacitors are first connected in\nseries and then in parallel. The ratio of the\nequivalent capacities in the two cases will be:",
                options = listOf("4 : 1", "2 : 1", "1 : 4", "1 : 2"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3
Solution:
For series combination
1/Ceq1 = 1/C + 1/C => Ceq1 = C/2
For parallel combination
Ceq2 = C + C => Ceq2 = 2C
=> Ceq1 / Ceq2 = (C/2) / 2C = 1/4 = 1 : 4""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q14_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Physics Q14]\\nIf an emitter current is changed by 4 mA, the\ncollector current changes by 3.5 mA. The value \nof B will be :",
                options = listOf("7", "0.5", "0.875", "3.5"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1
Solution:
Ie = IC + IB
=> dIe + dIC + dIB 
4mA = 3.5 mA + dIB
=> dIB = 0.5 mA
b = dIC / dIB = 3.5 / 0.5 = 7""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q15_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Physics Q15]\\nMatch List-I with List-II :\nList-I List-II\n(a) Isothermal (i) Pressure constant\n(b) Isochoric (ii) Temperature constant\n(c) Adiabatic (iii) Volume constant\n(d) Isobaric (iv) Heat content is constant\nChoose the correct answer from the options\ngiven below :",
                options = listOf("(a) -> (i), (b) -> (iii), (c) -> (ii), (d) -> (iv)", "(a) -> (ii), (b) -> (iii), (c) -> (iv), (d) -> (i)", "(a) -> (ii), (b) -> (iv), (c) -> (iii), (d) -> (i)", "(a) -> (iii), (b) -> (ii), (c) -> (i), (d) -> (iv)"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2
Solution:
(a) Isothermal => Temperature constant -> (ii)
(b) Isochoric => Volume constant -> (iii)
(c) Adiabatic => dQ = 0 => Heat content is constant -> (iv)
(d) Isobaric => Pressure constant -> (i)""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q16_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Physics Q16]\\nEach side of a box made of metal sheet in cubic \nshape is 'a' at room temperature 'T', the\ncoefficient of linear expansion of the metal\nsheet is 'a'. The metal sheet is heated \nuniformly, by a small temperature dT, so that \nits new temperature is T + dT. Calculate the \nincrease in the volume of the metal box.",
                options = listOf("3a^3 a dT", "4a^3 a dT", "4pi a^3 a dT", "4/3 pi a^3 a dT"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1
Solution:
dV = Vy dT
dV = 3a^3 a dT""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q17_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Physics Q17]\\nA cell E of emf 6V and internal resistance \n2O is connected with another cell E2 of emf 4V \nand internal resistance 8O (as shown in the \nfigure). The potential difference across points \nX and Y is :",
                options = listOf("10.0 V", "3.6 V", "5.6V", "2.0 V"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3
Solution:
I = (6 - 4) / 10 = 1/5 A 
Vx + 4 + 8 * 1/5 - Vy = 0
Vx - Vy = -5.6 => |Vx - Vy| = 5.6 V""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q18_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Physics Q18]\\nA cube of side 'a' has point charges +Q located \nat each of its vertices except at the origin where \nthe charge is -Q. The electric field at the centre \nof cube is :\n(1) -Q / (3sqrt(3)pi e0 a^2) (x + y + z)\n(2) -2Q / (3sqrt(3)pi e0 a^2) (x + y + z)\n(3) 2Q / (3sqrt(3)pi e0 a^2) (x + y + z)\n(4) Q / (3sqrt(3)pi e0 a^2) (x + y + z)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 2
Solution:
We can replace -Q charge at origin by +Q and -2Q . Now due to +Q charge at every corner of cube. Electric field at center of cube is zero so now net electric field at center is only due to -2Q charge at origin.
E = kqr / r^3 = (1(-2Q) * a/2 (i + j + k)) / (4pi e0 (a/2 * sqrt(3))^3)
E = -2Q(i + j + k) / (3sqrt(3)pi a^2 e0)""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q19_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Physics Q19]\\nConsider two satellites S1 and S2 with periods\nof revolution 1 hr. and 8hr. respectively\nrevolving around a planet in circular orbits. The \nratio of angular velocity of satellite S1 to the \nangular velocity of satellites S2 is :",
                options = listOf("8 : 1", "1 : 4", "2 : 1", "1 : 8"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1
Solution:
T1 / T2 = 1 / 8
(2pi / w1) / (2pi / w2) = 1 / 8
w1 / w2 = 1 / 8""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q20_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Physics Q20]\\nThe workdone by a gas molecule in an isolated \nsystem is given by,W = ab^2 e^(-x^2/akT), where x is \nthe displacement, k is the Boltzmann constant \nand T is the temperature, a and b are constants. \nThen the dimension of b will be :",
                options = listOf("[M L^2 T^-2]", "[M L T^-2]", "[M^2 L T^2]", "[M^0 L T^0]"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2
Solution:
x^2 / akT -> dimensionless 
=> [a] = [x^2] / [kT] = L^2 / ML^2T^-2 = M^-1 T^2
Now [W] = [a] [b]^2
[b] = sqrt([W] / [a]) = sqrt(ML^2T^-2 / M^-1T^2) = M^1 L^1 T^-2""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q21_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Physics Q21]\\nThe coefficient of static friction between a\nwooden block of mass 0.5 kg and a vertical\nrough wall is 0.2. The magnitude of horizontal\nforce that should be applied on the block to\nkeep it adhere to the wall will be ______N.\n[g = 10 ms-2]",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 25
Solution:
F.B.D. of the block is shown in the diagram
Since block is at rest therefore
fr - mg = 0 ...(1)
F - N = 0 ....(2)
fr <= uN
In limiting case
fr = uN = uF ....(3)
Using eq. (1) and (3)
:. uF = mg
=> F = mg / u = (0.5 * 10) / 0.2 = 25 N
Ans 25.00""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q22_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Physics Q22]\\nA resonance circuit having inductance and \nresistance 2 x 10^-4 H and 6.28 O respectively \noscillates at 10 MHz frequency. The value of \nquality factor of this resonator is _______.\n[pi = 3.14]",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 2000
Solution:
* Official answer by NTA (200)
Given : L = 2 x 10^-4 H
R = 6.28 ohms
f = 10 MHz = 10^7 HZ
Since quality factor,
Q = w0 L / R = 2pi f L / R
:. Q = 2pi x 10^7 x (2 x 10^-4) / 6.28
Q = 2 x 10^3 = 2000
:. Ans. is 2000""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q23_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Physics Q23]\\nA hydraulic press can lift 100 kg when a \nmass'm' is placed on the smaller piston. It can \nlift_______ kg when the diameter of the larger\npiston is increased by 4 times and that of the \nsmaller piston is decreased by 4 times keeping \nthe same mass 'm' on the smaller piston.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 25600
Solution:
Using Pascals law
100 x g / A2 = mg / A1 ..... (1)
Let m mass can lift M0 in second case then
M0 g / 16A2 = Mg / (A1/16) ....(2)
{Since A = pi d^2 / 4}
From equation (1) and (2) we get
M0 / 16.100 = 16
=> M0 = 25600 kg""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q24_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Physics Q24]\\nAn inclined plane is bent in such a way that the\nvertical cross-section is given by y = x^2/4\nwhere y is in vertical and x in horizontal \ndirection. If. the upper surface of this curved \nplane is rough with coefficient of friction \nu = 0.5, the maximum height in cm at which a \nstationary block will not slip downward is \n________cm.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 25
Solution:
At maximum ht. block will experience maximum friction force. Therefore if at this height slope of the tangent is tan 0, then 0 = Angle of repose.
:. = tan 0 = dy / dx = 2x / 4 = x / 2 = 0.5 
=> x = 1 and therefore y = x^2 / 4 = 0.25 m = 25 cm
:. Answer is 25 cm""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q25_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Physics Q25]\\nAn electromagnetic wave of frequency 5 GHz, \nis travelling in a medium whose relative \nelectric permittivity and relative magnetic \npermeability both are 2. Its velocity in this \nmedium is________x 10^7m/s.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 15
Solution:
Given : Frequency of wave f = 5 GHz = 5 x 10^9 Hz 
Relative permittivity, er = 2
and Relative permeability, ur = 2 
Since speed of light in a medium is given by,
V = 1 / sqrt(u e) = 1 / sqrt(ur u0 er e0)
v = 1 / sqrt(ur er) * 1 / sqrt(u0 e0) = C / sqrt(ur er)
Where C is speed of light is vacuum.
:. v = (3 x 10^8) / sqrt(4) = (30 x 10^7) / 2 m/s = 15 x 10^7 m/s
:. Ans. is 15""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q26_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Physics Q26]\\nIn connection with the circuit drawn below, the \nvalue of current flowing through 2 kO resistor\nis ________ x 10^-4 A.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 25
Solution:
Current through 2k ohms resistance
I = 5 / (2 x 10^3) = 2.5 x 10^-3 A = 25 x 10^-4 A
Ans 25""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q27_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Physics Q27]\\nAn audio signal v = 20 sin 2pi (1500 t)\namplitude modulates a carrier \nvC = 80 sin 2pi (100,000 t).\nThe value of percent modulation is _______.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 25
Solution:
% modulation = Am / Ac x 100
% modulation = 20 / 80 x 100 = 25%
Ans 25""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q28_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Physics Q28]\\nA ball will a speed of 9 m/s collides with\nanother identical ball at rest. After the collision, \nthe direction of each ball makes an angle of \n30deg with the original direction. The ratio of \nvelocities of the balls after collision is x : y, \nwhere x is ________.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 1
Solution:
From conservation of momentum along y-axis.
Piy = Pfy
0 + 0 = mv1 sin 30deg j + mv2 sin 30deg(-j)
mv2 sin 30deg= mv1 sin 30deg
v2 = v1 or v1 / v2 = 1""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q29_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Physics Q29]\\nA common transistor radio set requires 12V \n(D.C.) for its operation. The D.C. source is \nconstructed by using a transformer and a\nrectifier circuit, which are operated at 220 V\n(A.C.) on standard domestic A.C. supply. The \nnumber of turns of secondary coil are 24, then \nthe number of turns of primary are _______.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 440
Solution:
NP / NS = VP / VS
NP / 24 = 220 / 12
NP = 220 x 24 / 12
NP = 440
Ans. 440 turns""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q30_phys",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Physics Q30]\\nAn unpolarized light beam is incident on the\npolarizer of a polarization experiment and the\nintensity of light beam emerging from the\nanalyzer is measured as 100 Lumens. Now, if\nthe analyzer is rotated around the horizontal\naxis (direction of light) by 30deg in clockwise\ndirection, the intensity of emerging light will be \n_______ Lumens.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 75
Solution:
Assuming initially axis of Polarizer and Analyzer are parallel
Now emerging intensity = I0/2 cos^2 30deg
= 100 (sqrt(3)/2)^2 = 100 x 3/4 = 75 Ans. 75

CHEMISTRY""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q31_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Chemistry Q31]\\nThe product formed in the first step of the\nreaction of\nCH3-CH2-CH(Br)-CH2-CH(Br)-CH3 with excess\nMg/Et2O(Et = C2H5) is :",
                options = listOf("CH3-CH2 -CH-CH2-CH-CH3 ...", "CH3-CH2-CH-CH2-CH-CH3 ...", "CH3-CH(CH2)-CH-CH3", "product"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4
Solution:
(A ^ (A -> B)) -> B
= (A ^ (~A v B)) -> B
= ((A ^ ~A) v (A ^ B)) -> B
= (A ^ B) -> B
= ~(A ^ B) v B
= (~A v ~B) v B
= T""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q32_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Chemistry Q32]\\nConsider the elements Mg, Al, S, P and Si, the \ncorrect increasing order of their first ionization \nenthalpy is :",
                options = listOf("Mg < Al < Si < S < P", "Al < Mg < Si < S < P", "Mg < Al < Si < P < S", "Al < Mg < S < Si < P"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2
Solution:
Let the line be y = mx + c 
x-intercept : -c/m
y-intercept : c
A.M of reciprocals of the intercepts 
(-m/c + 1/c) / 2 = 1/4
=> 2 (1 - m) = c 
line : y = mx + 2(1 - m) = c
=> (y - 2) - m(x - 2) = 0
=> line always passes through (2, 2)
Ans. 4""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q33_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Chemistry Q33]\\n'A' and 'B' in the following reactions are :\nAniline -> A -> B",
                options = listOf("A : Benzene diazonium chloride B : Benzaldehyde", "A : Benzene diazonium chloride B : Chlorobenzene", "A : Benzonitrile B : Benzaldehyde", "A : Benzonitrile B : Chlorobenzene"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3
Solution:
Normal vector :
i j k
3 1 -2
2 -5 -1
= -11i - j + 17k
so drs of normal to the required plane is < 11, 1, 17 > 
plane passes through (1, 2, -3)
So eqn of plane :
11 (x - 1) + 1(y - 2) + 17 (z + 3) = 0
=> 11x + y + 17z + 38 = 0""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q34_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Chemistry Q34]\\nWhich of the following ore is concentrated\nusing group 1 cyanide salt ?",
                options = listOf("Sphalerite", "Calamine", "Siderite", "Malachite"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1
Solution:
dP / dt = 0.5P - 450
=> integral_850^P dp / (P - 900) = integral_0^t dt / 2
[ln |P(t) - 900|]_850^P = [t/2]_0^t
=> ln |P(t) - 900| - ln|P(0) - 900| = t / 2
=> ln |P(t) - 900| - ln |50| = t / 2 for P(t) = 0
=> ln (900 / 50) = t / 2
=> t = 2ln18""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q35_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Chemistry Q35]\\nAl2O3 was leached with alkali to get X. The\nsolution of X on passing of gas Y, forms Z. \nX,Y and Z respectively are :",
                options = listOf("X = Na[Al(OH)4], Y = SO2, Z = Al2O3", "X = Na[Al(OH)4], Y = CO2, Z = Al2O3, xH2O", "X = Al(OH)3, Y = CO2, Z = Al2O3", "X = Al(OH)3, Y = SO2, Z =Al2O3.xH2O"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2
Solution:
d = 
3 -2 -k
2 -4 -2
1 2 -1
= 0 => 24 - 2(0) - k(8) = 0 => k = 3 
dx =
10 -2 -3
6 -4 -2
5m 2 -1
= 10(8) - 2(-10m + 6) - 3(12 + 20m) = 8(4 - 5m)
dy =
3 10 -3
2 6 -2
1 5m -1
= 3(-6 + 10m) + 10(0) - 3(10m - 6) = 0
dz = 
3 -2 10
2 -4 6
1 2 5m
= 3(-20m - 12) - 2(6 - 10m) + 10(8) = 40m - 32 = 8(5m - 4)
for inconsistent k = 3 & m != 4/5""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q36_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Chemistry Q36]\\nWhich of the following are isostructural pairs ?\nA. SO4^2- and CrO4^2- B. SiCl4 and TiCl4\nC. NH3 and NO3^-\nD. BCl3 and BrCl3",
                options = listOf("C and D only", "A and B only", "A and C only", "B and C only"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2
Solution:
For x = n, n in Z
LHL = lim_{x->n-} f(x) = lim_{x->n-} [x - 1] cos ((2x - 1)/2 pi) = 0
RHL = lim_{x->n+} f(x) = lim_{x->n+} [x - 1] cos ((2x - 1)/2 pi) = 0
f(n) = 0
=> LHL = RHL = f(n)
=> f(x) is continuous for every real x.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q37_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Chemistry Q37]\\nWhat is the final product (major) 'A' in the\ngiven reaction ?",
                options = listOf("Product 1", "Product 2", "Product 3", "Product 4"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1
Solution:
Let (x - 3)/1 = (y - 4)/2 = (z - 5)/2 = t
=> x = 3 + t, y = 2y + 4 , z = 2t + 5
for point of intersection with x + y + z = 17
3 + t + 2t + 4 + 2t + 5 = 17
=> 5t = 5 => t = 1
=> point of intersection is (4, 6, 7)
distance between (1, 1, 9) and (4, 6, 7)
is sqrt(9 + 25 + 4) = sqrt(38)""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q38_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Chemistry Q38]\\nIn the following reaction the reason why\nmeta-nitro product also formed is :",
                options = listOf("low temperature", "-NH2 group is highly meta-directive", "Formation of anilinium ion", "-NO2 substitution always takes place at\nmeta-position"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3
Solution:
Slope of tangent at P(t, t^3) = [dy/dx]_(t,t^3)
= (3x^2)_(x=t) = 3t^2
So equation tangent at P(t, t^3) : 
y - t^3 = 3t^2(x - t) for point of intersection with y = x^3
x^3 - t^3 = 3t^2 x - 3t^3
=> (x - t)(x^2 + xt + t^2) = 3t^2 (x - t) 
for x != t
x^2 + xt + t^2 = 3t^2
=> x^2 + xt - 2t^2 = 0 
=> (x - t) (x + 2t) = 0 
So for Q : x = -2t, Q(-2t, -8t^3)
ordinate of required point : (-8t^3 + 2t^3) / (2 + 1) = -2t^3""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q39_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Chemistry Q39]\\nIn Freundlich adsorption isotherm, slope of \nAB line is :",
                options = listOf("log n with (n > 1)", "n with (n, 0.1 to 0.5)", "log 1/n with (n < 1)", "1/n with (1/n = 0 to 1)"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4
Solution:
integral (cos x - sin x) / sqrt(8 - sin 2x) dx
= integral (cos x - sin x) / sqrt(9 - (sin x + cos x)^2)
Let sinx + cosx = t
integral dt / sqrt(9 - t^2) = sin^-1(t/3) + c
= sin^-1 ((sin x + cos x)/3) + c
so a = 1, b = 3.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q40_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Chemistry Q40]\\n(A) HOCl + H2O2 -> H3O+ + Cl- + O2\n(B) I2 + H2O2 + 2OH- -> 2I- + 2H2O + O2\nChoose the correct option.",
                options = listOf("H2O2 acts as reducing and oxidising agent \nrespectively in equation (A) and (B)", "H2O2 acts as oxidising agent in equation \n(A) and (B)", "H2O2 acts as reducing agent in equation \n(A)and (B)", "H2O2 act as oxidizing and reducing agent\nrespectively in equation (A) and (B)"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3
Solution:
(-15C1 + 2 * 15C2 - 3 * 15C3 + .... - 15 * 15C15) + (14C1 + 14C3 + ... + 14C11)
= sum_{r=1}^{15} (-1)^r * r * 15Cr + (14C1 + 14C3 + .... + 14C11 + 14C13) - 14C3
= sum_{r=1}^{15} (-1)^r * 15 * 14C_{r-1} + 2^13 - 14
= 15 (-14C0 + 14C1 ...... -14C14) + 2^13 - 14
= 2^13 - 14""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q41_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Chemistry Q41]\\nWhat is the major product formed by HI on\nreaction with alkene",
                options = listOf("Product 1", "Product 2", "Product 3", "Product 4"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3
Solution:
f(x) = (4x^3 - 3x^2) / 6 - 2 sinx + (2x-1) cosx 
f'(x) = (2x^2 - x) - 2cos x + 2cos x - sin x(2x - 1)
= (2x - 1)(x - sinx)
for x > 0, x - sinx > 0
x < 0, x - sinx < 0
for x in (-inf, 0] U [1/2, inf), f'(x) >= 0
for x in [0, 1/2], f'(x) <= 0
=> f(x) increases in [1/2, inf).""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q42_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Chemistry Q42]\\nWhich of the following reagent is used for the \nfollowing reaction ?\nCH3CH2CH3 -> CH3CH2 CHO",
                options = listOf("Manganese acetate", "Copper at high temperature and pressure", "Molybdenum oxide", "Potassium permanganate"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3
Solution:
f(g(x)) = 2g(x) - 1 = 2 (1 / (x - 1)) - 1
= (2 - (x - 1)) / (x - 1) = (3 - x) / (x - 1)
Wait, the solution says:
f(g(x)) = 2g(x) - 1 = 2((x-1/2)/(x-1)) - 1 = (2x - 1)/(x-1) - 1 = x/(x-1)
Range of f(g(x) = R - {1}
Range of f(g(x)) is not onto & f(g(x)) is one-one
So f(g(x)) is one-one but not onto.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q43_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Chemistry Q43]\\nGiven below are two statements :\nStatement I : Colourless cupric metaborate is\nreduced to cuprous metaborate in a luminous\nflame.\nStatement II : Cuprous metaborate is btained by \nheating boric anhydride and copper sulphate in \na non-luminous flame.\nIn the light of the above statements, choose the\nmost appropriate answer from the options given\nbelow.",
                options = listOf("Statement I is true but Statement II is false", "Both Statement I and Statement II are false", "Statement I is false but Statement II is true", "Both Statement I and Statement II are true"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2
Solution:
nC2 (1/2)^n = nC3 (1/2)^n => nC2 = nC3
=> n = 5
Probability of getting an odd number for odd number of times is 
5C1 (1/2)^5 + 5C3 (1/2)^5 + 5C5 (1/2)^5
= 1/2^5 (5 + 10 + 1) 
= 16/32 = 1/2""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q44_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Chemistry Q44]\\nOut of the following, which type of interaction \nis responsible for the stabilisation of a-helix\nstructure of proteins ?",
                options = listOf("Ionic bonding", "Hydrogen bonding", "Covalent bonding", "vander Waals forces"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2
Solution:
Indians Foreigners Number of ways
2 4 -> 6C2 x 8C4 = 1050
3 6 -> 6C3 x 8C6 = 560
4 8 -> 6C4 x 8C8 = 15
Total number of ways = 1625""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q45_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Chemistry Q45]\\nMatch List -I with List -II \n List I List II\n (Monomer Unit) (Polymer)\n(a) Caprolactum (i) Natural rubber\n(b) 2-Chloro-1,3-butadiene (ii) Buna-N\n(c) Isoprene (iii) Nylon 6\n(d) Acrylonitrile (iv) Neoprene\nChoose the correct answer from the options\ngiven below :",
                options = listOf("(a) -> (iv), (b) -> (iii), (c) -> (ii), (d) -> (i)", "(a) -> (ii), (b) -> (i), (c) -> (iv), (d) -> (iii)", "(a) -> (iii), (b) -> (iv), (c) -> (i), (d) -> (ii)", "(a) -> (i), (b) -> (ii), (c) -> (iii), (d) -> (iv)"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3
Solution:
Required area
= pi (6)^2 - 2 integral_0^3 sqrt(9x) dx - integral_3^6 sqrt(36 - x^2) dx
= 36pi - 12 sqrt(3) - 2 [x/2 sqrt(36 - x^2) + 18 sin^-1(x/6)]_3^6
= 36pi - 12 sqrt(3) - 2 (9pi - 3pi - 9sqrt(3)/2)
= 24pi - 3 sqrt(3)""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q46_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Chemistry Q46]\\nThe gas released during anaerobic degradation\nof vegetation may lead to :",
                options = listOf("Ozone hole", "Acid rain", "Corrosion of metals", "Global warming and cancer"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4
Solution:
Consider (p^2 + q^2)^2 - 2p^2 q^2 = 272
((p + q)^2 - 2pq)^2 - 2p^2 q^2 = 272
(4 - 2pq)^2 - 2p^2 q^2 = 272
16 - 16pq + 4p^2q^2 - 2p^2q^2 = 272
2(pq)^2 - 16pq - 256 = 0 
(pq)^2 - 8pq - 128 = 0
pq = (8 +/- 24) / 2 = 16, -8
:. pq = 16
:. Required equation : x^2 - (2)x + 16 = 0""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q47_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Chemistry Q47]\\nThe major components in \"Gun Metal\" are :",
                options = listOf("Cu, Zn and Ni", "Cu, Sn and Zn", "Al, Cu, Mg and Mn", "Cu, Ni and Fe"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2
Solution:
tan 0 = h / 75 = 75 / 3h
=> h^2 = (75)^2 / 3
h = 25 sqrt(3) m""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q48_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Chemistry Q48]\\nThe electrode potential of M / M of 3d-series \nelements shows positive value of :",
                options = listOf("Zn", "Fe", "Co", "Cu"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4
Solution:
lim_{x->0+} (integral_0^x^3 sin sqrt(t) dt) / x^6 
Wait, the formula was different:
lim_{x->0+} integral_0^x^3 (sin t dt) / x^3
= lim_{x->0+} (sin x) 2x / 3x^2 = 2/3""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q49_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Chemistry Q49]\\nIdentify products A and B :",
                options = listOf("A : ... B : ...", "A : ... B : ...", "A : OHC-CH2CH2CH2-C(=O)-CH3 B : HOOC-CH2CH2CH2-C(=O)-CH3", "A : ... B : ..."),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2
Solution:
e^(cos^2 0 + cos^4 0 + ...) ln 2 = 2^(cos^2 0 + cos^4 0 + ...)
= 2^(cot^2 0)
Now - t^2 - 9t + 9 = 0 => t = 1, 8
=> 2^(cot^2 0) = 1, 8 => cot^2 0 = 0, 3
0 < 0 < pi/2 => cot 0 = sqrt(3)
=> (2 sin 0) / (sin 0 + sqrt(3) sin 0) = sqrt(2) / (1 + sqrt(3) cot 0)
= sqrt(2) / 4 = 1/2
Wait, solution says 1/2.""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q50_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Chemistry Q50]\\nWhich of the following compound gives pink\ncolour on reaction with phthalic anhydride in\nconc. H2SO4 followed by treatment with\nNaOH ?",
                options = listOf("compound 1", "compound 2", "compound 3", "compound 4"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1
Solution:
h = (at^2 + a)/2 , k = (2at + 0)/2
=> t^2 = (2h - a)/a and t = k/a
=> k^2/a^2 = (2h - a)/a
=> Locus of (h, k) is y^2 = a(2x - a)
=> y^2 = 2a (x - a/2)
Its directix is x - a/2 = -a/2
=> x = 0""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q51_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Chemistry Q51]\\nWhen 9.45 g of ClCH2COOH is added to 500 \nmL of water, its freezing point drops by 0.5degC. \nThe dissociation constant of ClCH2COOH is x x 10^-3.. The value of x is________.\n(Rounded off to the nearest integer)\n[Kf(H2O) = 1.86 kg mol^-1]",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 36
Solution:
Put z = x + iy
x + iy + a|x + iy - 1| + 2i = 0
=> x + a sqrt((x - 1)^2 + y^2) + i (y + 2) = 0 + 0i
=> y + 2 = 0 and x + a sqrt((x - 1)^2 + y^2) = 0 
=> y = -2 and a^2 = x^2 / (x^2 - 2x + 5)
Now x^2 / (x^2 - 2x + 5) in [0, 5/4]
:. a^2 in [0, 5/4] => a in [-sqrt(5)/2, sqrt(5)/2]
:. p = -sqrt(5)/2 ; q = sqrt(5)/2
=> 4(p^2 + q^2) = 4 (5/4 + 5/4) = 10""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q52_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Chemistry Q52]\\n4.5 g of compound A (MW = 90) was used to\nmake 250 mL of its aqueous solution. The\nmolarity of the solution in M is x x 10^-1. The\nvalue of x is ________. (Rounded off to the\nnearest integer)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 2
Solution:
integral_{-a}^0 (-2x + 2)dx + integral_0^2 (x + 2 - x)dx + integral_2^a (2x - 2)dx = 22
[-x^2 - 2x]_0^a + [2x]_0^2 + [x^2 - 2x]_2^a = 22
a^2 + 2a + 4 + a^2 - 2a - (4 - 4) = 22
2a^2 = 8 => a = 3 
integral_{-3}^3 (x + [x])dx = -(-3 - 2 - 1 + 1 + 2) = 3""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q53_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Chemistry Q53]\\nAt 1990 K and 1 atm pressure, there are equal \nnumber of Cl2 molecules and Cl atoms in the \nreaction mixture. The value KP for the reaction \nCl2(g) <=> 2Cl(g) under the above conditions is\nx x 10^-1. The value of x is ______.(Rounded \nof to the nearest integer)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 5
Solution:
B and C will contain three digit numbers of the form 9k + 2 and 9k + l respectively. We need to find sum of all elements in the set B U C effectively.
Now, S(B U C) = S(B) + S(C) - S(B I C) 
where S(k) denotes sum of elements of set k. 
Also, B = {101, 109, ......, 992}
:. S(B) = 100/2 (101 + 992) = 54650
Case-I : If l = 2
then B I C = B
:. S(B U C) = S(B)
which is not possible as given sum is 274 x 400 = 109600.
Case-II : If l != 2
then B I C = empty
:. S(B U C) = S(B) + S(C) = 400 x 274
=> 54650 + sum_{k=11}^110 (9k + l) = 109600
=> sum_{k=11}^110 9k + sum_{k=11}^110 l = 54950
=> 9 (100/2 (11 + 110)) + l (100) = 54950
=> 54450 + 100l = 54950
=> l = 5""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q54_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Chemistry Q54]\\nNumber of amphoteric compound among the\nfollowing is __________",
                options = listOf("BeO", "BaO", "Be(OH)2", "Sr(OH)2"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2
Solution:
a^2 + b^2 + c^2 + d^2 + e^2 + f^2 + g^2 + h^2 + i^2 = 7 
Case-I : Seven (1's) and two (0's)
9C2 = 36
Case-II : One (2) and three (1's) and five (0's)
9! / (5!3!) = 504
:. total = 540""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q55_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Chemistry Q55]\\nThe reaction of sulphur in alkaline medium is \nthe below\n S8(s) + a OH-(aq) -> b S^2-(aq) + c S2O3^2-(aq) + d H2O(l)\nThe values of 'a' is _______. (Integer answer)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 12
Solution:
x^2 + y^2 + 2x - 6y + 6 = 0
center (-1, 3)
Wait, equation is x^2+y^2-2x-6y+6=0?
center (1, 3), radius = 2
distance between (1, 3) and (2, 1) is sqrt(5)
:. (sqrt(5))^2 + (2)^2 = r^2
=> r = 3""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q56_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Chemistry Q56]\\nFor the reaction A(g) -> (B)(g), the value of he\nequilibrium constant at 300 K and 1 atm is\nequal to 100.0. The value of drG for the \nreaction at 300 K and 1 atm in J mol-1 is - xR, \nwhere x is ______ (Rounded of to the nearest \ninteger) (R = 8.31 J mol-1 K-1 and ln 10 = 2.3)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 1380
Solution:
Let f(x) = 4/sin x + 1/(1 - sin x)
=> f '(x) = 0 => sin x = 2/3
:. f(x)min = 4/(2/3) + 1/(1 - 2/3) = 9
f(x)max -> inf
f(x) is continuous function
:. a_min = 9""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q57_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Chemistry Q57]\\nA proton and a Li3+ nucleus are accelerated by \nthe same potential. If Li and p denote the de \nBroglie wavelengths of Li3+ and proton \nrespectively, then the value of Li / p is x x 10^-1\nThe value of x is ________\n(Rounded off to the nearest integer)\n(Mass of Li3+ = 8.3 mass of proton)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 2
Solution:
lim_{n->inf} tan {sum_{r=1}^n tan^-1(1/(1 + r + r^2))}
= lim_{n->inf} tan {sum_{r=1}^n tan^-1((r+1 - r)/(1 + r(r+1)))}
= tan (lim_{n->inf} sum_{r=1}^n [tan^-1(r+1) - tan^-1(r)])
= tan (lim_{n->inf} (tan^-1(n+1) - pi/4))
= tan (pi/2 - pi/4) = 1""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q58_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Chemistry Q58]\\nThe stepwise formation of [Cu(NH3)4]2+\nis given below \nCu2+ + NH3 <=> [Cu(NH3)]2+\n[Cu(NH3)]2+ + NH3 <=> [Cu(NH3)2]2+\n[Cu(NH3)2]2+ + NH3 <=> [Cu(NH3)3]2+\n[Cu(NH3)3]2+ + NH3 <=> [Cu(NH3)4]2+\nThe value of stability constants K1, K2, K3 and\nK4 are 10^4, 1.58 x 10^3, 5 x 10^2 and 10^2\nrespectively. The overall equilibrium constants \nfor dissociation of [Cu(NH3)4]2+\nis x x 10^-12.The value of x is ________. \n(Rounded off to the nearest integer)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 1
Solution:
Let c = l(b x (a x b))
= l ((b.b)a - (b.a)b)
= l (5(-i - j + k) - (-3)(2i + k))
Wait, actual calculation:
a = -i + j + k, b = 2i + 0j + k
b.b = 5, b.a = -2+1 = -1
c = l (5(-i+j+k) - (-1)(2i+k))
c.a = 7 => l = 1/2
=> c = (-3/2 i + 5/2 j + 3 k)
2 |a + b + c|^2 = 2 |(-1+2-3/2)i + (1+0+5/2)j + (1+1+3)k|^2 = 75""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q59_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Chemistry Q59]\\nThe coordination number of an atom in a \nbodycentered cubic structure is _______.\n[Assume that the lattice is made up of atoms.]",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 8
Solution:
Let P(B1) = p1, P(B2) = p2, P(B3) = p3
p1 (1 - p2) (1 - p3) = a 
p2 (1 - p1) (1 - p3) = b 
p3 (1 - p1) (1 - p2) = y 
(1 - p1) (1 - p2) (1 - p3) = p
=> p1 / (1 - p1) = a/p , p2 / (1 - p2) = b/p & p3 / (1 - p3) = y/p
Also b = ap / (a + 2p) = 3yp / (p - 2y)
=> ap - 2ay = 3ay + 6py
=> ap - 6py = 5ay
=> p1/(1-p1) - 6p3/(1-p3) = 5p1p3 / ((1-p1)(1-p3))
=> p1 - 6p3 = 0 
=> p1 / p3 = 6""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q60_chem",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Chemistry Q60]\\nGaseous cyclobutene isomerizes to butadiene in \na first order process which has a 'k' value of \n3.3 x 10^-4 s^-1 at 153degC. The time in minutes it \ntakes for the isomerization to proceed 40 % to \ncompletion at this temperature is _____.\n(Rounded off to the nearest integer)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 26
Solution:
PQ = kI 
|P|.|Q| = k^3
=> |P| = 2k != 0 => P is an invertible matrix 
:. PQ = kI 
:. Q = kP^-1I 
:. Q = adj.P / 2
:. q23 = -k/8
:. -(3a + 4) / 2 = -k/8 => k = 4 
:. |P| = 2k => k = 10 + 6a .....(i)
Put value of k in (i) .... we get a = -1 
a^2 + k^2 = 17""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q61_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Mathematics Q61]\\nThe statement among the following that is a\ntautology is :",
                options = listOf("A v (A ^B)", "A ^ (A v B)", "B -> [A ^ (A-> B)]", "[A ^ (A->B)] ->B"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q62_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Mathematics Q62]\\nA man is walking on a straight line. The\narithmetic mean of the reciprocals of the\nintercepts of this line on the coordinate axes\nis 1/4. Three stones A, B and C are placed at the\npoints (1,1), (2, 2) and (4, 4) respectively. Then \nwhich of these stones is / are on the path of the \nman?",
                options = listOf("A only", "C only", "All the three", "B only"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q63_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Mathematics Q63]\\nThe equation of the plane passing through the\npoint (1, 2, -3) and perpendicular to the planes\n3x + y - 2z = 5 and 2x - 5y - z = 7, is",
                options = listOf("3x - 10y - 2z + 11 = 0", "6x - 5y - 2z - 2 = 0", "11x + y + 17z + 38 = 0", "6x - 5y + 2z + 10 = 0"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q64_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Mathematics Q64]\\nThe population P = P(t) at time 't' of a certain\nspecies follows the differential equation\ndP/dt = 0.5P - 450. If P(0) = 850, then the time at \nwhich population becomes zero is :",
                options = listOf("loge 18", "loge9", "1/2 loge18", "2loge18"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q65_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Mathematics Q65]\\nThe system of linear equations\n3x - 2y - kz = 10\n2x - 4y - 2z = 6\nx + 2y - z = 5m\nis inconsistent if :",
                options = listOf("k = 3, m = 4/5", "k != 3, m in R", "k != 3, m != 4/5", "k = 3, m != 4/5"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q66_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Mathematics Q66]\\nIf f : R -> R is a function defined by\nf(x) = [x - 1] cos ((2x - 1)/2 pi). where [.] denotes \nthe greatest integer function, then f is :",
                options = listOf("discontinuous at all integral values of x\nexcept at x = 1", "continuous only at x = 1", "continuous for every real x", "discontinuous only at x = l"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q67_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Mathematics Q67]\\nThe distance of the point (1, 1, 9) from the \npoint of intersection of the line (x - 3)/1 = (y - 4)/2 = (z - 5)/2\nand the plane x + y + z = 17 is :\n(1) 2sqrt(19) (2) 19sqrt(2)\n(3) 38 (4) sqrt(38)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 4
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q68_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Mathematics Q68]\\nIf the tangent to the curve y = x^3 at the point \nP(t, t^3) meets the curve again at Q, then the \nordinate of the point which divides PQ \ninternally in the ratio 1 : 2 is :",
                options = listOf("-2t^3", "0", "-t^3", "2t^3"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q69_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Mathematics Q69]\\nIf integral (cos x - sin x) / sqrt(8 - sin 2x) dx = a sin^-1 ((sin x + cos x) / b) + c,\nwhere c is a constant of integration, then the\nordered pair (a, b) is equal to :",
                options = listOf("(-1, 3)", "(3, 1)", "(1, 3)", "(1, -3)"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q70_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Mathematics Q70]\\nThe value of -15C1 + 2 * 15C2 - 3 * 15C3 + .... \n- 15 * 15C15 + 14C1 + 14C3 + 14C5 + ... + 14C11 is :",
                options = listOf("2^16-1", "2^13 - 14", "2^14", "1^13 - 13"),
                correctOptionIndex = 1,
                explanation = """Correct Answer: 2
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q71_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Mathematics Q71]\\nThe function \nf(x) = (4x^3 - 3x^2) / 6 - 2 sinx + (2x - 1) cosx :",
                options = listOf("increases in [1/2, inf)", "increases in [-inf, 1/2]", "decreases in [1/2, inf)", "decreases in [-inf, 1/2]"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q72_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Mathematics Q72]\\nLet f : R -> R be defined as f(x) = 2x - 1 and \ng : R - {1} -> R be defined as g(x) = (x - 1/2) / (x - 1). \nThen the composition function f(g(x)) is :",
                options = listOf("onto but not one-one", "both one-one and onto", "one-one but not onto", "neither one-one nor onto"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q73_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Mathematics Q73]\\nAn ordinary dice is rolled for a certain number \nof times. If the probability of getting an odd \nnumber 2 times is equal to the probability of \ngetting an even number 3 times, then the \nprobability of getting an odd number for odd \nnumber of times is :",
                options = listOf("1/32", "5/16", "3/16", "1/2"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q74_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Mathematics Q74]\\nA scientific committee is to be formed from 6 \nIndians and 8 foreigners, which includes at\nleast 2 Indians and double the number of\nforeigners as Indians. Then the number of\nways, the committee can be formed, is :",
                options = listOf("1625", "575", "560", "1050"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q75_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Mathematics Q75]\\nThe area (in sq. units) of the part of the circle\nx^2 + y^2 = 36, which is outside the parabola \ny^2 = 9x, is : \n(1) 24pi + 3sqrt(3) (2) 12pi - 3sqrt(3)\n(3) 24pi - 3sqrt(3) (4) 12pi + 3sqrt(3)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 3
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q76_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Mathematics Q76]\\nLet p and q be two positive numbers such that \np + q = 2 and p^4 + q^4 = 272. Then p and q are \nroots of the equation :",
                options = listOf("x^2 - 2x + 2 = 0", "x^2 - 2x + 8 = 0", "x^2 - 2x + 136 = 0", "x^2 - 2x + 16 = 0"),
                correctOptionIndex = 3,
                explanation = """Correct Answer: 4
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q77_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Mathematics Q77]\\nTwo vertical poles are 150 m apart and the\nheight of one is three times that of the other. If \nfrom the middle point of the line joining their \nfeet, an observer finds the angles of elevation \nof their tops to be complementary, then the \nheight of the shorter pole (in meters)\nis :\n(1) 20sqrt(3) (2) 25sqrt(3)\n(3) 30 (4) 25",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 2
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q78_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Mathematics Q78]\\nlim_{x->0} integral_0^x^3 (sin t dt) / x^2 is equal to : \nWait, the image says lim_{x->0+} integral_0^x^2 (sin sqrt(t) dt) / x^3\nAh, the text says lim_{x->0+} integral_0^x^2 (sin sqrt(t) dt) / x^3\nThe answer is 2/3.",
                options = listOf("2/3", "3/2", "0", "1/15"),
                correctOptionIndex = 0,
                explanation = """Correct Answer: 1
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q79_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Mathematics Q79]\\nIf e^(cos^2 x + cos^4 x + cos^6 x + ...) loge 2 satisfies the \nequation t^2 - 9t + 8 = 0, then the value of\n(2sin x) / (sin x + sqrt(3) cos x) (0 < x < pi/2) is \n(1) 2sqrt(3) (2) 3/2 (3) sqrt(3) (4) 1/2",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 4
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q80_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Mathematics Q80]\\nThe locus of the mid-point of the line segment \njoining the focus of the parabola \ny^2 = 4ax to a moving point of the parabola, is \nanother parabola whose directrix is :",
                options = listOf("x = -a/2", "x = a/2", "x = 0", "x = a"),
                correctOptionIndex = 2,
                explanation = """Correct Answer: 3
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q81_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Mathematics Q81]\\nIf the least and the largest real values of a, for \nwhich the equation z + a|z - 1| + 2i = 0\n(z in C and i = sqrt(-1)) has a solution, are p and\nq respectively; then 4(p^2 + q^2) is equal to ----",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 10
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q82_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Mathematics Q82]\\nIf integral_-a^a (|x| + |x-2|)dx = 22, (a > 2) and [x]\ndenotes the greatest integer <= x, then\nintegral_-a^a (x + [x]) dx is equal to --------",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 3
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q83_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Mathematics Q83]\\nLet A = {n in N : n is a 3-digit number}\nB = {9k + 2 : k in N} and C = {9k + l : k in N} \nfor some l (0 < l < 9). If the sum of all the \nelements of the set A n (B U C) is 274 x 400, \nthen l is equal to ______.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 5
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q84_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Mathematics Q84]\\nLet M be any 3 x 3 matrix with entries from the \nset {0, 1, 2}. The maximum number of such \nmatrices, for which the sum of diagonal\nelements of M^T M is seven, is _______.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 540
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q85_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Mathematics Q85]\\nIf one of the diameters of the circle \nx^2 + y^2 - 2x - 6y + 6 = 0 is a chord of another\ncircle 'C', whose center is at (2, 1), then its \nradius is ______",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 3
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q86_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Mathematics Q86]\\nThe minimum value of a for which the\nequation 4/sin x + 1/(1 - sin x) = a has at least one \nsolution in (0, pi/2) is ------",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 9
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q87_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Mathematics Q87]\\nlim_{n->inf} tan (sum_{r=1}^n tan^-1 (1 / (1 + r + r^2))) is equal to ---",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 1
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q88_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Mathematics Q88]\\nLet three vectors a, b and c be such that c is \ncoplanar with a and b, a . c = 7 and b is \nperpendicular to c, where a = -i + j + k and \nb = 2i + k, then the value of 2 |a + b + c|^2 is ---",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 75
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q89_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Mathematics Q89]\\nLet Bi (i = 1, 2, 3) be three independent events \nin a sample space. The probability that only B1 \noccur is a, only B2 occurs is b and only B3\noccurs is y. Let p be the probability that none of\nthe events Bi occurs and these 4 probabilities\nsatisfy the equations (a - 2b) p = a b and\n(b - 3y)p = 2b y (All the probabilities are\nassumed to lie in the interval (0,1)). Then\nP(B1)/P(B3) is equal to ------",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 6
Solution:
""",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q90_math",
                topicId = testId,
                text = "[JEE Main 2021 Session 1 Shift 1 - Mathematics Q90]\\nLet P = [3 -1 -2; 2 0 a; 3 -5 0], where a in R. Suppose \nQ = [qij] is a matrix satisfying PQ = kI3 for \nsome non-zero k in R. If q23 = -k/8 and |Q| = k^2/2, \nthen a^2 + k^2 is equal to ------",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = """Correct Answer: 17
Solution:
""",
                difficulty = "Medium"
            )
        )
    }
}