package Practicas.Java.Practica3.IP;

import java.net.*;

public class DireccionIP {
    public String direccion(String host) {
        try {
            Socket socket = new Socket(host, 80);//Obtencion de IP
            String ip = socket.getInetAddress().getHostAddress();
            return ip;
        } catch (Exception e) {
        }
        return null;
    }
}
