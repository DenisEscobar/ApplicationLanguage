package com.example.applicationlanguage

import android.app.Application
import androidx.lifecycle.*
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
    fun setinfo(text: String) {
        infocorrecte.value = text
    }
    fun getinfo(): String {
        return ""+infocorrecte.value
    }
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
    fun firstall(){
        viewModelScope.launch {
            val idioma=idioma()
            val paal=palabra_alfabeto()
            val panu=palabra_numero()
            val pala=palabras()
            val usuda=usuaridades()
//idioma
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

    private var touserpass = MutableLiveData<usuari?>()

    fun onLoginUser(name:String, pass:String) {
        viewModelScope.launch {
            var a = comprobaruser(name, pass)
            setinfo(a)
        }

    }
    private suspend fun comprobaruser(name:String, pass: String): String {
        //touserpass.value?.username=name
        //touserpass.value?.userpass = database.getpasswd(name).toString()
        if(pass==database.getpasswd(name)) {
            return "ok"
        }
        return "ko"
    }
    private suspend fun insertuser(user: usuari) {
        database.insertuser(user)
    }

}