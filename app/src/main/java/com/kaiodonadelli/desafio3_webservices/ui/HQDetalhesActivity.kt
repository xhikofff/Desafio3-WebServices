package com.kaiodonadelli.desafio3_webservices.ui

import android.content.Intent
import android.os.Bundle
import android.text.SpannedString
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import com.kaiodonadelli.desafio3_webservices.R
import com.kaiodonadelli.desafio3_webservices.domain.HQ
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detalhes_hq.*
import java.text.SimpleDateFormat
import java.util.*

class HQDetalhesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_hq)

        val HQ = intent.getSerializableExtra("HQ") as HQ

        toolbarDetalhes.setNavigationOnClickListener {
            onBackPressed()
        }

        imageViewHQDetalhesCapa.setOnClickListener {
            startActivity(
                Intent(this, CapaActivity::class.java)
                    .putExtra("urlHQCapa", HQ.thumbnail.getFullPath())
            )
        }

        Picasso.get().load(HQ.getImage())
            .into(imageViewHQDetalhesFundo)

        Picasso.get().load(HQ.thumbnail.getFullPath())
            .into(imageViewHQDetalhesCapa)

        textViewHQDetalhesTitulo.text = HQ.title
        textViewHQDetalhesDescricao.text = HQ.description ?: "No description"
        textViewHQDetalhesPreco.text = makeBold("Price:", "$ " + HQ.getPrice().toString())
        textViewHQDetalhesPaginas.text = makeBold("Pages:", HQ.pageCount.toString())

        val oldPattern: Date =
            SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssss").parse(HQ.getDate())
        val newPattern = SimpleDateFormat("MMMM dd, yyyy", Locale.US)
        val dateFormated = newPattern.format(oldPattern)

        textViewHQDetalhesDataPublicacao.text =
            makeBold("Published:", dateFormated)
    }

    private fun makeBold(p1: String, p2: String): SpannedString {
        return buildSpannedString {
            bold {
                append(p1)
            }
            append(" $p2")
        }
    }
}