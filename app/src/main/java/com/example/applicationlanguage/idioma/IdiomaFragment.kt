package com.example.applicationlanguage.idioma

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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
        (activity as AppCompatActivity).supportActionBar?.title="Idioma"
        val binding = DataBindingUtil.inflate<FragmentIdiomaBinding>(inflater,
            R.layout.fragment_idioma,container,false)

        binding.buttonIngles.setOnClickListener { view:View ->
            view.findNavController().navigate(R.id.action_idiomaFragment_to_temaFragment)
            var idioma="ingles"
            modelShare = ViewModelProvider(requireActivity()).get(ShareViewModel::class.java)
            modelShare.sendidioma(idioma)
        }
        binding.buttonFrances.setOnClickListener {view:View ->
            view.findNavController().navigate(R.id.action_idiomaFragment_to_temaFragment)
            var idioma="frances"
            modelShare = ViewModelProvider(requireActivity()).get(ShareViewModel::class.java)
            modelShare.sendidioma(idioma)
        }
        binding.buttonJapones.setBackgroundResource(R.drawable.borde_redondo_no_comp)
        binding.buttonJapones.setOnClickListener {view:View ->
//            view.findNavController().navigate(R.id.action_idiomaFragment_to_temaFragment)
//            var idioma="japones"
//            modelShare = ViewModelProvider(requireActivity()).get(ShareViewModel::class.java)
//            modelShare.sendidioma(idioma)
            var toast= Toast.makeText(requireContext(), "Proximamente",Toast.LENGTH_SHORT)
            toast.show()
        }
        binding.buttonRuso.setOnClickListener {view:View ->
            view.findNavController().navigate(R.id.action_idiomaFragment_to_temaFragment)
            var idioma="ruso"
            modelShare = ViewModelProvider(requireActivity()).get(ShareViewModel::class.java)
            modelShare.sendidioma(idioma)
        }
        return binding.root
    }
}