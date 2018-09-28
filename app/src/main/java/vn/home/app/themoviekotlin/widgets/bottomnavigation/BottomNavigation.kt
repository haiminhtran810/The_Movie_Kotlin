package vn.home.app.themoviekotlin.widgets.bottomnavigation

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.StateListDrawable
import android.support.annotation.ColorInt
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewCompat
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import vn.home.app.themoviekotlin.R
import java.util.ArrayList

//@JvmOverloads : Phối hợp các constructor thành 1

class BottomNavigation @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null,
        defStyle: Int = 0, defStyleRes: Int = 0) : LinearLayout(context, attrs, defStyle,
        defStyleRes) {

    @ColorInt
    private var itemActiveColor: Int = 0

    @ColorInt
    private var itemInactiveColor: Int = 0

    @ColorInt
    private var titleColorActive: Int = 0

    @ColorInt
    private var titleColorinactive: Int = 0

    private var titleSize: Float = 0.toFloat()
    private var iconSize: Float = 0.toFloat()

    var onTabSelectedListener: OnTabSelectedListener? = null
    private var currentItem = -1

    private val items = ArrayList<BottomNavigationItem>()

    init {
        init(context, attrs)
    }

    // AttributeSet : Quy định style
    private fun init(context: Context, attrs: AttributeSet?) {
        val resource = context.resources
        if (attrs != null) {
            val typeArray = context.obtainStyledAttributes(attrs, R.styleable.BottomNavigation, 0,
                    0)
            try {
                itemActiveColor = typeArray.getColor(R.styleable.BottomNavigation_bgActiveColor,
                        ContextCompat.getColor(context, android.R.color.white))
                itemInactiveColor = typeArray.getColor(R.styleable.BottomNavigation_bgInactiveColor,
                        ContextCompat.getColor(context, android.R.color.black))
                titleColorActive = typeArray.getColor(R.styleable.BottomNavigation_titleActiveColor,
                        ContextCompat.getColor(context, R.color.colorPrimaryDark))
                titleColorinactive = typeArray.getColor(
                        R.styleable.BottomNavigation_titileInactiveColor,
                        ContextCompat.getColor(context, R.color.warmGreyTwo))
                titleSize = typeArray.getDimension(R.styleable.BottomNavigation_textSize,
                        resources.getDimension(R.dimen.sp_14))
                iconSize = typeArray.getDimension(R.styleable.BottomNavigation_iconSize,
                        resources.getDimension(R.dimen.sp_14))
            } finally {
                typeArray.recycle()
            }

            ViewCompat.setElevation(this, resource.getDimension(R.dimen.dp_8))
            clipToPadding = false
            layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    resources.getDimension(R.dimen.dp_48).toInt())
        }
    }

    override fun getOrientation(): Int {
        return LinearLayout.HORIZONTAL
    }

    fun addItems(items: List<BottomNavigationItem>) {
        this.items.clear()
        createItems()
    }

    fun removeAllItems() {
        this.items.clear()
        createItems()
    }

    private fun createItems() {
        for (i in items.indices) {
            val item = items[i]
            val view = LayoutInflater.from(context).inflate(R.layout.item_bottom_navigation, this,
                    false)
            val layoutParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT)
            layoutParams.weight = 1f
            (view.findViewById<View>(
                    R.id.bottom_navigation_item_icon) as ImageView).setImageDrawable(item.drawable)

            val bgColorStateList = StateListDrawable()
            bgColorStateList.addState(intArrayOf(android.R.attr.state_selected),
                    ColorDrawable(item.color))
            bgColorStateList.addState(intArrayOf(-android.R.attr.state_selected),
                    ColorDrawable(itemInactiveColor))
            view.background = bgColorStateList
            view.setOnClickListener { v -> performItemClick(i) }
            addView(view, layoutParams)
            // Force a request layout after all the items have been created
            post { this.requestLayout() }
        }
    }

    fun setCurrentItem(currentItem: Int) {
        performItemClick(currentItem)
    }

    private fun performItemClick(index: Int) {
        if (index != currentItem) {
            try {
                getChildAt(index).isSelected = true
                if (currentItem >= 0 && currentItem < items.size) {
                    getChildAt(currentItem).isSelected
                }
                currentItem = index
                if (onTabSelectedListener != null) {
                    onTabSelectedListener!!.onTabSelected(index, false)
                }
            } catch (e: NullPointerException) {
                e.printStackTrace()
            }
        } else {
            if (onTabSelectedListener != null) {
                onTabSelectedListener!!.onClickCurrentTab()
            }
        }
    }

    fun getItem(i: Int): BottomNavigationItem {
        return items[i]
    }

    interface OnTabSelectedListener {
        fun onTabSelected(position: Int, wasSelected: Boolean)
        fun onClickCurrentTab()
    }
}