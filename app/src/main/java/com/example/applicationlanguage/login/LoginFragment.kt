package com.example.applicationlanguage.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.applicationlanguage.R
import com.example.applicationlanguage.RoomViewModel
import com.example.applicationlanguage.RoomViewModelFactory
import com.example.applicationlanguage.database.database
import com.example.applicationlanguage.databinding.FragmentLoginBinding
import com.example.applicationlanguage.sharedpref.sharedApp

class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(inflater,
            R.layout.fragment_login,container,false)
        (activity as AppCompatActivity).supportActionBar?.title="Login"
        binding.buttonlogin.setOnClickListener {
            if(!binding.editTextTextPersonName.text.toString().isEmpty() && !binding.editTextTextPassword.text.toString().isEmpty()){

                val application = requireNotNull(this.activity).application
                val dataSource = database.getInstance(application).databaseDao
                val viewModelFactory = RoomViewModelFactory(dataSource, application)
                val roomViewModel = ViewModelProvider(this, viewModelFactory).get(RoomViewModel::class.java)
                roomViewModel.onLoginUser(binding.editTextTextPersonName.text.toString(),binding.editTextTextPassword.text.toString())

                if(roomViewModel.getinfo()=="ok") {
                    binding.buttonlogin.setOnClickListener { view: View ->
                        view.findNavController().navigate(R.id.action_loginFragment_to_idiomaFragment)
                        sharedApp.prefes.name=binding.editTextTextPersonName.text.toString()
                    }
                    binding.buttonlogin.callOnClick()
                }
                else{
                    binding.editTextTextPersonName.setText("")
                    binding.editTextTextPassword.setText("")
                    binding.textViewerrores.setText("")
                }
            }else{
                if(binding.editTextTextPersonName.text.toString().isEmpty()){
                    binding.textViewerrores.setText("el nom no pot ser vuit")
                }else if(binding.editTextTextPassword.text.toString().isEmpty()){
                    binding.textViewerrores.setText("la contaseña no pot ser vuida")
                }
            }
        }
        binding.textViewRegister.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_loginFragment_to_registreFragment)
        }
        return binding.root
    }

}