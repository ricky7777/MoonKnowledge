package com.cathaybk.dbs.beanknowledge

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.RelativeLayout
import androidx.core.view.ViewCompat
import androidx.customview.widget.ViewDragHelper

/**
 *  reference https://gist.github.com/smartherd/2ec415563f8369af10cfc4a3ea24e1aa
 *  https://www.youtube.com/watch?v=nrmAsu3zTrw
 *  https://static.kancloud.cn/digest/fastdev4android/109672
 */
class DraggableRelativeLayout @JvmOverloads constructor(context: Context?, attrs: AttributeSet? = null) : RelativeLayout(context!!, attrs) {

    /** A listener to use when a child view is being dragged  */
    interface ViewDragListener {
        fun onViewCaptured(view: View, i: Int)
        fun onViewReleased(view: View, vx: Float, vy: Float)
        fun onViewPositionChanged(changedView: View, x: Int, y: Int, dx: Int, dy: Int)
        fun onViewDragStateChanged(state: Int)
    }

    private val viewDragHelper: ViewDragHelper
    private var viewDragListener: ViewDragListener? = null
    private var viewDragHelperState: Int = ViewDragHelper.STATE_IDLE

    fun smoothSlideViewTo(childCiew: View, left: Int, top: Int) {
        viewDragHelper.smoothSlideViewTo(childCiew, left, top)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        return viewDragHelper.shouldInterceptTouchEvent(ev) || super.onInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(ev: MotionEvent): Boolean {
        viewDragHelper.processTouchEvent(ev)
        return super.onTouchEvent(ev)
    }

    override fun computeScroll() {
        if (viewDragHelper.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this)
        }
    }

    private val dragCallback: ViewDragHelper.Callback = object : ViewDragHelper.Callback() {
        override fun tryCaptureView(view: View, i: Int): Boolean {
            return view.visibility == VISIBLE && viewDragHelperState == ViewDragHelper.STATE_IDLE
        }

        override fun onViewPositionChanged(changedView: View, left: Int, top: Int, dx: Int, dy: Int) {
            viewDragListener?.onViewPositionChanged(changedView, left, top, dx, dy)
        }

        override fun onViewCaptured(view: View, i: Int) {
            viewDragListener?.onViewCaptured(view, i)
        }

        override fun onViewReleased(view: View, vx: Float, vy: Float) {
            viewDragListener?.onViewReleased(view, vx, vy)
        }

        override fun getViewHorizontalDragRange(view: View): Int {
            return view.width
        }

        override fun getViewVerticalDragRange(view: View): Int {
            return view.height
        }

        override fun clampViewPositionHorizontal(view: View, left: Int, dx: Int): Int {
            //鎖定只能往右水平移動
            val leftEdge = (width / 2 - view.width * 3 / 5)
            val medium = (width / 2 - view.width / 2)
            return when (left) {
                in medium..Int.MAX_VALUE -> left
                in leftEdge..medium -> left - dx / 3
                else -> leftEdge
            }
        }

        override fun clampViewPositionVertical(view: View, top: Int, dy: Int): Int {
            //鎖定Y軸只能在中間
            return height / 2 - view.height / 2
        }

        override fun onViewDragStateChanged(state: Int) {
            super.onViewDragStateChanged(state)
            viewDragListener?.onViewDragStateChanged(state)
            viewDragHelperState = state
        }
    }

    fun setViewDragListener(viewDragListener: ViewDragListener?) {
        this.viewDragListener = viewDragListener
    }

    init {
        viewDragHelper = ViewDragHelper.create(this, dragCallback)
    }
}