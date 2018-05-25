package com.tech_crunch.hackaton.vabama.fragment

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tech_crunch.hackaton.vabama.R
import com.tech_crunch.hackaton.vabama.VbmApp
import com.tech_crunch.hackaton.vabama.adapter.CarAdapter
import com.tech_crunch.hackaton.vabama.data.ALL_STATUS
import com.tech_crunch.hackaton.vabama.data.Car
import kotlinx.android.synthetic.main.fragment_page.*

/**
 * Created by evgenii_kanivets on 5/25/18.
 */
class PageFragment : Fragment() {

    private val carDao = VbmApp.app.appDatabase.carDao()

    private lateinit var status: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        status = arguments?.getString(KEY_STATUS) ?: ""
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (status == ALL_STATUS) {
            carDao.getAll().observe(this,
                    Observer<List<Car>> { t -> if (t != null) listView.adapter = CarAdapter(activity!!, t) })
        } else {
            carDao.getAllWithStatus(status).observe(this,
                    Observer<List<Car>> { t -> if (t != null) listView.adapter = CarAdapter(activity!!, t) })
        }
    }

    companion object {

        private const val KEY_STATUS = "key_status"

        fun newInstance(status: String): PageFragment {
            val fragment = PageFragment()
            val bundle = Bundle()
            bundle.putString(KEY_STATUS, status)
            fragment.arguments = bundle
            return fragment
        }

    }

}
