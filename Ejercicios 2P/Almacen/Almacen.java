public class Almacen {
    private char[] contenedor = new char[6];
    int ptr = 0;
    private boolean isFull = false;
    private boolean isEmpty = true;

    public Almacen() {
        isEmpty = true;
        isFull = false;
    }

    public synchronized char obtener() {
        while (isEmpty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ptr--;
        char ret = contenedor[ptr];
        if (ptr < 0) {
            isEmpty = true;
        }
        isFull = false;
        notify();
        return ret;
    }

    public synchronized void asignar(char c) {
        while (isFull) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        contenedor[ptr] = c;
        ptr++;
        if (ptr == contenedor.length) {
            isFull = true;
        }
        isEmpty = false;
        notify();
    }

}