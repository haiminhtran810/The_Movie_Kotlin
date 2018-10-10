package vn.home.app.themoviekotlin.ui.topSelling


import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.PopupMenu
import android.view.MenuItem
import org.koin.android.viewmodel.ext.android.viewModel
import vn.home.app.themoviekotlin.BR
import vn.home.app.themoviekotlin.base.fragment.BaseLoadMoreRefreshFragment
import vn.home.app.themoviekotlin.data.model.Movie
import vn.home.app.themoviekotlin.databinding.FragmentLoadMoreRefreshBinding
import vn.home.app.themoviekotlin.R.id.menu3
import vn.home.app.themoviekotlin.R.id.menu2
import vn.home.app.themoviekotlin.R.id.menu1


class TopSellingFragment : BaseLoadMoreRefreshFragment<FragmentLoadMoreRefreshBinding, TopSellingViewModel, Movie>(), TopSellingNavigator {
    companion object {
        const val TAG = "TopSellingFragment"
        fun instance() = TopSellingFragment()
    }

    override val viewModel by viewModel<TopSellingViewModel>()
    override val bindingVariable: Int
        get() = BR.viewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setAdapterTopSelling()
        viewModel.apply {
            listItem.observe(this@TopSellingFragment, Observer {
                var adapter = viewBinding.recyclerView.adapter
                if (adapter is TopSellingAdapter) {
                    adapter.submitList(it)
                }
            })
            firstLoad()
        }
    }

    private fun setAdapterTopSelling() {
        val topSellingAdapter = TopSellingAdapter({ menuItem -> onClickItemMore(menuItem) }, { movie -> onClickItem(movie) })
        viewBinding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = topSellingAdapter
        }
    }

    fun onClickItemMore(menuItem: MenuItem) {
        val a = menuItem
    }

    fun onClickItem(movie: Movie) {
        val a = movie
    }
}
