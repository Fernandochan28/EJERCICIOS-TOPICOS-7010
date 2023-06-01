import java.io.DataInputStream;
import java.io.DataOutputStream;
//import java.io.IOException;
//import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Vector;

public class HiloServidor extends Thread {
    private DataInputStream entrada;
    private DataOutputStream salida;
    private Servidor server;
    private Socket cliente;
    public static Vector<HiloServidor> usuarioActivo = new Vector<>();
    private String nombre;
    // private ObjectOutputStream salidaObjeto;

    public HiloServidor(Socket socketcliente, String nombre, Servidor serv) throws Exception {
        this.cliente = socketcliente;
        this.server = serv;
        this.nombre = nombre;
        usuarioActivo.add(this);

        for (int i = 0; i < usuarioActivo.size(); i++) {
            usuarioActivo.get(i).enviosMensajes(nombre + " Se ha conectado.");
        }
    }

    public void run() {
        String mensaje = " ";
        while (true) {
            try {
                entrada = new DataInputStream(cliente.getInputStream());
                mensaje = entrada.readUTF();

                for (int i = 0; i < usuarioActivo.size(); i++) {
                    usuarioActivo.get(i).enviosMensajes(mensaje);
                    server.mensajeria("Mensaje enviado");
                }
            } catch (Exception e) {
                break;
            }
        }

        usuarioActivo.removeElement(this);
        server.mensajeria("El usuario esta desconectado");
        try {
            cliente.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void enviosMensajes(String msg) throws Exception {
        salida = new DataOutputStream(cliente.getOutputStream());
        salida.writeUTF(msg);
    }

}
