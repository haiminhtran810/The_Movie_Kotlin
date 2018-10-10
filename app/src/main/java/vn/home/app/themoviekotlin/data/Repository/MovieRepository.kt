package vn.home.app.themoviekotlin.data.Repository

import io.reactivex.Single
import vn.home.app.themoviekotlin.data.model.Movie
import vn.home.app.themoviekotlin.data.remote.respone.GetGenreListResponse
import vn.home.app.themoviekotlin.data.remote.respone.GetMovieListResponse

interface MovieRepository {
    fun getTopRated(page: Int): Single<GetMovieListResponse>
    fun getGenres(): Single<GetGenreListResponse>
    fun findMovieById(id: String): Single<Movie>
    fun insertMovie(movie: Movie, fail: (Throwable) -> Unit = {})
}