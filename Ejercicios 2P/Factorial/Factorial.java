import java.util.Scanner;

public class Factorial{
    private double n;
    private double factorial;

    public Factorial(){
        n = 0;
        factorial = 1;
    }

    public void calcularFactorial(double num){
        n = num;
        for (double i = 1; i <=n; i++) {
            factorial = factorial * i;
        }
        System.out.println("Respuesta: " + factorial);
    }

    public static void main(String[] args) {
        double tiempoInicio, tiempoFinal;
        Scanner lec = new Scanner(System.in);

        System.out.println("Ingrese un número: ");
        double numero = lec.nextDouble();
        lec.close();

        tiempoInicio = System.currentTimeMillis();
        
        Factorial fac = new Factorial();
        fac.calcularFactorial(numero);
        
        tiempoFinal = System.currentTimeMillis();

        System.out.println("Tiempo: " + (tiempoFinal - tiempoInicio) + " milisegundos");

    }

}