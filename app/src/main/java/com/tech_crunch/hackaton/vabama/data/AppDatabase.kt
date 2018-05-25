package com.tech_crunch.hackaton.vabama.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

/**
 * Created by evgenii_kanivets on 5/25/18.
 */
@Database(entities = arrayOf(Car::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun carDao(): CarDao
}
