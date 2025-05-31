package com.newsaggregator.core.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography = Typography(

    displayMedium = TextStyle(
        fontWeight = FontWeight.Thin,
        fontSize = 45.sp,
        lineHeight = 52.sp,
        letterSpacing = 0.5.sp,
        fontFamily = GHGuardianHeadlineBlack
    ),

    titleLarge = TextStyle(
        fontSize = 22.sp,
        lineHeight = 28.sp,
        fontWeight = FontWeight.ExtraBold,
        fontFamily = GHGuardianHeadlineBlack
    ),

    bodyLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
        fontFamily = GHGuardianHeadlineBlack,
    ),

    bodyMedium = TextStyle(
        fontFamily = GHGuardianHeadlineBlack,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp,
    ),

    bodySmall = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
        fontFamily = GHGuardianHeadlineBlack,
    ),

    labelLarge = TextStyle(
        fontFamily = GHGuardianHeadlineBlack,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)
