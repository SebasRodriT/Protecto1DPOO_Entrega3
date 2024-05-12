package uniandes.dpoo.galeria.modelo.empleado;

import java.util.HashMap;

import uniandes.dpoo.galeria.modelo.Inventario;
import uniandes.dpoo.galeria.modelo.Pieza;
import uniandes.dpoo.galeria.modelo.plataforma.Plataforma;
import uniandes.dpoo.galeria.modelo.plataforma.RegistroSubasta;
import uniandes.dpoo.galeria.modelo.usuario.Comprador;
import uniandes.dpoo.galeria.modelo.usuario.Usuario;

import java.util.ArrayList;

public class OperadorGaleria extends Empleado {

	private static OperadorGaleria operador;
    private HashMap<Pieza, ArrayList<Usuario>> participantesPorSubasta;
    private HashMap<Pieza, HashMap<Usuario, Integer>> ofertasPorSubasta;
    private RegistroSubasta subasta;
    private Plataforma plataforma;
    private Inventario inventarioGaleria;

    private OperadorGaleria(String nombre, int identificacion, int edad) {
        super("Operador", nombre, identificacion, edad);
 
        participantesPorSubasta = new HashMap<>();
        ofertasPorSubasta = new HashMap<>();
        plataforma = Plataforma.obtenerInstancia();
        subasta = RegistroSubasta.registro();
        this.inventarioGaleria = Inventario.obtenerInstanciaInv();
    }
    
    public static synchronized OperadorGaleria instanciaOperador() {
    	
    	if (operador == null) {
    		operador = new OperadorGaleria("Andres Gonzales", 13679852, 32);
    	}
    	return operador;
    }

    public void iniciarSubasta(Pieza pieza) {
    	subasta.agregarPiezaASubastar(pieza);
        participantesPorSubasta.put(pieza, new ArrayList<>());
        ofertasPorSubasta.put(pieza, new HashMap<>());
    }

    public void registrarParticipantesSubasta(Usuario usuario, Pieza pieza) {
        ArrayList<Usuario> participantes = participantesPorSubasta.getOrDefault(pieza, new ArrayList<>());
        if (!participantes.contains(usuario)) {
            participantes.add(usuario);
        }
        participantesPorSubasta.put(pieza, participantes);
    }

    public void registrarOfertasSubasta(Usuario usuario, Pieza pieza, int oferta, String fecha) {
    	if (aceptarOfertasSubasta(pieza, usuario)) {
    	registrarParticipantesSubasta(usuario, pieza);
    	subasta.agregarOfertaSubasta(usuario, oferta, pieza);
        HashMap<Usuario, Integer> ofertas = ofertasPorSubasta.getOrDefault(pieza, new HashMap<>());
        ofertas.put(usuario, oferta);
        ofertasPorSubasta.put(pieza, ofertas);}
    }

    public boolean aceptarOfertasSubasta(Pieza pieza, Usuario usuario) {
      
    	Comprador comprador = (Comprador) usuario;
    	if (comprador.getSaldo()-pieza.getPrecio() >= 0) {
    		return true;
    	}
    	return false;
        }
    

    public Usuario identificarPostorGanador(Pieza pieza, String fecha) throws Exception {
        
            return plataforma.subastar(pieza, fecha);
    }

    public void finalizarSubasta(Pieza pieza) {
        if (subasta != null) {
            subasta.finalizar(pieza);
 
        }
    }

    public Pieza ConsultarPieza(String nombre) {
    	return inventarioGaleria.buscarPieza(nombre);
    }
    
    public ArrayList<Pieza> consultarHistoriaArtista(String nombre){
    	return inventarioGaleria.historiaArtista(nombre);
    }
   
}
