package vn.home.app.themoviekotlin.ui.welcome

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Handler
import vn.home.app.themoviekotlin.BR
import vn.home.app.themoviekotlin.R
import vn.home.app.themoviekotlin.base.fragment.BaseFragment
import vn.home.app.themoviekotlin.databinding.FragmentWelcomeBinding
import vn.home.app.themoviekotlin.ui.main.MainFragment

class WelcomeFragment : BaseFragment<FragmentWelcomeBinding, WelcomeViewModel>(), WelcomeNavigator {

    private val handler = Handler()

    companion object {
        const val TAG = "WelcomeFragment"
        const val DELAY_MILLISECONDS = 1000L
        fun newInstance() = WelcomeFragment()
    }

    override var viewModel: WelcomeViewModel = ViewModelProviders.of(this, viewModelFactory).get(
            WelcomeViewModel::class.java)

    override val bindingVariable: Int = BR.viewModel

    override val layoutId: Int = R.layout.fragment_welcome

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewBinding.viewModel = viewModel
        viewModel.apply {
            navigator = this@WelcomeFragment
        }
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(Runnable {
            replaceFragment(MainFragment.newInstance(), MainFragment.TAG)
        }, DELAY_MILLISECONDS)
    }

}