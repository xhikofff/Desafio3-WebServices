package com.kaiodonadelli.desafio3_webservices.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.kaiodonadelli.desafio3_webservices.R
import com.kaiodonadelli.desafio3_webservices.adapters.MedalhasAdapter
import kotlinx.android.synthetic.main.activity_medalhas.*
import kotlinx.android.synthetic.main.toolbar_main.view.*

class MedalhasActivity : AppCompatActivity() {

    private val viewModel: MedalhaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medalhas)

        toolbarMedalhas.toolbarMain.setNavigationOnClickListener {
            onBackPressed()
        }

        val listaMedalhas = viewModel.getListMedalhasGson()
        val adapter = MedalhasAdapter(listaMedalhas)

        rvMedalhas.adapter = adapter

    }
}
