package vn.home.app.themoviekotlin

import android.app.Application
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.module
import vn.home.app.themoviekotlin.di.ApiModule
import vn.home.app.themoviekotlin.di.AppModule
import vn.home.app.themoviekotlin.di.viewModelModule

class MainApplication : Application() {
    fun getModule() = module {
        ApiModule().getModule()
        AppModule().getContextModule()
        viewModelModule
    }

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(getModule()))
    }

}