package vn.home.app.themoviekotlin.data.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "Movie")
data class Genre(
        @PrimaryKey val id: String,
        @ColumnInfo val name: String? = ""
) : Parcelable