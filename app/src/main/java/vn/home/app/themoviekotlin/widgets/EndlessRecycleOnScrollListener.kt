package vn.home.app.themoviekotlin.widgets

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import vn.home.app.themoviekotlin.utils.Constants

abstract class EndlessRecycleOnScrollListener(threshold: Int) : RecyclerView.OnScrollListener() {
    // The total number of items in the dataset after the last load
    private var mPreviousTotal: Int = 0
    private var isLoading = true
    private var mFirstVisibleItem: Int = 0
    private var mVisibleItemCount: Int = 0
    private var mTotalItemCount: Int = 0
    private var mNumberThreshold: Int = -1

    init {
        if (threshold >= 1) {
            mNumberThreshold = threshold
        } else {
            mNumberThreshold = Constants.DEFAULT_NUM_VISIBLE_THRESHOLD
        }
    }

    override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        mVisibleItemCount = recyclerView?.childCount!!
        mTotalItemCount = recyclerView.layoutManager.itemCount
        if (recyclerView.layoutManager is LinearLayoutManager) {
            mFirstVisibleItem = (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
        } else if (recyclerView.layoutManager is GridLayoutManager) {
            mFirstVisibleItem = (recyclerView.layoutManager as GridLayoutManager).findFirstVisibleItemPosition()
        } else {
            throw RuntimeException("Un support this kind of LayoutManager ")
        }

        if (isLoading) {
            stateLoading()
        }

        if (!isLoading && mTotalItemCount - mVisibleItemCount <= mFirstVisibleItem + mNumberThreshold) {
            onLoadMore()
            isLoading = true
        }
    }

    private fun stateLoading() {
        if (mTotalItemCount > mPreviousTotal) {
            isLoading = false
            mPreviousTotal = mTotalItemCount
        }
    }


    fun resetOnLoadMore() {
        mFirstVisibleItem = 0
        mVisibleItemCount = 0
        mTotalItemCount = 0
        mPreviousTotal = 0
        isLoading = true
    }

    abstract fun onLoadMore()
}