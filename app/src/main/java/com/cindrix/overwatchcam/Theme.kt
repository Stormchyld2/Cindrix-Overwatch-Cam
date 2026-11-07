package com.cindrix.overwatchcam

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.widget.Button
import android.widget.EditText

/** The Cindrix Overwatch colors, in one place. The web page (assets/index.html) uses the same values. */
object Theme {
    val CHARCOAL = Color.parseColor("#1F2226")
    val PANEL = Color.parseColor("#2A2E33")
    val BONE = Color.parseColor("#ECE6D8")
    val MUTED = Color.parseColor("#9AA3AB")
    val BLUE = Color.parseColor("#67B4FF")
    val ON_BLUE = Color.parseColor("#07101F")
    val OUTLINE = Color.parseColor("#4A5159")
    val GREEN = Color.parseColor("#4CB782")
    val ORANGE = Color.parseColor("#F08A3C")
    val RED = Color.parseColor("#E5534B")

    private fun dp(c: Context, v: Int) = (v * c.resources.displayMetrics.density)

    private fun box(c: Context, fill: Int, stroke: Int? = null) = GradientDrawable().apply {
        setColor(fill)
        cornerRadius = dp(c, 10)
        if (stroke != null) setStroke(dp(c, 1).toInt().coerceAtLeast(1), stroke)
    }

    fun panel(c: Context): GradientDrawable = box(c, PANEL)

    fun primary(b: Button, c: Context) {
        b.background = box(c, BLUE)
        b.setTextColor(ON_BLUE)
    }

    fun secondary(b: Button, c: Context) {
        b.background = box(c, PANEL, OUTLINE)
        b.setTextColor(BONE)
    }

    fun field(e: EditText) {
        e.setTextColor(BONE)
        e.setHintTextColor(MUTED)
    }
}
