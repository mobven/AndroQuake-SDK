package com.mobven.donation

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import com.mobven.donation.databinding.ActivityDonateBinding
import com.mobven.donation.helper.MarginItemDecoration
import com.mobven.extension.showUrlOnCustomTabs

class DonateActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityDonateBinding
    private var donation: Donation? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityDonateBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            donation = intent.getParcelableExtra(EXTRA_DONATION, Donation::class.java)
        } else {
            @Suppress("DEPRECATION")
            donation = intent.getParcelableExtra(EXTRA_DONATION)
        }
        initDonationUi(donation)
    }

    private fun initDonationUi(donation: Donation?) {
        donation?.let {
            with(viewBinding) {

                ivLogo.setImageResource(it.logo)
                it.title?.let {
                    tvDonateTitle.text = it
                }

                it.setDarkMode?.let { mode ->
                    if(mode){
                        delegate.localNightMode = MODE_NIGHT_YES;
                    }else{
                        delegate.localNightMode = MODE_NIGHT_NO;
                    }
                }

                it.titleSpannable?.let {
                    tvDonateTitle.text = it.spannableString
                }
                it.description?.let {
                    tvDonateDescription.text = it
                }
                it.descriptionSpannable?.let {
                    tvDonateDescription.text = it.spannableString
                }
                rvDonateButtons.adapter =
                    DonateButtonAdapter(it.donationButtonList) { donateButton ->
                        showUrlOnCustomTabs(
                            url = donateButton.link.orEmpty(),
                            navigationColor = R.color.lotion,
                            toolbarColor = R.color.lotion
                        )
                    }
                rvDonateButtons.addItemDecoration(
                    MarginItemDecoration(
                        resources.getDimensionPixelSize(
                            R.dimen.margin_12
                        )
                    )
                )
            }
        }
    }
    companion object {

        private const val EXTRA_DONATION = "donation"

        fun callingIntent(ctx: Context, donation: Donation): Intent =
            Intent(ctx, DonateActivity::class.java).apply {
                putExtra(EXTRA_DONATION, donation)
            }
    }
}