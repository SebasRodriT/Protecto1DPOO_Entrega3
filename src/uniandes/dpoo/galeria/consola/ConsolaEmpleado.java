package uniandes.dpoo.galeria.consola;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import uniandes.dpoo.galeria.modelo.Pieza;
import uniandes.dpoo.galeria.modelo.Artista;
import uniandes.dpoo.galeria.modelo.Galeria;
import uniandes.dpoo.galeria.modelo.plataforma.RegistroVenta;
import uniandes.dpoo.galeria.modelo.usuario.Usuario;
import uniandes.dpoo.galeria.modelo.plataforma.RegistroSubasta;
import uniandes.dpoo.galeria.modelo.plataforma.Plataforma;
import uniandes.dpoo.galeria.modelo.empleado.Empleado;
import uniandes.dpoo.galeria.modelo.empleado.CajeroGaleria;


public class ConsolaEmpleado {
    
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, ingresa los detalles de la galería:");

        System.out.print("Ubicación: ");
        String ubicacion = scanner.nextLine();

        System.out.print("Cantidad de Piezas: ");
        int cantidadPiezas = scanner.nextInt();
        
        if (!verificarExistencia(ubicacion, cantidadPiezas)) {
            agregarGaleriaATxt(ubicacion, cantidadPiezas);
        }
        
        Galeria galeria = new Galeria(ubicacion, cantidadPiezas);
        
        int opcionRol;
        while (true) {
            System.out.println("Por favor, seleccione el rol que desea desempeñar: ");
            System.out.println("1. Cajero");
            System.out.println("2. Operador");
            System.out.println("3. Administrador de inventario");
            System.out.println("0. Salir del programa");
            System.out.print("Ingrese su opción: ");
            opcionRol = scanner.nextInt();
            scanner.nextLine();

            switch (opcionRol) {
                case 1:
                    menuCajero(scanner, galeria);
                    break;
                case 2:
                    menuOperador(scanner, galeria);
                    break;
                case 3:
                    menuAdminInventario(scanner, galeria);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }
    
    private static boolean verificarExistencia(String ubicacion, int cantidadPiezas) throws IOException {
        File archivo = new File("data/galerias.txt");
        if (!archivo.exists()) {
            archivo.getParentFile().mkdirs();
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Scanner scanner = new Scanner(archivo);

        while (scanner.hasNextLine()) {
            String[] partes = scanner.nextLine().split(",");
            if (partes[0].equals(ubicacion) && Integer.parseInt(partes[1]) == cantidadPiezas) {
                scanner.close();
                return true;
            }
        }
        scanner.close();
        return false;
    }
    
    private static void agregarGaleriaATxt(String ubicacion, int cantidadPiezas) throws IOException {
        FileWriter writer = new FileWriter("galerias.txt", true);
        writer.write(ubicacion + "," + cantidadPiezas + "\n");
        writer.close();
        System.out.println("Se ha agregado correctamente la galería al archivo.");
    }
    
    private static void menuCajero(Scanner scanner, Galeria galeria) {
        int opcionCajero;
        while (true) {   
            System.out.println("¡Bienvenido al menú del Cajero!");
            System.out.println("1. Obtener registro de pagos");
            System.out.println("2. Buscar pieza en bodega");
            System.out.println("3. Buscar pieza en histórico");
            System.out.println("4. Buscar pieza exhibida");
            System.out.println("0. Salir del programa");
            System.out.print("Ingrese su opción: ");
            opcionCajero = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcionCajero) {
                case 1:
                    obtenerRegistroPagos();
                    break;
            	case 2:
            		buscarPiezaBodega(scanner, galeria);
            		break;
            	case 3:
            		buscarPiezaHistorico(scanner, galeria);
            		break;
            	case 4:
            		buscarPiezaExhibida(scanner, galeria);
            		break;
            	case 0:
            		System.out.println("Saliendo del programa...");
            		scanner.close();
            		return;
            	default:
            		System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            		break;
            }
            System.out.println();
        }
    }
    
    private static void menuOperador(Scanner scanner, Galeria galeria) {
        int opcionOperador;
        while (true) {
            System.out.println("¡Bienvenido al menú del Operador!");
            System.out.println("1. Buscar pieza en bodega");
            System.out.println("2. Buscar pieza en histórico");
            System.out.println("3. Buscar pieza exhibida");
            System.out.println("0. Salir del programa");
            System.out.print("Ingrese su opción: ");
            opcionOperador = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcionOperador) {
            	case 1:
            		buscarPiezaBodega(scanner, galeria);
            		break;
            	case 2:
            		buscarPiezaHistorico(scanner, galeria);
            		break;
            	case 3:
            		buscarPiezaExhibida(scanner, galeria);
            		break;
            	case 0:
            		System.out.println("Saliendo del programa...");
            		scanner.close();
            		return;
            	default:
            		System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            		break;
            }
            
        }
    }
    
