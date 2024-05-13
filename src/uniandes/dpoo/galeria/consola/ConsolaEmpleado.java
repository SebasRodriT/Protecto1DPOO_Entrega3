package uniandes.dpoo.galeria.consola;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import uniandes.dpoo.galeria.modelo.Pieza;
import uniandes.dpoo.galeria.modelo.empleado.CajeroGaleria;
import uniandes.dpoo.galeria.modelo.empleado.OperadorGaleria;
import uniandes.dpoo.galeria.modelo.Artista;
import uniandes.dpoo.galeria.modelo.Galeria;
import uniandes.dpoo.galeria.modelo.plataforma.RegistroVenta;
import uniandes.dpoo.galeria.modelo.usuario.Comprador;
import uniandes.dpoo.galeria.modelo.plataforma.Plataforma;
import uniandes.dpoo.galeria.modelo.pago.Pago;
import uniandes.dpoo.galeria.modelo.empleado.Empleado;



public class ConsolaEmpleado {
	
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Menú que se muestra en bucle hasta que el usuario elige salir
        while (true) {
            // Imprime el menú
            System.out.println("Menú:");
            System.out.println("1. Buscar pieza");
            System.out.println("2. Buscar pieza en histórico");
            System.out.println("3. Buscar pieza en bodega");
            System.out.println("4. Agregar pieza exhibida");
            System.out.println("5. Agregar pieza a bodega");
            System.out.println("6. Agregar pieza a histórico");
            System.out.println("7. Obtener registro de pagos (Cajero)");
            System.out.println("8. Obtener registro de ofertas por subasta (Operador)");
            System.out.println("9. Salir");
            System.out.print("Elige una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    buscarPiezaExhibida(scanner);
                    break;
                case 2:
                    buscarPiezaHistorico(scanner);
                    break;
                case 3:
                    buscarPiezaBodega(scanner);
                    break;
                case 4:
                    agregarPiezaExhibida(scanner);
                    break;
                case 5:
                    agregarPiezaBodega(scanner);
                    break;
                case 6:
                    agregarPiezaHistorico(scanner);
                    break;
                case 7:
                    obtenerRegistroPagos(scanner);
                    break;
                case 8:
                    obtenerRegistroSubasta(scanner);
                    break;
                case 9:
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
        // Implementación
    }
    
    private static void obtenerRegistroSubasta() {
        // Implementación
    }
}
