import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.*;

public class Servidor extends JFrame{
    private JLabel titulo;
    public JTextArea msg_area;
    private JPanel sur;

    private ServerSocket server;
    private final int PUERTOH = 1000;    

    public Servidor(){
      initComponets();

        try {
            server = new ServerSocket(PUERTOH);
            mensajeria("*.:Servidor Con Conexion:.* \n");
            super.setVisible(true);
            while (true) {
                Socket cliente = server.accept();
                mensajeria("Cliente conectado desde la direccion: " + cliente.getInetAddress().getHostAddress());
                
                DataInputStream entrada = new DataInputStream(cliente.getInputStream());
                
                HiloServidor hilo = new HiloServidor(cliente, entrada.readUTF(), this);
                hilo.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void mensajeria(String msg){
        msg_area.append(" " + msg + " \n");
    }


    public static void main(String[] args) {
        new Servidor();
    }

    public void initComponets(){
        titulo = new JLabel("Servidor");
        msg_area = new JTextArea();
        sur = new JPanel(new BorderLayout());

        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(titulo, BorderLayout.NORTH);
        this.add(msg_area, BorderLayout.CENTER);
        this.add(sur, BorderLayout.SOUTH);


        this.setSize(400, 450);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Chat Server");
    }

}
