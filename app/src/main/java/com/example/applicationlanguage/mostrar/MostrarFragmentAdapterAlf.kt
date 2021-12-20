package com.example.applicationlanguage.mostrar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationlanguage.R
import com.example.applicationlanguage.ShareViewModel
import com.example.applicationlanguage.database.palabraAprenderAlfabeto

class MostrarFragmentAdapterAlf(
    private val context: Context,
    private val list: List<palabraAprenderAlfabeto>,
    modelShare: ShareViewModel
) : RecyclerView.Adapter<MostrarFragmentAdapterAlf.ViewHolder>() {
    val Conetxt: Context=context
    val smodel: ShareViewModel = modelShare
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val nametv: TextView = view.findViewById(R.id.textViewAlf)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_a,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]
        holder.nametv.text = data.palabra_local
        holder.nametv.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_mostrarFragment_to_alfabetoMostrarFragment)

            smodel.sendalfa(holder.nametv.text.toString())
        }
    }

}