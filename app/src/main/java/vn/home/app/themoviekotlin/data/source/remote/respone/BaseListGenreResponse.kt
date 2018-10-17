package vn.home.app.themoviekotlin.data.source.remote.respone

import com.google.gson.annotations.SerializedName
import vn.home.app.themoviekotlin.data.model.Genre

open class BaseListGenreResponse<T> {
    @SerializedName("genres")
    var genres = ArrayList<Genre>()
}