package testModelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import uniandes.dpoo.galeria.modelo.Artista;
import uniandes.dpoo.galeria.modelo.Escultura;

public class testEscultura {
	private Artista mAG = new Artista("Miguel Ángel", "Escultor");
	private Escultura dAV = new Escultura(5.17, 3.24, 5660, false, false, "David", 1501, "Italia", mAG, false, "personaje Bíblico", 20768900);
	
	@Test
	public void testmarcarVerdaderaElectricidad() throws Exception {
		 dAV.marcarVerdaderaElectricidad();
		 assertTrue(dAV.isNecesitaElectricidad());
	}
	
	@Test
	public void testAgregarMaterialDeConstruccion() throws Exception {
		String material = "Ladrillo";
		dAV.agregarMaterialDeConstruccion("Cemento");
		dAV.agregarMaterialDeConstruccion("Madera");
		dAV.agregarMaterialDeConstruccion(material);
		ArrayList<String> materialesEsperados = new ArrayList<>();
		materialesEsperados.add("Cemento");
		materialesEsperados.add("Madera");
		materialesEsperados.add(material);

		assertEquals(materialesEsperados, dAV.getMaterialesDeConstruccion());
	}
	
	@Test
	public void testAgregarElementoInstalacion() throws Exception {
		String material = "Andamios"; 
		dAV.agregarElementoInstalacion("Cuerdas");
		dAV.agregarElementoInstalacion("Plataformas");
		dAV.agregarElementoInstalacion(material);
		ArrayList<String> materialesEsperados = new ArrayList<>();
		materialesEsperados.add("Cuerdas");
		materialesEsperados.add("Plataformas");
		materialesEsperados.add(material);
		
		assertEquals(materialesEsperados, dAV.getElementosDeInstalacion());
	}
}
