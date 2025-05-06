package com.seasistemi.esempiostruttura.data.datasource.pokemonApi.dto.getpokemon

import com.google.gson.annotations.SerializedName

data class GenerationVi(
    @SerializedName ("omegaruby-alphasapphire") val omegarubyAlphasapphire: OmegarubyAlphasapphire,
    @SerializedName ("x-y") val xy: XY

)