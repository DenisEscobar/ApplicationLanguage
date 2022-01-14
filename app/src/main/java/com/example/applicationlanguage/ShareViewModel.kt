package com.example.applicationlanguage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShareViewModel: ViewModel(){
    val alfa = MutableLiveData<String>()
    val idioma = MutableLiveData<String>()
    val conocimiento = MutableLiveData<String>()
    val tema = MutableLiveData<String>()
    val inc = MutableLiveData<String>()

    fun sendalfa(text: String) {
        alfa.value = text
    }fun sendidioma(text: String) {
        idioma.value = text
    }fun sendtema(text: String){
        tema.value = text
    }fun sendconocimiento(text: String) {
        conocimiento.value = text
    }fun sendinc(text: Int) {
        inc.value = text.toString()
    }

    fun getalfa():String{
        return ""+alfa.value
    }fun getidioma():String{
        return ""+idioma.value
    }fun getconocimiento():String{
        return ""+conocimiento.value
    }fun gettema():String{
        return ""+tema.value
    }fun getall(): String {
        return ""+idioma.value+": "+tema.value+": "+conocimiento.value;
    }fun getinc():String{
        return ""+inc.value
    }
}