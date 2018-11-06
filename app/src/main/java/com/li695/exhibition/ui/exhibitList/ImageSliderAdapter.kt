package com.li695.exhibition.ui.exhibitList

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.li695.exhibition.R
import com.squareup.picasso.Picasso


class ImageSliderAdapter(private val context: Context) :
    ListAdapter<String, ImageSliderAdapter.ViewHolder>(ImageDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image = getItem(position)
        holder.setImage(image)
    }

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.image_item, null)
        return ViewHolder(view)
    }

    class ViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {
        fun setImage(image: String) {
            Picasso
                .get()
                .load(image)
                .into(root.findViewById<ImageView>(R.id.imageView))
        }
    }
}