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

    private var touser = MutableLiveData<usuari?>()
    private var toidioma = MutableLiveData<idioma?>()
    private var todades = MutableLiveData<usuaridades?>()
    private var tonumero = MutableLiveData<palabra_numero?>()
    private var toalfabeto = MutableLiveData<palabra_alfabeto?>()
    private var topalabra = MutableLiveData<palabras?>()

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
    fun getpal(): palabra_numero? {return palabra.value}
//    private fun initializeToUser(id:String) {
//        viewModelScope.launch {
//            touser.value = getToUserFromDatabase(id)
//        }
//    }
/*
private fun initializeTonumero(id:String) {
    viewModelScope.launch {
        tonumero.value = getToNumeroFromDatabase(id)
    }
}
private fun initializeToalfabeto(id:String) {
    viewModelScope.launch {
        toalfabeto.value = getToAlfabetoFromDatabase(id)
    }
}
private fun initializeTopalabra(id:String) {
    viewModelScope.launch {
        topalabra.value = getToPalabraFromDatabase(id)
    }
}

//private suspend fun getToUserFromDatabase(id:String): usuari {
    //var user = database.getuser(id)
    //return user
//}

private suspend fun getToNumeroFromDatabase(id:String): palabra_numero? {
    var numero = database.getPalabras_numero(id)
    return numero
}
private suspend fun getToAlfabetoFromDatabase(id:String): palabra_alfabeto? {
    var alfabeto = database.getPalabras_alfabeto(id)
    return alfabeto
}
private suspend fun getToPalabraFromDatabase(id:String): palabras? {
    var palabra = database.getPalabras(id)
    return palabra
}
*/
/*    fun firstall(){
        viewModelScope.launch {
            val idioma=idioma()
            val paal=palabra_alfabeto()
            val panu=palabra_numero()
            val pala=palabras()
            val usuda=usuaridades()
//idioma
            paal.id=2
            paal.idiomaid="1"
            paal.aprenderpalabra="b"
            paal.localpalabra="b"
            paal.pronunciacio_aprender="b"
            paal.pronunciacio_local="b"
            insertalfabeto(paal)

            idioma.idiomaid="1"
            idioma.idioma="ingles"
            idioma.conocimiento="alfabeto"
            idioma.tema="alfabeto"
            insertidioma(idioma)

            idioma.idiomaid="2"
            idioma.idioma="ingles"
            idioma.conocimiento="numero"
            idioma.tema="numero"
            insertidioma(idioma)
//alfabeto
            paal.id=1
            paal.idiomaid="1"
            paal.aprenderpalabra="a"
            paal.localpalabra="a"
            paal.pronunciacio_aprender="a"
            paal.pronunciacio_local="a"
            insertalfabeto(paal)
//numero
            panu.id=2
            panu.idiomaid="2"
            panu.aprenderpalabra="one"
            panu.localpalabra="uno"
            panu.numero=1
            insertnumero(panu)

            panu.id=3
            panu.idiomaid="2"
            panu.aprenderpalabra="two"
            panu.localpalabra="dos"
            panu.numero=2
            insertnumero(panu)
//userdadas
            usuda.id=1
            usuda.userid=1
            usuda.idiomaid="1"
            usuda.completado=false
            insertuserdadas(usuda)

            usuda.id=2
            usuda.userid=1
            usuda.idiomaid="2"
            usuda.completado=false
            insertuserdadas(usuda)
        }
    }
    private suspend fun insertuserdadas(dada: usuaridades) {
        database.insertdades(dada)
    }
    private suspend fun insertnumero(num: palabra_numero) {
        database.insert_numero(num)
    }
    private suspend fun insertidioma(idioma: idioma) {
        database.insertidioma(idioma)
    }
    private suspend fun insertalfabeto(p_al: palabra_alfabeto) {
        database.insert_alfabeto(p_al)
    }
    */

    fun onRegisterUser(u:String, p:String, e:String) {
        viewModelScope.launch {
            val newuser = usuari()
            newuser.username=u
            newuser.userpass=p
            newuser.useremail=e
            insertuser(newuser)
            //touser.value = getToUserFromDatabase(""+newuser.userid)
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
    fun verpalabras(conocimiento:String,Idioma:String){
        viewModelScope.launch {
            var idIdioma=mirarid(Idioma,conocimiento)
            if(conocimiento=="numero") {
//                var id = palabraIdNumero(idIdioma)
//                var i=0
//                while(i<id.size){
//                    var num = palabraNumero(id[i].toString())
//                    setpal(num)
//                    i++
//                }

            }else if(conocimiento=="alfabeto"){
//                var id = getallidsalfabeto(idIdioma)
//                var i=0
//                while(i<id.size){
//                    var alf = palabraletra(id[i].toString())
//                    setpalal(alf)
//                    i++
//                }
            }

        }
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
//        newuser.userid= nameid.toLong()
//        newuser.idiomaid="1"
//        newuser.completado=false
//        database.insertdades(newuser)
//        newuser.userid= nameid.toLong()
//        newuser.idiomaid="2"
//        newuser.completado=false
//        database.insertdades(newuser)
//        newuser.userid= nameid.toLong()
//        newuser.idiomaid="3"
//        newuser.completado=false
//        database.insertdades(newuser)
//        newuser.userid= nameid.toLong()
//        newuser.idiomaid="4"
//        newuser.completado=false
//        database.insertdades(newuser)
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