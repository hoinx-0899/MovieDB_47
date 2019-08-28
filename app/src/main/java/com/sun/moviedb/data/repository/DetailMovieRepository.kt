package com.sun.moviedb.data.repository

import com.sun.moviedb.data.dto.DetailMovieDTO
import com.sun.moviedb.data.remote.RemoteDataSource
import io.reactivex.Single

/**
 * Created by nguyenxuanhoi on 2019-08-25.
 * @author nguyen.xuan.hoi@sun-asterisk.com
 */
class DetailMovieRepository(private val remoteDataSource: RemoteDataSource) {

    fun getDetailMovie(idMovie: Int): Single<DetailMovieDTO> = Single.create { emitter ->
        remoteDataSource.getMovieDetail(idMovie).subscribe({
            emitter.onSuccess(it)
        }, {
            emitter.onError(it)
        })
    }
}
