package com.example.applicationlanguage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.applicationlanguage.databinding.FragmentTemaBinding

class TemaFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentTemaBinding>(inflater,
            R.layout.fragment_tema,container,false)
        binding.buttonNumeros.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_temaFragment_to_paraulasOTestFragment)
            var tema="numero"
        }
        return binding.root
    }
}