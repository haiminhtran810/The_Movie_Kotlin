package vn.home.app.themoviekotlin.base.fragment

import android.databinding.ViewDataBinding
import vn.home.app.themoviekotlin.R
import vn.home.app.themoviekotlin.base.viewmodel.BaseLoadMoreRefreshViewModel

abstract class BaseLoadMoreRefreshFragment
<View : ViewDataBinding, ViewModel : BaseLoadMoreRefreshViewModel<Item, *>, Item> : BaseFragment<View, ViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_load_more_refresh

}