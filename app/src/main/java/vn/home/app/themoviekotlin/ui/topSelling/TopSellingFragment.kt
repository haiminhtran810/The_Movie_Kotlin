package vn.home.app.themoviekotlin.ui.topSelling


import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import org.koin.android.viewmodel.ext.android.viewModel
import vn.home.app.themoviekotlin.BR
import vn.home.app.themoviekotlin.R
import vn.home.app.themoviekotlin.base.fragment.BaseFragment
import vn.home.app.themoviekotlin.databinding.FragmentTopSellingBinding

class TopSellingFragment : BaseFragment<FragmentTopSellingBinding, TopSellingViewModel>(), TopSellingNavigator {
    companion object {
        const val TAG = "TopSellingFragment"
        fun instance() = TopSellingFragment()
    }

    override val viewModel by viewModel<TopSellingViewModel>()
    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.fragment_top_selling

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.navigator = this
        viewModel.getDataTop(1)
        //setTopSellingAdapter()
        viewModel.listTopSelling.observe(this, Observer {
            /*val adapter = viewBinding.rcyLoadTopRate.adapter
            if (adapter is TopSellingAdapter) {
                adapter.submitList(it)
            }*/
            val a = it
        })
    }

    private fun setTopSellingAdapter() {
        var topSellingAdapter = TopSellingAdapter()
        viewBinding.apply {
            rcyLoadTopRate.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                adapter = topSellingAdapter
            }
        }
    }
}
