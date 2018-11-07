package com.li695.exhibition.ui.exhibitDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.li695.exhibition.ExhibitionApplication
import com.li695.exhibition.R
import com.li695.exhibition.ui.common.ImageSliderAdapter

class ExhibitDetailFragment : androidx.fragment.app.Fragment() {
    private lateinit var viewModel: ExhibitDetailViewModel
    private lateinit var title: TextView
    private lateinit var recycler: RecyclerView
    private lateinit var adapter: ImageSliderAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.exhibit_list_item, container, false)
        title = root.findViewById(R.id.title)
        recycler = root.findViewById(R.id.imageRecycler)
        adapter = ImageSliderAdapter(context!!)
        recycler.adapter = adapter
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val factory = ExhibitDetailViewModel.Companion.Factory(activity!!.application as ExhibitionApplication)
        viewModel = ViewModelProviders.of(this, factory).get(ExhibitDetailViewModel::class.java)
        val exhibitTitle = arguments?.getString("title") ?: ""
        viewModel.getExhibit(exhibitTitle).observe(this, Observer {
            title.text = it.title
            adapter.submitList(it.images)
        })
    }

}
