package com.tech_crunch.hackaton.vabama.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.tech_crunch.hackaton.vabama.R
import com.tech_crunch.hackaton.vabama.data.Car

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
        view.findViewById<TextView>(R.id.tvStatus).text = car.status

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

}