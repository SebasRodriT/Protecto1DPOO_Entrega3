package uniandes.dpoo.galeria.modelo;

import java.util.ArrayList;
import java.util.HashMap;


public class Inventario {
	private ArrayList<Pieza> inventarioPiezas = new ArrayList<Pieza>();
	private HashMap<String, ArrayList<Pieza>> inventarioArtistas= new HashMap<String, ArrayList<Pieza>>();
	private static Inventario inventario;
	
	private Inventario() {
	}
	
	public synchronized static Inventario obtenerInstanciaInv() {
        if (inventario == null) {
        	inventario = new Inventario();
        }
        return inventario;
    }
	
	public void agregarPiezainventario(Pieza pieza) {
		this.inventarioPiezas.add(pieza);
		String artista = pieza.getAutor().getNombre();
		if (!inventarioArtistas.containsKey(artista)) {
			ArrayList<Pieza> piezas = new ArrayList<Pieza>();
			inventarioArtistas.put(artista, piezas);}
		ArrayList<Pieza> piezasArtista = inventarioArtistas.get(artista);
		piezasArtista.add(pieza);
		inventarioArtistas.put(artista, piezasArtista);
	}
	
	public void eliminarPiezainventario(Pieza pieza) {
    	this.inventarioPiezas.remove(pieza);
    }
	
	public ArrayList<Pieza> getInventarioPiezas() {
		return inventarioPiezas;
	}

	public Pieza buscarPieza(String nombrePieza) {
		for (Pieza nPieza: inventarioPiezas) {
			if (nPieza.getTituloObra().equalsIgnoreCase(nombrePieza)){
				return nPieza;
			}
		}
		return null;
	}
	
	public ArrayList<Pieza> historiaArtista(String nombreArtista){
		if (inventarioArtistas.containsKey(nombreArtista)) {
			return inventarioArtistas.get(nombreArtista);
		}
		return null;
	}

}
