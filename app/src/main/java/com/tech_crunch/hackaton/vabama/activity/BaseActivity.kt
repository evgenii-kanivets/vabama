package com.tech_crunch.hackaton.vabama.activity

import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * Base class to encapsulate common activity functionality.
 * Created on 11/8/17.
 *
 * @author Evgenii Kanivets
 */
abstract class BaseActivity : AppCompatActivity() {

    fun showToast(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}
