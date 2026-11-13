package checkbox

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.example.uikit.R
import ru.example.uikit.ui.theme.GameTimeTheme

/**
 *
 * Дата создания: 10.11.2026
 * @param modifier модификатор
 * @param checked включен checkbox или нет
 * @param onClick действие при нажатии
 */

@Composable
fun CheckBox(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onClick: () -> Unit
) {
    Icon(
        modifier = modifier
            .size(14.dp)
            .clickable(
                onClick = onClick,
                interactionSource = null,
                indication = null
            ),
        imageVector = if (checked) {
            ImageVector.vectorResource(R.drawable.checkbox_filled)
        } else {
            ImageVector.vectorResource(R.drawable.chekbox_blank)
        },
        contentDescription = null,
        tint = GameTimeTheme.ColorScheme.accentInActive,
        )
}

@Preview
@Composable
fun CheckBoxPreview() {
    CheckBox(checked = false, onClick = {})
}