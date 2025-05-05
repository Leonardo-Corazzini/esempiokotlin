package com.seasistemi.esempiostruttura.data.repository


import com.seasistemi.esempiostruttura.data.datasource.pokemonApi.PokemonRemoteDataSource
import com.seasistemi.esempiostruttura.data.model.Pokemon

class PokemonRepository(
    private val pokemonRemoteDataSource: PokemonRemoteDataSource
) {
    suspend fun fetchPokemonList(): List<Pokemon>{
        val res = pokemonRemoteDataSource.fetchPokemonList()

        return res.results.map {
            Pokemon(
                it.name
            )
        }
    }
}