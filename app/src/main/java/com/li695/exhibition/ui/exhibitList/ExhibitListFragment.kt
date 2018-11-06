package com.li695.exhibition.ui.exhibitList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.li695.exhibition.ExhibitionApplication
import com.li695.exhibition.R

class ExhibitListFragment : androidx.fragment.app.Fragment() {

    private lateinit var recycler: RecyclerView
    private lateinit var viewModel: ExhibitListViewModel
    private lateinit var adapter: ExhibitAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.exhibit_list_fragment, container, false)
        recycler = root.findViewById(R.id.exhibitList)
        adapter = ExhibitAdapter(context!!)
        recycler.adapter = adapter
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val factory = ExhibitListViewModel.Companion.Factory(activity!!.application as ExhibitionApplication)
        viewModel = ViewModelProviders.of(this, factory).get(ExhibitListViewModel::class.java)
        viewModel.getExhibitions().observe(this, Observer { adapter.submitList(it) })
    }

}
