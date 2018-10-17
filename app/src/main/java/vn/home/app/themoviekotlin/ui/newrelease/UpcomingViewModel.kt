package vn.home.app.themoviekotlin.ui.newrelease

import vn.home.app.themoviekotlin.base.viewmodel.BaseLoadMoreRefreshViewModel
import vn.home.app.themoviekotlin.base.viewmodel.BaseViewModel
import vn.home.app.themoviekotlin.data.Repository.MovieRepository
import vn.home.app.themoviekotlin.data.model.Movie

class UpcomingViewModel constructor(var movieRepository: MovieRepository) : BaseLoadMoreRefreshViewModel<Movie, UpcomingNavigator>() {
    override fun loadData(page: Int) {
        movieRepository.getMovieUpComing(page).subscribe({
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
}