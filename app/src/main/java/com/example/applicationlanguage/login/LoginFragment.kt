package com.example.applicationlanguage.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.applicationlanguage.R
import com.example.applicationlanguage.databinding.FragmentLoginBinding

class loginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(inflater,
            R.layout.fragment_login,container,false)
        binding.buttonlogin.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_loginFragment_to_idiomaFragment)
        }
        return binding.root
    }

}