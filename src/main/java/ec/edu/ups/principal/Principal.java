package ec.edu.ups.principal;

import java.util.ArrayList;
import java.util.Scanner;

import ec.edu.ups.clases.*;

public class Principal {

	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca("Biblioteca Central", "123 Calle Principal");
		Scanner scanner = new Scanner(System.in);
		int opcion;
		boolean existenUsuarios=false;
		boolean sesionIniciada =false;
		do {
			System.out.println("Bienvenido al Sistema de Gestión de Biblioteca");
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
					String titulo;
					String autor;
					int anho;
					
					System.out.println("Ingresar titulo del libro: ");
					titulo = scanner.nextLine();
					System.out.println("Ingresar autor: ");
					autor = scanner.nextLine();
					System.out.println("Ingresar año de publicacion: ");
					anho = scanner.nextInt();
					
					Libro libro = new Libro(titulo,autor,anho,true);
					
					biblioteca.agregarLibro(libro);
					break;
				case 2:
				// Implementación para registrar usuario
					String nombre;
					String identificacion;
					String correo;
					
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
							}else {
								System.out.println("Usuario no encontrado");
							}
						}
					}else {
						System.out.println("No existen usurarios registrados");
					}
					break;
				case 4:
				// Implementación para buscar libro
					break;
				case 5:
				// Implementación para prestar libro
					break;
				case 6:
				// Implementación para devolver libro
					break;
				case 7:
					System.out.println("Saliendo del sistema...");
					break;
				default:
					System.out.println("Opción no válida. Por favor intente de nuevo.");
			}
		} while (opcion != 6);
		scanner.close();

	}

}
