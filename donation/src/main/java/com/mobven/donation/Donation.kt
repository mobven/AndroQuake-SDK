package com.mobven.donation

import android.content.Context
import android.os.Parcelable
import android.text.SpannableString
import androidx.annotation.DrawableRes
import com.mobven.donation.helper.DonationText
import com.mobven.donation.model.DonateButton
import com.mobven.extension.bold
import com.mobven.extension.color
import com.mobven.extension.setColor
import kotlinx.parcelize.Parcelize

@Parcelize
class Donation(
    @DrawableRes val logo: Int,
    val title: DonationText?,
    val description: DonationText?,
    val donationButtonList: List<DonateButton>
) : Parcelable {

    data class Builder(
        val context: Context,
        private var logo: Int = R.drawable.default_logo,
        private var title: DonationText? = null,
        private var description: DonationText? = null,
        private val donationButtonList: MutableList<DonateButton> = mutableListOf()
    ) {
        fun logo(logo: Int) = apply { this.logo = logo }

        fun title(title: DonationText?) = apply { this.title = title }

        fun description(description: DonationText?) = apply { this.description = description }

        fun donationButtons(donationButtonList: List<DonateButton>) =
            apply { this.donationButtonList.addAll(donationButtonList) }

        private fun prepareButtons(): MutableList<DonateButton> = mutableListOf(
            DonateButton(
                icon = R.drawable.ahbap_logo,
                link = "https://ahbap.org/bagisci-ol",
                strokeColor = R.color.color_green_ahbap,
                backgroundColor = R.color.color_bg_ahbap
            ),
            DonateButton(
                icon = R.drawable.afad_logo,
                link = "https://www.afad.gov.tr/depremkampanyasi2",
                strokeColor = R.color.color_green_afad,
                backgroundColor = R.color.color_bg_afad
            ),
            DonateButton(
                label = "TÜRK KIZILAY",
                icon = R.drawable.kizilay,
                link = "https://www.kizilay.org.tr/bagis",
                strokeColor = R.color.permanent_geranium_lake,
                textColor = R.color.color_kizilay_text,
                backgroundColor = R.color.color_bg_kizilay
            ),
            DonateButton(
                label = "BİREYSEL BAĞIŞ",
                link = "#bagisyap"
            )
        )

        fun build() {
            if (title == null) {
                title = DonationText(
                    SpannableString(context.getString(R.string.default_title))
                        .setColor(context.color(R.color.fuzzy_wuzzy), 12, 24)
                        .bold(12, 24)
                )
            }
            if (description == null) {
                description = DonationText(
                    SpannableString(context.getString(R.string.default_description))
                        .bold(13, 25)
                )
            }
            if (donationButtonList.isEmpty()) {
                donationButtonList.addAll(prepareButtons())
            }
            context.startActivity(
                DonateActivity.callingIntent(
                    context,
                    Donation(logo, title, description, donationButtonList)
                )
            )
        }
    }


}