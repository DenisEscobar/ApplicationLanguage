package com.example.applicationlanguage.idioma

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationlanguage.R
import com.example.applicationlanguage.ShareViewModel
import com.example.applicationlanguage.database.idioma

class ConocimientoFragmentAdapter(
    private val context: Context,
    private val list: List<idioma>,
    modelShare: ShareViewModel
) : RecyclerView.Adapter<ConocimientoFragmentAdapter.ViewHolder>() {
    val Conetxt: Context =context
    val smodel: ShareViewModel = modelShare
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val nametv: Button = view.findViewById(R.id.buttonConocimiento)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_conocimiento,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]
        holder.nametv.text = data.conocimiento
        holder.nametv.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_conocimientoFragment_to_paraulasOTestFragment)

            smodel.sendconocimiento(holder.nametv.text.toString().lowercase())
        }
    }

}