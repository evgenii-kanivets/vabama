package com.tech_crunch.hackaton.vabama.activity

import android.app.Activity
import android.arch.lifecycle.Observer
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
import com.tech_crunch.hackaton.vabama.dialog.WdywDialog
import com.tech_crunch.hackaton.vabama.fragment.ImageFragment
import com.tech_crunch.hackaton.vabama.utils.ImageUtils

import kotlinx.android.synthetic.main.activity_car.*
import kotlinx.android.synthetic.main.content_car.*

class CarActivity : BaseBackActivity() {

    private val carDao = VbmApp.app.appDatabase.carDao()
    private lateinit var car: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car)
        setSupportActionBar(toolbar)

        initViews()
    }

    override fun initViews() {
        super.initViews()

        val carLiveData = carDao.getById(intent.getIntExtra(KEY_CAR_ID, -1).toLong())
        carLiveData.observe(this, Observer<Car> {
            if (it == null) {
                finish()
            } else {
                car = it
                initViews(it)
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                REQUEST_ESTIMATION -> handleResult()
            }
        }
    }

    private fun initViews(car: Car) {
        toolbar.title = car.title

        tvTitle.text = car.plateNumber
        tvStatus.text = getStatus(car.status)

        val icon = BitmapFactory.decodeResource(resources, car.image)
        ImageUtils.displayRoundedPicture(this, icon, ivImage)

        initStatistics(car)
        initStatus(car.status)

        viewPager.adapter = MyFragmentPagerAdapter(supportFragmentManager)

        btnAction.setOnClickListener {
            val dialog = WdywDialog(this, object : WdywDialog.OnValidListener {
                override fun onValid() {
                    startEstimationActivity()
                }

            })
            dialog.show()
        }

        if (car.status == CLEANING_STATUS || car.status == REPAIRING_STATUS
                || car.status == PAINTING_STATUS || car.status == OK_STATUS) {
            btnAction.visibility = View.GONE
            viewPager.visibility = View.GONE
            cardInProgress.visibility = View.VISIBLE
            ivStatusImageInProgress.setImageResource(getRes(car.status))
            tvStatusTitleInProgress.text = getStatus(car.status)
        } else {
            btnAction.visibility = View.VISIBLE
            viewPager.visibility = View.VISIBLE
            cardInProgress.visibility = View.GONE
        }
    }

    private fun initStatistics(car: Car) {
        initCard(findViewById(R.id.card_mileage), car.mileage.toString(), "km")
        initCard(findViewById(R.id.card_rent), car.rent.toString(), "Rent")
        initCard(findViewById(R.id.card_repair), car.repair.toString(), "Repair")
        initCard(findViewById(R.id.card_maintenance), car.maintenance.toString(), "Mainten.")
    }

    private fun initCard(view: View, title: String, subtitle: String) {
        val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        val tvSubtitle = view.findViewById<TextView>(R.id.tvSubtitle)

        tvTitle.text = title
        tvSubtitle.text = subtitle
    }

    private fun initStatus(status: String) {
        ivStatusImage.setImageResource(getRes(status))
        tvStatusTitle.text = getStatus(status)
    }

    private fun getRes(status: String) = when (status) {
        OK_STATUS -> R.drawable.ic_histo
        NEED_PAINTING_STATUS -> R.drawable.ic_paint
        NEED_REPAIR_STATUS -> R.drawable.ic_repair
        NEED_CLEANING_STATUS -> R.drawable.ic_clean
        else -> R.drawable.ic_histo
    }

    private fun startEstimationActivity() {
        startActivityForResult(EstimationActivity.newIntent(this), REQUEST_ESTIMATION)
    }

    private fun handleResult() {
        when (car.status) {
            NEED_CLEANING_STATUS -> {
                car.status = CLEANING_STATUS
                carDao.update(car)
            }
            NEED_PAINTING_STATUS -> {
                car.status = PAINTING_STATUS
                carDao.update(car)
            }
            NEED_REPAIR_STATUS -> {
                car.status = REPAIRING_STATUS
                carDao.update(car)
            }
        }
    }

    companion object {

        private const val KEY_CAR_ID = "key_car_id"
        private const val REQUEST_ESTIMATION = 1

        fun newInstance(context: Context, carId: Int): Intent {
            val intent = Intent(context, CarActivity::class.java)
            intent.putExtra(KEY_CAR_ID, carId)
            return intent
        }

    }

    private inner class MyFragmentPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> ImageFragment.newInstance(R.drawable.durty)
                1 -> ImageFragment.newInstance(R.drawable.zoom_in)
                2 -> ImageFragment.newInstance(R.drawable.toyota_copie)
                3 -> ImageFragment.newInstance(R.drawable.top_view)
                else -> ImageFragment.newInstance(R.drawable.durty)
            }
        }

        override fun getCount(): Int {
            return 4
        }

    }

}
