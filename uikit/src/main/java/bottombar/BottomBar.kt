package bottombar

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.example.uikit.ui.theme.GameTimeTheme

/**
 *
 * Дата создания: 12.11.2026
 *@param modifier модификатор
 * @param selectedScreen какая вкладка(BottomBarItem) выбрана?
 * @param onScreenClick действие которое открывает нужную страницу, в зависимости от того, какая вкладка выбрана
 */
@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    selectedScreen: BottomBarScreen? = null,
    onScreenClick: (BottomBarScreen) -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(109.dp)
            .clip(FirstBottomBarShape())
            .background(Brush.linearGradient(GameTimeTheme.ColorScheme.accent)),
        contentAlignment = Alignment.BottomCenter
    ) {
        Box(
            modifier = Modifier
                .height(81.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 20.dp, end = 22.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                BottomBarItem(
                    screen = BottomBarScreen.Statistics,
                    selected = BottomBarScreen.Statistics == selectedScreen,
                    onClick = {
                        onScreenClick(BottomBarScreen.Statistics)
                    }
                )
                Spacer(modifier = Modifier.width(26.dp))
                BottomBarItem(
                    screen = BottomBarScreen.Discover,
                    selected = BottomBarScreen.Discover == selectedScreen,
                    onClick = {
                        onScreenClick(BottomBarScreen.Discover)
                    }
                )
                Spacer(modifier = Modifier.weight(1f))
                BottomBarItem(
                    screen = BottomBarScreen.Chat,
                    selected = BottomBarScreen.Chat == selectedScreen,
                    onClick = {
                        onScreenClick(BottomBarScreen.Chat)
                    }
                )
                Spacer(modifier = Modifier.width(38.dp))
                BottomBarItem(
                    screen = BottomBarScreen.Profile,
                    selected = BottomBarScreen.Profile == selectedScreen,
                    onClick = {
                        onScreenClick(BottomBarScreen.Profile)
                    }
                )
            }
        }
        BottomBarButton(
            modifier = Modifier.offset(y = (-38).dp),
            screen = BottomBarScreen.Schedule,
            onClick = {
                onScreenClick(BottomBarScreen.Schedule)
            }
        )
    }
}

/**
 * Функция для создания вкладок bottom bar-а, в виде иконка + текст
 * @param modifier модификатор
 * @param selected выбран ли текущий элемент
 * @param screen обращение к BottomBarScreen для того, чтобы получить иконку и текст
 * @param onClick действие при нажатии
 */
@Composable
fun BottomBarItem(
    modifier: Modifier = Modifier,
    selected: Boolean,
    screen: BottomBarScreen,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier.clickable(
            onClick = onClick,
            interactionSource = null,
            indication = null
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Icon(
            modifier = Modifier.size(16.dp),
            imageVector = ImageVector.vectorResource(screen.icon),
            contentDescription = null,
            tint = GameTimeTheme.ColorScheme.onAccent
        )
        Text(
            text = screen.label,
            style = if (selected) {
                GameTimeTheme.Typography.caption2Bold
            } else {
                GameTimeTheme.Typography.caption2Regular
            },
            color = GameTimeTheme.ColorScheme.onAccent,
        )
    }
}

/**
 * Функция для создания центрального объекта bottom bar-а. С белым кругом за иконкой
 * @param modifier модификатор
 * @param screen обращение к BottomBarScreen для того, чтобы получить иконку
 * @param onClick действие при нажатии
 */
@Composable
fun BottomBarButton(
    modifier: Modifier = Modifier,
    screen: BottomBarScreen,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .size(56.dp)
            .border(
                border = BorderStroke(5.dp, GameTimeTheme.ColorScheme.onAccent),
                shape = CircleShape
            )
            .clip(CircleShape)
            .clickable(
                onClick = onClick,
                indication = null,
                interactionSource = null
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.size(width = 24.dp, height = 29.dp),
            imageVector = ImageVector.vectorResource(screen.icon),
            contentDescription = null,
            tint = GameTimeTheme.ColorScheme.onAccent
        )
    }
}

@Preview
@Composable
fun BottomBarPreview() {
    BottomBar(onScreenClick = {},
        selectedScreen = BottomBarScreen.Chat)
}