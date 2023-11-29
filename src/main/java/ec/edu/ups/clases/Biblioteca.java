package ec.edu.ups.clases;

import java.util.ArrayList;

public class Biblioteca {
	private String nombre;
	private String direccion;
	private ArrayList <Libro> listaLibros;
	private ArrayList <Usuario> listaUsuarios;
	
	//Constructor

	public Biblioteca(String nombre, String direccion) {
		super();
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
	public void prestarLibro(Libro libro, Usuario usuario) {
		boolean existeUsuario=false;
		
		for (int i=0; i<listaUsuarios.size();i++) {
			Usuario usuarioBuscado = listaUsuarios.get(i);
			if (usuarioBuscado.equals(usuarioBuscado)) {
				existeUsuario = true;
				break;
			}
		}
		
		if(existeUsuario) {
			for (int i = 0; i<listaLibros.size(); i++) {
				Libro libroBuscado = listaLibros.get(i);
				if (libroBuscado.equals(libro)) {
					if (libroBuscado.isDisponible()) {
						System.out.println("Libro encontrado");
						break;
					}else {
						System.out.println("El libro no está disponible");
					}
				}
			}
		}else {
			System.out.println("Usuario no encontrado");
		}
	}
	
	//////Sobrecarga de metodos
	public void buscarLibro(String titulo, String autor, int anho) {
		for (int i = 0; i<listaLibros.size(); i++) {
			Libro libroBuscado = listaLibros.get(i);
			if (libroBuscado.getTitulo().equals(titulo) && libroBuscado.getAutor().equals(autor) && libroBuscado.getAnho()==anho) {
				System.out.println(libroBuscado.toString());
			}else {
				System.out.println("El libro no encontrado");
			}
		}
	}
	public void buscarLibro(String titulo, String autor) {
		for (int i = 0; i<listaLibros.size(); i++) {
			Libro libroBuscado = listaLibros.get(i);
			if (libroBuscado.getTitulo().equals(titulo) && libroBuscado.getAutor().equals(autor)) {
				System.out.println(libroBuscado.toString());
			}else {
				System.out.println("El libro no encontrado");
			}
		}
	}
	public void buscarLibro(String titulo) {
		for (int i = 0; i<listaLibros.size(); i++) {
			Libro libroBuscado = listaLibros.get(i);
			if (libroBuscado.getTitulo().equals(titulo)) {
				System.out.println(libroBuscado.toString());
			}else {
				System.out.println("El libro no encontrado");
			}
		}
	}
	
	
    
	@Override
	public String toString() {
		return "Biblioteca [nombre=" + nombre + ", direccion=" + direccion + "]";
	}	
}
