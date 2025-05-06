package com.seasistemi.esempiostruttura.data.datasource.pokemonApi

import com.seasistemi.esempiostruttura.data.datasource.pokemonApi.dto.fetchpokemonlist.PokemonListResponse
import com.seasistemi.esempiostruttura.data.datasource.pokemonApi.dto.getpokemon.GetPokemonResponse

class PokemonRemoteDataSource(private  val api : PokemonApi) {
    suspend fun fetchPokemonList(): PokemonListResponse{
        val response = api.fetchPokemonList()
        return response
    }

    suspend fun getPokemon(nome : String): GetPokemonResponse{
        val response = api.getPokemon(nome)
        return response
    }


}