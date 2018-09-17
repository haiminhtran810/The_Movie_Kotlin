package vn.home.app.themoviekotlin

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import dagger.android.AndroidInjection
import vn.home.app.themoviekotlin.base.activity.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val viewModel: MainActivityViewModel
        get() = ViewModelProviders.of(this, viewModelFactory).get(MainActivityViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
