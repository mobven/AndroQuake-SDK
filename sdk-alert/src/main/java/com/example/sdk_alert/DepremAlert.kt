package com.example.sdk_alert

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class DepremAlert {

    companion object {

        fun showAlertAction(
            context: Context,
            appLanguage: String
        ): MutableLiveData<Boolean> = showAlert(context, appLanguage)

        private fun showAlert(
            context: Context,
            appLanguage: String
        ): MutableLiveData<Boolean> {

            val customAlertDialogView: View = LayoutInflater.from(context)
                .inflate(R.layout.info_list, null, false)

            val response = MutableLiveData<Boolean>()

            try {
                val dialog = MaterialAlertDialogBuilder(context)
                dialog.setView(customAlertDialogView)
                dialog.show()


            } catch (ex: Exception) {
                print(ex)
            }

            return response
        }
    }
}