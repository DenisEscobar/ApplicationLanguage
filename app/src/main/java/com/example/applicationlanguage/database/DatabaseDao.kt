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
//    @Query("SELECT * FROM usuari ORDER BY userid DESC")
//    suspend fun getAlluser(): LiveData<List<usuari>>
    //@Query("SELECT name,password FROM usuari WHERE userid=':id'")
    //suspend fun getuser(id:String): usuari
    @Query("SELECT password FROM usuari WHERE name=:name")
    fun getpasswd(name:String):String

    //usuaridades
    @Insert
    suspend fun insertdades(info: usuaridades)

    @Query("SELECT * FROM dades WHERE id_usuari=:id and id_idioma=:idioma")
    fun getAlldades(id:String, idioma:String): usuaridades
    @Query("SELECT idiomaid From idioma where idioma=:idioma and conocimiento=:cono")
    fun getidiomaid(idioma:String, cono:String): String

    //idioma
    @Insert
    suspend fun insertidioma(idioma: idioma)

    //palabras
    @Insert
    suspend fun insertpalabra(palabras: palabras)
//por conocimintos
    @Query("SELECT id FROM palabras WHERE idioma_id=:id ORDER BY id ASC")
    suspend fun getAllIdPalabras(id: String): List<Long>

    @Query("SELECT palabra_aprender AS palabraApre,palabra_local AS palabraLocal FROM palabras WHERE id=:id")
    suspend fun getPalabras(id: String): List<palabraAprender>

    //palabra_alfabeto
    @Insert
    suspend fun insert_alfabeto(alfabeto: palabra_alfabeto)
    @Query("SELECT id FROM palabra_alfabeto WHERE idioma_id=:idi ORDER BY id DESC")
    suspend fun getAllIdPalabras_alfabeto(idi: String): List<Long>
    @Query("SELECT palabra_aprender,palabra_local,pronunciacio_local,pronunciacio_aprender FROM palabra_alfabeto WHERE id=:id")
    suspend fun getPalabras_alfabeto(id: String): palabraAprenderAlfabeto
    @Query("SELECT palabra_aprender,palabra_local,pronunciacio_local,pronunciacio_aprender FROM palabra_alfabeto WHERE idioma_id=:id ORDER BY id DESC")
    fun getAllpalabras_alfabeto_id(id: String):List<palabraAprenderAlfabeto>

    //palabra_numero
    @Insert
    suspend fun insert_numero(numero: palabra_numero)
    @Query("SELECT id FROM palabra_numero WHERE idioma_id=:id ORDER BY id DESC")
    fun getAllIdPalabras_numero(id: String): List<Long>
    @Query("SELECT palabra_aprender,palabra_local,numero FROM palabra_numero WHERE id=:id")
    fun getPalabras_numero(id: String): palabraAprenderNumero
    @Query("Select palabra_aprender, palabra_local, numero FROM palabra_numero WHERE idioma_id=:id ORDER BY id DESC")
    fun getAllpalabras_numero_id(id: String):List<palabraAprenderNumero>

}