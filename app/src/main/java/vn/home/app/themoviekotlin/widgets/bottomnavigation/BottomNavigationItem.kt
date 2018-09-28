package vn.home.app.themoviekotlin.widgets.bottomnavigation

import android.graphics.Color
import android.graphics.drawable.Drawable

class BottomNavigationItem {
    var title: String? = null
    var color = Color.WHITE
    var drawable: Drawable? = null

    constructor(title: String?, drawable: Drawable, color: Int) {
        this.title = title
        this.color = color
        this.drawable = drawable
    }

    constructor(title: String?, drawable: Drawable) {
        this.title = title
        this.drawable = drawable
    }
}
