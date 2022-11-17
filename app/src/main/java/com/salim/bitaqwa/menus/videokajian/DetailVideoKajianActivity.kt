package com.salim.bitaqwa.menus.videokajian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import com.salim.bitaqwa.R
import com.salim.bitaqwa.databinding.ActivityDetailVideoKajianBinding
import com.salim.bitaqwa.menus.videokajian.model.VideoKajianModel

class DetailVideoKajianActivity : AppCompatActivity() {

    //variable untuk menangkap data
    companion object {
        const val EXTRA_VIDEO_KAJIAN = "extra_video_kajian"
    }

    private lateinit var binding: ActivityDetailVideoKajianBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailVideoKajianBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //accept data intent
        val video =
            intent.getParcelableExtra<VideoKajianModel>(EXTRA_VIDEO_KAJIAN) as VideoKajianModel

        //panggil function init view
        initView(video)
    }

    //buat fuction untuk mengola data yang diterima
    private fun initView(video : VideoKajianModel){
        val youTubePlayerView : YouTubePlayerView = findViewById(R.id.player_video)
        lifecycle.addObserver(youTubePlayerView)

        youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener(){
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(video.urlVideo, 0f)
            }
        })

        binding.tvChannel.text = video.channel
        binding.tvTitle.text = video.title
        binding.tvSpeaker.text = video.speaker
        binding.tvSummary.text = video.summary

        //buat fungsi button share
        binding.ivShare.setOnClickListener {
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(
                Intent.EXTRA_TEXT,
                "Kajian dengan Judul \"${video.title}\" dibawakan oleh" +
                        "\"${video.speaker}\" dan dari channel \"${video.channel}\"" +
                        "\n\n\n Link Video : https://www.youtube.com/watch?v=\"${video.urlVideo}\""
            )
            sendIntent.type = "text/plain"
            startActivity(sendIntent)
        }
    }
}