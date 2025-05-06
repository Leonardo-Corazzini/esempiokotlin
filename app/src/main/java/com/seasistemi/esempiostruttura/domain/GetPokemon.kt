package com.seasistemi.esempiostruttura.domain

import com.seasistemi.esempiostruttura.data.model.DettaglioPokemon
import com.seasistemi.esempiostruttura.data.model.Pokemon
import com.seasistemi.esempiostruttura.data.repository.PokemonRepository

class GetPokemon (private val repository: PokemonRepository) {
    suspend operator fun invoke(nome : String): DettaglioPokemon{
        val res = repository.getPokemon(nome)
        return res
    }

}
