package vn.home.app.themoviekotlin.di

import android.app.Application
import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
        includes = arrayOf(ViewModelModule::class, ApiModule::class))
class AppModule {
    @Provides
    @Singleton
    fun provideResource(application: Application): Resources = application.resources

    @Provides
    @Singleton
    fun provideContext(application: Application): Context = application
}