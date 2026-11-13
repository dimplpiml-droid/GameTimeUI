package card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import ru.example.uikit.R
import ru.example.uikit.ui.theme.GameTimeTheme

/**
 * I'm always comeback
 * Дата создания: 06.11.2026
 *  @param modifier модификатор
 * @param title заголовок карточки
 * @param description основной текст
 * @param image картинка справа от текста
 * @param onClick действие при нажатии на карточку
 */
@Composable
fun LandingCard(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    image: Painter,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .width(315.dp)
            .height(169.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Brush.linearGradient(GameTimeTheme.ColorScheme.accent))
            .clickable(onClick = onClick)
    ) {
        Image(
            modifier = Modifier
                .fillMaxHeight()
                .align(Alignment.CenterEnd),
            painter = image,
            contentDescription = null
        )
        Column(
            modifier = Modifier
                .padding(top = 30.dp, start = 24.dp, bottom = 23.67.dp)
                .fillMaxHeight()
        ) {
            Text(
                text = title,
                style = GameTimeTheme.Typography.caption2Bold,
                color = GameTimeTheme.ColorScheme.onAccent
            )
            Spacer(modifier = Modifier.height(14.dp))
            Text(
                text = description,
                style = GameTimeTheme.Typography.caption2Regular,
                color = GameTimeTheme.ColorScheme.onAccent,
                modifier = Modifier.widthIn(max = 165.dp),
                fontSize = 10.sp,
                letterSpacing = (-0.003).em
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painter = painterResource(R.drawable.forward_arrow),
                contentDescription = null,
                modifier = Modifier.width(14.dp),
                tint = GameTimeTheme.ColorScheme.onAccent
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LandingCardPreview() {
    LandingCard(
        modifier = Modifier,
        title = "Schedule",
        description = "Easily schedule event/games\nthen find like minded players for battle. You up for it?",
        image = painterResource(R.drawable.shedule_image),
        onClick = {}
    )
}