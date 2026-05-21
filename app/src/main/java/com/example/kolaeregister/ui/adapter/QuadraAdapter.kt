package com.example.kolaeregister.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kolaeregister.model.Quadra
import com.example.kolaeregister.R

class QuadraAdapter(private val listaQuadras: List<Quadra>) : RecyclerView.Adapter<QuadraAdapter.QuadraViewHolder>() {

    // 1. Acha os itens dentro do layout do card
    class QuadraViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtTitulo: TextView = view.findViewById(R.id.txtTitulo)
        val txtPreco: TextView = view.findViewById(R.id.txtPreco)
        val txtNota: TextView = view.findViewById(R.id.txtNota)
    }

    // 2. Diz qual XML usar (o nosso item_quadra)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuadraViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_quadra, parent, false)
        return QuadraViewHolder(view)
    }

    // 3. Preenche os dados de cada quadra na tela
    override fun onBindViewHolder(holder: QuadraViewHolder, position: Int) {
        val quadra = listaQuadras[position]
        holder.txtTitulo.text = quadra.nome
        holder.txtPreco.text = quadra.preco
        holder.txtNota.text = quadra.nota
    }

    // 4. Diz quantos itens a lista tem no total
    override fun getItemCount(): Int = listaQuadras.size
}