package vn.home.app.themoviekotlin.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import vn.home.app.themoviekotlin.ui.welcome.WelcomeFragment

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributesWelcomFragment(): WelcomeFragment

}