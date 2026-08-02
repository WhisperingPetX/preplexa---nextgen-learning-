package com.example.ui.components

import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.ExamType

@Composable
fun ExamEnvironmentBackground(
    selectedExam: ExamType,
    modifier: Modifier = Modifier
) {
    val infiniteTransition = rememberInfiniteTransition(label = "exam_bg_anim")

    // Vertical floating motion
    val floatOffsetY by infiniteTransition.animateFloat(
        initialValue = -12f,
        targetValue = 16f,
        animationSpec = infiniteRepeatable(
            animation = tween(3200, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "float_offset"
    )

    // Gentle rotation wiggle
    val rotateAngle by infiniteTransition.animateFloat(
        initialValue = -8f,
        targetValue = 8f,
        animationSpec = infiniteRepeatable(
            animation = tween(2800, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "rotate_angle"
    )

    // Pulsing opacity for background ambient circles
    val pulseAlpha by infiniteTransition.animateFloat(
        initialValue = 0.12f,
        targetValue = 0.32f,
        animationSpec = infiniteRepeatable(
            animation = tween(2400, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulse_alpha"
    )

    // Smooth ambient background color shift based on exam
    val bgGradientTop by animateColorAsState(
        targetValue = if (selectedExam == ExamType.NEET_UG) Color(0xFF003820) else Color(0xFF1E1035),
        animationSpec = tween(600),
        label = "bg_top"
    )

    Box(modifier = modifier.fillMaxSize()) {
        // Gradient layer overlay
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            bgGradientTop.copy(alpha = 0.12f),
                            bgGradientTop.copy(alpha = 0.03f),
                            Color.Transparent
                        )
                    )
                )
        )

        Crossfade(
            targetState = selectedExam,
            animationSpec = tween(durationMillis = 500, easing = FastOutSlowInEasing),
            label = "exam_env_crossfade"
        ) { exam ->
            Box(modifier = Modifier.fillMaxSize()) {
                if (exam == ExamType.NEET_UG) {
                    // Medical Canvas Glows
                    Canvas(modifier = Modifier.fillMaxSize()) {
                        val width = size.width
                        val height = size.height

                        drawCircle(
                            color = Color(0xFF00E676).copy(alpha = pulseAlpha * 0.22f),
                            radius = width * 0.4f,
                            center = Offset(width * 0.85f, height * 0.18f + floatOffsetY * 2)
                        )
                        drawCircle(
                            color = Color(0xFF00B0FF).copy(alpha = pulseAlpha * 0.18f),
                            radius = width * 0.35f,
                            center = Offset(width * 0.15f, height * 0.65f - floatOffsetY * 2)
                        )
                    }

                    // Floating Medical Icons (🩺, 🧬, 💊, 🫀, 🏥)
                    Box(modifier = Modifier.fillMaxSize()) {
                        Text(
                            text = "🩺",
                            fontSize = 38.sp,
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(top = 90.dp, end = 20.dp)
                                .graphicsLayer {
                                    translationY = floatOffsetY * 1.5f
                                    rotationZ = rotateAngle * 2
                                    alpha = 0.3f
                                }
                        )
                        Text(
                            text = "🧬",
                            fontSize = 44.sp,
                            modifier = Modifier
                                .align(Alignment.CenterStart)
                                .padding(start = 12.dp)
                                .graphicsLayer {
                                    translationY = -floatOffsetY * 1.8f
                                    rotationZ = -rotateAngle * 3
                                    alpha = 0.25f
                                }
                        )
                        Text(
                            text = "💊",
                            fontSize = 34.sp,
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .padding(end = 16.dp, top = 220.dp)
                                .graphicsLayer {
                                    translationY = floatOffsetY * 2.2f
                                    rotationZ = rotateAngle * 4
                                    alpha = 0.25f
                                }
                        )
                        Text(
                            text = "🫀",
                            fontSize = 36.sp,
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .padding(start = 24.dp, bottom = 140.dp)
                                .graphicsLayer {
                                    translationY = -floatOffsetY * 1.4f
                                    alpha = 0.22f
                                }
                        )
                    }
                } else {
                    // JEE Rocket & Physics Canvas Glows
                    Canvas(modifier = Modifier.fillMaxSize()) {
                        val width = size.width
                        val height = size.height

                        drawCircle(
                            color = Color(0xFF7C4DFF).copy(alpha = pulseAlpha * 0.28f),
                            radius = width * 0.42f,
                            center = Offset(width * 0.82f, height * 0.2f - floatOffsetY * 2)
                        )
                        drawCircle(
                            color = Color(0xFFFF4081).copy(alpha = pulseAlpha * 0.18f),
                            radius = width * 0.38f,
                            center = Offset(width * 0.18f, height * 0.72f + floatOffsetY * 2)
                        )
                    }

                    // Floating Rocket & Physics Icons (🚀, ⚛️, 📐, ✨, 🛰️)
                    Box(modifier = Modifier.fillMaxSize()) {
                        Text(
                            text = "🚀",
                            fontSize = 42.sp,
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(top = 80.dp, end = 22.dp)
                                .graphicsLayer {
                                    translationY = -floatOffsetY * 2.5f
                                    rotationZ = -15f + rotateAngle
                                    alpha = 0.32f
                                }
                        )
                        Text(
                            text = "⚛️",
                            fontSize = 46.sp,
                            modifier = Modifier
                                .align(Alignment.CenterStart)
                                .padding(start = 12.dp)
                                .graphicsLayer {
                                    translationY = floatOffsetY * 1.6f
                                    rotationZ = rotateAngle * 5
                                    alpha = 0.28f
                                }
                        )
                        Text(
                            text = "📐",
                            fontSize = 34.sp,
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .padding(end = 20.dp, top = 230.dp)
                                .graphicsLayer {
                                    translationY = -floatOffsetY * 1.6f
                                    rotationZ = -rotateAngle * 2
                                    alpha = 0.25f
                                }
                        )
                        Text(
                            text = "✨",
                            fontSize = 32.sp,
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .padding(start = 28.dp, bottom = 150.dp)
                                .graphicsLayer {
                                    translationY = floatOffsetY * 2f
                                    alpha = 0.28f
                                }
                        )
                    }
                }
            }
        }
    }
}
