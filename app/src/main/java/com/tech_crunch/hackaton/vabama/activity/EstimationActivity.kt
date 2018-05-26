package com.tech_crunch.hackaton.vabama.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.tech_crunch.hackaton.vabama.R

import kotlinx.android.synthetic.main.content_estimation.*

class EstimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estimation)

        btnDone.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, EstimationActivity::class.java)
    }

}
