package com.evg_ivanoff.astonhomeworks

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import java.util.*

class ClockView : View {
    private var hours = 0
    private var minutes = 0
    private var seconds = 0
    private var mWidth = 0
    private var mHeight = 0
    private var centerHeight = 0f
    private var centerWidth = 0f
    private var paint = Paint()


    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        getTime()
        paint.reset()
        paint.apply {
            color = Color.BLACK
            isAntiAlias = true
            strokeWidth = 5f
            style = Paint.Style.STROKE
        }
        canvas?.drawColor(Color.WHITE)

        mWidth = width
        mHeight = height
        centerHeight = mHeight / 2.toFloat()
        centerWidth = mWidth / 2.toFloat()
        canvas?.drawCircle(centerWidth, centerHeight, 4f, paint)

        //hour scale
        for (i in 0..12) {
            canvas?.save()
            canvas?.rotate(360 / 12 * (i + 1).toFloat(), centerWidth, centerHeight)
            canvas?.drawLine(
                centerWidth,
                centerHeight - centerWidth + 10,
                centerWidth,
                centerHeight - centerWidth + 30,
                paint
            )
            canvas?.restore()
        }

        //minute scale
        paint.strokeWidth = 2f
        for (i in 0..60) {
            canvas?.save()
            canvas?.rotate(360 / 60 * (i + 1).toFloat(), centerWidth, centerHeight)
            canvas?.drawLine(
                centerWidth,
                centerHeight - centerWidth + 10,
                centerWidth,
                centerHeight - centerWidth + 30,
                paint
            )
            canvas?.restore()
        }

        //hour arrow
        canvas?.save()
        canvas?.rotate(360 / 12 * hours + minutes * 0.5f, centerWidth, centerHeight)
        paint.strokeWidth = 8f
        canvas?.drawLine(
            centerWidth,
            centerHeight,
            centerWidth,
            centerHeight - mHeight / 7,
            paint
        )
        canvas?.restore()

        //minute arrow
        canvas?.save()
        canvas?.rotate(360 / 60 * minutes + seconds * 0.1f, centerWidth, centerHeight)
        paint.strokeWidth = 5f
        canvas?.drawLine(
            centerWidth,
            centerHeight,
            centerWidth,
            centerHeight - mHeight / 5,
            paint
        )
        canvas?.restore()

        //second arrow
        canvas?.save()
        canvas?.rotate(360 / 60 * seconds.toFloat(), centerWidth, centerHeight)
        paint.strokeWidth = 3f
        paint.color = Color.RED
        canvas?.drawLine(
            centerWidth,
            centerHeight,
            centerWidth,
            centerHeight - mHeight / 4,
            paint
        )
        canvas?.restore()

        postInvalidateDelayed(500)
        invalidate()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }


    fun getTime() {
        val calendar = Calendar.getInstance()
        hours = calendar.get(Calendar.HOUR)
        minutes = calendar.get(Calendar.MINUTE)
        seconds = calendar.get(Calendar.SECOND)
    }
}