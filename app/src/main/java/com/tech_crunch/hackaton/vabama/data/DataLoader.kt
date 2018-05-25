package com.tech_crunch.hackaton.vabama.data

import com.tech_crunch.hackaton.vabama.R
import com.tech_crunch.hackaton.vabama.VbmApp

/**
 * Created by evgenii_kanivets on 5/25/18.
 */
object DataLoader {

    fun loadData() {
        val carDao = VbmApp.app.carDao
        carDao.insert(Car(1, "ZY1012TZ", "Chrysler 300s", R.drawable.car1, OK_STATUS,
                150000, 145, 4, 6))
        carDao.insert(Car(2, "MD2012TZ", "Chrysler 300 Limited Awd", R.drawable.car2, NEED_CLEANING_STATUS,
                160000, 113, 5, 10))
        carDao.insert(Car(3, "MD3012TZ", "Chrysler 300s black", R.drawable.car3, NEED_REPAIR_STATUS,
                170000, 90, 6, 0))
        carDao.insert(Car(4, "MD4012TZ", "Chrysler 300s", R.drawable.car4, OK_STATUS,
                130000, 40, 7, 10))
        carDao.insert(Car(5, "MD5012TZ", "Toyota Prius", R.drawable.car5, OK_STATUS,
                120000, 50, 8, 8))
        carDao.insert(Car(6, "MD6012TZ", "Toyota Prius Blue", R.drawable.car6, NEED_REPAIR_STATUS,
                140000, 70, 10, 4))
        carDao.insert(Car(7, "MD7012TZ", "toyota Prius White", R.drawable.car7, NEED_CLEANING_STATUS,
                130000, 80, 19, 5))
        carDao.insert(Car(8, "MD6212TZ", "Mercedes Benz C-Class Coupe", R.drawable.car8, NEED_PAINTING_STATUS,
                100000, 80, 3, 0))
        carDao.insert(Car(9, "MD7112TZ", "Mercedes Benz C-Class Coupe", R.drawable.car9, NEED_PAINTING_STATUS,
                90000, 70, 4, 12))
        carDao.insert(Car(10, "TR7112TZ", "Mercedes Benz C-Class White", R.drawable.car10, NEED_PAINTING_STATUS,
                10000, 30, 6, 8))
    }

}
