package vn.home.app.themoviekotlin.ui.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter
import org.koin.android.viewmodel.ext.android.viewModel
import vn.home.app.themoviekotlin.BR
import vn.home.app.themoviekotlin.R
import vn.home.app.themoviekotlin.base.fragment.BaseFragment
import vn.home.app.themoviekotlin.databinding.FragmentMainBinding
import vn.home.app.themoviekotlin.ui.genres.GenresFragment
import vn.home.app.themoviekotlin.ui.topSelling.TopSellingFragment
import vn.home.app.themoviekotlin.widgets.bottomnavigation.BottomNavigation
import vn.home.app.themoviekotlin.widgets.bottomnavigation.BottomNavigationAdapter

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>(), MainNavigator {

    companion object {
        const val TAG = "MainFragment"
        const val FRAGMENT_TAG = "FRAGMENT_TAG"

        fun newInstance() = MainFragment()
    }

    private var mBottomNavigator: AHBottomNavigation? = null
    private var mCurrentPositionFragment = Tab.TOP.position

    override val viewModel by viewModel<MainViewModel>()

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_main

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.navigator = this
        viewBinding.viewModel = viewModel
        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        mBottomNavigator = viewBinding.bottomNavigation
        val bottomNavigationAdapter = AHBottomNavigationAdapter(activity, R.menu.menu_bottom)
        bottomNavigationAdapter.setupWithBottomNavigation(mBottomNavigator)
        mBottomNavigator!!.apply {
            titleState = AHBottomNavigation.TitleState.ALWAYS_SHOW
            defaultBackgroundColor = ContextCompat.getColor(context, android.R.color.white)
            setNotificationBackgroundColor(ContextCompat.getColor(context, R.color.vermillion))
            accentColor = ContextCompat.getColor(context, R.color.colorPrimaryDark)
            inactiveColor = ContextCompat.getColor(context, R.color.warmGreyTwo)
            setOnTabSelectedListener { position, wasSelected ->
                onClickBottomNavigationItem(position)
            }
            mCurrentPositionFragment = Tab.TOP.position
            onClickBottomNavigationItem(mCurrentPositionFragment)
        }
    }

    private fun onClickBottomNavigationItem(position: Int): Boolean {
        val currentTag = getTabFragmentTag(mCurrentPositionFragment)
        val newTag = getTabFragmentTag(position)
        val fragmentManager = childFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val currentFragment = fragmentManager.findFragmentByTag(currentTag)
        if (currentFragment != null) {
            fragmentTransaction.hide(currentFragment)
        }
        var newFragment: Fragment? = fragmentManager.findFragmentByTag(newTag)
        if (newFragment == null) {
            newFragment = newFragmentInstance(position)
            if (newFragment.isAdded())
                fragmentTransaction.show(newFragment)
            fragmentTransaction.add(R.id.frame_layout, newFragment, newTag)
        } else {
            fragmentTransaction.show(newFragment)
        }

        mCurrentPositionFragment = position
        fragmentTransaction.commit()
        return true
    }

    fun newFragmentInstance(position: Int): Fragment {
        return when (position) {
            Tab.TOP.position -> TopSellingFragment.instance()
            Tab.NEW.position -> TopSellingFragment.instance()
            Tab.GENRES.position -> GenresFragment.instance()
            Tab.STUDIOS.position -> TopSellingFragment.instance()
            else -> Fragment()
        }

    }

    fun getTabFragmentTag(position: Int) = FRAGMENT_TAG + position
}
