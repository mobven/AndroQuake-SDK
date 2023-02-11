package com.mobven.donation

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.mobven.donation.databinding.ItemDonateButtonBinding
import com.mobven.donation.helper.dp
import com.mobven.donation.model.DonateButton
import com.mobven.extension.click

class DonateButtonAdapter(
    private val buttonList: List<DonateButton>,
    private val clickListener: (DonateButton) -> Unit
) :
    RecyclerView.Adapter<DonateButtonAdapter.DonateButtonViewHolder>() {

    class DonateButtonViewHolder(private val binding: ItemDonateButtonBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(donateButton: DonateButton, clickListener: (DonateButton) -> Unit) {
            binding.buttonDonate.apply {
                donateButton.icon?.let {
                    icon = ContextCompat.getDrawable(context, it)
                }
                donateButton.label?.let {
                    text = it
                }
                donateButton.textColor?.let {
                    setTextColor(
                        ContextCompat.getColor(
                            context, it
                        )
                    )
                }
                donateButton.strokeColor?.let {
                    strokeColor = ColorStateList.valueOf(
                        ContextCompat.getColor(
                            context, it
                        )
                    )
                }
                donateButton.strokeWidth?.let {
                    strokeWidth = it.dp
                }

                donateButton.backgroundColor?.let {
                    backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(
                            context, it
                        )
                    )
                }

                click {
                    clickListener(donateButton)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DonateButtonViewHolder {
        val mBinding =
            ItemDonateButtonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DonateButtonViewHolder(mBinding)
    }

    override fun getItemCount(): Int {
        return buttonList.size
    }

    override fun onBindViewHolder(holder: DonateButtonViewHolder, position: Int) {
        holder.bindData(buttonList[position], clickListener)
    }
}