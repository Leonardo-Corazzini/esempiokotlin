package com.seasistemi.esempiostruttura.data.datasource.pokemonApi.dto.getpokemon

data class HeldItem(
    val item: Item,
    val version_details: List<VersionDetail>
)