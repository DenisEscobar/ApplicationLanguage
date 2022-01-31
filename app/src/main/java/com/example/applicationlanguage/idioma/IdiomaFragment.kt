package com.example.applicationlanguage.idioma

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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

        binding.buttonIngles.setOnClickListener { view:View ->
            view.findNavController().navigate(R.id.action_idiomaFragment_to_temaFragment)
            var idioma="ingles"
            modelShare = ViewModelProvider(requireActivity()).get(ShareViewModel::class.java)
            modelShare.sendidioma(idioma)
        }
        //binding.buttonFrances.setBackgroundColor(Color.parseColor("#DCDC7F"))
        binding.buttonFrances.setOnClickListener {view:View ->
            view.findNavController().navigate(R.id.action_idiomaFragment_to_temaFragment)
            var idioma="frances"
            modelShare = ViewModelProvider(requireActivity()).get(ShareViewModel::class.java)
            modelShare.sendidioma(idioma)
//            var toast= Toast.makeText(requireContext(), "Proximamente",Toast.LENGTH_SHORT)
//            toast.show()
        }
        binding.buttonJapones.setBackgroundColor(Color.parseColor("#DCDC7F"))
        binding.buttonJapones.setOnClickListener {
            var toast= Toast.makeText(requireContext(), "Proximamente",Toast.LENGTH_SHORT)
            toast.show()
        }
        binding.buttonRuso.setBackgroundColor(Color.parseColor("#DCDC7F"))
        binding.buttonRuso.setOnClickListener {
            var toast= Toast.makeText(requireContext(), "Proximamente",Toast.LENGTH_SHORT)
            toast.show()
        }
        return binding.root
    }
}