package inputs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.OutputTransformation
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.example.uikit.ui.theme.GameTimeTheme

/**
 * @param modifier модификатор
 * @param state состояние текстового поля
 * @param placeholder текст подсказки
 */
@Composable
fun Input(
    modifier: Modifier = Modifier,
    state: TextFieldState,
    singleLine: Boolean = true,
    placeholder: String? = null,
    inputTransformation: InputTransformation? = null,
    outputTransformation: OutputTransformation? = null,
) {
    BasicTextField(
        state = state,
        lineLimits = if (singleLine) {
            TextFieldLineLimits.SingleLine
        } else {
            TextFieldLineLimits.MultiLine()
        },
        textStyle = GameTimeTheme.Typography.caption2Regular,
        cursorBrush = SolidColor(GameTimeTheme.ColorScheme.accentInActive),
        inputTransformation = inputTransformation,
        outputTransformation = outputTransformation,
        decorator = { innerTextField ->
            Column(
                modifier.fillMaxWidth()
            ) {
                Box(
                    modifier.fillMaxWidth()
                ) {
                    if (state.text.isEmpty() && placeholder != null) {
                        Text(
                            text = placeholder,
                            style = GameTimeTheme.Typography.caption2Regular
                        )
                    }
                    innerTextField()
                }
                Spacer(modifier.height(8.dp))
                Box(
                    modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(
                            Brush.horizontalGradient(
                                GameTimeTheme.ColorScheme.accent
                            )
                        )
                )
            }
        }
    )
}

@Composable
@Preview(showBackground = true)
fun InputPreview() {
    Input(
        modifier = Modifier,
        state = rememberTextFieldState(),
        placeholder = "Full Name"
    )
}