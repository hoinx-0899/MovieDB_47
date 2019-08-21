package com.sun.moviedb.view.detail

import android.os.Bundle
import com.sun.moviedb.R
import com.sun.moviedb.base.BaseFragment
import com.sun.moviedb.databinding.FragmentDetailBinding

/**
 * Created by nguyenxuanhoi on 2019-08-22.
 * @author nguyen.xuan.hoi@sun-asterisk.com
 */
class DetailMovieFragment :BaseFragment<FragmentDetailBinding>(){
    override val getContentViewId= R.layout.fragment_detail

    override fun initializeView(savedInstanceState: Bundle?) {
    }

    override fun initializeComponents() {
    }
}
