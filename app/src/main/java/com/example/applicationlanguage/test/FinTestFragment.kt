package com.example.applicationlanguage.test

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
import com.example.applicationlanguage.databinding.FragmentFinTestBinding
import com.example.applicationlanguage.sharedpref.sharedApp

class FinTestFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentFinTestBinding>(inflater,
            R.layout.fragment_fin_test,container,false)
        binding.textViewNom.setText(sharedApp.prefes.name.toString())
        val model = ViewModelProvider(requireActivity()).get(ShareViewModel::class.java)
        binding.textViewIncorrectas.setText(model.getinc())
        binding.button2.setText("Atras")
        binding.button2.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_finTestFragment_to_temaFragment)
        }
        return binding.root
    }
}