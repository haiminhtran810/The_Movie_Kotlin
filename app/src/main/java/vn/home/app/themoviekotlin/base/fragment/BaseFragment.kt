package vn.home.app.themoviekotlin.base.fragment

import android.arch.lifecycle.ViewModelProvider
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import vn.home.app.themoviekotlin.R
import vn.home.app.themoviekotlin.base.navigator.BaseNavigator
import vn.home.app.themoviekotlin.base.viewmodel.BaseViewModel
import javax.inject.Inject

/**
 * Created by HaiMinhTran on 9/11/2018.
 */
abstract class BaseFragment<ViewBinding : ViewDataBinding, ViewModel : BaseViewModel> : DaggerFragment(), BaseNavigator {
    lateinit var viewDataBinding: ViewBinding
    abstract var viewModel: ViewModel
    abstract val bindingVariable: Int

    // get layout id
    @get:LayoutRes
    abstract val layoutId: Int

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.apply {
            //https://developer.android.com/reference/android/databinding/ViewDataBinding
            setVariable(bindingVariable, viewModel)
            setLifecycleOwner(this@BaseFragment)
            root.isClickable = false
            // chưa biết thằng này xử lý thế nào
            executePendingBindings()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onActivityDestroy()
    }

    override fun onBack() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * fragment transaction
     */
    fun findFragment(TAG: String): Fragment? {
        return activity?.supportFragmentManager?.findFragmentByTag(TAG)
    }

    fun findChildFragment(parentFragment: Fragment = this, TAG: String): Fragment? {
        return parentFragment.childFragmentManager.findFragmentByTag(TAG)
    }

    fun replaceFragment(fragment: Fragment, TAG: String?, addToBackStack: Boolean = false,
            transit: Int = -1) {
        activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, fragment, TAG)?.apply {
                    commitTransaction(this, addToBackStack, transit)
                }?.commit()
    }

    fun replaceChildFragment(
            parentFragment: Fragment = this, containerViewId: Int, fragment: Fragment,
            TAG: String?, addToBackStack: Boolean = false, transit: Int = -1) {
        val transaction = parentFragment.childFragmentManager.beginTransaction().replace(
                containerViewId, fragment, TAG)
        commitTransaction(transaction, addToBackStack, transit)
    }

    fun commitTransaction(transaction: FragmentTransaction?, addToBackStack: Boolean,
            transit: Int) {
        if (addToBackStack) transaction?.addToBackStack(null)
        //Select a standard transition animation for this transaction.
        // May be one of TRANSIT_NONE, TRANSIT_FRAGMENT_OPEN, TRANSIT_FRAGMENT_CLOSE, or TRANSIT_FRAGMENT_FADE.
        if (transit != -1) transaction?.setTransition(transit)
        transaction?.commit()
    }

    fun addChildFragment(
            parentFragment: Fragment = this, containerViewId: Int,
            targetFragment: Fragment, TAG: String?, addToBackStack: Boolean = false,
            transit: Int = -1) {
        val transaction = parentFragment.childFragmentManager.beginTransaction().add(
                containerViewId, targetFragment, TAG)
        commitTransaction(transaction, addToBackStack, transit)
    }

    // lấy fragment trong stack ra ngoài
    fun popChildFragment(parentFragment: Fragment = this) {
        parentFragment.childFragmentManager.popBackStack()
    }

}