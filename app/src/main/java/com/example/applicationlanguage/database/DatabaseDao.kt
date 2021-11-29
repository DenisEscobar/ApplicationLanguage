package com.example.applicationlanguage.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DatabaseDao {
    //usuari
    @Insert
    suspend fun insertuser(usuari: usuari)
    @Query("SELECT * FROM usuari ORDER BY userid DESC")
    suspend fun getAlluser(): LiveData<List<usuari>>
    @Query("SELECT name,password FROM usuari WHERE userid=':id'")
    suspend fun getuser(id:String): usuari
    @Query("SELECT password FROM usuari WHERE name=':name'")
    suspend fun getpass(name:String):usuari

    //usuaridades
    @Insert
    suspend fun insertdades(info: usuaridades)

    @Query("SELECT * FROM dades WHERE id_usuari=':id'")
    suspend fun getAlldades(id:String): LiveData<List<usuaridades>>

    //idioma
    @Insert
    suspend fun insertidioma(idioma: idioma)

    //palabras
    @Insert
    suspend fun insertpalabra(palabras: palabras)
//por conocimintos
    @Query("SELECT id FROM palabras WHERE idioma_id=':id' ORDER BY id DESC")
    suspend fun getAllIdPalabras(id: String): LiveData<List<palabras>>

    @Query("SELECT palabra_aprender,palabra_local FROM palabras WHERE id=':id'")
    suspend fun getPalabras(id: String): palabras

    //palabra_alfabeto
    @Insert
    suspend fun insert_alfabeto(alfabeto: palabra_alfabeto)
    @Query("SELECT id FROM palabra_alfabeto WHERE idioma_id=':id' ORDER BY id DESC")
    suspend fun getAllIdPalabras_alfabeto(id: String): LiveData<List<palabra_alfabeto>>
    @Query("SELECT palabra_aprender,palabra_local,pronunciacio_local,pronunciacio_aprender FROM palabra_alfabeto WHERE id=':id'")
    suspend fun getPalabras_alfabeto(id: String): palabra_alfabeto

    //palabra_numero
    @Insert
    suspend fun insert_numero(numero: palabra_numero)
    @Query("SELECT id FROM palabra_numero WHERE idioma_id=':id' ORDER BY id DESC")
    suspend fun getAllIdPalabras_numero(id: String): LiveData<List<palabra_numero>>
    @Query("SELECT palabra_aprender,palabra_local,numero FROM palabra_numero WHERE id=':id'")
    suspend fun getPalabras_numero(id: String): palabra_numero

}