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
    @Query("SELECT * FROM usuari WHERE name=:name")
    fun getiduser(name:String):usuari

    //usuaridades
    @Insert
    fun insertdades(info: usuaridades)

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



    //palabra_alfabeto
    @Insert
    suspend fun insert_alfabeto(alfabeto: palabra_alfabeto)
    @Query("SELECT id FROM palabra_alfabeto WHERE idioma_id=:idi ORDER BY id")
    suspend fun getAllIdPalabras_alfabeto(idi: String): List<Long>
    @Query("SELECT palabra_aprender,palabra_local,pronunciacio_local,pronunciacio_aprender FROM palabra_alfabeto WHERE id=:id")
    suspend fun getPalabras_alfabeto(id: String): palabraAprenderAlfabeto
    @Query("SELECT id,palabra_aprender,palabra_local,pronunciacio_local,pronunciacio_aprender FROM palabra_alfabeto WHERE idioma_id=:id ORDER BY id")
    fun getAllpalabras_alfabeto_id(id: String):List<palabraAprenderAlfabeto>

    //palabra_numero
    @Insert
    suspend fun insert_numero(numero: palabra_numero)
    @Query("SELECT id FROM palabra_numero WHERE idioma_id=:id ORDER BY id DESC")
    fun getAllIdPalabras_numero(id: String): List<Long>
    @Query("SELECT * FROM palabra_numero WHERE id=:id")
    fun getPalabras_numero(id: String): palabra_numero
    @Query("Select palabra_aprender, palabra_local, numero FROM palabra_numero WHERE idioma_id=:id ORDER BY id ASC")
    fun getAllpalabras_numero_id(id: String):List<palabraAprenderNumero>
    @Query("Select max(id) FROM palabra_numero")
    fun getAll_numero_id():String

    @Query("Select * FROM palabra_numero WHERE palabra_local=:local")
    fun getpalabra(local:String):palabra_numero

    @Query("SELECT * FROM palabra_alfabeto WHERE id=:id")
    fun getPalabras_letras(id: String): palabra_alfabeto
    @Query("Select max(id) FROM palabra_alfabeto")
    fun getAll_numero_id_letra():String
    @Query("Select * FROM palabra_alfabeto WHERE palabra_local=:local")
    fun getletra(local:String):palabra_alfabeto

    @Query("Select * FROM palabras WHERE idioma_id=:id ORDER BY id ASC")
    fun getAllPalabras_id(id: String):List<palabras>
    @Query("SELECT * FROM palabras WHERE id=:id")
    fun getPalabras(id: String): palabras
    @Query("Select max(id) FROM palabras")
    fun getAll_Frase_id():String
    @Query("Select * FROM palabras WHERE palabra_local=:local")
    fun getpalabrasfra(local:String):palabras
}