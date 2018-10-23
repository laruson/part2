package com.chernikovichandreygmail.presenter.screen.lesson5

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.os.Handler
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.View
import java.util.*

class Watch : View {
    private val blackPaint = Paint().apply {
        color = Color.BLACK
        isAntiAlias = true
    }

    private val whitePaint = Paint().apply {
        color = Color.WHITE
        isAntiAlias = true
    }

    private val redPaint = Paint().apply {
        color = Color.RED
        isAntiAlias = true
    }

    private val textPaint = Paint().apply {
        color = Color.BLACK
        textSize = 70F
        isAntiAlias = true
    }

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val height = height / 1.7F
        val radius = Math.min(height, width.toFloat()) / 2.toFloat()
        val x = (width / 2).toFloat()
        val y = height / 2

        canvas.drawCircle(x, y, radius, blackPaint)
        canvas.drawCircle(x, y, radius * (radius - 50) / radius, whitePaint)

        canvas.save()

        var lineFinishY = (y + radius) * 0.81F
        val lineStartY = (y + radius) * 0.91F

        val hourStep = 360 / 12F
        val minuteStep = 360 / 60F

        for (i in 1..12) {
            canvas.drawLine(x, lineStartY, x, lineFinishY, blackPaint)
            canvas.rotate(hourStep, width / 2F, height / 2F)
        }
        canvas.restore()

        canvas.save()
        lineFinishY = (y + radius) * 0.87F

        for (i in 1..60) {
            canvas.drawLine(x, lineStartY, x, lineFinishY, blackPaint)
            canvas.rotate(minuteStep, width / 2F, height / 2F)
        }
        canvas.restore()

        canvas.drawText("3", x + radius * 0.45F, y * 1.07F, textPaint)
        canvas.drawText("6", x * 0.96F, y + radius * 0.55F, textPaint)
        canvas.drawText("9", x - radius * 0.55F, y * 1.07F, textPaint)
        canvas.drawText("12", x * 0.93F, y - radius * 0.4F, textPaint)


        val calendar = Calendar.getInstance()
        val minute = calendar.get(Calendar.MINUTE)
        val hour = calendar.get(Calendar.HOUR)
        val second = calendar.get(Calendar.SECOND)

        canvas.save()
        canvas.rotate(hourStep * hour + hourStep / 60 * minute, x, y)
        blackPaint.apply {
            strokeWidth = 15F
        }
        canvas.drawLine(x, y, x, y - radius / 2.2F, blackPaint)
        canvas.restore()
        canvas.save()
        canvas.rotate(minuteStep * minute, x, y)
        blackPaint.apply {
            strokeWidth = 10F
        }
        canvas.drawLine(x, y, x, y - radius / 1.8F, blackPaint)
        canvas.restore()
        canvas.save()
        canvas.rotate(minuteStep * second, x, y)
        blackPaint.apply {
            strokeWidth = 6F
        }
        canvas.drawLine(x, y, x, y - radius / 1.8F, blackPaint)

        canvas.drawCircle(x, y, 15F, redPaint)
        canvas.restore()

        invalidate()
        handler()
    }

    private fun handler() {
        Handler().postDelayed({

        }, 1000)
    }
}