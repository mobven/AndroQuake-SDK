package com.mobven.sample

import android.os.Bundle
import android.text.SpannableString
import androidx.appcompat.app.AppCompatActivity
import com.example.sample.databinding.ActivityMainBinding
import com.mobven.donation.Donation
import com.mobven.donation.R
import com.mobven.donation.helper.DonationText
import com.mobven.donation.model.DonateButton

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        with(viewBinding) {
            btnDefault.setOnClickListener {
                Donation.Builder(this@MainActivity).build()
            }

            Donation.Builder(this@MainActivity)
                .logo(R.drawable.kizilay)
                .titleSpan(DonationText(SpannableString.valueOf("Donate")))
                .descriptionSpan(DonationText(SpannableString.valueOf("Donation lorem impsum...")))
                .donationButtons(
                    mutableListOf(
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
                )
                .build()

        }
    }
}