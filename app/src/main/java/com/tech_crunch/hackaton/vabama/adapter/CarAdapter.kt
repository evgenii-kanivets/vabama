package com.tech_crunch.hackaton.vabama.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.tech_crunch.hackaton.vabama.R
import com.tech_crunch.hackaton.vabama.utils.ImageUtils
import android.graphics.BitmapFactory
import android.support.v4.app.FragmentActivity
import com.tech_crunch.hackaton.vabama.activity.CarActivity
import com.tech_crunch.hackaton.vabama.data.*


/**
 * Created by evgenii_kanivets on 5/25/18.
 */
class CarAdapter(private val activity: FragmentActivity, private val cars: List<Car>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        if (view == null) {
            view = View.inflate(parent!!.context, R.layout.view_item_car, null)
        }

        val car = cars[position]

        view!!.findViewById<TextView>(R.id.tvTitle).text = car.plateNumber
        view.findViewById<TextView>(R.id.tvStatus).text = getStatus(car.status)
        val imageView = view.findViewById<ImageView>(R.id.ivImage)

        val context = parent!!.context
        val icon = BitmapFactory.decodeResource(context.resources, car.image)
        ImageUtils.displayRoundedPicture(context, icon, imageView)

        val listener = View.OnClickListener {
            activity.startActivity(CarActivity.newInstance(context, car.id.toInt()))
        }

        view.findViewById<View>(R.id.cardView).setOnClickListener(listener)
        imageView.setOnClickListener(listener)

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