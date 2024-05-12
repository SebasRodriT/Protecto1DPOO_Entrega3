package uniandes.dpoo.galeria.modelo.usuario;

import java.util.HashMap;
import java.util.Scanner;

import uniandes.dpoo.galeria.modelo.Pieza;
import uniandes.dpoo.galeria.modelo.plataforma.Plataforma;


public class Usuario {
    protected String nombre;
    protected long identificacion;
    protected int edad;
    protected String nombreUsuario;
    protected String password;
    private String road;
   


    public Usuario(String nombre, long identificacion, int edad, String nombreUsuario, String password, String road) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.edad = edad;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.road = road;

    }

    public String getNombre() {
        return nombre;
    }

    public long getIdentificacion() {
        return identificacion;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

  

    
}

