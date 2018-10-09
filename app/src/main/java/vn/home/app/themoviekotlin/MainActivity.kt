package vn.home.app.themoviekotlin

import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import org.koin.android.viewmodel.ext.android.viewModel
import vn.home.app.themoviekotlin.base.activity.BaseActivity
import vn.home.app.themoviekotlin.ui.welcome.WelcomeFragment

class MainActivity : BaseActivity() {

    val viewModel by viewModel<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        }
        supportFragmentManager.beginTransaction().replace(R.id.parent,
                WelcomeFragment.newInstance(), WelcomeFragment.TAG).commitNow()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
