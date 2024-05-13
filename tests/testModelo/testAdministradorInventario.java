package testModelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import uniandes.dpoo.galeria.modelo.Artista;
import uniandes.dpoo.galeria.modelo.Inventario;
import uniandes.dpoo.galeria.modelo.Pieza;
import uniandes.dpoo.galeria.modelo.empleado.AdministradorInventario;

public class testAdministradorInventario {
	Artista artista = new Artista("Leonardo Da Vinci", "Pintor");
	Pieza pieza = new Pieza(false, "La Mona Lisa", 1503, "Italia", artista,true, "Humanismo", 19890786);
	AdministradorInventario adminInventario = new AdministradorInventario("Armando Reyes", 1054685947, 30);
	Inventario inv = Inventario.obtenerInstanciaInv();
	
	
	@SuppressWarnings("static-access")
	@Test
	public void testBuscarPiezaInventario() {
		inv.agregarPiezainventario(pieza);
		Pieza piezaEncontrada = adminInventario.buscarPiezaInventario(pieza);
		assertEquals(pieza.getTituloObra(), piezaEncontrada.getTituloObra(), "El título de la obra debe coincidir");
	}
	
	public void testBuscarPiezaPorString() {
		
	}
	
	@SuppressWarnings("static-access")
	@Test
    public void testBuscarPiezaInventarioNoExistente() {
        Pieza piezaNoEncontrada = adminInventario.buscarPiezaInventario(new Pieza(false,"La Noche Estrellada", 1889, "Países Bajos", new Artista("Vincent Van Gogh", "Pintor"), false, "Impresionismo",  15689586 ));
        assertNull(piezaNoEncontrada); 
    }
}
