package com.chernikovichandreygmail.lesson4

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.View

class Diagram : View {
    private val data = transfer()
    private val oval = RectF()
    private val paints = paints()

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    override fun onDraw(canvas: Canvas?) {
        val height = height / 2
        val radius = Math.min(height, width) / 2.toFloat()
        val diameter = radius * 2
        val x = width.toFloat() / 2
        val y = height.toFloat() / 2
        val sum = sum(data)
        val circle = 360F
        var start = -90F
        text()
        oval.set(x - radius, y - radius, x - radius + diameter, y - radius + diameter)
        for (i in 0 until data.size) {
            drawArc(canvas, start, circle, sum, data[i], paints[i])
            start += circle * data[i] / sum
        }
    }

    private fun drawArc(canvas: Canvas?, start: Float, circul: Float, sum: Int, data: Int, paint: Paint) {
        canvas?.drawArc(oval, start, circul * data / sum, true, paint)
    }
}