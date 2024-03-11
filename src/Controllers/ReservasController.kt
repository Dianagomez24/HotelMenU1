package Controllers

import Entidades.Cliente
import Entidades.Habitacion
import Entidades.Reservas
import utils.Printer

class ReservasController {

    private val printer = Printer()
    private val listaReservas = mutableListOf<Reservas>()

    fun crearReservas(
        clientes: Cliente, habitacion: Habitacion) {
        printer.printMsg("Bienvenido, Ingrese la fecha de inicio")
        val fechaInicio = readln()
        printer.printMsg("De igual manera, Ingrese la fecha de salida")
        val fechaFin = readln()
        printer.printMsg("Ingrese el número de noches")
        val totalxNoches = readln().toInt()

        val reservaAgregada = Reservas(
            clientes, habitacion, fechaInicio, fechaFin, totalxNoches, false
        )
        reservaAgregada.calcularPrecio()
        clientes.agregarReserva(reservaAgregada)
        listaReservas.add(reservaAgregada)
    }

    fun mostrarReservas() {
        if (listaReservas.isEmpty()) {
            printer.printMsg("Aún no se encuentran reservas registradas")
        } else {
            var contador = 1
            for (reserva in listaReservas) {
                printer.printMsg("$contador " + reserva.getDatosReserva())
                contador++
            }
        }
    }
}