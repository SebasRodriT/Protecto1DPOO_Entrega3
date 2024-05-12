package uniandes.dpoo.galeria.consola;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import uniandes.dpoo.galeria.modelo.Artista;
import uniandes.dpoo.galeria.modelo.Dibujo;
import uniandes.dpoo.galeria.modelo.Escultura;
import uniandes.dpoo.galeria.modelo.Fotografia;
import uniandes.dpoo.galeria.modelo.Impresion;
import uniandes.dpoo.galeria.modelo.Pieza;
import uniandes.dpoo.galeria.modelo.Pintura;
import uniandes.dpoo.galeria.modelo.Video;
import uniandes.dpoo.galeria.modelo.empleado.AdministradorGaleria;
import uniandes.dpoo.galeria.persistencia.PersistenciaAdministradorGaleria;

public class ConsolaAdministrador {
	
	
    public static void main(String[] args) throws IOException {
    	AdministradorGaleria administrador = AdministradorGaleria.obternerAdmin();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Menú que se muestra en bucle hasta que el usuario elige salir
        while (true) {
            // Imprime el menú
            System.out.println("Menú:");
            System.out.println("1. Ingresar una pieza al inventario");
            System.out.println("2. Confirmar venta Pieza");
            System.out.println("3. Confirmar devolucion Pieza");
            System.out.println("4. Ver historia de una Pieza");
            System.out.println("5. Ver historia de un Artista");
            System.out.println("6. Ver historia de un Comprador");
            System.out.println("7. Guardar administrador");
            System.out.println("8. Salir");
            System.out.print("Elige una opción: ");
            
         
            opcion = scanner.nextInt();
            scanner.nextLine();
           
            if (opcion == 1) {
                System.out.println("Has seleccionado la Opción 1.");
                System.out.println("Para ingresar a pieza es necesario registrar al artista primero. Por favor ingrese los siguientes datos:");
                System.out.println("Nombre del artista: ");
                String nombreArtista = scanner.nextLine();
                System.out.println("Tipo/especialidad del artista (ej: pintor): ");
                String tipoArtista = scanner.nextLine();
                Artista artista = new Artista(nombreArtista, tipoArtista);
                System.out.println("Ingrese el numero correspondiente al tipo de pieza que desea ingresar:"
                		
                		+ "\n1. Dibujo  "
                		+ "\n2. Escultura "
                		+ "\n3. Fotografía "
                		+ "\n4. Impresión "
                		+ "\n5. Pintura "
                		+ "\n6. Video "
                		+ "\nAviso: para medidas/tamaños ingrese unicamente valores enteros por favor");
                opcion = scanner.nextInt();
                scanner.nextLine();
                		
                		
                if (opcion == 1) {
                	
                	System.out.println("Ahora ingrese la informacion de la pieza");
                	System.out.println("Titulo de la pieza: ");
                	String tituloObra = scanner.nextLine();
                	System.out.println("Año de creación/publicación: ");
                	int anio = scanner.nextInt();
                	scanner.nextLine();
                	System.out.println("Lugar de creación/publicación: ");
                	String lugarObra = scanner.nextLine();
                	System.out.println("temática: ");
                	String tematicaObra = scanner.nextLine();
                	System.out.println("Valor/precio: ");
                	int precio = scanner.nextInt();
                	scanner.nextLine();
                	System.out.println("técnica: ");
                	String tecnicaObra = scanner.nextLine();
                	System.out.println("estilo: ");
                	String estiloObra = scanner.nextLine();
                	System.out.println("medio (ej: lienzo): ");
                	String medio = scanner.nextLine();
                	System.out.println("tamaño (m x n) ");
                	String tamano = scanner.nextLine();
            		Dibujo dibujo = new Dibujo(medio,tecnicaObra,estiloObra,tamano,false ,tituloObra,anio,lugarObra,artista,false,tematicaObra,precio);
            		administrador.registrarPiezaInventario(dibujo);
                	System.out.println("Pieza ingresada exitosamente al inventario");
                	
                } else if (opcion == 2) {
                	
                	System.out.println("Ahora ingrese la informacion de la pieza");
                	System.out.println("Titulo de la pieza: ");
                	String tituloObra = scanner.nextLine();
                	System.out.println("Año de creación/publicación: ");
                	int anio = scanner.nextInt();
                	scanner.nextLine();
                	System.out.println("Lugar de creación/publicación: ");
                	String lugarObra = scanner.nextLine();
                	System.out.println("temática: ");
                	String tematicaObra = scanner.nextLine();
                	System.out.println("Valor/precio: ");
                	int precio = scanner.nextInt();
                	scanner.nextLine();
                	System.out.println("Altura: ");
                	double altura = scanner.nextDouble();
                	scanner.nextLine();
                	System.out.println("Ancho: ");
                	double ancho = scanner.nextDouble();
                	scanner.nextLine();
                	System.out.println("Peso: ");
                	double peso = scanner.nextDouble();
                	scanner.nextLine();
                	System.out.println("¿Requiere electricidad?(true/false): ");
                	boolean electricidad = scanner.nextBoolean();
                	scanner.nextLine();
                	Escultura escultura = new Escultura(altura,ancho,peso,electricidad,false,tituloObra,anio,lugarObra,artista,false,tematicaObra,precio);
                	administrador.registrarPiezaInventario(escultura);
                	System.out.println("Pieza ingresada exitosamente al inventario");
                	
                } else if (opcion == 3) {
                	
                	System.out.println("Ahora ingrese la informacion de la pieza");
                	System.out.println("Titulo de la pieza: ");
                	String tituloObra = scanner.nextLine();
                	System.out.println("Año de creación/publicación: ");
                	int anio = scanner.nextInt();
                	scanner.nextLine();
                	System.out.println("Lugar de creación/publicación: ");
                	String lugarObra = scanner.nextLine();
                	System.out.println("temática: ");
                	String tematicaObra = scanner.nextLine();
                	System.out.println("Valor/precio: ");
                	int precio = scanner.nextInt();
                	scanner.nextLine();
                	System.out.println("Calidad (m x n): ");
                	String calidad = scanner.nextLine();
                	System.out.println("¿A color?(true/false): ");
                	boolean color = scanner.nextBoolean();
                	scanner.nextLine();
                	Fotografia fotografia = new Fotografia(calidad,color,false,tituloObra,anio,lugarObra,artista,false,tematicaObra,precio);
                	administrador.registrarPiezaInventario(fotografia);
                	System.out.println("Pieza ingresada exitosamente al inventario");
                	
                } else if (opcion == 4) {
                	
                	System.out.println("Ahora ingrese la informacion de la pieza");
                	System.out.println("Titulo de la pieza: ");
                	String tituloObra = scanner.nextLine();
                	System.out.println("Año de creación/publicación: ");
                	int anio = scanner.nextInt();
                	scanner.nextLine();
                	System.out.println("Lugar de creación/publicación: ");
                	String lugarObra = scanner.nextLine();
                	System.out.println("temática: ");
                	String tematicaObra = scanner.nextLine();
                	System.out.println("Valor/precio: ");
                	int precio = scanner.nextInt();
                	scanner.nextLine();
                	System.out.println("Tipo impresion: ");
                	String tipoImpresion = scanner.nextLine();
                	System.out.println("Calidad/ DPI (puntos por pulgada): ");
                	String calidad = scanner.nextLine();
                	System.out.println("tamaño (m x n) ");
                	String tamano = scanner.nextLine();
                	Impresion impresion = new Impresion(tipoImpresion,calidad,tamano,false,tituloObra,anio,lugarObra,artista,false,tematicaObra,precio);
                	administrador.registrarPiezaInventario(impresion);
                	System.out.println("Pieza ingresada exitosamente al inventario");
                	
                } else if (opcion == 5) {
                	
                	System.out.println("Ahora ingrese la informacion de la pieza");
                	System.out.println("Titulo de la pieza: ");
                	String tituloObra = scanner.nextLine();
                	System.out.println("Año de creación/publicación: ");
                	int anio = scanner.nextInt();
                	scanner.nextLine();
                	System.out.println("Lugar de creación/publicación: ");
                	String lugarObra = scanner.nextLine();
                	System.out.println("temática: ");
                	String tematicaObra = scanner.nextLine();
                	System.out.println("Valor/precio: ");
                	int precio = scanner.nextInt();
                	scanner.nextLine();
                	System.out.println("tecnica: ");
                	String tecnica = scanner.nextLine();
                	System.out.println("estilo: ");
                	String estilo = scanner.nextLine();
                	System.out.println("Altura: ");
                	double altura = scanner.nextDouble();
                	scanner.nextLine();
                	System.out.println("Ancho: ");
                	double ancho = scanner.nextDouble();
                	scanner.nextLine();
                	Pintura pintura = new Pintura(tecnica,estilo,altura,ancho,false,tituloObra,anio,lugarObra,artista,false,tematicaObra,precio);
                	administrador.registrarPiezaInventario(pintura);
                	System.out.println("Pieza ingresada exitosamente al inventario");
                	
                } else if (opcion == 6) {
                	
                	System.out.println("Ahora ingrese la informacion de la pieza");
                	System.out.println("Titulo de la pieza: ");
                	String tituloObra = scanner.nextLine();
                	System.out.println("Año de creación/publicación: ");
                	int anio = scanner.nextInt();
                	scanner.nextLine();
                	System.out.println("Lugar de creación/publicación: ");
                	String lugarObra = scanner.nextLine();
                	System.out.println("temática: ");
                	String tematicaObra = scanner.nextLine();
                	System.out.println("Valor/precio: ");
                	int precio = scanner.nextInt();
                	scanner.nextLine();
                	System.out.println("Calidad (m x n): ");
                	String calidad = scanner.nextLine();
                	System.out.println("formato: ");
                	String formato = scanner.nextLine();
                	System.out.println("RelacionAspecto (m:n): ");
                	String relacionAspecto = scanner.nextLine();
                	Video video = new Video (calidad, formato, relacionAspecto,false,tituloObra,anio,lugarObra,artista,false,tematicaObra,precio);
                	administrador.registrarPiezaInventario(video);
                	System.out.println("Pieza ingresada exitosamente al inventario");
                	
                } else {
                	System.out.println("Opcion invalida");
                }
             
                
            } else if (opcion == 2) {
                System.out.println("Has seleccionado la Opción 2.");
                System.out.print("Por favor, ingresa el nombre de la pieza a consultar: ");
                String nombrePieza = scanner.nextLine();
                boolean rta = administrador.confirmarVenta(nombrePieza);
                if (rta == true) {
                	System.out.println("La pieza consultada ya fue vendida");
                } else {
                	System.out.println("La pieza consultada NO ha sido vendida");
                }
              
            } else if (opcion == 3) {
                System.out.println("Has seleccionado la Opción 3.");
                System.out.print("Por favor, ingresa el nombre de la pieza a consultar: ");
                String nombrePieza = scanner.nextLine();
                boolean rta = administrador.confirmarDevolucion(nombrePieza);
                if (rta == true) {
                	System.out.println("La pieza consultada ha sido devuelta por el comprador anterior");
                } else {
                	System.out.println("La pieza consultada NO ha sido devuelta a la galeria");
                }
                
                
            } else if (opcion == 4) {
                System.out.println("Has seleccionado la Opción 4.");
                System.out.print("Por favor, ingresa el nombre de la pieza a consultar: ");
                String nombrePieza = scanner.nextLine();
                Pieza rta = administrador.ConsultarPieza(nombrePieza);
                
                if (rta== null) {
                	System.out.println("Pieza no encontrada");
                }
                else {
                
                System.out.println("La pieza " + rta.getTituloObra()+ " fue creada en " + rta.getLugarCreacion() + 
                		" en el año de "+ rta.getAño() + " por " + rta.getAutor().getNombre() + 
                		"\nLa tematica de la pieza es " + rta.getTematica());
                if (rta.isVendida() == true) {
                	System.out.println("La pieza fue vendida por un valor de " + rta.getPrecio() + " el dia " + rta.getFecha() +
                			".\nEl dueño actual es " + rta.getDueño()); 
                }else {
                    System.out.println("La pieza no ha sido vendida. Tiene un valor de " + rta.getPrecio());
                }}
             
                
            } else if (opcion == 5) {
                System.out.println("Has seleccionado la Opción 5.");
                System.out.print("Por favor, ingresa el nombre del Artista a consultar: ");
                String nombreArtista = scanner.nextLine();
                ArrayList<Pieza> rta = administrador.consultarHistoriaArtista(nombreArtista);
                if (rta == null) {
                	System.out.println("El artista NO tiene o ha tenido ninguna pieza en la galeria");
                } else {
                	int i = 1;
                	System.out.println("Lista de Piezas de " + nombreArtista+":\n");
                	for (Pieza p: rta) {
                		System.out.println(i);
                		if (p.isVendida() == true) {
                		System.out.println("La pieza " + p.getTituloObra() + " fue hecha en el año de " + p.getAño() + ".\n"
                		+ "Fue vendida por un valor de " + p.getPrecio() + " el dia " + p.getFecha() );} 
                		else {
                		System.out.println("La pieza " + p.getTituloObra() + " fue hecha en el año de " + p.getAño() + ".\n"+
                		"La pieza no ha sido vendida y tiene un valor de " + p.getPrecio());
                			} i ++;
                	}
                }
                
                
            } else if (opcion == 6) {
                System.out.println("Has seleccionado la Opción 6.");
                System.out.print("Por favor, ingresa el nombre del Comprador a consultar: ");
                String nombre = scanner.nextLine();
                administrador.historiaPiezasCompradas(nombre);
                
            } else if (opcion == 7) {
                System.out.println("Has seleccionado la Opción 7.");
                PersistenciaAdministradorGaleria.guardarAdministrador();
                System.out.println("La informacion del administrador se ha guardado exitosamente");
                
            } else if (opcion == 8) {
                System.out.println("Saliendo del programa...");
                
                scanner.close();
                return;
            } else {
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }

            System.out.println();
        }
    }
}