    private static void menuAdminInventario(Scanner scanner, Galeria galeria) {
        int opcionAdmin;
        while (true) {
            System.out.println("¡Bienvenido al menú del Administrador de Inventario!");
            System.out.println("1. Buscar pieza en bodega");
            System.out.println("2. Buscar pieza en histórico");
            System.out.println("3. Buscar pieza exhibida");
            System.out.println("4. Agregar pieza bodega");
            System.out.println("5. Agregar pieza histórico");
            System.out.println("6. Agregar pieza exhibida");
            System.out.println("0. Salir del programa");
            System.out.print("Ingrese su opción: ");
            opcionAdmin = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcionAdmin) {
                case 1:
                    buscarPiezaBodega(scanner, galeria);
                    break;
                case 2:
                	buscarPiezaHistorico(scanner, galeria);
                	break;
                case 3:
                	buscarPiezaExhibida(scanner, galeria);
                	break;
                case 4:
                	agregarPiezaBodega(scanner, galeria);
                	break;
                case 5:
                	agregarPiezaHistorico(scanner, galeria);
                	break;
                case 6:
                	agregarPiezaExhibida(scanner, galeria);
                	break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
            System.out.println();
        }
    }

    // Implementa los métodos de acuerdo a los requerimientos del Empleado

    private static void buscarPiezaExhibida(Scanner scanner, Galeria galeria) {
    	System.out.print("Por favor, ingresa el nombre de la pieza a consultar: ");
    	String nombrePieza = scanner.nextLine();

    	boolean piezaEncontrada = false;
    	for (Pieza pieza : galeria.getPiezasExhibidas()) {
    		if (pieza.getTituloObra().equals(nombrePieza)) {
    			piezaEncontrada = true;
    			System.out.println("Pieza encontrada: " + pieza.getTituloObra());
    			System.out.println("Autor: " + pieza.getAutor().getNombre());
    			System.out.println("Año: " + pieza.getAño());
    			break;
    		}
    	}

    	if (!piezaEncontrada) {
    		System.out.println("La pieza no se encuentra en el inventario.");
    	}
    }


    private static void buscarPiezaHistorico(Scanner scanner, Galeria galeria) {
    	System.out.print("Por favor, ingresa el nombre de la pieza a consultar: ");
    	String nombrePieza = scanner.nextLine();

    	boolean piezaEncontrada = false;
    	for (Pieza pieza : galeria.getHistoricoPiezas()) {
    		if (pieza.getTituloObra().equals(nombrePieza)) {
    			piezaEncontrada = true;
    			System.out.println("Pieza encontrada: " + pieza.getTituloObra());
    			System.out.println("Autor: " + pieza.getAutor().getNombre());
    			System.out.println("Año: " + pieza.getAño());
    			break;
    		}
    	}

    	if (!piezaEncontrada) {
    		System.out.println("La pieza no se encuentra en el inventario.");
    	}
    }

    private static void buscarPiezaBodega(Scanner scanner, Galeria galeria) {
    	System.out.print("Por favor, ingresa el nombre de la pieza a consultar: ");
    	String nombrePieza = scanner.nextLine();

    	boolean piezaEncontrada = false;
    	for (Pieza pieza : galeria.getPiezasBodega()) {
    		if (pieza.getTituloObra().equals(nombrePieza)) {
    			piezaEncontrada = true;
    			System.out.println("Pieza encontrada: " + pieza.getTituloObra());
    			System.out.println("Autor: " + pieza.getAutor().getNombre());
    			System.out.println("Año: " + pieza.getAño());
    			break;
    		}
    	}

    	if (!piezaEncontrada) {
    		System.out.println("La pieza no se encuentra en el inventario.");
    	}
    }

