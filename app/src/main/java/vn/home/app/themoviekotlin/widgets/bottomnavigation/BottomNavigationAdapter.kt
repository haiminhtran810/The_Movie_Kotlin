package vn.home.app.themoviekotlin.widgets.bottomnavigation


import android.support.v4.app.Fragment
import android.support.annotation.ColorInt
import android.support.annotation.MenuRes
import android.support.v7.widget.PopupMenu
import android.view.Menu
import android.view.MenuItem
import java.util.*

class BottomNavigationAdapter(fragment: Fragment, @MenuRes menuRes: Int) {
    private var mMenu: Menu? = null
    private var navigationItems: MutableList<BottomNavigationItem>? = null

    init {
        mMenu = PopupMenu(fragment.activity!!, fragment.view!!).menu
        fragment.activity!!.menuInflater.inflate(menuRes, mMenu)
    }

    @JvmOverloads
    fun setupWithBottomNavigation(
            bottomNavigation: BottomNavigation, @ColorInt colors: IntArray? = null) {
        if (navigationItems == null) {
            navigationItems = ArrayList()
        } else {
            navigationItems!!.clear()
        }

        if (mMenu != null) {
            for (i in 0 until mMenu!!.size()) {
                val item = mMenu!!.getItem(i)
                if (colors != null && colors.size >= mMenu!!.size() && colors[i] != 0) {
                    val navigationItem = BottomNavigationItem(item.title?.toString(), item.icon,
                            colors[i])
                    navigationItems!!.add(navigationItem)
                } else {
                    val navigationItem = BottomNavigationItem(item.title?.toString(), item.icon)
                    navigationItems!!.add(navigationItem)
                    bottomNavigation.removeAllItems()
                    bottomNavigation.addItems(navigationItems!!)
                }
            }
        }
    }
}