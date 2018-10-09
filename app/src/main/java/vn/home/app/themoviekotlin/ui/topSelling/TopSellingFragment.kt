package vn.home.app.themoviekotlin.ui.topSelling


import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import org.koin.android.viewmodel.ext.android.viewModel
import vn.home.app.themoviekotlin.BR
import vn.home.app.themoviekotlin.base.fragment.BaseLoadMoreRefreshFragment
import vn.home.app.themoviekotlin.data.model.Movie
import vn.home.app.themoviekotlin.databinding.FragmentLoadMoreRefreshBinding

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
        val topSellingAdapter = TopSellingAdapter()
        viewBinding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = topSellingAdapter
        }
    }
}
