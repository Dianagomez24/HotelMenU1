package Controllers

import utils.Printer

class MenuController {

    private val printer = Printer()
    private val reservacionesController = ReservasController()
    private val clienteController = ClienteController()
    private val habitacionController = HabitacionController(printer)

    fun mostrarMenu() {
        printer.apply {
            printMsg("\nPor favor, ingrese una de las opciones mostradas")
            printMsg("\n1 - Registrar una habitación")
            printMsg("2 - Registrar un cliente")
            printMsg("3 - Crear una reserva")
            printMsg("4 - Mostrar las habitaciones")
            printMsg("5 - Mostrar los clientes registrados")
            printMsg("6 - Mostrar las reservas registradas")

            val opcionSeleccionada = readln().toInt()
            validarOpciones(opcionSeleccionada)
        }
    }

    private fun validarOpciones(opcionSeleccionada: Int) {
        when (opcionSeleccionada) {
            1 -> {
                habitacionController.registrarHabitacion()
                mostrarMenu()
            }

            2 -> {
                clienteController.registrarCliente()
                mostrarMenu()
            }

            3 -> {
                seleccionarHabitacionYCliente()
                mostrarMenu()
            }

            4 -> {
                habitacionController.mostrarHabitaciones()
                mostrarMenu()
            }

            5 -> {
                clienteController.mostrarClientes()
                mostrarMenu()
            }

            6 -> {
                reservacionesController.mostrarReservas()
                mostrarMenu()
            }
        }
    }

    private fun seleccionarHabitacionYCliente() {

        if (clienteController.noHayClientesRegistrados()) {
            printer.printMsg("Lo sentimos, no se encuentran clientes registrados")
            mostrarMenu()
            return
        }

        if (habitacionController.noHayHabitacionesRegistradas()) {
            printer.printMsg("Lo sentimos, no se encuentran habitaciones registradas")
            mostrarMenu()
            return
        }

        printer.printMsg("Ingrese un cliente")
        clienteController.mostrarClientes()

        val indiceClienteSeleccionado = readln().toInt()
        val cliente = clienteController.obtenerClientePorIndice(indiceClienteSeleccionado - 1)

        printer.printMsg("Seleccione una habitación")
        habitacionController.mostrarHabitaciones()
        val indiceHabitacionSeleccionada = readln().toInt()
        val habitacion = habitacionController.obtenerHabitacionPorIndice(indiceHabitacionSeleccionada - 1)

        reservacionesController.crearReservas(cliente, habitacion)
    }
}