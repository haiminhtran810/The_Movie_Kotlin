package vn.home.app.themoviekotlin.data.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import io.reactivex.Single
import vn.home.app.themoviekotlin.data.model.Movie

@Dao
interface MovieDao {
    @Query("select * from Movie where id = :id")
    fun findMovieById(id: String): Single<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: Movie)

    @Update
    fun updateMovie(movie: Movie)

    @Delete
    fun deleteMovie(movie: Movie)

    @Query("DELETE from movie")
    fun deleteAll()
}