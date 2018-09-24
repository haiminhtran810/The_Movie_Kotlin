package vn.home.app.themoviekotlin.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import vn.home.app.themoviekotlin.MainActivity

@Module
abstract class MainActivityModule {

    // tự động gen ra 1 FragmentbuildersModuleComponent to tiem vào Fragment hay Activity Chỉ sử dụng cho Activity và Fragment

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity
}