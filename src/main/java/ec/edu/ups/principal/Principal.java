package ec.edu.ups.principal;

import java.util.ArrayList;
import java.util.Scanner;

import ec.edu.ups.clases.*;

public class Principal {

	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca("Biblioteca Central", "123 Calle Principal");
		Libro libro = new Libro();
		ArrayList <Libro> listaDePosiblesLibrosPrestados = new ArrayList();
		Scanner scanner = new Scanner(System.in);
		int opcion;
		boolean existenUsuarios=false;
		boolean sesionIniciada =false;
		boolean existenLibros=false;
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
					System.out.println("Ingresar titulo del libro: ");
					titulo = scanner.nextLine();
					System.out.println("Ingresar autor: ");
					autor = scanner.nextLine();
					System.out.println("Ingresar año de publicacion: ");
					anho = scanner.nextInt();
					
					Libro libroAIgresar = new Libro(titulo,autor,anho,true);
					
					biblioteca.agregarLibro(libroAIgresar);
					existenLibros=true;
					break;
				case 2:
				// Implementación para registrar usuario
					String nombre;
					String identificacion;
					String correo;
					System.out.println("========"+biblioteca.getNombre()+"========");
					System.out.println("Ingrese su nombre: ");
					nombre = scanner.nextLine();
					System.out.println("Ingrese su identificacion: ");
					identificacion = scanner.nextLine();
					System.out.println("Ingrese su correo: ");
					correo = scanner.nextLine();
					
					Usuario usuario = new Usuario(nombre, identificacion, correo);
					biblioteca.registrarUsuario(usuario);
					existenUsuarios = true;
					break;
				case 3:
				//Implementación para iniciar sesion
					System.out.println("========"+biblioteca.getNombre()+"========");
					if(existenUsuarios) {
						Usuario usuario1 = new Usuario();
						String correo1;
						System.out.println("Ingrese su correo: ");
						correo1 = scanner.nextLine();
						for(int i=0; i < biblioteca.devolverListaUsuarios().size();i++) {
							usuario1 = biblioteca.devolverListaUsuarios().get(i);
							if(correo1.equals(usuario1.getCorreo())) {
								System.out.println("Sesion iniciada");
								sesionIniciada=true;
								break;
							}
						}
						System.out.println("Usuario no encontrado");
					}else {
						System.out.println("No existen usurarios registrados");
					}
					break;
				case 4:
				// Implementación para buscar libro
					boolean libroEncontrado=false;
					System.out.println("========"+biblioteca.getNombre()+"========");
					if(sesionIniciada && existenLibros) {
						do {
							System.out.println("Método de búsqueda de libros");
							System.out.println("1.Por título, nombre y año");
							System.out.println("2.Por título y autor");
							System.out.println("3.Por título");
							System.out.println("4.Volver menú principal");
							opcion = scanner.nextInt();
							scanner.nextLine(); // Consumir la nueva línea
							switch(opcion) {
							case 1:
								System.out.println("Ingrese el título: ");
								titulo = scanner.nextLine();
								System.out.println("Ingrese el autor: ");
								autor = scanner.nextLine();
								System.out.println("Ingrese el año: ");
								anho = scanner.nextInt();
								libro=biblioteca.buscarLibro(titulo);
								if(libro != null && libro.isDisponible()) {
									System.out.println("¿Desea solicitar el libro?");
									System.out.println("1.Si \t 2.No");
									opcion = scanner.nextInt();
									if (opcion==1) {
										System.out.println("Agregando libro");
										listaDePosiblesLibrosPrestados.add(libro);
									}else {
										System.out.println("Volviendo al menú de búsqueda...");
									}
								}
								break;
							case 2:
								System.out.println("Ingrese el título: ");
								titulo = scanner.nextLine();
								System.out.println("Ingrese el autor: ");
								autor = scanner.nextLine();
								libro=biblioteca.buscarLibro(titulo, autor);
								if(libro != null && libro.isDisponible()) {
									System.out.println("¿Desea solicitar el libro?");
									System.out.println("1.Si \t 2.No");
									opcion = scanner.nextInt();
									if (opcion==1) {
										System.out.println("Agregando libro");
										listaDePosiblesLibrosPrestados.add(libro);
									}else {
										System.out.println("Volviendo al menú de búsqueda...");
									}
								}
								break;
							case 3:
								System.out.println("Ingrese el título: ");
								titulo = scanner.nextLine();
								libro=biblioteca.buscarLibro(titulo);
								if(libro != null && libro.isDisponible()) {
									System.out.println("¿Desea solicitar el libro?");
									System.out.println("1.Si \t 2.No");
									opcion = scanner.nextInt();
									if (opcion==1) {
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
						 */
					}else {
						System.out.println("Primero inicie sesión con su correo");
					}
					break;
				case 6:
				// Implementación para devolver libro}
					if(sesionIniciada) {
						
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
