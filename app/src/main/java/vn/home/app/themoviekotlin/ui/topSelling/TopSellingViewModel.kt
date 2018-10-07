package vn.home.app.themoviekotlin.ui.topSelling

import android.arch.lifecycle.MutableLiveData
import vn.home.app.themoviekotlin.base.viewmodel.BaseViewModel
import vn.home.app.themoviekotlin.data.Repository.MovieRepository
import vn.home.app.themoviekotlin.data.model.Movie

class TopSellingViewModel constructor(var movieRepository: MovieRepository) : BaseViewModel<TopSellingNavigator>() {
    var listTopSelling = MutableLiveData<ArrayList<Movie>>()

    init {
    }

    fun getDataTop(page: Int) {
        movieRepository.getTopRated(page).subscribe({
            listTopSelling.value = it.results
        }, {
            val message = it.message
        })
    }
}