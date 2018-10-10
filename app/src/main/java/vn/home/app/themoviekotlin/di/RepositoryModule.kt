package vn.home.app.themo

import android.arch.persistence.room.Room
import android.content.Context
import org.koin.dsl.module.module
import vn.home.app.themoviekotlin.data.Repository.MovieRepository
import vn.home.app.themoviekotlin.data.Repository.impl.MovieRepositoryImpl
import vn.home.app.themoviekotlin.data.constants.Constants
import vn.home.app.themoviekotlin.data.local.AppDataBase


val getRepositoryModule = module {
    single { providerDatabaseName() }
    single { MovieRepositoryImpl(get(),get()) as MovieRepository }
    single { createAppDatabase(get(), get()) }
    single { createMovieDao(get()) }
}

fun providerDatabaseName(): String = Constants.DATABASE_NAME

fun createAppDatabase(context: Context, dbName: String) = Room.databaseBuilder(context,
        AppDataBase::class.java, "database-name").build()

fun createMovieDao(appDataBase: AppDataBase) = appDataBase.movieDao()