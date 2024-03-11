package Controllers

import Entidades.Habitacion
import utils.Printer

class HabitacionController(private val printer: Printer) {

    private val listaHabitaciones = mutableListOf<Habitacion>(Habitacion(5000.00, 4, 31, true))

    fun registrarHabitacion() {
        printer.printMsg("Bienvenido, Ingrese el precio por noche")
        val precioxNoche = readln().toDouble()
        printer.printMsg("Por favor, Ingrese la capacidad")
        val capacidad: Int = readln().toInt()
        printer.printMsg("¿Qué numero de habitacion le gustaria?")
        val numHabitacion: Int = readln().toInt()
        val estaDisponible = true

        val habitacionAgregada = Habitacion(
            precioxNoche, capacidad, numHabitacion, estaDisponible
        )
        listaHabitaciones.add(habitacionAgregada)
    }

    fun modificarHabitacion(habitacionModificada: Habitacion, indice: Int) {
        listaHabitaciones[indice] = habitacionModificada
    }

    fun obtenerHabitacionPorIndice(indice: Int): Habitacion {
        return listaHabitaciones[indice]
    }

    fun mostrarHabitaciones() {
        if (listaHabitaciones.isEmpty()) {
            printer.printMsg("Aún no se encuentran habitaciones registradas")
        } else {
            var contador = 1
            for (habitacion in listaHabitaciones) {
                printer.printMsg("$contador " + habitacion.getDatosHabitacion())
                contador++
            }
        }
    }

    fun noHayHabitacionesRegistradas(): Boolean = listaHabitaciones.isEmpty()

}