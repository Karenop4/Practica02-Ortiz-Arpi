package ec.edu.ups.clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Usuario extends Persona{
	private String correo;
	private ArrayList <Prestamo> listaPrestamos;
	
	//Constructores
	public Usuario(String correo) {
		this.correo = correo;
	}
	public Usuario() {
		this.listaPrestamos = new ArrayList();
	}
	
	public Usuario(String nombre, String identificacion, String correo) {
		super(nombre, identificacion);
		this.correo = correo;
		this.listaPrestamos = new ArrayList();
	}
	
	//Getters y Setters
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	//Metodos
	public void solicitarPrestamo(Libro libro, Usuario usuario, Date fechaPrestamo, Date fechaDevolucion) {//Creacion lista de préstamos
		Prestamo nuevoPrestamo = new Prestamo (libro, usuario, fechaPrestamo, fechaDevolucion);
		listaPrestamos.add(nuevoPrestamo);	
	}
	
	public void devolverLibro(Libro libro) {//Metodo para cuando el usuario devuelva el libro a la biblioteca
		if (libro.isDisponible()==false) {
			libro.setDisponible(true);
			Prestamo prestamo = new Prestamo();
			for(int i=0;i<listaPrestamos.size();i++) {
				prestamo=listaPrestamos.get(i);
				if(prestamo.getLibro().equals(libro)) {
					listaPrestamos.remove(i);
				}
			}
		}
	}
	
        public ArrayList<Prestamo> getPrestamo(){
            return listaPrestamos;
        }
        
        
	@Override
	public String toString() {
		return "Usuario [correo=" + correo + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(correo);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(correo, other.correo);
	}
	
	@Override
	public void mostrarInformacion() {
		System.out.println(super.toString());
		System.out.println("Correo: " + correo);
		System.out.println("Lista de préstamos: ");
		for(int i=0; i<listaPrestamos.size();i++) {
			System.out.println((i+1) + ". " + listaPrestamos.get(i));
		}
	}
}
