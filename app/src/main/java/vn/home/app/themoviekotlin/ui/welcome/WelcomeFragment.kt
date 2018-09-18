package vn.home.app.themoviekotlin.ui.welcome

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import vn.home.app.themoviekotlin.BR
import vn.home.app.themoviekotlin.R
import vn.home.app.themoviekotlin.base.fragment.BaseFragment
import vn.home.app.themoviekotlin.databinding.FragmentWelcomeBinding

class WelcomeFragment : BaseFragment<FragmentWelcomeBinding, WelcomeViewModel>() {

    companion object {
        const val TAG = "WelcomeFragment"
        fun newInstance() = WelcomeFragment()
    }

    override var viewModel: WelcomeViewModel = ViewModelProviders.of(this, viewModelFactory).get(
            WelcomeViewModel::class.java)

    override val bindingVariable: Int = BR.viewModel

    override val layoutId: Int = R.layout.fragment_welcome

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}