package ec.edu.ups.interfaces;

import ec.edu.ups.clases.Libro;

public interface Prestable {
	public void prestar(Libro libro);
	public void devolver(Libro libro);
	public void mostrarInformacion();
}
