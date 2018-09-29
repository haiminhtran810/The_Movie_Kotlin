package vn.home.app.themoviekotlin.data.remote.respone

import com.google.gson.annotations.SerializedName
import vn.home.app.themoviekotlin.data.Model.Movie
import java.util.ArrayList

open class BaseListMovieReponse<T> {
    @SerializedName("page")
    var page: Int? = 0
    @SerializedName("total_results")
    var total_results: Int? = null
    @SerializedName("total_pages")
    var total_pages: Int? = null
    @SerializedName("results")
    var results = ArrayList<Movie>()
}