    private static void agregarPiezaExhibida(Scanner scanner, Galeria galeria) {
    	System.out.println("Por favor, ingresa los detalles de la pieza a agregar:");

    	System.out.print("Nombre de la pieza: ");
    	String nombrePieza = scanner.nextLine();

    	System.out.print("Año de creación: ");
    	int año = scanner.nextInt();
    	scanner.nextLine();

    	System.out.print("Lugar de creación: ");
    	String lugarCreacion = scanner.nextLine();

    	System.out.print("Nombre del autor: ");
    	String nombreAutor = scanner.nextLine();

    	System.out.print("Nacionalidad del autor: ");
    	String nacionalidadAutor = scanner.nextLine();

    	Artista autor = new Artista(nombreAutor, nacionalidadAutor);

    	System.out.print("Tematica: ");
    	String tematica = scanner.nextLine();

    	System.out.print("Precio: ");
    	int precio = scanner.nextInt();
    	scanner.nextLine();

    	Pieza nuevaPieza = new Pieza(false, nombrePieza, año, lugarCreacion, autor, true, tematica, precio);
    	galeria.agregarPiezaExhibida(nuevaPieza);
    	System.out.println("Pieza agregada con éxito a la lista de piezas exhibidas.");
    }



    private static void agregarPiezaBodega(Scanner scanner, Galeria galeria) {
    	System.out.println("Por favor, ingresa los detalles de la pieza a agregar:");

    	System.out.print("Nombre de la pieza: ");
    	String nombrePieza = scanner.nextLine();

    	System.out.print("Año de creación: ");
    	int año = scanner.nextInt();
    	scanner.nextLine();

    	System.out.print("Lugar de creación: ");
    	String lugarCreacion = scanner.nextLine();

    	System.out.print("Nombre del autor: ");
    	String nombreAutor = scanner.nextLine();

    	System.out.print("Nacionalidad del autor: ");
    	String nacionalidadAutor = scanner.nextLine();

    	Artista autor = new Artista(nombreAutor, nacionalidadAutor);

    	System.out.print("Tematica: ");
    	String tematica = scanner.nextLine();

    	System.out.print("Precio: ");
    	int precio = scanner.nextInt();
    	scanner.nextLine();

    	Pieza nuevaPieza = new Pieza(false, nombrePieza, año, lugarCreacion, autor, true, tematica, precio);
    	galeria.agregarPiezaBodega(nuevaPieza);
    	System.out.println("Pieza agregada con éxito a la lista de piezas exhibidas.");
    }

    private static void agregarPiezaHistorico(Scanner scanner, Galeria galeria) {
    	System.out.println("Por favor, ingresa los detalles de la pieza a agregar:");

    	System.out.print("Nombre de la pieza: ");
    	String nombrePieza = scanner.nextLine();

    	System.out.print("Año de creación: ");
    	int año = scanner.nextInt();
    	scanner.nextLine();

    	System.out.print("Lugar de creación: ");
    	String lugarCreacion = scanner.nextLine();

    	System.out.print("Nombre del autor: ");
    	String nombreAutor = scanner.nextLine();

    	System.out.print("Nacionalidad del autor: ");
    	String nacionalidadAutor = scanner.nextLine();

    	Artista autor = new Artista(nombreAutor, nacionalidadAutor);

    	System.out.print("Tematica: ");
    	String tematica = scanner.nextLine();

    	System.out.print("Precio: ");
    	int precio = scanner.nextInt();
    	scanner.nextLine();
	
    	Pieza nuevaPieza = new Pieza(false, nombrePieza, año, lugarCreacion, autor, true, tematica, precio);
    	galeria.agregarPiezaHistorico(nuevaPieza);
    	System.out.println("Pieza agregada con éxito a la lista de piezas exhibidas.");
    }

    private static void obtenerRegistroPagos() {
    	CajeroGaleria cajero = CajeroGaleria.obternerCajero();
    	cajero.getRegistroPagos();
    }
}


        