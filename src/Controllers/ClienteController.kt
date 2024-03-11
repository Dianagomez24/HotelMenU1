package Controllers

import utils.Printer
import Entidades.Cliente

class ClienteController {

    private val printer = Printer()
    private val listaClientes = mutableListOf<Cliente>(
        Cliente(
            "Katherin",
            "Rutherford",
            "ayd080124",
            "Cornelia street",
        )
    )

    fun registrarCliente() {
        printer.printMsg("Bienvenido, Ingrese susnombres")
        val nombres = readln()
        printer.printMsg("Ingrese su primer apellido")
        val primerApellido = readln()
        printer.printMsg("Ingrese su RFC")
        val rfc = readln()
        printer.printMsg("Ingrese su dirección")
        val direccion = readln()


        val clienteAgregado = Cliente(
            nombres, primerApellido, rfc, direccion,
        )

        listaClientes.add(clienteAgregado)
    }

    fun mostrarClientes() {
        if (listaClientes.isEmpty()) {
            printer.printMsg("Lo sentimos, no se encuentran clientes registrados")
        } else {
            var contador = 1
            for (cliente in listaClientes) {
                printer.printMsg("$contador-" + cliente.getDatosCliente())
                contador++
            }
        }
    }

    fun cargarClientesDesdeBD(){

    }

    fun obtenerClientePorIndice(indice: Int): Cliente = listaClientes[indice]

    fun noHayClientesRegistrados(): Boolean = listaClientes.isEmpty()
}
