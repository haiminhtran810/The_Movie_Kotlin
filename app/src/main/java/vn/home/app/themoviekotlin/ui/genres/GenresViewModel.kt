package vn.home.app.themoviekotlin.ui.genres

import android.arch.lifecycle.MutableLiveData
import vn.home.app.themoviekotlin.base.viewmodel.BaseViewModel
import vn.home.app.themoviekotlin.data.Repository.MovieRepository
import vn.home.app.themoviekotlin.data.model.Genre
import java.util.ArrayList

class GenresViewModel constructor(var movieRepository: MovieRepository) : BaseViewModel<GenresNavigator>() {
    var listData = MutableLiveData<ArrayList<Genre>>()
    fun getGenresData() {
        movieRepository.getGenres().subscribe({
            listData.value = it.genres
        }, {
        })
    }
}