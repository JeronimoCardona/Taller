package com.ejemplo.listadetareas

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ejemplo.listadetareas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val listaTareas = mutableListOf<Tarea>()
    private lateinit var adapter: TareaAdapter
    private var contadorId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configurarRecyclerView()
        configurarBotones()
    }

    private fun configurarRecyclerView() {
        // TODO 1 SOLUCIÓN: Crear el adapter pasando listaTareas y una lambda para eliminar
        adapter = TareaAdapter(listaTareas) { posicion ->
            eliminarTarea(posicion)
        }

        // TODO 2 SOLUCIÓN: Asignar un LinearLayoutManager al RecyclerView
        binding.rvTareas.layoutManager = LinearLayoutManager(this)

        // TODO 3 SOLUCIÓN: Asignar el adapter al RecyclerView
        binding.rvTareas.adapter = adapter
    }

    private fun configurarBotones() {
        binding.btnAgregar.setOnClickListener {
            val texto = binding.etNuevaTarea.text.toString().trim()
            if (texto.isNotEmpty()) {
                agregarTarea(texto)
                binding.etNuevaTarea.text.clear()
            } else {
                Toast.makeText(this, "Escribe una tarea primero", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun agregarTarea(titulo: String) {
        // TODO 4 SOLUCIÓN: Incrementar contadorId
        contadorId++

        // TODO 5 SOLUCIÓN: Crear una nueva Tarea con el id y titulo
        val nuevaTarea = Tarea(contadorId, titulo)

        // TODO 6 SOLUCIÓN: Agregarla a listaTareas
        listaTareas.add(nuevaTarea)

        // TODO 7 SOLUCIÓN: Notificar al adapter
        adapter.notifyItemInserted(listaTareas.size - 1)

        // TODO 8 SOLUCIÓN: Llamar a actualizarContador()
        actualizarContador()
    }

    private fun eliminarTarea(posicion: Int) {
        // TODO 9 SOLUCIÓN: Remover la tarea en la posición dada
        listaTareas.removeAt(posicion)

        // TODO 10 SOLUCIÓN: Notificar al adapter
        adapter.notifyItemRemoved(posicion)
        adapter.notifyItemRangeChanged(posicion, listaTareas.size)

        // TODO 11 SOLUCIÓN: Llamar a actualizarContador()
        actualizarContador()
    }

    private fun actualizarContador() {
        // TODO 12 SOLUCIÓN: Contar cuántas tareas tienen completada == false
        val pendientes = listaTareas.count { !it.completada }

        // TODO 13 SOLUCIÓN: Actualizar el TextView del contador
        binding.tvContador.text = "$pendientes tareas pendientes"
    }
}
