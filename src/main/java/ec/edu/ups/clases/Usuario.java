package ec.edu.ups.clases;

import java.util.Date;

public class Usuario {
	private String correo;
	
	//Constructores
	public Usuario(String correo) {
		this.correo = correo;
	}
	public Usuario() {
		
	}
	
	//Getters y Setters
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public void solicitarPrestamo(Libro libro, Usuario usuario, Date fechaPrestamo, Date fechaDevolucion) {
		
	}
	
	public void devolverLibro(Libro libro) {
		
	}
	
	@Override
	public String toString() {
		return "Usuario [correo=" + correo + "]";
	}
	
	
}
