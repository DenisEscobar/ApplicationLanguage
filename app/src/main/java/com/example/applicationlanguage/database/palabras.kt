package com.example.applicationlanguage.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "palabras")
data class palabras(
    @PrimaryKey(autoGenerate = true)
    var id:Long=0L,
    @ColumnInfo(name="idioma_id")
    var idiomaid: String="",
    @ColumnInfo(name="palabra_aprender")
    var aprenderpalabra: String="",
    @ColumnInfo(name="palabra_local")
    var localpalabra: String=""
)