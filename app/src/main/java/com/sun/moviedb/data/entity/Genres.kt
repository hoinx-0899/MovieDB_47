package com.sun.moviedb.data.entity

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

/**
 * Created by nguyenxuanhoi on 2019-08-14.
 * @author nguyen.xuan.hoi@sun-asterisk.com
 */
@Entity(tableName = "genres", primaryKeys = ["id"])
data class Genres(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String
)
