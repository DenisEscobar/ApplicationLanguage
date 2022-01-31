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
    @Query("SELECT password FROM usuari WHERE name=:name")
    fun getpasswd(name:String):String
    @Query("SELECT * FROM usuari WHERE name=:name")
    fun getiduser(name:String):usuari
    @Query("SELECT * FROM usuari")
    fun getuser(): List<usuari>

    //usuaridades
    @Insert
    fun insertdades(info: usuaridades)

    @Query("SELECT * FROM dades WHERE id_usuari=:id and id_idioma=:idioma")
    fun getAlldades(id:String, idioma:String): usuaridades
    @Query("SELECT idiomaid From idioma where idioma=:idioma and conocimiento=:cono")
    fun getidiomaid(idioma:String, cono:String): String
    @Query("SELECT idiomaid From idioma where idioma=:idioma and tema=:cono")
    fun getidiomaidtema(idioma:String, cono:String): String
    //idioma
    @Insert
    suspend fun insertidioma(idioma: idioma)
    @Query("SELECT * From idioma")
    fun getallidiomas(): List<idioma>

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
    @Query("Select * FROM palabra_numero where idioma_id=:id")
    fun getAll_numero_id(id:String):List<palabra_numero>
    @Query("Select * FROM palabra_numero WHERE palabra_local=:local and idioma_id=:id")
    fun getpalabra(local:String,id: String):palabra_numero

    //palabra_alfabeto
    @Query("SELECT * FROM palabra_alfabeto WHERE id=:id")
    fun getPalabras_letras(id: String): palabra_alfabeto
    @Query("Select * FROM palabra_alfabeto where idioma_id=:id")
    fun getAll_numero_id_letra(id: String):List<palabra_alfabeto>
    @Query("Select * FROM palabra_alfabeto WHERE palabra_local=:local and idioma_id=:id")
    fun getletra(local:String,id: String):palabra_alfabeto

    //palabras
    @Query("Select * FROM palabras WHERE idioma_id=:id")
    fun getAllPalabras_id(id: String):List<palabras>
    @Query("SELECT * FROM palabras WHERE id=:id")
    fun getPalabras(id: String): palabras
    @Query("Select * FROM palabras where idioma_id=:id")
    fun getAll_Palabras_id(id: String):List<palabras>
    @Query("Select * FROM palabras WHERE palabra_local=:local and idioma_id=:id")
    fun getpalabrasfra(local:String, id: String):palabras

    //palabras_frases
    @Insert
    suspend fun insert_frases(frases: palabra_frase)
    @Query("Select * FROM frases WHERE idioma_id=:id")
    fun getAllFrases_id(id: String):List<palabra_frase>
    @Query("SELECT * FROM frases WHERE id=:id")
    fun getFrases(id: String): palabra_frase
    @Query("Select * FROM frases Where idioma_id=:id")
    fun getAll_Frase_id(id:String):List<palabra_frase>
    @Query("Select * FROM frases WHERE frase_local=:local and idioma_id=:id")
    fun getFrasesfra(local:String, id: String):palabra_frase


    //cojer conocimientos
    @Query("Select * FROM idioma WHERE tema=:local and idioma=:id")
    fun getConocimiento(local:String, id:String):List<idioma>

    //completado
    @Query("Update dades set completado=1 WHERE id_idioma=:idioma and id_usuari=:usuari")
    fun competar(idioma:String, usuari:String)
}