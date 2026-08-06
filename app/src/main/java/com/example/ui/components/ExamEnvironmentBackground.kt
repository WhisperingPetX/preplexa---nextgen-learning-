package com.example.ui.components

import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
    // Smooth ambient background color shift based on exam (animates only on exam change)
    val bgGradientTop by animateColorAsState(
        targetValue = if (selectedExam == ExamType.NEET_UG) Color(0xFF003820) else Color(0xFF1E1035),
        animationSpec = tween(500),
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
                            bgGradientTop.copy(alpha = 0.10f),
                            bgGradientTop.copy(alpha = 0.02f),
                            Color.Transparent
                        )
                    )
                )
        )

        Crossfade(
            targetState = selectedExam,
            animationSpec = tween(durationMillis = 400, easing = FastOutSlowInEasing),
            label = "exam_env_crossfade"
        ) { exam ->
            Box(modifier = Modifier.fillMaxSize()) {
                if (exam == ExamType.NEET_UG) {
                    // Medical Ambient Glows (Static render for maximum scroll performance)
                    Canvas(modifier = Modifier.fillMaxSize()) {
                        val width = size.width
                        val height = size.height

                        drawCircle(
                            color = Color(0xFF00E676).copy(alpha = 0.06f),
                            radius = width * 0.45f,
                            center = Offset(width * 0.85f, height * 0.18f)
                        )
                        drawCircle(
                            color = Color(0xFF00B0FF).copy(alpha = 0.05f),
                            radius = width * 0.40f,
                            center = Offset(width * 0.15f, height * 0.65f)
                        )
                    }

                    // Watermark Medical Icons
                    Box(modifier = Modifier.fillMaxSize()) {
                        Text(
                            text = "🩺",
                            fontSize = 38.sp,
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(top = 90.dp, end = 20.dp)
                                .graphicsLayer { alpha = 0.20f }
                        )
                        Text(
                            text = "🧬",
                            fontSize = 44.sp,
                            modifier = Modifier
                                .align(Alignment.CenterStart)
                                .padding(start = 12.dp)
                                .graphicsLayer { alpha = 0.18f }
                        )
                        Text(
                            text = "💊",
                            fontSize = 34.sp,
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .padding(end = 16.dp, top = 220.dp)
                                .graphicsLayer { alpha = 0.18f }
                        )
                        Text(
                            text = "🫀",
                            fontSize = 36.sp,
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .padding(start = 24.dp, bottom = 140.dp)
                                .graphicsLayer { alpha = 0.16f }
                        )
                    }
                } else {
                    // JEE Rocket & Physics Glows
                    Canvas(modifier = Modifier.fillMaxSize()) {
                        val width = size.width
                        val height = size.height

                        drawCircle(
                            color = Color(0xFF7C4DFF).copy(alpha = 0.07f),
                            radius = width * 0.45f,
                            center = Offset(width * 0.82f, height * 0.2f)
                        )
                        drawCircle(
                            color = Color(0xFFFF4081).copy(alpha = 0.05f),
                            radius = width * 0.40f,
                            center = Offset(width * 0.18f, height * 0.72f)
                        )
                    }

                    // Watermark Engineering Icons
                    Box(modifier = Modifier.fillMaxSize()) {
                        Text(
                            text = "🚀",
                            fontSize = 42.sp,
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(top = 80.dp, end = 22.dp)
                                .graphicsLayer { alpha = 0.22f }
                        )
                        Text(
                            text = "⚛️",
                            fontSize = 46.sp,
                            modifier = Modifier
                                .align(Alignment.CenterStart)
                                .padding(start = 12.dp)
                                .graphicsLayer { alpha = 0.20f }
                        )
                        Text(
                            text = "📐",
                            fontSize = 34.sp,
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .padding(end = 20.dp, top = 230.dp)
                                .graphicsLayer { alpha = 0.18f }
                        )
                        Text(
                            text = "✨",
                            fontSize = 32.sp,
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .padding(start = 28.dp, bottom = 150.dp)
                                .graphicsLayer { alpha = 0.20f }
                        )
                    }
                }
            }
        }
    }
}
