package com.seasistemi.esempiostruttura.data.datasource.pokemonApi

import com.seasistemi.esempiostruttura.data.datasource.pokemonApi.dto.fetchpokemonlist.PokemonListResponse
import retrofit2.http.GET

interface PokemonApi {
    @GET("pokemon")
    suspend fun fetchPokemonList(): PokemonListResponse
}