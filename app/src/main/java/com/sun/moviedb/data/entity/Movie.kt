package com.sun.moviedb.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

/**
 * Created by nguyenxuanhoi on 2019-08-14.
 * @author nguyen.xuan.hoi@sun-asterisk.com
 */
@Entity(tableName = "movies", primaryKeys = ["id"])
data class Movie(
        @SerializedName("id")
        @ColumnInfo(name = "id")
        var id: Int,
        @SerializedName("title")
        val title: String?,
        @SerializedName("overview")
        val overview: String?,
        @SerializedName("poster_path")
        val posterPath: String?,
        @SerializedName("vote_count")
        val voteCount: Int?,
        @SerializedName("vote_average")
        val voteAverage: Double?,
        @SerializedName("popularity")
        val popularity: Double?
) {
    @ColumnInfo(name = "query_type")
    var queryType: String = ""
}
