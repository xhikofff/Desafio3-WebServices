package com.kaiodonadelli.desafio3_webservices.services

import com.google.gson.JsonObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Repository {

    @GET("characters/1009610/comics")
    suspend fun getListaHQs(
        @Query("ts") ts: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,

        ): JsonObject

}


const val urlApiMarvel = "https://gateway.marvel.com:443/v1/public/"

val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl(urlApiMarvel)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val repository: Repository = retrofit.create(Repository::class.java)