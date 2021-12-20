package com.example.applicationlanguage.mostrar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationlanguage.R
import com.example.applicationlanguage.database.palabraAprenderNumero

class MostrarFragmentAdapterNum(private val context: Context,
                                private val list: List<palabraAprenderNumero>) : RecyclerView.Adapter<MostrarFragmentAdapterNum.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val nametv: TextView = view.findViewById(R.id.textViewNum)
        val primertv: TextView = view.findViewById(R.id.textViewPronunciacio)
        val segontv: TextView = view.findViewById(R.id.textViewPronunciacioAprender)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_n,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]
        holder.nametv.text = data.numero.toString()
        holder.primertv.text = data.palabra_local
        holder.segontv.text = data.palabra_aprender
    }

}