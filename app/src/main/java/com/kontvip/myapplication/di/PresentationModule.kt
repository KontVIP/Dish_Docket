package com.kontvip.myapplication.di

import com.kontvip.myapplication.presentation.UiStateExceptionFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class PresentationModule {

    @Provides
    fun provideStateExceptionFactory(): UiStateExceptionFactory = UiStateExceptionFactory()

}