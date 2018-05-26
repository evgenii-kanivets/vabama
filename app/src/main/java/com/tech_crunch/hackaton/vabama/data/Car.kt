package com.tech_crunch.hackaton.vabama.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

/**
 * Created by evgenii_kanivets on 5/25/18.
 */
@Dao
interface CarDao {

    @Query("SELECT * FROM car")
    fun getAll(): LiveData<List<Car>>

    @Query("SELECT * FROM car WHERE status = :status")
    fun getAllWithStatus(status: String): LiveData<List<Car>>

    @Query("SELECT * FROM car WHERE id = :id")
    fun getById(id: Long): LiveData<Car>

    @Insert
    fun insert(user: Car)

    @Update
    fun update(user: Car)

    @Delete
    fun delete(user: Car)

}

@Entity
data class Car(@PrimaryKey(autoGenerate = true) val id: Long, val plateNumber: String,
               val title: String, val image: Int, val status: String,
               val mileage: Int, val rent: Int, val repair: Int, val maintenance: Int)

const val OK_STATUS = "OK"
const val NEED_CLEANING_STATUS = "NEED_CLEANING"
const val CLEANING_STATUS = "CLEANING"
const val NEED_REPAIR_STATUS = "NEED_REPAIR"
const val REPAIRING_STATUS = "REPAIRING"
const val NEED_PAINTING_STATUS = "NEED_PAINTING"
const val PAINTING_STATUS = "PAINTING"
const val ALL_STATUS = "ALL"

fun getStatus(status: String): String {
    return when (status) {
        OK_STATUS -> "All clear"
        NEED_PAINTING_STATUS -> "Needs painting"
        PAINTING_STATUS -> "Painting in progress"
        NEED_REPAIR_STATUS -> "Needs repair"
        REPAIRING_STATUS -> "Repair in progress"
        NEED_CLEANING_STATUS -> "Needs clean"
        CLEANING_STATUS -> "Cleaning in progress"
        else -> {
            return "Unknown"
        }
    }
}
