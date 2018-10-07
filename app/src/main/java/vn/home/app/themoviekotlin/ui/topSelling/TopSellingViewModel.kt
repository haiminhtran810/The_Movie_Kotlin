package vn.home.app.themoviekotlin.ui.topSelling

import vn.home.app.themoviekotlin.base.viewmodel.BaseViewModel
import vn.home.app.themoviekotlin.data.Repository.MovieRepository

class TopSellingViewModel constructor(var movieRepository: MovieRepository) : BaseViewModel<TopSellingNavigator>() {
    init {
    }

    fun getDataTop() {
        movieRepository.getTopRated(1).subscribe({
            val data =  it
        },{
            val message = it.message
        })
    }
}