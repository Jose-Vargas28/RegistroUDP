package servidor;

import modelo.*;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServidorUDP {

    private RegistroUsuarios registro = new RegistroUsuarios();

    public void iniciar(int puerto) throws Exception {

        DatagramSocket socket = new DatagramSocket(puerto);
        System.out.println("Servidor UDP Registro activo en puerto " + puerto);

        while (true) {

            byte[] buffer = new byte[1024];
            DatagramPacket entrada = new DatagramPacket(buffer, buffer.length);
            socket.receive(entrada);

            String mensaje =
                    new String(entrada.getData(), 0, entrada.getLength());

            String respuesta;
            String[] partes = mensaje.split(";");

            switch (partes[0]) {

                case "REGISTRAR":
                    respuesta = registrarUsuario(partes);
                    break;

                case "CONSULTAR":
                    respuesta = consultarUsuario(partes[1]);
                    break;

                case "RECARGAR":
                    respuesta = recargarTarjeta(partes);
                    break;

                case "PAGAR":
                    respuesta = pagarPasaje(partes[1]);
                    break;

                default:
                    respuesta = "ERROR: Comando no reconocido";
            }

            byte[] salida = respuesta.getBytes();
            DatagramPacket paqueteSalida =
                    new DatagramPacket(
                            salida, salida.length,
                            entrada.getAddress(), entrada.getPort()
                    );

            socket.send(paqueteSalida);
        }
    }


    private String registrarUsuario(String[] partes) {

        Usuario usuario = new Usuario(
                partes[1], // cédula
                partes[2], // correo
                partes[3], // teléfono
                partes[4], // nombre
                Boolean.parseBoolean(partes[5]) // preferencial
        );

        return registro.registrarUsuario(usuario);
    }

    private String consultarUsuario(String cedula) {

        Usuario u = registro.buscarUsuario(cedula);

        if (u == null) {
            return "ERROR: Usuario no encontrado";
        }

        return "OK;" + u.obtenerInformacion();
    }

    private String recargarTarjeta(String[] partes) {

        Usuario u = registro.buscarUsuario(partes[1]);

        if (u == null) {
            return "ERROR: Usuario no encontrado";
        }

        double monto = Double.parseDouble(partes[2]);
        u.getTarjeta().cargarSaldo(monto);

        return "OK;Saldo actual:" + u.getTarjeta().getSaldo();
    }

    private String pagarPasaje(String cedula) {

        Usuario u = registro.buscarUsuario(cedula);

        if (u == null) {
            return "ERROR: Usuario no encontrado";
        }

        boolean pagado =
                u.getTarjeta().pagarPasaje(u.isPreferencial());

        if (pagado) {
            return "OK;Pago exitoso;Saldo:" + u.getTarjeta().getSaldo();
        }
        return "ERROR;Saldo insuficiente";
    }
}