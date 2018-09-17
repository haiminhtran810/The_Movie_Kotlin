package vn.home.app.themoviekotlin

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import vn.home.app.themoviekotlin.di.DaggerAppComponent
import javax.inject.Inject


//Generate graph object
class MainApplication : Application(), HasActivityInjector {

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().application(this).build().inject(this)
    }

    @Inject
    lateinit var activityInjector : DispatchingAndroidInjector<Activity>

}