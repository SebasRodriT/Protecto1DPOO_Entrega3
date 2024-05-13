package testModelo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import uniandes.dpoo.galeria.modelo.Artista;
import uniandes.dpoo.galeria.modelo.Inventario;
import uniandes.dpoo.galeria.modelo.Pieza;
import uniandes.dpoo.galeria.modelo.empleado.AdministradorInventario;

public class testInventario {
	Artista artista = new Artista("Leonardo Da Vinci", "Pintor");
	Pieza pieza = new Pieza(false, "La Mona Lisa", 1503, "Italia", artista,true, "Humanismo", 19890786);
	AdministradorInventario adminInventario = new AdministradorInventario("Armando Reyes", 1054685947, 30);
	Inventario inv = new Inventario();
	
	@Test
	public void testAgregarPiezainventario(){
		inv.agregarPiezainventario(pieza);
		assertTrue(inv.getInventarioPiezas().contains(pieza), "La pieza debería estar en la lista de inventario de piezas");
	}
	
	@Test
	public void testEliminarPiezaInventario() {
		inv.agregarPiezainventario(pieza);
		assertTrue(inv.getInventarioPiezas().contains(pieza), "La pieza debería estar en la lista de inventario de piezas");
		
		inv.eliminarPiezainventario(pieza);
		assertFalse(inv.getInventarioPiezas().contains(pieza), "La pieza no debería estar en la lista de inventario de piezas");
	}
}
