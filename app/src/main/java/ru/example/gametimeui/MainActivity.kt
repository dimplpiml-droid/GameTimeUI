package ru.example.gametimeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.union
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import bottombar.BottomBar
import bottombar.BottomBarScreen
import buttons.PrimaryButton
import buttons.TertiaryButton
import card.LandingCard
import checkbox.CheckBox
import indicator.Pagination
import inputs.Input
import inputs.PasswordInput
import ru.example.uikit.R
import ru.example.uikit.ui.theme.GameTimeTheme
import select.Select
import timer.Timer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GameTimeTheme {
                Scaffold(
                    contentWindowInsets = WindowInsets.systemBars
                        .union(WindowInsets.displayCutout)
                        .add(WindowInsets(24.dp, 24.dp, 24.dp, 24.dp))
                ) { innerPadding ->
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = innerPadding,
                        verticalArrangement = Arrangement.spacedBy(64.dp)
                    ) {
                        item {
                            Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
                                PrimaryButton(
                                    label = "Let’s Combat!",
                                    onClick = {}
                                )
                                TertiaryButton(
                                    label = "Logout",
                                    icon = ImageVector.vectorResource(R.drawable.logout_icon),
                                    onClick = {}
                                )
                            }
                        }

                        item {
                            Row(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
                                CheckBox(
                                    checked = false,
                                    onClick = {}
                                )
                                CheckBox(
                                    checked = true,
                                    onClick = {}
                                )
                            }
                        }
                        item {
                            Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
                                Pagination(
                                    countPage = 3,
                                    currentPage = 0
                                )
                                Pagination(
                                    countPage = 3,
                                    currentPage = 1
                                )
                                Pagination(
                                    countPage = 3,
                                    currentPage = 2
                                )
                            }
                        }

                        item {
                            Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
                                Input(
                                    state = rememberTextFieldState(),
                                    placeholder = "Full Name"
                                )
                                PasswordInput(
                                    state = rememberTextFieldState(),
                                    placeholder = "Password",
                                    isPasswordVisibility = true,
                                    onTogglePasswordVisibility = {}
                                )
                                PasswordInput(
                                    state = rememberTextFieldState(),
                                    placeholder = "Password",
                                    isPasswordVisibility = false,
                                    onTogglePasswordVisibility = {}
                                )
                            }
                        }

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
                        item {
                            Select(
                                label = "FROM",
                                value = "MON, NOV 4,2019",
                                onClick = {}
                            )
                        }
                        item {
                            Timer(seconds = 0)
                        }
                    }

                }
            }
        }
    }
}


