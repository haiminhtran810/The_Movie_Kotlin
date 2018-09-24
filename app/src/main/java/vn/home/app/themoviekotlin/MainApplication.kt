package vn.home.app.themoviekotlin

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import vn.home.app.themoviekotlin.di.AppComponent
import vn.home.app.themoviekotlin.di.DaggerAppComponent


//Generate graph object
class MainApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }

}