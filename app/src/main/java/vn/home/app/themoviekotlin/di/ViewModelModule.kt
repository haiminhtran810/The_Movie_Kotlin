package vn.home.app.themoviekotlin.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import vn.home.app.themoviekotlin.MainActivityViewModel
import vn.home.app.themoviekotlin.ui.main.MainViewModel
import vn.home.app.themoviekotlin.ui.welcome.WelcomeViewModel

@Suppress("unused")
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

    @Binds
    @IntoMap
    @ViewModelKey(WelcomeViewModel::class)
    abstract fun bindWelcomeViewModel(welcomeViewModel: WelcomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel
}