package vn.home.app.themoviekotlin.di

import android.app.Application
import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import vn.home.app.themoviekotlin.MainApplication
import javax.inject.Singleton

@Module(
        includes = [
            ViewModelModule::class,
            ApiModule::class,
            RepositoryModule::class
        ])
class AppModule {

    @Provides
    @Singleton
    fun provideApplication(mainApplication: MainApplication): MainApplication = mainApplication

    @Provides
    @Singleton
    fun provideResource(application: Application): Resources = application.resources

    @Provides
    @Singleton
    fun provideContext(application: Application): Context = application
}