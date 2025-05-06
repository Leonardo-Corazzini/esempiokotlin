package com.seasistemi.esempiostruttura.data.datasource.pokemonApi.dto.getpokemon

import com.google.gson.annotations.SerializedName

data class GenerationV(
    @SerializedName ("black-white") val blackWhite: BlackWhite
)