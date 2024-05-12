package uniandes.dpoo.galeria.modelo.empleado;

import java.util.ArrayList;

import uniandes.dpoo.galeria.modelo.Inventario;
import uniandes.dpoo.galeria.modelo.Pieza;
import uniandes.dpoo.galeria.modelo.plataforma.Plataforma;

public class AdministradorInventario extends Empleado{
	private Inventario inventario = Inventario.obtenerInstanciaInv();
	
	public AdministradorInventario(String nombre, int identificacion, int edad) {
        super("Administrador Inventario", nombre, identificacion, edad);
    }
	
	public String getNombre() {
        return this.nombre;
    }

    public int getIdentificacion() {
        return this.identificacion;
    }

    public int getEdad() {
        return this.edad;
    }
    
    public Pieza buscarPiezaInventario(Pieza pieza) {
		Pieza piezaEncontrada = null;
    	String tituloObra = pieza.getTituloObra();
    	ArrayList<Pieza> inventarioPiezas = inventario.getInventarioPiezas();
    	for (int i = 0; i < inventario.getInventarioPiezas().size(); i++) {
    	    Pieza piezaLista = inventarioPiezas.get(i);
    	    if (piezaLista.getTituloObra().equals(tituloObra)) {
    	        piezaEncontrada = piezaLista;
    	        break; // Terminamos la búsqueda si encontramos la pieza
    	    }
    	}

    	// Verificar si se encontró la pieza y mostrar el resultado
    	if (piezaEncontrada != null) {
    	    System.out.println("Pieza encontrada: " + piezaEncontrada.getTituloObra());
    	    System.out.println("Autor pieza encontrada: " + piezaEncontrada.getAutor().getNombre());
    	    System.out.println("Año pieza encontrada: " + piezaEncontrada.getAño());
	        return piezaEncontrada;
    	} else {
    	    System.out.println("Pieza no encontrada");
    	    return null;
    	}
	}
    
    public Pieza buscarPieza(String nombre) {
		Pieza rta = null;
		ArrayList<Pieza> inventarioPiezas = inventario.getInventarioPiezas();
		for (int i = 0; i < inventario.getInventarioPiezas().size(); i++) {
			Pieza pieza = inventarioPiezas.get(i);
			if (pieza.getTituloObra().equalsIgnoreCase(nombre)) {
				rta = pieza;
				return rta;
			}
		}
		return rta;
	}
	
}
