package com.example.applicationlanguage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.applicationlanguage.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentSecondBinding>(inflater,
            R.layout.fragment_second,container,false)
        val args = SecondFragmentArgs.fromBundle(requireArguments())
        Toast.makeText(context, "Num: ${args.num}", Toast.LENGTH_LONG).show()

        return binding.root
    }
}