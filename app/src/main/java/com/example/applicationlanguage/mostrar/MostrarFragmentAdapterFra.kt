package com.example.applicationlanguage.mostrar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationlanguage.R
import com.example.applicationlanguage.database.palabras

class MostrarFragmentAdapterFra(private val context: Context,
                                private val list: List<palabras>) : RecyclerView.Adapter<MostrarFragmentAdapterFra.ViewHolder>()  {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val primertv: TextView = view.findViewById(R.id.textViewPronunciacioF)
        val segontv: TextView = view.findViewById(R.id.textViewPronunciacioAprenderF)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MostrarFragmentAdapterFra.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_f,parent, false)
        return MostrarFragmentAdapterFra.ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: MostrarFragmentAdapterFra.ViewHolder, position: Int) {
        val data = list[position]
        holder.primertv.text = data.localpalabra
        holder.segontv.text = data.aprenderpalabra
    }
}