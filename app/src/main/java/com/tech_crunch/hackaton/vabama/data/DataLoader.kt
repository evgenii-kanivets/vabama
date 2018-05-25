package com.tech_crunch.hackaton.vabama.data

import com.tech_crunch.hackaton.vabama.R
import com.tech_crunch.hackaton.vabama.VbmApp

/**
 * Created by evgenii_kanivets on 5/25/18.
 */
object DataLoader {

    fun loadData() {
        val carDao = VbmApp.app.carDao
        carDao.insert(Car(1, "MD1012TZ", "Renaud Megan", R.drawable.car1, OK_STATUS))
        carDao.insert(Car(2, "MD2012TZ", "Ford Focus", R.drawable.car1, NEED_CLEANING_STATUS))
        carDao.insert(Car(3, "MD3012TZ", "Suzuki Megan", R.drawable.car1, NEED_REPAIR_STATUS))
        carDao.insert(Car(4, "MD4012TZ", "Citroen C1", R.drawable.car1, OK_STATUS))
        carDao.insert(Car(5, "MD5012TZ", "Renaud Forza", R.drawable.car1, OK_STATUS))
        carDao.insert(Car(6, "MD6012TZ", "Renaud PO", R.drawable.car1, NEED_REPAIR_STATUS))
        carDao.insert(Car(7, "MD7012TZ", "Ford C1", R.drawable.car1, NEED_CLEANING_STATUS))
        carDao.insert(Car(8, "MD6212TZ", "Ferrari Megan", R.drawable.car1, NEED_PAINTING_STATUS))
        carDao.insert(Car(9, "MD7112TZ", "Pojo Megan", R.drawable.car1, NEED_PAINTING_STATUS))
        carDao.insert(Car(10, "TR7112TZ", "Chloe Megan", R.drawable.car1, NEED_PAINTING_STATUS))
    }

}
