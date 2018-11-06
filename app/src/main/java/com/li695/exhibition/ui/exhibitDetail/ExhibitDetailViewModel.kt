package com.li695.exhibition.ui.exhibitDetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.li695.exhibition.ExhibitionApplication
import com.li695.exhibition.domain.Exhibit

class ExhibitDetailViewModel(private val application: ExhibitionApplication) :
    ViewModel() {
    private val exhibition = MutableLiveData<Exhibit>()

    fun getExhibit(title: String): MutableLiveData<Exhibit> {
        val exhibit = application.exhibitsLoader.getExhibitList()
            .first { it.title == title }
        exhibition.value = exhibit
        return exhibition
    }

    companion object {
        class Factory(
            private val application: ExhibitionApplication
        ) : ViewModelProvider.NewInstanceFactory() {

            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return ExhibitDetailViewModel(application) as T
            }
        }
    }
}
