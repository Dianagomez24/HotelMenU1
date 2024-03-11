package Entidades

class Habitacion(
    val precioxNoche: Double,
    val capacidad: Int,
    val numHabitacion: Int,
    val disponibilidad: Boolean = true
) {

    fun getDatosHabitacion(): String {
        return "Número de habitación: $numHabitacion precioxnoche: $precioxNoche Capacidad : $capacidad Disposicion: ${if (disponibilidad) "Sí" else "No"}"
    }
}