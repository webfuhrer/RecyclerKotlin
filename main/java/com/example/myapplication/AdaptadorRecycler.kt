package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.vista_alumno.view.*

class AdaptadorRecycler(val elementos: List<Alumno>, val oyente: Oyente) : RecyclerView.Adapter<AdaptadorRecycler.HolderAlumno>() {

    interface Oyente
    {
        fun clickSimple(alumno: Alumno)
        fun clickLargo (alumno: Alumno)
    }

    class HolderAlumno(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
    val tv_nombre=itemView.tv_nombre
    val tv_nota=itemView.tv_nota

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderAlumno {
        return  HolderAlumno(LayoutInflater.from(parent.context).inflate(R.layout.vista_alumno, parent,false))
    }

    override fun getItemCount(): Int {
        return elementos.size
    }

    override fun onBindViewHolder(holder: HolderAlumno, position: Int) {
        val alumno=elementos.get(position)
        holder.tv_nombre.text=alumno.nombre
        holder.tv_nota.text=alumno.nota.toString()
        holder.itemView.setOnClickListener{oyente.clickSimple(alumno)}
        holder.itemView.setOnLongClickListener{oyente.clickLargo(alumno);true}
    }
}