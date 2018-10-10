package vn.home.app.themoviekotlin.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import vn.home.app.themoviekotlin.data.model.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}