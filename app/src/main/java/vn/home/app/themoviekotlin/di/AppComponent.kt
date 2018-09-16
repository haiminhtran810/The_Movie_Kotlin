package vn.home.app.themoviekotlin.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import vn.home.app.themoviekotlin.MainApplication
import javax.inject.Singleton

//https://medium.com/@malinitin/setup-dagger-2-11-on-kotlin-project-2257ad84ad7c
@Component(modules = arrayOf(AppModule::class, AndroidInjectionModule::class, ActivityBuilder::class))
@Singleton
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: MainApplication)
}