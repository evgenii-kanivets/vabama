package com.tech_crunch.hackaton.vabama.data

import com.tech_crunch.hackaton.vabama.VbmApp

/**
 * Created by evgenii_kanivets on 5/25/18.
 */
object DataLoader {

    fun loadData() {
        val carDao = VbmApp.app.carDao
        carDao.insert(Car(1, "MD1012TZ", "Renaud Megan", OK_STATUS))
        carDao.insert(Car(2, "MD2012TZ", "Renaud Megan", NEED_CLEANING_STATUS))
        carDao.insert(Car(3, "MD3012TZ", "Renaud Megan", NEED_REPAIR_STATUS))
        carDao.insert(Car(4, "MD4012TZ", "Renaud Megan", OK_STATUS))
        carDao.insert(Car(5, "MD5012TZ", "Renaud Megan", OK_STATUS))
        carDao.insert(Car(6, "MD6012TZ", "Renaud Megan", NEED_REPAIR_STATUS))
        carDao.insert(Car(7, "MD7012TZ", "Renaud Megan", NEED_CLEANING_STATUS))
    }

}
