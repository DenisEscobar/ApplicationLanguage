package com.example.applicationlanguage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.applicationlanguage.databinding.FragmentTestBinding

class TestFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var con=0
        val binding = DataBindingUtil.inflate<FragmentTestBinding>(inflater,
            R.layout.fragment_test,container,false)
        binding.buttonOpcion1.setOnClickListener {view: View ->
con++
            if(con>=10){
                     view.findNavController().navigate(R.id.action_testFragment_to_finTestFragment)
            }
        }
        binding.buttonOpcion2.setOnClickListener {view: View ->
            con++
            if(con>=10){
                view.findNavController().navigate(R.id.action_testFragment_to_finTestFragment)
            }
        }
        binding.buttonOpcion3.setOnClickListener {view: View ->
            con++
            if(con>=10){
                view.findNavController().navigate(R.id.action_testFragment_to_finTestFragment)
            }
        }
        binding.buttonOpcion4.setOnClickListener {view: View ->
            con++
            if(con>=10){
                view.findNavController().navigate(R.id.action_testFragment_to_finTestFragment)
            }
        }

        return binding.root
    }
}