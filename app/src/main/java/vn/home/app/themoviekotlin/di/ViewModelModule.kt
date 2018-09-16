package vn.home.app.themoviekotlin.di

import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(providerFactory: ViewModelProviderFactory): ViewModelProvider.Factory
}