package inputs

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicSecureTextField
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.example.uikit.R
import ru.example.uikit.ui.theme.GameTimeTheme

/**
 * Дата создания: 06.11.2026
 *
 * @param modifier модификатор
 * @param state состояние текстового поля
 * @param placeholder текст подсказки
 * @param isPasswordVisibility булево значение для определния видимости пароля
 * @param onTogglePasswordVisibility действие при нажатии на иконку видимости пароля
 */
@Composable
fun PasswordInput(
    modifier: Modifier = Modifier,
    state: TextFieldState,
    placeholder: String? = null,
    isPasswordVisibility: Boolean,
    onTogglePasswordVisibility: () -> Unit,
) {
    BasicSecureTextField(
        state = state,
        textObfuscationMode = if (isPasswordVisibility) {
            TextObfuscationMode.Visible
        } else {
            TextObfuscationMode.Hidden
        },
        cursorBrush = SolidColor(GameTimeTheme.ColorScheme.accentInActive),
        textStyle = GameTimeTheme.Typography.caption2Regular,
        decorator = { innerTextField ->
            Column(
                modifier = modifier.fillMaxWidth()
            ) {
                Row(
                    modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Box(
                        modifier = Modifier.weight(1f)
                    ) {
                        if (state.text.isEmpty() && placeholder != null) {
                            Text(
                                text = placeholder,
                                style = GameTimeTheme.Typography.caption2Regular
                            )
                        }
                        innerTextField()
                    }
                    Icon(
                        painter = painterResource(R.drawable.visibility),
                        contentDescription = null,
                        modifier = Modifier
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = ripple(bounded = false),
                                onClick = onTogglePasswordVisibility
                            )
                            .padding(horizontal = 6.dp)
                            .size(width = 12.dp, height = 8.dp),
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier.fillMaxWidth()
                        .height(1.dp)
                        .background(Brush.horizontalGradient(GameTimeTheme.ColorScheme.accent))
                )
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun PasswordInputPreview(){
    PasswordInput(modifier = Modifier,
        state = rememberTextFieldState(),
        isPasswordVisibility = true,
        onTogglePasswordVisibility = {},
        placeholder = "1234"
    )
}