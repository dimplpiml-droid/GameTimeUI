package timer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.example.uikit.ui.theme.GameTimeTheme

/**
 *
 * Дата создания: 10.11.2026
 * @param modifier модификатор
 * @param seconds время в секундах
 */

@Composable
fun Timer(
    modifier: Modifier = Modifier,
    seconds: Int
    ) {
    Box(
        modifier = modifier
            .width(295.dp)
            .height(100.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Brush.linearGradient(GameTimeTheme.ColorScheme.accent)),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 7.dp, bottom = 15.82.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Timer",
                color = GameTimeTheme.ColorScheme.onAccent,
                style = GameTimeTheme.Typography.caption2Regular,
            )
            Spacer(modifier = Modifier.height(14.dp))
            Text(
                text = "%02d:%02d".format(seconds / 60 , seconds % 60),
                color = GameTimeTheme.ColorScheme.onAccent,
                style = GameTimeTheme.Typography.caption2Bold,
                fontSize = 30.sp
                )
        }
    }
}

@Preview
@Composable
fun TimerPreview() {
    Timer(modifier = Modifier,
        seconds = 0)
}
