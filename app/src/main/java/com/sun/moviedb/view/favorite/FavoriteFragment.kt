package com.sun.moviedb.view.favorite

import android.os.Bundle
import com.sun.moviedb.R
import com.sun.moviedb.base.BaseFragment
import com.sun.moviedb.databinding.FragmentFavoriteBinding

/**
 * Created by nguyenxuanhoi on 2019-08-26.
 * @author nguyen.xuan.hoi@sun-asterisk.com
 */
class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>() {
    override val getContentViewId = R.layout.fragment_favorite

    override fun initializeView(savedInstanceState: Bundle?) {
        initTooBar(viewDataBinding.toolBar)
    }

    override fun initializeComponents() {
    }
}
