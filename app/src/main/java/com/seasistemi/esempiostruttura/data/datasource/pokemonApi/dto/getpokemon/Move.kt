package com.seasistemi.esempiostruttura.data.datasource.pokemonApi.dto.getpokemon

data class Move(
    val move: MoveX,
    val version_group_details: List<VersionGroupDetail>
)