package com.tech_crunch.hackaton.vabama

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.tech_crunch.hackaton.vabama.adapter.CarAdapter
import com.tech_crunch.hackaton.vabama.data.Car
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val carDao = VbmApp.app.appDatabase.carDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carDao.getAll().observe(this,
                Observer<List<Car>> { t -> if (t != null) listView.adapter = CarAdapter(t) })
    }
}
