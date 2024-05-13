package testPlataforma;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.galeria.modelo.Artista;
import uniandes.dpoo.galeria.modelo.Pintura;
import uniandes.dpoo.galeria.modelo.empleado.CajeroGaleria;
import uniandes.dpoo.galeria.modelo.empleado.OperadorGaleria;
import uniandes.dpoo.galeria.modelo.usuario.Comprador;
import uniandes.dpoo.galeria.modelo.usuario.Usuario;


public class testSubasta {

	private Artista vG = new Artista("Vincent van Gogh", "Pintor");
	private OperadorGaleria operador = OperadorGaleria.instanciaOperador();
	private Pintura lNE = new Pintura("óleo sobre lienzo","impresionismo", 73.7, 92.1, false, "La Noche Estrellada", 1889, "Saint Rémy de Provence",vG, true, "Paisaje", 800000000);
	private Comprador comprador1 = new Comprador("Felipe Gonzales", 11579875, 28, "f.gon", "F123G", "3124257895", "g.gon@gmail.com", 900000000);
	private Comprador comprador2 = new Comprador("Ana María", 32548901, 34, "a.maria", "AM34A", "3156781234", "ana.maria@gmail.com",1000000000);
	private Comprador comprador3 = new Comprador("Carlos Rodríguez", 10234876, 45, "c.rod", "CR45R", "3175498765", "carlos.rod@gmail.com", 1500000000);
	private Comprador comprador4 = new Comprador("Lucía Hernández", 48576234, 29, "l.hernan", "LH29H", "3109876543", "lucia.hernan@gmail.com", 2000000000);
	private Comprador comprador5 = new Comprador("Juan Pérez", 29713485, 38, "j.perez", "JP38P", "3123475689", "juan.perez@gmail.com", 2100000000);
	
	
	@Test 
	public void testPiezaASubastar() throws Exception {
		operador.iniciarSubasta(lNE);
		operador.registrarOfertasSubasta(comprador1, lNE, 800000000, "06/05/2024");
		operador.registrarOfertasSubasta(comprador2, lNE, 900000000, "06/05/2024");
		operador.registrarOfertasSubasta(comprador3, lNE, 1000000000, "06/05/2024");
		operador.registrarOfertasSubasta(comprador4, lNE, 1100000000, "06/05/2024");
		operador.registrarOfertasSubasta(comprador5, lNE, 2000000000, "06/05/2024");
		assertEquals(comprador5.getNombre(), operador.identificarPostorGanador(lNE, "06/05/2024").getNombre());
		operador.finalizarSubasta(lNE);

}
	
	@Test 
	public void testPiezaASubastarFalla() throws Exception {
		operador.iniciarSubasta(lNE);
		operador.registrarOfertasSubasta(comprador1, lNE, 800000000, "06/05/2024");
		operador.registrarOfertasSubasta(comprador2, lNE, 900000000, "06/05/2024");
		Exception exception = assertThrows(Exception.class, () -> {operador.identificarPostorGanador(lNE, "06/05/2024");});
}}


