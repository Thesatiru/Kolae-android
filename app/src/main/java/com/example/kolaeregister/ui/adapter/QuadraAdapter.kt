package com.example.kolaeregister.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kolaeregister.data.model.Venue
import com.example.kolaeregister.R
import com.example.kolaeregister.ui.quadra.InformationActivity

class QuadraAdapter(private val listaQuadras: List<Venue>) : RecyclerView.Adapter<QuadraAdapter.QuadraViewHolder>() {

    class QuadraViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtTitulo: TextView = view.findViewById(R.id.txtTitulo)
        val txtPreco: TextView = view.findViewById(R.id.txtPreco)
        val txtNota: TextView = view.findViewById(R.id.txtNota)
        val imgQuadra: ImageView? = view.findViewById(R.id.imgQuadra)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuadraViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_quadra, parent, false)
        return QuadraViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuadraViewHolder, position: Int) {
        val quadra = listaQuadras[position]

        holder.txtTitulo.text = quadra.name
        holder.txtPreco.text = if (quadra.pricePerHour != null) {
            "R$ ${quadra.pricePerHour}/h"
        } else {
            "Preço sob consulta"
        }
        holder.txtNota.text = quadra.rating.toString()

        if (holder.imgQuadra != null) {
            Glide.with(holder.itemView.context)
                .load(quadra.imageUrl)
                .placeholder(android.R.drawable.ic_menu_gallery)
                .into(holder.imgQuadra)
        }

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, InformationActivity::class.java).apply {
                putExtra("EXTRA_QUADRA", quadra)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listaQuadras.size
}