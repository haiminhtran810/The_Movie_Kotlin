package vn.home.app.themoviekotlin.data.source.remote.Repository

import io.reactivex.Single
import vn.home.app.themoviekotlin.data.source.remote.respone.GetGenreListResponse
import vn.home.app.themoviekotlin.data.source.remote.respone.GetMovieListResponse
import vn.home.app.themoviekotlin.data.source.remote.respone.GetUpComingListResponse

interface MovieRepository {
    fun getTopRated(page: Int): Single<GetMovieListResponse>
    fun getGenres(): Single<GetGenreListResponse>
    fun getMovieUpComing(page: Int):Single<GetUpComingListResponse>
}