package com.cathaybk.dbs.beanknowledge

import android.content.Context
import android.graphics.LinearGradient
import android.graphics.Shader
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat

/**
 * @author Tom on 2022/1/17
 * TextView with gradient color
 */
class GradientTextView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    AppCompatTextView(context, attrs, defStyleAttr) {
    private var colorStart = ContextCompat.getColor(context, R.color.black)
    private var colorEnd = ContextCompat.getColor(context, R.color.white)

    init {
        context.theme.obtainStyledAttributes(attrs, R.styleable.GradientTextView, 0, 0).apply {
            colorStart = getColor(R.styleable.GradientTextView_startTextColor, colorStart)
            colorEnd = getColor(R.styleable.GradientTextView_endTextColor, colorEnd)
        }.recycle()
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        //Setting the gradient if layout is changed
        if (changed) {
            paint.shader = getLinearGradient()
        }
    }

    fun setGradientColors(colorStart: Int, colorEnd: Int) {
        this.colorStart = colorStart
        this.colorEnd = colorEnd
        // this forces view redrawing
        invalidate()
    }

    private fun getLinearGradient() = LinearGradient(
        0f, 0f, width.toFloat(), 0f, colorStart, colorEnd, Shader.TileMode.DECAL
    )
}