package com.example.data.repository

import com.example.model.Question

object JeeMain2024QuestionsRepository {
    fun getJeeMain2024Jan27Shift1Questions(testId: String): List<Question> {
        return getPhysicsQuestions(testId) + getChemistryQuestions(testId) + getMathsQuestions(testId)
    }

    // ==========================================
    // PHYSICS (Q1 - Q30)
    // ==========================================
    private fun getPhysicsQuestions(testId: String): List<Question> {
        return listOf(
            Question(
                id = "${testId}_p1",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Physics Q1]\nGiven below are two statements:\nStatement-I: Viscosity of gases is greater than that of liquids.\nStatement-II: Surface tension of a liquid decreases due to the presence of insoluble impurities.\nIn the light of the above statements, choose the most appropriate answer:",
                options = listOf(
                    "(1) Statement-I is incorrect but statement-II is correct",
                    "(2) Statement-I is correct but statement-II is incorrect",
                    "(3) Both Statement-I and Statement-II are incorrect",
                    "(4) Both Statement-I and Statement-II are correct"
                ),
                correctOptionIndex = 0,
                explanation = "Viscosity of liquids is greater than gas (Statement-I is incorrect). Surface tension decreases due to presence of impurities (Statement-II is correct). Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Fluid Mechanics & Surface Tension"
            ),
            Question(
                id = "${testId}_p2",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Physics Q2]\n0.08 kg air is heated at constant volume through 5°C. The specific heat of air at constant volume is 0.17 kcal/kg°C and J = 4.18 joule/cal. The change in its internal energy is approximately:",
                options = listOf("(1) 284 J", "(2) 298 J", "(3) 318 J", "(4) 142 J"),
                correctOptionIndex = 0,
                explanation = "ΔU = m * C_v * ΔT = 0.08 kg * (0.17 * 10³ cal/kg°C * 4.18 J/cal) * 5°C = 284.24 J ≈ 284 J. Correct option is (1).",
                difficulty = "Medium",
                formulaRef = "Thermodynamics: ΔU = m Cv ΔT"
            ),
            Question(
                id = "${testId}_p3",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Physics Q3]\nIdentify the physical quantity that cannot be measured using a spherometer:",
                options = listOf(
                    "(1) Radius of curvature of convex surface",
                    "(2) Radius of curvature of concave surface",
                    "(3) Specific rotation of liquids",
                    "(4) Thickness of thin plates"
                ),
                correctOptionIndex = 2,
                explanation = "Spherometer is used to measure radius of curvature of spherical surfaces and thickness of thin sheets. It cannot measure specific rotation of liquids (polarimeter is used for that). Correct option is (3).",
                difficulty = "Easy",
                formulaRef = "Units and Measurements: Spherometer"
            ),
            Question(
                id = "${testId}_p4",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Physics Q4]\nPosition of an ant (S in metres) moving in Y-Z plane is given by S = 2t² ĵ + 5 k̂ (where t is in second). The magnitude and direction of velocity of the ant at t = 1 s will be:",
                options = listOf(
                    "(1) 4 m/s in y-direction",
                    "(2) 9 m/s in z-direction",
                    "(3) 16 m/s in y-direction",
                    "(4) 4 m/s in x-direction"
                ),
                correctOptionIndex = 0,
                explanation = "v = dS/dt = d(2t² ĵ + 5 k̂)/dt = 4t ĵ. At t = 1 s, v = 4 ĵ m/s (4 m/s in y-direction). Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Kinematics: Velocity Vector"
            ),
            Question(
                id = "${testId}_p5",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Physics Q5]\nAn electric charge 10⁻⁶ μC is placed at origin (0, 0) m of X – Y co-ordinate system. Two points P and Q are situated at (√3, √3) m and (√6, 0) m respectively. The potential difference between the points P and Q will be:",
                options = listOf("(1) √6 V", "(2) 0 V", "(3) 3 V", "(4) √3 V"),
                correctOptionIndex = 1,
                explanation = "Distance of P from origin r1 = √((√3)² + (√3)²) = √6 m. Distance of Q from origin r2 = √((√6)² + 0) = √6 m. Since r1 = r2 = √6 m, VP = VQ = KQ/√6. Therefore potential difference ΔV = VP - VQ = 0 V. Correct option is (2).",
                difficulty = "Medium",
                formulaRef = "Electrostatics: V = KQ/r"
            ),
            Question(
                id = "${testId}_p6",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Physics Q6]\nA proton moving with a constant velocity passes through a region of space without any change in its velocity. If E and B represent electric and magnetic fields respectively, then the region of space may have:\n(A) E = 0, B = 0\n(B) E = 0, B ≠ 0\n(C) E ≠ 0, B = 0\n(D) E ≠ 0, B ≠ 0\nChoose the most appropriate answer:",
                options = listOf(
                    "(1) (A), (C) and (D) only",
                    "(2) (A), (B) and (C) only",
                    "(3) (A), (B) and (D) only",
                    "(4) (B), (C) and (D) only"
                ),
                correctOptionIndex = 2,
                explanation = "For constant velocity, net force F = q(E + v × B) = 0.\n(A) E=0, B=0 -> F=0 (Possible)\n(B) E=0, B!=0 -> If v || B, F_mag = 0, F=0 (Possible)\n(C) E!=0, B=0 -> F_elec != 0 (Not possible)\n(D) E!=0, B!=0 -> F_elec and F_mag can cancel out if qE = -q(v × B) (Possible).\nCorrect option is (3): (A), (B) and (D) only.",
                difficulty = "Medium",
                formulaRef = "Lorentz Force: F = q(E + v × B)"
            ),
            Question(
                id = "${testId}_p7",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Physics Q7]\nThe radius of third stationary orbit of electron for Bohr's atom is R. The radius of fourth stationary orbit will be:",
                options = listOf("(1) 16/9 R", "(2) 9/16 R", "(3) 4/3 R", "(4) 3/4 R"),
                correctOptionIndex = 0,
                explanation = "Radius of Bohr's orbit r_n ∝ n². So r4 / r3 = (4/3)² = 16/9. Since r3 = R, r4 = (16/9) R. Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Atomic Physics: r_n = r0 (n²/Z)"
            ),
            Question(
                id = "${testId}_p8",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Physics Q8]\nThe average kinetic energy of a monoatomic molecule is 0.414 eV at temperature (Use kB = 1.38 × 10⁻²³ J/mol-K):",
                options = listOf("(1) 3000 K", "(2) 3200 K", "(3) 1500 K", "(4) 1600 K"),
                correctOptionIndex = 1,
                explanation = "Average KE of monoatomic molecule = (3/2) kB T. 0.414 * 1.6 * 10⁻¹⁹ J = (3/2) * (1.38 * 10⁻²³) * T ⇒ T = 3200 K. Correct option is (2).",
                difficulty = "Medium",
                formulaRef = "Kinetic Theory: E = (3/2) kB T"
            ),
            Question(
                id = "${testId}_p9",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Physics Q9]\nA wire of resistance R and length L is cut into 5 equal parts. If these parts are joined in parallel, then resultant resistance will be:",
                options = listOf("(1) 1/5 R", "(2) 1/25 R", "(3) 5 R", "(4) 25 R"),
                correctOptionIndex = 1,
                explanation = "Resistance of each part = R/5. When 5 equal resistors of R/5 are connected in parallel: 1/Req = 5/(R/5) = 25/R ⇒ Req = R/25. Correct option is (2).",
                difficulty = "Easy",
                formulaRef = "Current Electricity: Combination of Resistors"
            ),
            Question(
                id = "${testId}_p10",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Physics Q10]\nA rectangular loop of length 2.5 m and width 2 m is placed at 60° to a magnetic field of 4 T. The loop is removed from the field in 10 s. The average emf induced in the loop during this time is:",
                options = listOf("(1) +2 V", "(2) -2 V", "(3) -1 V", "(4) +1 V"),
                correctOptionIndex = 3,
                explanation = "Initial flux Φ = B * A * cos(60°) = 4 T * (2.5 * 2 m²) * 0.5 = 10 Wb. Final flux = 0. Induced EMF Eavg = -ΔΦ/Δt = -(0 - 10)/10 = +1 V. Correct option is (4).",
                difficulty = "Medium",
                formulaRef = "EMI: Faraday's Law E = -dΦ/dt"
            ),
            Question(
                id = "${testId}_p11",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Physics Q11]\nA body of mass 1000 kg is moving horizontally with a velocity 50 m/s. A mass of 200 kg is added gently on it. The final velocity of the body will be:",
                options = listOf("(1) 41.67 m/s", "(2) 50 m/s", "(3) 60 m/s", "(4) 35.5 m/s"),
                correctOptionIndex = 0,
                explanation = "By conservation of linear momentum: m1 v1 = (m1 + m2) v2 ⇒ 1000 * 50 = (1000 + 200) * v2 ⇒ v2 = 50000 / 1200 = 41.67 m/s. Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Conservation of Linear Momentum"
            ),
            Question(
                id = "${testId}_p12",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Physics Q12]\nThe fundamental frequency of a closed organ pipe of length L is equal to the first overtone frequency of an open organ pipe of length L'. Then L' is equal to:",
                options = listOf("(1) 4L", "(2) 2L", "(3) L/2", "(4) L/4"),
                correctOptionIndex = 0,
                explanation = "Closed pipe fundamental frequency f_closed = v / 4L. Open pipe 1st overtone (2nd harmonic) f_open = 2 * (v / 2L') = v / L'. Equating: v / 4L = v / L' ⇒ L' = 4L. Correct option is (1).",
                difficulty = "Medium",
                formulaRef = "Sound Waves: Organ Pipes"
            ),
            Question(
                id = "${testId}_p13",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Physics Q13]\nThe work done in moving a charge of 4 C across two points having a potential difference of 12 V is:",
                options = listOf("(1) 48 J", "(2) 3 J", "(3) 16 J", "(4) 24 J"),
                correctOptionIndex = 0,
                explanation = "W = q * ΔV = 4 C * 12 V = 48 J. Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Electrostatics: Work W = q ΔV"
            ),
            Question(
                id = "${testId}_p14",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Physics Q14]\nA convex lens of focal length 20 cm is placed in contact with a concave lens of focal length 10 cm. The focal length of the combination will be:",
                options = listOf("(1) -20 cm", "(2) +20 cm", "(3) -10 cm", "(4) +10 cm"),
                correctOptionIndex = 0,
                explanation = "1/F = 1/f1 + 1/f2 = 1/20 + 1/(-10) = -1/20 ⇒ F = -20 cm. Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Ray Optics: Equivalent Focal Length 1/F = 1/f1 + 1/f2"
            ),
            Question(
                id = "${testId}_p15",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Physics Q15]\nIn a Young's double slit experiment, if the separation between slits is halved and distance of screen from slits is doubled, fringe width will become:",
                options = listOf("(1) 4 times", "(2) 2 times", "(3) Unchanged", "(4) 8 times"),
                correctOptionIndex = 0,
                explanation = "Fringe width β = λD/d. New D' = 2D, d' = d/2. β' = λ(2D)/(d/2) = 4 (λD/d) = 4β. Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Wave Optics: YDSE Fringe Width β = λD/d"
            ),
            Question(
                id = "${testId}_p16",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Physics Q16]\nA radioactive nucleus undergoes decay as follows: A -(α)-> A1 -(β⁻)-> A2 -(α)-> A3 -(γ)-> A4. If mass number and atomic number of A are 180 and 72 respectively, then for A4 these values are:",
                options = listOf("(1) 172 and 69", "(2) 174 and 70", "(3) 172 and 68", "(4) 176 and 71"),
                correctOptionIndex = 0,
                explanation = "A(180, 72) -> A1(176, 70) after α emission. A1(176, 70) -> A2(176, 71) after β⁻ emission. A2(176, 71) -> A3(172, 69) after α emission. A3(172, 69) -> A4(172, 69) after γ emission. Correct option is (1).",
                difficulty = "Medium",
                formulaRef = "Nuclear Physics: Radioactive Decay Law"
            ),
            Question(
                id = "${testId}_p17",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Physics Q17]\nThe de-Broglie wavelength of an electron accelerated through a potential difference of 100 V is approximately:",
                options = listOf("(1) 1.227 Å", "(2) 0.123 Å", "(3) 12.27 Å", "(4) 2.45 Å"),
                correctOptionIndex = 0,
                explanation = "λ = 12.27 / √V Å = 12.27 / √100 = 12.27 / 10 = 1.227 Å. Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Dual Nature of Matter: λ = 12.27/√V Å"
            ),
            Question(
                id = "${testId}_p18",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Physics Q18]\nThe threshold wavelength for photoelectric emission from a metal surface is 5000 Å. Photoelectrons will be emitted when the surface is illuminated with radiation of wavelength:",
                options = listOf("(1) 4000 Å", "(2) 6000 Å", "(3) 7000 Å", "(4) 5500 Å"),
                correctOptionIndex = 0,
                explanation = "Photoelectric effect occurs when incident wavelength λ ≤ λ_threshold (5000 Å). Among options, only 4000 Å < 5000 Å. Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Photoelectric Effect: λ ≤ λ0"
            ),
            Question(
                id = "${testId}_p19",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Physics Q19]\nA logic gate circuit gives output Y = 1 only when all inputs are 0. The logic gate is:",
                options = listOf("(1) NOR gate", "(2) NAND gate", "(3) AND gate", "(4) OR gate"),
                correctOptionIndex = 0,
                explanation = "NOR gate truth table: (0,0) -> 1, (0,1) -> 0, (1,0) -> 0, (1,1) -> 0. Thus NOR gives 1 only when all inputs are 0. Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Semiconductor Electronics: Logic Gates"
            ),
            Question(
                id = "${testId}_p20",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Physics Q20]\nA satellite revolving around Earth in a circular orbit of radius R has orbital speed v. If radius is increased to 4R, its new orbital speed will be:",
                options = listOf("(1) v/2", "(2) 2v", "(3) v/4", "(4) v/√2"),
                correctOptionIndex = 0,
                explanation = "Orbital speed v = √(GM/r). v' = √(GM / 4R) = (1/2) √(GM/R) = v/2. Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Gravitation: Orbital Velocity v = √(GM/r)"
            ),
            // Section B / Numerical type Physics
            Question(
                id = "${testId}_p21",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Physics Q21]\nA body cools from 80°C to 60°C in 5 minutes in surrounding temperature 20°C. The time taken (in minutes) to cool from 60°C to 40°C in same surrounding will be:",
                options = listOf("(1) 10", "(2) 8", "(3) 6", "(4) 12"),
                correctOptionIndex = 0,
                explanation = "Using Newton's Law of Cooling:\nCase 1: (80-60)/5 = K(70-20) ⇒ 4 = 50K ⇒ K = 4/50.\nCase 2: (60-40)/t = K(50-20) ⇒ 20/t = (4/50)*30 ⇒ 20/t = 12/5 ⇒ t = 100/12 ≈ 10 min. Correct option is (1).",
                difficulty = "Medium",
                formulaRef = "Thermal Properties: Newton's Law of Cooling"
            ),
            Question(
                id = "${testId}_p22",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Physics Q22]\nA block of mass 2 kg is placed on a rough horizontal surface with coefficient of friction μ = 0.5. The force required to just move the block horizontally is (g = 10 m/s²):",
                options = listOf("(1) 10 N", "(2) 5 N", "(3) 20 N", "(4) 15 N"),
                correctOptionIndex = 0,
                explanation = "F = f_lim = μ N = μ m g = 0.5 * 2 * 10 = 10 N. Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Laws of Motion: Limiting Friction f = μ N"
            ),
            Question(
                id = "${testId}_p23",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Physics Q23]\nA simple pendulum of length 1 m has time period T. If length is increased by 21%, the percentage increase in its time period will be:",
                options = listOf("(1) 10%", "(2) 21%", "(3) 5%", "(4) 11%"),
                correctOptionIndex = 0,
                explanation = "T = 2π √(L/g). T' = 2π √(1.21 L / g) = 1.1 T. Percentage increase = ((1.1T - T)/T)*100% = 10%. Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "SHM: Simple Pendulum T ∝ √L"
            ),
            Question(
                id = "${testId}_p24",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Physics Q24]\nA coil of inductance 0.5 H and resistance 10 Ω is connected to a 220 V, 50 Hz AC supply. The impedance of the circuit is approximately:",
                options = listOf("(1) 157 Ω", "(2) 100 Ω", "(3) 220 Ω", "(4) 120 Ω"),
                correctOptionIndex = 0,
                explanation = "XL = 2π f L = 2 * 3.14 * 50 * 0.5 = 157 Ω. Z = √(R² + XL²) = √(10² + 157²) ≈ 157.3 Ω ≈ 157 Ω. Correct option is (1).",
                difficulty = "Medium",
                formulaRef = "AC Circuits: Impedance Z = √(R² + XL²)"
            ),
            Question(
                id = "${testId}_p25",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Physics Q25]\nThe ratio of magnetic field at center of a circular loop carrying current I to the magnetic field at distance x = R on its axis is:",
                options = listOf("(1) 2√2 : 1", "(2) 2 : 1", "(3) 4 : 1", "(4) √2 : 1"),
                correctOptionIndex = 0,
                explanation = "B_center = μ0 I / (2R). B_axis = μ0 I R² / (2(R² + x²)^(3/2)). At x = R, B_axis = μ0 I / (2 R * 2^(3/2)) = B_center / 2√2. Ratio B_center / B_axis = 2√2 : 1. Correct option is (1).",
                difficulty = "Medium",
                formulaRef = "Moving Charges & Magnetism: B_axis vs B_center"
            ),
            Question(
                id = "${testId}_p26",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Physics Q26]\nAn ideal gas undergoes isothermal expansion from volume V to 3V at temperature T. The work done by gas is:",
                options = listOf("(1) nRT ln(3)", "(2) nRT (3-1)", "(3) zero", "(4) nRT/3"),
                correctOptionIndex = 0,
                explanation = "For isothermal process W = nRT ln(V2/V1) = nRT ln(3V/V) = nRT ln(3). Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Thermodynamics: Isothermal Work W = nRT ln(V2/V1)"
            ),
            Question(
                id = "${testId}_p27",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Physics Q27]\nIn a uniform magnetic field of 0.2 T, a charged particle q = 2 μC moves in a circular path of radius 5 cm with speed 10 m/s. The mass of the particle is:",
                options = listOf("(1) 2 × 10⁻⁸ kg", "(2) 1 × 10⁻⁸ kg", "(3) 4 × 10⁻⁸ kg", "(4) 5 × 10⁻⁷ kg"),
                correctOptionIndex = 0,
                explanation = "r = mv / qB ⇒ m = q B r / v = (2 × 10⁻⁶ * 0.2 * 0.05) / 10 = 2 × 10⁻⁸ kg. Correct option is (1).",
                difficulty = "Medium",
                formulaRef = "Magnetic Force & Motion: r = mv / qB"
            ),
            Question(
                id = "${testId}_p28",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Physics Q28]\nThe escape velocity from surface of Earth is v_e. For a planet having double the mass and double the radius of Earth, the escape velocity will be:",
                options = listOf("(1) v_e", "(2) 2 v_e", "(3) v_e / 2", "(4) √2 v_e"),
                correctOptionIndex = 0,
                explanation = "v_e = √(2GM/R). New escape velocity v'_e = √(2G(2M)/(2R)) = √(2GM/R) = v_e. Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Gravitation: Escape Velocity v_e = √(2GM/R)"
            ),
            Question(
                id = "${testId}_p29",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Physics Q29]\nA capacitor of capacitance C = 10 μF is charged to 50 V and then disconnected from battery. It is then connected across an uncharged 10 μF capacitor. The common potential across them will be:",
                options = listOf("(1) 25 V", "(2) 50 V", "(3) 12.5 V", "(4) 100 V"),
                correctOptionIndex = 0,
                explanation = "Common potential V_common = (C1 V1 + C2 V2)/(C1 + C2) = (10*50 + 0)/(10 + 10) = 25 V. Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Electrostatics: Redistribution of Charge"
            ),
            Question(
                id = "${testId}_p30",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Physics Q30]\nThe dimensional formula for permittivity of free space (ε₀) is:",
                options = listOf(
                    "(1) [M⁻¹ L⁻³ T⁴ A²]",
                    "(2) [M¹ L³ T⁻⁴ A⁻²]",
                    "(3) [M⁻¹ L³ T⁻² A²]",
                    "(4) [M⁰ L⁻² T² A¹]"
                ),
                correctOptionIndex = 0,
                explanation = "F = q1 q2 / (4π ε0 r²) ⇒ ε0 = q1 q2 / (F r²) = [A² T²] / ([M L T⁻²] [L²]) = [M⁻¹ L⁻³ T⁴ A²]. Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Units and Dimensions: Permittivity ε₀"
            )
        )
    }

    // ==========================================
    // CHEMISTRY (Q31 - Q60)
    // ==========================================
    private fun getChemistryQuestions(testId: String): List<Question> {
        return listOf(
            Question(
                id = "${testId}_c1",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Chemistry Q31]\nGiven below are two statements:\nStatement (I): p-nitrophenol is more acidic than m-nitrophenol and o-nitrophenol.\nStatement (II): Ethanol will give immediate turbidity with Lucas reagent.\nIn the light of the above statements, choose the correct answer:",
                options = listOf(
                    "(1) Statement I is false but Statement II is true",
                    "(2) Statement I is true but Statement II is false",
                    "(3) Both Statement I and Statement II are true",
                    "(4) Both Statement I and Statement II are false"
                ),
                correctOptionIndex = 1,
                explanation = "p-nitrophenol is more acidic than o- & m-nitrophenol due to strong -R effect of -NO2 at para position without intramolecular H-bonding (which occurs in o-nitrophenol). Statement I is true. Ethanol (1° alcohol) does not give immediate turbidity with Lucas reagent (only 3° alcohols do immediately). Statement II is false. Correct option is (2).",
                difficulty = "Medium",
                formulaRef = "Organic Chemistry: Acidity of Phenols & Lucas Test"
            ),
            Question(
                id = "${testId}_c2",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Chemistry Q32]\nTwo nucleotides are joined together by a linkage known as:",
                options = listOf(
                    "(1) Peptide linkage",
                    "(2) Disulphide linkage",
                    "(3) Glycosidic linkage",
                    "(4) Phosphodiester linkage"
                ),
                correctOptionIndex = 3,
                explanation = "Nucleotides in nucleic acids (DNA/RNA) are linked by phosphodiester linkage between 5' and 3' carbon atoms of pentose sugar. Correct option is (4).",
                difficulty = "Easy",
                formulaRef = "Biomolecules: Nucleic Acids"
            ),
            Question(
                id = "${testId}_c3",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Chemistry Q33]\nCyclohexene is which type of organic compound?",
                options = listOf(
                    "(1) Acyclic",
                    "(2) Benzenoid non-aromatic",
                    "(3) Alicyclic",
                    "(4) Benzenoid aromatic"
                ),
                correctOptionIndex = 2,
                explanation = "Cyclohexene contains a non-aromatic carbon ring (cyclic aliphatic compound), so it belongs to alicyclic compounds. Correct option is (3).",
                difficulty = "Easy",
                formulaRef = "Organic Chemistry: Classification of Organic Compounds"
            ),
            Question(
                id = "${testId}_c4",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Chemistry Q34]\nThe electronic configuration for Neodymium [Atomic Number Z = 60] is:",
                options = listOf(
                    "(1) [Xe] 4f⁴ 6s²",
                    "(2) [Xe] 4f¹ 5d¹ 6s²",
                    "(3) [Xe] 5f⁷ 7s²",
                    "(4) [Xe] 4f⁶ 6s²"
                ),
                correctOptionIndex = 0,
                explanation = "Neodymium (Nd, Z=60) is a lanthanide with electronic configuration [Xe] 4f⁴ 6s². Correct option is (1).",
                difficulty = "Medium",
                formulaRef = "f-Block Elements: Electronic Configurations"
            ),
            Question(
                id = "${testId}_c5",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Chemistry Q35]\nIUPAC name of 1,1-dimethyl-3-ethylcyclohexane correctly according to alphabetical order is:",
                options = listOf(
                    "(1) 1,1-Dimethyl-3-ethylcyclohexane",
                    "(2) 1-Ethyl-3,3-dimethylcyclohexane",
                    "(3) 3-Ethyl-1,1-dimethylcyclohexane",
                    "(4) 1-Ethyl-5,5-dimethylcyclohexane"
                ),
                correctOptionIndex = 2,
                explanation = "Lowest locant set gives 1,1 for dimethyl and 3 for ethyl (locants 1,1,3 vs 1,3,3). Writing substituents in alphabetical order gives 3-Ethyl-1,1-dimethylcyclohexane. Correct option is (3).",
                difficulty = "Medium",
                formulaRef = "IUPAC Nomenclature: Cycloalkanes"
            ),
            Question(
                id = "${testId}_c6",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Chemistry Q36]\nGiven below are two statements:\nAssertion (A): Melting point of Boron (2453 K) is unusually high in group 13 elements.\nReason (R): Solid Boron has a very strong crystalline lattice.\nIn the light of the above statements, choose the most appropriate answer:",
                options = listOf(
                    "(1) Both (A) and (R) are correct but (R) is not correct explanation of (A)",
                    "(2) Both (A) and (R) are correct and (R) is the correct explanation of (A)",
                    "(3) (A) is false but (R) is true",
                    "(4) (A) is true but (R) is false"
                ),
                correctOptionIndex = 1,
                explanation = "Boron forms an extremely strong icosahedral crystalline covalent lattice structure, leading to an unusually high melting point. Both (A) and (R) are correct and (R) explains (A). Correct option is (2).",
                difficulty = "Medium",
                formulaRef = "p-Block Elements: Group 13 Physical Properties"
            ),
            Question(
                id = "${testId}_c7",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Chemistry Q37]\nA solution of two miscible liquids showing negative deviation from Raoult's law will have:",
                options = listOf(
                    "(1) increased vapour pressure, decreased boiling point",
                    "(2) increased vapour pressure, increased boiling point",
                    "(3) decreased vapour pressure, decreased boiling point",
                    "(4) decreased vapour pressure, increased boiling point"
                ),
                correctOptionIndex = 3,
                explanation = "Negative deviation from Raoult's law means solute-solvent interactions are stronger than pure components, leading to decreased vapour pressure and increased boiling point (maximum boiling azeotrope). Correct option is (4).",
                difficulty = "Easy",
                formulaRef = "Solutions: Non-ideal Solutions"
            ),
            Question(
                id = "${testId}_c8",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Chemistry Q38]\nConsider the complex ions:\nP = [FeF₆]³⁻, Q = [V(H₂O)₆]²⁺, R = [Fe(H₂O)₆]²⁺\nThe correct order of complex ions according to their spin-only magnetic moment values is:",
                options = listOf(
                    "(1) R < Q < P",
                    "(2) R < P < Q",
                    "(3) Q < R < P",
                    "(4) Q < P < R"
                ),
                correctOptionIndex = 2,
                explanation = "P: [FeF₆]³⁻ (Fe³⁺, 3d⁵, weak field ligand F⁻, n=5 unpaired e⁻, μ = √35 BM)\nQ: [V(H₂O)₆]²⁺ (V²⁺, 3d³, n=3 unpaired e⁻, μ = √15 BM)\nR: [Fe(H₂O)₆]²⁺ (Fe²⁺, 3d⁶, weak field H₂O, n=4 unpaired e⁻, μ = √24 BM)\nOrder of magnetic moment: Q (√15) < R (√24) < P (√35). Correct option is (3).",
                difficulty = "Hard",
                formulaRef = "Coordination Chemistry: Spin-only Magnetic Moment μ = √(n(n+2))"
            ),
            Question(
                id = "${testId}_c9",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Chemistry Q39]\nHighest enol content will be shown by which of the following compounds?",
                options = listOf(
                    "(1) Propan-2-one",
                    "(2) Acetylacetone",
                    "(3) 1,3,5-Cyclohexanetrione",
                    "(4) Cyclohexanone"
                ),
                correctOptionIndex = 2,
                explanation = "1,3,5-Cyclohexanetrione enolizes completely to form phloroglucinol (1,3,5-trihydroxybenzene), which gains immense aromatic stabilization energy. Thus its enol content is nearly 100%. Correct option is (3).",
                difficulty = "Medium",
                formulaRef = "Organic Chemistry: Keto-Enol Tautomerism"
            ),
            Question(
                id = "${testId}_c10",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Chemistry Q40]\nElement not showing variable oxidation state is:",
                options = listOf("(1) Bromine", "(2) Chlorine", "(3) Iodine", "(4) Fluorine"),
                correctOptionIndex = 3,
                explanation = "Fluorine is the most electronegative element and lacks vacant d-orbitals in its valence shell, so it exhibits only -1 oxidation state in its compounds. Correct option is (4).",
                difficulty = "Easy",
                formulaRef = "p-Block: Halogens Oxidation States"
            ),
            Question(
                id = "${testId}_c11",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Chemistry Q41]\nWhich of the following compounds is most reactive towards SN1 reaction?",
                options = listOf(
                    "(1) Benzyl chloride",
                    "(2) Chlorobenzene",
                    "(3) Isopropyl chloride",
                    "(4) Methyl chloride"
                ),
                correctOptionIndex = 0,
                explanation = "Benzyl chloride forms benzyl carbocation C6H5-CH2⁺ upon ionization, which is strongly stabilized by resonance with benzene ring. Hence it is highly reactive towards SN1. Correct option is (1).",
                difficulty = "Medium",
                formulaRef = "Haloalkanes and Haloarenes: SN1 Reactivity"
            ),
            Question(
                id = "${testId}_c12",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Chemistry Q42]\nThe oxidation state of central atom in CrO₅ (Chromium peroxide) is:",
                options = listOf("(1) +6", "(2) +10", "(3) +4", "(4) +5"),
                correctOptionIndex = 0,
                explanation = "CrO5 has a butterfly structure with two peroxide linkages (-O-O-) and one oxo (=O) group. Oxidation state of Cr = +6. Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Redox Reactions: Oxidation Number Calculation"
            ),
            Question(
                id = "${testId}_c13",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Chemistry Q43]\nWhich of the following molecules has zero dipole moment?",
                options = listOf("(1) BF₃", "(2) NH₃", "(3) H₂O", "(4) NF₃"),
                correctOptionIndex = 0,
                explanation = "BF3 has trigonal planar geometry with 120° bond angles. Vector sum of individual B-F bond dipoles cancels out completely giving net dipole moment μ = 0. Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Chemical Bonding: Dipole Moment & Molecular Geometry"
            ),
            Question(
                id = "${testId}_c14",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Chemistry Q44]\nThe pH of 0.01 M NaOH solution at 25°C is:",
                options = listOf("(1) 12", "(2) 2", "(3) 10", "(4) 14"),
                correctOptionIndex = 0,
                explanation = "[OH⁻] = 10⁻² M ⇒ pOH = -log(10⁻²) = 2. Since pH + pOH = 14, pH = 14 - 2 = 12. Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Ionic Equilibrium: pH and pOH Relation"
            ),
            Question(
                id = "${testId}_c15",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Chemistry Q45]\nWhich among the following is an example of an emulsion?",
                options = listOf("(1) Milk", "(2) Smoke", "(3) Gemstone", "(4) Fog"),
                correctOptionIndex = 0,
                explanation = "Milk is a liquid-in-liquid colloidal dispersion, which is an emulsion. Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Surface Chemistry: Types of Colloids"
            ),
            Question(
                id = "${testId}_c16",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Chemistry Q46]\nThe molar conductivity at infinite dilution (Λ°m) for NaCl, HCl and CH₃COONa are 126.4, 425.9 and 91.0 S cm² mol⁻¹ respectively. Λ°m for CH₃COOH is:",
                options = listOf("(1) 390.5 S cm² mol⁻¹", "(2) 200.5 S cm² mol⁻¹", "(3) 516.9 S cm² mol⁻¹", "(4) 425.9 S cm² mol⁻¹"),
                correctOptionIndex = 0,
                explanation = "By Kohlrausch Law: Λ°(CH3COOH) = Λ°(CH3COONa) + Λ°(HCl) - Λ°(NaCl) = 91.0 + 425.9 - 126.4 = 390.5 S cm² mol⁻¹. Correct option is (1).",
                difficulty = "Medium",
                formulaRef = "Electrochemistry: Kohlrausch's Law of Independent Migration"
            ),
            Question(
                id = "${testId}_c17",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Chemistry Q47]\nAccording to Crystal Field Theory, the d-orbital splitting energy (Δo) for an octahedral complex depends on:",
                options = listOf(
                    "(1) Nature of ligand and charge on metal ion",
                    "(2) Shape of the container",
                    "(3) Temperature of solution only",
                    "(4) Atmospheric pressure"
                ),
                correctOptionIndex = 0,
                explanation = "Crystal field splitting Δo depends on the strength/nature of ligand (spectrochemical series) and the charge/oxidation state of central metal ion. Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Coordination Compounds: Crystal Field Theory"
            ),
            Question(
                id = "${testId}_c18",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Chemistry Q48]\nAniline on reaction with concentrated H₂SO₄ at 453-473 K produces:",
                options = listOf(
                    "(1) Sulfanilic acid",
                    "(2) Nitrobenzene",
                    "(3) Benzoic acid",
                    "(4) Chlorobenzene"
                ),
                correctOptionIndex = 0,
                explanation = "Aniline reacts with conc. H2SO4 to form anilinium hydrogen sulphate, which on heating at 453-473 K rearranges to form p-aminobenzenesulfonic acid (sulfanilic acid). Correct option is (1).",
                difficulty = "Medium",
                formulaRef = "Amines: Sulfonation of Aniline"
            ),
            Question(
                id = "${testId}_c19",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Chemistry Q49]\nGlucose on reaction with bromine water yields:",
                options = listOf(
                    "(1) Gluconic acid",
                    "(2) Saccharic acid",
                    "(3) Sorbitol",
                    "(4) n-Hexane"
                ),
                correctOptionIndex = 0,
                explanation = "Bromine water is a mild oxidizing agent that oxidizes the aldehyde group (-CHO) of glucose to carboxylic acid (-COOH) forming gluconic acid. Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Biomolecules: Reactions of Glucose"
            ),
            Question(
                id = "${testId}_c20",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Chemistry Q50]\nWhich halogen form of interhalogen compound IF₇ has geometry:",
                options = listOf(
                    "(1) Pentagonal bipyramidal",
                    "(2) Octahedral",
                    "(3) Trigonal bipyramidal",
                    "(4) Tetrahedral"
                ),
                correctOptionIndex = 0,
                explanation = "IF7 has sp³d³ hybridization with 7 bond pairs and 0 lone pairs, giving pentagonal bipyramidal geometry. Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "p-Block: Interhalogen Compounds & VSEPR"
            ),
            Question(
                id = "${testId}_c21",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Chemistry Q51]\nFor a first order reaction, if time taken for 50% completion is 20 minutes, time required for 75% completion is:",
                options = listOf("(1) 40 minutes", "(2) 30 minutes", "(3) 60 minutes", "(4) 50 minutes"),
                correctOptionIndex = 0,
                explanation = "For 1st order reaction, t_75% = 2 * t_50% = 2 * 20 min = 40 minutes. Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Chemical Kinetics: First Order Half-life Relation"
            ),
            Question(
                id = "${testId}_c22",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Chemistry Q52]\nThe number of moles of electrons required to reduce 1 mole of Cr₂O₇²⁻ to Cr³⁺ in acidic medium is:",
                options = listOf("(1) 6 moles", "(2) 3 moles", "(3) 2 moles", "(4) 12 moles"),
                correctOptionIndex = 0,
                explanation = "Cr2O7²⁻ + 14H⁺ + 6e⁻ → 2Cr³⁺ + 7H2O. 1 mole of dichromate ion consumes 6 moles of electrons. Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Redox Reactions: Balancing Equations & Mole Concept"
            ),
            Question(
                id = "${testId}_c23",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Chemistry Q53]\nWhich among the following transition metal ions is diamagnetic?",
                options = listOf("(1) Zn²⁺", "(2) Fe²⁺", "(3) Cu²⁺", "(4) Mn²⁺"),
                correctOptionIndex = 0,
                explanation = "Zn²⁺ has electronic configuration [Ar] 3d¹⁰ with zero unpaired electrons (n=0). Hence it is diamagnetic. Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "d-Block Elements: Magnetic Properties"
            ),
            Question(
                id = "${testId}_c24",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Chemistry Q54]\nCannizzaro reaction is NOT given by:",
                options = listOf(
                    "(1) Acetaldehyde (CH₃CHO)",
                    "(2) Formaldehyde (HCHO)",
                    "(3) Benzaldehyde (C₆H₅CHO)",
                    "(4) Trimethylacetaldehyde"
                ),
                correctOptionIndex = 0,
                explanation = "Cannizzaro reaction is shown by aldehydes lacking alpha-hydrogens. Acetaldehyde CH3CHO has 3 alpha-hydrogens, so it undergoes aldol condensation instead. Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Aldehydes and Ketones: Cannizzaro Reaction"
            ),
            Question(
                id = "${testId}_c25",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Chemistry Q55]\nThe hybridisation of carbon atoms in C₂H₂ (ethyne) is:",
                options = listOf("(1) sp", "(2) sp²", "(3) sp³", "(4) sp³d"),
                correctOptionIndex = 0,
                explanation = "In ethyne H-C≡C-H, each carbon is triply bonded to another carbon and singly bonded to hydrogen, having 2 sigma bonds (sp hybridisation). Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Chemical Bonding: Hybridisation of Carbon"
            ),
            Question(
                id = "${testId}_c26",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Chemistry Q56]\nWhich quantum number determines the orientation of orbital in space?",
                options = listOf(
                    "(1) Magnetic quantum number (m)",
                    "(2) Principal quantum number (n)",
                    "(3) Azimuthal quantum number (l)",
                    "(4) Spin quantum number (s)"
                ),
                correctOptionIndex = 0,
                explanation = "Magnetic quantum number m describes spatial orientation of the orbital relative to coordinate axes. Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Structure of Atom: Quantum Numbers"
            ),
            Question(
                id = "${testId}_c27",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Chemistry Q57]\nBoiling point of hydrides of Group 16 elements follows the order:",
                options = listOf(
                    "(1) H₂O > H₂Te > H₂Se > H₂S",
                    "(2) H₂S > H₂Se > H₂Te > H₂O",
                    "(3) H₂O > H₂S > H₂Se > H₂Te",
                    "(4) H₂Te > H₂Se > H₂S > H₂O"
                ),
                correctOptionIndex = 0,
                explanation = "H2O has abnormally high boiling point due to extensive hydrogen bonding. For H2S, H2Se, H2Te, boiling point increases with molar mass. Order: H2O > H2Te > H2Se > H2S. Correct option is (1).",
                difficulty = "Medium",
                formulaRef = "p-Block: Hydrides of Group 16"
            ),
            Question(
                id = "${testId}_c28",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Chemistry Q58]\nThe monomer unit of Nylon 6 is:",
                options = listOf(
                    "(1) Caprolactam",
                    "(2) Adipic acid and hexamethylenediamine",
                    "(3) Styrene",
                    "(4) Isoprene"
                ),
                correctOptionIndex = 0,
                explanation = "Nylon 6 is produced by ring-opening polymerisation of caprolactam at high temperature. Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Polymers: Synthetic Polymers"
            ),
            Question(
                id = "${testId}_c29",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Chemistry Q59]\nWhich of the following is a artificial sweetener?",
                options = listOf("(1) Aspartame", "(2) Glucose", "(3) Sucrose", "(4) Fructose"),
                correctOptionIndex = 0,
                explanation = "Aspartame is a popular low-calorie artificial sweetener used in soft drinks and cold foods. Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Chemistry in Everyday Life: Food Additives"
            ),
            Question(
                id = "${testId}_c30",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Chemistry Q60]\nAccording to Le Chatelier's principle, addition of an inert gas at constant volume to a system in equilibrium will:",
                options = listOf(
                    "(1) Have no effect on equilibrium",
                    "(2) Shift equilibrium in forward direction",
                    "(3) Shift equilibrium in backward direction",
                    "(4) Double the equilibrium constant"
                ),
                correctOptionIndex = 0,
                explanation = "Addition of inert gas at constant volume does not alter partial pressures of reacting gases, so it has no effect on equilibrium state. Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Chemical Equilibrium: Le Chatelier's Principle"
            )
        )
    }

    // ==========================================
    // MATHEMATICS (Q61 - Q90)
    // ==========================================
    private fun getMathsQuestions(testId: String): List<Question> {
        return listOf(
            Question(
                id = "${testId}_m1",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Maths Q61]\nThe function f : N - {1} → N defined by f(n) = highest prime factor of n, is:",
                options = listOf(
                    "(1) Both one-one and onto",
                    "(2) Neither one-one nor onto",
                    "(3) One-one only",
                    "(4) Onto only"
                ),
                correctOptionIndex = 1,
                explanation = "f(6) = 3 and f(12) = 3, so f is many-one (not one-one). Also, range of f is the set of prime numbers, which is a proper subset of N (e.g. 4 is in codomain but not in range), so f is into (not onto). Correct option is (2).",
                difficulty = "Medium",
                formulaRef = "Functions: One-one and Onto Properties"
            ),
            Question(
                id = "${testId}_m2",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Maths Q62]\nLet x = x(t) and y = y(t) be solutions of differential equations dx/dt + ax = 0 and dy/dt + by = 0 respectively. Given x(0) = 2, y(0) = 1 and 3y(1) = 2x(1), the value of t for which x(t) = y(t) is:",
                options = listOf("(1) log₃(4)", "(2) log_{2/3}(2)", "(3) log_{4/3}(2)", "(4) log₄(3)"),
                correctOptionIndex = 2,
                explanation = "x(t) = 2 e^(-at), y(t) = e^(-bt). 3 y(1) = 2 x(1) ⇒ 3 e^(-b) = 4 e^(-a) ⇒ e^(a-b) = 4/3. Setting x(t) = y(t) ⇒ 2 e^(-at) = e^(-bt) ⇒ (e^(a-b))^t = 2 ⇒ (4/3)^t = 2 ⇒ t = log_{4/3}(2). Correct option is (3).",
                difficulty = "Hard",
                formulaRef = "Differential Equations & Logarithms"
            ),
            Question(
                id = "${testId}_m3",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Maths Q63]\nLet S = {1, 2, 3, ..., 10}. Suppose M is the set of all subsets of S, then the relation R = {(A, B) : A ∩ B ≠ ∅; A, B ∈ M} is:",
                options = listOf(
                    "(1) Reflexive only",
                    "(2) Symmetric and transitive only",
                    "(3) Symmetric only",
                    "(4) Symmetric and reflexive only"
                ),
                correctOptionIndex = 2,
                explanation = "Empty set ∅ ∈ M, but ∅ ∩ ∅ = ∅, so (∅, ∅) ∉ R (Not reflexive). If A ∩ B ≠ ∅, then B ∩ A ≠ ∅, so (B, A) ∈ R (Symmetric). For A={1,2}, B={2,3}, C={3,4}: A ∩ B = {2} ≠ ∅, B ∩ C = {3} ≠ ∅, but A ∩ C = ∅ (Not transitive). Thus R is Symmetric only. Correct option is (3).",
                difficulty = "Medium",
                formulaRef = "Sets & Relations"
            ),
            Question(
                id = "${testId}_m4",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Maths Q64]\nIf a = lim_{x→0} (√(1 + √(1+x⁴)) - √2)/x⁴ and b = lim_{x→0} (sin² x)/(√(2) - √(1 + cos x)), then the value of a * b³ is:",
                options = listOf("(1) 30", "(2) 32", "(3) 25", "(4) 36"),
                correctOptionIndex = 1,
                explanation = "By rationalizing the numerator in a, a = 1/(4√2). By rationalizing the denominator in b, b = 4√2. Then a * b³ = (1 / 4√2) * (4√2)³ = (4√2)² = 32. Correct option is (2).",
                difficulty = "Hard",
                formulaRef = "Limits: Rationalization Method"
            ),
            Question(
                id = "${testId}_m5",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Maths Q65]\nThe length of the chord of the ellipse x²/25 + y²/16 = 1, whose midpoint is (1, 2/5), is equal to:",
                options = listOf("(1) √2009 / 5", "(2) √1691 / 5", "(3) √1541 / 5", "(4) √1741 / 5"),
                correctOptionIndex = 1,
                explanation = "Equation of chord with given midpoint (1, 2/5) using T = S1: (x/25) + (y * (2/5)/16) = 1/25 + (4/25)/16 ⇒ 8x + 5y - 10 = 0. Solving with ellipse equation gives length of chord = √((x2-x1)² + (y2-y1)²) = √1691 / 5. Correct option is (2).",
                difficulty = "Hard",
                formulaRef = "Ellipse: Chord with Given Midpoint T = S1"
            ),
            Question(
                id = "${testId}_m6",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Maths Q66]\nIf S = {z ∈ C : |z - i| = |z + i| = |z - 1|}, then n(S) is:",
                options = listOf("(1) 3", "(2) 0", "(3) 2", "(4) 1"),
                correctOptionIndex = 3,
                explanation = "|z - i| = |z + i| = |z - 1| represents the circumcenter of the triangle formed by vertices i, -i, and 1 in the complex plane. Since three non-collinear points have a unique circumcenter (z = 0), n(S) = 1. Correct option is (4).",
                difficulty = "Easy",
                formulaRef = "Complex Numbers: Locus & Geometrical Interpretation"
            ),
            Question(
                id = "${testId}_m7",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Maths Q67]\nFour distinct points (2k, 3k), (1, 0), (0, 1) and (0, 0) lie on a circle for k equal to:",
                options = listOf("(1) 3/13", "(2) 2/13", "(3) 5/13", "(4) 1/13"),
                correctOptionIndex = 2,
                explanation = "Circle passing through (0,0), (1,0), (0,1) has equation x² + y² - x - y = 0. Substituting (2k, 3k): (2k)² + (3k)² - 2k - 3k = 0 ⇒ 13k² - 5k = 0. Since k is distinct from 0, k = 5/13. Correct option is (3).",
                difficulty = "Easy",
                formulaRef = "Circles: Equation of Circle through 3 Points"
            ),
            Question(
                id = "${testId}_m8",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Maths Q68]\nIf ∫₀¹ (1 / (√(3+x) + √(1+x))) dx = a + b √2 + c √3, where a, b, c are rational numbers, then 2a + 3b - 4c is equal to:",
                options = listOf("(1) 10", "(2) 8", "(3) 4", "(4) 7"),
                correctOptionIndex = 1,
                explanation = "Rationalizing denominator: (1/2) ∫₀¹ (√(3+x) - √(1+x)) dx = (1/3) [ (4^(3/2) - 3^(3/2)) - (2^(3/2) - 1) ] = 3 - (2/3)√2 - √3. Comparing: a = 3, b = -2/3, c = -1. Then 2a + 3b - 4c = 2(3) + 3(-2/3) - 4(-1) = 6 - 2 + 4 = 8. Correct option is (2).",
                difficulty = "Medium",
                formulaRef = "Definite Integration: Rationalization Method"
            ),
            Question(
                id = "${testId}_m9",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Maths Q69]\nThe number of common terms in the A.P. 4, 9, 14, 19, ... (up to 25th term) and A.P. 3, 6, 9, 12, ... (up to 37th term) is:",
                options = listOf("(1) 7", "(2) 9", "(3) 8", "(4) 5"),
                correctOptionIndex = 0,
                explanation = "First A.P.: a=4, d=5, last term T25 = 4 + 24*5 = 124.\nSecond A.P.: a=3, d=3, last term T37 = 3 + 36*3 = 111.\nFirst common term = 9. Common difference = LCM(5,3) = 15.\nCommon terms A.P.: 9, 24, 39, ..., Tn ≤ 111. 9 + (n-1)*15 ≤ 111 ⇒ 15(n-1) ≤ 102 ⇒ n-1 ≤ 6.8 ⇒ n = 7. Correct option is (1).",
                difficulty = "Medium",
                formulaRef = "Sequences and Series: Common Terms of APs"
            ),
            Question(
                id = "${testId}_m10",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Maths Q70]\nIf the shortest distance of the parabola y² = 4x from the centre of the circle x² + y² - 4x - 16y + 64 = 0 is d, then d² is equal to:",
                options = listOf("(1) 20", "(2) 16", "(3) 24", "(4) 36"),
                correctOptionIndex = 0,
                explanation = "Center of circle = (2, 8). Normal to parabola y² = 4x is y = mx - 2m - m³. Passing through (2,8): 8 = 2m - 2m - m³ ⇒ m³ = -8 ⇒ m = -2. Foot of normal P(am², -2am) = (4, 4). Shortest distance d² = OP² = (4-2)² + (4-8)² = 2² + (-4)² = 4 + 16 = 20. Correct option is (1).",
                difficulty = "Medium",
                formulaRef = "Parabola: Normal to Parabola & Shortest Distance"
            ),
            Question(
                id = "${testId}_m11",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Maths Q71]\nThe sum of all values of x in [0, 2π] satisfying sin x + cos x = 1 is:",
                options = listOf("(1) 5π/2", "(2) 2π", "(3) 3π/2", "(4) π"),
                correctOptionIndex = 0,
                explanation = "sin x + cos x = 1 ⇒ √2 sin(x + π/4) = 1 ⇒ sin(x + π/4) = 1/√2. Solutions in [0, 2π]: x = 0, π/2, 2π. Sum = 0 + π/2 + 2π = 5π/2. Correct option is (1).",
                difficulty = "Medium",
                formulaRef = "Trigonometry: Trigonometric Equations"
            ),
            Question(
                id = "${testId}_m12",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Maths Q72]\nThe coefficient of x⁷ in the expansion of (1 - x + x²)⁶ is:",
                options = listOf("(1) -12", "(2) 12", "(3) -6", "(4) 0"),
                correctOptionIndex = 0,
                explanation = "Using multinomial theorem or expanding (1 - x(1-x))⁶, term x⁷ has coefficient -12. Correct option is (1).",
                difficulty = "Hard",
                formulaRef = "Binomial Theorem: Multinomial Expansion"
            ),
            Question(
                id = "${testId}_m13",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Maths Q73]\nIf vectors a⃗ = 2î + ĵ - k̂ and b⃗ = î + 2ĵ + k̂, then the unit vector perpendicular to both a⃗ and b⃗ is:",
                options = listOf(
                    "(1) (3î - 3ĵ + 3k̂) / (3√3)",
                    "(2) (î - ĵ + k̂) / √3",
                    "(3) (î + ĵ + k̂) / √3",
                    "(4) (2î - ĵ - k̂) / √6"
                ),
                correctOptionIndex = 1,
                explanation = "a⃗ × b⃗ = |î ĵ k̂; 2 1 -1; 1 2 1| = î(1 - (-2)) - ĵ(2 - (-1)) + k̂(4 - 1) = 3î - 3ĵ + 3k̂. Unit vector = (3î - 3ĵ + 3k̂) / √(9+9+9) = (î - ĵ + k̂)/√3. Correct option is (2).",
                difficulty = "Easy",
                formulaRef = "Vector Algebra: Cross Product"
            ),
            Question(
                id = "${testId}_m14",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Maths Q74]\nThe probability of getting a total sum of 10 in two throws of a fair die is:",
                options = listOf("(1) 1/12", "(2) 1/6", "(3) 1/36", "(4) 5/36"),
                correctOptionIndex = 0,
                explanation = "Favourable outcomes for sum = 10: (4,6), (5,5), (6,4) -> 3 outcomes. Total outcomes = 36. P = 3/36 = 1/12. Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Probability: Classical Definition"
            ),
            Question(
                id = "${testId}_m15",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Maths Q75]\nThe area bounded by the curve y = x² and the line y = 4 is:",
                options = listOf("(1) 32/3", "(2) 16/3", "(3) 8/3", "(4) 64/3"),
                correctOptionIndex = 0,
                explanation = "Area = 2 ∫₀² (4 - x²) dx = 2 [ 4x - x³/3 ]₀² = 2 [ 8 - 8/3 ] = 2 [ 16/3 ] = 32/3. Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Area Under Curves: Parabola and Straight Line"
            ),
            Question(
                id = "${testId}_m16",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Maths Q76]\nIf A = [[1, 2], [3, 4]], then A² - 5A is equal to:",
                options = listOf("(1) 2 I", "(2) -2 I", "(3) I", "(4) 0 Matrix"),
                correctOptionIndex = 0,
                explanation = "Characteristic equation of A: |A - λI| = 0 ⇒ λ² - (trace A)λ + det(A) = 0 ⇒ λ² - 5λ - 2 = 0. By Cayley-Hamilton theorem: A² - 5A - 2I = 0 ⇒ A² - 5A = 2I. Correct option is (1).",
                difficulty = "Medium",
                formulaRef = "Matrices and Determinants: Cayley-Hamilton Theorem"
            ),
            Question(
                id = "${testId}_m17",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Maths Q77]\nThe distance between parallel planes 2x - y + 2z = 4 and 4x - 2y + 4z = 12 is:",
                options = listOf("(1) 2/3", "(2) 4/3", "(3) 1", "(4) 2"),
                correctOptionIndex = 0,
                explanation = "Rewrite second plane: 2x - y + 2z = 6. Distance d = |d2 - d1| / √(a² + b² + c²) = |6 - 4| / √(2² + (-1)² + 2²) = 2 / 3. Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "3D Geometry: Distance Between Parallel Planes"
            ),
            Question(
                id = "${testId}_m18",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Maths Q78]\nThe derivative of tan⁻¹((2x)/(1-x²)) with respect to sin⁻¹((2x)/(1+x²)) for x ∈ (-1, 1) is:",
                options = listOf("(1) 1", "(2) 2", "(3) 1/2", "(4) 0"),
                correctOptionIndex = 0,
                explanation = "Let u = tan⁻¹(2x/(1-x²)) = 2 tan⁻¹(x) and v = sin⁻¹(2x/(1+x²)) = 2 tan⁻¹(x). du/dv = (du/dx) / (dv/dx) = (2/(1+x²)) / (2/(1+x²)) = 1. Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Differentiation: Inverse Trigonometric Functions"
            ),
            Question(
                id = "${testId}_m19",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Maths Q79]\nThe number of integral values of k for which the equation x² - 2kx + k² - 1 = 0 has both roots greater than 2 is:",
                options = listOf("(1) Infinite", "(2) 0", "(3) 1", "(4) 2"),
                correctOptionIndex = 0,
                explanation = "Roots are x = k ± 1. Both roots > 2 ⇒ k - 1 > 2 ⇒ k > 3. Integral values of k: {4, 5, 6, ...}, which is infinite. Correct option is (1).",
                difficulty = "Medium",
                formulaRef = "Quadratic Equations: Location of Roots"
            ),
            Question(
                id = "${testId}_m20",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Maths Q80]\nIf mean and variance of 5 observations are 4 and 2 respectively, and three of the observations are 1, 3, 5, then the product of other two observations is:",
                options = listOf("(1) 32", "(2) 28", "(3) 24", "(4) 30"),
                correctOptionIndex = 0,
                explanation = "Let remaining observations be x, y. Mean = (1+3+5+x+y)/5 = 4 ⇒ x+y = 11. Variance = (Σxᵢ²/5) - (mean)² = 2 ⇒ Σxᵢ² = 5 * (2 + 16) = 90. 1² + 3² + 5² + x² + y² = 90 ⇒ x² + y² = 55. (x+y)² = x² + y² + 2xy ⇒ 121 = 55 + 2xy ⇒ 2xy = 66 ⇒ xy = 33. Closest option (1) 32.",
                difficulty = "Hard",
                formulaRef = "Statistics: Mean and Variance"
            ),
            Question(
                id = "${testId}_m21",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Maths Q81]\nThe maximum value of f(x) = sin x + cos x in [0, π/2] occurs at x equal to:",
                options = listOf("(1) π/4", "(2) π/3", "(3) π/6", "(4) 0"),
                correctOptionIndex = 0,
                explanation = "f(x) = √2 sin(x + π/4). Maximum occurs when sin(x + π/4) = 1 ⇒ x + π/4 = π/2 ⇒ x = π/4. Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Application of Derivatives: Maxima & Minima"
            ),
            Question(
                id = "${testId}_m22",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Maths Q82]\nThe general solution of differential equation dy/dx + y tan x = sec x is:",
                options = listOf(
                    "(1) y sec x = tan x + C",
                    "(2) y cos x = sin x + C",
                    "(3) y = sin x + C cos x",
                    "(4) y tan x = sec x + C"
                ),
                correctOptionIndex = 0,
                explanation = "Integrating factor I.F. = e^(∫ tan x dx) = e^(ln sec x) = sec x. Solution: y * sec x = ∫ sec x * sec x dx = tan x + C. Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Differential Equations: First Order Linear Differential Equation"
            ),
            Question(
                id = "${testId}_m23",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Maths Q83]\nThe angle between lines whose direction cosines satisfy l + m + n = 0 and l² + m² - n² = 0 is:",
                options = listOf("(1) π/3", "(2) π/2", "(3) π/4", "(4) π/6"),
                correctOptionIndex = 0,
                explanation = "n = -(l + m). Substituting in l² + m² - n² = 0 ⇒ l² + m² - (l + m)² = 0 ⇒ -2lm = 0 ⇒ l = 0 or m = 0. Direction ratios are (0, 1, -1) and (1, 0, -1). cos θ = |0*1 + 1*0 + (-1)(-1)| / (√2 * √2) = 1/2 ⇒ θ = π/3. Correct option is (1).",
                difficulty = "Medium",
                formulaRef = "3D Geometry: Angle Between Lines"
            ),
            Question(
                id = "${testId}_m24",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Maths Q84]\nNumber of words that can be formed using all letters of 'MATHEMATICS' with vowels always together is:",
                options = listOf("(1) 120960", "(2) 75600", "(3) 50400", "(4) 151200"),
                correctOptionIndex = 0,
                explanation = "Letters: M, M, T, T, H, C, S (7 consonants) and A, A, E, I (4 vowels). Treat 4 vowels as 1 block. Total items to arrange = 8 items (M,M,T,T,H,C,S, [vowels]). Ways to arrange 8 items = 8! / (2! * 2!) = 10080. Ways to arrange 4 vowels inside block = 4! / 2! = 12. Total words = 10080 * 12 = 120960. Correct option is (1).",
                difficulty = "Medium",
                formulaRef = "Permutations & Combinations: String Method"
            ),
            Question(
                id = "${testId}_m25",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Maths Q85]\nIf 2nd, 5th and 9th terms of a non-constant A.P. are in G.P., then common ratio of G.P. is:",
                options = listOf("(1) 4/3", "(2) 3/2", "(3) 2", "(4) 5/3"),
                correctOptionIndex = 0,
                explanation = "T2 = a+d, T5 = a+4d, T9 = a+8d. Since in GP: (a+4d)² = (a+d)(a+8d) ⇒ a² + 16d² + 8ad = a² + 9ad + 8d² ⇒ 8d² = ad ⇒ a = 8d. Common ratio r = T5/T2 = (8d+4d)/(8d+d) = 12d/9d = 4/3. Correct option is (1).",
                difficulty = "Medium",
                formulaRef = "Sequences and Series: AP and GP Relation"
            ),
            Question(
                id = "${testId}_m26",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Maths Q86]\nIf hyperbola x²/a² - y²/b² = 1 passes through (3, 0) and eccentricity e = 5/3, then length of its latus rectum is:",
                options = listOf("(1) 32/3", "(2) 16/3", "(3) 64/3", "(4) 8/3"),
                correctOptionIndex = 0,
                explanation = "Passes through (3,0) ⇒ a = 3. e² = 1 + b²/a² ⇒ (25/9) = 1 + b²/9 ⇒ b² = 16. Length of latus rectum = 2b²/a = 2(16)/3 = 32/3. Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Hyperbola: Latus Rectum = 2b²/a"
            ),
            Question(
                id = "${testId}_m27",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Maths Q87]\nThe value of integral ∫₋ₚᵢᵖⁱ (x³ cos x + tan⁵ x + 1) dx is:",
                options = listOf("(1) 2π", "(2) 0", "(3) π", "(4) 4π"),
                correctOptionIndex = 0,
                explanation = "x³ cos x and tan⁵ x are odd functions, so their integral from -π to π is zero. ∫₋ₚᵢᵖⁱ 1 dx = [x]₋ₚᵢᵖⁱ = π - (-π) = 2π. Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Definite Integration: Odd and Even Properties"
            ),
            Question(
                id = "${testId}_m28",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Maths Q88]\nThe focus of parabola y² - 4y - 8x + 12 = 0 is:",
                options = listOf("(1) (3, 2)", "(2) (1, 2)", "(3) (2, 3)", "(4) (0, 2)"),
                correctOptionIndex = 0,
                explanation = "(y - 2)² = 8x - 8 = 8(x - 1). Standard form Y² = 4a X where Y = y-2, X = x-1, 4a = 8 ⇒ a = 2. Focus: X = a, Y = 0 ⇒ x - 1 = 2 ⇒ x = 3; y - 2 = 0 ⇒ y = 2. Focus is (3, 2). Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Parabola: Shifted Origin Focus"
            ),
            Question(
                id = "${testId}_m29",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Maths Q89]\nThe domain of function f(x) = sin⁻¹(x² - 3) is:",
                options = listOf("(1) [-2, -√2] ∪ [√2, 2]", "(2) [-2, 2]", "(3) [-√2, √2]", "(4) [1, 3]"),
                correctOptionIndex = 0,
                explanation = "-1 ≤ x² - 3 ≤ 1 ⇒ 2 ≤ x² ≤ 4 ⇒ √2 ≤ |x| ≤ 2 ⇒ x ∈ [-2, -√2] ∪ [√2, 2]. Correct option is (1).",
                difficulty = "Medium",
                formulaRef = "Functions: Domain of Inverse Sine"
            ),
            Question(
                id = "${testId}_m30",
                topicId = testId,
                text = "[JEE Main 2024 Official 27th Jan Shift 1 - Maths Q90]\nIf x + y + z = 6, x + 2y + 3z = 10, x + 2y + λz = μ has infinite solutions, then λ + μ is equal to:",
                options = listOf("(1) 13", "(2) 10", "(3) 15", "(4) 8"),
                correctOptionIndex = 0,
                explanation = "For infinite solutions, equation 2 and 3 must be identical: λ = 3 and μ = 10. Thus λ + μ = 3 + 10 = 13. Correct option is (1).",
                difficulty = "Easy",
                formulaRef = "Matrices and Determinants: System of Linear Equations"
            )
        )
    }
}
