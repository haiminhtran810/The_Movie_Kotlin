package vn.home.app.themoviekotlin.ui.welcome

import android.os.Bundle
import android.os.Handler
import org.koin.android.viewmodel.ext.android.viewModel
import vn.home.app.themoviekotlin.BR
import vn.home.app.themoviekotlin.R
import vn.home.app.themoviekotlin.base.fragment.BaseFragment
import vn.home.app.themoviekotlin.databinding.FragmentWelcomeBinding
import vn.home.app.themoviekotlin.ui.main.MainFragment

class WelcomeFragment : BaseFragment<FragmentWelcomeBinding, WelcomeViewModel>(), WelcomeNavigator {

    private val handler = Handler()
    private val progressTask = Runnable { gotoMain() }

    companion object {
        const val TAG = "WelcomeFragment"
        const val DELAY_MILLISECONDS = 1000L
        fun newInstance() = WelcomeFragment()
    }

    override val viewModel by viewModel<WelcomeViewModel>()

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_welcome

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewBinding.viewModel = viewModel
        viewModel.apply {
            navigator = this@WelcomeFragment
        }
    }

    override fun onResume() {
        handler.postDelayed(progressTask, DELAY_MILLISECONDS)
        super.onResume()
    }

    override fun onPause() {
        handler.removeCallbacks(progressTask)
        super.onPause()
    }

    fun gotoMain() {
        replaceFragment(MainFragment.newInstance(), MainFragment.TAG)
    }

}