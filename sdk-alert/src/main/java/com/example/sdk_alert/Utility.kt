package com.example.sdk_alert

import android.content.res.Resources
import android.view.View

val Int.dp: Int
    get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

fun <T : View> T.click(block: (T) -> Unit) = setOnClickListener { block(it as T) }
