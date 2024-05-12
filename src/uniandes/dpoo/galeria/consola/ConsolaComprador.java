package uniandes.dpoo.galeria.consola;

import uniandes.dpoo.galeria.modelo.usuario.Comprador;
import uniandes.dpoo.galeria.modelo.Pieza;
import uniandes.dpoo.galeria.persistencia.PersistenciaComprador;


import java.util.Scanner;

public class ConsolaComprador{

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Por favor, ingresa tu identificación para verificar si ya estás registrado: ");
        int identificacion = scanner.nextInt();
        scanner.nextLine(); 

        Comprador comprador = PersistenciaComprador.obtenerCompradorPorCedula(identificacion);

        if (comprador == null) {
            System.out.println("No se encontró un usuario registrado con esa identificación. Por favor, registra tus datos.");
            comprador = registrarComprador(scanner);
        } else {
            System.out.println("Bienvenido de nuevo, " + comprador.getNombre());
        }

        if (comprador == null) {
            System.out.println("Registro cancelado. Saliendo del programa...");
            scanner.close();
            return;
        }

        int opcion;
        // Menú que se muestra en bucle hasta que el usuario elige salir
        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Solicitar aumento del limite de compras");
            System.out.println("2. Consultar pieza en inventario");
            System.out.println("3. Realizar compra");
            System.out.println("4. Solicitar devolución");
            System.out.println("5. Hacer oferta en subasta");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
            	case 1: 
            		establecerLimite(scanner, comprador);
                case 2:
                    consultarPieza(scanner, comprador);
                    break;
                case 3:
                    realizarCompra(scanner, comprador);
                    break;
                case 4:
                    solicitarDevolucion(scanner, comprador);
                    break;
                case 5:
                	hacerOfertaSubasta(scanner, comprador);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
            System.out.println();
        }
    }

    private static Comprador registrarComprador(Scanner scanner) {
        System.out.println("Bienvenido al registro de compradores.");
        System.out.print("Por favor, ingresa tu nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Por favor, ingresa tu identificación: ");
        int identificacion = scanner.nextInt();
        System.out.print("Por favor, ingresa tu edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Por favor, ingresa tu nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Por favor, ingresa tu contraseña: ");
        String contraseña = scanner.nextLine();
        System.out.print("Por favor, ingresa tu número de teléfono: ");
        String numeroTelefono = scanner.nextLine();
        System.out.print("Por favor, ingresa tu correo electrónico: ");
        String correo = scanner.nextLine();
        System.out.print("Por favor, ingresa tu saldo inicial: ");
        int saldo = scanner.nextInt();
        scanner.nextLine();

        Comprador nuevoComprador = new Comprador(nombre, identificacion, edad, nombreUsuario, contraseña, numeroTelefono, correo, saldo);
        PersistenciaComprador.guardarComprador(nuevoComprador);

        return nuevoComprador;
    }
    
    //Opción 1
    private static void establecerLimite(Scanner scanner, Comprador comprador) {
    	System.out.print("Por favor, indique si desea solicitar el cambio de limite compras (1 para si, 0 para no: ");
    	Integer opcion = scanner.nextInt();
    	if(opcion == 1) {
    		comprador.solicitarAumentoLimite();
    		System.out.println("Límite de compras actualizado correctamente a: " + comprador.getValorMaxCompras()); 
    	}
    	else {
    		System.out.println("Su límite de compras no fue modificado, y es el siguiente: " + comprador.getValorMaxCompras()); 
    	}
    	
    }
    
    //Opcion 2
 

    private static void consultarPieza(Scanner scanner, Comprador comprador) {
        System.out.print("Por favor, ingresa el nombre de la pieza a consultar: ");
        String nombrePieza = scanner.nextLine();
        Pieza pieza = comprador.ConsultarPieza(nombrePieza);
        if (pieza != null) {
            System.out.println("La pieza consultada es: " + pieza.toString());
        } else {
            System.out.println("La pieza no se encuentra en el inventario.");
        }
    }
    
    //Opcion 3
    private static void realizarCompra(Scanner scanner, Comprador comprador) {
        System.out.print("Por favor, ingresa el nombre de la pieza a comprar: ");
        String nombrePieza = scanner.nextLine();
        Pieza pieza = comprador.ConsultarPieza(nombrePieza);
        boolean vendida = pieza.isVendida();
        if (pieza != null  && vendida == false ) {
            comprador.agregarPieza(pieza);
            comprador.agregarPiezaColeccion(pieza);
            System.out.println("¡Compra realizada con éxito!");
        } else {
            System.out.println("La pieza no se encuentra en el inventario.");
        }
    }


    //Opcion 4
    private static void solicitarDevolucion(Scanner scanner, Comprador comprador) {
        System.out.print("Por favor, ingresa el nombre de la pieza a devolver: ");
        String nombrePieza = scanner.nextLine();
        Pieza pieza = comprador.ConsultarPieza(nombrePieza);
        if (pieza != null && comprador.getPiezasCompradas().contains(pieza)) {
            comprador.solicitarDevolucion(pieza);
            System.out.println("¡Devolución procesada con éxito!");
        } else {
            System.out.println("La pieza no fue comprada por este comprador.");
        }
    }
    
    //Opcion 5
    private static void hacerOfertaSubasta(Scanner scanner, Comprador comprador) throws Exception {
    	System.out.print("Elija 1 si desea participar en la subasta, 0 para no: ");
    	int opcion = scanner.nextInt();
    	if (opcion == 1) {
    		System.out.print("Ingrese el nombre de la pieza participante en la subasta a la que quiere ofertar: ");
    		String piezaOferta = scanner.nextLine();
    		Pieza pieza = comprador.ConsultarPieza(piezaOferta);
    		System.out.print("Ingrese el valor de la oferta para la subasta: ");
    		int valor = scanner.nextInt();
    		System.out.print("Ingrese la fecha actual en el formato DIA/MES/AÑO: ");
    		String fecha = scanner.nextLine();
    		comprador.hacerOfertaSubasta(pieza, valor, fecha);
    		System.out.print("Buenas noticias!, eres participante de la subasta. ");
    	}
    	else {
    		System.out.print("Lo sentimos, intenta de nuevo, no has accedido a la subasta. ");
    	}
    }
}

