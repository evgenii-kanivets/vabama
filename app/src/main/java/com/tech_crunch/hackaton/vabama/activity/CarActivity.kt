package com.tech_crunch.hackaton.vabama.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.tech_crunch.hackaton.vabama.R
import com.tech_crunch.hackaton.vabama.VbmApp
import com.tech_crunch.hackaton.vabama.data.Car

import kotlinx.android.synthetic.main.activity_car.*

class CarActivity : BaseBackActivity() {

    private val carDao = VbmApp.app.appDatabase.carDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car)
        setSupportActionBar(toolbar)

        initViews()
    }

    override fun initViews() {
        super.initViews()

        val car = carDao.getById(intent.getIntExtra(KEY_CAR_ID, -1).toLong())
        toolbar.title = car.title
    }

    companion object {

        private const val KEY_CAR_ID = "key_car_id"

        fun newInstance(context: Context, carId: Int): Intent {
            val intent = Intent(context, CarActivity::class.java)
            intent.putExtra(KEY_CAR_ID, carId)
            return intent
        }

    }

}
