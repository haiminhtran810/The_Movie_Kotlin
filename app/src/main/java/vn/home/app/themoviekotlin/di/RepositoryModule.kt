package vn.home.app.themo

import vn.home.app.themoviekotlin.data.constants.Constants

class RepositoryModule {

    fun providerDatabaseName(): String = Constants.DATABASE_NAME

}