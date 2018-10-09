package vn.home.app.themoviekotlin.base.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.support.v4.widget.SwipeRefreshLayout
import vn.home.app.themoviekotlin.utils.Constants
import vn.home.app.themoviekotlin.widgets.EndlessRecycleOnScrollListener

abstract class BaseLoadMoreRefreshViewModel<Item, Navigator> : BaseViewModel<Navigator>() {
    val isRefreshing = MutableLiveData<Boolean>().apply { value = false }
    val onRefreshListener = SwipeRefreshLayout.OnRefreshListener {
        if (isLoading.value == true
                || isRefreshing.value == true) return@OnRefreshListener
        isRefreshing.value = true
        refreshData()
    }
    val isLoadMore = MutableLiveData<Boolean>().apply { value = false }
    var currentPage = MutableLiveData<Int>().apply { value = 0 }
    var isLastPage = MutableLiveData<Boolean>().apply { value = false }

    val onScrollListener = object : EndlessRecycleOnScrollListener(
            getLoadMoreThreshold()) {
        override fun onLoadMore() {
            if (isLoading.value == true
                    || isRefreshing.value == true
                    || isLoadMore.value == true
                    || isLastPage.value == true) return
            isLoadMore.value = true
            loadMore()
        }
    }
    val listItem = MutableLiveData<ArrayList<Item>>()

    abstract fun loadData(page: Int)

    fun isFirst() = currentPage.value == 0
            && (listItem.value == null || listItem.value?.size == 0)

    fun firstLoad() {
        if (isFirst()) {
            isLoading.value = true
            loadData(1)
        }
    }

    fun refreshData() {
        loadData(1)
    }

    fun loadMore() {
        loadData(currentPage.value?.plus(1) ?: 1)
    }

    fun getLoadMoreThreshold() = Constants.DEFAULT_NUM_VISIBLE_THRESHOLD

    fun getNumberItemPerPage() = Constants.DEFAULT_LIMIT

    fun resetLoadMore() {
        onScrollListener.resetOnLoadMore()
        isLastPage.value = false
    }

    fun onLoadSuccess(listItemSize: Int) {
        isLastPage.value = listItemSize < getNumberItemPerPage()
        isLoading.value = false
        isRefreshing.value = false
        isLoadMore.value = false
    }

    fun onLoadFail(it: Throwable) {
        isLoading.value = false
        isRefreshing.value = false
        isLoadMore.value = false
    }
}