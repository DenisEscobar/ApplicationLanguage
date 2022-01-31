package com.example.applicationlanguage.mostrar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.applicationlanguage.R
import com.example.applicationlanguage.RoomViewModel
import com.example.applicationlanguage.RoomViewModelFactory
import com.example.applicationlanguage.ShareViewModel
import com.example.applicationlanguage.database.database
import com.example.applicationlanguage.databinding.FragmentAlfabetoMostrarBinding
import com.example.applicationlanguage.databinding.FragmentFirstBinding

class AlfabetoMostrarFragment : Fragment() {
    lateinit var modelShare: ShareViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentAlfabetoMostrarBinding>(inflater,
            R.layout.fragment_alfabeto_mostrar,container,false)
        modelShare = ViewModelProvider(requireActivity()).get(ShareViewModel::class.java)
        binding.textViewAlfabeto.text = modelShare.getalfa().uppercase()
        val application = requireNotNull(this.activity).application
        val dataSource = database.getInstance(application).databaseDao
        val viewModelFactory = RoomViewModelFactory(dataSource, application)
        val roomViewModel = ViewModelProvider(this, viewModelFactory).get(RoomViewModel::class.java)
        var idiomaid=roomViewModel.mirarid(modelShare.getidioma(),modelShare.getconocimiento())
        var pronunciacion = roomViewModel.getletra(modelShare.getalfa(), idiomaid)
        binding.textViewAlfabetopron.text = pronunciacion.pronunciacio_aprender.toString()

        return binding.root
    }
}