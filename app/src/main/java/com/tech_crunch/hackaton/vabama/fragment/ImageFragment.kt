package com.tech_crunch.hackaton.vabama.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tech_crunch.hackaton.vabama.R
import kotlinx.android.synthetic.main.fragment_image.*

/**
 * Created by evgenii_kanivets on 5/25/18.
 */
class ImageFragment : Fragment() {

    private var imageResId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        imageResId = arguments!!.getInt(KEY_IMAGE_ID)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageView.setImageResource(imageResId)
    }

    companion object {

        private const val KEY_IMAGE_ID = "key_status"

        fun newInstance(imageResId: Int): ImageFragment {
            val fragment = ImageFragment()
            val bundle = Bundle()
            bundle.putInt(KEY_IMAGE_ID, imageResId)
            fragment.arguments = bundle
            return fragment
        }

    }

}
