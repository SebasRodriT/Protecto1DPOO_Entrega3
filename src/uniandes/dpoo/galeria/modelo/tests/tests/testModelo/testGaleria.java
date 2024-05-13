package testModelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;

import uniandes.dpoo.galeria.modelo.Artista;
import uniandes.dpoo.galeria.modelo.Galeria;
import uniandes.dpoo.galeria.modelo.Pieza;
import uniandes.dpoo.galeria.modelo.usuario.Comprador;
import uniandes.dpoo.galeria.modelo.usuario.Usuario;

public class testGaleria {
	private Usuario user1 = new Usuario("Maria Ariza", 17657934, 25, "mari34", "MariAri3400", "Comprador");
	private Usuario user2 = new Usuario("Juan Pérez", 67856453, 35, "jupe45", "Juanpe2005", "Propietario");
	private Usuario user3 = new Usuario("Pedro Arias", 45638567, 29, "Juanpe01", "Pear2024*", "Comprador");
	private Comprador compradorExistente = new Comprador("Maria Ariza", 17657934, 25, "mari34", "MariAri3400", "300567895", "mari34@domain.com", 20000000);
    //private Comprador compradorNoExistente = new Comprador("Martin Arias", 17657934, 25, "mari34", "MariAri3400", "300567895", "mari34@domain.com", 20000000);
    private Comprador compradorNoExistente = new Comprador(null, 0, 0, null, null, null, null, 0);
    Artista artista = new Artista("Leonardo Da Vinci", "Pintor");
    Pieza piezaExhibida = new Pieza(false, "La Mona Lisa", 1503, "Italia", artista,true, "Humanismo", 19890786);
    Pieza piezaEnBodega = new Pieza(false, "El Hombre de Vitruvio", 1490, "Italia", artista,true, "Humanismo", 17890786);
    Pieza piezaEnHistorico = new Pieza(false,"La Última Cena", 1495, "Italia", artista, true, "Religión", 15789000);
    Galeria galeria = new Galeria("Italia", 130);
    
	@Test
	public void testVerificarCompradorExistente() {
		
		boolean encontrado = galeria.verificarComprador(compradorExistente);
        assertTrue(encontrado, "El comprador existente debería haber sido encontrado"); 
	}
	
	@Test
	void testCompradorNoExistente() {
        
        boolean resultado = galeria.verificarComprador(compradorNoExistente);
        assertFalse(resultado, "El comprador no existente no debería haber sido encontrado");
    }
	
	@Test
	public void testAgregarPiezaBodega() {
        Galeria galeria = new Galeria("Italia", 120);

        galeria.agregarPiezaBodega(piezaEnBodega);

        assertTrue(galeria.getPiezasBodega().contains(piezaEnBodega), "La pieza debería estar en la lista de piezas exhibidas");
    }
	
	@Test
	public void testAgregarPiezaHistorico() {
        Galeria galeria = new Galeria("Francia", 120);

        galeria.agregarPiezaHistorico(piezaEnHistorico);

        assertTrue(galeria.getHistoricoPiezas().contains(piezaEnHistorico), "La pieza debería estar en la lista de piezas exhibidas");
    }
	
	@Test
	public void testAgregarPiezaExhibida() {
        Galeria galeria = new Galeria("España", 120);

        galeria.agregarPiezaExhibida(piezaExhibida);

        assertTrue(galeria.getPiezasExhibidas().contains(piezaExhibida), "La pieza debería estar en la lista de piezas exhibidas");
    }
   
	@Test
    void testEliminarPiezaExhibida() {
        Galeria galeria = new Galeria("Italia", 100);

        galeria.agregarPiezaExhibida(piezaExhibida);
        assertTrue(galeria.getPiezasExhibidas().contains(piezaExhibida), "La pieza debería estar en la lista de piezas exhibidas");
        
        galeria.eliminarPiezaExhibida(piezaExhibida);
        assertFalse(galeria.getPiezasExhibidas().contains(piezaExhibida), "La pieza no debería estar en la lista de piezas exhibidas");
    }

    @Test
    void testEliminarPiezaBodega() {
        Galeria galeria = new Galeria("Italia", 100);

        galeria.agregarPiezaBodega(piezaEnBodega);
        assertTrue(galeria.getPiezasBodega().contains(piezaEnBodega), "La pieza debería estar en la lista de piezas en bodega");

        galeria.eliminarPiezaBodega(piezaEnBodega);
        assertFalse(galeria.getPiezasBodega().contains(piezaEnBodega), "La pieza no debería estar en la lista de piezas en bodega");
    }
    
    @SuppressWarnings("static-access")
	@Test
    public void testBuscarPiezaExhibida() {
    	Galeria galeria = new Galeria("Italia", 100);
    	galeria.agregarPiezaExhibida(piezaExhibida);
    	Pieza piezaEncontrada = galeria.buscarPiezaExhibida(piezaExhibida);
    	assertNotNull(piezaEncontrada, "La pieza debería haber sido encontrada");
        assertEquals(piezaExhibida.getTituloObra(), piezaEncontrada.getTituloObra(), "El título de la obra debe coincidir");

    }
    
    @SuppressWarnings("static-access")
	@Test
    public void testBuscarPiezaBodega() {
    	Galeria galeria = new Galeria("España", 100);
    	galeria.agregarPiezaBodega(piezaEnBodega);
    	Pieza piezaEncontrada = galeria.buscarPiezaBodega(piezaEnBodega);
    	assertNotNull(piezaEncontrada, "La pieza debería haber sido encontrada");
        assertEquals(piezaEnBodega.getTituloObra(), piezaEncontrada.getTituloObra(), "El título de la obra debe coincidir");

    }
    
    @SuppressWarnings("static-access")
	@Test
    public void testBuscarPiezaHistorico() {
    	Galeria galeria = new Galeria("Francia", 110);
    	galeria.agregarPiezaHistorico(piezaEnHistorico);
    	Pieza piezaEncontrada = galeria.buscarPiezahistorico(piezaEnHistorico);
    	assertNotNull(piezaEncontrada, "La pieza debería haber sido encontrada");
    	assertEquals(piezaEnHistorico.getTituloObra(), piezaEncontrada.getTituloObra(), "El título de la obra debe coincidir");
    }
    
    @Test
    public void testBuscarPiezaExhibidaNoExistente() {
        Pieza piezaNoEncontrada = Galeria.buscarPiezaExhibida(new Pieza(false,"La Noche Estrellada", 1889, "Países Bajos", new Artista("Vincent Van Gogh", "Pintor"), false, "Impresionismo",  15689586 ));
        assertNull(piezaNoEncontrada); 
    }



    @Test
    public void testBuscarPiezaBodegaNoExistente() {
        // Act
        Pieza piezaNoEncontrada = Galeria.buscarPiezaBodega(new Pieza(false,"La Noche Estrellada", 1889, "Países Bajos", new Artista("Vincent Van Gogh", "Pintor"), false, "Impresionismo",  15689586 ));

        // Assert
        assertNull(piezaNoEncontrada); 
    }

    

    @Test
    public void testBuscarPiezaHistoricoNoExistente() {
        Pieza piezaNoEncontrada = Galeria.buscarPiezahistorico(new Pieza(false,"La Noche Estrellada", 1889, "Países Bajos", new Artista("Vincent Van Gogh", "Pintor"), false, "Impresionismo",  15689586 ));
        assertNull(piezaNoEncontrada); 
    }
}
