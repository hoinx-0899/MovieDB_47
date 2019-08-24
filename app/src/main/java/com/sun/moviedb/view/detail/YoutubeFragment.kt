package com.sun.moviedb.view.detail

import android.os.Bundle
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerFragment
import com.sun.moviedb.BuildConfig

/**
 * Created by nguyenxuanhoi on 2019-08-25.
 * @author nguyen.xuan.hoi@sun-asterisk.com
 */
class YoutubeFragment : YouTubePlayerFragment(), YouTubePlayer.OnInitializedListener {
    private lateinit var youTubePlayer: YouTubePlayer
    override fun onInitializationSuccess(
        p0: YouTubePlayer.Provider,
        p1: YouTubePlayer,
        p2: Boolean
    ) {
        youTubePlayer=p1
        youTubePlayer.cueVideo("JOAWOLaxcCA")

    }

    override fun onInitializationFailure(
        p0: YouTubePlayer.Provider?,
        p1: YouTubeInitializationResult?
    ) {
    }

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        initialize(BuildConfig.YOUTUBE_KEY, this)
    }

    override fun onDestroy() {
        super.onDestroy()
        if(::youTubePlayer.isInitialized){
            youTubePlayer.release()
        }
    }
    fun playTrailer() {
        if (::youTubePlayer.isInitialized) youTubePlayer.play()
    }
    fun setFullScreen(isFullScreen: Boolean) {
        if (::youTubePlayer.isInitialized) youTubePlayer.setFullscreen(isFullScreen)
    }
    fun setTrailerId(trailerId: String) {
        if (::youTubePlayer.isInitialized) youTubePlayer.cueVideo(trailerId)
    }

}