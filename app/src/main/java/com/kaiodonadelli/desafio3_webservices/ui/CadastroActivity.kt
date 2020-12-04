package com.kaiodonadelli.desafio3_webservices.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kaiodonadelli.desafio3_webservices.R
import kotlinx.android.synthetic.main.activity_cadastro.*
import android.content.Intent


class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        cadastroBtnSave.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        toolbarCadastro.setNavigationOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}
