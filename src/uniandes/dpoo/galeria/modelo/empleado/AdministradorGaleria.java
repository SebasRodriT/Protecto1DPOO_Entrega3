package uniandes.dpoo.galeria.modelo.empleado;

import java.util.ArrayList;
import java.util.HashMap;

import uniandes.dpoo.galeria.modelo.Inventario;
import uniandes.dpoo.galeria.modelo.Pieza;
import uniandes.dpoo.galeria.modelo.plataforma.Plataforma;
import uniandes.dpoo.galeria.modelo.usuario.Comprador;
import uniandes.dpoo.galeria.modelo.usuario.Usuario;

public class AdministradorGaleria extends Empleado {
    private ArrayList<Pieza> inventario = new ArrayList<>();
    private static int limite = 1000000000;
    private Plataforma plataforma = Plataforma.obtenerInstancia();
    private static AdministradorGaleria administrador;
    private Inventario inventarioGaleria;
    
    
    private AdministradorGaleria(String nombre, int identificacion, int edad) {
        super("Administrador", nombre, identificacion, edad);
        this.plataforma = Plataforma.obtenerInstancia();
        this.inventarioGaleria = Inventario.obtenerInstanciaInv();
    }
    
   
    public static synchronized AdministradorGaleria obternerAdmin() {
    	if (administrador == null) {
    		administrador = new AdministradorGaleria("Juan Garcia", 10654218, 38);
    	}
    	return administrador;
    } 

    public String getNombre() {
        return this.nombre;
    }

    public int getIdentificacion() {
        return this.identificacion;
    }

    public int getEdad() {
        return this.edad;
    }

    public void registrarPiezaInventario(Pieza pieza) {
        inventario.add(pieza);
        inventarioGaleria.agregarPiezainventario(pieza);
    }

    public void confirmarVenta(Comprador comprador, Pieza pieza, String fecha) throws Exception {
       
        
    	plataforma.vender(comprador, pieza, fecha);
            pieza.marcarComoVendida(fecha);
            inventario.remove(pieza);
            comprador.agregarPieza(pieza);
            
        
    }

    public void registrarDevolucion(Comprador comprador, Pieza pieza) {
        if (!inventario.contains(pieza)) {
            pieza.marcarComoDevolucion();
            inventario.add(pieza);
            hacerDevolucion(comprador, pieza.getPrecio());
        }
    }

    public void verificarUsuario(Usuario usuario) {
        boolean usuarioActivo = false;
        boolean usuarioAutorizado = false;

        if (usuario.getNombre()!= null || usuario.getIdentificacion()!= 0 || usuario.getPassword()!= null){
             usuarioActivo = true;
             usuarioAutorizado = true;

        }
    
        if (usuarioActivo && usuarioAutorizado) {
        	System.out.println("El usuario " + usuario.getNombre() + " está autorizado.");
        } else {
            
            if (!usuarioActivo) {
                System.out.println("El usuario " + usuario.getNombre() + " está bloqueado.");
            }
            if (!usuarioAutorizado) {
                System.out.println("El usuario " + usuario.getNombre() + " no tiene los permisos necesarios.");
            }
        }
    }
    
    
        public void verificarOfertaCompra(Comprador comprador, Pieza pieza, String fecha) throws Exception {
            int valor = pieza.getPrecio();
            int oferta = comprador.getValorMaxCompras();
           
            if (oferta>=valor) {
                System.out.println("Oferta aceptada para la pieza: " + pieza.getTituloObra() + " por el comprador: " + comprador.getNombre());
                confirmarVenta(comprador, pieza, fecha);
            } else {
                System.out.println("Oferta rechazada o inválida para la pieza: " + pieza.getTituloObra() + " por el comprador: " + comprador.getNombre());
            }
        }

    public void establecerLimiteCompras(Comprador comprador) {
        
            comprador.establecerLimiteCompras(limite);
    }

    public int modificarLimiteCompras(Comprador comprador) {
        
            if (comprador.getSaldo() > comprador.getValorMaxCompras()) {
            	return comprador.getSaldo();
            }
			return comprador.getValorMaxCompras();
        
    }
    
    public void hacerDevolucion(Comprador comprador, int valor) {
    	comprador.actualizarSaldoDevolucion(valor);
    }
    
    //Requerimiento 3: Proyecto 2
    // Verificar Historia Comprador: Historia de piezas que ha comprado
    public void historiaPiezasCompradas(String nombre) {
    	Comprador comprador = plataforma.encontrarComprador(nombre);
    	ArrayList<Pieza> piezas = comprador.getPiezasCompradas();
    	System.out.println("Nombre: " + comprador.getNombre());
    	System.out.println("Nombre Usuario: " + comprador.getNombreUsuario());
    	for (int i = 0; i < piezas.size(); i++) {
            String elemento = piezas.get(i).getTituloObra();
            System.out.println("Titulo Obra:" + elemento);
        }
    }
    
    //Verificar historia de coleeccion: Historia de piezas que posee
    public void historiaPiezasColeccion(String nombre) {
    	Comprador comprador = plataforma.encontrarComprador(nombre);
    	ArrayList<Pieza> piezas = comprador.getPiezasCompradas();
    	System.out.println("Nombre: " + comprador.getNombre());
    	System.out.println("Nombre Usuario: " + comprador.getNombreUsuario());
    	for (int i = 0; i < piezas.size(); i++) {
            String elemento = piezas.get(i).getTituloObra();
            System.out.println("Titulo Obra:" + elemento);
            System.out.println("Fecha de venta: "+ piezas.get(i).getFecha());
        }
    }
    
    public Pieza ConsultarPieza(String nombre) {
    	return inventarioGaleria.buscarPieza(nombre);
    }
    
    public ArrayList<Pieza> consultarHistoriaArtista(String nombre){
    	return inventarioGaleria.historiaArtista(nombre);
    }
    
    public boolean confirmarVenta(String nombre) {
    	Pieza p = ConsultarPieza(nombre);
    	return p.isVendida();
    	
    }
    
    public ArrayList<Pieza> getInventario() {
		return inventario;
	}


	public boolean confirmarDevolucion(String nombre) {
    	Pieza p = ConsultarPieza(nombre);
    	return p.isDevuelta();
    	
    }
}

