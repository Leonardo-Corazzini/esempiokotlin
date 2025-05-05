package com.seasistemi.esempiostruttura.data.datasource.pokemonApi.dto.fetchpokemonlist

data class PokemonListResponse(
    val count : Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonListResponseResult>
)
