package com.li695.exhibition.loaders

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.li695.exhibition.domain.Exhibit
import com.li695.exhibition.domain.ExhibitList

class FileExhibitsLoader(private val context: Context) : ExhibitsLoader {
    private val exhibitType = object : TypeToken<ExhibitList>() {}.type
    private var jsonReader: JsonReader? = null

    override fun getExhibitList(): List<Exhibit> {
        val inputStream = context.assets.open("exhibitions.json")
        jsonReader = JsonReader(inputStream.reader())
        val exhibitList: ExhibitList = Gson().fromJson(jsonReader, exhibitType)
        jsonReader?.close()
        return exhibitList.list
    }
}