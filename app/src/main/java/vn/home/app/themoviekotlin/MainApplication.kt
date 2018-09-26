package vn.home.app.themoviekotlin

import android.app.Application
import org.koin.android.ext.android.startKoin
import vn.home.app.themoviekotlin.di.*

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(
                getApiModule(),
                getAppModule(),
                viewModelModule
        ))
    }

}