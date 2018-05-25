package com.tech_crunch.hackaton.vabama.activity

import android.view.MenuItem
import com.tech_crunch.hackaton.vabama.R

/**
 * Base activity class to encapsulate common functionality. Adds back button.
 * Created on 11/8/17.
 *
 * @author Evgenii Kanivets
 */
abstract class BaseBackActivity : BaseActivity() {

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    open protected fun initViews() {
        initToolbar()
    }

    open protected fun initToolbar() {
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
