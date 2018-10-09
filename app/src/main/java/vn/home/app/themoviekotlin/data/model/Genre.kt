package vn.home.app.themoviekotlin.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Genre(
        val id: String,
        val name: String? = ""
) : Parcelable