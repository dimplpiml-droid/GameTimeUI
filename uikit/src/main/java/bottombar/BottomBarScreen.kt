package bottombar

import androidx.annotation.DrawableRes
import ru.example.uikit.R

/**
 *
 * Дата создания: 12.11.2026
 *
 * Описывает вкладки нижней панели навигации
 * @property icon идентификатор векторной иконки вкладки из ресурсов
 * @property label текстовое название вкладки, отображаемое под иконкой
 */
sealed class BottomBarScreen(
    @DrawableRes
    val icon: Int,
    val label: String,
) {
    data object Statistics : BottomBarScreen(
        icon = R.drawable.statistics_icon,
        label = "Statistics"
    )
    data object  Discover: BottomBarScreen(
        icon = R.drawable.location_pin,
        label = "Discover"
    )
    data object Schedule: BottomBarScreen(
        icon = R.drawable.schedule,
        label = "Schedule"
    )
    data object Chat: BottomBarScreen(
        icon = R.drawable.chat,
        label = "Chat"
    )
    data object Profile: BottomBarScreen(
        icon = R.drawable.profile,
        label = "Profile"
    )
}