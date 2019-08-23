package com.sun.moviedb.view.home.discover

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.sun.moviedb.base.BaseResponse
import com.sun.moviedb.data.dto.CategoryDTO
import com.sun.moviedb.data.entity.Movie
import com.sun.moviedb.data.repository.MovieByCategoryRepository
import com.sun.moviedb.utils.CategoryQuery

/**
 * Created by nguyenxuanhoi on 2019-08-23.
 * @author nguyen.xuan.hoi@sun-asterisk.com
 */
class DiscoverViewModel(
        application: Application,
        private val repository: MovieByCategoryRepository
) : AndroidViewModel(application) {
    companion object {
        private val FIRST_PAGE = 1
    }

    private val _categories by lazy {
        repository.getQueryTypeCategory()
    }

    fun getCategories(): List<CategoryDTO> {
        return _categories
    }

    private val _moviesPopular: LiveData<BaseResponse<List<Movie>>> by lazy {
        repository.getMoviesByCategory(CategoryQuery.POPULAR, FIRST_PAGE)
    }
    val moviesPopular: LiveData<BaseResponse<List<Movie>>>
        get() = _moviesPopular

    private val _moviesUpComing: LiveData<BaseResponse<List<Movie>>> by lazy {
        repository.getMoviesByCategory(CategoryQuery.UP_COMING, FIRST_PAGE)
    }
    val moviesUpComming: LiveData<BaseResponse<List<Movie>>>
        get() = _moviesUpComing

    override fun onCleared() {
        super.onCleared()
        repository.coroutines.onClear()
    }

}
