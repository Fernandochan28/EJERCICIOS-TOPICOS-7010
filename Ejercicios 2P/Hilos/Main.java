import java.util.Random;

public class Main extends Thread {
    private String name;

    public Main(String name) {
        this.name = name;
    }

    public void run() {
        try {
            print();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void print() throws InterruptedException {
        Random r = new Random();
        int d = r.nextInt(10000);
        Thread.sleep(d);
        System.out.println(name + " - Número generado: " + d);
    }

    public static void main(String[] args) {
        Main m1 = new Main("P1");
        Main m2 = new Main("P2");
        Main m3 = new Main("P3");

        System.out.println("Llamar al proceso 1");
        m1.start();
        System.out.println("Llamar al proceso 2");
        m2.start();
        System.out.println("Llamar al proceso 3");
        m3.start();

        // m1.print();
        // m2.print();
        // m3.print();

        // -- Investigación --
        //Problemas de los hilos, en el uso de recursos compartidos
        //La mesa comensales o sena de los filosofos - problema de concurrencia
        
        //con implenents no lo convierte a hilo
    }

}