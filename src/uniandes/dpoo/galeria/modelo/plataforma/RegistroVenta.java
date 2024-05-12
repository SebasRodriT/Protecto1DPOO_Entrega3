package uniandes.dpoo.galeria.modelo.plataforma;

import java.util.ArrayList;
import java.util.HashMap;

import uniandes.dpoo.galeria.modelo.Pieza;
import uniandes.dpoo.galeria.modelo.usuario.Comprador;

public class RegistroVenta {
	
	private static RegistroVenta registroVentas;
	private ArrayList<Pieza> piezasVendidas = new ArrayList<Pieza>();
	private ArrayList<Comprador> compradores = new ArrayList<Comprador>();
	
	private RegistroVenta() {}
	
	public static synchronized RegistroVenta instancia(){
		
		if (registroVentas == null) {
			registroVentas = new RegistroVenta();
		}
		return registroVentas;
	}
	
	public void agregarPiezaVendida(Pieza pieza) {
		piezasVendidas.add(pieza);
	}
	
	public void agregarComprador(Comprador comprador) {
		compradores.add(comprador);
	}
	
}
