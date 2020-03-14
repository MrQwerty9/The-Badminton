package com.sstudio.thebadminton.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sstudio.thebadminton.R
import com.sstudio.thebadminton.menu3.DetailVideoActivity
import com.sstudio.thebadminton.model.Video
import kotlinx.android.synthetic.main.item_video.view.*
import java.util.ArrayList
import com.sstudio.thebadminton.BuildConfig.BASE_URL
import android.media.MediaMetadataRetriever
import android.os.Build
import android.graphics.Bitmap
import com.sstudio.thebadminton.Common
import com.sstudio.thebadminton.menu3.VideoActivity
import com.sstudio.thebadminton.menu3.mvp.upload.UploadActivity

class VideoAdapter(private val context: Context): RecyclerView.Adapter<VideoAdapter.VideoPlayerViewHolder>() {

    var videos: List<Video> = ArrayList()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): VideoPlayerViewHolder{
        return VideoPlayerViewHolder(
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item_video, viewGroup, false)
        )
    }

    override fun getItemCount(): Int {
        return videos.size
    }

    override fun onBindViewHolder(holder: VideoPlayerViewHolder, position: Int) {
        val video = videos[position]

        Glide.with(context)
            .load("${BASE_URL}/${video.thumbnailUrl}")
            .into(holder.iv_thumbnail)

        Log.d("taggAdapter", "${BASE_URL}${video.thumbnailUrl}")
        holder.txt_title.text = video.title
        holder.txt_name.text = video.name
        holder.txt_overview.text = video.overview

        holder.cv_video.setOnClickListener {
            val intent = Intent(context, DetailVideoActivity::class.java)
            intent.putExtra(DetailVideoActivity.EXTRA_DETAIL, video)
            context.startActivity(intent)
        }

        holder.cv_video.setOnLongClickListener {
            if (Common.isCoach) {
                video.id?.let { it1 ->
                    (context as VideoActivity).videoOnLongClick(
                        it1,
                        video.videoUrl
                    )
                }
            }
            true
        }
    }

    class VideoPlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val iv_thumbnail = itemView.iv_thumbnail
        val txt_title = itemView.txt_title
        val txt_name = itemView.txt_name
        val txt_overview = itemView.txt_overview
        val cv_video = itemView.cv_item_video
    }
}