package vn.home.app.themoviekotlin.data.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "Movie")
data class Movie(
        @PrimaryKey val id: String,
        @ColumnInfo val adult: Boolean = false,
        @ColumnInfo val backdrop_path: String? = "",
        @ColumnInfo val budget: Int = 0,
        @ColumnInfo val homepage: String = "",
        @ColumnInfo val imdb_id: String = "",
        @ColumnInfo val original_language: String = "",
        @ColumnInfo val original_title: String = "",
        @ColumnInfo val overview: String = "",
        @ColumnInfo val popularity: Double = 0.0,
        @ColumnInfo val poster_path: String? = "",
        @ColumnInfo val release_date: String = "",
        @ColumnInfo val revenue: Int = 0,
        @ColumnInfo val runtime: Int = 0,
        @ColumnInfo val status: String = "",
        @ColumnInfo val tagline: String = "",
        @ColumnInfo val title: String = "",
        @ColumnInfo val video: Boolean = false,
        @ColumnInfo val vote_average: Double = 0.0,
        @ColumnInfo val vote_count: Int = 0,
        @ColumnInfo var isFavorite: Boolean = false
) : Parcelable