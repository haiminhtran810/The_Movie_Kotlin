package vn.home.app.themoviekotlin.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import vn.home.app.themoviekotlin.MainApplication
import javax.inject.Singleton

//https://medium.com/@malinitin/setup-dagger-2-11-on-kotlin-project-2257ad84ad7c
//https://blog.mindorks.com/the-new-dagger-2-android-injector-cbe7d55afa6a
@Singleton
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        AppModule::class,
        MainActivityModule::class))
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(mainApplication: MainApplication)
}