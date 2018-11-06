package com.li695.exhibition.ui.exhibitList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.li695.exhibition.R

class ExhibitListFragment : androidx.fragment.app.Fragment() {

    private lateinit var viewModel: ObjectsListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.objects_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ObjectsListViewModel::class.java)
    }

    companion object {
        fun newInstance() = ObjectsListFragment()
    }

}
