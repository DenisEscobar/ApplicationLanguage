package com.example.applicationlanguage.database

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import androidx.room.Entity

@Entity(tableName="dades")
data class usuaridades(
    @PrimaryKey(autoGenerate = true)
    var id:Long=0L,
    @ColumnInfo(name="id_usuari")
    var userid:Long=0L,
    @ColumnInfo(name="id_idioma")
    var idiomaid: String="",
    @ColumnInfo(name="completado")
    var completado: Boolean=false
)
