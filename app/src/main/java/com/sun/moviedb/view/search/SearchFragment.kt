package com.sun.moviedb.view.search

import android.os.Bundle
import com.sun.moviedb.R
import com.sun.moviedb.base.BaseFragment
import com.sun.moviedb.base.ViewModelBaseFragment
import com.sun.moviedb.databinding.FragmentSearchBinding

/**
 * Created by nguyenxuanhoi on 2019-08-22.
 * @author nguyen.xuan.hoi@sun-asterisk.com
 */
class SearchFragment :BaseFragment<FragmentSearchBinding>(){

    override val getContentViewId = R.layout.fragment_search

    override fun initializeView(savedInstanceState: Bundle?) {
    }

    override fun initializeComponents() {
    }
}
