package com.li695.exhibition.ui.exhibitList

import androidx.recyclerview.widget.DiffUtil

import com.li695.exhibition.domain.Exhibit


class ExhibitDiffCallback : DiffUtil.ItemCallback<Exhibit>() {

    override fun areItemsTheSame(oldItem: Exhibit, newItem: Exhibit): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Exhibit, newItem: Exhibit): Boolean {
        return oldItem == newItem
    }
}
