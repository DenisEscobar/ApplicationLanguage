package com.example.applicationlanguage.mostrar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.applicationlanguage.R
import com.example.applicationlanguage.ShareViewModel
import com.example.applicationlanguage.databinding.FragmentAlfabetoMostrarBinding
import com.example.applicationlanguage.databinding.FragmentFirstBinding

class AlfabetoMostrarFragment : Fragment() {
    lateinit var modelShare: ShareViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentAlfabetoMostrarBinding>(inflater,
            R.layout.fragment_alfabeto_mostrar,container,false)
        modelShare = ViewModelProvider(requireActivity()).get(ShareViewModel::class.java)
        binding.textViewAlfabeto.text = modelShare.getalfa()

        return binding.root
    }
}