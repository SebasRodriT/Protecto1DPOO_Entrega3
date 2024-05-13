package testPlataforma;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import uniandes.dpoo.galeria.modelo.Artista;
import uniandes.dpoo.galeria.modelo.Escultura;
import uniandes.dpoo.galeria.modelo.Pieza;
import uniandes.dpoo.galeria.modelo.empleado.AdministradorGaleria;
import uniandes.dpoo.galeria.modelo.usuario.Comprador;


public class testVenta {
	
	private Artista mA = new Artista("Miguel Angel", "escultor");
	private Escultura d = new Escultura(517, 198, 5660, false, false, "David", 1504, "Florencia", mA, true, "biblica", 1500000000);
	private Comprador comprador1 = new Comprador("Felipe Martinez", 11576575, 28, "f.mar", "F123G", "3124256795", "f.mar@gmail.com", 900000000);
	private Comprador comprador2 = new Comprador("Ana María Perez", 32546801, 34, "a.mariap", "AM34A", "3156781234", "ana.mariap@gmail.com",1000000000);
	private Comprador comprador3 = new Comprador("Juan Rodríguez", 10694876, 45, "j.rod", "CR45R", "3175498765", "juan.rod@gmail.com", 1500000000);
	private Comprador comprador4 = new Comprador("Lucía Fernández", 48577534, 29, "l.fernan", "LH29H", "3109876543", "lucia.fernan@gmail.com", 2000000000);
	private Comprador comprador5 = new Comprador("Mario Pérez", 29683485, 38, "m.perez", "JP38P", "3123475689", "m.perez@gmail.com", 2100000000);
	private AdministradorGaleria admin = AdministradorGaleria.obternerAdmin();
	
	@Test
	public void venderPiezaFallo() throws Exception {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PrintStream originalOut = System.out;
		System.setOut(new PrintStream(outputStream));
		
		admin.registrarPiezaInventario(d);
		admin.verificarUsuario(comprador1);
		comprador1.hacerOfertaVenta(d, "08/05/2024");
		String[] outputs = outputStream.toString().split(System.lineSeparator());
		assertEquals("Oferta rechazada o inválida para la pieza: David por el comprador: Felipe Martinez", outputs[1].trim());
		
	}
		@Test
		public void venderPiezaExito() throws Exception {
			
			admin.registrarPiezaInventario(d);
			admin.verificarUsuario(comprador5);
			comprador5.solicitarAumentoLimite();
			comprador5.hacerOfertaVenta(d, "08/05/2024");
			assertEquals(1, comprador5.getPiezasCompradas().size());
			assertEquals(true, d.isVendida());
		}
		
		
		@Test
		public void casoDevolucion() throws Exception {
			admin.registrarPiezaInventario(d);
			admin.verificarUsuario(comprador5);
			comprador5.solicitarAumentoLimite();
			comprador5.hacerOfertaVenta(d, "08/05/2024");
			comprador5.solicitarDevolucion(d);
			assertEquals(0, comprador5.getPiezasCompradas().size());
			assertEquals(false, d.isVendida());
		}
	
	
	
		@Test
		public void concultarhistoriaPieza() {
			admin.registrarPiezaInventario(d);
			assertEquals(d, admin.ConsultarPieza("David"));
			
		}

		@Test
		public void concultarhistoriaArtista() {
			ArrayList<Pieza> prueba = new ArrayList<Pieza>();
			prueba.add(d);
			assertEquals(prueba, admin.consultarHistoriaArtista("Miguel Angel"));
			
			
		}

}
