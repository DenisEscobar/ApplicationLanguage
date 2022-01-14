package com.example.applicationlanguage.login

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
import com.example.applicationlanguage.database.database
import com.example.applicationlanguage.databinding.FragmentRegistreBinding
import com.example.applicationlanguage.sharedpref.sharedApp

class RegistreFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentRegistreBinding>(inflater,
            R.layout.fragment_registre,container,false)
        binding.registrarte.setOnClickListener { view : View ->
            if(!binding.editTextTextName.text.toString().isEmpty() && !binding.editTextPassword.text.toString().isEmpty() && !binding.editTextTextEmail.text.toString().isEmpty()){
                view.findNavController().navigate(R.id.action_registreFragment_to_idiomaFragment)

                val application = requireNotNull(this.activity).application
                val dataSource = database.getInstance(application).databaseDao
                val viewModelFactory = RoomViewModelFactory(dataSource, application)
                val roomViewModel = ViewModelProvider(this, viewModelFactory).get(RoomViewModel::class.java)

                roomViewModel.onRegisterUser(binding.editTextTextName.text.toString(),binding.editTextPassword.text.toString(),binding.editTextTextEmail.text.toString())
                sharedApp.prefes.name=binding.editTextTextName.text.toString()
                binding.editTextTextName.setText("")
                binding.editTextPassword.setText("")
                binding.editTextTextEmail.setText("")
            }else {
                if (binding.editTextTextEmail.text.toString().isEmpty()) {
                    binding.TextViewerror.setText("el email no pot ser vuit")
                }
                if (binding.editTextPassword.text.toString().isEmpty()) {
                    binding.TextViewerror.setText("la contaseña no pot ser vuida")
                }
                if (binding.editTextTextName.text.toString().isEmpty()) {
                    binding.TextViewerror.setText("el nom no pot ser vuit")
                }
            }
        }

        return binding.root
    }
}