import java.util.Scanner;

public class FactorialConHilo implements Runnable {
    private static double n;
    private double inicio, fin;
    private double factorial;

    public FactorialConHilo(double inicio, double fin) {
        this.inicio = inicio;
        this.fin = fin;
        factorial = 1;
    }

    @Override
    public void run() {
        for (double i = inicio; i <= fin; i++) {
            factorial = factorial * i;
        }
    }


    public static void main(String[] args) throws InterruptedException {
        double tiempoInicio, tiempoFinal;

        Scanner lec = new Scanner(System.in);
        System.out.println("Ingrese un número: ");
        n = lec.nextDouble();
        lec.close();

        double total;

        tiempoInicio = System.currentTimeMillis();

        if ((n % 2) == 0) {
            FactorialConHilo fac1 = new FactorialConHilo(1, n / 2);
            FactorialConHilo fac2 = new FactorialConHilo((n / 2) + 1, n);
            Thread t1 = new Thread(fac1);
            Thread t2 = new Thread(fac2);
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            total = fac1.factorial * fac2.factorial;
        } else {
            FactorialConHilo fac1 = new FactorialConHilo(1, n / 2);
            FactorialConHilo fac2 = new FactorialConHilo((n / 2) + 0.5, n);
            Thread t1 = new Thread(fac1);
            Thread t2 = new Thread(fac2);
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            total = fac1.factorial * fac2.factorial;
        }

        tiempoFinal = System.currentTimeMillis();
        System.out.println("Respuesta: " + total);

        System.out.println("Tiempo: " + (tiempoFinal - tiempoInicio) + " milisegundos");

    }

}