using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Práctica1
{
    public partial class Form1 : Form
    {//Clase principal
        private int dat1;//Numero 1 ingresado.
        private int dat2;//Numero 2 ingresado.
        private string op;//Tipo de operación a realizar.
        private Operaciones operac;//Objeto de la clase Operaciones.
        public Form1()
        {//Inicialización de los componentes y del objeto operac.
            InitializeComponent();
            operac = new Operaciones();
        }
        //Metodos que permiten aciones al presionar los botones.
        private void btn_1(object sender, EventArgs e)
        {
            txt_in.Text = (txt_in.Text + "1");
        }
        //Al presionar algún boton con un número se muestra lo que está en el TextBox seguido del número que se presionó.
        private void btn_2(object sender, EventArgs e)
        {
            txt_in.Text = (txt_in.Text + "2");
        }

        private void btn_3(object sender, EventArgs e)
        {
            txt_in.Text = (txt_in.Text + "3");
        }

        private void btn_suma(object sender, EventArgs e)
        {//Al presionar una operación se guarda el numero que se ingreso y se pide el siguiente.
            String texto = txt_in.Text;
            //Primero se hace una comprobación para saber si lo que se guarda si es un número.
            {
                String nose = txt_in.Text;
                if (isNumber(nose))
                {
                    dat1 = int.Parse(nose);
                    op = "+";//Según la operación se define el operador.
                    txt_in.Text = "";
                }
                else
                    txt_in.Text = "Por favor ingresa solo números o datos de maximo 20 digitos";
            }
        }

        private void btn_4(object sender, EventArgs e)
        {
            txt_in.Text = (txt_in.Text + "4");
        }

        private void btn_5(object sender, EventArgs e)
        {
            txt_in.Text = (txt_in.Text + "5");
        }

        private void btn_6(object sender, EventArgs e)
        {
            txt_in.Text = (txt_in.Text + "6");
        }

        private void btn_resta(object sender, EventArgs e)
        {
            String nose = txt_in.Text;
            if (isNumber(nose))
            {
                dat1 = int.Parse(nose);
                op = "-";
                txt_in.Text = "";
            }
            else
                txt_in.Text = "Por favor ingresa solo números o datos de maximo 20 digitos";
        }

        private void btn_7(object sender, EventArgs e)
        {
            txt_in.Text = (txt_in.Text + "7");
        }

        private void btn_8(object sender, EventArgs e)
        {
            txt_in.Text = (txt_in.Text + "8");
        }

        private void btn_9(object sender, EventArgs e)
        {
            txt_in.Text = (txt_in.Text + "9");
        }

        private void btn_div(object sender, EventArgs e)
        {
            String nose = txt_in.Text;
            if (isNumber(nose))
            {
                dat1 = int.Parse(nose);
                op = "/";
                txt_in.Text = "";
            }
            else
                txt_in.Text = "Por favor ingresa solo números o datos de maximo 20 digitos";
        }

        private void btn_multi(object sender, EventArgs e)
        {
            String nose = txt_in.Text;
            if (isNumber(nose))
            {
                dat1 = int.Parse(nose);
                op = "*";
                txt_in.Text = "";
            }
            else
                txt_in.Text = "Por favor ingresa solo números o datos de maximo 20 digitos";
        }

        private void btn_0(object sender, EventArgs e)
        {
            txt_in.Text = (txt_in.Text + "0");
        }

        private void btn_cuadra(object sender, EventArgs e)
        {
            String nose = txt_in.Text;
            if (isNumber(nose))
            {
                dat1 = int.Parse(nose);
                op = "^";
                txt_in.Text = "";
            }
            else
                txt_in.Text = "Por favor ingresa solo números o datos de maximo 20 digitos";
        }
        //Al presionar el igual, guarada el segundo número y llama al método operac de la clase operaciones.
        private void btn_igual(object sender, EventArgs e)
        {
            String nose = txt_in.Text;
            if (isNumber(nose))
            {//Comprobación.
                dat2 = int.Parse(nose);
                txt_in.Text = operac.operacion(dat1,dat2,op);//Llamada al método.
            }
            else
                txt_in.Text = "Por favor ingresa solo números o datos de maximo 20 digitos";
        }
        public static bool isNumber(String cadena)
        {//metodo que prueba si el dato que se ingresa es un número
            bool resultado;
            try
            {
                int.Parse(cadena);
                resultado = true;
            }
            catch(FormatException)
            {
                resultado = false;
            }
            return resultado;
        }
        //Métod que hace que no se puedan ingresar numero de más de 20 digitos.
        private void txtResOP_TextChanged(object sender, EventArgs e)
        {
            txt_in.MaxLength = 20;
            if (txt_in.TextLength == 20)
            {
                txt_in.Text = "Desbordamiento de Digitos";
                MessageBox.Show("Error Desbordamiento de Digitos", null, MessageBoxButtons.OK);
            }
        }

    }
}
