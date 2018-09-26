package vn.home.app.themoviekotlin.di

import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import vn.home.app.themoviekotlin.MainActivityViewModel
import vn.home.app.themoviekotlin.ui.main.MainViewModel
import vn.home.app.themoviekotlin.ui.welcome.WelcomeViewModel


val viewModelModule = module(override = true) {

    viewModel { MainActivityViewModel() }

    viewModel { WelcomeViewModel() }

    viewModel { MainViewModel() }

}
