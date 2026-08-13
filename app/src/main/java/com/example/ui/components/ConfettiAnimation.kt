package com.example.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

private data class Particle(
    val initialX: Float,
    val speedY: Float,
    val speedX: Float,
    val color: Color,
    val size: Float,
    val rotationSpeed: Float
)

@Composable
fun ConfettiOverlay(
    isVisible: Boolean,
    onAnimationEnd: () -> Unit = {}
) {
    if (!isVisible) return

    val progress = remember { Animatable(0f) }
    val particles = remember {
        List(60) {
            Particle(
                initialX = Random.nextFloat(),
                speedY = Random.nextFloat() * 800f + 600f,
                speedX = (Random.nextFloat() - 0.5f) * 300f,
                color = listOf(
                    Color(0xFFFFC107), Color(0xFFE53935), Color(0xFF2E7D32),
                    Color(0xFF0288D1), Color(0xFF7B1FA2), Color(0xFFEC407A)
                ).random(),
                size = Random.nextFloat() * 18f + 10f,
                rotationSpeed = Random.nextFloat() * 360f
            )
        }
    }

    LaunchedEffect(isVisible) {
        progress.snapTo(0f)
        progress.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 2200, easing = LinearEasing)
        )
        onAnimationEnd()
    }

    Canvas(modifier = Modifier.fillMaxSize()) {
        val width = size.width
        val height = size.height
        val t = progress.value

        particles.forEach { p ->
            val currentX = (p.initialX * width) + (p.speedX * t)
            val currentY = p.speedY * t - 100f
            if (currentY in 0f..height) {
                drawRect(
                    color = p.color,
                    topLeft = Offset(currentX, currentY),
                    size = Size(p.size, p.size * 0.7f)
                )
            }
        }
    }
}
