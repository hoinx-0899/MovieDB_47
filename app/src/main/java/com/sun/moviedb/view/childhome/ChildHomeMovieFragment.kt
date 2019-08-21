package com.sun.moviedb.view.childhome

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.sun.moviedb.R
import com.sun.moviedb.base.BaseResponse
import com.sun.moviedb.base.ViewModelBaseFragment
import com.sun.moviedb.data.dto.CategoryDTO
import com.sun.moviedb.data.entity.Movie
import com.sun.moviedb.databinding.FragmentChildHomeBinding
import com.sun.moviedb.utils.CategoryQuery
import com.sun.moviedb.view.adapter.HomeAdapter
import com.sun.moviedb.view.widget.SpaceItemDecoration
import kotlinx.android.synthetic.main.fragment_child_home.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by nguyenxuanhoi on 2019-08-19.
 * @author nguyen.xuan.hoi@sun-asterisk.com
 */
class ChildHomeMovieFragment : ViewModelBaseFragment<ChildHomeViewModel, FragmentChildHomeBinding>() {

    override val viewModel: ChildHomeViewModel by viewModel()

    override val getContentViewId = R.layout.fragment_child_home

    override fun initializeView(savedInstanceState: Bundle?) {
    }

    override fun initializeComponents() {
        val categories = viewModel.getCategories()
        val adapter = HomeAdapter {

        }
        recyclerView.apply {
            setHasFixedSize(true)
            addItemDecoration(SpaceItemDecoration(resources.getDimensionPixelSize(R.dimen.dp_8)))
            this.adapter = adapter
        }
        adapter.submitList(categories)
        categories.forEach { category ->
            when (category.queryType) {
                CategoryQuery.POPULAR -> {
                    observeMovieByCategory(category, adapter, viewModel.moviesPopular)
                }
                CategoryQuery.NOW_PLAYING -> {
                    observeMovieByCategory(category, adapter, viewModel.moviesNowPlaying)
                }
                CategoryQuery.UP_COMING -> {
                    observeMovieByCategory(category, adapter, viewModel.moviesUpComming)
                }
                CategoryQuery.TOP_RATE -> {
                    observeMovieByCategory(category, adapter, viewModel.movieTopRate)
                }
            }

        }
    }

    private fun observeMovieByCategory(
            category: CategoryDTO,
            adapter: HomeAdapter, data:
            LiveData<BaseResponse<List<Movie>>>
    ) {
        data.observe(this, Observer {
            handlerError(it)
            it.result?.let { movies ->
                category.movies = movies
                adapter.notifyDataSetChanged()
            }
        })
    }
}
