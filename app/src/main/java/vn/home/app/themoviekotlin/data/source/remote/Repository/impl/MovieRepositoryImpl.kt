package vn.home.app.themoviekotlin.data.source.remote.Repository.impl

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import vn.home.app.themoviekotlin.data.source.remote.Repository.MovieRepository
import vn.home.app.themoviekotlin.data.source.remote.ApiService
import vn.home.app.themoviekotlin.data.source.remote.respone.GetGenreListResponse
import vn.home.app.themoviekotlin.data.source.remote.respone.GetMovieListResponse
import vn.home.app.themoviekotlin.data.source.remote.respone.GetUpComingListResponse

class MovieRepositoryImpl constructor(val apiService: ApiService) : MovieRepository {
    override fun getMovieUpComing(page: Int): Single<GetUpComingListResponse> {
        return apiService.getMovieUpComing(page).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }

    override fun getGenres(): Single<GetGenreListResponse> {
        return apiService.getGenres().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }

    override fun getTopRated(page: Int): Single<GetMovieListResponse> {
        return apiService.getTopRated(page).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }
}