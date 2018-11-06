package com.li695.exhibition.ui.exhibitList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.li695.exhibition.ExhibitionApplication
import com.li695.exhibition.domain.Exhibit

class ExhibitListViewModel(private val application: ExhibitionApplication) :
    ViewModel() {
    private val exhibitions = MutableLiveData<List<Exhibit>>()

    fun getExhibitions(): MutableLiveData<List<Exhibit>> {
        val exhibitList = application.exhibitsLoader.getExhibitList()
        exhibitions.value = exhibitList
        return exhibitions
    }

    companion object {
        class Factory(
            private val application: ExhibitionApplication
        ) : ViewModelProvider.NewInstanceFactory() {

            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return ExhibitListViewModel(application) as T
            }
        }
    }
}
