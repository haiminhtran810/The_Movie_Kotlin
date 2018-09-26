package vn.home.app.themoviekotlin.di

import android.app.Application
import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import org.koin.dsl.module.module
import vn.home.app.themoviekotlin.MainApplication
import javax.inject.Singleton

class AppModule {
    fun getContextModule() = module {
        factory { provideApplication(get()) }
        factory { provideResource(get()) }
        factory { provideContext(get()) }
    }

    fun provideApplication(mainApplication: MainApplication): MainApplication = mainApplication

    fun provideResource(application: Application): Resources = application.resources

    fun provideContext(application: Application): Context = application
}