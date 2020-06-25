package com.example.minipaint

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.view.MotionEvent
import android.view.View
import androidx.core.content.res.ResourcesCompat

class MyCanvasView(context:Context):View(context) {
    private const val STROKE_WIDTH = 12f // has to be float
    private lateinit var extraCanvas: Canvas
    private lateinit var extraBitmap: Bitmap
    private val backgroundColor = ResourcesCompat.getColor(resources,R.color.colorBackground,null)
    private var path: Path
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        if (::extraBitmap.isInitialized) extraBitmap.recycle()
        extraBitmap = Bitmap.createBitmap(width,height, Bitmap.Config.ARGB_8888)
        extraCanvas = Canvas(extraBitmap)
        extraCanvas.drawColor(backgroundColor)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawBitmap(extraBitmap, 0f, 0f, null)
    }
    private val drawColor = ResourcesCompat.getColor(resources,R.color.colorPaint, null)

    //setup the paint with which to draw
    private val paint Paint().apply{
        color= drawColor
        //smooths out edges of what is drawn without affecting shape.
        isAntialias = true
        // Dithering affects how colors with higher-precision than the device are down-sampled.
        isDither = true
        style = Paint.Style.STROKE // default: FILL
        strokeJoin = Paint.Join.ROUND // default: MITER
        strokeCap = Paint.Cap.ROUND // default: BUTT
        strokeWidth = STROKE_WIDTH // default: Hairline-width (really thin)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        motionEvent.A
    }
}