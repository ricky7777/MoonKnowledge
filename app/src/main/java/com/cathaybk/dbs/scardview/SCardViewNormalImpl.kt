package com.cathaybk.dbs.scardview

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF

/**
 * Created by Hongren 2021/5/18.
 * */
open class SCardViewNormalImpl : SCardViewBaseImpl() {

    override fun initStatic() {
        SRoundRectDrawableWithShadow.sRoundRectHelper = object :
            SRoundRectDrawableWithShadow.RoundRectHelper {
            override fun drawRoundRect(canvas: Canvas, bounds: RectF, cornerRadius: Float, cornerVisibility: Int, paint: Paint) {
                canvas.drawRoundRect(bounds, cornerRadius, cornerRadius, paint)
            }
        }
    }
}