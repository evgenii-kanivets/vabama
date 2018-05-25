package com.tech_crunch.hackaton.vabama

import android.app.Application
import android.arch.persistence.room.Room
import com.tech_crunch.hackaton.vabama.data.AppDatabase
import com.tech_crunch.hackaton.vabama.data.CarDao

/**
 * Created by evgenii_kanivets on 5/25/18.
 */
class VbmApp : Application() {

    lateinit var appDatabase: AppDatabase
    lateinit var carDao: CarDao

    override fun onCreate() {
        super.onCreate()

        app = this@VbmApp

        appDatabase = Room.databaseBuilder(applicationContext,
                AppDatabase::class.java, "database").allowMainThreadQueries().build()
        carDao = appDatabase.carDao()

        //DataLoader.loadData()
    }

    companion object {
        lateinit var app: VbmApp
    }
}
