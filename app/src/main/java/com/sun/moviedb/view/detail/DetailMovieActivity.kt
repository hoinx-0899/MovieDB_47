package com.sun.moviedb.view.detail

import android.os.Bundle
import androidx.navigation.navArgs
import com.sun.moviedb.R
import com.sun.moviedb.base.BaseActivity

/**
 * Created by nguyenxuanhoi on 2019-08-23.
 * @author nguyen.xuan.hoi@sun-asterisk.com
 */
class DetailMovieActivity : BaseActivity() {
     val movie by lazy {
        intent.extras?.let {
            DetailMovieActivityArgs.fromBundle(it).movie
        }
    }
    override val getContentViewId = R.layout.activity_detail

    override fun initializeView(savedInstanceState: Bundle?) {

    }

    override fun initializeComponents() {

    }

}