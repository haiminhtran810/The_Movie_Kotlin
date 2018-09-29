package vn.home.app.themo

import org.koin.dsl.module.module
import vn.home.app.themoviekotlin.data.Repository.MovieRepository
import vn.home.app.themoviekotlin.data.Repository.impl.MovieRepositoryImpl
import vn.home.app.themoviekotlin.data.constants.Constants


val getRepositoryModule = module {
    single { providerDatabaseName() }
    single<MovieRepository> { MovieRepositoryImpl(get()) }
}

fun providerDatabaseName(): String = Constants.DATABASE_NAME