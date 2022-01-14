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
import androidx.room.Room
import com.example.applicationlanguage.R
import com.example.applicationlanguage.RoomViewModel
import com.example.applicationlanguage.RoomViewModelFactory
import com.example.applicationlanguage.ShareViewModel
import com.example.applicationlanguage.database.database
import com.example.applicationlanguage.databinding.FragmentTestBinding
import kotlin.random.Random

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
        val application = requireNotNull(this.activity).application
        val dataSource = database.getInstance(application).databaseDao
        val viewModelFactory = RoomViewModelFactory(dataSource, application)
        val roomViewModel = ViewModelProvider(this, viewModelFactory).get(RoomViewModel::class.java)


        val aleatori =roomViewModel.getallids()

        val ale2=0
        val ale3=0
        val ale4=0
        val ale1 = (0..aleatori.toInt()).random()
        do {
            val ale2 = (0..aleatori.toInt()).random()
        }while(ale2!=ale1)
        do {
            val ale3 = (0..aleatori.toInt()).random()
        }while(ale3!=ale1 && ale3!=ale2)
        do{
            val ale4 = (0..aleatori.toInt()).random()
        }while(ale4!=ale1 && ale4!=ale2 && ale4!=ale3)
        val aleace = (1..5).random()
        if(aleace==1) {
            binding.paraulaAEncertar.text = roomViewModel.palabraNumero(ale1.toString()).palabra_local
        }else if(aleace==2){
            binding.paraulaAEncertar.text = roomViewModel.palabraNumero(ale2.toString()).palabra_local
        }else if(aleace==3){
            binding.paraulaAEncertar.text = roomViewModel.palabraNumero(ale3.toString()).palabra_local
        }else if(aleace==4){
            binding.paraulaAEncertar.text = roomViewModel.palabraNumero(ale4.toString()).palabra_local
        }
        val paraula=roomViewModel.palabraNumero(ale1.toString())
        binding.buttonOpcion1.text = paraula.palabra_aprender
        binding.buttonOpcion1.setOnClickListener {view: View ->
            if(binding.buttonOpcion1.text == binding.paraulaAEncertar){con++}
            if(con>=10){con=0
                view.findNavController().navigate(R.id.action_testFragment_to_finTestFragment)
            }
        }
        binding.buttonOpcion2.text = roomViewModel.palabraNumero(ale2.toString()).palabra_aprender
        binding.buttonOpcion2.setOnClickListener {view: View ->
            if(binding.buttonOpcion1.text == binding.paraulaAEncertar){con++}
            if(con>=10){con=0
                view.findNavController().navigate(R.id.action_testFragment_to_finTestFragment)
            }
        }
        binding.buttonOpcion3.text = roomViewModel.palabraNumero(ale3.toString()).palabra_aprender
        binding.buttonOpcion3.setOnClickListener {view: View ->
            if(binding.buttonOpcion1.text == binding.paraulaAEncertar){con++}
            if(con>=10){con=0
                view.findNavController().navigate(R.id.action_testFragment_to_finTestFragment)
            }
        }
        binding.buttonOpcion4.text = roomViewModel.palabraNumero(ale4.toString()).palabra_aprender
        binding.buttonOpcion4.setOnClickListener {view: View ->
            if(binding.buttonOpcion1.text == binding.paraulaAEncertar){con++}
            if(con>=10){con=0
                view.findNavController().navigate(R.id.action_testFragment_to_finTestFragment)
            }
        }


        return binding.root
    }
}