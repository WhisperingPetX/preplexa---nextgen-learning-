package com.example.data.repository
import com.example.model.Question
object JeeMain2022Session1Shift1QuestionsRepository {
    fun getQuestions(testId: String): List<Question> {
        return listOf(
            Question(
                id = "${testId}_s1_sh1_q1_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Physics Q1]\\nThe bulk modulus of a liquid is 3 × 1010 Nm–2. The pressure required to reduce the volume of liquid by 2% is",
                options = listOf("3 × 108\n Nm–2", "9 × 108\n Nm–2", "6 × 108\n Nm–2", "12 × 108\n Nm–2"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n∴ B = \n⎟\n⎠\n⎞ ⎜\n⎝\n⎛ Δ\nΔ\nV\nV –\nP\n⇒ ΔP = 3 × 1010 × (0.02) = 6 × 108\n N/m2",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q2_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Physics Q2]\\nGiven below are two statements: One is labelled as \n Assertion (A) and the other is labelled as Reason (R). \n Assertion (A): In an uniform magnetic field, speed and energy remains the same for a moving charged \nparticle. \n Reason (R): Moving charged particle experiences magnetic force perpendicular to its direction of motion.",
                options = listOf("Both (A) and (R) true and (R) is the correct explanation of (A).", "Both (A) and (R) are true but (R) is NOT the correct explanation of (A).", "(A) is true but (R) is false.", "(A) is false but (R) is true."),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nMagnetic force F\n ⊥ V\n\n⇒ Wb = 0 ⇒ ΔKE = 0 and speed remains constant.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q3_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Physics Q3]\\nTwo identical cells each of emf 1.5 V are connected in parallel across a parallel combination of two resistors \neach of resistance 20 Ω. A voltmeter connected in the circuit measures 1.2 V. The internal resistance of each \ncell is",
                options = listOf("2.5 Ω", "4 Ω", "5 Ω", "10 Ω"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n2\nr 10\n1.5 10\n+\n× = 1.2 ⇒ r = 5 Ω",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q4_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Physics Q4]\\nIdentify the pair of physical quantities which have different dimensions.",
                options = listOf("Wave number and Rydberg’s constant", "Stress and Coefficient of elasticity", "Coercivity and Magnetisation", "Specific heat capacity and Latent heat"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n[S] = [m] [ T]\n[C]\n× Δ\n and, [L] = [m]\n[Q]\n⇒ They have different dimensions.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q5_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Physics Q5]\\nA projectile is projected with velocity of 25 m/s at an angle θ with the horizontal. After t seconds its \ninclination with horizontal becomes zero. If R represents horizontal range of the projectile, the value of θ will \nbe [use g = 10 m/s2\n]",
                options = listOf("⎥\n⎥\n⎦\n⎤\n⎢\n⎢\n⎣\n⎡\n4R\n5t sin\n2\n1 2 –1", "⎥\n⎦\n⎤ ⎢\n⎣\n⎡\n2\n–1\n5t\n4R sin\n2\n1", "⎥\n⎥\n⎦\n⎤\n⎢\n⎢\n⎣\n⎡\n5R\n4t\ntan\n2 –1", "⎥\n⎦\n⎤ ⎢\n⎣\n⎡\n2\n–1\n20t\nR\ncot"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nt = \ng\n25sin θ\n and, R = \ng\n(25) (2sin cos ) 2 θ θ\n⇒ R = \ng\n25× 25× 2\n× \n25\ngt × cos θ\n⇒ R = 50t cosθ \n∴ tanθ = \nR\n50t\n25\ngt × = \nR\n20t\n2\n⇒ θ = cot–1 ⎟\n⎠\n⎞ ⎜\n⎝\n⎛\n2 20t\nR",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q6_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Physics Q6]\\nA block of mass 10 kg starts sliding on a surface with an initial velocity of 9.8 ms–1. The coefficient of \nfriction between the surface and block is 0.5. The distance covered by the block before coming to rest is \n[use g = 9.8 ms–2]",
                options = listOf("4.9 m", "9.8 m", "12.5 m", "19.6 m"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nS = \n2(µg)\nu\n2a\nu\n2 2\n= = \n2 0.5(9.8)\n(9.8)\n2\n× = \n1\n9.8 = 9.8 m",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q7_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Physics Q7]\\nA boy ties a stone of mass 100 g to the end of a 2 m long string and whirls it around in a horizontal plane. \nThe string can withstand the maximum tension of 80 N. If the maximum speed with which the stone can \nrevolve is \nπ\nK rev. / min . The value of K is \n (Assume the string is massless and unstretchable)",
                options = listOf("400", "300", "600", "800"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nT = mω\n2\nr \n⇒ 80 = 0.1 × 2\n60\nK 1 2\n2\n⎟ × ⎠\n⎞ ⎜\n⎝\n⎛ × π\nπ×\n⇒\n900\nK\n2\n800 2\n=\n⇒ K = 30 × 20 = 600",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q8_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Physics Q8]\\nA vertical electric field of magnitude 4.9 × 105\n N/C just prevents a water droplet of a mass 0.1 g from falling. \nThe value charge on the droplet will be (Given g = 9.8 m/s2\n)",
                options = listOf("1.6 × 10–9 C", "2.0 × 10–9 C", "3.2 × 10–9 C", "0.5 × 10–9 C"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nSince the droplet is at rest \n⇒ Net force = 0 \n⇒ mg = qE \n⇒ q = E\nmg = 2 × 10–9 C",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q9_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Physics Q9]\\nA particle experiences a variable force j)ˆ i 3y ˆ F (4x 2 = +  in a horizontal x-y plane. Assume distance in meters \nand force is newton. If the particle moves from point (1, 2) to point (2, 3) in the x-y plane; then Kinetic \nEnergy changes by",
                options = listOf("50.0 J", "12.5 J", "25.0 J", "0 J"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nW = ∫ F.dr  \n = ∫ ∫ +\n3\n2\n2\n2\n1\n4x dx 3y dy\n = [ ] [] 3\n2\n3 2\n1\n2 2x + y\n = 2 × 3 + (27 – 8) \n = 25 J",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q10_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Physics Q10]\\nThe approximate height from the surface of earth at which the weight of the body becomes 3\n1 of its weight on \nthe surface of earth is [Radius of earth R = 6400 km and 3 = 1.732 ]",
                options = listOf("3840 km", "4685 km", "2133 km", "4267 km"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nAccording to the given information \n2 (R h)\nGM\n+\n = 2 R\nGM\n3\n1 ×\n⇒ R + h = 3 R \n⇒ h = ( 3 – 1)R ~– 4685 km",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q11_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Physics Q11]\\nA resistance of 40 Ω is connected to a source of alternating current rated 220 V, 50 Hz. Find the time taken \nby the current to change from its maximum value to the rms value :",
                options = listOf("2.5 ms", "1.25 ms", "2.5 s", "0.25"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nI = I0 cos(ωt) say \n⇒ At maximum ωt1 = 0 or t1 = 0 \n Then at rms value I = I0/ 2\n⇒ ωt2 = π/4 \n⇒ ω(t2 – t1) = π/4 \nΔt = \nω\nπ\n4\n= × π\nπ\n4 2\nT\n= \n400\n1 s or 2.5 ms \n⇒ Option (1) is right answer",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q12_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Physics Q12]\\nThe equations of two waves are given by : \ny1 = 5 sin 2π(x – vt) cm \n y2 = 3 sin 2π(x – vt + 1.5) cm \n These waves are simultaneously passing through a string. The amplitude of the resulting wave is :",
                options = listOf("2 cm", "4 cm", "5.8 cm", "8 cm"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\ny1 = 5 sin(2πx – 2πvt) cm \n y2 = 3 sin (2πx – 2πvt + 3π) \n⇒ Phase difference = 3π\n⇒ Anet = A A 2A A cos(3 ) 2 2\n2\n2\n2\n1 + + π\n⇒ Anet = 2 cm",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q13_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Physics Q13]\\nA plane electromagnetic waves travels in a medium of relative permeability 1.61 and relative permittivity \n6.44. If magnitude of magnetic intensity is 4.5 × 10–2 Am–1 at a point, what will be the approximate \nmagnitude of electric field intensity at that point? \n(Given : Permeability of free space μ0 = 4π × 10–7 NA–2, speed of light in vacuum c = 3 × 108\n ms\n–1)",
                options = listOf("16.96 Vm–1", "2.25 × 10–2 Vm–1", "8.48 Vm–1", "6.75 × 106 Vm–1"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nH = 4.5 × 10–2 \nSo B = µ0µH \n Thus E = B\nn\nc (where n ⇒ refractive index) \n So E = \n1.61 6.44\n3 10 4 10 1.61 4.5 10 8 –7 –2\n×\n× × π× × × ×\n E = 8.48",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q14_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Physics Q14]\\nChoose the correct option from the following options given below :",
                options = listOf("In the ground state of Rutherford’s model electrons are in stable equilibrium. While in Thomson’s model \nelectrons always experience a net-force", "An atom has a nearly continuous mass distribution in a Rutherford’s model but has a highly non-uniform \nmass distribution in Thomson’s model", "A classical atom based on Rutherford’s model is doomed to collapse.", "The positively charged part of the atom possesses most of the mass in Rutherford’s model but not in \nThomson’s model."),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nAn atom based on classical theory of Rutherford’s model should collapse as the electrons in continuous \ncircular motion that is a continuously accelerated charge should emit EM waves and so should lose energy. \nThese electrons losing energy should soon fall into heavy nucleus collapsing the whole atom.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q15_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Physics Q15]\\nNucleus A is having mass number 220 and its binding energy per nucleon is 5.6 MeV. It splits in two \nfragments ‘B’ and ‘C’ of mass numbers 105 and 115. The binding energy of nucleons in ‘B’ and ‘C’ is \n6.4 MeV per nucleon. The energy Q released per fission will be :",
                options = listOf("0.8 MeV", "275 MeV", "220 MeV", "176 MeV"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n220A → 105B + 115C \n⇒ Q = [105 × 6.4 + 115 × 6.4] – [220 × 5.6] MeV \n⇒ Q = 176 MeV",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q16_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Physics Q16]\\nA baseband signal of 3.5 MHz frequency is modulated with a carrier signal of 3.5 GHz frequency using \namplitude modulation method. What should be the minimum size of antenna required to transmit the \nmodulated signal?",
                options = listOf("42.8 m", "42.8 mm", "21.4 mm", "21.4 m"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nνc = 3.5 × 109\n Hz \n∴ λ = 9\n8\nc 3.5 10\nc 3 10\n×\n× = ν\n∴ Size of antenna = \n4\nλ\n = \n4\n8.57 10–2 × = 21.4 mm",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q17_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Physics Q17]\\nA Carnot engine whose heat sinks at 27°C, has an efficiency of 25%. By how many degrees should the \ntemperature of the source be changed to increase the efficiency by 100% of the original efficiency?",
                options = listOf("Increases by 18°C", "Increases by 200°C", "Increases by 120°C", "Increases by 73°C"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nInitially : 4\n1 = 1 – \nTH\n300\n⇒ TH = 400 K \n Finally : Efficiency becomes 2\n1\n⇒\n2\n1 = 1 – ′ TH\n300\n⇒ ′ TH = 600 K \n⇒ Temperature of the source increases by 200ºC",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q18_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Physics Q18]\\nA parallel plate capacitor is formed by two plates each of area 30π cm\n2\n separated by 1 mm. A material of \ndielectric strength 3.6 × 107\n Vm–1 is filled between the plates. If the maximum charge that can be stored on \nthe capacitor without causing any dielectric breakdown is 7 × 10–6 C, the value of dielectric constant of the \nmaterial is : \n[Use 4 0\n1\nπε\n= 9 × 109\n Nm2\n C–2]",
                options = listOf("1.66", "1.75", "2.25", "2.33"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nField inside the dielectric = \nk 0 ε\nσ\n According to the given information, \nk 0 ε\nσ = 3.6 × 107 \n⇒\nk 0\nA\nQ\nε\n = 3.6 × 107\n⇒ k = 2.33",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q19_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Physics Q19]\\nThe magnetic field at the centre of a circular coil of radius r, due to current I flowing through it, is B. The \nmagnetic field at a point along the axis at a distance 2\nr from the centre is :",
                options = listOf("2\nB", "2B", "B\n5\n2\n3\n⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛", "B\n3\n2\n3\n⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nB = \n2r\nµ I0\n Ba = \n⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\n+\n4\nr 2 r\nµ Ir\n2\n2\n2\n0\n⇒\nB\nBa = \n3\n5\n2\n⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\n⇒ Ba = \n3\n5\n2\n⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛ B",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q20_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Physics Q20]\\nTwo metallic blocks M1 and M2 of same area of cross-section are connected to each other (as shown in \nfigure). If the thermal conductivity of M2 is K then the thermal conductivity of M1 will be : \n[Assume steady state heat conduction]",
                options = listOf("10 K", "8K", "12.5K", "2K"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nThermal current is same so \nK A\nl\nT\nK A\nl\nT\ndt\ndQ\n2\n2\n2\n1\n1\n1 Δ = Δ =\n or K\n8\n80 K\n16\n20 × ′ = × ⇒ K′ = 8K\nSection-B: This section contains 10 questions. In Section-B, attempt any five questions out of 10. The answer \nto each of the questions is a numerical value. For each question, enter the correct numerical value (in decimal \nnotation, truncated/rounded-off to the second decimal place; e.g. 06.25, 07.00, –00.33, –00.30, 30.27, –27.30). \nEach question carries 4 marks for correct answer and –1 mark for wrong answer.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q21_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Physics Q21]\\n0.056 kg of Nitrogen is enclosed in a vessel at a temperature of 127°C. The amount of heat required to \ndouble the speed of its molecules is ___ k cal. (Take R = 2 cal mol–1 K–1)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 12.00\\nSolution:\\nBecause the vessel is closed, it will be an isochoric process. \nTo double the speed, temperature must be 4 times (v α T ) \n So Tf = 1600 K, Ti = 400 K \n number of moles are \n28\n56 = 2 \n so Q = nCv ΔT = 2 × \n2\n5 × 2 × 1200 = 12000 cal = 12 K cal",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q22_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Physics Q22]\\nTwo identical thin biconvex lenses of focal length 15 cm and refractive index 1.5 are in contact with each \nother. The space between the lenses is filled with a liquid of refractive index 1.25. The focal length of the \ncombination is ___ cm.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 10.00\\nSolution:\\nl f\n1\n= ⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛ –1\nµ\nµ\nm\ne\n⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\n1 R2\n1 – R\n1\n here |R1| = |R2| = R \n⇒\n1l f\n1 = (1.5 – 1) ⎟\n⎠\n⎞ ⎜\n⎝\n⎛\nR\n2\n = \n15\n1\n⇒\n15\n1\nR\n1 = or R = 15 cm \n for the concave lens made up of liquid \n2l f\n1 = (1.25 – 1) ⎟\n⎠\n⎞ ⎜\n⎝\n⎛\nR\n2 – = –\n30\n1\ncm \n now for equivalent lens \n1 2 e l l f\n1\nf\n2\nf\n1 = + \n = \n10\n1\n30\n3\n30\n1 – 15\n2 = =\n or fe = 10 cm",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q23_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Physics Q23]\\nA transistor is used in common-emitter mode in an amplifier circuit. When a signal of 10 mV is added to the \nbase-emitter voltage, the base current changes by 10 μA and the collector current changes by 1.5 mA. The \nload resistance is 5 kΩ. The voltage gain of the transistor will be ___.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 750.00\\nSolution:\\nRB = –6\n–3\n10 10\n10 10\n×\n× = 103 Ω \n ∴ AV = ⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\n×⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\nΔ\nΔ\nB\nC\nB\nC\nR\nR\nl\nl \n = 3\n3\n–6\n–3\n1 10\n5 10\n10 10\n1.5 10\n×\n× × ×\n× = \n10\n1.5×5 × (1000) = 750",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q24_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Physics Q24]\\nAs shown in the figure an inductor of inductance 200 mH is connected to an AC source of emf 220 V and \nfrequency 50 Hz. The instantaneous voltage of the source is 0 V when the peak value of current is Aa\nπ . \nThe value of a is ___.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 242.00\\nSolution:\\nIrms = z\nVrms\n z = X2 = ω2 \n = 2π × 50 × \n1000\n200 = 20π \n ∴ Irms = \n20π\n220\n = \nπ\n11\n∴ Ipeak = \nπ ×11 2\n = \nπ\n2×121\n= \nπ\n242",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q25_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Physics Q25]\\nSodium light of wavelengths 650 nm and 655 nm is used to study diffraction at a single slit of aperture 0.5 \nmm. The distance between the slit and the screen is 2.0 m. The separation between the positions of the first \nmaxima of diffraction pattern obtained in the two cases is _____ × 10–5\n m.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 3.00\\nSolution:\\nPosition of 1st maxima is \na\nD\n2\n3 λ\n⇒ According to given values, required separation \n = \n2\n3 × (655 nm – 650 nm) × 0.5mm\n2m\n⇒ Required separation = 3 × 10–5\n m.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q26_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Physics Q26]\\nWhen light of frequency twice the threshold frequency is incident on the metal plate, the maximum velocity \nof emitted electron is v1. When the frequency of incident radiation is increased to five times the threshold \nvalue, the maximum velocity of emitted electron becomes v2. If v2 = x v1, the value of x will be ________.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 2.00\\nSolution:\\nSol. Let us say the work function is φ \n⇒ 2φ = φ + 2 mv1 2\n1 … (1) \n and 5φ = φ + 2 mv2 2\n1 … (2) \n From (1) and (2) \n1\n4\nv\nv\n2\n1\n2\n2 = or \n1\n2\nv\nv = 2",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q27_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Physics Q27]\\nFrom the top of a tower, a ball is thrown vertically upward which reaches the ground in 6 s. A second ball \nthrown vertically downward from the same position with the same speed reaches the ground in 1.5 s. A third \nball released, from the rest from the same location, will reach the ground in ____ s.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 3.00\\nSolution:\\nBased on the situation \n h = – ut1 + 2\n1 gt\n2\n1 → throwing up …(i) \n h = ut2 + 2\n2 gt\n2\n1 → throwing down …(ii) \n h = \n2\n1\ngt2\n → dropping … (iii) \n and 0 = (t1 – t2) – 2\n1 g (t1 – t2)\n2 … (iv) \n solving above equations \n t = 1 2 t t\n⇒ t = 6×1.5 = 3s",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q28_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Physics Q28]\\nA ball of mass 100 g is dropped from a height h =10 cm on a platform fixed at the top of a vertical spring (as \nshown in figure). The ball stays on the platform and the platform is depressed by a distance 2\nh . The spring \nconstant is ______ Nm–1. \n(Use g = 10 ms–2)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 120.00\\nSolution:\\nmg ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ +\n2\nh h = \n2\n2\nh k\n2\n1 ⎟\n⎠\n⎞ ⎜\n⎝\n⎛\n⇒ 0.1 × 10 × (0.15) = 2 k(0.05) 2\n1\n⇒ k = 120 N/m",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q29_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Physics Q29]\\nIn a potentiometer arrangement, a cell gives a balancing point at 75 cm length of wire. This cell is now \nreplaced by another cell of unknown emf. If the ratio of the emf's of two cells respectively is 3 : 2, the \ndifference in the balancing length of the potentiometer wire in above two cases will be _____cm.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 25.00\\nSolution:\\nAt balancing point, we know that emf is proportional to the balancing length. i.e., \nemf ∝ balancing length \n Now, let the emf’s be 3ε and 2ε. \n⇒ 3ε = k(75) …(1) \n and 2ε = k() …(2) \n⇒  = 50 cm \n⇒ Difference is (75 – 50) cm = 25 cm.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q30_phys",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Physics Q30]\\nA metre scale is balanced on a knife edge at its centre. When two coins, each of mass 10 g are put one on the \ntop of the other at the 10.0 cm mark the scale is found to be balanced at 40.0 cm mark. The mass of the metre \nscale is found to be x × 10–2 kg. The value of x is _________.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 6.00\\nSolution:\\nIf λ is the mass per unit length of the scale then \n 0.02 × (30) × 10 + λ40 × 20 × 10 = λ60 × 30 × 10 \n 0.006 = λ10 \n Or 100λ = 0.06 kg \n = 6 × 10–2 kg \n⇒ x = 6",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q31_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Chemistry Q31]\\nIf a rocket runs on a fuel (C15H30) and liquid oxygen, the weight of oxygen required and CO2 released for \nevery litre of fuel respectively are : \n(Given : density of the fuel is 0.756 g/mL)",
                options = listOf("1188 g and 1296 g", "2376 g and 2592 g", "2592 g and 2376 g", "3429 g and 3142 g"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nC15H30 + \n2\n45 O2 → 15CO2 + 15H2O \nOne litre of fuel has a mass (0.756) × 1000 g. \n∴ moles of C15H30 = \n210\n756 \n Moles of O2 required = 210\n756\n2\n45 ×\n Mass of O2 required = 210\n756\n2\n45 × × 32 g = 2592 g \n Mass of CO2 formed = 15 ×\n210\n756 × 44 = 2376 g",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q32_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Chemistry Q32]\\nConsider the following pairs of electrons \n (A) (a) n = 3, l = 1, m1 = 1, ms = +\n2\n1 (B) (a) n = 3, l = 2, m1 = –2, ms = –\n2\n1 \n (b) n = 3, l = 2, m1 = 1, ms = +\n2\n1 (b) n = 3, l = 2, m1 = –1, ms = –\n2\n1\n (C) (a) n = 4, l = 2, m1 = 2, ms = +\n2\n1 \n (b) n = 3, l = 2, m1 = 2, ms = +\n2\n1\n The pairs of electrons present in degenerate orbitals is /are:",
                options = listOf("Only (A)", "Only (B)", "Only (C)", "(B) and (C)"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nFor degenerate orbitals, only the value of m must be different. The value of ‘n’ and ‘l’ must be the same. \nHence, the pair of electrons with quantum numbers given in (B) are degenerate.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q33_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Chemistry Q33]\\nMatch List-I with List-II : \n List-I List-II \n (A) [PtCl4]\n2– (I) sp3\nd \n (B) BrF5 (II) d2\nsp\n3\n (C) PCl5 (III) dsp2\n (D) [Co(NH3)6]\n3+ (IV) sp3\nd2\n Choose the most appropriate answer from the options given below.",
                options = listOf("(A)-(II), (B)-(IV), (C)-(I), (D)-(III)", "(A)-(III), (B)-(IV), (C)-(I), (D)-(II)", "(A)-(III), (B)-(I), (C)-(IV), (D)-(II)", "(A)-(II), (B)-(I), (C)-(IV), (D)-(III)"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nComplex/compound Hybridisation of central atoms \n (A) [PtCl4]–2 (III) dsp2\n (B) BrF5 (IV) sp3\nd2\n (C) PCl5 (I) sp3\nd \n (D) [Co(NH3)6]\n+3 (II) d2\nsp\n3\n Hence, the most appropriate answer is given in option (2)",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q34_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Chemistry Q34]\\nFor a reaction at equilibrium \n A(g) B(g) + 2\n1 C(g) \nthe relation between dissociation constant (K), degree of dissociation (α) and equilibrium pressure (p) is \ngiven by :",
                options = listOf("K = \n(1– ) 2\n3 1\np\n2\n1\n2\n3\n2\n1\n⎟ α ⎠\n⎞ ⎜\n⎝\n⎛ + α\nα", "K = \n() 2 (1– )\np\n2\n1\n2\n1\n2\n3\n+ α α\nα", "K =\n(1– ) 2\n3 1\n( p)\n2\n1\n2\n3\n⎟ α ⎠\n⎞ ⎜\n⎝\n⎛ + α\nα", "K = \n2\n1\n2\n3\n(1 )(1– )\n( p)\n+ α α\nα"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nA(g) B(g) + 2\n1 C(g)\n t = 0 pi – – \n(eq.mconditions)\nt = t pi – piα piα \n2\npiα\n∴ P (equilibrium pressure) = pi – piα + piα + \n2\npiα\n = pi ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ α\n+\n2\n1\n∴ pi = \n⎟\n⎠\n⎞ ⎜\n⎝\n⎛ α\n+\n2\n1\np\n Kp = \np (1– )\np 2 p\ni\ni\n1/ 2\ni\nα\n⎟ × α ⎠\n⎞ ⎜\n⎝\n⎛ α\n= \n2\n1\n2\n1\n2\n3\n2\n1\n2\n1\n(1– ) 2\n1\np ×\n⎟ α ⎠\n⎞ ⎜\n⎝\n⎛ α\n+\nα\n = \n(2 ) (1– )\np\n1/ 2\n2\n3\n2\n1\n+ α α\nα\n Hence the correct option is (2)",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q35_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Chemistry Q35]\\nGiven below are two statements: \n Statement I : Emulsion of oil in water are unstable and sometimes they separate into two layers on standing. \nStatement II : For stabilisation of an emulsion, excess of electrolyte is added. \n In the light of the above statements, choose the most appropriate answer from the options given below:",
                options = listOf("Both Statement I and Statement II are correct", "Both Statement I and Statement II are incorrect.", "Statement I is correct but Statement II is incorrect.", "Statement I is incorrect but Statement II is correct."),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nOil in water emulsions can sometimes separate into two layers on standing. \nThe most relevant example for the above case is milk, which can separate into two layers on standing for a \nlonger time. Therefore, statement (I) is correct. \n On adding excess of electrolyte, coagulation occurs and emulsion is further destabilised. \n Therefore, statement (II) is incorrect.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q36_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Chemistry Q36]\\nGiven below are the oxides: \nNa2O, As2O3, N2O, NO and Cl2O7 \nNumber of amphoteric oxides is:",
                options = listOf("0", "1", "2", "3"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nOxides \nNa2O ⎯→Basic \n As2O3 ⎯→ Amphoteric \n N2O ⎯→ Neutral \n NO ⎯→ Neutral \n Cl2O7 ⎯→ Acidic \n Hence, only one amphoteric oxide is present.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q37_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Chemistry Q37]\\nMatch List-I with List -II : \n List-I List-II \n (A) Sphalerite (I) FeCO3\n (B) Calamine (II) PbS \n (C) Galena (III) ZnCO3\n (D) Siderite (IV) ZnS \n Choose the most appropriate answer from the options given below:",
                options = listOf("(A)-(IV), (B)-(III), (C)-(II), (D)-(I)", "(A)-(IV), (B)-(I), (C)-(II), (D)-(III)", "(A)-(II), (B)-(III), (C)-(I), (D)-(IV)", "(A)-(III), (B)-(IV), (C)-(II), (D)-(I)"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nOres Formula\n (A) Sphalerite (IV) ZnS \n (B) Calamine (III) ZnCO3\n (C) Galena (II) PbS \n (D) Siderite (I) FeCO3\n Hence, the most appropriate option is (1).",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q38_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Chemistry Q38]\\nThe highest industrial consumption of molecular hydrogen is to produce compounds of element:",
                options = listOf("Carbon", "Nitrogen", "Oxygen", "Chlorine"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nHydrogen combines with nitrogen to produce Ammonia in Haber's process. \nN2(g) + 3H2(g) 2NH3 (g) \n In this process, iron oxide is used with small amounts of K2O and Al2O3 to increase the rate of attainment of \nequilibrium. \n Optimum conditions for the production of ammonia are a pressure of 200 atm and a temperature of 700K. \n Earlier, iron was used as a catalyst with molybdenum as promoter in this reaction.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q39_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Chemistry Q39]\\nWhich of the following statements are correct? \n(A) Both LiCl and MgCl2 are soluble in ethanol. \n (B) The oxides Li2O and MgO combine with excess of oxygen to give superoxide. \n (C) LiF is less soluble in water than other alkali metal fluorides. \n (D) Li2O is more soluble in water than other alkali metal oxides. \n Choose the most appropriate answer from the options given below:",
                options = listOf("(A) and (C) only", "(A), (C) and (D) only", "(B) and (C) only", "(A) and (D) only"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n(A) Both LiCl and MgCl2 are covalent in nature due to high polarizing power of Li+\n and Mg+2 ions. \n Hence, they are soluble in ethanol. \n (B) Oxides of Li2O and MgO do not form superoxide \n (C) LiF is least soluble among all other alkali metal fluorides due to high lattice energy of LiF \n (D) Li2O is least soluble among all other alkali metal oxides. \n Hence, Statements (A) and (C) are correct.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q40_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Chemistry Q40]\\nIdentify the correct statement for B2H6 from those given below: \n(A) In B2H6, all B-H bonds are equivalent. \n (B) In B2H6, there are four 3-centre-2-electron bonds. \n (C) B2H6 is a Lewis acid. \n (D) B2H6 can be synthesized from both BF3 and NaBH4. \n (E) B2H6 is a planar molecule. \n Choose the most appropriate answer from the options given below:",
                options = listOf("(A) and (E) only", "(B), (C) and (E) only", "(C) and (D) only", "(C) and (E) only"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nStructure of B2H6\nIt has two 3-centre-2-electron bonds and four 2-centre-2-electron bonds. \n Hence, all B–H bonds are not equivalent. \n It is an electron deficient compound as the octet of boron is incomplete. \n Hence, it can behave as a Lewis acid. \n It can be synthesized from both BF3 and NaBH4 \n 2BF3 + 6NaH ⎯450 ⎯→⎯K B2H6 + 6NaF \n 2NaBH4 + I2 ⎯→ B2H6 + 2NaI + H2 \nIt is a non-planar molecule. \n Hence, only Statements (C) and (D) are correct.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q41_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Chemistry Q41]\\nThe most stable trihalide of nitrogen is: \n (A) NF3 (B) NCl3 (C) NBr3 (D) NI3",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 1\\nSolution:\\nThe most stable trihalide is NF3 \nOrder of stability: NF3 > NCl3 > NBr3 > NI3 \n NCl3 is explosive is nature. \n NBr3 and NI3 are known only as ammoniates. The stability of trihalides decreases down the group due to \nweakening of N – X bond and inability of N to accommodate large sized halogen atoms (Cl, Br, I) around it.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q42_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Chemistry Q42]\\nWhich one of the following elemental forms is not present in the enamel of the teeth? \n (1) Ca2+ (2) P3+ (C) F– (4) P5+",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 2\\nSolution:\\nP+3 is not present is enamel of teeth. \nTh compound present is [3Ca3(PO4)2·CaF2] \n Which contains Ca+2, P+5 & F–",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q43_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Chemistry Q43]\\nIn the given reaction sequence, the major product ‘C’ is:",
                options = listOf("", "", "", ""),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q44_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Chemistry Q44]\\nTwo statements are given below: \n Statement I: The melting point of monocarboxylic acid with even number of carbon atoms is higher than \nthat of with odd number of carbon atoms acid immediately below and above it in the series. \n Statement II: The solubility of monocarboxylic acids in water decreases with increase in molar mass. \nChoose the most appropriate option:",
                options = listOf("Both Statement I and Statement II are correct.", "Both Statement I and Statement II are incorrect.", "Statement I is correct but Statement II is incorrect.", "Statement I is incorrect but Statement II is correct."),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nStatement (I) is correct as monocarboxylic acids with even number of carbon atoms show better packing \nefficiency in solid state, statement (II) is also correct as the solubility of carboxylic acids decreases with \nincrease in molar mass due to increase in the hydrophobic portion with increase in the number of carbon atoms.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q45_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Chemistry Q45]\\nWhich of the following is an example of conjugated diketone?",
                options = listOf("", "", "", ""),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nis a conjugated diketone. \nIn rest of the diketones given in the question, the two (C = O) groups are not in conjugation with each other.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q46_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Chemistry Q46]\\n- \nThe major product of the above reactions is :",
                options = listOf("", "", "", ""),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nHence, the correct option is (D).",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q47_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Chemistry Q47]\\nWhich of the following is an example of polyester ? -",
                options = listOf("Butadiene-styrene copolymer", "Melamine polymer", "Neoprene", "Poly-β-hydroxybutyrate-co-β-hydroxy valerate"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nPolyesters are formed by condensation reaction between alcohols and carboxylic acid. \nPoly-β-hydroxybutyrate-co-β-hydroxy valerate (PHBV) is a polymer obtained by condensation reaction of \n3-hydroxybutanoic acid with 3-hydroxypentanoic acid. \nHence, PHBV is a polyester",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q48_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Chemistry Q48]\\nA polysaccharide ‘X’ on boiling with dil. H2SO4 at 393 K under 2-3 atm pressure yields ‘Y’. ‘Y’ on \ntreatment with bromine water gives gluconic acid. ‘X’ contains β-glycosidic linkages only. Compound ‘X’ is",
                options = listOf("starch", "cellulose", "amylose", "amylopectin"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nCellulose contains β-glycosidic linkages only. \nStructure of cellulose \nOn boiling with dil. H2SO4 at 393 K under 2-3 atm, ‘X’ forms glucose, which given gluconic acid on \ntreatment with bromine water.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q49_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Chemistry Q49]\\nWhich of the following is not a broad-spectrum antibiotic ?",
                options = listOf("Vancomycin", "Ampicillin", "Ofloxacin", "Penicillin G"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nPenicillin G is a narrow spectrum antibiotic. (Based on fact)",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q50_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Chemistry Q50]\\nDuring the qualitative analysis of salt with cation y\n2+, addition of a reagent (X) to alkaline solution of the salt \ngives a bright red precipitate. The reagent (X) and the cation (y\n2+) present respectively are:",
                options = listOf("Dimethylglyoxime and Ni2+", "Dimethylglyoxime and Co2+", "Nessler’s reagent and Hg2+", "Nessler’s reagent and Ni2+"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nOn addition of dimethylglyoxime to alkaline solution of Ni+2, a bright red ppt. is obtained. \nNi+2 + 2dmg → [Ni(dmg)2]\n+2 (Bright red ppt) \nSection-B: This section contains 10 questions. In Section-B, attempt any five questions out of 10. The answer \nto each of the questions is a numerical value. For each question, enter the correct numerical value (in decimal \nnotation, truncated/rounded-off to the second decimal place; e.g. 06.25, 07.00, –00.33, –00.30, 30.27, –27.30). \nEach question carries 4 marks for correct answer and –1 mark for wrong answer.\nNUMERICAL VALUE. For each question, enter the correct numerical value (in decimal notation, \ntruncated/rounded-off to the second decimal place; e.g. 06.25, 07.00, –00.33, –00.30, 30.27, –27.30) using the mouse \nand the on-screen virtual numeric keypad in the place designated to enter the answer.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q51_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Chemistry Q51]\\nAtoms of element X form hcp lattice and those of element Y occupy 3\n2 of its tetrahedral voids. The \npercentage of element X in the lattice is _______ . (Nearest integer)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 43.00\\nSolution:\\nSince X occupies hcp lattice, \nNumber of particles of type X in a unit cell = 6 \nNumber of particles of type Y = 3\n2 × 12 = 8 \n∴ Percentage of element X = 14\n6 × 100 = \n7\n300 = 42.85 ~ 43%",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q52_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Chemistry Q52]\\n2O3 (g) 3O2(g) \nAt 300 K, ozone is fifty percent dissociated. The standard free energy change at this temperature and 1 atm \npressure is (–) ____ J mol–1. (Nearest integer) [Given: In 1.35 = 0.3 and R = 8.3 J K–1 mol–1]",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 747.00\\nSolution:\\n2O3 (g) 3O2(g) \n 1 – x \n2\n3x\n Given, x = 0.5 \n∴ kp =\n[2] (0.5) 1.25\n[3(0.5)] 1\n3 2\n3\n× ×\n×\n∴ kp = 1.25\n0.5\n8\n27\n× = 1.35 \nΔGº = −2.303 RT log kp\n= – 2.303 × 8.3 × 300 log 1.35 = – 8.3 × 300 ln(1.35) = – 747 J mol–1",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q53_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Chemistry Q53]\\nThe osmotic pressure of blood is 7.47 bar at 300 K. To inject glucose to a patient intravenously, it has to be \nisotonic with blood. The concentration of glucose solution in gL–1 is _______. (Molar mass of glucose = 180 \ng mol–1 \nR = 0.083 L bar K–1 mol–1) (Nearest integer)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 54.00\\nSolution:\\n7.47 = C × 0.083 × 300 \n(π = CRT) \n(Where C represents the concentration of glucose solution and π represents osmotic pressure) \nC = \n0.083 300\n7.47\n×\nC (mol L–1) \nwhich in gm/L = 0.083 300\n7.47\n×\n× 180 = 54 gm/",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q54_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Chemistry Q54]\\nThe cell potential for the following cell \nPt | H2(g) | H+\n (aq) || Cu2+ (0.01 M) | Cu(s) \n is 0.576 V at 298 K. The pH of the solution is ___ . (Nearest integer) \n (Given: o\nCu /Cu E 2+ = 0.34 V and \nF\n2.303RT = 0.06 V)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 5.00\\nSolution:\\nEcell = \n[Cu ]\n[H ] log 2\n0.06 E 2\n2 o\ncell +\n⊕\n−\n0.576 = 0.34 – 0.03 log [0.01]\n[H ] ⊕ 2\n0.576 – 0.34 = – 0.03 log [H⊕]\n2\n + 0.03 log(0.01) = 0.06 pH – 0.06 \npH = 4.93 = 5",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q55_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Chemistry Q55]\\nThe rate constants for decomposition of acetaldehyde have been measured over the temperature range 700 – \n1000 K. The data has been analysed by plotting In k vs T\n103\ngraph. The value of activation energy for the \nreaction is ______ kJ mol–1. (Nearest integer) (Given : R = 8.31 J K–1 mol–1)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 154.00\\nSolution:\\nIn k = In A – \nRT\nEa\nSlope of the graph = – 3\na\nR 10\nE\n×\n= – 18.5 \n∴ Ea = 18.5 × 8.31 × 1000 = 154 kJ mol–1",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q56_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Chemistry Q56]\\nThe difference in oxidation state of chromium in chromate and dichromate salts is ______,",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 0.00\\nSolution:\\nChromate ion → 2− CrO , oxidation state of Cr = +6 4\nDichromate ion → 2− CrO , oxidation state of Cr = +6 4\n∴ Difference in oxidation state = zero",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q57_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Chemistry Q57]\\nIn the cobalt-carbonyl complex: [Co2(CO)8], number of Co-Co bonds is “X” and terminal CO ligands is “Y”. \nX + Y = _______.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 7.00\\nSolution:\\nStructure of Co2(CO)8 \n Number of Co – Co bonds = 1 = X \nNumber of terminal CO ligands = 6 = Y \n∴ X + Y = 1 + 6 = 7",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q58_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Chemistry Q58]\\nA 0.166 g sample of an organic compound was digested with conc. H2SO4 and then distilled with NaOH. The \nammonia gas evolved was passed through 50.0 mL of 0.5 N H2SO4. The used acid required 30.0 mL of 0.25 \nN NaOH for complete neutralisation. The mass percentage of nitrogen in the organic compound is ________.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 63.00\\nSolution:\\nMillimoles of used acid = \n2\n30×0.25\nMillimoles of NH3 = 30 × 0.25 = 7.5 \nMass % of nitrogen = 0.166\n7.5 × 10–3 × 14 ×100 = 63%",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q59_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Chemistry Q59]\\nNumber of electrophilic centres in the given compound is ______.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 3.00\\nSolution:\\nGiven compounds : \n Number of electrophilic centres = 3",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q60_chem",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Chemistry Q60]\\nThe major product ‘A’ of the following given reaction has ______ sp\n2\n hybridized carbon atoms. \n2, 7-Dimethyl-2, 6-octadiene ⎯⎯→⎯\n+ H\nMajor Product\nA",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 2.00\\nSolution:\\nNumber of sp\n2\n hybridised carbon atoms = 2",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q61_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Mathematics Q61]\\nLet A = {z ∈ C : 1 ≤ |z – (1 + i)| ≤ 2} and B = {z ∈ A : |z – (1 – i)| = 1}. Then, B :",
                options = listOf("Is an empty set", "Contains exactly two elements", "Contains exactly three elements", "Is an infinite set"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nSet A represents region 1 i.e. R1 and clearly set B has infinite points in it.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q62_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Mathematics Q62]\\nThe remainder when 32022 is divided by 5 is :",
                options = listOf("1", "2", "3", "4"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n32022 = (10 – 1)1011\n = \n1011C0(10)1011 (–1)0\n + 1011C1(10)1010 (–1)1\n + ..... + 1011C1010(10)1\n (–1)1010 + 1011C1011(10)0\n(–1)1011 \n= 5k –1, where k ∈ I \n So when divided by 5, it leaves remainder 4.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q63_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Mathematics Q63]\\nThe surface area of a balloon of spherical shape being inflated, increases at a constant rate. If initially, the \nradius of balloon is 3 units and after 5 seconds, it becomes 7 units, then its radius after 9 seconds is :",
                options = listOf("9", "10", "11", "12"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nS = 4πr\n2\ndt\ndS = 8πr \ndt\ndr \ndt\ndS\n= constant so ⇒ r\ndt\ndr = k (Let) \nr dr = k dt ⇒\n2\nr\n2\n = kt + C \nat t = 0, r = 3 \n2\n9 = C \nat t = 5, \n2\n49 = k . 5 + \n2\n9\n⇒ K = 4 \nAt t = 9, 2\nr\n2\n= \n2\n81\nSo, r = 9",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q64_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Mathematics Q64]\\nBag A contains 2 white, 1 black and 3 red balls and bag B contains 3 black, 2 red and n white balls. One bag \nis chosen at random and 2 balls drawn from it at random, are found to be 1 red and 1 black. If the probability \nthat both balls come from Bag A is 11\n6 , then n is equal to _______.",
                options = listOf("13", "6", "4", "3"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nP(1R and 1B) = P(A) . P ⎟\n⎠\n⎞ ⎜\n⎝\n⎛\nA\n1R.1B + P(B) . P ⎟\n⎠\n⎞ ⎜\n⎝\n⎛\nB\n1R.1B\n = \n2 n 5\n1\n3\n1\n2\n2\n6\n1\n1\n1\n3\nC\nC . C .\n2\n1\nC\nC . C .\n2\n1\n+ +\n P ⎟\n⎠\n⎞ ⎜\n⎝\n⎛\nA\n1R1B\n = \n(n 5)(n 4)\n6.2 .\n2\n1\n15\n3 .\n2\n1\n15\n3 .\n2\n1\n+ +\n+\n = \n11\n6\n⇒\n(n 5)(n 4)\n6\n10\n1\n10\n1\n+ +\n+\n = \n11\n6\n⇒\n(n 5)(n 4)\n36\n10\n6\n10\n11\n+ + = +\n⇒\n(n 5)(n 4)\n1\n10 36\n5\n+ + = ×\n⇒ n\n2\n + 9n – 52 = 0 \n⇒ n = 4 is only possible value",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q65_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Mathematics Q65]\\nLet x2\n + y2\n + Ax + By +C = 0 be a circle passing through (0, 6) and touching the parabola y = x2\n at (2, 4). \nThen A + C is equal to ________.",
                options = listOf("16", "5\n88", "72", "–8"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nFor tangent to parabola y = x2\n at (2, 4) \n(2,4) dx\ndy = 4 \nEquation of tangent is \ny – 4 = 4(x – 2) \n⇒ 4x – y – 4 = 0 \nFamily of circle can be given by \n(x – 2)2\n + (y – 4)2\n + λ(4x – y – 4) = 0 \nAs it passes through (0, 6) \n22\n + 22\n + λ(–10) = 0 \n⇒ λ = \n5\n4\nEquation of circle is \n(x – 2)2\n + (y – 4)2\n + \n5\n4 (4x – y – 4) = 0 \n⇒ (x2\n + y2\n – 4x – 8y + 20) + ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ − 5\n16\ny\n5\n4\nx – 5\n16 = 0 \nA= − 4 + \n5\n16 , C = 20 – 5\n16\nSo, A + C = 16",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q66_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Mathematics Q66]\\nThe number of values of α for which the system of equations : \nx + y + z = α \nαx + 2αy + 3z = –1 \nx + 3αy + 5z = 4 \nis inconsistent, is",
                options = listOf("0", "1", "2", "3"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nΔ = \n1 3 5\n2 3\n1 1 1\nα\nα α\n= 1(10α – 9α) – 1 (5α – 3) + 1 (3α\n2\n – 2α) \n= α – 5α + 3 + 3α\n2\n – 2α \n= 3α\n2\n – 6α + 3 \nFor inconsistency Δ = 0 i.e. α = 1 \nNow check for α = 1 \nx + y + z = 1 …(i) \nx + 2y + 3z = –1 …(ii) \nx + 3y + 5z = 4 …(iii) \nBy (ii) × 2 – (i) × 1 \nx + 3y + 5z = –3 \nso equations are \ninconsistent for α = 1",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q67_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Mathematics Q67]\\nIf the sum of the squares of the reciprocals of the roots α and β of the equation 3x2\n + λx – 1 = 0 is 15, then \n6(α3\n + β3\n)\n2\n is equal to :",
                options = listOf("18", "24", "36", "96"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n2 2\n1 1\nβ\n+\nα\n= 15 ⇒ 2 2\n2 ( ) 2\nα β\nα + β − αβ = 15 \n⇒\n9\n1\n3\n2\n9\n2\n+\nλ\n = 15 ⇒\n9\n2λ = 1 ⇒ λ2\n = 9 \nα3\n+ β3\n = (α + β) (α2\n + β2 – αβ) \n = ⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛ ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ − − λ ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ − λ\n3\n1 3\n3 9\n2\n = ⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\n+\nλ ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ − λ 1\n3 9\n2\n = \n3\n− 2λ\n 6(α3\n + β3\n)\n2\n = 6.\n9\n4 2λ = 24",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q68_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Mathematics Q68]\\nThe set of all values of k for which (tan–1x)3 + (cot–1x)3 = kπ\n3\n, x ∈ R, is the interval :",
                options = listOf("⎟\n⎠\n⎞ ⎢\n⎣\n⎡\n8\n7\n, 32\n1", "⎟\n⎠\n⎞ ⎜\n⎝\n⎛\n16\n13\n, 24\n1", "⎥\n⎦\n⎤ ⎢\n⎣\n⎡\n16\n13\n, 48\n1", "⎟\n⎠\n⎞ ⎢\n⎣\n⎡\n8\n9\n, 32\n1"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nLet tan–1x = t ∈ ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ − π π\n2\n, 2\ncot–1\nx = \n2\nπ\n – t \nƒ(t) = t3\n + \n3\nt\n2 ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ − π\n⇒ f '(t) = 3t2\n – 3 \n2\nt\n2 ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ − π\nf '(t) = 0 at t = 4\nπ f ' \nf(t)|min = \n64 64 32\n3 3 3 π = π\n+\nπ \nMax will occur around t = –\n2\nπ\nRange of f (t) = ⎟\n⎟\n⎠\n⎞\n⎢\n⎢\n⎣\n⎡π π\n8\n7\n, 32\n3 3\nk ∈ ⎟\n⎠\n⎞ ⎢\n⎣\n⎡\n8\n7\n, 32\n1",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q69_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Mathematics Q69]\\nLet S = { n :1 ≤ n ≤ 50 and n is odd} \nLet a ∈ S and A = \na 0 1\n1 1 0\n1 0 a\n−\n−\n If ∑\na∈S\ndet (adj A) = 100 λ, then λ is equal to :",
                options = listOf("218", "221", "663", "1717"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n|A| = a2\n + 1 \n|adj A| = (a2\n + 1)2\nS = {1, 3 , 5 , 7 , ...... 49 } \n∑\na∈S\ndet (adj A) = (12\n + 1)2\n + (3 + 1)2\n + (5 + 1)2\n + … + (49 + 1)2\n= 22\n (12\n + 22\n + 32\n + … + 252\n) = 4 ⋅ 6\n25.26.51 = 100⋅221 \nλ = 221",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q70_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Mathematics Q70]\\nFor the function f(x) = 4 loge(x – 1) – 2x2\n + 4x + 5, x > 1, which one of the following is NOT correct ? \n(1) f is increasing in (1, 2) and decreasing in (2, ∞) \n(2) f(x) = –1 has exactly two solutions \n(3) f ′(e) – f ′(2) < 0 \n(4) f(x) = 0 has a root in the interval (e, e + 1)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 3\\nSolution:\\nf ′(X) = \nx 1\n4\n− – 4x + 4 = \nx 1\n4(2x x ) 2\n−\n−\nSo maxima occurs at x = 2 \nf(2) = 4⋅0 – 2⋅22\n + 4⋅2 + 5 = 5 \nso clearly f(x) = –1 has \nexactly 2 solutions \nf ″(x) = 2 (x 1)\n4(2 2x)(x 1)\n−\n− − – (2x – x2\n) \nso f ′(e) – f ″ (2) > 0 \nso option (3) is not correct",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q71_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Mathematics Q71]\\nIf the tangent at the point (x1, y1) on the curve y = x3\n + 3x2\n + 5 passes through the origin, then (x1, y1) does \nNOT lie on the curve :",
                options = listOf("x2\n + \n81\ny\n2\n = 2", "9\ny\n2\n– x\n2\n = 8", "y = 4x2\n + 5", "3\nx\n– y\n2\n = 2"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nmop – mTangent \n1\n1\nx\ny = 1\n2 3x1 + 6x\n⇒\n1\n2\n1\n3\n1\nx\nx + 3x + 5\n = 1\n2 3x1 + 6x ⇒ x 3x 5 2\n1\n3\n1 + + = \n2\n1\n3 3x1 + 6x\n⇒ 5 2x 3x\n2\n1\n3\n1 + − = 0 ⇒ (x1 − 1)(2 2 x + 5x 1 1 + 5) = 0 \nSo, (x1, y1) = (1, 9)",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q72_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Mathematics Q72]\\nThe sum of absolute maximum and absolute minimum values of the function f(x) = |2x2\n + 3x – 2| + sinx cosx \nin the interval [0, 1] is : \n (1) 2\n2\n1 sin(1) cos\n3\n2 ⎟\n⎠\n⎞ ⎜\n⎝\n⎛\n+ (2) (1 2cos(1))sin(1) 2\n1 3+ + \n (3) (sin(1) sin(2)) 2\n1 5 + + (4) ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ +\n2\n1\ncos\n2\n1 2 sin",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 2\\nSolution:\\nf(x) = | (2x – 1) (x + 2) | + 2\nsin 2x\n2\n1 0 ≤ x ≤ f(x) = (1 – 2x) (x + 2) + 2\nsin 2x\n f '(x) = – 4x – 3 + cos 2x < 0 \n For \n2\n1\nx ≥ : f '(x) = 4x − 3 + cos2\nx > 0 \n So, minima occurs at x = 2\n1\n f(x)|min = 2\n2\n3\n2\n1 2\n2\n⎟ + − ⎠\n⎞ ⎜\n⎝\n⎛ + sin ⎟\n⎠\n⎞ ⎜\n⎝\n⎛\n2\n1\n.cos ⎟\n⎠\n⎞ ⎜\n⎝\n⎛\n2\n1\n = \n2\n1 sin1 \nSo, maxima is possible at x = 0 or x = 1 \n Now checking for x = 0 and x = 1, we can see it attains its maximum value at x = 1 \n f(x)|max = |2 + 3 – 2| + 2\nsin 2 = 3 + \n2\n1 sin2 \n Sum of absolute maximum and minimum value = 3 + \n2\n1 (sin1 + sin2)",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q73_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Mathematics Q73]\\nIf n i i 1 {a } = , where n is an even integer, is an arithmetic progression with common difference 1, and \n∑\n=\nn\ni 1\ni a = 192, ∑\n=\nn / 2\ni 1\n2i a = 120, then n is equal to :",
                options = listOf("48", "96", "92", "104"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\na1 + a2 + .......+ an = 192 ⇒\n2\nn (a1 + an) = 192 …(1) \na2 + a4 + a6 + … + an = 120 \n⇒\n4\nn (a1 + 1 + an) = 120 …(2) \nFrom (2) & (1) \nn\n480 – n\n384 = 1 ⇒ n = 96",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q74_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Mathematics Q74]\\nIf x = x(y) is the solution of the differential equation y dy\ndx = 2x + y3\n(y + 1)ey\n, x(1) = 0 ; then x(e) is equal to \n (1) e3\n(ee\n – 1) (2) ee\n(e3\n – 1) (3) e2\n(ee\n + 1) (4) ee\n(e2\n – 1)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 1\\nSolution:\\ny\n2x\ndy\ndx = = y\n2 (y + 1)ey \nI.f. = 2\n–2 ny\ndy\ny\n2\ny\n1\ne = e = ∫ − \nSolution is given by \ndy\ny\n1\ny (y 1)e . y\n1\nx 2\n2 y\n2 ∫ = +\n⇒ (y 1)e dy\ny\nx y\n2 ∫ = +\n⇒ ye c\ny\nx y\n2 = +\n⇒ x = y\n2\n (yey\n + c) \nat, y = 1, x = 0 \n⇒ 0 = 1(1.e1\n + c) ⇒ c = –e \nat y = e, \nx = e\n2\n(e.ee\n – e)",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q75_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Mathematics Q75]\\nLet λx – 2y = μ be a tangent to the hyperbola a2\nx\n2 \n– y\n2\n = b2\n. Then \n2 2\na b ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ μ ⎟ − ⎠\n⎞ ⎜\n⎝\n⎛ λ is equal to :",
                options = listOf("–2", "–4", "2", "4"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n1\nb\ny –\na\nb\nx\n2\n2\n2\n2\n2\n=\n⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\nTangent in slope form ⇒ y = mx ± 2 2\n2\n2\nm b\na\nb − \n i.e., same as y = 2 2\nx μ − λ\n Comparing coefficients, \n m = \n4\nm – b\na\nb\n,\n2\n2\n2 2\n2\n2 μ = λ\n Eliminating m, 4\n. a\nb 2\n2\n2 λ – b2\n = \n4\n2 μ\n⇒ 2\n2\n2\n2\nb\n– a\nλ μ = 4",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q76_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Mathematics Q76]\\nLet b\nˆ aˆ, be unit vectors. If c\n\n be a vector such that the angle between aˆ and c\n is \n12\nπ , and b\nˆ = c +2( c × aˆ ), \nthen 2 | 6c |\n is equal to:",
                options = listOf("6 (3 – 3 )", "3 + 3", "6(3 + 3 )", "6( 3 + 1)"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n∵ b c 2(c aˆ) ˆ = + ×   \n⇒ 2 b.c | c | ˆ   = .....(i) \n∴ ) b c 2(c aˆ ˆ − = ×  \n⇒ c b.ˆ b | | c | – 2 ˆ| 2 2   + = \n2 4 | c |\n 2 | a |\n sin2\n12\nπ\n ⇒ 1 + 2 | c |\n – 2 2 | c |\n = \n2 4 | c |\n 2\n2 2\n3 1\n⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛ −\n ⇒ 1 = 2 | c |\n (3 – 3 ) \n⇒ 36 2 | c |\n = \n3 – 3\n36 = 6 ( 3 – 3)",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q77_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Mathematics Q77]\\nIf a random variable X follows the Binomial distribution B(33, p) such that 3P(X = 0) = P(X = 1), then the \nvalue of \nP(X 17)\nP(X 16) – P(X 18)\nP(X 15)\n=\n=\n=\n= is equal to -",
                options = listOf("1320", "1088", "1331\n120", "1089\n1088"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n3P(X = 0) = P(X = 1) \n3.n\nC0P0\n(1 – P)n\n = n\nC1P1\n(1 – P)n–1 \n1 P\nP\nn\n3\n− =⇒\n11\n1\n= \n1 P\nP\n−\n⇒ 1 – P = 11 P \n⇒ P = \n12\n1\n P(X 17)\nP(X 16) – P(X 18)\nP(X 15)\n=\n=\n=\n= \n⇒ 18 15\n18\n33\n15 18\n15\n33\nC P (1 – P)\nC P (1 – P) – 17 16\n17\n33\n16 17\n16\n33\nC P (1 – P)\nC P (1 – P)\n⇒ ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ − ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ −\nP\n1 P – P\n1 P 3\n ⇒ 112\n – 11 = 1320",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q78_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Mathematics Q78]\\nThe domain of the function f(x) = log (x 3x 2)\nx 9\nx 5x 6\ncos\n2 e\n2\n2 –1\n− +\n⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\n−\n− +\nis -",
                options = listOf(") (–∞, 1) ∪ (2, ∞", ") (2, ∞", ",1 (2, ) 2\n1 ⎟ ∪ ∞ ⎠\n⎞ ⎢\n⎣\n⎡\n−", "⎪⎭\n⎪\n⎬\n⎫\n⎪⎩\n⎪\n⎨\n⎧ + − ⎟ ∪ ∞ ⎠\n⎞ ⎢\n⎣\n⎡\n− 2\n3 5 , 5\n3 5 ,1 (2, ) – 2\n1"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n1\nx 9\nx 5x 6 1 2\n2\n≤ −\n− + − ≤ and x2\n – 3x + 2 > 0, ≠ 1 \n0\nx 9\n5(x 3) 0\nx 9\n(x 3)(2x 1)\n2 2 ≥ −\n− ≥ −\n− +\n Solution to this inequality is \n⎟\n⎠\n⎞ ⎢\n⎣\n⎡ ∞ − ∈ , 2\n1\nx – {3} \nfor x2\n – 3x + 2 > 0 and ≠ 1 \n x ∈ (– ∞, 1) ∪ (2, ∞) – ⎪⎭\n⎪\n⎬\n⎫\n⎪⎩\n⎪\n⎨\n⎧ − +\n2\n3 5 , 2\n3 5\nCombining the two solution sets (taking intersection) \n,1 (2, ) 2\n1\nx ⎟ ∪ ∞ ⎠\n⎞ ⎢\n⎣\n⎡\n∈ − – ⎪⎭\n⎪\n⎬\n⎫\n⎪⎩\n⎪\n⎨\n⎧ − +\n2\n3 5 , 2\n3 5",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q79_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Mathematics Q79]\\nLet \n⎭\n⎬\n⎫\n⎩\n⎨\n⎧ θ θ + θ = θ ⎭\n⎬\n⎫\n⎩\n⎨\n⎧ π = θ∈ π π ± :sin tan tan sin 2\n2\nS . If T = [– , ] – ∑\nθ∈\nθ\nS\ncos , then T + n(S) is equal to - 2",
                options = listOf("7 + 3", "9", "8 + 3", "10"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\ntanθ (sinθ + 1) – sin2θ = 0 \ntanθ (sinθ + 1 – 2 cos2\nθ) = 0 \n⇒ tanθ = 0 or 2sin2\nθ + sinθ – 1 = 0 \n⇒ (2sinθ + 1)(sinθ – 1) = 0 \n⇒ sinθ = \n2\n−1 or 1 \nBut, sinθ = 1 not possible \nθ = 0, π, – π, – 6\nπ , 6\n− 5π\n n(S) = 5 \n T = ∑cos 2θ = cos 0° + cos 2π + cos(–2π) – cos ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ − π\n3\n5\n + cos ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ π − 3",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q80_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Mathematics Q80]\\nThe number of choices for Δ ∈ {∧, ∨, ⇒, ⇔}, such that (p Δ q) ⇒ ((p Δ ~ q) ∨ ((~p) Δ q)) is a tautology, is -",
                options = listOf("1", "2", "3", "4"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nLet x : (p Δ q) ⇒ (pΔ ~ q) ∨ (~ p Δq) \nCase-I \nWhen Δ is same as ∨\nThen (p Δ ~ q) ∨ (~ p Δ q) becomes \n(p ∨ ~ q) ∨ (~ p ∨ q) which is always true, so x becomes a tautology. \nCase-II \nWhen Δ is same as ∧\nThen (p ∧ q) ⇒ (p∧ ~ q) ∨ (~ p ∧ q) \nIf p ∧ q is T, then (p ∧ ~ q) ∨ (~ p ∧ q) is F so x cannot be a tautology. \nCase-III \nWhen Δ is same as ⇒\nThen (p ⇒ ~ q) ∨ (~ p ⇒ q) is same at (~ p ∨ ~ q) ∨ (p ∨ q), which is always true, so x becomes a tautology. \nCase-IV \nWhen Δ is same as ⇔\nThen (p ⇔ q) ⇒ (p ⇔ ~ q) ∨ (~ p ⇔ q) \np ⇔ q is true when p and q have same truth values, then p ⇔ ~ q and ~p ⇔ q both are false. Hence x cannot \nbe a tautology. \nSo finally x can be ∨ or ⇒. \nSection-B: This section contains 10 questions. In Section-B, attempt any five questions out of 10. The answer \nto each of the questions is a numerical value. For each question, enter the correct numerical value (in decimal \nnotation, truncated/rounded-off to the second decimal place; e.g. 06.25, 07.00, –00.33, –00.30, 30.27, –27.30). \nEach question carries 4 marks for correct answer and –1 mark for wrong answer.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q81_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Mathematics Q81]\\nThe number of one-one functions ƒ : {a, b, c, d} → {0, 1, 2, ..., 10} such that 2ƒ(a) – ƒ(b) + 3ƒ(c) + ƒ(d) = 0 \nis ________.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 31.00\\nSolution:\\n∵ 3ƒ(c) + 2ƒ(a) + ƒ(d) = ƒ(b)",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q82_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Mathematics Q82]\\nIn an examination, there are 5 multiple choice questions with 3 choices, out of which exactly one is correct. \nThere are 3 marks for each correct answer, –2 marks for each wrong answer and 0 mark if the question is not \nattempted. Then, the number of ways a student appearing in the examination gets 5 marks is _____.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 40.00\\nSolution:\\nLet student marks x correct answers and y incorrect. So \n3x – 2y = 5 and x + y ≤ 5 where x, y ∈ W \n Only possible solution is (x, y) = (3, 2) \n Student can mark correct answer by only one choice but for incorrect answer, there are two choices. So total \number of ways of scoring 5 marks = 5\nC3(1)3\n. (2)2\n = 40",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q83_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Mathematics Q83]\\nLet ⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛ , a\na\n3 A , a > 0, be a fixed point in the xy-plane. The image of A in y-axis be B and the image of B in \nx-axis be C. If D(3cosθ, a sinθ) is a point in the fourth quadrant such that the maximum area of ΔACD is 12 \nsquare units, then a is equal to ______.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 8.00\\nSolution:\\nClearly B is ⎟\n⎟\n⎠\n⎞ ⎜\n⎜\n⎝\n⎛ , + a\na\n3 – and C is ⎟\n⎟\n⎠\n⎞ ⎜\n⎜\n⎝\n⎛ , – a\na\n3 – \n Area of ΔACD = \n3cos a sin 1\na 1\na\n3 –\na 1\na\n3\n2\n1\nθ θ\n⇒ Δ = \n3cos a sin 1\n– a 1\na\n3 –\n0 0 1\nθ θ\n ⇒ Δ = 3 a sin θ + 3 a cosθ = 3 a sin θ + cosθ\n⇒ Δmax= 3 a . 2 = 12 ⇒ a = ()2\n2 2 = 8",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q84_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Mathematics Q84]\\nLet a line having direction ratios 1, –4, 2 intersect the lines 3\nx – 7\n = –1\ny –1\n= \n1\nz + 2 and \n1\nz\n3\ny – 7\n2\nx = = at the \npoints A and B. Then (AB)2\n is equal to _________.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 84.00\\nSolution:\\nLet A(3λ + 7, –λ + 1, λ – 2) and B (2μ, 3μ + 7, μ) \n So, DR’s of AB ∝ 3λ – 2μ + 7, – (λ + 3μ + 6), λ – μ – 2 \n Clearly 2\n– µ – 2\n4\n3µ 6\n1\n3 – 2µ 7 λ = λ + + = λ +\n⇒ 5λ – 3μ = –16 …(i) \n And λ – 5μ = 10 …(ii) \n From (i) and (ii) we get λ = –5, μ = –3 \n So, A is (–8, 6, –7) and B is (–6, –2, –3) \n AB = 4 + 64 +16 ⇒ (AB)2\n = 84",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q85_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Mathematics Q85]\\nThe number of points where the function \n f(x) = \n⎪\n⎩\n⎪\n⎨\n⎧\n+ + ≥\n< <\n≤\n| x 1| | x – 2 | if x 1\n[4x –1] if –1 x 1\n| 2x – 3x – 7 | if x –1\n2\n2\n [t] denotes the greatest integer ≤ t, is discontinuous is _____________.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 7.00\\nSolution:\\n∵ f (–1) = 2 and f (1) = 3 \n For x ∈ (–1, 1), (4x2\n – 1) ∈ [–1, 3) \n hence f(x) will be discontinuous at x = 1 and also \n whenever 4x2\n – 1 = 0, 1 or 2 \n⇒ x = \n2\n1\n± , 2\n1\n± and ±\n2\n3\n So there are total 7 points of discontinuity.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q86_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Mathematics Q86]\\nLet f(θ) = sin θ + ∫\nπ\nπ\nθ + θ\n/ 2\n– / 2\n(sin t cos )f(t) dt . Then the value of | f( ) d |\n/ 2\n0\n∫\nπ\nθ θ is _________.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 1.00\\nSolution:\\nf(θ) = sin θ ⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\n+ ∫\nπ\nπ\n/ 2\n– / 2\n1 f(t) dt + cos θ ⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\n∫\nπ\nπ\n/ 2\n– / 2\ntf(t) dt\n Clearly f(θ) = a sinθ + b cosθ \nWhere a = ∫\nπ\nπ\n+ +\n/ 2\n– / 2\n1 (a sin t bcost) dt ⇒ a = 1 + 2b … (1) \n and b = ∫\nπ\nπ\n+\n/ 2\n– / 2\n(atsin t bt cost) dt ⇒ b = 2a … (2) \n from (1) and (2) we get \n a = –\n3\n1 and b = –\n3\n2\n So f(θ) = – 3\n1 (sin θ + 2cos θ) \n⇒ ∫\nπ\nθ θ\n/ 2\n0\nf( ) d = \n3\n1 (1 + 2 × 1) = 1",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q87_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Mathematics Q87]\\nLet ⎪⎭\n⎪\n⎬\n⎫\n⎪⎩\n⎪\n⎨\n⎧\n≤ ≤ 5 – x\n9 – x Max\n2\n0 x 2\n= α and ⎪⎭\n⎪\n⎬\n⎫\n⎪⎩\n⎪\n⎨\n⎧\n≤ ≤ 5 – x\n9 – x Min\n2\n0 x 2\n = β. If , x dx\n5 – x\n9 – x Max\n2 –1\n3\n8 –\n2\n∫\nα\nβ\n⎪⎭\n⎪\n⎬\n⎫\n⎪⎩\n⎪\n⎨\n⎧\n = α1 + α2 loge ⎟\n⎠\n⎞ ⎜\n⎝\n⎛\n15\n8 then α1 + α2\nis equal to ______________.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 34.00\\nSolution:\\nLet f(x) = x – 5\nx – 9 2\n⇒ f ′(x) = 2 (x – 5)\n(x –1)(x – 9)\n So, α = f(1) = 2 and β = min (f(0), f(2)) = 3\n5\n Now, ∫ ⎪⎭\n⎪\n⎬\n⎫\n⎪⎩\n⎪\n⎨\n⎧ 3\n–1\n2\n, x dx x – 5\nx – 9\nmax = ∫\n9/5\n–1\n2\ndx x – 5\nx – 9 + ∫\n3\n9/5\nx dx\n = \n3\n9/5\n9/5\n–1\n2\n2\nx dx x – 5\n16 x 5 ∫ ⎟ + ⎠\n⎞ ⎜\n⎝\n⎛ + +\n = \n25\n28 + 14 + 16 ln ⎟\n⎠\n⎞ ⎜\n⎝\n⎛\n15\n8\n + \n25\n72 = 18 + 16 ln ⎟\n⎠\n⎞ ⎜\n⎝\n⎛\n15\n8\n Clearly α1 = 18 and α2 = 16, so α1 + α2 = 34.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q88_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Mathematics Q88]\\nIf two tangents drawn from a point (α, β) lying on the ellipse 25x2\n + 4y2\n = 1 to the parabola y2\n = 4x are such \nthat the slope of one tangent is four times the other, then the value of (10α + 5)2\n + (16β2\n + 50)2\n equals \n____________.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 2929.00\\nSolution:\\n(α, β) lies on the given ellipse, 25α\n2\n + 4β2\n = 1 …(1) \n Tangent to the parabola, y = mx +\nm\n1 passes through (α, β). So, αm\n2\n – βm + 1 = 0 has roots m1 and 4m1, \n m1 + 4m1 = \nα\nβ and m1. 4 m1 = \nα\n1\n Gives that 4β2\n = 25α …(2) \n from (1) and (2) \n 25(α\n2\n + α) = 1 …(3) \n Now, (10α + 5)2 + (16β2\n + 50)2 \n= 25(2α + 1)2\n + 2500 (2α + 1)2\n = 2525 (4α\n2\n + 4α + 1) from equation (3) \n = 2525 ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ +1\n25\n4\n = 2929",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q89_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Mathematics Q89]\\nLet S be the region bounded by the curves y = x3 and y2\n = x. The curve y = 2|x| divides S into two regions of \nareas R1 and R2. If max {R1, R2} = R2, then \n1\n2\nR\nR is equal to _____.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 19.00\\nSolution:\\nC1 : y = x\n3\n C2 : y\n2\n = x \n and C3 = y = 2|x| \n C1 and C2 intersect at (1, 1) \n C2 and C3 intersect at ⎟\n⎠\n⎞ ⎜\n⎝\n⎛\n2\n1 ,\n4\n1\n Clearly R1 = () x – 2x dx\n1/ 4\n∫ 0\n= \n48\n1\n16\n1 – 8\n1\n3\n2 ⎟ = ⎠\n⎞ ⎜\n⎝\n⎛\n and R1 + R2 = () x – x dx\n1\n0\n3\n∫ = \n12\n5\n4\n1 – 3\n2 =\n So, 1/ 48\n5/12\nR\nR R\n1\n1 2 = +\n⇒\n1\n2\nR\nR 1+ = 20 \n⇒\n1\n2\nR\nR = 19",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s1_sh1_q90_math",
                topicId = testId,
                text = "[JEE Main 2022 Session 1 Shift 1 - Mathematics Q90]\\nIf the shortest distance between the lines r\n = k)ˆ i 3 ˆ (– + + λ j)ˆ i – a ˆ( and r\n = k)ˆ j 2 ˆ (– + + µ k)ˆ j\nˆ i –ˆ( + is \n3\n2 , \nthen the integral value of a is equal to ______________.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 2.00\\nSolution:\\n1 –1 1\n1 – a 0\nk\nˆ j\nˆ i\nˆ\nb1 × b2 =   = k\nˆ j (a –1) ˆ i –ˆ – a +\nk\nˆ j\nˆ i –ˆ a1 – a 2 = – +  \n Shortest distance = \n| b b |\n(a – a ).(b b )\n1 2\n1 2 1 2  \n   \n×\n×\n⇒\n2 2 a 1 (a –1)\n2(a –1)\n3\n2\n+ +\n=\n⇒ 6(a2\n – 2a +1) = 2a2\n – 2a + 2 \n⇒ (a − 2)(2a −1) = 0 ⇒ a = 2 because a ∈ z .",
                difficulty = "Medium"
            )
        )
    }
}