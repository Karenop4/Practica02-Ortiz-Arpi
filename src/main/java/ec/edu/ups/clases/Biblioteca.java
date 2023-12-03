package ec.edu.ups.clases;

import java.util.ArrayList;
import java.util.Objects;

public class Biblioteca {
	private String nombre;
	private String direccion;
	private ArrayList <Libro> listaLibros;
	private ArrayList <Usuario> listaUsuarios;
	
	//Constructor

	public Biblioteca(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.listaLibros = new ArrayList();
		this.listaUsuarios = new ArrayList();
	}
	
	public Biblioteca() {
		this.listaLibros = new ArrayList();
		this.listaUsuarios = new ArrayList();
	}



	//Getters y Setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	//Métodos
	public void agregarLibro(Libro libro) {
		listaLibros.add(libro);
	}
	public void registrarUsuario(Usuario usuario) {
		listaUsuarios.add(usuario);
	}
	public void prestarLibro(Libro libro) {
		
		for (int i = 0; i<listaLibros.size(); i++) {
			Libro libroBuscado = listaLibros.get(i);
			if (libroBuscado.equals(libro)) {
				if (libroBuscado.isDisponible()) {
					System.out.println("Libro encontrado");
					libroBuscado.mostrarInformacion();
					break;
				}else {
					System.out.println("El libro no está disponible");
				}
			}
		}
	}
	
	
	public ArrayList<Libro> devolverListaLibros() {
		return listaLibros;
	}

	public ArrayList<Usuario> devolverListaUsuarios() {
		return listaUsuarios;
	}

	//////Sobrecarga de metodos
	public Libro buscarLibro(String titulo, String autor, int anho) {
		for (int i = 0; i<listaLibros.size(); i++) {
			Libro libroBuscado = listaLibros.get(i);
			if (libroBuscado.getTitulo().equals(titulo) && libroBuscado.getAutor().equals(autor) && libroBuscado.getAnho()==anho) {
				libroBuscado.mostrarInformacion();
				return libroBuscado;
			}else {
				System.out.println("El libro no encontrado");
			}
		}
		return null;
	}
	public Libro buscarLibro(String titulo, String autor) {
		for (int i = 0; i<listaLibros.size(); i++) {
			Libro libroBuscado = listaLibros.get(i);
			if (libroBuscado.getTitulo().equals(titulo) && libroBuscado.getAutor().equals(autor)) {
				libroBuscado.mostrarInformacion();
				return libroBuscado;
			}else {
				System.out.println("El libro no encontrado");
			}
		}
		return null;
		
	}
	public Libro buscarLibro(String titulo) {
		for (int i = 0; i<listaLibros.size(); i++) {
			Libro libroBuscado = listaLibros.get(i);
			if (libroBuscado.getTitulo().equals(titulo)) {
				libroBuscado.mostrarInformacion();
				return libroBuscado;
			}else {
				System.out.println("El libro no encontrado");
			}
		}
		return null;
	}
	
	
    
	@Override
	public String toString() {
		return "Biblioteca [nombre=" + nombre + ", direccion=" + direccion + "]";
	}
	
}
