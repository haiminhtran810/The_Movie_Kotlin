package vn.home.app.themoviekotlin.di

import dagger.Module
import dagger.Provides
import vn.home.app.themoviekotlin.data.constants.Constants
import javax.inject.Named
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    @Named("database_name")
    fun providerDatabaseName(): String = Constants.DATABASE_NAME

}