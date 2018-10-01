package com.chernikovichandreygmail.lesson4

import android.graphics.Color
import android.graphics.Paint
import android.util.Log

fun sum(list: ArrayList<Int>): Int {
    var sum = 0
    for (item: Int in list)
        sum += item

    return sum
}

fun transfer(): ArrayList<Int> {
    val list = ArrayList<Int>()
    list.add(1)
    list.add(2)
    list.add(3)
    list.add(4)
    return list
}

fun paints(): ArrayList<Paint> {
    val list = ArrayList<Paint>()
    for (i in 1..4) {
        list.add(Paint().apply {
            color = Color.YELLOW
        })
        list.add(Paint().apply {
            color = Color.GREEN
        })
        list.add(Paint().apply {
            color = Color.BLUE
        })
        list.add(Paint().apply {
            color = Color.CYAN
        })
        list.add(Paint().apply {
            color = Color.GRAY
        })
        list.add(Paint().apply {
            color = Color.MAGENTA
        })
        list.add(Paint().apply {
            color = Color.YELLOW
        })
        list.add(Paint().apply {
            color = Color.BLUE
        })
        list.add(Paint().apply {
            color = Color.CYAN
        })
        list.add(Paint().apply {
            color = Color.GRAY
        })
        list.add(Paint().apply {
            color = Color.MAGENTA
        })
    }
    return list
}

fun blackPaint(): Paint {
    val paint = Paint()
    paint.color = Color.BLACK
    paint.textSize = 35F
    paint.style = Paint.Style.STROKE
    paint.isAntiAlias = true

    return paint
}


fun text() {
    var start = 0
    var a = 0
    var b = 10
    for (i in 1..36) {
        Log.e("AAAAA", a.toString() + " " + b.toString())
        a += 10
        b += 10
    }

}

//if (start >= -90 && start<0) {
//    if (start >= -90 && start < -80)
//        canvas?.drawText(data.toString(), x + 10, y - 300, blackPaint())
//    else if(start>=-80 && start<-70)
//        canvas?.drawText(data.toString(), x + 60, y - 280, blackPaint())
//    else if(start>=-70 && start<-60)
//        canvas?.drawText(data.toString(), x + 110, y - 260, blackPaint())
//    else if(start>=-60 && start<-50)
//        canvas?.drawText(data.toString(), x + 150, y - 240, blackPaint())
//    else if(start>=-50 && start<-40)
//        canvas?.drawText(data.toString(), x + 190, y - 200, blackPaint())
//    else if(start>=-40 && start<-30)
//        canvas?.drawText(data.toString(), x + 210, y - 160, blackPaint())
//    else if(start>=-30 && start<-20)
//        canvas?.drawText(data.toString(), x + 230, y - 120, blackPaint())
//    else if(start>=-20 && start<-10)
//        canvas?.drawText(data.toString(), x + 280, y - 80, blackPaint())
//    else if(start>=-10 && start<0)
//        canvas?.drawText(data.toString(), x + 290, y - 70, blackPaint())
//}else if(start>=0 && start<90){
//    if (start >= 0 && start < 10)
//        canvas?.drawText(data.toString(), x + 300, y - 10, blackPaint())
//            else if(start>=10 && start<20)
//                canvas?.drawText(data.toString(), x + 60, y - 280, blackPaint())
//            else if(start>=20 && start<30)
//                canvas?.drawText(data.toString(), x + 100, y - 260, blackPaint())
//            else if(start>=30 && start<40)
//                canvas?.drawText(data.toString(), x + 140, y - 240, blackPaint())
//            else if(start>=40 && start<50)
//                canvas?.drawText(data.toString(), x + 170, y - 200, blackPaint())
//            else if(start>=50 && start<60)
//                canvas?.drawText(data.toString(), x + 190, y - 160, blackPaint())
//            else if(start>=60 && start<70)
//                canvas?.drawText(data.toString(), x + 210, y - 120, blackPaint())
//            else if(start>=70 && start<80)
//                canvas?.drawText(data.toString(), x + 230, y - 90, blackPaint())
//            else if(start>=80 && start<90)
//                canvas?.drawText(data.toString(), x + 250, y - 50, blackPaint())
//}




//        } else if (start >= 0 && start < 90) {
//            canvas?.drawText(data.toString(), x + i - k, y + i - k, blackPaint())
//            Log.e("AAAAA", k.toString())
//
//        } else if (start >= 90 && start < 180) {
//            canvas?.drawText(data.toString(), x - i + k, y - i + k, blackPaint())
//            Log.e("AAAAA", k.toString())
//
//        } else if (start >= 180) {
//            canvas?.drawText(data.toString(), x - i + k, y + i + k, blackPaint())
//            Log.e("AAAAA", k.toString())
//        }
//        k += 20