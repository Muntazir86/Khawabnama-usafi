package com.muntazir86.khwabnama

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ProgressBar
import com.github.barteksc.pdfviewer.PDFView

class pdfViewer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_viewer)

        val pdfViewer: PDFView = findViewById(R.id.pdfView)

        val bundle = intent.extras

        pdfViewer.fromAsset("khawab_nama.pdf")
            .defaultPage(bundle!!.getInt("pageNo", 0))
            .enableDoubletap(true)
            .enableAnnotationRendering(false)
            .enableAntialiasing(true)
            .load()

        val progress_bar: ProgressBar = findViewById(R.id.progress_circular)

        Handler().postDelayed({
            progress_bar.visibility = View.INVISIBLE
        }, 1000)

    }
}
