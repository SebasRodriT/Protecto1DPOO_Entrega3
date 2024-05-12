package uniandes.dpoo.galeria.persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import uniandes.dpoo.galeria.modelo.usuario.Comprador;

public class PersistenciaComprador {
    private static final String PATH_USUARIOS = "data/compradores.txt";

    /**
     * Guarda la información de un comprador en un archivo de texto.
     * 
     * @param comprador El objeto Comprador que contiene la información a guardar.
     */
    public static void guardarComprador(Comprador comprador) {
    File archivo = new File("data/compradores.txt"); 
    if (!archivo.exists()) {
        archivo.getParentFile().mkdirs(); 
        try {
            archivo.createNewFile(); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    try (PrintWriter writer = new PrintWriter(new FileWriter(archivo, true))) {
        StringBuilder sb = new StringBuilder();
        // Formato: nombre|identificacion|edad|nombreUsuario|contraseña|numeroTelefono|correo|saldo
        sb.append(comprador.getNombre()).append("|")
          .append(comprador.getIdentificacion()).append("|")
          .append(comprador.getEdad()).append("|")
          .append(comprador.getNombreUsuario()).append("|")
          .append(comprador.getPassword()).append("|")  
          .append(comprador.getNumeroTelefono()).append("|")
          .append(comprador.getCorreo()).append("|")
          .append(comprador.getSaldo());
        writer.println(sb.toString());
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    public static Comprador obtenerCompradorPorCedula(int cedula) {
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH_USUARIOS))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter("\\|");
                String nombre = lineScanner.next();
                long identificacion = lineScanner.nextLong();
                int edad = lineScanner.nextInt();
                String nombreUsuario = lineScanner.next();
                String contraseña = lineScanner.next();
                String numeroTelefono = lineScanner.next();
                String correo = lineScanner.next();
                int saldo = lineScanner.nextInt();
                
                if (identificacion == cedula) {
                    lineScanner.close();
                    return new Comprador(nombre, identificacion, edad, nombreUsuario, contraseña, numeroTelefono, correo, saldo);
                }
                lineScanner.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
