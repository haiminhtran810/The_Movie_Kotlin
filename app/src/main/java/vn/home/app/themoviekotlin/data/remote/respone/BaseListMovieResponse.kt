package vn.home.app.themoviekotlin.data.remote.respone

import com.google.gson.annotations.SerializedName
import vn.home.app.themoviekotlin.data.model.Dates
import vn.home.app.themoviekotlin.data.model.Movie
import java.util.ArrayList

open class BaseListMovieResponse<T> {
    @SerializedName("page")
    var page: Int? = 0
    @SerializedName("total_results")
    var total_results: Int? = null
    @SerializedName("total_pages")
    var total_pages: Int? = null
    @SerializedName("results")
    var results = ArrayList<Movie>()
    @SerializedName("dates")
    var dates: Dates? = null
}
