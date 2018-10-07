package vn.home.app.themoviekotlin.data.Repository

import io.reactivex.Single
import vn.home.app.themoviekotlin.data.remote.respone.GetMovieListResponse

interface MovieRepository {
    fun getTopRated(page: Int): Single<GetMovieListResponse>
}