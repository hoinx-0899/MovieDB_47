package com.sun.moviedb.view.home.discover

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.sun.moviedb.R
import com.sun.moviedb.base.BaseResponse
import com.sun.moviedb.base.ViewModelBaseFragment
import com.sun.moviedb.data.dto.CategoryDTO
import com.sun.moviedb.data.entity.Movie
import com.sun.moviedb.databinding.FragmentDiscoverBinding
import com.sun.moviedb.utils.CategoryQuery
import com.sun.moviedb.view.adapter.HomeAdapter
import com.sun.moviedb.view.widget.SpaceItemDecoration
import kotlinx.android.synthetic.main.fragment_discover.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by nguyenxuanhoi on 2019-08-23.
 * @author nguyen.xuan.hoi@sun-asterisk.com
 */
class DiscoverFragment : ViewModelBaseFragment<DiscoverViewModel, FragmentDiscoverBinding>() {

    override val viewModel: DiscoverViewModel by viewModel()

    override val getContentViewId = R.layout.fragment_discover

    override fun initializeView(savedInstanceState: Bundle?) {
    }

    override fun initializeComponents() {
        initCategory()
    }

    private fun initCategory() {
        val categories = viewModel.getCategories()
        val adapter = HomeAdapter({
            val directions = DiscoverFragmentDirections.actDiscoverToMovieByCategory(it.queryType)
            findNavController().navigate(directions)
        }, {
            findNavController().navigate(R.id.actDiscoverToDetailActivity)

        })
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
                CategoryQuery.UP_COMING -> {
                    observeMovieByCategory(category, adapter, viewModel.moviesUpComming)
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
