package ru.example.gametimeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import bottombar.BottomBar
import bottombar.BottomBarScreen
import card.LandingCard
import ru.example.uikit.R
import ru.example.uikit.ui.theme.GameTimeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GameTimeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = innerPadding,
                        verticalArrangement = Arrangement.spacedBy(64.dp)
                    ) {
                        item {
                            Column(
                                verticalArrangement = Arrangement.spacedBy(24.dp)
                            ) {
                                BottomBar(
                                    selectedScreen = BottomBarScreen.Statistics,
                                    onScreenClick = {}
                                )
                                BottomBar(
                                    selectedScreen = BottomBarScreen.Discover,
                                    onScreenClick = {}
                                )
                                BottomBar(
                                    selectedScreen = BottomBarScreen.Chat,
                                    onScreenClick = {}
                                )
                                BottomBar(
                                    selectedScreen = BottomBarScreen.Profile,
                                    onScreenClick = {}
                                )
                            }
                        }
                        item {
                            LandingCard(
                                modifier = Modifier,
                                title = "Schedule",
                                description = "Easily schedule event/games\nthen find like minded players for battle. You up for it?",
                                image = painterResource(R.drawable.shedule_image),
                                onClick = {},
                            )
                        }
                    }

                }
            }
        }
    }
}


