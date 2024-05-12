package uniandes.dpoo.galeria.modelo;


public class Dibujo extends Pieza{
	private String medio;
	private String tecnica;
	private String estilo;
	private String tamaño;
	
	public Dibujo(String medio,String tecnica,String estilo,String tamaño, boolean vendida ,String tituloObra, int año,String lugarCreacion, Artista autor, boolean exhibido, String tematica, int precio) {
		super(vendida, tituloObra, año, lugarCreacion, autor, exhibido, tematica, precio);
		this.medio = medio;
		this.tecnica = tecnica;
		this.estilo = estilo;
		this.tamaño = tamaño;
	}

	public String getMedio() {
		return medio;
	}

	public String getTecnica() {
		return tecnica;
	}

	public String getEstilo() {
		return estilo;
	}

	public String getTamaño() {
		return tamaño;
	}
	
	
}
