package com.example.alvaaro.examenrecusegundajavierrl;

/**
 * Created by alvaaro on 01/03/2018.
 */

public class Contacto {
    String nombre, numero;

    public Contacto(String nombre,String numero){
        this.nombre=nombre;
        this.numero=numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
