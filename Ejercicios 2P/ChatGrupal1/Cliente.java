import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.*;

public class Cliente extends JFrame implements ActionListener, KeyListener {
    private JLabel titulo;
    public JTextArea msg_area;
    private JTextField msg_text;
    private JButton msg_send;
    private JPanel sur;

    private Socket cliente;
    private final int PUERTOC = 1000;
    private String host = "10.0.36.204";
    private DataOutputStream salida;
    private String nombre;

    public Cliente() {
        initComponets();
        try {
            nombre = JOptionPane.showInputDialog("Su nombre ");
            super.setTitle(super.getTitle() + " " + nombre);
            super.setVisible(true);
            cliente = new Socket(host, PUERTOC);
            DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
            salida.writeUTF(nombre);
            HiloCliente hilo = new HiloCliente(cliente, this);
            hilo.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mensajeria(String msg) {
        this.msg_area.append(" " + msg + "\n");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            salida = new DataOutputStream(cliente.getOutputStream());
            salida.writeUTF(nombre + ": " + this.msg_text.getText());
            msg_text.setText(" ");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Cliente();
    }

    private void initComponets() {
        titulo = new JLabel("Cliente");
        msg_area = new JTextArea();
        msg_text = new JTextField();
        msg_send = new JButton("Enviar");
        sur = new JPanel(new BorderLayout());

        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(titulo, BorderLayout.NORTH);
        this.add(msg_area, BorderLayout.CENTER);
        sur.add(msg_text, BorderLayout.CENTER);
        sur.add(msg_send, BorderLayout.EAST);
        this.add(sur, BorderLayout.SOUTH);

        msg_send.addActionListener(this);
        msg_text.addKeyListener(this);

        this.setSize(400, 550);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Chat");
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                salida = new DataOutputStream(cliente.getOutputStream());
                salida.writeUTF(nombre + ": " + this.msg_text.getText());
                msg_text.setText(" ");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}