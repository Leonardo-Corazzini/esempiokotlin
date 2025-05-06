package com.seasistemi.esempiostruttura.data.datasource.pokemonApi

import com.seasistemi.esempiostruttura.data.datasource.pokemonApi.dto.fetchpokemonlist.PokemonListResponse
import com.seasistemi.esempiostruttura.data.datasource.pokemonApi.dto.getpokemon.GetPokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {
    @GET("pokemon?limit=100000&offset=0")
    suspend fun fetchPokemonList(): PokemonListResponse

    @GET("pokemon/{nome}")
    suspend fun getPokemon(@Path("nome") nome: String): GetPokemonResponse
}