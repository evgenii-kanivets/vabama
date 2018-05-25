package com.tech_crunch.hackaton.vabama.activity

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.view.View
import android.widget.TextView
import android.support.v4.app.FragmentManager
import com.tech_crunch.hackaton.vabama.R
import com.tech_crunch.hackaton.vabama.VbmApp
import com.tech_crunch.hackaton.vabama.data.*
import com.tech_crunch.hackaton.vabama.fragment.ImageFragment
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
        initStatus(car.status)

        viewPager.adapter = MyFragmentPagerAdapter(supportFragmentManager)
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

    private fun initStatus(status: String) {
        val res = when (status) {
            OK_STATUS -> R.drawable.ic_histo
            NEED_PAINTING_STATUS -> R.drawable.ic_paint
            NEED_REPAIR_STATUS -> R.drawable.ic_repair
            NEED_CLEANING_STATUS -> R.drawable.ic_clean
            else -> R.drawable.ic_histo
        }
        ivStatusImage.setImageResource(res)
        tvStatusTitle.text = getStatus(status)
    }

    companion object {

        private const val KEY_CAR_ID = "key_car_id"

        fun newInstance(context: Context, carId: Int): Intent {
            val intent = Intent(context, CarActivity::class.java)
            intent.putExtra(KEY_CAR_ID, carId)
            return intent
        }

    }

    private inner class MyFragmentPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> ImageFragment.newInstance(R.drawable.domage)
                1 -> ImageFragment.newInstance(R.drawable.toyota)
                2 -> ImageFragment.newInstance(R.drawable.domage)
                3 -> ImageFragment.newInstance(R.drawable.toyota)
                else -> ImageFragment.newInstance(R.drawable.domage)
            }
        }

        override fun getCount(): Int {
            return 4
        }

    }

}
