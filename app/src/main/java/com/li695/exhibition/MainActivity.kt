package com.li695.exhibition

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.li695.exhibition.ui.objectslist.ObjectsListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ObjectsListFragment.newInstance())
                .commitNow()
        }
    }
}
