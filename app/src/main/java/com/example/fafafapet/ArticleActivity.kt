package com.example.fafafapet

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_article.*

class ArticleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
    }

    fun lihatSemua2(view: View) {}

    fun LihatArtikel(view: View){
        var itentArticleActivity2 = Intent(this, ArticleActivity2::class.java)
        startActivity(itentArticleActivity2)
    }

}