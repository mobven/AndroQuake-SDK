package com.example.sample

import android.content.res.Resources
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sdk_alert.DepremAlert
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val deviceLang: Locale = resources.configuration.locales.get(0)

        DepremAlert.showAlertAction(
            this,
            deviceLang.country
        )
    }
}