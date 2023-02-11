package com.mobven.donation.helper

import android.os.Parcel
import android.os.Parcelable
import android.text.SpannableString
import android.text.TextUtils
import androidx.annotation.Keep

@Keep
class DonationText(
    val spannableString: SpannableString?
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readSpannableString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeSpannableString(spannableString, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DonationText> {
        override fun createFromParcel(parcel: Parcel): DonationText {
            return DonationText(parcel)
        }

        override fun newArray(size: Int): Array<DonationText?> {
            return arrayOfNulls(size)
        }
    }
}

fun Parcel.writeSpannableString(spannableString: SpannableString?, flags: Int) {
    TextUtils.writeToParcel(spannableString, this, flags)
}

fun Parcel.readSpannableString(): SpannableString? {
    return TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this) as SpannableString?
}