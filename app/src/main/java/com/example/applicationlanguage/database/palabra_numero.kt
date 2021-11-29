package com.example.applicationlanguage.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "palabra_numero")
data class palabra_numero(
    @PrimaryKey(autoGenerate = true)
    var id:Long=0L,
    @ColumnInfo(name="idioma_id")
    var idiomaid: String="",
    @ColumnInfo(name="palabra_aprender")
    var aprenderpalabra: String="",
    @ColumnInfo(name="palabra_local")
    var localpalabra: String="",
    @ColumnInfo(name="numero")
    var numero: Long=0L
)