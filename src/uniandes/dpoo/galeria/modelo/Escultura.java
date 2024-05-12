package uniandes.dpoo.galeria.modelo;

import java.util.ArrayList;

public class Escultura extends Pieza{
	private double alto;
	private double ancho;
	private double peso;
	private boolean necesitaElectricidad;
	private ArrayList<String> materialesDeConstruccion = new ArrayList<String>();
	private ArrayList<String> elementosDeInstalacion = new ArrayList<String>();
	
	public Escultura(double alto, double ancho, double peso, boolean necesitaElectricidad, boolean vendida ,String tituloObra, int año,String lugarCreacion, Artista autor, boolean exhibido, String tematica, int precio) {
		super(vendida, tituloObra, año, lugarCreacion, autor, exhibido, tematica, precio);
		this.alto = alto;
		this.ancho = ancho;
		this.peso = peso;
		this.necesitaElectricidad = necesitaElectricidad;
	}

	public ArrayList<String> getMaterialesDeConstruccion() {
		return materialesDeConstruccion;
	}

	public ArrayList<String> getElementosDeInstalacion() {
		return elementosDeInstalacion;
	}

	public double getAlto() {
		return alto;
	}

	public double getAncho() {
		return ancho;
	}

	public double getPeso() {
		return peso;
	}

	public boolean isNecesitaElectricidad() {
		return necesitaElectricidad;
	}
	
	public void marcarVerdaderaElectricidad() {
		necesitaElectricidad = true;
	}
	
	public void agregarMaterialDeConstruccion(String material) {
		this.materialesDeConstruccion.add(material);
	}
	
	public void agregarElementoInstalacion(String elemento) {
		this.elementosDeInstalacion.add(elemento);
	}
}
