package com.example.applicationlanguage.test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.applicationlanguage.R
import com.example.applicationlanguage.ShareViewModel
import com.example.applicationlanguage.databinding.FragmentTestBinding

class TestFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var con=0
        val binding = DataBindingUtil.inflate<FragmentTestBinding>(inflater,
            R.layout.fragment_test,container,false)


        var tema=""
        var conocimiento=""
        var idioma=""
        val model = ViewModelProvider(requireActivity()).get(ShareViewModel::class.java)
        model.idioma.observe(viewLifecycleOwner, Observer {
            idioma = it
        })
        model.tema.observe(viewLifecycleOwner, Observer {
            tema = it
        })
        model.conocimiento.observe(viewLifecycleOwner, Observer {
            conocimiento = it
        })


        binding.buttonOpcion1.setOnClickListener {view: View ->
con++
            if(con>=10){con=0
                     view.findNavController().navigate(R.id.action_testFragment_to_finTestFragment)
            }
        }
        binding.buttonOpcion2.setOnClickListener {view: View ->
            con++
            if(con>=10){con=0
                view.findNavController().navigate(R.id.action_testFragment_to_finTestFragment)
            }
        }
        binding.buttonOpcion3.setOnClickListener {view: View ->
            con++
            if(con>=10){con=0
                view.findNavController().navigate(R.id.action_testFragment_to_finTestFragment)
            }
        }
        binding.buttonOpcion4.setOnClickListener {view: View ->
            con++
            if(con>=10){con=0
                view.findNavController().navigate(R.id.action_testFragment_to_finTestFragment)
            }
        }

        return binding.root
    }
}