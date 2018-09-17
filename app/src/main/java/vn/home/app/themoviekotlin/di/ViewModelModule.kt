package vn.home.app.themoviekotlin.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import vn.home.app.themoviekotlin.MainActivityViewModel

@Module
abstract class ViewModelModule {

    // Binds : tự trả về mà ko cần return như Provides
    // Ko tự động gen ra như ContributesAndroidInjector
    @Binds
    abstract fun bindViewModelFactory(
            providerFactory: ViewModelProviderFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMainActivityViewModel(mainActivityViewModel: MainActivityViewModel): ViewModel
}