package buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.example.uikit.ui.theme.GameTimeColorScheme
import ru.example.uikit.ui.theme.GameTimeTheme

/**
 * Первичная кнопка
 * @param modifier модификатор
 * @param label текст на кнопке
 * @param onClick действие при нажатии
 */
@Composable
fun PrimiaryBuuton(
    modifier: Modifier = Modifier,
    label: String,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(58.dp)
            .clip(RoundedCornerShape(100.dp))
            .background(
                Brush.linearGradient(colors = GameTimeTheme.ColorScheme.accent)
            )
            .clickable(
                onClick =onClick
            ),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = label,
            textAlign = TextAlign.Center,
            style = GameTimeTheme.Typography.captionSemibold,
            color = GameTimeTheme.ColorScheme.onAccent,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PrimiaryBuutonPreview() {
    PrimiaryBuuton(
        modifier = Modifier,
        label = "Lets Combat",
        onClick = {}
    )
}