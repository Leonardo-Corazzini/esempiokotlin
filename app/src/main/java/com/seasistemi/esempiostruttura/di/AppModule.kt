package com.seasistemi.esempiostruttura.di

import com.seasistemi.esempiostruttura.data.datasource.pokemonApi.ApiClient
import com.seasistemi.esempiostruttura.data.datasource.pokemonApi.PokemonRemoteDataSource
import com.seasistemi.esempiostruttura.data.repository.PokemonRepository
import com.seasistemi.esempiostruttura.domain.AppUseCases
import com.seasistemi.esempiostruttura.domain.GetListaPokemon
import com.seasistemi.esempiostruttura.domain.GetPokemon
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providePokemonRemoteDataSource(): PokemonRemoteDataSource{
        return PokemonRemoteDataSource(ApiClient.pokemonApi)
    }

    @Singleton
    @Provides
    fun providePokemonRepository(
        pokemonRemoteDataSource: PokemonRemoteDataSource
    ): PokemonRepository {
        return PokemonRepository(pokemonRemoteDataSource)
    }

    @Singleton
    @Provides
    fun provideUseCases(
        pokemonRepository: PokemonRepository
    ): AppUseCases {
        return AppUseCases(
            getListaPokemon = GetListaPokemon(pokemonRepository),
            getPokemon = GetPokemon(pokemonRepository)
        )
    }
}