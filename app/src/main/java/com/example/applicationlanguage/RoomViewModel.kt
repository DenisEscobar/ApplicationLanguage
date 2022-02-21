package com.example.applicationlanguage

import android.app.Application
import androidx.lifecycle.*
import androidx.room.ColumnInfo
import com.example.applicationlanguage.database.*
import kotlinx.coroutines.launch

class RoomViewModel(
    val database: DatabaseDao,
    application: Application
) : AndroidViewModel(application) {

    private var infocorrecte=MutableLiveData<String>()
    private var palabra=MutableLiveData<palabra_numero>()
    private var letra=MutableLiveData<palabra_alfabeto>()
    private var frase=MutableLiveData<palabra_frase>()

    fun getfrase(id: String): List<palabra_frase> {
        val frase=database.getAllFrases_id(id)
        return frase
    }
    fun getnumero(id: String): List<palabraAprenderNumero> {
        val num=database.getAllpalabras_numero_id(id)
        return num
    }
    fun getAlfabeto(id:String):List<palabraAprenderAlfabeto>{
        val alf=database.getAllpalabras_alfabeto_id(id)
        return alf
    }
    fun getPalabra(id:String):List<palabras>{
        val fra = database.getAllPalabras_id(id)
        return fra
    }
    fun setinfo(text: String) {
        infocorrecte.value = text
    }
    fun getinfo(): String {
        return ""+infocorrecte.value
    }
    fun setpal(text: palabra_numero){
        palabra.value=text
    }
    fun setpalal(text: palabra_alfabeto){
        letra.value=text
    }
    fun getpal(): palabra_numero? {
        return palabra.value
    }


    fun onRegisterUser(u:String, p:String, e:String) {
        viewModelScope.launch {
            val newuser = usuari()
            newuser.username=u
            newuser.userpass=p
            newuser.useremail=e
            insertuser(newuser)
        }
    }


    fun onLoginUser(name:String, pass:String) {
        viewModelScope.launch {
            var a = comprobaruser(name, pass)
            setinfo(a)
        }

    }
    private suspend fun comprobaruser(name:String, pass: String): String {
        if(pass==database.getpasswd(name)) {
            return "ok"
        }
        return "ko"
    }
    private suspend fun insertuser(user: usuari) {
        database.insertuser(user)
    }
    fun mirarid(idioma:String, conocimineto:String): String {
        return database.getidiomaid(idioma, conocimineto)
    }
    fun miraridtema(idioma:String, tema:String): String {
        return database.getidiomaid(idioma, tema)
    }
    fun palabraIdNumero(idIdioma:String): List<Long> {
        return database.getAllIdPalabras_numero(idIdioma)
    }
    fun palabraNumero(idNumero:String): palabra_numero {
        return database.getPalabras_numero(idNumero)
    }

    fun getallids(id: String): List<palabra_numero>{
        return database.getAll_numero_id(id)
    }
    fun getpalabra(palabra:String,id: String): palabra_numero{
        return database.getpalabra(palabra,id)
    }
    fun getallidsalfabeto(idIdioma: String): List<palabraAprenderAlfabeto>{
        return database.getAllpalabras_alfabeto_id(idIdioma)
    }
    fun palabraletra(idNumero:String): palabra_alfabeto {
        return database.getPalabras_letras(idNumero)
    }
    fun getallidsletra(id:String): List<palabra_alfabeto>{
        return database.getAll_numero_id_letra(id)
    }
    fun getletra(palabra:String,id: String): palabra_alfabeto{
        return database.getletra(palabra,id)
    }
    fun getallids_fra(id:String): List<palabras>{
        return database.getAll_Palabras_id(id)
    }
    fun palabraFra(idFrase:String): palabras {
        return database.getPalabras(idFrase)
    }
    fun getpalabrapal(palabra:String, id:String): palabras{
        return database.getpalabrasfra(palabra,id)
    }
//falsta mas....
    fun getallids_frases(id:String): List<palabra_frase>{
        return database.getAll_Frase_id(id)
    }
    fun palabraFrases(idFrase:String): palabra_frase {
        return database.getFrases(idFrase)
    }
    fun getpalabrafrases(palabra:String, id: String): palabra_frase{
        return database.getFrasesfra(palabra,id)
    }

    fun creardades(nameid:String){
        val newuser = usuaridades()
        for(i in database.getallidiomas()){
            newuser.userid= nameid.toLong()
            newuser.idiomaid=i.idiomaid
            newuser.completado=false
            database.insertdades(newuser)
        }
    }
    fun getuserid(name: String): String{
        return database.getiduser(name).userid.toString()
    }
    fun getuser(): List<usuari> {
        val coma = database.getuser()
        return coma
    }
    fun getconocimiento(name: String,id: String): List<idioma>{
        return database.getConocimiento(name,id)
    }
    fun completar(idioma:String, usuari:String){
        database.competar(idioma,usuari)
    }
}