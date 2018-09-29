package vn.home.app.themoviekotlin.data.Repository.impl

import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import vn.home.app.themoviekotlin.data.Repository.MovieRepository
import vn.home.app.themoviekotlin.data.remote.ApiService
import vn.home.app.themoviekotlin.data.remote.respone.GetMovieListReponse

class MovieRepositoryImpl constructor(val apiService: ApiService) : MovieRepository {
    override fun getTopRated(page: Int): Single<GetMovieListReponse> {
        return apiService.getTopRated(page).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }
}