package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.AdaptadorRecycler.Oyente
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cargarLista()
        tv_texto.ocultarTextViewVacio("Hola Manolito")
    }

    private fun cargarLista() {
       var a=Alumno("Pepe", 8.5)
       var b=Alumno("Ana", 3.5)
       var alumnos= listOf(a, b)
       lista_alumnos.layoutManager=LinearLayoutManager(this)
       lista_alumnos.adapter=AdaptadorRecycler(alumnos, object: Oyente {
           override fun clickSimple(alumno: Alumno) {
              Log.d("ClickSimple", alumno.nombre+" "+alumno.nota)
           }

           override fun clickLargo(alumno: Alumno) {
               Log.d("ClickLargo", alumno.nombre+" "+alumno.nota)
           }

       })
    }
}
fun TextView.ocultarTextViewVacio(texto: String)
{
    this.text=texto
    if (texto.equals(""))
    {
        this.visibility= View.GONE
    }
    else {
        this.visibility = View.VISIBLE
    }
}
class Alumno(var nombre: String, var nota: Double)