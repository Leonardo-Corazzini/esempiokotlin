package com.seasistemi.esempiostruttura.data.datasource.pokemonApi


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {
    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    val pokemonApi: PokemonApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/") // <-- Cambia con il tuo URL
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(PokemonApi::class.java)
    }
}
