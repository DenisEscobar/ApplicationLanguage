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
import com.example.applicationlanguage.RoomViewModel
import com.example.applicationlanguage.RoomViewModelFactory
import com.example.applicationlanguage.ShareViewModel
import com.example.applicationlanguage.database.*
import com.example.applicationlanguage.databinding.FragmentTestBinding

class TestFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var con = 0
        val binding = DataBindingUtil.inflate<FragmentTestBinding>(
            inflater,
            R.layout.fragment_test, container, false
        )

        var inc = 0
        var tema = ""
        var conocimiento = ""
        var idioma = ""
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
        tema = model.gettema().toString()
        idioma = model.getidioma().toString()
        conocimiento = model.getconocimiento().toString()
        val application = requireNotNull(this.activity).application
        val dataSource = database.getInstance(application).databaseDao
        val viewModelFactory = RoomViewModelFactory(dataSource, application)
        val roomViewModel = ViewModelProvider(this, viewModelFactory).get(RoomViewModel::class.java)
        var idiomaid=roomViewModel.mirarid(idioma,conocimiento)
        if (tema.equals("numero")) {
            val aleatori = roomViewModel.getallids(roomViewModel.mirarid(idioma,conocimiento))
            numero(binding, aleatori, con)

            binding.buttonOpcion1.setOnClickListener { view: View ->
                val palabraacertar =
                    roomViewModel.getpalabra(binding.paraulaaencertar.text.toString(),idiomaid)
                if (binding.buttonOpcion1.text.toString()
                        .equals(palabraacertar.aprenderpalabra.toString())
                ) {
                    con++
                } else {
                    inc++
                }
                if (con >= 10) {
                    con = 0
                    model.sendinc(inc)
                    view.findNavController().navigate(R.id.action_testFragment_to_finTestFragment)
                }
                numero(binding, aleatori, con)
            }

            binding.buttonOpcion2.setOnClickListener { view: View ->
                val palabraacertar =
                    roomViewModel.getpalabra(binding.paraulaaencertar.text.toString(),idiomaid)
                if (binding.buttonOpcion2.text.toString()
                        .equals(palabraacertar.aprenderpalabra.toString())
                ) {
                    con++
                } else {
                    inc++
                }
                if (con >= 10) {
                    con = 0
                    model.sendinc(inc)
                    view.findNavController().navigate(R.id.action_testFragment_to_finTestFragment)
                }
                numero(binding, aleatori, con)
            }
            binding.buttonOpcion3.setOnClickListener { view: View ->
                val palabraacertar =
                    roomViewModel.getpalabra(binding.paraulaaencertar.text.toString(),idiomaid)
                if (binding.buttonOpcion3.text.toString()
                        .equals(palabraacertar.aprenderpalabra.toString())
                ) {
                    con++
                } else {
                    inc++
                }
                if (con >= 10) {
                    con = 0
                    model.sendinc(inc)
                    view.findNavController().navigate(R.id.action_testFragment_to_finTestFragment)
                }
                numero(binding, aleatori, con)
            }
            binding.buttonOpcion4.setOnClickListener { view: View ->
                val palabraacertar =
                    roomViewModel.getpalabra(binding.paraulaaencertar.text.toString(),idiomaid)
                if (binding.buttonOpcion4.text.toString()
                        .equals(palabraacertar.aprenderpalabra.toString())
                ) {
                    con++
                } else {
                    inc++
                }
                if (con >= 10) {
                    con = 0
                    model.sendinc(inc)
                    view.findNavController().navigate(R.id.action_testFragment_to_finTestFragment)
                }
                numero(binding, aleatori, con)
            }
        } else if (tema.equals("alfabeto")) {
//areglar
            val aleatoriletra = roomViewModel.getallidsletra(roomViewModel.mirarid(idioma,conocimiento))
            letra(binding, aleatoriletra, con)

            binding.buttonOpcion1.setOnClickListener { view: View ->
                val palabraacertar =
                    roomViewModel.getletra(binding.paraulaaencertar.text.toString(),idiomaid)
                if (binding.buttonOpcion1.text.toString()
                        .equals(palabraacertar.pronunciacio_aprender.toString())
                ) {
                    con++
                } else {
                    inc++
                }
                if (con >= 10) {
                    con = 0
                    model.sendinc(inc)
                    view.findNavController().navigate(R.id.action_testFragment_to_finTestFragment)
                }
                letra(binding, aleatoriletra, con)
            }

            binding.buttonOpcion2.setOnClickListener { view: View ->
                val palabraacertar =
                    roomViewModel.getletra(binding.paraulaaencertar.text.toString(),idiomaid)
                if (binding.buttonOpcion2.text.toString()
                        .equals(palabraacertar.pronunciacio_aprender.toString())
                ) {
                    con++
                } else {
                    inc++
                }
                if (con >= 10) {
                    con = 0
                    model.sendinc(inc)
                    view.findNavController().navigate(R.id.action_testFragment_to_finTestFragment)
                }
                letra(binding, aleatoriletra, con)
            }
            binding.buttonOpcion3.setOnClickListener { view: View ->
                val palabraacertar =
                    roomViewModel.getletra(binding.paraulaaencertar.text.toString(),idiomaid)
                if (binding.buttonOpcion3.text.toString()
                        .equals(palabraacertar.pronunciacio_aprender.toString())
                ) {
                    con++
                } else {
                    inc++
                }
                if (con >= 10) {
                    con = 0
                    model.sendinc(inc)
                    view.findNavController().navigate(R.id.action_testFragment_to_finTestFragment)
                }
                letra(binding, aleatoriletra, con)
            }
            binding.buttonOpcion4.setOnClickListener { view: View ->
                val palabraacertar =
                    roomViewModel.getletra(binding.paraulaaencertar.text.toString(),idiomaid)
                if (binding.buttonOpcion4.text.toString()
                        .equals(palabraacertar.pronunciacio_aprender.toString())
                ) {
                    con++
                } else {
                    inc++
                }
                if (con >= 10) {
                    con = 0
                    model.sendinc(inc)
                    view.findNavController().navigate(R.id.action_testFragment_to_finTestFragment)
                }
                letra(binding, aleatoriletra, con)
            }
        } else if (tema.equals("vocabulario")) {
            var idiomaid = roomViewModel.mirarid(idioma,conocimiento)
            val aleatoripal = roomViewModel.getallids_fra(idiomaid)
            paraula(binding, aleatoripal, con)

            binding.buttonOpcion1.setOnClickListener { view: View ->
                val palabraacertar =
                    roomViewModel.getpalabrapal(binding.paraulaaencertar.text.toString(),idiomaid)
                if (binding.buttonOpcion1.text.toString()
                        .equals(palabraacertar.aprenderpalabra.toString())
                ) {
                    con++
                } else {
                    inc++
                }
                if (con >= 10) {
                    con = 0
                    model.sendinc(inc)
                    view.findNavController().navigate(R.id.action_testFragment_to_finTestFragment)
                }
                paraula(binding, aleatoripal, con)
            }

            binding.buttonOpcion2.setOnClickListener { view: View ->
                val palabraacertar =
                    roomViewModel.getpalabrapal(binding.paraulaaencertar.text.toString(),idiomaid)
                if (binding.buttonOpcion2.text.toString()
                        .equals(palabraacertar.aprenderpalabra.toString())
                ) {
                    con++
                } else {
                    inc++
                }
                if (con >= 10) {
                    con = 0
                    model.sendinc(inc)
                    view.findNavController().navigate(R.id.action_testFragment_to_finTestFragment)
                }
                paraula(binding, aleatoripal, con)
            }
            binding.buttonOpcion3.setOnClickListener { view: View ->
                val palabraacertar =
                    roomViewModel.getpalabrapal(binding.paraulaaencertar.text.toString(),idiomaid)
                if (binding.buttonOpcion3.text.toString()
                        .equals(palabraacertar.aprenderpalabra.toString())
                ) {
                    con++
                } else {
                    inc++
                }
                if (con >= 10) {
                    con = 0
                    model.sendinc(inc)
                    view.findNavController().navigate(R.id.action_testFragment_to_finTestFragment)
                }
                paraula(binding, aleatoripal, con)
            }
            binding.buttonOpcion4.setOnClickListener { view: View ->
                val palabraacertar =
                    roomViewModel.getpalabrapal(binding.paraulaaencertar.text.toString(),idiomaid)
                if (binding.buttonOpcion4.text.toString()
                        .equals(palabraacertar.aprenderpalabra.toString())
                ) {
                    con++
                } else {
                    inc++
                }
                if (con >= 10) {
                    con = 0
                    model.sendinc(inc)
                    view.findNavController().navigate(R.id.action_testFragment_to_finTestFragment)
                }
                paraula(binding, aleatoripal, con)
            }

        } else if (tema.equals("frases")) {
            var idiomaid = roomViewModel.mirarid(idioma,conocimiento)
            val aleatorifra = roomViewModel.getallids_frases(idiomaid)
            frase(binding, aleatorifra, con)

            binding.buttonOpcion1.setOnClickListener { view: View ->
                val palabraacertar =
                    roomViewModel.getpalabrafrases(binding.paraulaaencertar.text.toString(),idiomaid)
                if (binding.buttonOpcion1.text.toString()
                        .equals(palabraacertar.aprenderfrase.toString())
                ) {
                    con++
                } else {
                    inc++
                }
                if (con >= 10) {
                    con = 0
                    model.sendinc(inc)
                    view.findNavController().navigate(R.id.action_testFragment_to_finTestFragment)
                }
                frase(binding, aleatorifra, con)
            }

            binding.buttonOpcion2.setOnClickListener { view: View ->
                val palabraacertar =
                    roomViewModel.getpalabrafrases(binding.paraulaaencertar.text.toString(),idiomaid)
                if (binding.buttonOpcion2.text.toString()
                        .equals(palabraacertar.aprenderfrase.toString())
                ) {
                    con++
                } else {
                    inc++
                }
                if (con >= 10) {
                    con = 0
                    model.sendinc(inc)
                    view.findNavController().navigate(R.id.action_testFragment_to_finTestFragment)
                }
                frase(binding, aleatorifra, con)
            }
            binding.buttonOpcion3.setOnClickListener { view: View ->
                val palabraacertar =
                    roomViewModel.getpalabrafrases(binding.paraulaaencertar.text.toString(),idiomaid)
                if (binding.buttonOpcion3.text.toString()
                        .equals(palabraacertar.aprenderfrase.toString())
                ) {
                    con++
                } else {
                    inc++
                }
                if (con >= 10) {
                    con = 0
                    model.sendinc(inc)
                    view.findNavController().navigate(R.id.action_testFragment_to_finTestFragment)
                }
                frase(binding, aleatorifra, con)
            }
            binding.buttonOpcion4.setOnClickListener { view: View ->
                val palabraacertar =
                    roomViewModel.getpalabrafrases(binding.paraulaaencertar.text.toString(),idiomaid)
                if (binding.buttonOpcion4.text.toString()
                        .equals(palabraacertar.aprenderfrase.toString())
                ) {
                    con++
                } else {
                    inc++
                }
                if (con >= 10) {
                    con = 0
                    model.sendinc(inc)
                    view.findNavController().navigate(R.id.action_testFragment_to_finTestFragment)
                }
                frase(binding, aleatorifra, con)
            }
        }
        return binding.root
    }

