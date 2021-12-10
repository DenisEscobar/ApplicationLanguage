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
    private suspend fun getToNumeroFromDatabase(id:String): palabra_numero {
        var numero = database.getPalabras_numero(id)
        return numero
    }
    private suspend fun getToAlfabetoFromDatabase(id:String): palabra_alfabeto {
        var alfabeto = database.getPalabras_alfabeto(id)
        return alfabeto
    }
    private suspend fun getToPalabraFromDatabase(id:String): palabras {
        var palabra = database.getPalabras(id)
        return palabra
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
        touserpass.value?.username=name
        touserpass.value?.userpass = database.getpasswd(name).toString()
        if(pass==touserpass.value!!.userpass) {
            return "ok"
        }
        return "ko"
    }
    private suspend fun insertuser(user: usuari) {
        database.insertuser(user)
    }

}