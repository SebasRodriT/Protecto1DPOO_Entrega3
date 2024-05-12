package uniandes.dpoo.galeria.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import uniandes.dpoo.galeria.modelo.usuario.Comprador;
import uniandes.dpoo.galeria.modelo.usuario.Usuario;
import uniandes.dpoo.galeria.modelo.plataforma.Plataforma;

public class Galeria {
	private String ubicacion;
	private int cantidadPiezas;
	private static ArrayList<Pieza> piezasExhibidas = new ArrayList<Pieza>();
    private static ArrayList<Pieza> piezasBodega = new ArrayList<Pieza>();
    private static ArrayList<Pieza> historicoPiezas = new ArrayList<Pieza>();
    private Plataforma plataforma;
    private ArrayList<Usuario> usuarios;

    public Galeria(String ubicacion, int cantidadPiezas) {
    	this.ubicacion = ubicacion;
    	this.cantidadPiezas = cantidadPiezas;
    	this.plataforma = Plataforma.obtenerInstancia();
    	this.usuarios = plataforma.getUsuarios();

    }

	public String getUbicacion() {
		return ubicacion;
	}

	public int getCantidadPiezas() {
		return cantidadPiezas;
	}
    
	 
	public boolean verificarComprador(Comprador comprador) {
	    	boolean encontrado = false;
        
        for (int i = 0; i < usuarios.size(); i++) {
        	 if (usuarios != null && usuarios.get(i).getNombre() != null) {
	            if (usuarios.get(i).getNombre().equals(comprador.getNombre())) {
	                encontrado = true;
	                break;
	            }
        	 }
        }
        
        if (encontrado) {
            System.out.println("El comprador está en la lista de usuarios.");
            return true;
        } else {
            System.out.println("El comprador NO está en la lista de usuarios.");
            return false;
        }
    	
    }
    
    public void agregarPiezaExhibida(Pieza pieza) {
    	Galeria.piezasExhibidas.add(pieza);
    }
    
    public ArrayList<Pieza> getPiezasExhibidas() {
		return piezasExhibidas;
	}

	public ArrayList<Pieza> getPiezasBodega() {
		return piezasBodega;
	}

	public ArrayList<Pieza> getHistoricoPiezas() {
		return historicoPiezas;
	}

	public void agregarPiezaBodega(Pieza pieza) {
    	Galeria.piezasBodega.add(pieza);
    }
    
    public void agregarPiezaHistorico(Pieza pieza) {
    	Galeria.historicoPiezas.add(pieza);
    	
    }
    
    public void eliminarPiezaExhibida(Pieza pieza) {
    	Galeria.piezasExhibidas.remove(pieza);
    }
    
    public void eliminarPiezaBodega(Pieza pieza) {
    	Galeria.piezasBodega.remove(pieza);
    }
    
    public static Pieza buscarPiezaExhibida(Pieza pieza) {
    	Pieza piezaEncontrada = null;
    	String tituloObra = pieza.getTituloObra();
    	for (int i = 0; i < piezasExhibidas.size(); i++) {
    	    Pieza piezaLista = piezasExhibidas.get(i);
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
    	
    public static Pieza buscarPiezaBodega(Pieza pieza) {
    	Pieza piezaEncontrada = null;
    	String tituloObra = pieza.getTituloObra();
    	for (int i = 0; i < piezasBodega.size(); i++) {
    	    Pieza piezaLista = piezasBodega.get(i);
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
    
    public static Pieza buscarPiezahistorico(Pieza pieza) {
    	Pieza piezaEncontrada = null;
    	String tituloObra = pieza.getTituloObra();
    	for (int i = 0; i < historicoPiezas.size(); i++) {
    	    Pieza piezaLista = historicoPiezas.get(i);
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
}
