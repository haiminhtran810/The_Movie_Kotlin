package vn.home.app.themoviekotlin.ui.main


import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import vn.home.app.themoviekotlin.BR
import vn.home.app.themoviekotlin.R
import vn.home.app.themoviekotlin.base.fragment.BaseFragment
import vn.home.app.themoviekotlin.databinding.FragmentWelcomeBinding
import vn.home.app.themoviekotlin.ui.welcome.WelcomeNavigator
import vn.home.app.themoviekotlin.ui.welcome.WelcomeViewModel

class MainFragment : BaseFragment<FragmentWelcomeBinding, WelcomeViewModel>(), WelcomeNavigator {

    companion object {
        const val TAG = "MainFragment"

        fun newInstance() = MainFragment()
    }

    override var viewModel: WelcomeViewModel = ViewModelProviders.of(this, viewModelFactory).get(
            WelcomeViewModel::class.java)

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_main

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.navigator = this
    }

}
