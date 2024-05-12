package uniandes.dpoo.galeria.modelo.plataforma;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import uniandes.dpoo.galeria.modelo.Pieza;
import uniandes.dpoo.galeria.modelo.pago.Pago;
import uniandes.dpoo.galeria.modelo.usuario.Comprador;
import uniandes.dpoo.galeria.modelo.usuario.Usuario;

public class Plataforma {
	
	private static Plataforma plataforma;
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private RegistroSubasta subasta;
	private RegistroVenta venta;

	
	
	private Plataforma() {
		subasta = RegistroSubasta.registro();
		venta = RegistroVenta.instancia();
		
	}
	
	public synchronized static Plataforma obtenerInstancia() {
        if (plataforma == null) {
        	plataforma = new Plataforma();
        }
        return plataforma;
    }
	
	
	public void vender(Comprador comprador, Pieza pieza, String fecha) throws Exception {
		if (comprador.getSaldo() >= pieza.getPrecio()) {
			int precio = pieza.getPrecio();
			Pago pago = new Pago(comprador, precio);
			pieza.marcarComoVendida(fecha);
			pieza.actualizarDueño(comprador.getNombre());
		}
		
		else {
			throw new Exception ("Saldo insuficiente para comprar la pieza");
		}
	}
	
	
	public Comprador subastar(Pieza pieza, String fecha) throws Exception {
		
		HashMap<String, HashMap<String, Integer>> ofertas = subasta.getOfertas();
		HashMap<String, Integer> ofertasPieza = ofertas.get(pieza.getTituloObra());
		if(ofertasPieza.size()>= 3) {
		String ganador = "";
		int mayor = -1;
		for (String nombre : ofertasPieza.keySet()) {
			Integer valor = ofertasPieza.get(nombre);
			int valorInt = valor.intValue();
			if (valorInt > mayor) {
					mayor = valorInt;
					ganador = nombre;		
			}}
		Comprador ganadorSubasta= encontrarComprador(ganador);
		Pago pago = new Pago(ganadorSubasta, mayor);
		ganadorSubasta.agregarPieza(pieza);
		pieza.marcarComoVendida(fecha);
		pieza.actualizarDueño(ganadorSubasta.getNombre());
		return ganadorSubasta;}
	else {
		throw new Exception ("Personas insuficientes para ejecutar la subasta");
	}
		
		
	} 
	
	public void registrarUsuario (Usuario usuario) {
		usuarios.add(usuario);
	}
		
	
	

	public Comprador encontrarComprador(String nombre) {
    	int i = 0;
    	Comprador comprador = null;
    	while (i<usuarios.size()) {
    		Usuario usuario = usuarios.get(i);
    		if (usuario.getNombre().equals(nombre)) {
    			comprador = (Comprador) usuario;
    			return comprador;}
    		i++;}
		return comprador;
    		}
    	
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	
	
}