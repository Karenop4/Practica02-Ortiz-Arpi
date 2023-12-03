package ec.edu.ups.clases;

import java.util.Date;
import java.util.Objects;

public class Prestamo {
    private Libro libro;
    private Usuario usuario;
    private Date fechaPrestamo;
    private Date fechaDevolucion;

    //Constructores

    public Prestamo(Libro libro, Usuario usuario, Date fechaPrestamo, Date fechaDevolucion) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Prestamo() {
    }
    
    
    //Getters and setters
    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    
    //Metodos
    public int calcularDiasPrestamo(){
        int a = fechaDevolucion.getYear()-fechaPrestamo.getYear();
        int m = fechaDevolucion.getMonth()-fechaPrestamo.getMonth();
        if(m<0){
            m=m+12;
            a--;
        }
        int d = fechaDevolucion.getDay()-fechaPrestamo.getDay();
        if (d<0) {
            d=d+30;
            m--;
        }
        if(m<0){
            m=m+12;
            a--;
        }
        return (a*365)+(m*30)+d;
    }
    
    public boolean esPrestamoVigente(){
        Date fechaHoy = new Date();
        return fechaHoy.before(fechaDevolucion);
    }
    
    @Override
    public String toString(){
        return "Prestamo [libro: " + libro + ", usuario: " + usuario + ", fecha prestamo: " + fechaPrestamo + ", fecha devolucion: " + fechaDevolucion + "]";
    }

	@Override
	public int hashCode() {
		return Objects.hash(libro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prestamo other = (Prestamo) obj;
		return Objects.equals(libro, other.libro);
	}
    
    
}
