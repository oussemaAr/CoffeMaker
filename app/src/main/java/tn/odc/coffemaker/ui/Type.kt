package tn.odc.coffemaker.ui

import androidx.ui.material.Typography
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.text.font.font
import androidx.ui.text.font.fontFamily
import androidx.ui.unit.sp
import tn.odc.coffemaker.R


private val regular = font(R.font.sen_regular)
private val bold = font(R.font.sen_bold, FontWeight.W600)

val appFontFamilly = fontFamily(
        listOf(
                regular,
                bold
        )
)

val typography = Typography(
        body1 = TextStyle(
                fontFamily = appFontFamilly,
                fontWeight = FontWeight.W600,
                fontSize = 20.sp
        )
)