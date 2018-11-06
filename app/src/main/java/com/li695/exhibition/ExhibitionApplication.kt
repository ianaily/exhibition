package com.li695.exhibition

import android.app.Application
import com.li695.exhibition.loaders.ExhibitsLoader
import com.li695.exhibition.loaders.FileExhibitsLoader

class ExhibitionApplication : Application() {
    val exhibitsLoader: ExhibitsLoader by lazy { FileExhibitsLoader(baseContext) }
}