package vn.home.app.themoviekotlin

import android.os.Bundle
import org.koin.android.viewmodel.ext.android.viewModel
import vn.home.app.themoviekotlin.base.activity.BaseActivity
import vn.home.app.themoviekotlin.ui.welcome.WelcomeFragment

class MainActivity : BaseActivity() {

    val viewModel by viewModel<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.parent,
                WelcomeFragment.newInstance(), WelcomeFragment.TAG)
    }

    override fun onBackPressed() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.parent)
        super.onBackPressed()
    }
}
