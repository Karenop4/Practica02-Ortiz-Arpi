package ec.edu.ups.principal;

import java.util.Scanner;

import ec.edu.ups.clases.*;

public class Principal {

	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca("Biblioteca Central", "123 Calle Principal");
		Scanner scanner = new Scanner(System.in);
		int opcion;
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
					break;
				case 2:
				// Implementación para registrar usuario
					break;
				case 3:
				//Implementación para iniciar sesion
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
