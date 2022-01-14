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

        var ale2=0
        var ale3=0
        var ale4=0
        var ale1=0
        ale1 = (1..aleatori.toInt()).random()
        do {
            ale2 = (1..aleatori.toInt()).random()
        }while(ale2==ale1)
        do {
            ale3 = (1..aleatori.toInt()).random()
        }while(ale3==ale1 || ale3==ale2)
        do{
            ale4 = (1..aleatori.toInt()).random()
        }while(ale4==ale1 || ale4==ale2 || ale4==ale3)

        val paraula=roomViewModel.palabraNumero(ale1.toString())
        binding.buttonOpcion1.text = paraula.aprenderpalabra
        val palabla2 = roomViewModel.palabraNumero(ale2.toString())
        binding.buttonOpcion2.text = palabla2.aprenderpalabra
        val paraula3=roomViewModel.palabraNumero(ale3.toString())
        binding.buttonOpcion3.text = paraula3.aprenderpalabra
        val paraula4=roomViewModel.palabraNumero(ale4.toString())
        binding.buttonOpcion4.text = paraula4.aprenderpalabra


        val aleace = (1..5).random()
        if(aleace==1) {
            binding.paraulaaencertar.setText(paraula.localpalabra.toString())
        }else if(aleace==2){
            binding.paraulaaencertar.setText(palabla2.localpalabra.toString())
        }else if(aleace==3){
            binding.paraulaaencertar.setText(paraula3.localpalabra.toString())
        }else if(aleace==4){
            binding.paraulaaencertar.setText(paraula4.localpalabra.toString())
        }

        binding.buttonOpcion1.setOnClickListener {view: View ->
            var palabraacertar = roomViewModel.getpalabra(binding.paraulaaencertar.toString())
            if(binding.buttonOpcion1.text.toString().equals(palabraacertar.aprenderpalabra.toString())){con++}
            if(con>=10){con=0
                view.findNavController().navigate(R.id.action_testFragment_to_finTestFragment)
            }
        }

        binding.buttonOpcion2.setOnClickListener {view: View ->
            var palabraacertar = roomViewModel.getpalabra(binding.paraulaaencertar.toString())
            if(binding.buttonOpcion2.text.toString().equals(palabraacertar.aprenderpalabra.toString())){con++}
            if(con>=10){con=0
                view.findNavController().navigate(R.id.action_testFragment_to_finTestFragment)
            }
        }
       binding.buttonOpcion3.setOnClickListener {view: View ->
           var palabraacertar = roomViewModel.getpalabra(binding.paraulaaencertar.toString())
            if(binding.buttonOpcion3.text.toString().equals(palabraacertar.aprenderpalabra.toString())){con++}
            if(con>=10){con=0
                view.findNavController().navigate(R.id.action_testFragment_to_finTestFragment)
            }
        }
        binding.buttonOpcion4.setOnClickListener {view: View ->
            var palabraacertar = roomViewModel.getpalabra(binding.paraulaaencertar.toString())
            if(binding.buttonOpcion4.text.toString().equals(palabraacertar.aprenderpalabra.toString())){con++}
            if(con>=10){con=0
                view.findNavController().navigate(R.id.action_testFragment_to_finTestFragment)
            }
        }


        return binding.root
    }
}