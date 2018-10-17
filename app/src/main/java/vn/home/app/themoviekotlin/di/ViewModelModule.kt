package vn.home.app.themoviekotlin.di

import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import vn.home.app.themoviekotlin.MainActivityViewModel
import vn.home.app.themoviekotlin.ui.genres.GenresViewModel
import vn.home.app.themoviekotlin.ui.main.MainViewModel
import vn.home.app.themoviekotlin.ui.newrelease.UpcomingViewModel
import vn.home.app.themoviekotlin.ui.topSelling.TopSellingViewModel
import vn.home.app.themoviekotlin.ui.welcome.WelcomeViewModel


val viewModelModule = module(override = true) {

    viewModel { MainActivityViewModel() }

    viewModel { WelcomeViewModel() }

    viewModel { MainViewModel() }

    viewModel { TopSellingViewModel(get()) }

    viewModel { GenresViewModel(get()) }

    viewModel { UpcomingViewModel(get()) }

}
