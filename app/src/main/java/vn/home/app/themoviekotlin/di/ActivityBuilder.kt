package vn.home.app.themoviekotlin.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import vn.home.app.themoviekotlin.MainActivity

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}