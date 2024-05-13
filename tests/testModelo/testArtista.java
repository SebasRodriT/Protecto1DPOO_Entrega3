package testModelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import uniandes.dpoo.galeria.modelo.Artista;
import uniandes.dpoo.galeria.modelo.Dibujo;

public class testArtista {
	private Artista lDV = new Artista("Leonardo da Vinci", "Pintor");
	private Dibujo eHV = new Dibujo("Papel", "Tinta y plumilla", "Humanismo", "34.4 cm x 24.5 cm ", false, "El hombre de Vitruvio", 1490, "Italia", lDV,  true, "Anatomia",158990890);
	
//prueba
	@Test
	public void testAgregarPieza() throws Exception {
		assertTrue(lDV.getPiezas().isEmpty());
		lDV.agregarPieza(eHV);
		assertEquals(1, lDV.getPiezas().size());
	}
}
