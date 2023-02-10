package com.example.sdk_alert.model

import android.graphics.drawable.Drawable

data class DonateButton(
    val label: String,
    val icon: Drawable,
    val link: String,
    val strokeWidth: Int,
    val strokeColor: Int,
)