package select

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.example.uikit.R
import ru.example.uikit.ui.theme.GameTimeTheme

/**
 *
 * Дата создания: 10.11.2026
 *
 * @param modifier модификатор
 * @param label заголовок
 * @param value текущее значение
 * @param onClick действие при нажатии на селект
 */

@Composable
fun Select(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = label,
            style = GameTimeTheme.Typography.caption2Regular,
            color = GameTimeTheme.ColorScheme.accentInActive,
            fontSize = 8.sp,
        )
        Row(
            modifier = Modifier
                .clickable(
                    onClick = onClick,
                    interactionSource = null,
                    indication = null
                ),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = value,
                style = GameTimeTheme.Typography.caption2Regular
            )
            Icon(
                modifier = Modifier.size(width = 4.dp, height = 8.dp),
                imageVector = ImageVector.vectorResource(R.drawable.dropdown),
                contentDescription = null,
                tint = GameTimeTheme.ColorScheme.accentInActive
            )
        }
    }
}

@Preview
@Composable
fun SelectPreview() {
    Select(
        modifier = Modifier,
        label = "FROM",
        value = "MON, NOV 4,2019",
        onClick = {}
    )
}