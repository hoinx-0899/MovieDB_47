package com.sun.moviedb.view.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.sun.moviedb.base.BaseResponse
import com.sun.moviedb.data.entity.Genres
import com.sun.moviedb.data.repository.HomeRepository

/**
 * Created by nguyenxuanhoi on 2019-08-07.
 * @author nguyen.xuan.hoi@sun-asterisk.com
 */
class HomeViewModel(application: Application, private val homeRepository: HomeRepository) :
    AndroidViewModel(application) {

    private val _genres = homeRepository.getAllGenres()
    val genres: LiveData<BaseResponse<List<Genres>>>
        get() = _genres

    override fun onCleared() {
        super.onCleared()
        homeRepository.coroutines.onClear()
    }
}
