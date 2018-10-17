package vn.home.app.themo

import org.koin.dsl.module.module
import vn.home.app.themoviekotlin.data.source.remote.Repository.MovieRepository
import vn.home.app.themoviekotlin.data.source.remote.Repository.impl.MovieRepositoryImpl
import vn.home.app.themoviekotlin.constants.Constants


val getRepositoryModule = module {
    single { providerDatabaseName() }
    single{ MovieRepositoryImpl(get())as MovieRepository }
}

fun providerDatabaseName(): String = Constants.DATABASE_NAME