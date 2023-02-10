package com.example.sdk_alert

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.sdk_alert.databinding.ItemDonateButtonBinding
import com.example.sdk_alert.model.DonateButton

class DonateButtonAdapter(
    private val buttonList: MutableList<DonateButton>,
    private val clickListener: (DonateButton) -> Unit
) :
    RecyclerView.Adapter<DonateButtonAdapter.DonateButtonViewHolder>() {

    class DonateButtonViewHolder(private val binding: ItemDonateButtonBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(donateButton: DonateButton, clickListener: (DonateButton) -> Unit) {
            binding.buttonDonate.apply {
                donateButton.icon?.let {
                    icon = it
                }

                donateButton.label?.let {
                    text = it
                }

                strokeColor = ColorStateList.valueOf(
                    ContextCompat.getColor(
                        context,
                        donateButton.strokeColor ?: R.color.color_black
                    )
                )

                strokeWidth = (donateButton.strokeWidth ?: 2).dp

                setOnClickListener {
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