package uniandes.dpoo.galeria.modelo.usuario;



import java.util.ArrayList;
import java.util.HashMap;

import uniandes.dpoo.galeria.modelo.Inventario;
import uniandes.dpoo.galeria.modelo.Pieza;
import uniandes.dpoo.galeria.modelo.empleado.AdministradorGaleria;
import uniandes.dpoo.galeria.modelo.empleado.OperadorGaleria;
import uniandes.dpoo.galeria.modelo.plataforma.Plataforma;


public class Comprador extends Usuario {
    private String numeroTelefono;
    private String correo;
    private int valorMaxCompras;
    private ArrayList<Pieza> piezasCompradas;
    private HashMap<Pieza, String> listapieza;
    private ArrayList<Pieza> coleccion;
    private int saldo;
    private Plataforma plataforma;
    private AdministradorGaleria admin;
    private OperadorGaleria operador;
    private Inventario inventarioGaleria;
    
    public Comprador(String nombre, int identificacion, int edad, String nombreUsuario, String password,
                     String numeroTelefono, String correo, int saldo) {
        super(nombre, identificacion, edad, nombreUsuario, password, "Comprador");
        this.numeroTelefono = numeroTelefono;
        this.correo = correo;
        this.piezasCompradas = new ArrayList<>();
        this.saldo = saldo;
        plataforma = Plataforma.obtenerInstancia();
        plataforma.registrarUsuario(this);
        admin = AdministradorGaleria.obternerAdmin();
        admin.establecerLimiteCompras(this);
        operador = OperadorGaleria.instanciaOperador();
        this.inventarioGaleria = Inventario.obtenerInstanciaInv();   
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public String getCorreo() {
        return correo;
    }

    public int getValorMaxCompras() {
        return valorMaxCompras;
    }
    
    public void establecerLimiteCompras(Integer limite){
        this.valorMaxCompras = limite;
        
    }
    public HashMap<Pieza,String>getlistapieza(){
        return listapieza;
    }

    
     
    public ArrayList<Pieza> getPiezasCompradas() {
		return piezasCompradas;
	}
     
    
	public ArrayList<Pieza> getColeccion() {
		return coleccion;
	}

	public HashMap<Pieza, String> getListapieza() {
		return listapieza;
	}

	public int getSaldo() {
		return saldo;
	}

	public void actualizarSaldo(int valor) {
     	saldo-= valor;
     	valorMaxCompras -= valor;
     }
	
	public void actualizarSaldoDevolucion(int valor) {
     	saldo+= valor;
     	valorMaxCompras += valor;
     }

    
    
    public void agregarPieza(Pieza pieza) {
    	String nombre = pieza.getTituloObra();
    	Integer valor = (Integer)pieza.getPrecio();
    	piezasCompradas.add(pieza);
    	valorMaxCompras -= pieza.getPrecio();
    }
    
    public void agregarPiezaColeccion(Pieza pieza) {
    	String nombre = pieza.getTituloObra();
    	Integer valor = (Integer)pieza.getPrecio();
    	coleccion.add(pieza);
    }
    
    public void hacerOfertaVenta(Pieza pieza, String fecha) throws Exception {
    	admin.verificarOfertaCompra(this, pieza, fecha);
    }
    
    public void hacerOfertaSubasta(Pieza pieza, int valor, String fecha) throws Exception {
    	operador.registrarOfertasSubasta(this, pieza, valor, fecha);
    }
    	
    	
    public void solicitarAumentoLimite() {
    	this.valorMaxCompras = admin.modificarLimiteCompras(this);
    }
    
    public void solicitarDevolucion(Pieza pieza) {
    	if (this.piezasCompradas.contains(pieza)) {
    		admin.registrarDevolucion(this, pieza);
    		this.piezasCompradas.remove(pieza);
    	}
    }
    
    public Pieza ConsultarPieza(String nombre) {
    	return inventarioGaleria.buscarPieza(nombre);
    }

    }

