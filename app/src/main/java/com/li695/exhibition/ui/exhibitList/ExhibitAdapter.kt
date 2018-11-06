package com.li695.exhibition.ui.exhibitList

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.li695.exhibition.R
import com.li695.exhibition.domain.Exhibit


class ExhibitAdapter(private val context: Context) :
    ListAdapter<Exhibit, ExhibitAdapter.ViewHolder>(ExhibitDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val exhibit = getItem(position)
        holder.apply {
            setOnClickListener(View.OnClickListener {
                val bundle = Bundle()
                bundle.putString("title", exhibit.title)
                it.findNavController().navigate(R.id.exhibitDetailFragment, bundle)
            })
            setTitle(exhibit.title)
            setImages(exhibit.images)
        }
    }

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.exhibit_list_item, null)
        return ViewHolder(view)
    }

    class ViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {
        fun setTitle(title: String) {
            root.findViewById<TextView>(R.id.title).text = title
        }

        fun setImages(images: List<String>) {
            val pager = root.findViewById<RecyclerView>(R.id.imageRecycler)
            val adapter = ImageSliderAdapter(root.context)
            pager.adapter = adapter
            adapter.submitList(images)
        }

        fun setOnClickListener(listener: View.OnClickListener) {
            root.setOnClickListener(listener)
        }
    }
}