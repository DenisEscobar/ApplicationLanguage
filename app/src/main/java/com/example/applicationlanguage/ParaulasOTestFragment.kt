package com.example.applicationlanguage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.applicationlanguage.databinding.FragmentParaulasOTestBinding

class ParaulasOTestFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentParaulasOTestBinding>(inflater,
            R.layout.fragment_paraulas_o_test,container,false)
        binding.buttonGoTest.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_paraulasOTestFragment_to_testFragment)
        }
        binding.buttonGoVeureParaules.setOnClickListener { view : View ->
            //view.findNavController().navigate(R.id.action_paraulasOTestFragment_to_veureFragment)
        }
        return binding.root
    }
}