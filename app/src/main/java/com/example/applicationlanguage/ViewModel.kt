package com.example.applicationlanguage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel : ViewModel(){
    val idioma = MutableLiveData<String>()
    val conocimiento = MutableLiveData<String>()
    val tema = MutableLiveData<String>()

    fun sendidioma(text: String) {
        idioma.value = text
    }fun sendtema(text: String){
        tema.value = text
    }fun sendconocimiento(text: String) {
        conocimiento.value = text
    }
}