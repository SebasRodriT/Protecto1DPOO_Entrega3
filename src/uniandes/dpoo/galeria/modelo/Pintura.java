package uniandes.dpoo.galeria.modelo;

public class Pintura extends Pieza{
	private String tecnica;
	private String estilo;
	private double alto;
	private double ancho;
	
	public Pintura(String tecnica, String estilo, double alto, double ancho, boolean vendida ,String tituloObra, int año,String lugarCreacion, Artista autor, boolean exhibido, String tematica, int precio) {
		super(vendida, tituloObra, año, lugarCreacion, autor, exhibido, tematica, precio);
		this.tecnica = tecnica;
		this.estilo = estilo;
		this.alto = alto;
		this.ancho = ancho;
	}

	public String getTecnica() {
		return tecnica;
	}

	public String getEstilo() {
		return estilo;
	}

	public double getAlto() {
		return alto;
	}

	public double getAncho() {
		return ancho;
	}
	
	
}