//funciones
    //numero
    fun numero(binding: FragmentTestBinding, aleatori: List<palabra_numero>, con: Int){
        binding.textViewPuntuacionRestante.setText("Llevas "+con+" de 10")
        val application = requireNotNull(this.activity).application
        val dataSource = database.getInstance(application).databaseDao
        val viewModelFactory = RoomViewModelFactory(dataSource, application)
        val roomViewModel = ViewModelProvider(this, viewModelFactory).get(RoomViewModel::class.java)

        var ale2=0
        var ale3=0
        var ale4=0
        var ale1=0
        ale1 = (1..aleatori.size).random()
        do {
            ale2 = (1..aleatori.size).random()
        }while(ale2==ale1)
        do {
            ale3 = (1..aleatori.size).random()
        }while(ale3==ale1 || ale3==ale2)
        do{
            ale4 = (1..aleatori.size).random()
        }while(ale4==ale1 || ale4==ale2 || ale4==ale3)

        val paraula = roomViewModel.palabraNumero(aleatori[ale1-1].id.toString())
        binding.buttonOpcion1.text = paraula.aprenderpalabra
        val palabla2 = roomViewModel.palabraNumero(aleatori[ale2-1].id.toString())
        binding.buttonOpcion2.text = palabla2.aprenderpalabra
        val paraula3 = roomViewModel.palabraNumero(aleatori[ale3-1].id.toString())
        binding.buttonOpcion3.text = paraula3.aprenderpalabra
        val paraula4 = roomViewModel.palabraNumero(aleatori[ale4-1].id.toString())
        binding.buttonOpcion4.text = paraula4.aprenderpalabra

        val aleace = (1..4).random()
        if(aleace==1) {
            binding.paraulaaencertar.setText(paraula.localpalabra.toString())
        }else if(aleace==2){
            binding.paraulaaencertar.setText(palabla2.localpalabra.toString())
        }else if(aleace==3){
            binding.paraulaaencertar.setText(paraula3.localpalabra.toString())
        }else if(aleace==4){
            binding.paraulaaencertar.setText(paraula4.localpalabra.toString())
        }
    }
    //alfabeto
    fun letra(binding: FragmentTestBinding, aleatori: List<palabra_alfabeto>, con: Int){
        binding.textViewPuntuacionRestante.setText("Llevas "+con+" de 10")

        val application = requireNotNull(this.activity).application
        val dataSource = database.getInstance(application).databaseDao
        val viewModelFactory = RoomViewModelFactory(dataSource, application)
        val roomViewModel = ViewModelProvider(this, viewModelFactory).get(RoomViewModel::class.java)

        var ale2=0
        var ale3=0
        var ale4=0
        var ale1=0
        ale1 = (1..aleatori.size).random()
        do {
            ale2 = (1..aleatori.size).random()
        }while(ale2==ale1)
        do {
            ale3 = (1..aleatori.size).random()
        }while(ale3==ale1 || ale3==ale2)
        do{
            ale4 = (1..aleatori.size).random()
        }while(ale4==ale1 || ale4==ale2 || ale4==ale3)

        val paraula = roomViewModel.palabraletra(aleatori[ale1-1].id.toString())
        binding.buttonOpcion1.text = paraula.pronunciacio_aprender
        val palabla2 = roomViewModel.palabraletra(aleatori[ale2-1].id.toString())
        binding.buttonOpcion2.text = palabla2.pronunciacio_aprender
        val paraula3 = roomViewModel.palabraletra(aleatori[ale3-1].id.toString())
        binding.buttonOpcion3.text = paraula3.pronunciacio_aprender
        val paraula4 = roomViewModel.palabraletra(aleatori[ale4-1].id.toString())
        binding.buttonOpcion4.text = paraula4.pronunciacio_aprender

        val aleace = (1..4).random()
        if(aleace==1) {
            binding.paraulaaencertar.setText(paraula.localpalabra.toString())
        }else if(aleace==2){
            binding.paraulaaencertar.setText(palabla2.localpalabra.toString())
        }else if(aleace==3){
            binding.paraulaaencertar.setText(paraula3.localpalabra.toString())
        }else if(aleace==4){
            binding.paraulaaencertar.setText(paraula4.localpalabra.toString())
        }
    }
    //palabra
    fun paraula(binding: FragmentTestBinding, aleatori: List<palabras>, con: Int){
        binding.textViewPuntuacionRestante.setText("Llevas "+con+" de 10")

        val application = requireNotNull(this.activity).application
        val dataSource = database.getInstance(application).databaseDao
        val viewModelFactory = RoomViewModelFactory(dataSource, application)
        val roomViewModel = ViewModelProvider(this, viewModelFactory).get(RoomViewModel::class.java)

        var ale2=0
        var ale3=0
        var ale4=0
        var ale1=0
        ale1 = (1..aleatori.size).random()
        ale1 = aleatori[ale1-1].id.toInt()
        do {
            ale2 = (1..aleatori.size).random()
            ale2 = aleatori[ale2-1].id.toInt()
        }while(ale2==ale1)
        do {
            ale3 = (1..aleatori.size).random()
            ale3 = aleatori[ale3-1].id.toInt()
        }while(ale3==ale1 || ale3==ale2)
        do{
            ale4 = (1..aleatori.size).random()
            ale4 = aleatori[ale4-1].id.toInt()
        }while(ale4==ale1 || ale4==ale2 || ale4==ale3)

        val paraula = roomViewModel.palabraFra(ale1.toString())
        binding.buttonOpcion1.text = paraula.aprenderpalabra
        val palabla2 = roomViewModel.palabraFra(ale2.toString())
        binding.buttonOpcion2.text = palabla2.aprenderpalabra
        val paraula3 = roomViewModel.palabraFra(ale3.toString())
        binding.buttonOpcion3.text = paraula3.aprenderpalabra
        val paraula4 = roomViewModel.palabraFra(ale4.toString())
        binding.buttonOpcion4.text = paraula4.aprenderpalabra

        val aleace = (1..4).random()
        if(aleace==1) {
            binding.paraulaaencertar.setText(paraula.localpalabra.toString())
        }else if(aleace==2){
            binding.paraulaaencertar.setText(palabla2.localpalabra.toString())
        }else if(aleace==3){
            binding.paraulaaencertar.setText(paraula3.localpalabra.toString())
        }else if(aleace==4){
            binding.paraulaaencertar.setText(paraula4.localpalabra.toString())
        }
    }
    //frases
    fun frase(binding: FragmentTestBinding, aleatori: List<palabra_frase>, con: Int){
        binding.textViewPuntuacionRestante.setText("Llevas "+con+" de 10")

        val application = requireNotNull(this.activity).application
        val dataSource = database.getInstance(application).databaseDao
        val viewModelFactory = RoomViewModelFactory(dataSource, application)
        val roomViewModel = ViewModelProvider(this, viewModelFactory).get(RoomViewModel::class.java)

        var ale2=0
        var ale3=0
        var ale4=0
        var ale1=0
        ale1 = (1..aleatori.size).random()
        ale1 = aleatori[ale1-1].id.toInt()
        do {
            ale2 = (1..aleatori.size).random()
            ale2 = aleatori[ale2-1].id.toInt()
        }while(ale2==ale1)
        do {
            ale3 = (1..aleatori.size).random()
            ale3 = aleatori[ale3-1].id.toInt()
        }while(ale3==ale1 || ale3==ale2)
        do{
            ale4 = (1..aleatori.size).random()
            ale4 = aleatori[ale4-1].id.toInt()
        }while(ale4==ale1 || ale4==ale2 || ale4==ale3)

        val paraula = roomViewModel.palabraFrases(ale1.toString())
        binding.buttonOpcion1.text = paraula.aprenderfrase
        val palabla2 = roomViewModel.palabraFrases(ale2.toString())
        binding.buttonOpcion2.text = palabla2.aprenderfrase
        val paraula3 = roomViewModel.palabraFrases(ale3.toString())
        binding.buttonOpcion3.text = paraula3.aprenderfrase
        val paraula4 = roomViewModel.palabraFrases(ale4.toString())
        binding.buttonOpcion4.text = paraula4.aprenderfrase

        val aleace = (1..4).random()
        if(aleace==1) {
            binding.paraulaaencertar.setText(paraula.localfrase.toString())
        }else if(aleace==2){
            binding.paraulaaencertar.setText(palabla2.localfrase.toString())
        }else if(aleace==3){
            binding.paraulaaencertar.setText(paraula3.localfrase.toString())
        }else if(aleace==4){
            binding.paraulaaencertar.setText(paraula4.localfrase.toString())
        }
    }
}