package com.mobven.donation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DonateButton(
    val label: String? = null,
    val icon: Int? = null,
    val link: String? = null,
    val strokeWidth: Int? = null,
    val strokeColor: Int? = null,
    val backgroundColor: Int? = null,
    val textSize: Int? = null,
    val textColor: Int? = null
): Parcelable