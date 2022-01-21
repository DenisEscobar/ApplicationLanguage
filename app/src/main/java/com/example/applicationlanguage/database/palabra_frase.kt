package com.example.applicationlanguage.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "frases")
data class palabra_frase(
    @PrimaryKey(autoGenerate = true)
    var id:Long=0L,
    @ColumnInfo(name="idioma_id")
    var idiomaid: String="",
    @ColumnInfo(name="frase_aprender")
    var aprenderfrase: String="",
    @ColumnInfo(name="frase_local")
    var localfrase: String=""
)