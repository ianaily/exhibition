package com.li695.exhibition.loaders

import com.li695.exhibition.domain.Exhibit

interface ExhibitsLoader {
    fun getExhibitList(): List<Exhibit>
}
