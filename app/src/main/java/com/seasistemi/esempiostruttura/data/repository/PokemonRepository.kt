package com.seasistemi.esempiostruttura.data.repository


import com.seasistemi.esempiostruttura.data.datasource.pokemonApi.PokemonRemoteDataSource
import com.seasistemi.esempiostruttura.data.model.DettaglioPokemon
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
    suspend fun getPokemon(nome : String): DettaglioPokemon{
        val res = pokemonRemoteDataSource.getPokemon(nome)

        return DettaglioPokemon(
            nome = res.name,
            altezza = res.height,
            peso = res.weight,
            numeroPokedex = res.id,
            tipo = res.types.joinToString(separator = ", ", transform = { it.type.name }) ,
            urlImg = res.sprites.front_default

        )
    }
}