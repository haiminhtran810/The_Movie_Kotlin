package vn.home.app.themoviekotlin.data.source.remote

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import vn.home.app.themoviekotlin.data.source.remote.respone.GetGenreListResponse
import vn.home.app.themoviekotlin.data.source.remote.respone.GetMovieListResponse
import vn.home.app.themoviekotlin.data.source.remote.respone.GetUpComingListResponse

interface ApiService {
    @GET("movie/top_rated")
    fun getTopRated(@Query(ApiParams.PAGE) page: Int): Single<GetMovieListResponse>

    @GET("genre/movie/list")
    fun getGenres(): Single<GetGenreListResponse>

    @GET("movie/upcoming")
    fun getMovieUpComing(@Query(ApiParams.PAGE) page: Int): Single<GetUpComingListResponse>
}

object ApiParams {
    const val PAGE = "page"
    const val SORT_BY = "sort_by"
    const val POPULARITY_DESC = "popularity.desc"
    const val VOTE_AVERAGE_DESC = "vote_average.desc"
}