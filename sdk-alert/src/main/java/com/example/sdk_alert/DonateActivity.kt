package com.example.sdk_alert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sdk_alert.databinding.ActivityDonateBinding
import com.example.sdk_alert.model.DonateButton

class DonateActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityDonateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityDonateBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.rvDonateButtons.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        viewBinding.rvDonateButtons.adapter = DonateButtonAdapter(prepareButtons()) {
            Toast.makeText(this, it.link, Toast.LENGTH_SHORT).show()
        }
    }

    //Added for test
    private fun prepareButtons(): MutableList<DonateButton> {
        val buttonList = mutableListOf<DonateButton>()

        buttonList.add(
            DonateButton(
                label = null,
                icon = ContextCompat.getDrawable(this, R.drawable.button_ahbap),
                link = "https://ahbap.org/bagisci-ol",
                2,
                R.color.color_green_ahbap
            )
        )

        buttonList.add(
            DonateButton(
                label = null,
                icon = ContextCompat.getDrawable(this, R.drawable.button_afad),
                link = "https://www.afad.gov.tr/depremkampanyasi2",
                2,
                R.color.color_green_afad
            )
        )

        return buttonList
    }
}