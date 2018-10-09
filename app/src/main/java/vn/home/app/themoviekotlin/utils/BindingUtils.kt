package vn.home.app.themoviekotlin.utils

import android.databinding.BindingAdapter
import android.graphics.drawable.Drawable
import android.support.v4.widget.SwipeRefreshLayout
import android.text.TextUtils
import android.widget.ImageView
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.signature.ObjectKey
import vn.home.app.themoviekotlin.GlideApp
import java.io.File

@BindingAdapter(
        value = ["loadImage", "placeholder", "centerCrop", "fitCenter", "circleCrop", "fitXY", "cacheSource", "animation"],
        requireAll = false)
fun ImageView.loadImage(url: String? = "", placeholder: Drawable?,
                        centerCrop: Boolean = false, fitCenter: Boolean = false, circleCrop: Boolean = false, fitXY: Boolean = false,
                        isCacheSource: Boolean = false, animation: Boolean = false) {
    if (TextUtils.isEmpty(url)) {
        setImageDrawable(placeholder)
        return
    }
    val requestBuilder = GlideApp.with(context).load(url)
    val requestOptions = RequestOptions().diskCacheStrategy(
            if (isCacheSource) DiskCacheStrategy.DATA else DiskCacheStrategy.RESOURCE)
            .placeholder(placeholder)
    if (!animation) requestOptions.dontAnimate()
    // default centerCrop
    if (centerCrop || !circleCrop && !fitCenter && !fitXY) requestOptions.centerCrop()
    if (fitCenter) requestOptions.optionalFitCenter()
    if (circleCrop) requestOptions.circleCrop()
    val file = File(url)
    if (file.exists()) {
        requestOptions.signature(ObjectKey(file.lastModified().toString()))
    }
    requestBuilder.apply(requestOptions).into(this)
}

@BindingAdapter("isRefreshing")
fun SwipeRefreshLayout.customRefreshing(refreshing: Boolean?) {
    isRefreshing = refreshing == true
}

@BindingAdapter("onRefreshListener")
fun SwipeRefreshLayout.customRefreshListener(listener: SwipeRefreshLayout.OnRefreshListener?) {
    setOnRefreshListener(listener)
}