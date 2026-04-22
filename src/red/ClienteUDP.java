package red;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteUDP {

    private static final String HOST = "localhost";
    private static final int PUERTO = 5000;

    public String enviar(String mensaje) throws Exception {

        DatagramSocket socket = new DatagramSocket();
        InetAddress direccion = InetAddress.getByName(HOST);

        byte[] buffer = mensaje.getBytes();
        DatagramPacket paquete =
                new DatagramPacket(buffer, buffer.length, direccion, PUERTO);
        socket.send(paquete);

        byte[] bufferRespuesta = new byte[1024];
        DatagramPacket respuesta =
                new DatagramPacket(bufferRespuesta, bufferRespuesta.length);

        socket.receive(respuesta);
        socket.close();
        return new String(
                respuesta.getData(), 0, respuesta.getLength()
        );
    }
}
