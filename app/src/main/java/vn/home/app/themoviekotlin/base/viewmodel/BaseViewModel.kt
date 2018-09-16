package vn.home.app.themoviekotlin.base.viewmodel

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by HaiMinhTran on 9/10/2018.
 */
abstract class BaseViewModel : ViewModel() {
    var compoDisposable = CompositeDisposable()
    fun addDisposable(disposable: Disposable) {
        compoDisposable.add(disposable)
    }

    fun onActivityDestroy() {
        compoDisposable.clear()
        compoDisposable = null!!
    }
}