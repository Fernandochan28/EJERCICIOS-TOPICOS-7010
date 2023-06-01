package com.example.myapplication

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.os.CountDownTimer
import android.view.MotionEvent
import android.view.View

class Canvas (p:MainActivity): View(p)
{
    var x1=1000f
    var y1=1000f
    var top= false

    override fun onDraw(c: Canvas)
    {
        super.onDraw(c)
        val p= Paint()
        c.drawColor(Color.CYAN)
        p.color= Color.BLACK
        c.drawCircle(x1, y1, 25f,p)
        p.color= Color.GREEN
        c.drawRoundRect(RectF(20f, 200f, 50f, 500f), 6f, 6f, p)
        p.color= Color.GREEN
        c.drawRoundRect(RectF(970f, 800f, 1000f, 1100f), 6f, 6f, p)

        object : CountDownTimer(500000, 1000)
        {
            override fun onTick(millisUntilFinished: Long)
            {
                if (!top)
                {
                    x1 += 20f
                    colision(y1, x1)
                }
                if (top)
                {
                    x1 -= 20f
                    colision(y1, x1)

                }
                invalidate()
            }
            override fun onFinish() {
            }

        }.start()
    }

    private fun colision(y: Float,x: Float)
    {
        if (x1>=1080)
        {
            x1= 1080F
            top=true
        }
        if (x1<=0)
        {
            x1= 0F
            top =false
        }
    }
}