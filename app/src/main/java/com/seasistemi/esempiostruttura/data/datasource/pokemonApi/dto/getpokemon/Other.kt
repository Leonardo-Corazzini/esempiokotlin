package com.seasistemi.esempiostruttura.data.datasource.pokemonApi.dto.getpokemon

import com.google.gson.annotations.SerializedName

data class Other(
    val dream_world: DreamWorld,
    val home: Home,
    @SerializedName("official-artwork") val officialArtwork: OfficialArtwork,
    val showdown: Showdown
)