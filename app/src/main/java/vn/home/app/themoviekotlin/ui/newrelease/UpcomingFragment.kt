package vn.home.app.themoviekotlin.ui.newrelease

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import org.koin.android.viewmodel.ext.android.viewModel
import vn.home.app.themoviekotlin.BR
import vn.home.app.themoviekotlin.base.fragment.BaseLoadMoreRefreshFragment
import vn.home.app.themoviekotlin.data.model.Movie
import vn.home.app.themoviekotlin.databinding.FragmentLoadMoreRefreshBinding
import vn.home.app.themoviekotlin.ui.topSelling.TopSellingAdapter

class UpcomingFragment : BaseLoadMoreRefreshFragment<FragmentLoadMoreRefreshBinding, UpcomingViewModel, Movie>(), UpcomingNavigator {

    companion object {
        const val TAG = "UpcomingFragment"
        fun instance() = UpcomingFragment()
    }

    override val viewModel by viewModel<UpcomingViewModel>()

    override val bindingVariable: Int
        get() = BR.viewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setAdapterUpComing()
        viewModel.apply {
            listItem.observe(this@UpcomingFragment, Observer {
                var adapter = viewBinding.recyclerView.adapter
                if (adapter is TopSellingAdapter) {
                    adapter.submitList(it)
                }
            })
            firstLoad()
        }
    }

    private fun setAdapterUpComing() {
        val upComingAdapter = TopSellingAdapter({ menuItem -> onClickItemMore(menuItem) }, { movie -> onClickItem(movie) })
        viewBinding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = upComingAdapter
        }
    }

    fun onClickItemMore(menuItem: MenuItem) {
        val a = menuItem
    }

    fun onClickItem(movie: Movie) {
        val a = movie
    }
}