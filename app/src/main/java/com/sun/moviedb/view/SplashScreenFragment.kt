package com.sun.moviedb.view

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Handler
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.vectordrawable.graphics.drawable.Animatable2Compat
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.sun.moviedb.R
import com.sun.moviedb.base.BaseFragment
import com.sun.moviedb.constants.Constants
import com.sun.moviedb.databinding.FragmentSplashScreenBinding
import kotlinx.android.synthetic.main.fragment_splash_screen.*

/**
 * Created by nguyenxuanhoi on 2019-08-14.
 * @author nguyen.xuan.hoi@sun-asterisk.com
 */
class SplashScreenFragment : BaseFragment<FragmentSplashScreenBinding>() {

    override val getContentViewId: Int = R.layout.fragment_splash_screen

    override fun initializeView(savedInstanceState: Bundle?) {

    }

    override fun initializeComponents() {

    }

    override fun onResume() {
        super.onResume()
        Handler().postDelayed({
            view?.let {
                findNavController().navigate(R.id.actionSplashToHome)
            }
        }, Constants.TIME_DELAY)
    }

    override fun onBackPressed(): Boolean = true
}
