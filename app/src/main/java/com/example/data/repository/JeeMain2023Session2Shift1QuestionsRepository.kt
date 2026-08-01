package com.example.data.repository
import com.example.model.Question
object JeeMain2023Session2Shift1QuestionsRepository {
    fun getQuestions(testId: String): List<Question> {
        return listOf(
            Question(
                id = "${testId}_s2_sh1_q1_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Mathematics Q1]\\nThe straight lines 1 and 2 pass through the origin and trisect the line segment of the line L : 9x + 5y = 45 \nbetween the axes. If m1 and m2 are the slopes of the lines 1 and 2, then the point of intersection of the line \ny = (m1 + m2)x with L lies on",
                options = listOf("y – 2x = 5", "6x + y = 10", "y – x = 5", "6x – y = 15"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nL : 9x + 5y = 45 \n⇒\n9\ny\n5\nx\n+ = 1 \n∴ C ≡ ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ , 3\n3\n10\n D ≡ ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ , 6\n3\n5\n∴ m1 = \n10\n9\n, m2 = \n5\n6× 3\n = \n5\n18\n∴ y = x\n10\n36\n10\n9 ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ + = x\n2\n9 ...(i) \n So, intersection point with L \n 7y = 45 ⇒ y = 7\n45\n, x = 7\n10\n∴ Option (3) is correct.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q2_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Mathematics Q2]\\nIf the ratio of the fifth term from the beginning to the fifth term from the end in the expansion of n\n4\n4\n3\n1 2 ⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\n+ is 6 , then the third term from the beginning is- :1",
                options = listOf("30", "2 30 3", "60", "2 60 3"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nGiven expansion \nn\n4\n4\n3\n1 2 ⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\n+\n (5th term from beginning) \n T5 = ()\n4\n4\nn 4 4\n4\nn\n3\n1 C 2 . ⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n− ⎛\n (5th term from end) \n T′5 = ()4 4\nn 4\n4 4\nn 2\n3\n1 C\n−\n⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\n Now, 1\n6\nT\nT\n5\n5 = ′ ⇒ 4\nn 8\n4\nn 8\n2 .3\n− −\n = 6\n∴ 2\nn 8\n( 6)\n−\n = ( 6)\n∴ n = 10 \n∴ T3 = \n10C2\n2\n4\n4 8\n3\n1 ( 2) ⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\n = \n3\n45× 4\n = 60 3",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q3_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Mathematics Q3]\\nThe mean and variance of a set of 15 numbers are 12 and 14 respectively. The mean and variance of another \nset of 15 numbers are 14 and σ\n2\n respectively. If the variance of all the 30 numbers in the two sets is 13, then \nσ\n2\n is equal to-",
                options = listOf("10", "11", "9", "12"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nΣxi = 15 ×12 and \n15\nx2 Σ i – 122\n = 14 \n and Σyi = 15 × 14 and \n15\ny2 Σ i – 142\n = σ\n2\n Now, 13 = 2\n2\n13\n30\n(14 144) 15 ( 196) 15 − + × + σ + ×\n∴ σ\n2\n = 10",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q4_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Mathematics Q4]\\nA pair of dice is thrown 5 times. For each throw, a total of 5 is considered a success. If the probability of at \nleast 4 successes is 11 3\nk , then k is equal to-",
                options = listOf("82", "75", "164", "123"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nP(success) = 36\n4\n = \n9\n1\n P(failure) = 9\n8\n∴ Required probability = \n5\n5\n5\n4\n4\n5\n9\n1 C\n9\n8\n9\n1 C ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ ⎟ + ⎠\n⎞ ⎜\n⎝\n⎛\n = 5 5 5 9\n41\n9\n1\n9\n8 5. + = = 11 3\n123\n∴ k = 123",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q5_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Mathematics Q5]\\nLet the position vectors of the points A, B, C and D be kˆ j 2 ˆ i 5 ˆ 5 + + λ , kˆ j 3 ˆ i 2 ˆ + + , kˆ j 4 ˆ i\nˆ − 2 + λ + and \nk\nˆ j 6 ˆ i 5 ˆ − + + . Let the set S = {λ ∈ : the points A, B, C and D are coplanar). The∑\nλ∈\nλ +\nS\n2 ( is equal to- 2)",
                options = listOf("25", "2\n37", "13", "41"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nA(5, 5, 2λ) \n B(1, 2, 3) \n C(–2, λ, 4) \n D(–1, 5, 6) \nAB (–4, –3, 3 –2λ) \nAC(–7, λ – 5, 4 – 2λ) \nAD (–6, 0, 6 – 2λ) \n∴ [ = 0 AB AC AD]\n− − λ\n− λ − − λ\n− − − λ\n6 0 6 2\n7 5 4 2\n4 3 3 2\n = 0 \n⇒ –4(λ – 3)(λ – 2) = 0 \n∴ λ = 3, λ = 2 \n∑\nλ∈\nλ +\nS\n2 ( = 5 2) 2\n + 42 = 41",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q6_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Mathematics Q6]\\nLet I(x) = ∫ +\n+ dx\n(x tan x 1)\nx (x sec x tan x)\n2\n2 2\n. If I(0) = 0, then I ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ π\n4 is equal to-",
                options = listOf("16 4( 4)\n( 4) log\n2 2\ne π +\nπ\n+\nπ +", "16 4( 4)\n( 4) log\n2 2\ne π +\nπ − π +", "32 4( 4)\n( 4) log\n2 2\ne π +\nπ − π +", "32 4( 4)\n( 4) log\n2 2\ne π +\nπ\n+\nπ +"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n∫ ⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\n+\n+ dx\nx tan x 1)\nx sec x tan x\nx 2\n2\n2\n = ∫ +\n+\n+\ndx\nx tan x 1\n2x\n(x tan x 1)\nx2\n I = ∫ +\ndx\nx tan x 1\nx 2 \n = ∫ +\ndx\nx sin x cos x\nx cos x 2 \n Let x sinx + cosx = t \n (x cosx + sinx – sinx) dx = dt \n = ∫ t\ndt 2 = 2 log t + c \n = 2log |x sinx + cosx| + c \n∴ dx\n(x tan x 1)\nx (x sec x tan x)\n2\n2 2\n∫ +\n+\n = \nx tan x 1\nx\n2\n+\n− + 2 log |x sinx + cosx| + c \n I(0) = 0 \n⇒ c = 0 \n⎟\n⎠\n⎞ ⎜\n⎝\n⎛ π\n4\nI = 1\n2 4\n1 2log\n1 1\n4\n4\n2\n⎟ +\n⎠\n⎞ ⎜\n⎝\n⎛ π\n+\n× +\nπ\n⎟\n⎠\n⎞ ⎜\n⎝\n⎛ π\n = \n32 4( 4)\n( 4) log\n2 2\ne π +\nπ − π +",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q7_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Mathematics Q7]\\nLet kˆ j 4 ˆ i 3 ˆ a = 2 + +  , kˆ j 2 ˆ i 2 ˆ b = − −  and kˆ j 3 ˆ i 4 ˆ c = − + +  . If d\n\n is a vector perpendicular to both b\n and c\n , \nand d a.\n  = 18, then 2 | a d |\n \n× is equal to-",
                options = listOf("640", "680", "720", "760"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nb c\n \n× = kˆ j 2 ˆ i\nˆ 2 − +\n∴ d\n\n = ) k\nˆ j 2 ˆ i\nˆ λ(2 − +\n d a.\n  = 18 \n⇒ λ = 2 \n∴ 2 | a d |\n \n× = \n2 2 2 | a | .|d | (a.d)\n    −\n = 720",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q8_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Mathematics Q8]\\nLet 5f(x) + 4f ⎟\n⎠\n⎞ ⎜\n⎝\n⎛\nx\n1\n = \nx\n1 + 3, x > 0. Then ∫\n2\n1\n18 is equal to- f(x)dx",
                options = listOf("5 loge2 + 3", "10 loge2 + 6", "10 loge2 – 6", "5 loge2 – 3"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n5f(x) + 4f ⎟\n⎠\n⎞ ⎜\n⎝\n⎛\nx\n1\n = 3\nx\n1\n+ ...(i) \n Replace x →\nx\n1\n 5f ⎟\n⎠\n⎞ ⎜\n⎝\n⎛\nx\n1 + 4f(x) = x + 3 ...(ii) \n Solving (i) and (ii) we get \n gf(x) = 4x 3\nx\n5 − +\n∫\n2\n1\nf = (x) dx ∫ ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ − +\n2\n1\n4x 3 dx\nx\n5\n9\n1\n = \n2\n1\n2 [5log x 2x 3x] 9\n1 − +\n = [5log x 3] 9\n1 −\n∴ 18 ∫\n2\n1\nf = 10 log (x) dx e2 – 6",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q9_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Mathematics Q9]\\nStatement (P ⇒ Q) ∧ (R ⇒ Q) is logically equivalent to-",
                options = listOf("(P ⇒ R) ∨ (Q ⇒ R)", "(P ∨ R) ⇒ Q", "(P ⇒ R) ∧ (Q ⇒ R)", "(P ∧ R) ⇒ Q"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n(P → Q) ∧ (R → Q) \n⇒ (P′ ∨ Q) ∧ (R′ ∨ Q) \n⇒ Q ∨ (P′ ∧ R′) \n⇒ Q ∨ (P ∧ R)′\n⇒ (P ∧ R′) ∨ Q \n⇒ (P ∧ R) → Q",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q10_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Mathematics Q10]\\nIf the system of equations \n x + y + az = b \n 2x + 5y + 2z = 6 \n x + 2y + 3z = 3 \n has infinitely many solutions, then 2a + 3b is equal to",
                options = listOf("25", "20", "23", "28"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nx + y + az = b …(i) \n 2x + 5y + 2z = 6 …(ii) \n x + 2y + 3z = 3 …(iii) \n 3 (iii) – (ii) \n x + y + 7z = 3 \n x + y + az = b \n∴ a = 7, b = 3 (∵ solutions are infinite) \n∴ 2a + 3b \n = 14 + 9 = 23",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q11_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Mathematics Q11]\\nFrom the top A of a vertical wall AB of height 30 m, the angles of depression of the top P and bottom Q of a \nvertical tower PQ are 15° and 60° respectively, B and Q are on the same horizontal level. If C is a point on \nAB such that CB = PQ, then the area (in m2\n) of the quadrilateral BCPQ is equal to",
                options = listOf("300( 3 −1)", "300( 3 +1)", "600( 3 −1)", "200( 3 −1)"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nx\n30\n = 3 ; \nx\n30 − h\n = 2 − 3\n⇒ 30 – h = 20 3 – 30 \n⇒ x = 10 3\n⇒ h = 60 – 20 3\n∴ area = hx \n = (60 – 20 3 ) 10 3\n = 200 3(3 – 3)\n = 600( 3 −1)\n∴ (3) is correct.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q12_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Mathematics Q12]\\nOne vertex of a rectangular parallelopiped is at the origin O and the lengths of its edges along x, y and z axes \nare 3, 4 and 5 units respectively. Let P be the vertex (3, 4, 5). Then the shortest distance between the diagonal \nOP and an edge parallel to z axis, not passing through O or P is",
                options = listOf("5\n12", "12 5", "5 5\n12", "5\n12"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nLine OP : \n5\nz\n4\ny\n3\nx = =\n Line AB : \n1\nz\n0\ny\n0\nx 3 = = −\nn1 n2\n  × = \n0 0 1\n3 4 5\nk\nˆ j\nˆ i\nˆ\n = iˆ (4) – jˆ (3) + kˆ (0) \n = 4 iˆ – 3 jˆ\n Distance = \n| n n |\n(a a ).(n n )\n1 2\n2 1 1 2  \n   \n×\n− ×\n = \n5\nj)ˆ i 3 ˆ i).(4 ˆ (3 −\n = \n5\n12\n Option (4) is correct.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q13_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Mathematics Q13]\\nIf 2nC3 : n\nC3 = 10 : 1, then the ratio (n2\n + 3n) : (n2\n – 3n + 4) is-",
                options = listOf("35 : 16", "27 : 11", "65 : 37", "2 : 1"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n2nC3 : n\nC3 = 10 : 1 \nn!\n3!(n 3)!\n3!(2n – 3)!\n(2n)! − × = 10 \n⇒ 4(2n – 1) = 10n – 20 \n⇒ n = 8 \n Now \n(n 3n 4)\n(n 3n)\n2\n2\n− +\n+\n = \n64 24 4\n64 24\n− +\n+\n = \n44\n88 = 2",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q14_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Mathematics Q14]\\nIf the equation of the plane passing through the line of intersection of the planes 2x – y + z = 3, \n4x – 3y + 5z + 9 = 0 and parallel to the line 5\nz 2\n4\ny 3\n2\nx 1 − = + = −\n+ is ax + by + cz + 6 = 0, then a + b + c is \nequal to-",
                options = listOf("12", "14", "15", "13"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nP1 = 2x – y + z = 3 \n P2 = 4x – 3y + 5z + 9 = 0 \n P1 = λP2 = 0 \n (2x – y + z – 3) + λ(4x – 3y + 5z + 9) = 0 \n P3 = (2 + 4λ)x – (1 + 3λ)y + (1 + 5λ)z – (3 – 9λ) = 0 \n P3 is parallel to 5\nz 2\n4\ny 3\n2\nx 1 − = + = −\n+\n –2(2 + 4λ) – 4(1 + 3λ) + 5(1 + 5λ) = 0 \n –3 + 5λ = 0 \n⇒ λ = \n5\n3\n P3 : \n5\n12\n5\n20z\n5\n14y\n5\n22x − + + = 0 \n P3 = 11x – 7y + 10z + 6 = 0 \n∴ a = 11 \n b = –7 \n c = 10 \n∴ a + b + c = 11 – 7 + 10 = 14",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q15_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Mathematics Q15]\\nThe sum of the first 20 terms of the series 5 + 11 + 19 + 29 + 41 + … is",
                options = listOf("3520", "3450", "3250", "3420"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nS = 5 + 11 + 19 + 29 + 41 + ....... Tn\nT 5 6 8 .....(T T )\nS 5 11 19 29 ......T T\nn n n 1\nn 1 n\n−\n−\n= + + + −\n= + + + + +\n Tn = n\n2\n + 3n + 1 \n Sn = ΣTn = Σn\n2\n + 3Σn + Σ1 \n = n\n2\n3n(n 1)\n6\nn(n 1)(2n 1) +\n+\n+\n+ +\n n = 20 \n S20 = \n2\n3 20 21\n6\n20 21 41 × ×\n+\n× ×\n + 20 = 3520",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q16_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Mathematics Q16]\\nLet a1,a2,a3,....,an be n positive consecutive terms of an arithmetic progression. If d > 0 is its common \ndifference, then ⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\n+\n+ +\n+\n+\n+ − →∞ 1 2 2 3 n 1 n n a a\n1 ... a a\n1\na a\n1\nn\nd lim is-",
                options = listOf("d\n1", "d", "1", "0"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\n+\n+ +\n+\n+\n+ − →∞ 1 2 2 3 n 1 n n a a\n1 ... a a\n1\na a\n1\nn\nd lim \n⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\n−\n− + + −\n− + −\n−\n−\n−\n→∞ n n 1\nn n 1\n3 2\n3 2\n2 1\n2 1\nn a a\na a ... a a\na a\na a\na a\nn\nd lim \n( a a ) d\n1\nn\nd lim n 1 n\n− − →∞\n⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛ + − −\n→∞ n\na (n 1)d a\nd\n1 lim 1 1\nn\n⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\n+ − − →∞ n\na\nn\nd d\nn\na\nd\n1 lim 1 1\nn\nd\nd\n1\n× = 1",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q17_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Mathematics Q17]\\nLet A = [aij]2 × 2, where aij ≠ 0 for all i, j and A2\n = I. Let a be the sum of all diagonal elements of A and \nb = |A|. Then 3a2\n + 4b2\n is equal to-",
                options = listOf("4", "14", "7", "3T"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nLet A = ⎥\n⎦\n⎤ ⎢\n⎣\n⎡\nr s\np q\n A2\n = ⎥\n⎦\n⎤ ⎢\n⎣\n⎡\n⎥\n⎦\n⎤ ⎢\n⎣\n⎡\nr s\np q\nr s\np q\n = ⎥\n⎦\n⎤ ⎢\n⎣\n⎡\n+ +\n+ +\n2\n2\nrp rs qr s\np qr pq qs\n A2\n = I \n⇒ p\n2\n + qr = 1 q(p + s) = 0 \n r(p + s) = 0 qr + s2\n = 1 \n q ≠ 0 ⇒ p + s = 0 ⇒ a = 0 \n b = |A| = ps – qr = –p2\n – qr = –1 (∵ s = –p) ∴ 3a2\n + 4b2\n = 4",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q18_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Mathematics Q18]\\nThe sum of all the roots of the equation |x2\n – 8x + 15| – 2x + 7 = 0 is-",
                options = listOf("9 – 3", "9 + 3", "11 – 3", "11 + 3"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nCase-I \nx\n2\n – 8x + 15 ≥ 0 ⇒ (x – 3)(x – 5) ≥ 0 \n⇒ x ≤ 3 OR x ≥ 5 \n x\n2\n – 8x + 15 – 2x + 7 = 0 \n x\n2\n – 10x + 22 = 0 ⇒ x = 5 + 3 , 5 – 3\n (rejected) \nα = 5 + 3\nCase-II \nx\n2\n – 8x + 15 < 0 ⇒ 3 < x < 5 \n x\n2\n – 8x + 15 + 2x – 7 = 0 \n x\n2\n – 6x + 8 = 0 ⇒ x = 4, 2 (rejected) \nγ = 4 \nα + γ = 9 + 3",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q19_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Mathematics Q19]\\nIf 2xy\n + 3yx\n = 20, then dx\ndy at (2, 2) is equal to-",
                options = listOf("⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\n+\n+ − 3 log 4\n2 log 8\ne\ne", "⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\n+\n+ − 4 log 8\n3 log 16\ne\ne", "⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\n+\n+ − 2 log 4\n3 log 8\ne\ne", "⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\n+\n+ − 2 log 8\n3 log 4\ne\ne"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n2xy\n + 3yx\n = 20 \n Differentiating both sides w.r.t. x, \n 2xy\n⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛ ⎟ + + ′ ⎠\n⎞ ⎜\n⎝\n⎛ ′ + .y\ny\nx 3y ln y\nx\ny y ln x x = 0 \n Putting x = 2 = y \n 8(ln2 . y′ + 1) + 12(ln y + y′) = 0 \n (8 ln2 + 12)y′ = –(12 ln 2 + 8) \n y′ = ⎟\n⎠\n⎞ ⎜\n⎝\n⎛\n+\n+ − 2ln 2 3\n3ln 2 2\n = ⎟\n⎠\n⎞ ⎜\n⎝\n⎛\n+\n+ − 3 ln 4\n2 ln8",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q20_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Mathematics Q20]\\nLet A = {x ∈ : [x + 3] + [x + 4] ≤ 3}, \n B = \n⎪\n⎭\n⎪\n⎬\n⎫\n⎪\n⎩\n⎪\n⎨\n⎧\n< ⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\n∈ −\n− ∞\n=\n∑ 3x\nx 3\nr 1\nr\nx 3\n10\n3\nx R : 3 , where [f] denotes greatest integer function. Then,",
                options = listOf("B ⊂ C, A ≠ B", "A ∩ B = φ", "A ⊂ B, A ≠ Β", "A = B"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n∵ [x + 3] + [x + 4] ≤ 3 ⇒ [x] ≤ – 2 \n⇒ x < –1 ⇒ A = (–∞, –1) \n∵ 3x\nx 3\nr 1\nr\nx 3\n10\n3 3 −\n− ∞\n=\n< ⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\n∑\n⇒ 3x\nx 3\nx 3\n10\n1 1\n10\n1 3.\n3 −\n−\n<\n⎟\n⎟\n⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎜\n⎜\n⎝\n⎛\n−\n⇒ 3x\nx 3\nx 3\n3\n1 3 −\n−\n⎟ < ⎠\n⎞ ⎜\n⎝\n⎛\n⇒ 3x – x + 3 + 3x < 1 \n⇒ 33(x + 1) < 1 \n⇒ x < –1 ⇒ B = (–∞, –1) \n⇒ A = B\nSection-B: Numerical Value Type Questions: This section contains 10 questions. In Section B, attempt any \nfive questions out of 10. The answer to each question is a NUMERICAL VALUE. For each question, enter the \ncorrect numerical value (in decimal notation, truncated/rounded-off to the second decimal place; \ne.g. 06.25, 07.00, –00.33, –00.30, 30.27, –27.30) using the mouse and the on-screen virtual numeric keypad in \nthe place designated to enter the answer..",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q21_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Mathematics Q21]\\nThe coefficient of x16 in the expansion of \n15\n3\n4\nx\n1\nx ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ − is _________",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 5005\\nSolution:\\nGeneral term (Tr + 1) = 15Cr(x4\n)\n15–r\nr\n3 x\n1 ⎟\n⎠\n⎞ ⎜\n⎝\n⎛\n−\n Tr + 1 = \n15Cr x\n60–7r(–1)r\n For coefficient of x18, put 60 – 7r = 18 \n⇒ r = 6 \n For coefficient of x18, put 60 – 7r = 18 \n⇒ r = 6 \n Coefficient of x18 = (–1)6\n.\n15C6 = 5005",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q22_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Mathematics Q22]\\nLet a ∈ and [t] be the greatest integer ≤ t. Then the number of points, where the function \nf(x) = [a + 13sinx], x ∈ (0, π) is not differentiable, is _________",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 25\\nSolution:\\nf(x) = [a + 13sinx], x ∈ (0, π), a ∈ Z \n f(x) = [13sinx] \n Let g(x) = 13sinx \n f(x) = [13sinx] is not differentiable at intersection \n points of y = K, K ∈ [1, 13], K ∈ Z \n⇒ Points of non-differentiability = 25",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q23_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Mathematics Q23]\\nThe number of ways of giving 20 distinct oranges to 3 children such that each child gets at least one orange \nis _______",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 171*\\nSolution:\\nNumber of ways \n = coefficient of x20 in (x + x2\n + …. + x18)\n3\n = coefficient of x17 in (1 – x)–3\n = \n19C2 = 171 \nNote: Here 3 children are considered identical but children showed be considered distinct and number of \nways should be number of ways \n = 320 − 3\nC1220 + 3\nC2120",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q24_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Mathematics Q24]\\nIf the area of the region S = {(x, y) : 2y – y2 ≤ x\n2 ≤ 2y, x ≥ y} is equal to \nn 1 n 1\nn 2\n−\nπ − +\n+ , then the natural \nnumber n is equal to _________ .",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 5.00\\nSolution:\\n2y – y2 ≤ x\n2 ≤ 2y, x ≥ y \n Area = ∫ ∫ − + − −\n1\n0\n2\n2\n1\n( 2y y)dy ( 2y 2y y )dy\n = \n12\n2 3\n6\n7 25/ 2 7 / 2 − π\n+ −\n = \n12\n14 2 2 3 7 / 2 7 / 2 − + − π\n = \n6 4\n7 π −\n n = 5",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q25_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Mathematics Q25]\\nA circle passing through the point P(α, β) in the first quadrant touches the two coordinate axes at the points \nA and B. The point P is above the line AB. The point Q on the line segment AB is the foot of perpendicular \nfrom P on AB. If PQ is equal to 11 units, then the value of αβ is _______",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 121.00\\nSolution:\\n(x – r)2\n + (y – r)2\n = r\n2\n passes through (α, β) \n AB : x + y = r \n Q(h, k) \n1\nh − α\n = \n1\nk − β = \n2\n−(α + β − r)\n (h, k) = ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ + β − α\n+ β − β − α\nα − 2\nr\n2 2 ,\n2\nr\n2 2\n (PQ)2\n = \n2 2\n2\nr\n2\nr ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ − α − β + ⎟ + ⎠\n⎞ ⎜\n⎝\n⎛ − α − β + = 121 \n⇒ (r – (α + β))2\n = 242 \n or r\n2\n + (α + β)\n2\n – 2r(α + β) = 242 \n or α\n2\n + β2\n + 2αβ + r2\n – 2rα – 2rβ = 242 \n or 2αβ = 242 \n⇒ αβ = 121",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q26_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Mathematics Q26]\\nLet the image of the point P(1, 2, 3) in the plane 2x – y + z = 9 be Q. If the coordinates of the point R are \n(6, 10, 7), then the square of the area of the triangle PQR is ________.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 594.00\\nSolution:\\nR lies on plane \n PR = 2 2 2 5 + 8 + 4 = 105\n cosθ = \n105 6\nk)ˆ j\nˆ i\nˆ k)(2 ˆ j 4 ˆ i 8 ˆ (5 + + − +\n = \n630\n6\n Area (ΔPQR) = 2area (ΔPMR) \n = 2.\n2\n1 (PR)2\nsinθ cosθ\n = 105 . \n2\n1 (PR)2\n sinθcosθ\n = 105 . \n630\n6 . 630\n594\n = 594",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q27_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Mathematics Q27]\\nLet y = y(x) be a solution of the differential equation (xcosx)dy + (xysinx + ycosx – 1)dx = 0, 0 < x < 2\nπ . If \n⎟\n⎠\n⎞ ⎜\n⎝\nπ ⎛ π\n3 y\n3\n = 3 , then ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ π ⎟ + ′ ⎠\n⎞ ⎜\n⎝\n⎛ π ′′ π\n6\n2y 6 y\n6 is equal to ________",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 02.00\\nSolution:\\n∵ (xcosx) dy + (xy sinx + y cosx – 1) dx = 0 \n∴ (xcosx) dx\ndy + y(xsinx + ycosx) = 1 \n⇒\ndx\ndy + ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ +\nx cos x\nx sin x cos x\ny = \nx cos x\n1\n∴ Integrating factor = \ndx x\n1 tan x\ne\n∫ ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ +\n = xsecx \n∴ y.xsecx = ∫ dx\nx cos x\nx sec x\n∴ xysecx = tanx + C \n∵\n3\nsec\n3 y\n3\nπ ⎟\n⎠\n⎞ ⎜\n⎝\nπ ⎛ π\n = C\n3\ntan +\nπ\n∴ C = 3\n∴ xy secx = tanx + 3\n∴ y(x) = \nx\n3\n2sin x ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ π\n+\n∴ xy′′ + 2y′(x) = –2 ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ π\n+\n3\nsin x\n Thus ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ π ′′ π\n6 y\n6 + 2 y′ ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ π\n6\n = –2 \n Hence ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ π ⎟ + ′ ⎠\n⎞ ⎜\n⎝\n⎛ π ′′ π\n6\n2y 6 y\n6\n = 2",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q28_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Mathematics Q28]\\nLet A = {1, 2, 3, 4, ........, 10} and B = {0, 1, 2, 3, 4}. The number of elements in the relation \n R = {(a,b) ∈ A × A : 2(a – b)2\n + 3(a – b) ∈ B} is ________.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 18\\nSolution:\\nA = {1, 2, 3, ..., 10} B = {0, 1, 2, 4} \n (a, b) ∈ A × A such that \n 2(a – b)2 + 3(a – b) – k = 0 \n where k ∈ {0, 1, 2, 3, 4} \n We should have \n 9 – 4 × 2(–k) a perfect square for any possible (a, b) \n i.e, 9 + 8k is perfect square ⇒ k = 0 or k = 2 \n for k = 0, 2(a – b)2\n + 3(a – b) = 0 \n⇒ a – b = 0 ⇒ (a, b) ∈ {(1, 1), (2, 2) ..... (10, 10)}. ⇒ Total 10 elements belonging to R. \n a – b = \n2\n3 − is not possible \n for k = 0 2(a – b) + 3(a – b) – 2 = 0 \n⇒ a – b = –2 or \n2\n1 (not possible) ⇒ (a, b) ∈ {(1, 3), (2, 4), ..... (8, 10)} \n⇒ 8 element belonging to R \n Total = 18",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q29_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Mathematics Q29]\\nLet the tangent to the curve x2\n + 2x – 4y + 9 = 0 at the point P(1, 3) on it meet the y-axis at A. Let the line \npassing through P and parallel to the line x – 3y = 6 meet the parabola y2\n = 4x at B. If B lies on the line \n2x – 3y = 8, then (AB)2\n is equal to ________.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 5\\nSolution:\\nGiven region are : 2y – y2 ≤ x\n2\n x\n2 ≤ 2y \n x ≥ y \n The required area is as shown \n Required area \n = ∫∫ ⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\n+ − ⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\n+ − −\n1\n0\n2\n1\n2 2\n2 dx\n2\nx\nx\n2\nx 1 1 x\n = \n2\n1\n2 3 1\n0\n3\n2 1\n6\nx\n2\nx\n6\nx .sin x\n2\n1 1 x\n2\nx\nx ⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\n+ − ⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛ − − − − −\n = \n6 4\n7 π − = \nn 1\nn 2\n+\n+ – x −1\nπ\n⇒ n = 5",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q30_math",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Mathematics Q30]\\nLet the point (p, p + 1) lie inside the region E = {(x, y):3 x y 9 x ,0 x 3} 2 − ≤ ≤ − ≤ ≤ . If the set of all values \nof p is the interval (a, b), then b2\n + b – a2\n is equal to ________.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 3\\nSolution:\\n(p, p + 1) lies on y – x = 1 \n∴ Solving y – x = 1 and x + y = 3 \n P(1, 2) \n solving y – x = 1 and x2\n + y2\n = 9 \n x\n2\n + (1 + x)2\n = 9 ⇒ 2x2\n + 2x – 8 = 0 \n⇒ x\n2\n + x – 4 = 0 ...(i) \n x = \n2\n−1± 1+ 4.4\n = \n2\n17 −1\n∴ p ∈ ⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛ −\n2\n17 1 1 ,\n∴ a = 1, b2\n + b = 4 [using (i)] \n∴ b2\n + b – a2\n = 4 – 1 = 3",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q31_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Physics Q31]\\nA particle is moving with constant speed in a circular path. When the particle turns by an angle 90°, the ratio \nof instantaneous velocity to its average velocity is π : x 2 . The value of x will be",
                options = listOf("2", "5", "1", "7"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nInstantaneous velocity = ωR \n Time taken = \nω\nπ\n2\n Displacement = R 2\n Average velocity = \nπ\nR 2 × 2ω\n = R 2 2\nω\nπ\n⇒\navg\nins\nv\nv\n = \n2 2 R\nR\nω\nω π\n⇒ x = 2",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q32_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Physics Q32]\\nA source supplies heat to a system at the rate of 1000 W. If the system performs work at a rate of 200 W. The \nrate at which internal energy of the system increases is-",
                options = listOf("600 W", "800 W", "500 W", "1200 W"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\ndt\ndQ = 1000 W \ndt\ndW = 200 W \ndt\ndU = 1000 W – 200 W = 800 W",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q33_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Physics Q33]\\nThe number of air molecules per cm3\n increased from 3 × 1019 to 12 × 1019. The ratio of collision frequency of \nair molecules before and after the increase in number respectively is :",
                options = listOf("0.75", "1.25", "0.50", "0.25"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nf ∝ τ\n1\n⇒ f ∝ n \nafter\nbefore\nf\nf\n = \n12\n3 = 0.25",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q34_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Physics Q34]\\nThe energy levels of an hydrogen atom are shown below. The transition corresponding to emission of \nshortest wavelength is",
                options = listOf("D", "A", "B", "C"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nShortest wavelength will correspond to highest energy difference de-excitation, which in the given figure \nwill correspond to transition from n = 3 to n = 1.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q35_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Physics Q35]\\nThe induced emf can be produced in a coil by \n A. moving the coil with uniform speed inside uniform magnetic field \n B. moving the coil with non uniform speed inside uniform magnetic field \n C. rotating the coil inside the uniform magnetic field \n D. changing the area of the coil inside the uniform magnetic field \n Choose the correct answer from the options given \n below:",
                options = listOf("B and C only", "A and C only", "C and D only", "B and D only"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nIf flux can change with respect to time then emf can be produced in the coil.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q36_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Physics Q36]\\nA mass m is attached to two strings as shown in figure. The spring constants of two springs are K1 and K2. \nFor the frictionless surface, the time period of oscillation of mass m is-",
                options = listOf("K1 K2\nm 2\n+\nπ", "m\nK K\n2\n1 1 − 2\nπ", "K1 K2\nm 2 − π", "m\nK K\n2\n1 1 + 2\nπ"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nTwo springs are effectively in parallel \n⇒ K = K1 + K2 ⇒ T = \nK1 K2\nm 2\n+\nπ",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q37_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Physics Q37]\\nGiven below are two statements: one is labelled as Assertion A and the other is labelled as Reason R. \nAssertion A: When a body is projected at an angle 45°, it’s range is maximum. \nReason R: For maximum range, the value of sin 2θ should be equal to one. \n In the light of the above statements, choose the correct answer from the options given below:",
                options = listOf("A is false but R is true", "A is true but R is false", "Both A and R are correct and R is the correct explanation of A", "Both A and R are correct but R is NOT the correct explanation of A"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nOn a horizontal ground projectile R = \ng\nu sin 2 2 θ\n for Rmax sin(2θ) = 1 ⇒ θ = 45°",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q38_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Physics Q38]\\nA small block of mass 100 g is tied to a spring of spring constant 7.5 N/m and length 20 cm. The other end of \nspring is fixed at a particular point A. If the block moves in a circular path on a smooth horizontal surface \nwith constant angular velocity 5 rad/s about point A, then tension in the spring is-",
                options = listOf("0.75 N", "0.25 N", "0.50 N", "1.5 N"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nkx = T = mω\n2\n(r + x) \n 7.5x = 2.5(0.2 + x) \n x = \n5\n0.5 = 0.1 ⇒ kx = 0.75 N",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q39_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Physics Q39]\\nFor a uniformly charged thin spherical shell, the electric potential (V) radially away from the centre (O) of \nshell can be graphically represented as",
                options = listOf("r\nr = R \nV", "r = R r\nV", "r = R r\nV", "r = R r\nV"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nElectric potential inside shell will remain constant. \n Outside the shell \nr\n1 V ∝\n⇒",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q40_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Physics Q40]\\nTwo resistance are given as R1 = (10 ± 0.5) Ω and R2 = (15 ± 0.5) Ω. The percentage error in the \nmeasurement of equivalent resistance when they are connected in parallel is",
                options = listOf("6.33", "2.33", "5.33", "4.33"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n1 R2\n1\nR\n1\nR\n1 = + ⇒ 2\n2\n2\n2\n1\n1\n2 R\ndR\nR\ndR\nR\ndR = +\n15\n1\n10\n1\nR\n1 = + ⇒\n25\n150 = 6Ω\n⇒ dR = ⎟\n⎠\n⎞ ⎜\n⎝\n⎛\n×\n+\n15 15\n0.5\n100\n0.5 36 = 0.26 \n⇒ R = 6 ± 0.26 \nR\ndR in percentage = 4.33 %",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q41_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Physics Q41]\\nA planet has double the mass of the earth. Its average density is equal to that of the earth. An object weighing \nW on earth will weigh on that planet:",
                options = listOf("W", "21/3 W", "2 W", "22/3 W"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\ng = 2 R\nGM\n3\n2\n3\n1\ng ∝ M ρ\n3\n1\n3\n1\n(2) M\nM\nW\nW ⎟ = ⎠\n⎞ ⎜\n⎝\n⎛ ′ =\n′",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q42_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Physics Q42]\\nA monochromatic light wave with wavelength λ1 and frequency ν1 in air enters another medium. If the angle \nof incidence and angle of refraction at the interface are 45° and 30° respectively, then the wavelength λ2 and \nfrequency ν2 of the refracted wave are:",
                options = listOf("λ2 = 2 λ1, ν2 = ν1", "λ2 = λ1, ν2 = \n2\n1\nν1", "λ2 = λ1, ν2 = 2 ν1", "λ2 = \n2\n1 λ1, ν2 = ν1"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nµ = sin 30º\nsin 45º = 2 \n⇒\nmed\nair\nC\nC\n = 2 = \nmed\nair\nλ\nλ\n⇒ λ1 = 2λ2 and ν1 = ν2",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q43_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Physics Q43]\\nA small ball of mass M and density ρ is dropped in a viscous liquid of density ρ0. After some time, the ball \nfalls with a constant velocity. What is the viscous force on the ball?",
                options = listOf("F = Mg ⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\nρ\nρ + 0 1", "F = Mg ⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\nρ\nρ +\n0\n1", "F = Mg ⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\nρ\nρ − 0 1", "F = Mg(1 ± ρρ0)"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nAt terminal velocity \n B + Fv = Mg \n⇒ Fv = Mg ⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\nρ\nρ − 0 1",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q44_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Physics Q44]\\nBy what percentage will the transmission range of a TV tower be affected when the height of the tower is \nincreased by 21%?",
                options = listOf("15%", "12%", "10%", "14%"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nRangle = e 2 = R(say) hR\n Now h′ = 1.21h \n⇒ R′ = 1.1R \n⇒ Range increases by 10%",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q45_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Physics Q45]\\nName the logic gate equivalent to the diagram attached",
                options = listOf("NAND", "AND", "NOR", "OR"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nTruth table corresponding to given situation \nA B Out \n1 1 0 \n1 0 0 \n0 1 0 \n0 0 1 \n⇒ The truth table corresponds to NOR gate.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q46_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Physics Q46]\\nFor the plane electromagnetic wave given by E = E0 sin (ωt – kx) and B = B0 sin(ωt – kx), the ratio of \naverage electric energy density to average magnetic energy density is",
                options = listOf("1/2", "2", "4", "1"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nAverage electric energy density = Average magnetic energy density",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q47_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Physics Q47]\\nThe resistivity (ρ) of semiconductor varies with temperature. Which of the following curve represents the \ncorrect behaviour?",
                options = listOf("T \nρ", "T \nρ", "T \nρ", "T \nρ"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nIn semiconductors when small amount of energy is supplied then electrons easily move to conduction band \nbecoming free to move within lattice. \n \nT\nρ",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q48_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Physics Q48]\\nA long straight wire of circular cross-section (radius a) is carrying steady current I. The current I is uniformly \ndistributed across this cross-section. The magnetic field is",
                options = listOf("inversely proportional to r in the region r < a and uniform throughout in the region r > a", "directly proportional to r in the region r < a and inversely proportional to r in the region r > a", "zero in the region r < a and inversely proportional to r in the region r > a", "uniform in the region r < a and inversely proportional to distance r from the axis, in the region r > a"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nBin = \n2\nµ Jr 0\n Bout = \n2r\nµ JR2\n0",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q49_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Physics Q49]\\nGiven below are two statements: one is labelled as Assertion A and the other is labelled as Reason R. \nAssertion A: Earth has atmosphere whereas moon doesn’t have any atmosphere. \nReason R : The escape velocity on moon is very small as compared to that on earth. \n In the light of the above statements, choose the correct answer from the options given below:",
                options = listOf("Both A and R are correct but R is NOT the correct explanation of A", "A is false but R is true", "Both A and R are correct and R is the correct explanation of A", "A is true but R is false"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nBecause of lower escape velocity on surface of moon the average velocity of gas molecules remains higher \nthan the escape velocity making moon unable to hold atmosphere.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q50_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Physics Q50]\\nThe kinetic energy of an electron, α-particle and a proton are given as 4 K, 2 K and K respectively. The de Broglie wavelength associated with electron (λe), α-particle (λα) and the proton (λp) are as follows:",
                options = listOf("λα = λp > λe", "λα < λp < λe", "λα = λp < λe", "λα > λp > λe"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nλ = \n2mKE\nh\n⇒ λe > λp > λα\nSection-B: Numerical Value Type Questions: This section contains 10 questions. In Section B, attempt any \nfive questions out of 10. The answer to each question is a NUMERICAL VALUE. For each question, enter the \ncorrect numerical value (in decimal notation, truncated/rounded-off to the second decimal place; \ne.g. 06.25, 07.00, –00.33, –00.30, 30.27, –27.30) using the mouse and the on-screen virtual numeric keypad in \nthe place designated to enter the answer..",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q51_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Physics Q51]\\nThe radius of fifth orbit of Li++ is _______ × 10−12 m. Take: radius of hydrogen atom = 0.51 Å",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 425\\nSolution:\\nRLi = RH × \nZ\nn2\n = \n10 10\n3\n0.51 25 − ×\n×\n = 425 × 10–12\n m",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q52_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Physics Q52]\\nA parallel plate capacitor with plate area A and plate separation d is filled with a dielectric material of \ndielectric constant K = 4. The thickness of the dielectric material is x, where x < d. \n Let C1 and C2 be the capacitance of the system for x = 3\n1 d and x = \n3\n2d , respectively. If C1 = 2µF the value \nof C2 is __________ µF.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 3\\nSolution:\\nC1 = \n4\n3\nd\n3\n2d\n0A\n+\nε\n = \n3d\n4ε0A\n C2 = \n4\n3\n2d\n3\nd\n0A\n+\nε\n = \n2d\n4ε0A\n= \nd\n2ε0A\n = 3 µF",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q53_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Physics Q53]\\nA particle of mass 10 g moves in a straight line with retardation 2x, where x is the displacement in SI units. \nIts loss of kinetic energy for above displacement is J\nx\n10 −n\n⎟\n⎠\n⎞ ⎜\n⎝\n⎛ . The value of n will be _________ .",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 2\\nSolution:\\nvdv = –adx \nm(v v ) 2\n1 2\ni\n2\nf − = m2 ⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\n2\nx2\n = mx\n2\n⇒ |ΔKE| = 0.01 x2 \n= \n2\nx\n10 −\n⎟\n⎠\n⎞ ⎜\n⎝\n⎛",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q54_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Physics Q54]\\nTwo identical circular wires of radius 20 cm and carrying current 2 A are placed in perpendicular planes as \nshown in figure. The net magnetic field at the centre of the circular wires is _______× 10−8\n T. \n (Take π = 3.14)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 628\\nSolution:\\nBnet = \n2 0.2\n2 4 10 2 7\n×\n× π× × −\n = 2π × 10–8 T \n = 6.28 × 10–6 T",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q55_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Physics Q55]\\nA person driving car at a constant speed of 15 m/s is approaching a vertical wall. The person notices a \nchange of 40 Hz in the frequency of his car’s horn upon reflection from the wall. The frequency of horn is \n________ Hz. (Given: Speed of sound : 30 m/s)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 420\\nSolution:\\nfapp = f\n330 15\n330 15 ⎟\n⎠\n⎞ ⎜\n⎝\n⎛\n−\n+\n⇒ 1 f\n315\n345 ⎟\n⎠\n⎞ ⎜\n⎝\n⎛ − = 40 \n⇒ f = \n30\n40×315 = 420",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q56_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Physics Q56]\\nA pole is vertically submerged in swimming pool, such that it gives a length of shadow 2.15 m within water \nwhen sunlight is incident at an angle of 30° with the surface of water. If swimming pool is filled to a height \nof 1.5 m, then the height of the pole above the water surface in centimeters is (nw = 4/3) ________",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 50\\nSolution:\\nsin60º = sinθ × \n3\n4\n sinθ = \n8\n3 3\n⇒ tanθ = \n37\n3 3\n BC = 1.5 × tan θ\n AB = 2.15 – BC = 0.8686 m \n DF = AB tan30º = 0.5015 m ≈ 50 cm",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q57_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Physics Q57]\\nA steel rod has a radius of 20 mm and a length of 2.0 m. A force of 62.8 kN stretches it along its length. \nYoung's modulus of steel is 2.0 × 1011 N/m2\n. The longitudinal strain produced in the wire is _____ × 10–5.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 25\\nSolution:\\nStrain = 2 11\n3\n2 10\n1\n3.14 (0.02)\n62.8 10\n×\n×\n×\n×\n = 7\n4\n8 10\n2 10\n×\n× = 25 × 10–5",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q58_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Physics Q58]\\nAn ideal transformer with purely resistive load operates at 12 kV on the primary side. It supplies electrical \nenergy to a number of nearby houses at 120 V. The average rate of energy consumption in the houses served \nby the transformer is 60 kW. The value of resistive load (Rs) required in the secondary circuit will \nbe_______ mΩ.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 240\\nSolution:\\nP = 60 × 103\n W \nR\nV2\n = 60 × 103\n W \n R = Ω\n×\n×\n3 60 10\n120 120 = 240 mΩ",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q59_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Physics Q59]\\nThe length of a metallic wire is increased by 20% and its area of cross section is reduced by 4%. The \npercentage change in resistance of the metallic wire is _________.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 25\\nSolution:\\nR = \nA\nρ and R′ = \n0.96A\n1.2ρ\n R′ = 1.25 R \n⇒ ΔR = 0.25 R \nR\nΔR = 25%",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q60_phys",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Physics Q60]\\nTwo identical solid spheres each of mass 2 kg and radii 10 cm are fixed at the ends of a light rod. The \nseparation between the centres of the spheres is 40 cm. The moment of inertia of the system about an axis \nperpendicular to the rod passing through its middle point is ______ × 10–3 kg-m2\n.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 176\\nSolution:\\n= 2(2 × (0.2)2\n) + 2 ⎟\n⎠\n⎞ ⎜\n⎝\n⎛\n5\n2 (2 × (0.1)2\n) \n = 0.16 + 0.016 \n = 0.176 \n 176 × 10–3 kgm2",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q61_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Chemistry Q61]\\nWhich of the following options are correct for the reaction? \n 2[Au(CN)2]\n–\n(aq) + Zn(s) → 2Au(s) + [Zn(CN)4]\n2–(aq) \n A. Redox reaction \n B. Displacement reaction \n C. Decomposition reaction \n D. Combination reaction \n Choose the correct answer from the options given below:",
                options = listOf("A only", "A and D only", "A and B only", "C and D only"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n(A) Oxidation state of zinc is changing from 0 to +2. \n (B) Zinc is displacing Au from complex.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q62_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Chemistry Q62]\\nThe setting time of Cement is increased by adding",
                options = listOf("Clay", "Silica", "Gypsum", "Limestone"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nGypsum is added to slow down the process of setting of the cement so that it gets sufficiently hardened. \n Ref.: NCERT Class XI_Page No. 312_(s-Block Elements)",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q63_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Chemistry Q63]\\nA compound is formed by two elements X and Y. The element Y forms cubic close packed arrangement and \nthose of element X occupy one third of the tetrahedral voids. What is the formula of the compound?",
                options = listOf("X2Y3", "X3Y2", "X3Y", "XY3"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n3\nY4X8\n3\nY4X8\n⇒ Y12X8 \n⇒ X2Y3",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q64_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Chemistry Q64]\\nThe standard electrode potential of M+\n/M in aqueous solution does not depend on",
                options = listOf("Hydration of a gaseous metal ion", "Sublimation of a solid metal", "Ionisation of a solid metal atom", "Ionisation of a gaseous metal atom"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nIonisation energy is defined for gaseous atom and not solid atom.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q65_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Chemistry Q65]\\nMatch List I and List II \nLIST I \nVitamin \nLIST II \nDeficiency disease \nA. Vitamin A I. Beri-Beri \nB. Thiamine II. Cheilosis \nC. Ascorbic acid III. Xerophthalmia \nD. Riboflavin IV. Scurvy \n Choose the correct answer from the options given below",
                options = listOf("A-III, B-I, C-IV, D-II", "A-IV, B-I, C-III, D-II", "A-IV, B-II, C-III, D-I", "A-III, B-II, C-IV, D-I"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nVitamin A : Xerophthalmia \n Thiamine : Beri Beri \n Ascorbic acid : Scurvy \n Riboflavin : Cheilosis",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q66_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Chemistry Q66]\\nThe difference between electron gain enthalpies will be maximum between :",
                options = listOf("Ne and F", "Ar and F", "Ne and Cl", "Ar and Cl"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\nΔHeg for chlorine = –349 kJ mole–1\nΔHeg for Neon = +116 kJ mole–1",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q67_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Chemistry Q67]\\nThe possibility of photochemical smog formation is more at",
                options = listOf("Marshy lands", "Industrial areas", "Himalayan villages in winter", "The places with healthy vegetation"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nPhotochemical smog formation will be more at Industrial areas.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q68_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Chemistry Q68]\\nMatch List I with List II \nList I \nOxide \nList II \nType of bond \nA. N2O4 I. 1 N = O bond \nB. NO2 II. 1 N – O –N bond \nC. N2O5 III. 1 N – N bond \nD. N2O IV. 1 N = N / N ≡ N bond \n Choose the correct answer from the options given below :",
                options = listOf("A-III, B-I, C-II, D-IV", "A-II, B-IV, C-III, D-I", "A-III, B-I, C-IV, D-II", "A-II, B-I, C-III, D-IV"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nN2O4 (N–N) Bond \nNO2 (N=O) Bond \n N2O5 (N–O–N Bond) \n N2O N ≡ N → O (N = N / N ≡ N Bond)",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q69_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Chemistry Q69]\\nThe major products A and B from the following reactions are : \nLiAlH4\nN\nH\nO\nB A Br2/AcOH",
                options = listOf("A =\nN\nBr\nH\nO , B =\nN\nH\nOH", "A =\nN\nBr\nH\nO , B = \nNH2\nBr\nBr", "A = \nN\nBr\nH\nO , B =\nN\nH", "A =\nN\nBr\nH\nO , B = \nBr\nBr\nN\nH\nOH"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q70_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Chemistry Q70]\\nStrong reducing and oxidizing agents among the following , respectively, are",
                options = listOf("Ce3+ and Ce4+", "Ce4+ and Tb4+", "Ce4+ and Eu2+", "Eu2+ and Ce4+"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\n4+ 3+ Ce |Ce E = +1.74 V º\n Lanthanoids have +3 oxidation state as stable oxidation state \n +4 oxidation state : Oxidising agents \n +2 oxidation state : Reducing agents \n (Reference : NCERT class XIIth page 235)",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q71_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Chemistry Q71]\\nThe major product formed in the following reaction is \nCONH2 \nCOOCH3\nBr2 / NaOH\nΔ",
                options = listOf("O\nO \nO", "NH \nO", "O\nO", "O\nNH \nO"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q72_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Chemistry Q72]\\nFor the reaction \n− − RCH Br + I ⎯⎯→ ⎯⎯ RCH I+ Br\nmajor\n2\nAcetone\n2\n The correct statement is",
                options = listOf("Br –\n can act as competing nucleophile.", "The reaction can occur in acetic acid also.", "The transition state formed in the above reaction is less polar than the localised anion.", "The solvent used in the reaction solvates the ions formed in rate determining step"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n− − R – CH – Br + I ⎯⎯→ ⎯⎯ R – CH – I + Br 2\nAcetone\n2\n NaBr is not soluble in acetone and hence reaction shifts in forward reaction and reaction is called Finkelstein \nreaction which proceeds through SN2 mechanism For SN2 reactions, transition state formed is less polar than \nthe localised anion.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q73_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Chemistry Q73]\\nPolymer used in orlon is:",
                options = listOf("Polyethene", "Polycarbonate", "Polyamide", "Polyacrylonitrile"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nOrlon is polyacrylonitrile \nn CH2 = CH \nCN\nacrylonitrile\nCH2–CH \n | \n CN \nn\npolyacrylonitirle",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q74_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Chemistry Q74]\\nCompound P HCl, Δ\nFilter\nResidue Q\nFiltrate\nNaOH\nOily Liquid R\n(M.F. C14H13ON)\nM.F. = Molecular formula \n Compound P is neutral, Q gives effervescence with NaHCO3 while R reacts with Hinsberg’s reagent to give \nsolid soluble in NaOH. Compound P is",
                options = listOf("N CH3 \nH \nO", "N\nCH3 \nO", "N\nO \nC \nCH3 \nH\nH", "N\nH3C H \nO"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nR is 1° Amine \n Q is Carboxylic Acid",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q75_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Chemistry Q75]\\nMatch List I with List II \nLIST I \nEnzymatic reaction \nLIST II \nEnzyme \nA. Sucrose → Glucose and Fructose I. Zymase \nB. Glucose → ethyl alcohol and CO2 II. Pepsin \nC. Starch → Maltose III. Invertase \nD. Proteins → Amino acids IV. Diastase \n Choose the correct answer from the options given below.",
                options = listOf("A-I, B-II, C-IV, D-III", "A-III, B-I, C-IV, D-II", "A-III, B-I, C-II, D-IV", "A-I, B-IV, C-III, D-II"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\n(A) Sucrose ⎯Invertase ⎯→ ⎯⎯ Glucose + Fructose \n (B) Glucose ⎯Zymase ⎯→⎯⎯ Ethyl alcohol and CO2\n (C) Starch ⎯Diastase ⎯→ ⎯⎯ Maltose \n (D) Proteins ⎯Pep ⎯→⎯sin Amino Acids",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q76_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Chemistry Q76]\\nFor a concentrated solution of a weak electrolyte (Keq = equilibrium constant) A2B3 of concentration ‘c’, the \ndegree of dissociation ‘α’ is",
                options = listOf("5\n1\n4\neq\n5c\nK\n⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛", "5\n1\n4\neq\n108c\nK\n⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛", "5\n1\n2\neq\n25c\nK\n⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛", "5\n1\n5\neq\n6c\nK\n⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛"),
                correctOptionIndex = 1,
                explanation = "Correct Answer: 2\\nSolution:\\nA2B3 2A3+ + 3B2–\n C – – \n ↓ ↓ ↓ \n C(1–α) 2Cα 3Cα\n Keq = \nC(1 – )\n(2C ) (3C ) 2 3\nα\nα α = 108C4\nα5\n4\neq\n108C\nK\n = α5 ⇒ α = \n5\n1\n4\neq\n108C\nK\n⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q77_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Chemistry Q77]\\nMatch List I with List II \n \nList-I \nElement detected \nList-II \nReagent \nused/Product formed \nA. Nitrogen I. Na2[Fe(CN)5NO] \nB. Sulphur II. AgNO3\nC. Phosphorus III. Fe4[Fe(CN)6]3\nD. Halogen IV. (NH4)2MoO4\n Choose the correct answer from the options given below.",
                options = listOf("A → III; B → I; C → IV; D → II", "A → II; B → IV; C → I; D → III", "A → IV; B → II; C → I; D → III", "A → II; B → I; C → IV; D → III"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\nNitrogen : Fe4[Fe(CN)6]3 (Prussian Blue) \n Sulphur : Na2[Fe(CN)5NO] \n Phosphorous : (NH4)2MoO4\n Halogen : AgNO3",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q78_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Chemistry Q78]\\nGiven below are two statements, one is labelled as Assertion A and the other is labelled as Reason R. \nAssertion A: The spin only magnetic moment value for [Fe(CN)6]\n3– is 1.74 BM, whereas for [Fe(H2O)6]\n3+ is \n5.92 BM. \n Reason B: In both complexes, Fe is present in +3 oxidation state. In the light of the above statements, choose \nthe correct answer from the options given below:",
                options = listOf("A is false but R is true", "A is true but R is false", "Both A and R are true but R is NOT the correct explanation of A", "Both A and R are true and R is the correct explanation of A"),
                correctOptionIndex = 2,
                explanation = "Correct Answer: 3\\nSolution:\\n→ CN– is strong field ligand and hence pairing will take place. \n→ H2O is a weak field ligand and hence pairing will not take place.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q79_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Chemistry Q79]\\nMatch List I with List II \nList-I \nName of reaction \nList-II \nReagent used \nA. Hell-Volhard-Zelinsky reaction I. NaOH + I2\nB. Iodoform reaction II. (i) CrO2Cl2, CS2\n(ii) H2O \nC. Etard reaction III. (i) Br2/red phosphorus \n(ii) H2O \nD. Gatterman-Koch reaction IV. CO, HCl, anhyd. AlCl3\n Choose the correct answer from the options given below.",
                options = listOf("A → III; B → I; C → II; D → IV", "A → I; B → II; C → III; D → IV", "A → III; B → II; C → I; D → IV", "A → III; B → I; C → IV; D → II"),
                correctOptionIndex = 0,
                explanation = "Correct Answer: 1\\nSolution:\\n(A) Hell-Volhard-Zelinsky reaction: \n \n (B) Iodoform reaction: \n \n (C) Etard reaction: \n \n (D) Gatterman-Koch reaction",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q80_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Chemistry Q80]\\nGiven below are two statements, one is labelled as Assertion A and the other is labelled as Reason R. \nAssertion A: Loss of electron from hydrogen atom results in nucleus of ~1.5 × 10–3 pm size. \nReason R: Proton (H+\n) always exists in combined form. \n In the light of the above statements, choose the most appropriate answer from the options given below:",
                options = listOf("Both A and R are correct and R is the correct explanation of A", "A is correct but R is not correct", "A is not correct but R is correct", "Both A and R are correct but R is NOT the correct explanation of A"),
                correctOptionIndex = 3,
                explanation = "Correct Answer: 4\\nSolution:\\nSize of nucleus is of order \n 1.5 × 10–15 m or 1.5 × 10–3\n pm \n H+\n always exists in combined form. There is no relation between two statements and hence option (4) is the \nanswer. \nSection-B: Numerical Value Type Questions: This section contains 10 questions. In Section B, attempt any \nfive questions out of 10. The answer to each question is a NUMERICAL VALUE. For each question, enter the \ncorrect numerical value (in decimal notation, truncated/rounded-off to the second decimal place; \ne.g. 06.25, 07.00, –00.33, –00.30, 30.27, –27.30) using the mouse and the on-screen virtual numeric keypad in \nthe place designated to enter the answer..",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q81_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Chemistry Q81]\\nMass of Urea (NH2CONH2) required to be dissolved in 1000 g of water in order to reduce the vapour \npressure of water by 25% is _______ g. (Nearest integer) \n Given : Molar mass of N, C, O and H are 14, 12, 16 and 1 g mol–1 respectively.",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 1111\\nSolution:\\n100 \n75 \n25 \n75\n25\n = \n⎟\n⎠\n⎞ ⎜\n⎝\n⎛\n18\n1000\nmoles of urea\n18\n1000\n3\n1\n× = moles of urea \n Mass of urea = \n18\n1000\n3\n1\n× × 60 = 1111.11 gm",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q82_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Chemistry Q82]\\nThe value of log K for the reaction A B at 298 K is _______. (Nearest integer) \n Given :ΔH° = –54.07 kJ mol–1\n ΔS° = 10 JK–1mol–1\n (Take 2.303 × 8.314 × 298 = 5705)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 10\\nSolution:\\nΔG° = ΔH° − TΔS°\n1000\n298(10) − 54.07 −\n = –57.05 kJ/mole \nΔG° = –2.303 RT logKeq\n –57.05 × 1000 = –2.303 × 8.314 × 298 logKeq\n –57.05 × 1000 = –5705 logKeq\n 10 = logKeq",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q83_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Chemistry Q83]\\nIn ammonium – phosphomolybdate, the oxidation state of Mo is + _______",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 6\\nSolution:\\nAmmonium phosphomolybdate is \n (NH4)3PO4 · 12 MoO3\n MoO3\n ↓ \n (+6)",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q84_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Chemistry Q84]\\nNumber of bromo derivatives obtained on treating ethane with excess of Br2 in diffused sunlight is \n_________",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 9\\nSolution:\\n6 Bromine atoms : 1 product possible \n 5 Bromine atoms : 1 product possible \n 4 Bromine atoms : 2 products possible \n 3 Bromine atoms : 2 products possible \n 2 Bromine atoms : 2 products possible \n 1 Bromine atom : 1 product possible \n Total 9 products possible",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q85_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Chemistry Q85]\\nFor the adsorption of hydrogen on platinum, the activation energy is 30 kJ mol–1 and for the adsorption of \nhydrogen on nickel, the activation energy is 41.4 kJ mol–1. The logarithm of the ratio of the rates of \nchemisorption on equal areas of the metals at 300 K is ______ (Nearest integer) \n Given : In 10 = 2.3 \n R = 8.3 J K–1 mol–1",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 2\\nSolution:\\n2.3RT\nE\nK\nK log\n1\n2 Δ =⎟\n⎟\n⎠\n⎞\n⎜\n⎜\n⎝\n⎛\n = \n2.3 8.3 300\n11.4 1000\n× ×\n×\n = 1.990 ≈ 2",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q86_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Chemistry Q86]\\nThe number of species from the following which have square pyramidal structure is______ \n PF5, − BrF , IF 4 5, BrF5, XeOF4, 4\n4 ICl−",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 3\\nSolution:\\nIF5 ; BrF5 and XeOF4 have square pyramidal structure.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q87_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Chemistry Q87]\\nIf 5 moles of BaCl2 is mixed with 2 moles of Na3PO4, the maximum number of moles of Ba3(PO4)2 formed \nis______ (Nearest integer)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 1\\nSolution:\\n3BaCl2 + 2Na3PO4 ⎯⎯→ Ba3(PO4)2 + 6NaCl \n \n5 \n3\n2 \n2 \n0 \n(–) \n1 mole \n \n mole of Ba3(PO4)2 formed = 1",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q88_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Chemistry Q88]\\nNumber of ambidentate ligands in a representative metal complex [M(en)(SCN)4] is_____________. \n [en = ethylenediamine]",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 4\\nSolution:\\n4 SCN–\n ligands are ambidentate.",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q89_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Chemistry Q89]\\nThe wavelength of an electron of kinetic energy 4.50 × 10–29 J is _________ × 10–5 m. (Nearest integer) \nGiven: mass of electron is 9 × 10–31 kg, h = 6.6 × 10–34 Js",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 7\\nSolution:\\n2mKE\nh λ =\n = \n31 29\n34\n2 9 10 4.5 10\n6.6 10\n− −\n−\n× × × ×\n×\n = 30\n34\n9 10\n6.6 10\n−\n−\n×\n×\n= \n4 10\n9\n6.6 − ×\n = \n5 10\n9\n66 − ×\n = 7.33 × 10–5",
                difficulty = "Medium"
            ),
            Question(
                id = "${testId}_s2_sh1_q90_chem",
                topicId = testId,
                text = "[JEE Main 2023 Session 2 Shift 1 - Chemistry Q90]\\nConsider the graph of Gibbs free energy G vs extent of reaction. The number of statement/s from the \nfollowing which are true with respect to points (a), (b) and (c) is_______ \n \nb c\na \nExtent of reaction →\nGibbs energy \n→\n A. Reaction is spontaneous at (a) and (b) \n B. Reaction is at equilibrium at point (b) and nonspontaneous at point (c) \n C. Reaction is spontaneous at (a) and nonspontaneous at (c) \n D. Reaction is non-spontaneous at (a) and (b)",
                options = emptyList(),
                correctOptionIndex = -1,
                explanation = "Correct Answer: 2\\nSolution:\\nAt point a : Slope = –ve \n dG = –ve \n⇒ spontaneous \n At point b : Slope = 0 \n dG = 0 \n⇒ equilibrium \n At point c: Slope = +ve \n dG = +ve \n⇒ non-spontaneous",
                difficulty = "Medium"
            )
        )
    }
}