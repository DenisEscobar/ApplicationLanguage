package com.example.applicationlanguage.idioma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationlanguage.R
import com.example.applicationlanguage.RoomViewModel
import com.example.applicationlanguage.RoomViewModelFactory
import com.example.applicationlanguage.ShareViewModel
import com.example.applicationlanguage.database.database
import com.example.applicationlanguage.databinding.FragmentConocimientoBinding
import com.example.applicationlanguage.mostrar.MostrarFragmentAdapterAlf
import com.example.applicationlanguage.mostrar.MostrarFragmentAdapterFra
import com.example.applicationlanguage.mostrar.MostrarFragmentAdapterNum
import com.example.applicationlanguage.mostrar.MostrarFragmentAdapterPal

class ConocimientoFragment : Fragment() {
    lateinit var modelShare: ShareViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentConocimientoBinding>(
            inflater,
            R.layout.fragment_conocimiento, container, false
        )
        val model = ViewModelProvider(requireActivity()).get(ShareViewModel::class.java)

        var tema=model.gettema()
        var idioma=model.getidioma()

        val application = requireNotNull(this.activity).application
        val dataSource = database.getInstance(application).databaseDao
        val viewModelFactory = RoomViewModelFactory(dataSource, application)
        val roomViewModel = ViewModelProvider(this, viewModelFactory).get(RoomViewModel::class.java)
        //roomViewModel.verpalabras(conocimiento,idioma)
        //binding.textViewpalabra.text = roomViewModel.getpal()?.numero.toString()
        modelShare = ViewModelProvider(requireActivity()).get(ShareViewModel::class.java)
        val recyclerView: RecyclerView = binding.recyclerViewConocimiento
        recyclerView.layoutManager= LinearLayoutManager(this.activity)
        recyclerView.adapter = ConocimientoFragmentAdapter(
            application,
            roomViewModel.getconocimiento(tema),
            modelShare
        )





//        val modelShare = ViewModelProvider(requireActivity()).get(ShareViewModel::class.java)
//        if (modelShare.gettema().toString() == "vocabulario") {
//
//            binding.buttonSentimiento.text="Sentimiento"
//            binding.buttonSentimiento.setOnClickListener { view: View ->
//                view.findNavController()
//                    .navigate(R.id.action_conocimientoFragment_to_paraulasOTestFragment)
//                var conocimiento = "sentimiento"
//                modelShare.sendconocimiento(conocimiento.toString())
//            }
//        }else if(modelShare.gettema().toString() == "frases"){
//            binding.buttonSentimiento.text="personas"
//            binding.buttonSentimiento.setOnClickListener { view: View ->
//                view.findNavController()
//                    .navigate(R.id.action_conocimientoFragment_to_paraulasOTestFragment)
//                var conocimiento = "personas"
//                modelShare.sendconocimiento(conocimiento.toString())
//            }
//        }

        return binding.root
    }
}