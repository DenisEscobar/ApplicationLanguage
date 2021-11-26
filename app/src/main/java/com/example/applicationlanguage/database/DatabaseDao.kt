package com.example.applicationlanguage.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DatabaseDao {
    //user
    @Insert
    suspend fun insertuser(usuari: usuari)

    @Query("SELECT * FROM usuari ORDER BY userid DESC")
    suspend fun getAlluser(): LiveData<List<usuari>>
//
    @Query("SELECT name,password FROM usuari WHERE userid=''")
    suspend fun getuser(): usuari



    //userdades
    @Insert
    suspend fun insertdades(info: usuaridades)

    @Query("SELECT * FROM dades ORDER BY userid DESC LIMIT 1")
    suspend fun getdades():usuaridades
    @Query("SELECT * FROM dades WHERE userid=''")
    suspend fun getAlldades(): LiveData<List<usuaridades>>



    //lenguage
    @Insert
    suspend fun insertidioma(idioma: idioma)


    //words
    @Insert
    suspend fun insertpalabra(palabras: palabras)
//por conocimintos
    @Query("SELECT id FROM palabras WHERE idioma_id='' ORDER BY id DESC")
    suspend fun getAllIdPalabras(): LiveData<List<usuari>>

    @Query("SELECT palabra_aprender,palabra_local FROM palabras WHERE id=''")
    suspend fun getPalabras(): LiveData<List<usuari>>

}