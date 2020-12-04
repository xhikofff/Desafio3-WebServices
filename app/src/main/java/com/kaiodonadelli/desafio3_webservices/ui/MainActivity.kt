package com.kaiodonadelli.desafio3_webservices.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kaiodonadelli.desafio3_webservices.R
import com.kaiodonadelli.desafio3_webservices.adapters.HQAdapter
import com.kaiodonadelli.desafio3_webservices.services.repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var HQAdapter: HQAdapter
    lateinit var gridLayoutManager: GridLayoutManager
    lateinit var recyclerViewHQ: RecyclerView

    private val viewModel by viewModels<MainViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(repository) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewHQ = recyclerViewHQTelaPrincipal
        HQAdapter = HQAdapter(this)
        gridLayoutManager = GridLayoutManager(this, 3)
        recyclerViewHQ.adapter = HQAdapter
        recyclerViewHQ.layoutManager = gridLayoutManager

        viewModel.listaHQs.observe(this) {
            it.forEach { HQ ->
                HQAdapter.addHQ(HQ)
            }
        }
        viewModel.getListaHQs()
    }
}