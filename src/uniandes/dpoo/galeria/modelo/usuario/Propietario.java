package uniandes.dpoo.galeria.modelo.usuario;

import java.util.ArrayList;

public class Propietario extends Usuario {
    private int numeroTelefono;
    private String correo;
    private ArrayList<String> piezasQuePosee;
    private ArrayList<String> historicoPiezasVendidas;

    public Propietario(String nombre, int identificacion, int edad, String nombreUsuario, String password,
                       int numeroTelefono, String correo) {
        super(nombre, identificacion, edad, nombreUsuario, password, "Propietario");
        this.numeroTelefono = numeroTelefono;
        this.correo = correo;
        this.piezasQuePosee = new ArrayList<>();
        this.historicoPiezasVendidas = new ArrayList<>();
    }

    public int getNumeroTelefono() {
        return numeroTelefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void agregarPiezaQuePosee(String idPieza) {
       
        if (!piezasQuePosee.contains(idPieza)) {
            piezasQuePosee.add(idPieza);
            System.out.println("Pieza agregada a la colección del propietario.");
        } else {
            System.out.println("El propietario ya posee esta pieza.");
        }
    }

    public void agregarPiezaHistorico(String idPieza) {
       
        if (!historicoPiezasVendidas.contains(idPieza)) {
            historicoPiezasVendidas.add(idPieza);
            
            piezasQuePosee.remove(idPieza);
            System.out.println("Pieza agregada al historial de ventas.");
        } else {
            System.out.println("Esta pieza ya está en el historial de ventas.");
        }
    }}