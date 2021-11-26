package com.example.applicationlanguage.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuari")
data class usuari(
    @PrimaryKey(autoGenerate = true)
    var userid:Long=0L,
    @ColumnInfo(name="name")
    var username: String="",
    @ColumnInfo(name="password")
    var userpass: String="",
    @ColumnInfo(name="email")
    var useremail: String=""
)