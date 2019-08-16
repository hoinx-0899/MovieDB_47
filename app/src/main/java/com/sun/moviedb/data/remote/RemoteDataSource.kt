package com.sun.moviedb.data.remote

import androidx.lifecycle.LiveData
import com.sun.moviedb.base.BaseResponse
import com.sun.moviedb.data.dto.GenresDto
import com.sun.moviedb.data.dto.MovieDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RemoteDataSource {
    @GET("genre/movie/list")
    fun getGenres(): LiveData<BaseResponse<GenresDto>>

    @GET("movie/{type}")
    fun getMoviesByCategory(@Path("type") type: String, @Query("page") page: Int): LiveData<BaseResponse<MovieDto>>
}
