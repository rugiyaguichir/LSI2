package com.example.lsi2

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.graphics.pdf.PdfDocument
import android.graphics.pdf.PdfDocument.PageInfo
import android.widget.Toast
import androidx.core.content.ContextCompat
import java.io.File
import java.io.FileOutputStream
import java.io.IOException


fun generatePDF(context: Context, directory: File) {
//    val doctor = MyRow(item = title)
    val pageHeight = 1000
    val pageWidth = 992
    val pdfDocument = PdfDocument()
    val paint = Paint()
    val title = Paint()
    val myPageInfo = PageInfo.Builder(pageWidth, pageHeight, 1).create()
    val myPage = pdfDocument.startPage(myPageInfo)
    val canvas: Canvas = myPage.canvas
    val bitmap: Bitmap? = drawableToBitmap(context.resources.getDrawable(R.drawable.img))
    val scaleBitmap: Bitmap? = Bitmap.createScaledBitmap(bitmap!!, 165, 200, true)
    canvas.drawBitmap(scaleBitmap!!, 40f, 60f, paint)
    title.typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
    title.textSize = 53f
    title.color = ContextCompat.getColor(context, R.color.black)
    canvas.drawText("TALON A21", 600f, 210f, title)
    canvas.drawText("Guichir Rugiya", 560f, 380f, title)
    title.typeface = Typeface.defaultFromStyle(Typeface.NORMAL)
    title.color = ContextCompat.getColor(context, R.color.black)
    title.textSize = 40f
    title.textAlign = Paint.Align.CENTER
    canvas.drawText("This is information about ",730f, 470f, title)
    canvas.drawText("patient.", 730f, 550f, title)
    canvas.drawText("Doctor Alex. Dentist. 14:30, 14.02.2024", 420f, 750f, title)
    val ritmap: Bitmap? = drawableToBitmap(context.resources.getDrawable(R.drawable.logos))
    val rscaleBitmap: Bitmap? = Bitmap.createScaledBitmap(ritmap!!, 62, 50, false)
    canvas.drawBitmap(rscaleBitmap!!, 150f, 810f, paint)
    title.typeface = Typeface.defaultFromStyle(Typeface.NORMAL)
    title.color = ContextCompat.getColor(context, R.color.black)
    title.textSize = 35f
    title.textAlign = Paint.Align.CENTER
    canvas.drawText("Luke Service International", 530f, 860f, title)
    canvas.drawText("Tokmok, Hope clinic", 530f, 900f, title)
    pdfDocument.finishPage(myPage)
    val file = File(directory, "sample.pdf")

    try {
        pdfDocument.writeTo(FileOutputStream(file))
        Toast.makeText(context, "PDF file generated successfully", Toast.LENGTH_SHORT).show()
    } catch (ex: IOException) {
        ex.printStackTrace()
    }
    pdfDocument.close()
}

fun drawableToBitmap(drawable: Drawable): Bitmap? {
    if (drawable is BitmapDrawable) {
        return drawable.bitmap
    }
    val bitmap = Bitmap.createBitmap(drawable.intrinsicWidth, drawable.intrinsicHeight, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)
    drawable.setBounds(0, 0, canvas.width, canvas.height)
    drawable.draw(canvas)
    return bitmap
}

