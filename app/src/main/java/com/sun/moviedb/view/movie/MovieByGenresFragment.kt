package com.sun.moviedb.view.movie

import android.os.Bundle
import com.sun.moviedb.R
import com.sun.moviedb.base.BaseFragment
import com.sun.moviedb.databinding.FragmentMovieByGenresBinding

/**
 * Created by nguyenxuanhoi on 2019-08-22.
 * @author nguyen.xuan.hoi@sun-asterisk.com
 */
class MovieByGenresFragment : BaseFragment<FragmentMovieByGenresBinding>() {
    override val getContentViewId = R.layout.fragment_movie_by_genres

    override fun initializeView(savedInstanceState: Bundle?) {
    }

    override fun initializeComponents() {
    }
}
