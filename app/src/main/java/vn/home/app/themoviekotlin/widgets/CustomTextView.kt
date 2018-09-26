package vn.home.app.themoviekotlin.widgets

import android.content.Context
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet


class CustomTextView : AppCompatTextView {
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet? = null) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : super(
            context, attrs, defStyleAttr)
}