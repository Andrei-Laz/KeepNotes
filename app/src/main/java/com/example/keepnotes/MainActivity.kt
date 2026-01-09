package com.example.keepnotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
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

                Scaffold(
                    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
                    topBar = {
                        LargeTopAppBar(
                            colors = TopAppBarDefaults.topAppBarColors(
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
                                            imageVector = Icons.Filled.Search,
                                            contentDescription = "Localized description"
                                        )
                                    }
                                    IconButton(onClick = { /* Implement later */ }) {
                                        Icon(
                                            imageVector = Icons.Filled.Share,
                                            contentDescription = "Localized description"
                                        )
                                    }
                                }
                            },
                            scrollBehavior = scrollBehavior,
                        )
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

}