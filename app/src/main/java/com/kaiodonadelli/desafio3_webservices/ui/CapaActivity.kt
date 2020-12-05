package com.kaiodonadelli.desafio3_webservices.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kaiodonadelli.desafio3_webservices.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_capa.*

class CapaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capa)

        toolbarCapa.setNavigationOnClickListener {
            onBackPressed()
        }

        val HQCapa = intent.getStringExtra("urlHQCapa")

        Picasso.get().load(HQCapa)
            .into(imageViewCapa)
    }
}