package com.sun.moviedb.view

import android.os.Bundle
import com.sun.moviedb.R
import com.sun.moviedb.base.BaseFragment
import com.sun.moviedb.databinding.FragmentHomeBinding

/**
 * Created by nguyenxuanhoi on 2019-08-14.
 * @author nguyen.xuan.hoi@sun-asterisk.com
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override val getContentViewId: Int = R.layout.fragment_home

    override fun initializeView(savedInstanceState: Bundle?) {
    }

    override fun initializeComponents() {
    }
}
