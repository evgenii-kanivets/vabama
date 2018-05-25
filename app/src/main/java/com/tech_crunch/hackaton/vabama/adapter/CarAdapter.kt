package com.tech_crunch.hackaton.vabama.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.tech_crunch.hackaton.vabama.R
import com.tech_crunch.hackaton.vabama.utils.ImageUtils
import android.graphics.BitmapFactory
import com.tech_crunch.hackaton.vabama.data.*


/**
 * Created by evgenii_kanivets on 5/25/18.
 */
class CarAdapter(private val cars: List<Car>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        if (view == null) {
            view = View.inflate(parent!!.context, R.layout.view_item_car, null)
        }

        val car = cars[position]

        view!!.findViewById<TextView>(R.id.tvTitle).text = car.title
        view.findViewById<TextView>(R.id.tvStatus).text = getStatus(car.status)
        val imageView = view.findViewById<ImageView>(R.id.ivImage)

        val icon = BitmapFactory.decodeResource(parent!!.context.resources, car.image)
        ImageUtils.displayRoundedPicture(parent.context, icon, imageView)

        return view
    }

    override fun getItem(position: Int): Any {
        return cars[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return cars.size
    }

    private fun getStatus(status: String): String {
        return when (status) {
            OK_STATUS -> "All clear"
            NEED_PAINTING_STATUS -> "Needs painting"
            NEED_REPAIR_STATUS -> "Needs repaire"
            NEED_CLEANING_STATUS -> "Needs clean"
            else -> {
                return "Unknown"
            }
        }
    }

}