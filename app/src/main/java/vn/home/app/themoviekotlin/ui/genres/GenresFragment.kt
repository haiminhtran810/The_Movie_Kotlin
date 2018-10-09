package vn.home.app.themoviekotlin.ui.genres

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.android.databinding.library.baseAdapters.BR
import org.koin.android.viewmodel.ext.android.viewModel
import vn.home.app.themoviekotlin.R
import vn.home.app.themoviekotlin.base.fragment.BaseFragment
import vn.home.app.themoviekotlin.databinding.FragmentTopSellingBinding

class GenresFragment : BaseFragment<FragmentTopSellingBinding, GenresViewModel>(), GenresNavigator {

    companion object {
        val TAG = "GenresFragment"
        fun instance() = GenresFragment()
    }

    override val viewModel by viewModel<GenresViewModel>()
    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.fragment_top_selling

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.navigator = this
        setAdapterGenres()
        viewModel.listData.observe(this, Observer {
            var adapterGenre = viewBinding.rcyGenres.adapter
            if (adapterGenre is GenresAdapter) {
                adapterGenre.submitList(it)
            }
        })
        viewModel.getGenresData()
    }

    private fun setAdapterGenres() {
        val adapterGenre = GenresAdapter()
        viewBinding.rcyGenres.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = adapterGenre
        }
    }
}