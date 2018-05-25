package com.tech_crunch.hackaton.vabama.activity

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.tech_crunch.hackaton.vabama.R
import com.tech_crunch.hackaton.vabama.VbmApp
import com.tech_crunch.hackaton.vabama.data.Car
import com.tech_crunch.hackaton.vabama.data.getStatus
import com.tech_crunch.hackaton.vabama.utils.ImageUtils

import kotlinx.android.synthetic.main.activity_car.*
import kotlinx.android.synthetic.main.content_car.*

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

        tvTitle.text = car.plateNumber
        tvStatus.text = getStatus(car.status)

        val icon = BitmapFactory.decodeResource(resources, car.image)
        ImageUtils.displayRoundedPicture(this, icon, ivImage)

        initStatistics(car)
    }

    private fun initStatistics(car: Car) {
        initCard(findViewById(R.id.card_mileage), car.mileage.toString(), "km")
        initCard(findViewById(R.id.card_rent), car.rent.toString(), "Rent")
        initCard(findViewById(R.id.card_repair), car.repair.toString(), "Repair")
        initCard(findViewById(R.id.card_maintenance), car.maintenance.toString(), "Maintenance")
    }

    private fun initCard(view: View, title: String, subtitle: String) {
        val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        val tvSubtitle = view.findViewById<TextView>(R.id.tvSubtitle)

        tvTitle.text = title
        tvSubtitle.text = subtitle
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
