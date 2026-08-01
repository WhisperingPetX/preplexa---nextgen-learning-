package com.example.data.repository
import com.example.model.Question
object JeeMain2023Session2Shift2QuestionsRepository {
    fun getQuestions(testId: String): List<Question> {
        return listOf(
            Question(
                id = "${testId}_s2_sh2_q1_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Mathematics Q1]\\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n2n 1\n1\n2\n1\n5\n1\n2\n1\n3\n1\n2\n1\nn\nlim 2 – 2 2 – 2 ..... 2 – 2 is equal to",
                options = listOf("1", "0", "2", "2\n1"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n2n 1\n1\n2\n1\n5\n1\n2\n1\n3\n1\n2\n1\nn\nlim 2 – 2 2 – 2 ..... 2 – 2\nSince 3\n1\n2\n1\n2 – 2 < 1\n5\n1\n2\n1\n2 – 2 < 1\n----------------\n2 – 2 1\n2n 1\n1\n2\n1\n\n n  N\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n2n 1\n1\n2\n1\n5\n1\n2\n1\n3\n1\n2\n1\nn\nlim 2 – 2 2 – 2 ..... 2 – 2 = 0",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q2_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Mathematics Q2]\\nIf gcd (m, n) = 1 and 12\n– 22\n + 32\n– 42\n + ….. + (2021)2 \n– (2022)2\n + (2023)2\n = 1012m2\nn then m2\n– n\n2\n is equal to",
                options = listOf("240", "200", "220", "180"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n1\n2\n– 22\n + 32\n– 42\n + ….. + (2021)2\n– (2022)2\n + (2023)\n2\n= \n2\n1011times\n– 3–7 –11... (2023)\n= \n2\n–1011 [6 + (1010)4] + (2023)2\n = 2023(1012)\n 2023 = 172\n × 7\n m = 17, n = 7\n m\n2\n– n\n2\n = 289 – 49 = 240",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q3_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Mathematics Q3]\\nIn a group of 100 persons 75 speak English and 40 speak Hindi. Each person speaks at least one of the two \nlanguages. If the number of persons who speak only English is  and the number of persons who speak only \nHindi is , then the eccentricity of the ellipse 25(\n2\nx\n2\n + \n2\ny\n2\n) = \n2\n\n2\n is",
                options = listOf("12\n119", "12\n117", "12\n3 15", "12\n129"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n \nE H\n75 – \nNow  = 100 – 75 = 25\n  = 75 – [40 – 25] = 60\nNow, ellipse 1\n25\ny\n(60)\nx\n25 2\n2\n2\n2\n \n\n\n\n\n\n\n 1\n25\ny\n36 4\nx\n2 2\n \n\n e = \n12\n119\n36 4\n25 1 – \n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q4_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Mathematics Q4]\\nLet the vectors a ,b, c\n\n \n represent three coterminous edges of a parallelopiped of volume V. Then the volume \nof the parallelopiped, whose coterminous edges are represented by a ,b c\n\n \n and a 2b 3c\n\n \n  is equal to",
                options = listOf("2V", "6V", "V", "3V"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n[a ,b c, a 2b 3c]\n\n  \n \n   = \n1 2 3\n0 1 1\n1 0 0\n[a b c]\n\n \n = [a b c]\n\n \n = V",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q5_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Mathematics Q5]\\nIf the solution curve f(x, y) = 0 of the differential equation (1 + logex)\ndy\ndx\n– x logex = e\ny\n, x > 0, passes \nthrough the points (1, 0) and (, 2), then aa\n is equal to",
                options = listOf("2\n2e\ne", "2\ne\ne", "2\n2e\ne", "2\n2e\ne"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n(1 + ln x)\ndy\ndx\n– x ln x = ey\nPut x ln x = t \n(1 + ln x) dx = dt\n y\n– t e\ndy\ndt\n\nI.F = \n– dy\ne = e\n–y\nt × e–y\n = \ne  e dy  c\ny – y\nt × e–y\n = y + c\nx ln x = y ey\n + c ey\nPut x = 1, y = 0 \n c = 0\nPut x = a, y = 2\na ln a = 2e2\n a\na\n = \n2\n2e\ne",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q6_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Mathematics Q6]\\nLet f(x) be a function satisfying f(x) + f( – x) = \n2\n,  x  R. Then \n\n0\nf(x)sin x dx is equal to",
                options = listOf("4\n2\n", "2\n2", "2\n", "2\n2\n"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nI = \n\n0\nf(x)sin x dx\nI = \n\n\n0\nf ( – x)sin x dx\n2I = \n\n \n0\nsin x(f (x) f( – x))dx\n2I = \n\n\n0\n2\nsin x dx  2I = \n\n\n2\n0\n2\n2 sin x dx\nI = \n2",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q7_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Mathematics Q7]\\nIf the tangents at the points P and Q on the circle x2\n + y2\n– 2x + y = 5 meet at the point \n\n\n\n\n\n,2\n4\n9\nR , then the \narea of the triangle PQR is",
                options = listOf("4\n5", "8\n13", "8\n5", "4\n13"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nL\nP\n2\n5\n\n\n\n\n\n\n2\n1\n1, –\nx\n2\n + y2\n– 2x + y – 5 = 0\n2\n5\nR \n\n\n\n\n\n\n, 2\n4\n9\nR\nQ\nL = S1 = 2 – 5\n4\n9\n(2) – 2\n4\n9 2\n2\n   \n\n\n\n\n\n= \n4\n5\nArea = 2 2\n3\n2 2\n3\n4\n5\n2\n5\n4\n5\n2\n5\nR L\nRL\n\n\n\n\n\n\n \n\n\n\n\n\n\n\n\n\n\n\n\n\n\n= \n8\n5\n4 1\n8\n25\n\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q8_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Mathematics Q8]\\nThe area bounded by the curves y = |x – 1| + |x – 2| and y = 3 is equal to",
                options = listOf("4", "6", "3", "5"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n(3, 3)\ny = |x – 1| + |x – 2|\n(0, 3)\n(1, 1) (2, 1)\nArea = \n2\n1\n[1 + 3] × 2 = 4",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q9_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Mathematics Q9]\\nIf the coefficients of x7\n in \n11\n2\n2bx\n1\nax \n\n\n\n\n\n and x\n–7\n in \n11\n2\n3bx\n1\nax – \n\n\n\n\n\nare equal, then",
                options = listOf("729ab = 32", "32ab = 729", "64ab = 243", "243ab = 64"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nCoefficient of x7\n in \n11\n2\n2bx\n1\nax \n\n\n\n\n\n\nTr+1 = \n11Cr  \nr\n11–r\n2\n2bx\n1\nax \n\n\n\n\n\n= \n11Cr(a)11–r 22–3r\nr\nx\n2b\n1\n\n\n\n\n\n\n22 – 3r = 7  r = 5\nCoefficient of x–7 in \n11\n2\n3bx\n1\nax – \n\n\n\n\n\nTr+1 = \n11Cr(ax)11–r\nr\n2\n3bx\n1\n– \n\n\n\n\n\n= \n11Cra\n11–r 11–3r\nr\nx\n3b\n1\n– \n\n\n\n\n\n11 – 3r = –7  r = 6\n\n11C5(a)6\n5\n2b\n1\n\n\n\n\n\n\n= \n11C6a\n5\n6\n3b\n1\n– \n\n\n\n\n\n 36\nab = 32\n 729 ab = 32",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q10_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Mathematics Q10]\\nLet the sets A and B denote the domain and range respectively of the function f(x) = \n[x] – x\n1\n, where [x] \ndenotes the smallest integer greater than or equal to x. Then among the statements\n(S1) : A  B = (1, ) – N and \n(S2) : A  B = (1, )",
                options = listOf("Only (S2) is true", "Only (S1) is true", "Neither (S1) nor (S2) is true", "Both (S1) and (S2) are true"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nf(x) = \n[x] – x\n1\n= \n–{x}\n1\n Domain = ",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q11_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Mathematics Q11]\\nLet P be a square matrix such that P2\n = I – P. For , , ,   N, if P\n + P\n = I – 29P and P\n– P\n = I – 13P,\nthen  +  +  –  is equal to",
                options = listOf("18", "40", "22", "24"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nP\n2\n = I – P\nP\n4\n = (I − P)(I − P) = I + P\n2\n– 2P = 2I − 3P\nP\n6\n = 2I − 5P + 3P2\n = 2I − 5P + 3(IP) = 5I − 8P …(i)\nP\n8\n = 5I − 13P + 8P2\n = 13I − 21P …(ii)\n(ii) + (i)\nP\n8\n + P6\n = 18I − 29P\n(ii) – (i)\nP\n8\n– P6\n = 8I −13P\n = 8,  = 6,  = 18,  = 8\n8 + 6 + 18 + 8 = 24",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q12_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Mathematics Q12]\\nAmong the statements\n(S1) : (p  q) ((~p) q) is tautology\n(S2) : (q  p) ((~p)  q) is a contradiction",
                options = listOf("Neither (S1) and (S2) is True", "Both (S1) and (S2) are True", "Only (S2) is True", "Only (S1) is True"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nS-1 : (p  q)  (~p  q)\n (p  q)  (p  q)\n(p  (p q))  q\n= (p)  q (not a tautology)\nS-2 : (q  p)  (p  q)\n (q  p)(pq\n(q  p)  (pq\n= p  q (not a contradiction)",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q13_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Mathematics Q13]\\nAll the letters of the word PUBLIC are written in all possible orders and these words are written as in a \ndictionary with serial numbers. Then the serial number of the word PUBLIC is",
                options = listOf("576", "578", "580", "582"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n5! 4! 3! 2! 1! 0!\n4 4 0 2 1 0\nP U B L I C\n5 6 1 4 3 2\nRank = (1 × 1! + 2 × 2! + 4 × 4! + 4 × 5!) + 1\n= (1 + 4 + 96 + 480) + 1\n= 582",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q14_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Mathematics Q14]\\nThree dice are rolled. If the probability of getting different numbers on the three dice is p/q, where p and q \nare co-prime, then q – p is equal to",
                options = listOf("2", "1", "3", "4"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nIf numbers are different on all three dice then number of ways\n= 6 × 5 × 4 = 120\nP(E) = 3\n6\n120\n = \n216\n120\n= \n9\n5\n= \nq\np\nNow, q – p = 9 – 5 = 4",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q15_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Mathematics Q15]\\nAmong the statements : \n(S1) : 20232022\n– 19992022 is divisible by 8.\n(S2) : 13(13)n\n– 11n – 13 is divisible by 144 for infinitely many n  N",
                options = listOf("Only (S2) is correct", "Only (S1) is correct", "Both (S1) and (S2) are correct", "Both (S1) and (S2) are incorrect"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n(S1) : (2023)2022 \n– (1999)2022 is divisible by 8\nWe know that (x – y) divides (xn\n– y\nn\n)  n  N\n (2023 – 1999) divides (2023)2022\n– (1999)2022\n 24 divides (2023)2022\n – (1999)2002\n 8 will divide (2023)2022\n– (1999)2002\n (S1) is correct.\n(S2) : 13(13)n\n– 11n – 13 is divisible by 144 for n N.\n13(1 + 12)n\n– 11n − 13\n13 (\nnC0 + nC112 + nC2122\n+...+\nnCn12n\n) – 11n – 13 \n12 × 13n − 11n + 122\n\n145n + 144 is not divisible by 144.\n (S2) is incorrect.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q16_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Mathematics Q16]\\nLet the line L pass through the point (0, 1, 2), intersect the line \n4\nz – 3\n3\ny – 2\n2\nx –1\n  and be parallel to the \nplane 2x + y – 3z = 4. Then the distance of the point P(1, –9, 2) from the line L is",
                options = listOf("74", "69", "54", "9"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n(0, 1, 2)\nL = 0\n< a, b, c>\n(1, 2, 3)\n<2, 3, 4>\nL1 = 0\n<2, 1, –3>\n2 3 4\n1 1 1\na b c\n = 0\na b c\n2a b – 3c 0\na – 2b c 0\n \n\n\n\n \n \n L =    \n1\nz – 2\n1\ny –1\n1\nx\nSo any point on L can be taken as \nA(, 1 + , 2 + )\nP(1, –9, 2)\n\nAP ·< 1, 1, 1> = 0\n – 1 +  + 10 +  = 0\n3 + 9 = 0\n= –3\n A(–3, –2, –1) P(1, –9, 2)\nAP = 74",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q17_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Mathematics Q17]\\nFor the system of equations \nx + y + z = 6\nx + 2y + z = 10\nx + 3y + 5z = , which one of the following is NOT true?",
                options = listOf("System has no solution for  = 3,  = 24", "System has a unique solution for  = –3,  = 14", "System has infinitely many solutions for  = 3,  = 14", "System has unique solution for  = 3,  14"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nD = \n1 3 5\n1 2\n1 1 1\n\n= 1(10 – 3) – (5 – ) + (3 – 2) \n= 6 – 2\nD  0    3\nUnique solution    3",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q18_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Mathematics Q18]\\nThe sum of the all values of , for which the points whose position vectors are k\nˆ\nj 3\nˆ\ni – 2\nˆ  , k\nˆ\nj 4\nˆ\ni – 3\nˆ 2  , \nk\nˆ\ni 2\nˆ\n( 1)  and k\nˆ\nj 6\nˆ\ni ( – 8)\nˆ 9    are coplanar, is equal to",
                options = listOf("–2", "2", "6", "4"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nLet the point be A, B, C, D\n\nAB= k\nˆ\nj\nˆ\ni –\nˆ \n\nAC= k\nˆ\nj –\nˆ\ni 2\nˆ  \n\nAD = k\nˆ\nj 3\nˆ\ni ( – 6)\nˆ 8   \nSo, vectors \n\nAB, \n\nAC, \n\nAD are coplanar.\n\n8 ( – 6) 3\n2 – 1\n1 – 1 1\n\n = 0\n(6 + – 6) + (3 + 8) + (\n2\n– 6 – 16) = 0\n\n2\n– 2 – 14 = 0\nSum of values of  = 2",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q19_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Mathematics Q19]\\nA plane P contains the line of intersection of the plane k)\nˆ\nj\nˆ\ni\nˆ\nr.(  \n\n= 6 and k) –5.\nˆ\nj 4\nˆ\ni 3\nˆ\nr.(2   \n\n If P passes \nthrough the point (0, 2, – 2), then the square of distance of the point (12, 12, 18) from the plane P is",
                options = listOf("620", "155", "310", "1240"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nP1 : x + y + z – 6 = 0\nP2 : 2x + 3y + 4z + 5 = 0 \nP : (x + y + z – 6) + l (2x + 3y + 4z + 5) = 0\nPlane P passes through (0, 2, –2)\n–6 + (3) = 0\n = 2\nP : 5x + 7y + 9z + 4 = 0\nSquare of distance = \n2\n25 49 81\n5(12) 7(12) 9(18) 4\n\n\n\n\n\n\n\n\n \n  \n= \n155\n310310 = 620",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q20_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Mathematics Q20]\\nLet a  b be two non-zero real numbers. Then the number of elements in the set X = {Z  C : Re(az2\n + bz) = a\nand Re(bz2\n + az) = b}",
                options = listOf("0", "1", "3", "2"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1*\\nSolution:\\nLet z = x + iy\n Re(az2\n + bz) = a\n Re(a(x + iy)2\n + b(x + iy)) = a\n a(x2\n− y\n2\n) + bx = a …(i)\n Re(bz2\n + az) = b\n b(x2\n− y\n2\n) + ax = b …(ii)\nfrom (i) and (ii), (i) – (ii)\n(x2\n− y\n2\n)(a − b) − x(a − b) = a − b\n x\n2\n− y\n2 − x = 1 …(iii)\nfrom (i) and (ii), (i) + (ii)\n((x\n2\n− y\n2\n) + x − 1) (a + b) = 0\n(here a + b  0 is considered but it is not clear from the question)\nx\n2\n− y\n2\n + x − 1= 0 …(iv)\nfrom (iii) and (iv)\nx = 0, y2\n = –1 (No solution)",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q21_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Mathematics Q21]\\nThe value of tan9° – tan27° – tan63° + tan81° is _________.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 4\\nSolution:\\ntan9º − tan27º − tan63º + tan81º\n= (cot 81º + tan81º) − (tan27º + cot 27º)\n= (tan9º + cot 9º) − (tan27º + cot 27º)\n= \nsin18º\n2\n–\nsin 54º\n2\n= \n\n\n\n\n\n\n\n\n \n5 1\n2 4\n–\n5 –1\n2 4\n = 4",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q22_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Mathematics Q22]\\nThe number of 4-letter words, with or without meaning, each consisting of 2 vowels and 2 consonants, which \ncan be formed from the letters of the word UNIVERSE without repetition is ___________.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 432\\nSolution:\\nUNIVERSE\nE, E, I, U, (Vowels) + N, R, S, V (Consonants)\nTwo different vowels + 2 consonants = \n3C2.\n4C2. 4 = 432",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q23_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Mathematics Q23]\\nFor , , z  C and  > 1, if  – 1 is the radius of the circle |z – |\n2\n + |z – |\n2\n = 2, then | – | is equal \nto _________.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 2\\nSolution:\\n|z – |\n2\n + |z – |\n2\n = 2\n(z – )( z –  ) = (z – ) ( z –  ) = 2\nzz – z\n\n  \n \n\n\n\n\n   \n\n\n\n\n\n\n\n   \n2\n– z\n2\n= \nRadius = \n\n\n\n\n\n\n\n\n     \n–\n2\n–\n2\n2\n =  – 1\n | + |\n2\n– 2(  + ) = – 4\n| – |\n2 = 4  | – | = 2",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q24_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Mathematics Q24]\\nLet the eccentricity of an ellipse 2\n2\n2\n2\nb\ny\na\nx\n = 1 is reciprocal to that of the hyperbola 2x2\n– 2y2\n = 1. If the \nellipse intersects the hyperbola at right angles, then square of length of the latus-rectum of the ellipse \nis _______.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 02.00\\nSolution:\\neH = 2 , ee =\n2\n1\nFocus of hyperbola = (±1, 0)\nBoth curves are confocal\naee = 1  a = 2\na\n2b\n2\n = 2a(1 –\n2\ne\ne ) = 2 2 .\n2\n1\n = 2",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q25_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Mathematics Q25]\\nLet a curve y = f(x), x  (0, ) pass through the points P \n\n\n\n\n\n2\n3\n1, and Q \n\n\n\n\n\n2\n1\na, . If the tangent at any point \nR(b, f(b)) to the given curve cuts the y-axis at the point S(0, c) such that bc = 3, then (PQ)2\n is equal to _____.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 05.00\\nSolution:\\nY – y = m(X – x), m = \ndx\ndy\nPut X = 0\n Y = y – mx\n x(y – mx) = 3\nor y –\ndx\nxdy\n= \nx\n3\nor 2 X\nydx – Xdy\n = 2\nx\n1\n.\nx\n3dx\nor \n\n\n\n\n\nx\n– y\nd = \n\n\n\n\n\n\n\n– 2\nx\n3d\n–2\n C\n2x\n3\nx\ny\n2\n \nC = 0\n2\n2\n3\n2\n1\n\n\n\nOR  = 3\n\n\n\n\n\n\n2\n3\nP 1, Q \n\n\n\n\n\n2\n1\n3,\n(PQ)2\n = 4 + 1 = 5",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q26_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Mathematics Q26]\\nIf the mean and variance of the frequency distribution \nf 4 4 15 8 4 5\nx 2 4 6 8 10 12 14 16\ni\ni\n \nare 9 and 15.08 respectively, then the value of \n2\n + \n2\n–  is ________.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 25.00\\nSolution:\\nMean = \n   \n        \n40\n8 16 120 80 56 80 6 12\n 360 + 9 + 9 = 360 + 6 + 12\nOR\n 3 – 3 = 0\n15.08 + 81 = \n \n        \n40 2\n16 64 36 960 800 144 784 1280\n(40 + 2)(96.08) = 3904 + 180\n3843.20 + (192.16) = 3904 + 180\n(12.16) = 60.80\n = 5 = ",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q27_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Mathematics Q27]\\nLet f(x) = \n n\n1\nn\n1 x\nx\n\n, x  R – {–1}, n  N, n > 2. if f n\n(x) = (fofof ....... upto n times) (x), then \nlim x (f (x))dx\n1\n0\nn–2 n\nn  \n is equal to",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 00.00\\nSolution:\\nf\nn\n(x) = \nn\n1\nn\n(1 n x )\nx\n\nI = dx\n(1 nx )\nx\n1\n0 n\n1\nn\nn–1\n\n\n1 + nxn\n = tn\nn\n2\nx\nn–1\ndx = ntn–1\ndt\nI = \n n\n1\n(1 n)\n1\nn –1\nt\nt dt\nn\n1\n = \nn\n1\n(1 n)\n1\nn –1\nn –1\nt\nn\n1\n\n = \n\n\n\n\n\n\n\n(1 n) –1\nn(n –1)\n1 n\n1\n1–\nn(n –1)\n(1 n) –1\nlim\nn\n1\n1–\nn\n\n\n = \nn(n –1)\n(1 n)\nlim\nn\n1\n1–\nn\n\n\n= 0",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q28_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Mathematics Q28]\\nThe number of points, where the curve y = x5\n– 20x3\n + 50x + 2 crosses the x-axis, is ________.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 5\\nSolution:\\nf(x) = x5\n– 20x3\n + 50x + 2\nf(x) is continuous for all x  R\nAlso, f(–5) = –873\nf(–2) = 30\nf(–1) = –29\nf(0) = 2\nf(2) = –26\nf(5) = 877\nHence by intermediate value theorem\nf(x) = 0 for some x  (–5, –2)\nAlso, for some x  (–2, –1)\nAlso, for some x  (–1, 0)\nAlso, for some x  (0, 2)\nAlso, for some x  (2, 5)\nAs f(x) is 5th degree polynomial answer is 5.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q29_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Mathematics Q29]\\nIf (20)19 + 2(21) (20)18 + 3(21)2\n (20)17 + … +20(21)19 = k(20)19, then k is equal to ________.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 400\\nSolution:\\nS = 2019 + 2.(20)19\n. \n\n\n\n\n\n20\n21 + 3(20)19\n2\n20\n21\n\n\n\n\n\n+ ..... + 20(20)19\n. \n19\n20\n21 \n\n\n\n\n\n = 2019\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n  \n\n\n\n\n\n \n2 19\n20\n21\n..... 20\n20\n21 3\n20\n21 1 2.\n= k.2019\n k = 1 + 2. \n\n\n\n\n\n20\n21 + 3\n2\n20\n21\n\n\n\n\n\n +.....+ 20\n19\n20\n21 \n\n\n\n\n\n k\n20\n21\n = 2\n20\n21\n\n2\n20\n21 \n\n\n\n\n\n + .... 19 + \n19\n20\n21 \n\n\n\n\n\n+ 20\n20\n20\n21 \n\n\n\n\n\n k –\n20\n21 k = 1 + \n20\n21\n+\n2\n20\n21 \n\n\n\n\n\n+.....+ \n19\n20\n21 \n\n\n\n\n\n–\n20\n20\n21 20 \n\n\n\n\n\n\n20\n20\n20\n21\n– 20\n–1\n20\n21\n–1\n20\n21\n20\n– k\n\n\n\n\n\n\n\n\n\n\n\n\n\n= \n\n\n\n\n\n\n\n\n\n\n\n\n\n–1\n20\n21 20\n× 20 – 20\n20\n20\n21 \n\n\n\n\n\n\n20\n–k\n= –20\n k = 400",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q30_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Mathematics Q30]\\nIf the lines \n\n \nz – 3\n– 3\n2 – y\n2\nx –1\n and \n\n \nz\n2\ny –1\n5\nx – 4\n intersect, then the magnitude of the minimum value \nof 8 is _________ .",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 18\\nSolution:\\nL1 = \n\n \nz – 3\n3\ny – 2\n2\nx –1\n= \nL2 : \n\n \nz – 0\n2\ny –1\n5\nx – 4\n= µ\nFor point of intersection \n2 + 1 = 5µ + 4 … (i)\n3 + 2 = 2µ + 1 … (ii)\n + 3 = µ + 0 … (iii)\nFrom (i) and (ii),  = µ = –1\nNow, from (ii)  – = 3 \nLet E = 8= 8( – 3)\nMinimum value of E = –18 at = +\n2\n3",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q31_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Physics Q31]\\nThe work functions of Aluminium and Gold are 4.1 eV and 5.1 eV respectively. The ratio of the slope of the \nstopping potential versus frequency plot for Gold to that of Aluminium is",
                options = listOf("1.24", "2", "1", "1.5"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nAl = 4.1 eV\nAu = 5.1 eV\nSlope of V vs  graph = \ne\nh",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q32_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Physics Q32]\\nThe weight of a body on the surface of the earth is 100 N. The gravitational force on it when taken at a\nheight, from the surface of earth, equal to one-fourth the radius of the earth is:",
                options = listOf("64 N", "25 N", "50 N", "100 N"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nW = 100 × 2\n2\n4\nR\nR\nR\n\n\n\n\n\n\n\n= 64 N",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q33_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Physics Q33]\\nA 2 meter long scale with least count of 0.2 cm is used to measure the locations of objects on an optical \nbench. While measuring the focal length of a convex lens, the object pin and the convex lens are placed at \n80 cm mark and 1 m mark, respectively. The image of the object pin on the other side of lens coincides with \nimage pin that is kept at 180 cm mark. The % error in the estimation of focal length is:",
                options = listOf("0.85", "1.70", "1.02", "0.51"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nu = 1 m – 80 cm = 20 cm\nv = 1.8 m – 1 m = 80 cm\n80\n5\n20\n1\n80\n1\nu\n1\n–\nv\n1\nf\n1\n   \nf = 16 cm\n400\n0.2 2\n6400\n0.2 2\nf\ndf\n2\n\n\n\n\ndf = \n6400 400\n16 16 0.2 6800 2\n\n   \n = 0.136 × 2 \nf\ndf = 0.0085 × 2 = 1.70",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q34_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Physics Q34]\\nA capacitor of capacitance 150.0 µF is connected to an alternating source of emf given by E = 36 sin(120t) V.\nThe maximum value of current in the circuit is approximately equal to:",
                options = listOf("2A", "2A", "2 2A", "2\n1\nA"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nImax = \n1\n36 60 150 10 2\n–6\n    \n= 2.036 A  2A",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q35_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Physics Q35]\\nThe energy density associated with electric field E\n\n and magnetic field B\n\nof an electronmagnetic wave in\nfree space is given by (0 – permittivity of free space, µ0 – permeability of free space)",
                options = listOf("UE = \n0\n2\n2\nE\n\n, UB =\n0\n2\n2µ\nB", "UE = \n2\nE\n2\n0\n\n, UB = \n0\n2\n2µ\nB", "UE = \n2\nE\n2\n0\n\n, UB = \n2\nµ B\n2\n0", "UE = \n0\n2\n2\nE\n\n, UB = \n2\nµ B\n2\n0"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nCorrect option is \nUE = option is \nUE = \n2\n0E\n2\n1\n UB = \n0\n2\nµ\nB\n2\n1",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q36_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Physics Q36]\\nThe ratio of speed of sound in hydrogen gas to the speed of sound in oxygen gas at the same temperature is :",
                options = listOf("1 : 2", "4 : 1", "1 : 4", "1 : 1"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n16\nM\nM\nv\nv\n2\n2\n2\n2\nH\nO\nO\nH\n \n= 4 : 1",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q37_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Physics Q37]\\nFor an amplitude modulated wave the minimum amplitude is 3 V, while the modulation index is 60%. The \nmaximum amplitude of the modulated wave is :",
                options = listOf("5 V", "15 V", "12 V", "10 V"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nµ = 0.6 =\nmax min\nmax min\nA A\nA – A\n\n 0.6 =\nx 3\nx – 3\n\nx = 12 V",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q38_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Physics Q38]\\nA student is provided with a variable voltage source V, a test resistor RT = 10, two identical galvanometers\nG1 and G2 and two additional resistors, R1 = 10M and R2 = 0.001 . For conducting an experiment to \nverify ohm’s law, the most suitable circuit is :",
                options = listOf("R1\nRT\nR2\nV\nG1\nG2", "R2\nRT R1\nV\nG1\nG2", "R2\nRT\nR1\nV\nG1\nG2", "R1\nRT R2\nV\nG1\nG2"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nFor voltage measurement across RT\nVoltmeter should have very high resistance\n R1 should be in series with G1 and Ammeter should be having very less resistance \n R2 should be in parallel with G2",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q39_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Physics Q39]\\nGiven below are two statements: one is labelled as Assertion A and the other is labelled as Reason R\nAssertion A: The phase difference of two light waves change if they travel through different media having \nsame thickness, but different indices of refraction.\nReason R: The wavelengths of waves are different in different media.\nIn the light of the above statements, choose the most appropriate answer from the options given below",
                options = listOf("Both A and R are correct but R is NOT the correct explanation of A", "A is not correct but R is correct", "A is correct but R is not correct", "Both A and R are correct and R is the correct explanation of A"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nBecause of changed wavelength the phase difference changes while the two waves travel the same distance.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q40_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Physics Q40]\\nThe temperature of an ideal gas is increased from 200 K to 800 K. If r.m.s. speed of gas at 200 K is v0. Then, \nr.m.s. speed of the gas at 800 K will be :",
                options = listOf("4\nv0", "v0", "4v0", "2v0"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n2\n200\n800\nv\nv\n0\n \n\nv = 2v0",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q41_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Physics Q41]\\nChoose the incorrect statement from the following :",
                options = listOf("The speed of satellite in a given circular orbit remains constant", "For a planet revolving around the sun in an elliptical orbit, the total energy of the planet remains constant", "The linear speed of a planet revolving around the sun remains constant", "When a body falls towards earth, the displacement of earth towards the body is negligible"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nLinear speed varies as the planet moves in elliptical orbit.\nv = \n\n\n\n\n\na\n1\n–\nr\n2\nGM",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q42_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Physics Q42]\\nA child of mass 5 kg is going round a merry-go-round that makes 1 rotation in 3.14 S. The radius of the \nmerry-go-round is 2 m. The centrifugal force on the child will be",
                options = listOf("80 N", "40 N", "100 N", "50 N"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n = 2rad /s\n3.14\n2\n\n\nr = 2 m\nFr\n = m\n2\nr = 5 × (2)2\n × 2 = 40 N",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q43_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Physics Q43]\\nA dipole comprises of two charged particles of identical magnitude q and opposite in nature. The mass ‘m’ of \nthe positive charged particle is half of the mass of the negative charged particle. The two charges are \nseparated by a distance ‘l’. If the dipole is placed in a uniform electric field ‘ E ’; in such a way that dipole \naxis makes a very small angle with the electric field, ‘ E ’. The angular frequency of the oscillations of the \ndipole when released is given by:",
                options = listOf("3m\n4qE", "m\n8qE", "m\n4qE", "3m\n8qE"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: Bonus\\nSolution:\\n = pE\nI =\n3\n2m\n( )\n(m 2m)\n(m 2m)\n2\n2 \n \n\n\n = \n2\n2m\n3pE\n\n= \n2m\n3qE\n = \n2m\n3qE\n No option is correct.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q44_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Physics Q44]\\nFigure shows a part of an electric circuit. The potentials at points a, b and c are 30 V, 12 V and 2 V \nrespectively. The current through the 20  resistor will be,\na\n10 \n20 \n30 \nc\nb",
                options = listOf("1.0 A", "0.4 A", "0.6 A", "0.2 A"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n0\n30\n2 – x\n20\n12 – x\n10\n30 – x\n  \n30 – x + 6 – 0\n3\nx\n–\n3\n2\n2\nx\n \nx = 20 V\nI = A\n20\n8\n= 0.4 A",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q45_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Physics Q45]\\nA particle starts with an initial velocity of 10.0 ms–1\nalong x-direction and accelerates uniformly at the rate of \n2.0 ms–2\n. The time taken by the particle to reach the velocity of 60.0 ms–1\n is ___________.",
                options = listOf("25 s", "3 s", "6 s", "30 s"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n60 = 10 + 2t\nt = 25 s",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q46_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Physics Q46]\\nGiven below are two statements: one is labelled as Assertion A and the other is labelled as Reason R \nAssertion A: Diffusion current in a p-n junction is greater than the drift current in magnitude if the junction \nis forward biased.\nReason R: Diffusion current in a p-n junction is form the n-side to the p-side if the junction is forward \nbiased.\nIn the light of the above statements, choose the most appropriate answer from the options given below.",
                options = listOf("Both A and R are correct but R is NOT the correct explanation of A", "A is correct but R is not correct", "A is not correct but R is correct", "Both A and R is correct and R is the correct explanation of A"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nIn forward bias movement of electrons is eased due to external electric field.\n A is correct\nR is incorrect as diffusion current in p-n junction is from p side to n-side.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q47_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Physics Q47]\\nGiven below are two statements: one is labelled as Assertion A and the other is labelled as Reason R. \nAssertion A: When you squeeze one end of a tube to get toothpaste out from the other end, Pascal’s\nprinciple is observed.\nReason R: A change in the pressure applied to an enclosed incompressible fluid is transmitted undiminished \nto every portion of the fluid and to the walls of its container.\nIn the light of the above statements, choose the most appropriate answer from the options given below.",
                options = listOf("Both A and R are correct but R is NOT the correct explanation of A", "A is not correct but R is correct", "A is not correct but R is correct", "Both A and R is correct and R is the correct explanation of A"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nPascal's law is applicable for an enclosed liquid.\n A is correct\nR is correct and explains A.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q48_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Physics Q48]\\nA small particle of mass m moves in such a way that its potential energy U =\n2\n1\nm\n2\nr\n2 where is constant \nand r is the distance of the particle from origin. Assuming Bohr’s quantization of momentum and circular \norbit, the radius of n\nth orbit will be proportional to",
                options = listOf("n", "n\n1", "n\n2", "n"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nU = 2 2 m r\n2\n1\n = cr\n2\nF  r\n\nr\nmv2\n= cr and mvr = \n2\nnh\n v  r\n r\n2  n  r  n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q49_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Physics Q49]\\nAs shown in the figure, a particle is moving with constant speed  m/s. Considering its motion from A to B, \nthe magnitude of the average velocity is:\n120º\nV\nA\nB\nV",
                options = listOf("3 m/s", " m/s", "1.5 3 m/s", "2 3 m/s"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nv =  m/s\nx = 2R sin60º = 3 R\nvavg = \nR\n3\n2\n3R v\n\n\n = \n2\n3 3\n = 1.5 3 m/s",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q50_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Physics Q50]\\nA body cools in 7 minutes from 60ºC to 40ºC. The temperature of the surrounding is 10ºC. The temperature \nof the body after the next 7 minutes will be",
                options = listOf("30ºC", "32ºC", "34ºC", "28ºC"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n7\n60 – 40 = C \n\n\n\n\n\n–10\n2\n60 – 40\n7\n40 – x\n = C \n\n\n\n\n \n–10\n2\n40 x\n x = 28\nSection-B: Numerical Value Type Questions: This section contains 10 questions. In Section B, attempt any \nfive questions out of 10. The answer to each question is a NUMERICAL VALUE. For each question, enter the \ncorrect numerical value (in decimal notation, truncated/rounded-off to the second decimal place; e.g. 06.25, \n07.00, –00.33, –00.30, 30.27, –27.30) using the mouse and the on-screen virtual numeric keypad in the place \ndesignated to enter the answer.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q51_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Physics Q51]\\nA body is dropped on ground from a height ‘h1’ and after hitting the ground, it rebounds to a height ‘h2’. If\nthe ratio of velocities of the body just before and after hitting ground is 4, then percentage loss in kinetic \nenergy of the body is\n4\nx\n. The value of x is _____.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 375\\nSolution:\\n4\nv\nv\n2\n1 \n2\n2\n2\n1\nv\nv\n = 16\n\n16\n15\nv\nv – v\n2\n1\n2\n2\n2\n1 \n 100\n16\n15\n4\nx\n \n x = 375",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q52_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Physics Q52]\\nA ring and a solid sphere rotating about an axis passing through their centres have same radii of gyration. \nThe axis of rotation is perpendicular to plane of ring. The ratio of radius of ring to that of sphere is\nx\n2\n. The \nvalue of x is _____.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 5\\nSolution:\\nmk2\n = \n2 mRr = \n2 mRS\n5\n2\n5\n2\nR\nR\ns\nr   x = 5",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q53_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Physics Q53]\\nA simple pendulum with length 100 cm and bob of mass 250 g is executing S.H.M of amplitude 10 cm. The \nmaximum tension in the string is found to be\n40\nx\nN. The value of x is ______.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 99\\nSolution:\\n = \nl\ng\n= 10\nvmax = 10 × 0.1\nMaximum tension = mg + \nr\nmv2\n= \n4\n1\n10\ng\n100 1\n10 10 \n\n\n\n\n\n\n = 98.98 = 99",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q54_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Physics Q54]\\nAs shown in the figure the voltmeter reads 2 V across 5  resistor. The resistance of the voltmeter is _____\n5  V\n3 V\n2 ",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 20\\nSolution:\\nV2 = 3 V – 2 V = 1 V\n\nv\nv\n5 R\n5 R\n\n\n= 2 × 2 = 4\nRv = 20",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q55_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Physics Q55]\\nTwo concentric circular coils with radii 1 cm and 1000 cm and number of turns 10 and 200 respectively are \nplaced coaxially with centers coinciding. The mutual inductance of this arrangement will be ________ × 10–8\n H.\n(Take, \n2\n = 10)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 4\\nSolution:\\nB =\n2 10\n200µ I\n2 10\nnµ I\n0 0\n\n\n\n\n = \n2 10\n200µ I 10 (0.01)\n2 0\n\n\n \nL = 200 µ0  × \n2\n200µ 10–4\n0\n= 4 × 10–8\n H",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q56_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Physics Q56]\\nA proton with a kinetic energy of 2.0 eV moves into a region of uniform magnetic field of magnitude \n–3\n10\n2\n\n\nT. The angle between the direction of magnetic field and velocity of proton is 60º. The pitch of the \nhelical path taken by the proton is ______ cm.\n(Take, mass of proton = 1.6 × 10–27 kg and charge on proton = 1.6 × 10–19C).",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 40\\nSolution:\\nK.E = 2 eV\nB =\n2\n\n× 10–3\n = 60º\nPitch = \nqB\n2m\n× v cos \n= \n–19 –3\n1.6 10 10\n2\n2\n1\n2 2mKE\n  \n   \n= \n–19\n–27 –19 3\n1.6 10\n2 2 1.6 10 2 1.6 10 10\n\n      \n= 2 × 2 × 10–1\n = 0.4 m",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q57_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Physics Q57]\\nExperimentally it is found that 12.8 eV energy of required to separate a hydrogen atom into a proton and an \nelectron. So the orbital radius of the electron in a hydrogen atom is \nx\n9\n× 10–10\nm.\nThe value of the x is : ________.\n(1 eV = 1.6 × 10–19 J, \n0\n4\n1\n\n= 9 × 109\n Nm2\n/C2\nand electronic charge = 1.6 × 10–19 C)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 16\\nSolution:\\n2r\nkq2\n= 12.8 × 1.6 × 10–19\nr = \n12.8 2\n9 10 1.6 10 9 –19\n\n  \nr = –10 10\n16\n9\n m",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q58_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Physics Q58]\\nA beam of light consisting of two wavelengths 7000 Å and 5500 Å is used to obtain interference pattern in \nYoung’s double slit experiment. The distance between the slits is 2.5 mm and the distance between the plane \nof slits and the screen is 150 cm. The least distance from the central fringe, where the bright fringes due to\nboth the wavelengths coincide, is n × 10–5\n m. The value of n is ________.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 462\\nSolution:\\n1 = 7000 Å\n2 = 5500 Å\nd = 2.5 × 10–3\n m\nD = 1.5 m\nn1 = m2\nn7 = 5.5 m\nn14 = 11 m  n = 11 & m = 14\n y = \n–3\n–7\n2.5 10\n11 7 10 1.5\n\n  \n= 46.2 × 10–4\n = 462 × 10–5",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q59_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Physics Q59]\\nAs shown in the figure, two parallel plate capacitors having equal plate area of 200 cm2\nare joined in such a \nway that a  b. The equivalent capacitance of the combination is x0F. The value of x is \nc = 1 mm d = 5 mm\na\nb",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 5\\nSolution:\\nCeq = –3\n–4\n0\n4 10\n200 10\n\n  \n= 50F",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q60_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Physics Q60]\\nA metal block of mass m is suspended from a rigid support through a metal wire of diameter 14 mm. The \ntensile stress developed in the wire under equilibrium state is 7 × 105\n Nm–2\n. The value of mass m is ______kg.\n[Take, g = 9.8 ms–2\n and  = \n7\n22 )",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 11\\nSolution:\\nmg = 7 × 105\n ×\n7\n22 × 72\n × 10–6\nmg =\n10\n49 22\nm = \n98\n49 22 = 11",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q61_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Chemistry Q61]\\nIn the following reactions, B is\nH3O\n+\n‘B’\n(major)\nOH",
                options = listOf("", "O", "", "O"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nH\n\nOH\n\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q62_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Chemistry Q62]\\nFind out the major product from the following reaction.\n(1) MeMgBr/Cul\nO\n(2) nPrl\n(1) \nO\nMe\nMe (2) \nMe\nMe\nMe\n(3) \nHO Me\n(4) \nMe\nMe\nO",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 1\\nSolution:\\n(1) MeMgBr/Cul\nO\nnPrl Me\nO\nMe\nMe\nO\nPr",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q63_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Chemistry Q63]\\nConsider the following reaction that goes from A to B in three steps as shown below :\nStep\nI\nStep\nII\nStep\nIII\nB\nReaction coordinate\nA\nEnergy\nChoose the correct option\nNumber of Intermediates Number of Activated Complexes Rate determining step",
                options = listOf("2 3 I", "2 3 III", "2 3 II", "3 2 II"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nAs the reaction profile, clearly the number of intermediates are 2 and the number of activated \ncomplexes/transition state is 3. Rate determining step is II.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q64_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Chemistry Q64]\\nFrom the figure of column chromatography given below, identify incorrect statements.\na\nb\nc\nA. Compound ‘c’ is more polar than ‘a’ and ‘b’\nB. Compound ‘a’ is least polar\nC. Comound ‘b’ comes out of the column before ‘c’ and after ‘a’\nD. Compound ‘a’ spends more time in the column\nChoose the correct answer from the options given below",
                options = listOf("A, B and D only", "A, B and C only", "B and D only", "B, C and D only"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nAs the chromatogram, degree of polarity\n a > b > c.\n Statements A, B are incorrect as b comes out before 'C' the statement C is also incorrect.\nAs a is most polar, it spends most time. hence, A, B & C are incorrect statements.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q65_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Chemistry Q65]\\nThe group of chemicals used as pesticide is",
                options = listOf("Aldrin, Sodium Chlorate, Sodium arsinite", "DDT, Aldrin", "Sodium chlorate, DDT, PAN", "Dieldrin, Sodium arsinite, Tetrachloroethene"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nDDT, Aldrin and Dialdrin are pesticides.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q66_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Chemistry Q66]\\nThe IUPAC name of K3[Co(C2O4)3] is:",
                options = listOf("Potassium tris(oxalato)cobaltate(III)", "Potassium tris(oxalato)cobalt(III)", "Potassium trioxalatocobalt(III)", "Potassium trioxalatocobaltate(III)"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nIUPAC name is potassium tri(oxalato) cobaltate(III).",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q67_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Chemistry Q67]\\nWhich one of the following elements will remain as liquid inside pure boiling water ?",
                options = listOf("Ga", "Br", "Li", "Cs"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nAs Br2, Li and Cs can react with H2O, Ga remains as liquid inside boiling water.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q68_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Chemistry Q68]\\nDuring the reaction of permanganate with thiosulphate, the change in oxidation of manganese occurs by \nvalue of 3. Identify which of the below medium will favour the reaction.",
                options = listOf("Both aqueous acidic and neutral", "Aqueous neutral", "Both aqueous acidic and faintly alkaline", "Aqueous acidic"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nMnO4\nΘ\n + S2O3\n–2  MnO2 + SO4\n–2\nThis ionic mechanism is favoured in neutral aqueous medium.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q69_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Chemistry Q69]\\nGroup-13 elements react with O2 in amorphous form to form oxides of type M2O3 (M = element). \nWhich among the following is the most basic oxide ?",
                options = listOf("Al2O3", "B2O3", "Tl2O3", "Ga2O3"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nMost basic oxide is Tl2O3\nBasic character  Tl2O3 > Ga2O3 > Al2O3 > B2O3",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q70_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Chemistry Q70]\\nThe volume of 0.02 M aqueous HBr required to neutralize 10.0 mL of 0.01 M aqueous Ba(OH)2 is (Assume \ncomplete neutralization)",
                options = listOf("2.5 mL", "5.0 mL", "10.0 mL", "7.5 mL"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nMeq of Ba(OH)2 = Meq of HBr\n0.1 × 2 = 0.02 × V\nV = \n0.02\n0.2\n= 10 mL",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q71_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Chemistry Q71]\\nThe product, which is not obtained during the electrolysis of brine solution is",
                options = listOf("H2", "HCl", "NaOH", "Cl2"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nAnode : H2O \n2\n1\nO2 + 2H\n + 2eΘ\nCathode : H2O + eΘ \n2\n1\nH2 + OHΘ\nElectrolyte : NaOH\nHence, HCl is not obtained",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q72_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Chemistry Q72]\\nGiven below are two statements: one is labelled as “Assertion A” and the other is labelled as “Reason R”\nAssertion A : In the complex Ni(CO)4 and Fe(CO)5, the metals have zero oxidation state.\nReason R : Low oxidation states are found when a complex has ligands capable of -donor character in \naddition to the -bonding.\nIn the light of the above statements, choose the most appropriate answer from the options given below",
                options = listOf("A is correct but R is not correct", "A is not correct but R is correct", "Both A and R are correct but R is NOT the correct explanation of A", "Both A and R are correct and R is the correct explanation of A"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nAssertion is correct as metals have zero oxidation state in both Ni(CO)4 and Fe(CO)5.\nReason is incorrect as ligands have -donor and -acceptor character or have both -donor and\n-acceptor character for the metal to show low oxidation state.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q73_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Chemistry Q73]\\nIon having highest hydration enthalpy among the given alkaline earth metal ions is:",
                options = listOf("Be2+", "Sr2+", "Ba2+", "Ca2+"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nIon having highest hydration enthalpy among alkaline earth metal ions is Be+2\n.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q74_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Chemistry Q74]\\nElement not present in Nessler's reagent is",
                options = listOf("N", "Hg", "I", "K"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nNessler's Reagent is K2HgI4.\nSo, N is not present",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q75_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Chemistry Q75]\\nIf the radius of the first orbit of hydrogen atom is 0, then de Broglie's wavelength of electron in 3rd orbit is",
                options = listOf("6\na 0", "3\na 0", "6a0", "3a0"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nmvr = \n2\nnh\nmvr = \n2\n3h\nmv\nh\n3\n2 r\n\n\n =\n3\n2 9a  0 = 6a0",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q76_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Chemistry Q76]\\nThe strongest acid from the following is",
                options = listOf("OH\nNO2", "OH\nCH3", "OH\nCl", "OH"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nAcidic strength order is : \nOH\nNO2\n >\n \nOH\nCl\n>\nOH\n \n>\n \nOH\nCH3",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q77_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Chemistry Q77]\\nGiven below are two statements:\nStatement I: Morphine is a narcotic analgesic. It helps in relieving pain without producing sleep.\nStatement II: Morphine and its derivatives are obtained from opium poppy.\nIn the light of the above statements, choose the correct answer from the options given below",
                options = listOf("Both Statement I and Statement II are true", "Statement I is true but Statement II is false", "Both Statement I and Statement II are false", "Statement I is false but Statement II is true"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nMorphine is a narcotic analgesic which produces sleep.\nHence, Statement I is incorrect.\nMorphine narcotics are obtained from opium poppy.\nHence, Statement II is correct.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q78_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Chemistry Q78]\\nFormation of which complex, among the following, is not a confirmatory test of Pb2+ ions",
                options = listOf("Lead sulphate", "Lead nitrate", "Lead chromate", "Lead iodide"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nAs lead nitrate is water soluble, it cannot be a confirmatory test.\nAlso, it is colourless.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q79_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Chemistry Q79]\\nStructures of BeCl2 in solid state, vapour phase and at very high temperature respectively are :",
                options = listOf("Monomeric, Dimeric, Polymeric", "Dimeric, Polymeric, Monomeric", "Polymeric, Monomeric, Dimeric", "Polymeric, Dimeric, Monomeric"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nBeCl2 is dimeric in vapour phase. \nBeCl2 is monomeric at high temperature.\nBeCl2 is polymeric in solid state.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q80_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Chemistry Q80]\\nMatch List-I and List-II.\nList-I\nNatural Amino acid\nList-II\nOne Letter Code\n(A) Arginine (I) D\n(B) Aspartic acid (II) N\n(C) Asparagine (III) A\n(D) Alanine (IV) R\nChoose the correct answer from the options given below :",
                options = listOf("(A)-(IV), B-I, (C)-II, (D)-III", "(A)-I, (B)-III, (C)-IV, (D)-II", "(A)-III, (B)-I, (C)-II, (D)-IV", "(A)-IV, (B)-I, (C)-III, (D)-II"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nNatural Amino acid One Letter Code\n(A) Arginine (IV) R \n(B) Aspartic acid (I) D \n(C) Asparagine (II) N\n(D) Alanine (III) A\nSection-B: Numerical Value Type Questions: This section contains 10 questions. In Section B, attempt any \nfive questions out of 10. The answer to each question is a NUMERICAL VALUE. For each question, enter the \ncorrect numerical value (in decimal notation, truncated/rounded-off to the second decimal place; e.g. 06.25, \n07.00, –00.33, –00.30, 30.27, –27.30) using the mouse and the on-screen virtual numeric keypad in the place \ndesignated to enter the answer..",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q81_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Chemistry Q81]\\nNumber of crystal systems from the following where body centred unit cell can be found, is _______.\nCubic, tetragonal, orthorhombic, hexagonal, rhombohedral, monoclinic, triclinic",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 3\\nSolution:\\nCrystal systems where body centred unit cell can be found\nCubic, orthorhombic and tetragonal\nHence, correct answer is 3",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q82_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Chemistry Q82]\\nThe number of species having a square planar shape from the following is\nXeF4, SF4, SiF4, BF4\n–\n, BrF4\n–\n, [Cu(NH3)4]\n2+\n, [FeCl4]\n2–\n, [PtCl4]\n2–",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 4\\nSolution:\\nXeF4 Square planar\nSF4  See saw\nSiF4  Tetrahedral\nBF4\n–  Tetrahedral\n[Cu(NH3)4]\n2+ Square planar\n[FeCl4]\n2–  Tetrahedral\n[PtCl4]\n2–  Square planar\nBrF4\n–  Square planar\nSo, 4 square planer shape compounds are present.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q83_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Chemistry Q83]\\nThe equilibrium composition for the reaction PCl3 + Cl2 PCl5 at 298 K is given below:\n[PCl3]eq = 0.2 mol L–1\n, [Cl2]eq = 0.1 mol L–1\n,\n[PCl5]eq = 0.40 mol L–1\nIf 0.2 mol of Cl2 is added at the same temperature, the equilibrium concentrations of PCl5 is ______ × 10–2\nmol L–1 Given: Kc for the reaction at 298 K is 20",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 49\\nSolution:\\n0.2\n3 PCl (g) + \n0.1\n2 Cl (g)\n0.4\n5 PCl (g)\nKc =\n0.2 0.1\n0.4\n\n= 20\nIf 0.2 moles of Cl2 is added\n20 = Kc = \n(0.3 – X)(0.2 – X)\n0.4  X\n (0.4 + X) = 20(0.3 – X) (0.2 – X)\n 0.4 + X = 20(0.06 + X2\n– 0.5 X)\n0.4 + X = 1.2 + 20 X2 \n– 10 X\n20 X2\n– 11 X + 0.8 = 0\nX = \n40\n11 121– 64\n = \n40\n11 – 7.55\n~– 0.08625\n (PCl5) = 0.48625 × 10–2\n or 49 × 10–2",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q84_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Chemistry Q84]\\nConsider the following pairs of solution which will be isotonic at the same temperature. The number of pairs \nof solutions is/are ________\nA. 1 M aq. NaCl and 2 M aq. urea\nB. 1 M aq. CaCl2 and 1.5 M aq. KCI\nC. 1.5 M aq. AlCl3 and 2 M aq. Na2SO4\nD. 2.5 M aq. KCI and 1 M aq. Al2(SO4)3",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 4\\nSolution:\\nA. isotonic (product of i × C is same)\nB. isotonic\nC. isotonic\nD. isotonic\nSo, number of isotonic pairs = 4",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q85_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Chemistry Q85]\\nThe number of colloidal systems from the following, which will have 'liquid' as the dispersion medium,\nis ______.\nGem stones, paints, smoke, cheese, milk, hair cream, insecticide sprays, froth, soap lather",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 5\\nSolution:\\nPaints, milk, froth, soap lather and hair cream have liquid as dispersion medium.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q86_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Chemistry Q86]\\nNumber of isomeric aromatic amines with molecular formula C8H11N, which can be synthesized by Gabriel\nPhthalimide synthesis is ________.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 5\\nSolution:\\nC8H11N\nDegree of unsaturation = 4\nNH2\n(ortho + meta + para)\nNH2\nAniline derivatives cannot \nbe prepared by Gabriel \nphthalimide synthesis\nNH2 NH2\nNH2 NH2\nCH2NH2\n(o + m + p)\nNH2 NH2\nSo, number of aromatic amines = 5",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q87_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Chemistry Q87]\\nConsider the following data\nHeat of combustion of H2(g) = –241.8 kJ mol–1\nHeat of combustion of C(s) = –393.5 kJ mol–1\nHeat of combustion of = –1234.7 kJ mol–1\nC2H5OH(l)\nThe heat of formation of C2H5OH(l) is (–) _____ kJ mol–1\n (Nearest integer).",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 278\\nSolution:\\n3O (g)\n2 5\n2\nC H OH(l)\n\n 2CO2(g) + 3H2O(l)\nHC = [2Hfº(CO2) + 3Hºf(H2O)] – [Hfº(C2H5OH)(l)]\n= 1234.7 = [2 × (–393.5) + 3 × (–241.8)] – [Hfº(C2H5OH)(l)]\nHfºC2H5OH = –277.7 kJ/mol ~– –278 kJ/mol",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q88_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Chemistry Q88]\\nThe standard reduction potential at 295 K for the following half cells are given below:\n– NO3 + 4H+\n + 3e–  NO(g) + 2H2O E\n\n = 0.97 V\nV\n2+(aq) + 2e– V E\n\n = –1.19 V\nFe+3(aq) + 3e–  Fe Eº = –0.04 V\nAg+\n(aq) + e–  Ag(s) Eº = 0.80 V\nAu+3(aq) + 3e–  Au(s) E\n\n = 1.40 V\nThe number of metal(s) which will be oxidized by – NO3\n in aqueous solution is _______.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 3\\nSolution:\\nFor feasibility check Eºcell > 0 \nFor electrodes having oxidation potential greater than –0.97V,\nE�cell > 0.\n Ag, Fe & V can be oxidised",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q89_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Chemistry Q89]\\nIn an ice crystal, each water molecule is hydrogen bonded to ________ neighrbouring molecules.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 4\\nSolution:\\nEach water molecules is H-bonded to 4 neighbouring molecules.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh2_q90_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 2 - Chemistry Q90]\\nAmong the following the number of compounds which will give positive iodoform reaction is ________.\n(a) 1-Phenylbutan-2-one\n(b) 2-Methylbutan-2-ol\n(c) 3-Methylbutan-2-ol\n(d) 1-Phenylethanol\n(e) 3,3-dimethylbutan-2-one\n(f) 1-Phenylpropan-2-ol",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 4\\nSolution:\\n(a) \nPh\nO\n(b)\nCH3\nOH\n(c) \nCH3\nOH\n(d)\nPh\nOH\n(e)\nO\n(f)\nO\nPh\n(c), (d), (e) & (f) give iodoform reaction",
                difficulty = "Medium"
            )
        )
    }
}