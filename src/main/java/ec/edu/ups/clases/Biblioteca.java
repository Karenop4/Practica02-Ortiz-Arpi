package ec.edu.ups.clases;

import java.util.Objects;

public class Biblioteca {
	private String nombre;
	private String direccion;
	
	//Constructor
	public Biblioteca(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
	}
	
	public Biblioteca() {
		
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
		
	}
	public void registrarUsuario(Usuario usuario) {
		
	}
	public void prestarLibro(Libro libro, Usuario usuario) {
		
	}
	//////Sobrecarga de metodos
	public void buscarLibro(String titulo, String autor, int anho) {
		
	}
	public void buscarLibro(String titulo, String autor) {
		
	}
	public void buscarLibro(String titulo) {
		
	}
	
	
    
	@Override
	public String toString() {
		return "Biblioteca [nombre=" + nombre + ", direccion=" + direccion + "]";
	}	
}
