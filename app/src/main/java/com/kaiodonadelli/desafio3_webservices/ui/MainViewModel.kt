package com.kaiodonadelli.desafio3_webservices.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kaiodonadelli.desafio3_webservices.domain.HQ
import com.kaiodonadelli.desafio3_webservices.services.Repository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

    val listaHQs = MutableLiveData<ArrayList<HQ>>()

    fun getListaHQs() {
        try {
            viewModelScope.launch {
                val response = repository.getListaHQs(
                    "1",
                    "comic",
                    "true",
                    "issueNumber",
                    "aa25bbbc2439c9acce70e02378645e05",
                    "ce9c567fa8eaf4c1e27a9ef2a7cb9dc5",
                    95,
                    10,
                )

                val results = response.get("data").asJsonObject.get("results")
                val comics = Gson().fromJson(
                    results,
                    object : TypeToken<List<HQ>>() {}.type
                ) as ArrayList<HQ>

                listaHQs.value = comics
            }
        } catch (e: Exception) {
            throw java.lang.Exception()
        }
    }
}