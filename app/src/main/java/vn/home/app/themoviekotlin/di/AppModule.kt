
package vn.home.app.themoviekotlin.di

import android.app.Application
import android.content.Context
import android.content.res.Resources
import org.koin.dsl.module.module
import vn.home.app.themoviekotlin.MainApplication

fun getAppModule() = module(override = true) {
    single { provideApplication(get()) }
    single { provideResource(get()) }
    single { provideContext(get()) }
}

fun provideApplication(mainApplication: MainApplication): MainApplication = mainApplication

fun provideResource(application: Application): Resources = application.resources

fun provideContext(application: Application): Context = application