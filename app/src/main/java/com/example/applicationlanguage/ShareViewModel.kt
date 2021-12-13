package com.example.applicationlanguage

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.applicationlanguage.database.DatabaseDao

class ShareViewModel: ViewModel(){
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

    fun getidioma():String{
        return ""+idioma.value
    }fun getconocimiento():String{
        return ""+conocimiento.value
    }fun gettema():String{
        return ""+tema.value
    }fun getall(): String {
        return ""+idioma.value+": "+tema.value+": "+conocimiento.value;
    }
}