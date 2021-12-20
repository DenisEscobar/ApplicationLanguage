package com.example.applicationlanguage.mostrar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationlanguage.R
import com.example.applicationlanguage.RoomViewModel
import com.example.applicationlanguage.RoomViewModelFactory
import com.example.applicationlanguage.ShareViewModel
import com.example.applicationlanguage.database.database
import com.example.applicationlanguage.databinding.FragmentMostrarBinding

class MostrarFragment : Fragment() {
    lateinit var modelShare: ShareViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentMostrarBinding>(inflater,
            R.layout.fragment_mostrar,container,false)

        val model = ViewModelProvider(requireActivity()).get(ShareViewModel::class.java)

        var tema=model.gettema()
        var conocimiento=model.getconocimiento()
        var idioma=model.getidioma()

        binding.textViewmostrar.text = model.getall()

        val application = requireNotNull(this.activity).application
        val dataSource = database.getInstance(application).databaseDao
        val viewModelFactory = RoomViewModelFactory(dataSource, application)
        val roomViewModel = ViewModelProvider(this, viewModelFactory).get(RoomViewModel::class.java)
        //roomViewModel.verpalabras(conocimiento,idioma)
        //binding.textViewpalabra.text = roomViewModel.getpal()?.numero.toString()
val id = roomViewModel.mirarid(idioma,conocimiento)
modelShare = ViewModelProvider(requireActivity()).get(ShareViewModel::class.java)
        val recyclerView: RecyclerView = binding.recyclerView
        recyclerView.layoutManager= LinearLayoutManager(this.activity)
        if(conocimiento=="numero") {
            recyclerView.adapter = MostrarFragmentAdapterNum(
                application,
                roomViewModel.getnumero(id.toString())
            )
        }else if(conocimiento=="alfabeto"){
            recyclerView.adapter = MostrarFragmentAdapterAlf(
                application,
                roomViewModel.getAlfabeto(id.toString()),
                modelShare
            )
            
        }




        return binding.root
    }
}
