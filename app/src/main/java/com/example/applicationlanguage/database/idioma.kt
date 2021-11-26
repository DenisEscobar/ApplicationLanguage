package com.example.applicationlanguage.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "idioma")
data class idioma(
    @PrimaryKey
    var idiomaid: String="",
    @ColumnInfo(name="idioma")
    var idioma: String="",
    @ColumnInfo(name="tema")
    var tema: String="",
    @ColumnInfo(name="conocimiento")
    var conocimiento: String=""
)
