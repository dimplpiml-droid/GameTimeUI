package buttons

import android.util.EventLogTags
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.example.uikit.R
import ru.example.uikit.ui.theme.GameTimeTheme

/**
 * Третичная кнопка
 *
 * @param modifier модификатор
 * @param label текст на кнопке
 * @param icon иконка
 * @param onClick действие при нажатии
 */
@Composable
fun TertiaryButton(
    modifier: Modifier = Modifier,
    label: String,
    icon: ImageVector? = null,
    onClick: () -> Unit
){
    Row(
        modifier = modifier.clickable(
            onClick = onClick,
            interactionSource = null,
            indication = null
        ),
        horizontalArrangement = Arrangement.spacedBy(18.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if(icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = GameTimeTheme.ColorScheme.accentInActive,
                modifier = Modifier.size(18.dp)
            )
        }
        Text(
            text = label,
            style = GameTimeTheme.Typography.headlineRegular
        )
    }
}


@Composable
@Preview(showBackground = true)
fun TertiaryButtonPreview(){
    TertiaryButton(
        modifier = Modifier,
        label = "Logout",
        onClick = {},
        icon = ImageVector.vectorResource(R.drawable.logout_icon)
    )
}