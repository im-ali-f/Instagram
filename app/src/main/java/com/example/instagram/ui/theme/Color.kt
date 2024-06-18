package com.example.instagram.ui.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)



val mainSeperatorColor = Color(0x946B6B6B)
val officialColor = Color(0xFF3897F0)
val pageCountBGCColor = Color(0xB3121212)
val pageCountFontColor = Color(0xFFF9F9F9)
val activeDotColor = Color(0xFF3897F0)
val deActiveDotColor = Color(0xFFA59C9C)
//login
val borderColor = Color(0x1A000000)
val inputPlaceHolderColor = Color(0x33000000)
val mainBlueColor = Color(0xFF3797EF)
//addPage
val addManagerCircleBGC = Color(0x99121212)



sealed class  ThemeColors(
    val topBarColorAlpha :Color,
    val mainIconColor :Color,
    val mainFontColor :Color,
    val secondFontColor :Color,
    val backgroundColor :Color,
    val searchBarColor :Color

){
    object Night : ThemeColors(
         topBarColorAlpha = Color(0xFF121212),
         mainIconColor = Color(0xFFF9F9F9),
         mainFontColor = Color(0xFFF9F9F9),
         secondFontColor = Color(0x99FFFFFF),
         backgroundColor = Color(0xFF000000),
         searchBarColor = Color(0xFF262626),

    )

    object Day : ThemeColors(
        topBarColorAlpha = Color(0xFFFAFAFA),
        mainIconColor = Color(0xFF262626),
        mainFontColor = Color(0xFF262626),
        secondFontColor = Color(0x66000000),
        backgroundColor = Color(0xFFFFFFFF),
        searchBarColor = Color(0x33767680),



    )

}
