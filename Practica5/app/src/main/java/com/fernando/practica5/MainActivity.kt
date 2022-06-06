package com.fernando.practica5

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    // Declaracion de Variables
    lateinit var usuario: EditText
    lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // Muestra una alerta y pasa a la guiente ventana
    fun formLoginOk() {
        Toast.makeText(applicationContext, "Inicio de Sesion Correcto", Toast.LENGTH_SHORT).show()
        mostrarPantalla()
    }

    // Muestra un cuadro de dialogo de error de contraseña
    fun formLoginError() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle(" ")
        builder.setMessage("Error de Usuario y/o Contraseña")

        builder.setPositiveButton("Aceptar", DialogInterface.OnClickListener { dialog, which ->
            dialog.dismiss()
        })
        builder.show()
    }

    // Nos permite validar si lo ingresado por el usuario concuerda con lo declarado para acceder
    fun validarUsuario(view: View) {
        init()
        if(usuario.length() == 0 || password.length() == 0){
            Toast.makeText(applicationContext, "No puede dejar ningun campo Vacio", Toast.LENGTH_SHORT).show()
        } else {
            if (usuario.text.toString().equals("fernando") && password.text.toString().equals("12345")) {
                formLoginOk()
            } else {
                formLoginError()
            }
        }
    }

    // Funcion que permite invocan nuestra siguiente ventana
    fun mostrarPantalla(){
        val loggHome = Intent(this, homeLogin:: class.java)
        startActivity(loggHome)
    }

    // Inicializacion de los componentes
    fun init(){
        usuario = findViewById(R.id.txtUser)
        password = findViewById(R.id.txtPassword)
    }

}