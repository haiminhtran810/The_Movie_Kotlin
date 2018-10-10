package vn.home.app.themoviekotlin.ui.topSelling

import vn.home.app.themoviekotlin.base.viewmodel.BaseLoadMoreRefreshViewModel
import vn.home.app.themoviekotlin.data.Repository.MovieRepository
import vn.home.app.themoviekotlin.data.model.Movie

class TopSellingViewModel constructor(var movieRepository: MovieRepository) : BaseLoadMoreRefreshViewModel<Movie, TopSellingNavigator>() {

    override fun loadData(page: Int) {
        movieRepository.getTopRated(page).subscribe({
            currentPage.value = page
            if (currentPage.value == 1) listItem.value?.clear()
            if (isRefreshing.value == true) resetLoadMore()
            val newList = listItem.value ?: arrayListOf()
            newList.addAll(it.results ?: arrayListOf())
            listItem.value = newList
            onLoadSuccess(it.results?.size ?: 0)
        }, {
            onLoadFail(it)
            val message = it.message
        })
    }

    fun insetMovie(movie: Movie) {
        movieRepository.insertMovie(movie)
    }

    fun findMovieById(id: String) {
        movieRepository.findMovieById(id).subscribe({
            val a = it
        }, {
            val a = it.message
        })
    }
}