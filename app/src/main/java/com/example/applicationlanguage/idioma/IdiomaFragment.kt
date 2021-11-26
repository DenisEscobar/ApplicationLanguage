package com.example.applicationlanguage.idioma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.applicationlanguage.R
import com.example.applicationlanguage.ShareViewModel
import com.example.applicationlanguage.RoomViewModelFactory
import com.example.applicationlanguage.database.database
import com.example.applicationlanguage.databinding.FragmentIdiomaBinding

class IdiomaFragment : Fragment() {
    lateinit var modelShare: ShareViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentIdiomaBinding>(inflater,
            R.layout.fragment_idioma,container,false)

        val application = requireNotNull(this.activity).application
        val dataSource = database.getInstance(application).databaseDao
        val viewModelFactory = RoomViewModelFactory(dataSource, application)
        modelShare = ViewModelProvider(this, viewModelFactory).get(ShareViewModel::class.java)


        binding.buttonIngles.setOnClickListener { view:View ->
            view.findNavController().navigate(R.id.action_idiomaFragment_to_temaFragment)
            var idioma="ingles"
            //model = ViewModelProvider(requireActivity()).get(ViewModel::class.java)
            modelShare.sendidioma(idioma)
        }
        return binding.root
    }
}