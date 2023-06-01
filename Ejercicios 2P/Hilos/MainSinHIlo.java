import java.util.Random;

public class MainSinHIlo implements Runnable {
    private String name;

    public MainSinHIlo(String name){
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i <10; i++) {
            print();            
        }
    }

    public void print(){
        Random r = new Random();
        int d = r.nextInt(1000);
        System.out.println(String.format("%s: Número generado: %d", name, d));
    }
 
    public static void main(String[] args) {
        MainSinHIlo m1 = new MainSinHIlo("P1");
        MainSinHIlo m2 = new MainSinHIlo("P2");
        MainSinHIlo m3 = new MainSinHIlo("P3");

        Thread t1 =  new Thread(m1);
        Thread t2 = new Thread(m2);
        Thread t3 = new Thread(m3);
        
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
        t3.start();

        // m1.run();
        // m2.run();
        // m3.run();

        // Hacer un programa que utilizando hilos 
        // Divida las operaciones al realizar en el factorial
        // Comparar cual tarda más con timimilis en promedio 100 veces
    }

}
