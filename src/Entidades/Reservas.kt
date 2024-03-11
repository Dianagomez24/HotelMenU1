package Entidades

class Reservas(
    private val cliente: Cliente,
    private val habitacion: Habitacion,
    private val fechaInicio: String,
    private val fechaFin: String,
    private var totalxNoches: Int,
    private var noDisponible: Boolean = false,
) {
    private var precioTotal = 0.0

    fun calcularPrecio() {
        precioTotal = habitacion.precioxNoche * totalxNoches
    }

    fun cancelarReservaciones() {
        noDisponible = true
    }

    fun actualizarlasNoches(totalNoches: Int) {
        this.totalxNoches = totalNoches
    }

    fun getTotal(): Double = precioTotal

    fun getDatosReserva(): String {
        return "Nombre cliente ${cliente.getDatosCliente()}" + "Total de noches: $totalxNoches" +
                "Fecha inicio :  $fechaInicio" +
                "Fecha final :  $fechaFin" +
                "Total : $precioTotal"
    }
}