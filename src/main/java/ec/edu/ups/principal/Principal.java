package ec.edu.ups.principal;

import java.util.ArrayList;
import java.util.Scanner;

import ec.edu.ups.clases.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Principal {

	public static void main(String[] args) {
                Date fechaHoy = new Date();
                Date fecha1 = new Date(); //Fecha para almacenar la devolucion de los libros
		Biblioteca biblioteca = new Biblioteca("Biblioteca Central", "123 Calle Principal");//Creacion de biblioteca
		Libro libro = new Libro();//Creación variable auxiliar de tipo Libro para la busqueda de libros
		ArrayList <Libro> listaDePosiblesLibrosPrestados = new ArrayList(); //Lista preliminar de libros a ser prestados
                ArrayList <Prestamo> listaDePrestamos = new ArrayList();
		Scanner scanner = new Scanner(System.in);//Inicializacion del scanner
                Usuario usuarioSesion = new Usuario();//Variable que almacena el usuario que ha ingresado sesion
		int opcion;//Opción menús
		boolean existenUsuarios=false; //Corrobora que existan usuarios registrados
		boolean sesionIniciada =false; //Corrobora que haya una sesión activa
		boolean existenLibros=false; //Corrobora que la biblioteca tengan libros
		
		//Variables sirven para ingresar libros y buscarlos segun los distintos parámetros
		String titulo="";
		String autor="";
		int anho=0;
		
		do {
			System.out.println("========"+biblioteca.getNombre()+"========");
			System.out.println("Sistema de Gestión de Biblioteca");
			System.out.println("1. Agregar Libro");
			System.out.println("2. Registrar Usuario");
			System.out.println("3. Iniciar Sesión");
			System.out.println("4. Buscar Libro");
			System.out.println("5. Prestar Libro");
			System.out.println("6. Devolver Libro");
			System.out.println("7. Salir");
			System.out.print("Ingrese una opción: ");
			opcion = scanner.nextInt();
			scanner.nextLine(); // Consumir la nueva línea
			switch (opcion) {
				case 1:
				// Implementación para agregar libro
					System.out.println("========"+biblioteca.getNombre()+"========");
					//////////Ingreso de datos del libro////////////////
					System.out.println("Ingresar titulo del libro: ");
					titulo = scanner.nextLine();
					System.out.println("Ingresar autor: ");
					autor = scanner.nextLine();
					System.out.println("Ingresar año de publicacion: ");
					anho = scanner.nextInt();
					
					Libro libroAIgresar = new Libro(titulo,autor,anho,true);//Creación de libro a ingresar a la biblioteca
                                        
					biblioteca.agregarLibro(libroAIgresar);//Añade a la lista de libros disponibles de la biblioteca
					existenLibros=true;
					break;
				case 2:
				// Implementación para registrar usuario
					//////////Variables para ingresar datos del usuario//////////////
					String nombre;
					String identificacion;
					String correo;
					/////////////Ingreso de datos/////////////////
					System.out.println("========"+biblioteca.getNombre()+"========");
					System.out.println("Ingrese su nombre: ");
					nombre = scanner.nextLine();
					System.out.println("Ingrese su identificacion: ");
					identificacion = scanner.nextLine();
					System.out.println("Ingrese su correo: ");
					correo = scanner.nextLine();
					
					Usuario usuario = new Usuario(nombre, identificacion, correo);//Creacion de usuario nuevo
					biblioteca.registrarUsuario(usuario);//Añade a lista de usuarios de la biblioteca
					existenUsuarios = true;
					break;
				case 3:
				//Implementación para iniciar sesion
					System.out.println("========"+biblioteca.getNombre()+"========");
					if(existenUsuarios) {
						Usuario usuario1 = new Usuario();//Usuario auxiliar para el inicio de sesión
						String correo1;//Variable para ingresar el correo a buscar
						System.out.println("Ingrese su correo: ");
						correo1 = scanner.nextLine();
						/////////Busca en la lista de usuarios, el correo ingresado//////////////////
						for(int i=0; i < biblioteca.devolverListaUsuarios().size();i++) {
							usuario1 = biblioteca.devolverListaUsuarios().get(i);
							if(correo1.equals(usuario1.getCorreo())) {
								System.out.println("Sesion iniciada");
								sesionIniciada=true;
                                                                usuarioSesion = usuario1;
								break;
							}
                                                        if(i==biblioteca.devolverListaUsuarios().size()-1){
                                                            System.out.println("Usuario no encontrado");
                                                        }
						}
					}else {
						System.out.println("No existen usurarios registrados");
					}
					break;
				case 4:
				// Implementación para buscar libro
					System.out.println("========"+biblioteca.getNombre()+"========");
					//////////////////Se puede buscar libros, solo si existe una sesión iniciada y si la biblioteca cuenta con libros//////////////////////
					if(sesionIniciada && existenLibros) {
						do {
							System.out.println("Método de búsqueda de libros");
							System.out.println("1.Por título, nombre y año");
							System.out.println("2.Por título y autor");
							System.out.println("3.Por título");
							System.out.println("4.Volver menú principal");
                                                        System.out.print("Ingrese la opcion: ");
							opcion = scanner.nextInt();
							scanner.nextLine(); // Consumir la nueva línea
							switch(opcion) {
							case 1:
							// Busca por titulo, autor y año
								/////////////////Ingreso de datos///////////////////
								System.out.println("Ingrese el título: ");
								titulo = scanner.nextLine();
								System.out.println("Ingrese el autor: ");
								autor = scanner.nextLine();
								System.out.println("Ingrese el año: ");
								anho = scanner.nextInt();
								libro=biblioteca.buscarLibro(titulo);//Busca el libro
								
								if(libro != null && libro.isDisponible()) {
									//Entra solo si el libro buscado existe y está disponible
									System.out.println("¿Desea solicitar el libro?");
									System.out.println("1.Si \t 2.No");
									opcion = scanner.nextInt();
									if (opcion==1) {//Agrega el libro a una lista preliminar de préstamos
										System.out.println("Agregando libro");
										listaDePosiblesLibrosPrestados.add(libro);
									}else {
										System.out.println("Volviendo al menú de búsqueda...");
									}
								}
								break;
							case 2:
							// Busca por titulo y autor
								/////////////////Ingreso de datos///////////////////
								System.out.println("Ingrese el título: ");
								titulo = scanner.nextLine();
								System.out.println("Ingrese el autor: ");
								autor = scanner.nextLine();
								libro=biblioteca.buscarLibro(titulo, autor);//Busca el libro
								
								if(libro != null && libro.isDisponible()) {
									//Entra solo si el libro buscado existe y está disponible
									System.out.println("¿Desea solicitar el libro?");
									System.out.println("1.Si \t 2.No");
									opcion = scanner.nextInt();
									if (opcion==1) {//Agrega el libro a una lista preliminar de préstamos
										System.out.println("Agregando libro");
										listaDePosiblesLibrosPrestados.add(libro);
									}else {
										System.out.println("Volviendo al menú de búsqueda...");
									}
								}
								break;
							case 3:
							// Busca por titulo
								/////////////////Ingreso de datos///////////////////
								System.out.println("Ingrese el título: ");
								titulo = scanner.nextLine();
								libro=biblioteca.buscarLibro(titulo);//Busca el libro
								
								if(libro != null && libro.isDisponible()) {
									//Entra solo si el libro buscado existe y está disponible
									System.out.println("¿Desea solicitar el libro?");
									System.out.println("1.Si \t 2.No");
									opcion = scanner.nextInt();
									if (opcion==1) {//Agrega el libro a una lista preliminar de préstamos
										System.out.println("Agregando libro");
										listaDePosiblesLibrosPrestados.add(libro);
									}else {
										System.out.println("Volviendo al menú de búsqueda...");
									}
								}
								break;
							case 4:
								System.out.println("Volviendo menú principal...");
								break;
							default:
								System.out.println("Opción ingresada incorrecta");
							}
							
						}while(opcion!=4);
					}else {
						System.out.println("Posiblemente no inició sesión o la biblioteca no cuenta con libros");
					}
					break;
				case 5:
				// Implementación para prestar libro
					System.out.println("========"+biblioteca.getNombre()+"========");
					if(sesionIniciada) {
						/* Funciona solo si el usuario inició sesión, inicia sesión solo con el correo
						 * En buscar libro si el libro está disponible, el usuario puede elegir si quiere el libro 
						 * o no, si quiere el libro se agrega a una listaDePosiblesLibrosPrestados
						 * 
						 * En la clase Biblioteca hay el metodo prestarLibro, no está con codigo porque no se como le vas a hacer
						 * para el préstamo de libros
						 * 
						 * En la clase libro hay los metodos para poner prestar y devolver, estos setean la disponibilidad del libro 
						 */
                                                System.out.println("Libros Escogidos Actualmente:");
                                                System.out.println("==============================");
                                                for(int i = 0; i<listaDePosiblesLibrosPrestados.size(); i++){
                                                    listaDePosiblesLibrosPrestados.get(i).mostrarInformacion();
                                                    System.out.println("==============================");
                                                }
                                                System.out.println("¿La informacion es correcta?");
                                                System.out.println("1.Si \t 2.No");
                                                System.out.print("Ingrese una opcion: ");
                                                if(scanner.nextInt()!=1){
                                                    break;
                                                }
                                                System.out.print("Ingrese la fecha de devolucion (formato: dd/MM/yyyy): ");
                                                String fechaIngresada = scanner.next();

                                                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                                                
                                                try {
                                                    fecha1 = formatoFecha.parse(fechaIngresada);
                                                } catch (ParseException e) {
                                                    System.out.println("Error al analizar la fecha. Asegúrese de usar el formato dd/MM/yyyy.");
                                                    break;
                                                }
                                                
                                                for(int i = 0; i<listaDePosiblesLibrosPrestados.size(); i++){
                                                    usuarioSesion.solicitarPrestamo(listaDePosiblesLibrosPrestados.get(i), usuarioSesion, fechaHoy, fecha1);
                                                    listaDePosiblesLibrosPrestados.get(i).prestar(listaDePosiblesLibrosPrestados.get(i));
                                                    System.out.println("Libro ["+ listaDePosiblesLibrosPrestados.get(i).getTitulo() +"] prestado! Le quedan " + usuarioSesion.getPrestamo().get(usuarioSesion.getPrestamo().size()-1).calcularDiasPrestamo() + " dia(s)" );
                                                }
                                                //Vaciar el vector
                                                for(int i = listaDePosiblesLibrosPrestados.size()-1; i>=0; i--){
                                                    listaDePosiblesLibrosPrestados.remove(i);
                                                }
					}else {
						System.out.println("Primero inicie sesión con su correo");
					}
					break;
				case 6:
				// Implementación para devolver libro}
					if(sesionIniciada) {
                                            listaDePrestamos = usuarioSesion.getPrestamo();
                                            System.out.println("Libros Prestados");
                                            System.out.println("==============================");
                                            for(int i=0; i<listaDePrestamos.size(); i++){
                                                listaDePrestamos.get(i).getLibro().mostrarInformacion();
                                                System.out.println("Dias Restantes: "+ listaDePrestamos.get(i).calcularDiasPrestamo() + " dia(s)");
                                                System.out.println("==============================");
                                            }
                                            System.out.println("Ingrese el nombre del libro a devolver");
                                            titulo = scanner.nextLine();
                                            libro=usuarioSesion.buscarLibro(titulo);
                                            if(libro != null) {
                                                //Entra solo si el libro buscado existe en el vector de prestamos
                                                System.out.println("¿Desea devolver el libro?");
                                                System.out.println("1.Si \t 2.No");
                                                opcion = scanner.nextInt();
                                                if (opcion==1) {//Agrega el libro a una lista preliminar de préstamos
                                                        System.out.println("Devolviendo libro");
                                                        usuarioSesion.devolverLibro(libro);
                                                }else {
                                                        System.out.println("Volviendo al menú de búsqueda...");
                                                }
                                            }
					}else {
                                            System.out.println("Primero inicie sesión con su correo");
					}
					break;
				case 7:
					System.out.println("Saliendo del sistema...");
					break;
				default:
					System.out.println("Opción no válida. Por favor intente de nuevo.");
			}
		} while (opcion != 7);
		scanner.close();

	}

}
