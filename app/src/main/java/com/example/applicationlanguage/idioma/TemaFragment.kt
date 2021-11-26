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
import com.example.applicationlanguage.databinding.FragmentTemaBinding

class TemaFragment : Fragment() {
    lateinit var modelShare: ShareViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentTemaBinding>(inflater,
            R.layout.fragment_tema,container,false)
        binding.buttonNumeros.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_temaFragment_to_paraulasOTestFragment)
            var tema="numero"
            modelShare = ViewModelProvider(requireActivity()).get(ShareViewModel::class.java)
            modelShare.sendtema(tema.toString())
            modelShare.sendconocimiento(tema.toString())
        }
        binding.buttonAlfabeto.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_temaFragment_to_paraulasOTestFragment)
            var tema="alfabeto"
            modelShare = ViewModelProvider(requireActivity()).get(ShareViewModel::class.java)
            modelShare.sendtema(tema.toString())
            modelShare.sendconocimiento(tema.toString())
        }
        binding.buttonFrases.setOnClickListener { view:View ->
            view.findNavController().navigate(R.id.action_temaFragment_to_conocimientoFragment)
            var tema="frases"
            modelShare = ViewModelProvider(requireActivity()).get(ShareViewModel::class.java)
            modelShare.sendtema(tema.toString())
        }
        binding.buttonParaulas.setOnClickListener { view:View ->
            view.findNavController().navigate(R.id.action_temaFragment_to_conocimientoFragment)
            var tema="vocabulario"
            modelShare = ViewModelProvider(requireActivity()).get(ShareViewModel::class.java)
            modelShare.sendtema(tema.toString())
        }

        return binding.root
    }
}