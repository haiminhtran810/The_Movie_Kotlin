package vn.home.app.themoviekotlin.base.fragment

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import vn.home.app.themoviekotlin.base.navigator.BaseNavigator
import vn.home.app.themoviekotlin.base.viewmodel.BaseViewModel

/**
 * Created by HaiMinhTran on 9/11/2018.
 */
abstract class BaseFragment<ViewBinding : ViewDataBinding, ViewModel : BaseViewModel> : Fragment(), BaseNavigator {
    lateinit var viewDataBinding: ViewBinding
    lateinit var viewModel: ViewModel

    // get layout id
    @get:LayoutRes
    abstract val layoutId: Int

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewDataBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.apply {
            root.isClickable = true
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onActivityDestroy()
    }

    override fun onBack() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}