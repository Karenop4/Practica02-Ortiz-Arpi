package ec.edu.ups.clases;

import java.util.Objects;

import ec.edu.ups.interfaces.*;

public class Libro implements Prestable{
	private String titulo;
	private String autor;
	private int anho;
	private boolean disponible;
	
	//Constructores
	public Libro(String titulo, String autor, int anho, boolean disponible) {
		this.titulo = titulo;
		this.autor = autor;
		this.anho = anho;
		this.disponible = disponible;
	}

	public Libro() {
	}
	
	//Getters y Setters
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAnho() {
		return anho;
	}

	public void setAnho(int anho) {
		this.anho = anho;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	//sobreescritura de metodos
	@Override
	public void prestar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void devolver() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarInformacion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", anho=" + anho + ", disponible=" + disponible + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(anho, autor, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return anho == other.anho && Objects.equals(autor, other.autor) && Objects.equals(titulo, other.titulo);
	}
	
}
