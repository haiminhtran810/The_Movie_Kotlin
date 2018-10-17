package vn.home.app.themoviekotlin.data.Repository

import io.reactivex.Single
import vn.home.app.themoviekotlin.data.remote.respone.GetGenreListResponse
import vn.home.app.themoviekotlin.data.remote.respone.GetMovieListResponse
import vn.home.app.themoviekotlin.data.remote.respone.GetUpComingListResponse

interface MovieRepository {
    fun getTopRated(page: Int): Single<GetMovieListResponse>
    fun getGenres(): Single<GetGenreListResponse>
    fun getMovieUpComing(page: Int):Single<GetUpComingListResponse>
}