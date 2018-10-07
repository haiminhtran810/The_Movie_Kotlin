package vn.home.app.themoviekotlin.ui.topSelling


import android.os.Bundle
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
        viewModel.getDataTop()
    }


}
