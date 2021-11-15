package com.example.applicationlanguage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.applicationlanguage.databinding.FragmentFinTestBinding

class FinTestFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentFinTestBinding>(inflater,
            R.layout.fragment_fin_test,container,false)
        binding.button2.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_finTestFragment_to_temaFragment)
        }
        return binding.root
    }
}