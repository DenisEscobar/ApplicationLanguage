package com.example.applicationlanguage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.applicationlanguage.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
   override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val binding = DataBindingUtil.inflate<FragmentFirstBinding>(inflater,
           R.layout.fragment_first,container,false)
        binding.button.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
       return binding.root
    }
}