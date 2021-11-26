package com.example.applicationlanguage.login

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.applicationlanguage.R
import com.example.applicationlanguage.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
   override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       val binding = DataBindingUtil.inflate<FragmentFirstBinding>(inflater,
           R.layout.fragment_first,container,false)
        binding.buttonGoIdioma.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_firstFragment_to_idiomaFragment)
        }
       binding.buttonGoLogin.setOnClickListener { view : View ->
           view.findNavController().navigate(R.id.action_firstFragment_to_loginFragment)
       }
       binding.buttonGoRegister.setOnClickListener { view : View ->
           view.findNavController().navigate(R.id.action_firstFragment_to_registreFragment)
       }

       setHasOptionsMenu(true)
       return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.option_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.
        onNavDestinationSelected(item,requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }


}