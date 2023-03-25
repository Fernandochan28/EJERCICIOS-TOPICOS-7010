package Practicas.Java.Practica1;
//Clase que realiza las operaciones.
public class Controlador{
    public String Operac(int dat1, int dat2, String op) {//Recibe los dos numeros y el operador.
        switch (op) {//Según el operdor se realiza la operación definida
        case "+"://Suma
            int suma = dat1 + dat2;
            return suma + "";

        case "-"://Resta
            int resta = dat1 - dat2;
            return resta + "";

        case "/"://División
            if (dat1 > 0 && dat2 > 0) {//Comprueba que los datos son diferentes a 0.
                int divicion = dat1 / dat2;//Porque no se puede dividir entre 0.
                return divicion + "";
            } else {
                return "Imposible división entre 0";
            }

        case "*"://Multiplicación.
            int multiplicacion = dat1 * dat2;
            return multiplicacion + "";

        case "^"://Elevar.
            if (dat2 != 0) {//Ve que a lo que se elavará sea diferente de 0.
                double elevar = Math.pow(dat1, dat2);
                return elevar + "";
            }
            break;
        default:
            return "";
        }

        return null;
    }
    //metodo que prueba si el dato que se ingresa es un número
    public boolean isNumber(String cadena) {
        boolean resultado;
        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }
}
