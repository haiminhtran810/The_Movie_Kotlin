package vn.home.app.themoviekotlin.data.remote

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import vn.home.app.themoviekotlin.data.remote.respone.GetGenreListResponse
import vn.home.app.themoviekotlin.data.remote.respone.GetMovieListResponse

interface ApiService {
    @GET("movie/top_rated")
    fun getTopRated(@Query("page") page: Int): Single<GetMovieListResponse>

    @GET("genre/movie/list")
    fun getGenres(): Single<GetGenreListResponse>
}

object ApiParams {
    const val PAGE = "page"
    const val SORT_BY = "sort_by"
    const val POPULARITY_DESC = "popularity.desc"
    const val VOTE_AVERAGE_DESC = "vote_average.desc"
}