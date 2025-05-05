package com.seasistemi.esempiostruttura.domain

import com.seasistemi.esempiostruttura.data.model.Pokemon
import com.seasistemi.esempiostruttura.data.repository.PokemonRepository

class GetListaPokemon (private val repository: PokemonRepository) {
    suspend operator fun invoke(): List<Pokemon>{
        val res = repository.fetchPokemonList()
        return res
    }

}
