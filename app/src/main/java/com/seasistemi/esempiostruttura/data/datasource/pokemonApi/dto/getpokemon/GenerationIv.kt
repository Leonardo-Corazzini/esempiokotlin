package com.seasistemi.esempiostruttura.data.datasource.pokemonApi.dto.getpokemon

import com.google.gson.annotations.SerializedName

data class GenerationIv(
    @SerializedName ("diamond-pearl") val diamondPearl: DiamondPearl,
    @SerializedName  ("heartgoldSoulsilver") val heartgoldSoulsilver: HeartgoldSoulsilver,
    val platinum: Platinum
)