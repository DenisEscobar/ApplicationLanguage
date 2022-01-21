package com.example.applicationlanguage.idioma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.applicationlanguage.R
import com.example.applicationlanguage.ShareViewModel
import com.example.applicationlanguage.databinding.FragmentConocimientoBinding

class ConocimientoFragment : Fragment() {
    lateinit var modelShare: ShareViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentConocimientoBinding>(
            inflater,
            R.layout.fragment_conocimiento, container, false
        )
        val modelShare = ViewModelProvider(requireActivity()).get(ShareViewModel::class.java)
        if (modelShare.gettema().toString() == "vocabulario") {
            binding.buttonSentimiento.text="Sentimiento"
            binding.buttonSentimiento.setOnClickListener { view: View ->
                view.findNavController()
                    .navigate(R.id.action_conocimientoFragment_to_paraulasOTestFragment)
                var conocimiento = "sentimiento"
                modelShare.sendconocimiento(conocimiento.toString())
            }
        }else if(modelShare.gettema().toString() == "frases"){
            binding.buttonSentimiento.text="personas"
            binding.buttonSentimiento.setOnClickListener { view: View ->
                view.findNavController()
                    .navigate(R.id.action_conocimientoFragment_to_paraulasOTestFragment)
                var conocimiento = "personas"
                modelShare.sendconocimiento(conocimiento.toString())
            }
        }

        return binding.root
    }
}