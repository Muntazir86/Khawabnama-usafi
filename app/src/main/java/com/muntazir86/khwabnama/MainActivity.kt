package com.muntazir86.khwabnama

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.github.barteksc.pdfviewer.PDFView

class MainActivity : AppCompatActivity() {
    val contents = arrayOf("قرآنی سورتیں پڑھنا", "ملاءکہ کو دیکھنا", "پیغمبروں کو دیکھنا", "صحابہ کو دیکھنا",
        "آ", "ا", "ب", "پ",  "ت", "ٹ"  ,"ث",  "ج",  "چ",  "ح",  "خ",  "د",  "ڈ",  "ذ",  "ر",  "ز",  "س",  "ش",  "ص",
        "ض", "ط",  "ظ", "ع",  "غ", "ف", "ق",  "ک",  "گ",  "ل",  "م",  "ن",  "و",  "ہ",  "ی")
    val pageNo = arrayOf(18, 23, 25, 28, 29, 34, 40, 49, 56, 60, 62, 62, 67, 73, 75, 78, 88, 91, 92, 98, 103,
    112, 119, 122, 123, 127, 128, 132, 134, 136, 140, 147, 153, 156, 162, 166, 168, 171)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list_view: ListView = findViewById(R.id.list_view)

        val adp :ArrayAdapter<String> = ArrayAdapter(this@MainActivity,
            android.R.layout.simple_list_item_1, contents)
        list_view.adapter = adp

        list_view.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, pdfViewer::class.java)
            val bundle = Bundle()
            bundle.putInt("pageNo", pageNo[id.toInt()])
            intent.putExtras(bundle)
            startActivity(intent)
             }
     }

    override fun onBackPressed() {
        super.onBackPressed()
        onDestroy()
    }
}
