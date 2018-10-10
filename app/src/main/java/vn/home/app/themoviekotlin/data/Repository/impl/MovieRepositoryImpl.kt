package vn.home.app.themoviekotlin.data.Repository.impl

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import vn.home.app.themoviekotlin.data.Repository.MovieRepository
import vn.home.app.themoviekotlin.data.local.MovieDao
import vn.home.app.themoviekotlin.data.model.Movie
import vn.home.app.themoviekotlin.data.remote.ApiService
import vn.home.app.themoviekotlin.data.remote.respone.GetGenreListResponse
import vn.home.app.themoviekotlin.data.remote.respone.GetMovieListResponse

class MovieRepositoryImpl constructor(val apiService: ApiService, val movieDao: MovieDao) : MovieRepository {
    override fun findMovieById(id: String): Single<Movie> {
        return movieDao.findMovieById(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }

    override fun insertMovie(movie: Movie, fail: (Throwable) -> Unit) {
        try {
            movieDao.insertMovie(movie)
        } catch (e: Throwable) {
            fail(e)
        }
    }

    override fun getGenres(): Single<GetGenreListResponse> {
        return apiService.getGenres().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }

    override fun getTopRated(page: Int): Single<GetMovieListResponse> {
        return apiService.getTopRated(page).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }

}