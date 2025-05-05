package com.seasistemi.esempiostruttura.data.datasource.pokemonApi

import com.seasistemi.esempiostruttura.data.datasource.pokemonApi.dto.fetchpokemonlist.PokemonListResponse

class PokemonRemoteDataSource(private  val api : PokemonApi) {
    suspend fun fetchPokemonList(): PokemonListResponse{
        val response = api.fetchPokemonList()
        return response
    }

}