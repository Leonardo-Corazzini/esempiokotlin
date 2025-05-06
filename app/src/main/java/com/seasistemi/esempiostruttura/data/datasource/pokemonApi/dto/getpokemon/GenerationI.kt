package com.seasistemi.esempiostruttura.data.datasource.pokemonApi.dto.getpokemon

import com.google.gson.annotations.SerializedName

data class GenerationI(
    @SerializedName("red-blue") val redBlue: RedBlue,
    val yellow: Yellow
)