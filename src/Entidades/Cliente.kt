package Entidades

class Cliente(
    private val nombres: String,
    private val primerApellido: String,
    private val rfc: String,
    private val direccion: String,
    private val listaReservacion: MutableList<Reservas> = mutableListOf()
) {

    fun getDatosCliente(): String {
        return "Nombre: $primerApellido $nombres RFC: $rfc Dirección: $direccion "
    }

    fun agregarReserva(reserva: Reservas) {
        listaReservacion.add(reserva)
    }
}
