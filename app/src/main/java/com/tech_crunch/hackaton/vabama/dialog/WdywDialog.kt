package com.tech_crunch.hackaton.vabama.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.WindowManager
import com.tech_crunch.hackaton.vabama.R

/**
 * Created by evgenii_kanivets on 5/26/18.
 */
class WdywDialog(context: Context) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_wdyw)
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT)
    }

}
