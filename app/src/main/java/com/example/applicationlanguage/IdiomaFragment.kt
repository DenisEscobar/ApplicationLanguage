package com.example.applicationlanguage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.applicationlanguage.databinding.FragmentIdiomaBinding

class IdiomaFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentIdiomaBinding>(inflater,
            R.layout.fragment_idioma,container,false)
        binding.buttonIngles.setOnClickListener { view:View ->
            view.findNavController().navigate(R.id.action_idiomaFragment_to_temaFragment)
            var idioma="ingles"

        }
        return binding.root
    }
}