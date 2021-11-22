package com.example.applicationlanguage.mostrar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.applicationlanguage.R
import com.example.applicationlanguage.ViewModel
import com.example.applicationlanguage.databinding.FragmentMostrarBinding

class MostrarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMostrarBinding>(inflater,
            R.layout.fragment_mostrar,container,false)

        var tema=""
        var conocimiento=""
        var idioma=""
        val model = ViewModelProvider(requireActivity()).get(ViewModel::class.java)
        model.idioma.observe(viewLifecycleOwner, Observer {
            idioma = it
            //binding.textViewmostrar.text = idioma
        })
        model.tema.observe(viewLifecycleOwner, Observer {
            tema = it
        })
        model.conocimiento.observe(viewLifecycleOwner, Observer {
            conocimiento = it
        })
        var tex=idioma+": "+tema+": "+conocimiento
        binding.textViewmostrar.text = tex
        return binding.root
    }
}