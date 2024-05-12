package uniandes.dpoo.galeria.modelo;

public class Video extends Pieza{
	private String calidadImagen;
	private String formatoVideo;
	private String relacionAspecto;
	
	public Video (String calidadImagen, String formatoVideo, String relacionAspecto, boolean vendida ,String tituloObra, int año,String lugarCreacion, Artista autor, boolean exhibido, String tematica, int precio) {
		super(vendida, tituloObra, año, lugarCreacion, autor, exhibido, tematica, precio);
		this.calidadImagen = calidadImagen;
		this.formatoVideo = formatoVideo;
		this.relacionAspecto = relacionAspecto;
	}

	public String getCalidadImagen() {
		return calidadImagen;
	}

	public String getFormatoVideo() {
		return formatoVideo;
	}

	public String getRelacionAspecto() {
		return relacionAspecto;
	}
	
	
}
