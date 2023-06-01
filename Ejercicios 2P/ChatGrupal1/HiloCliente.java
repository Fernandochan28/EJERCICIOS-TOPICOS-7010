import java.io.DataInputStream;
import java.io.IOException;
//import java.io.ObjectInputStream;
import java.net.Socket;

public class HiloCliente extends Thread {
    private Socket socketCliente;
    private DataInputStream entrada;
    private Cliente cliente;
    //private ObjectInputStream entradaObjeto;

    public HiloCliente(Socket socketCliente, Cliente cliente){
        this.socketCliente = socketCliente;
        this.cliente = cliente;
    }

    public void run(){
       while (true) {
            try {
                entrada = new DataInputStream(socketCliente.getInputStream());
                cliente.mensajeria(entrada.readUTF());
                
                //entradaObjeto = new ObjectInputStream(socketCliente.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
       }
    }

}
