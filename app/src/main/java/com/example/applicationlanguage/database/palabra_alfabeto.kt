package com.example.applicationlanguage.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "palabra_alfabeto")
data class palabra_alfabeto(
    @PrimaryKey(autoGenerate = true)
    var id:Long=0L,
    @ColumnInfo(name="idioma_id")
    var idiomaid: String="",
    @ColumnInfo(name="palabra_aprender")
    var aprenderpalabra: String="",
    @ColumnInfo(name="palabra_local")
    var localpalabra: String="",
    @ColumnInfo(name="pronunciacio_local")
    var pronunciacio_local: String="",
    @ColumnInfo(name="pronunciacio_aprender")
    var pronunciacio_aprender: String=""
)