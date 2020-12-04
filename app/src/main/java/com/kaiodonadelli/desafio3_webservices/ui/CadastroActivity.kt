package com.kaiodonadelli.desafio3_webservices.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.kaiodonadelli.desafio3_webservices.R
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.toolbar_main.view.*

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        toolbarCadastro.toolbarMain.setNavigationOnClickListener {
            onBackPressed()
        }

        btnCadastroCadastrar.setOnClickListener {
            Toast.makeText(this, "Conta criada com sucesso!", Toast.LENGTH_SHORT).show()
            finish()
        }

    }
}
