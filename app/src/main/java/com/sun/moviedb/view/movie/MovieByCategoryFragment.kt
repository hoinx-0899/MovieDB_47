package com.sun.moviedb.view.movie

import android.os.Bundle
import com.sun.moviedb.R
import com.sun.moviedb.base.BaseFragment
import com.sun.moviedb.databinding.FragmentMovieByCategoryBinding

/**
 * Created by nguyenxuanhoi on 2019-08-22.
 * @author nguyen.xuan.hoi@sun-asterisk.com
 */
class MovieByCategoryFragment :BaseFragment<FragmentMovieByCategoryBinding>() {
    override val getContentViewId = R.layout.fragment_movie_by_category

    override fun initializeView(savedInstanceState: Bundle?) {
    }

    override fun initializeComponents() {
    }
}
