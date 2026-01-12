package com.example.keepnotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.keepnotes.ui.theme.KeepNotesTheme
import com.example.keepnotes.ui.theme.LightOrange
import com.example.keepnotes.ui.theme.Purple40

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KeepNotesTheme {
                val scrollBehavior =
                    TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

                val value by rememberInfiniteTransition().animateFloat(
                    initialValue = 25f,
                    targetValue = -25f,
                    animationSpec = infiniteRepeatable(
                        animation = tween(
                            durationMillis = 600,
                            easing = LinearEasing
                        ),
                        repeatMode = RepeatMode.Reverse
                    )
                )

                Scaffold(
                    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
                    topBar = {
                        LargeTopAppBar(
                            navigationIcon = {
                                IconButton(onClick = {/*implement later*/}) {
                                    Icon(
                                        imageVector = Icons.Filled.Menu,
                                        contentDescription = "App Menu Icon"
                                    )
                                }
                            },
                            colors = TopAppBarDefaults.largeTopAppBarColors(
                                containerColor = LightOrange,
                                titleContentColor = Color.White
                            ),
                            title = {
                                Text(
                                    "Keep Notes",
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            },
                            actions = {
                                Row {
                                    IconButton(onClick = { /* Implement later */ }) {
                                        Icon(
                                            imageVector = Icons.Outlined.Notifications,
                                            contentDescription = "stuff",
                                        modifier = Modifier
                                            .graphicsLayer(
                                                transformOrigin = TransformOrigin(
                                                    pivotFractionX = 0.5f,
                                                    pivotFractionY = 0.0f,
                                                ),
                                                rotationZ = value
                                            )
                                        )
                                    }
                                    IconButton(onClick = { /* Implement later */ }) {
                                        Icon(
                                            imageVector = Icons.Filled.MoreVert,
                                            contentDescription = "Localized description"
                                        )
                                    }
                                }
                            },
                            scrollBehavior = scrollBehavior,
                        )
                    },
                    floatingActionButton = {
//                        val image =
//                            AnimatedImageVector.animatedVectorResource(R.drawable.avd_tick_animations)
                        var atEnd by remember { mutableStateOf(false) }

                        Box(
//                            modifier = Modifier
//                                .drawBehind(DrawScope.)
                        ) {
                            FloatingActionButton(
                                onClick = { atEnd = !atEnd },
                                content = {
                                    IconButton(onClick = { /* Implement later */ }) {
                                        Icon(
                                            imageVector = Icons.Filled.Create,
                                            contentDescription = "FAB button"
                                        )
                                    }
                                },
                                modifier = Modifier
                                    .size(65.dp)
                            )
                        }
                    }
                ) { innerPadding ->
                    KeepNotesApp(innerPadding)
                }
            }
        }
    }
}

@Composable
fun KeepNotesApp(innerPadding: PaddingValues) {
    val comments = remember {
        mutableStateListOf(
            "Excelente café y ambiente.",
            "El capuchino estaba delicioso.",
            "Muy buena atención del personal.",
            "Espacio tranquilo para estudiar.",
            "Un poco caro, pero vale la pena.",
            "Excelente café y ambiente.",
            "El capuchino estaba delicioso.",
            "Muy buena atención del personal.",
            "Espacio tranquilo para estudiar.",
            "Un poco caro, pero vale la pena.",
            "Excelente café y ambiente.",
            "El capuchino estaba delicioso.",
            "Muy buena atención del personal.",
            "Espacio tranquilo para estudiar.",
            "Un poco caro, pero vale la pena.",
            "Excelente café y ambiente.",
            "El capuchino estaba delicioso.",
            "Muy buena atención del personal.",
            "Espacio tranquilo para estudiar.",
            "Un poco caro, pero vale la pena.",
            "Excelente café y ambiente.",
            "El capuchino estaba delicioso.",
            "Muy buena atención del personal.",
            "Espacio tranquilo para estudiar.",
            "Un poco caro, pero vale la pena."
        )
    }

    val gridState = rememberLazyStaggeredGridState()

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(8.dp),
        state = gridState,
        verticalItemSpacing = 8.dp,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(comments) { comment ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Box(
                    modifier = Modifier
                        .padding(12.dp)
                ) {
                    Text(
                        text = comment,
                        style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}

@Composable
fun dibujoCircStr(){
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
    ) {
        drawCircle(
            color = Color.Red,
            radius = 90f,
            style = Stroke(width = 15f, cap = StrokeCap.Round)
        )
    }
}