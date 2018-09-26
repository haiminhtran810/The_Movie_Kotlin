package vn.home.app.themoviekotlin.ui.main

import android.os.Bundle
import org.koin.android.viewmodel.ext.android.viewModel
import vn.home.app.themoviekotlin.BR
import vn.home.app.themoviekotlin.R
import vn.home.app.themoviekotlin.base.fragment.BaseFragment
import vn.home.app.themoviekotlin.databinding.FragmentWelcomeBinding

class MainFragment : BaseFragment<FragmentWelcomeBinding, MainViewModel>(), MainNavigator {

    companion object {
        const val TAG = "MainFragment"

        fun newInstance() = MainFragment()
    }

    override val viewModel by viewModel<MainViewModel>()

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_main

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.navigator = this
    }

}
