package com.example.applicationlanguage.idioma

import android.graphics.Color
import android.graphics.Color.parseColor
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.applicationlanguage.R
import com.example.applicationlanguage.RoomViewModel
import com.example.applicationlanguage.RoomViewModelFactory
import com.example.applicationlanguage.ShareViewModel
import com.example.applicationlanguage.database.database
import com.example.applicationlanguage.databinding.FragmentTemaBinding
import com.example.applicationlanguage.sharedpref.sharedApp
import java.lang.Integer.parseInt

class TemaFragment : Fragment() {
     //val modelShare: ShareViewModel= ViewModelProvider(requireActivity()).get(ShareViewModel::class.java)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentTemaBinding>(inflater,
            R.layout.fragment_tema,container,false)
        val modelShare = ViewModelProvider(requireActivity()).get(ShareViewModel::class.java)

        val application = requireNotNull(this.activity).application
        val dataSource = database.getInstance(application).databaseDao
        val viewModelFactory = RoomViewModelFactory(dataSource, application)
        val roomViewModel = ViewModelProvider(this, viewModelFactory).get(RoomViewModel::class.java)
        var user = sharedApp.prefes.name
        //falta poner dentro!!!
        var idiomanum = roomViewModel.database.getidiomaid(modelShare.getidioma(),"numero")
        if(!user.isNullOrBlank()) {

            var compnum = roomViewModel.database.getAlldades(roomViewModel.getuserid(user.toString()), idiomanum)
            if(compnum.completado==true){
                binding.buttonNumeros.setBackgroundResource(R.drawable.borde_redondo_comp)
            }
            var idiomaalfa = roomViewModel.database.getidiomaid(modelShare.getidioma(),"alfabeto")
            var compalfa = roomViewModel.database.getAlldades(roomViewModel.getuserid(user.toString()),idiomaalfa)
            if(compalfa.completado==true){
                binding.buttonAlfabeto.setBackgroundResource(R.drawable.borde_redondo_comp)
            }
        }



        binding.buttonNumeros.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_temaFragment_to_paraulasOTestFragment)
            var tema="numero"

            modelShare.sendtema(tema.toString())
            modelShare.sendconocimiento(tema.toString())
        }
        binding.buttonAlfabeto.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_temaFragment_to_paraulasOTestFragment)
            var tema="alfabeto"
            modelShare.sendtema(tema.toString())
            modelShare.sendconocimiento(tema.toString())
        }
        binding.buttonFrases.setOnClickListener { view:View ->
            view.findNavController().navigate(R.id.action_temaFragment_to_conocimientoFragment)
            var tema="frases"
            modelShare.sendtema(tema.toString())
        }
        binding.buttonParaulas.setOnClickListener { view:View ->
            view.findNavController().navigate(R.id.action_temaFragment_to_conocimientoFragment)
            var tema="vocabulario"
            modelShare.sendtema(tema.toString())
        }

        return binding.root
    }
}