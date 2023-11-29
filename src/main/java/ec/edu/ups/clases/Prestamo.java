package ec.edu.ups.clases;

import java.util.Date;

public class Prestamo {
    private Libro libro;
    private Usuario usuario;
    private Date fechaPrestamo;
    private Date fechaDevolucion;

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
    public void calcularDiasPrestamo(){
        
    }
    
    public void esPrestamoVigente(){
        
    }
    
    @Override
    public String toString(){
        return "Prestamo [libro: " + libro + ", usuario: " + usuario + ", fecha prestamo: " + fechaPrestamo + ", fecha devolucion: " + fechaDevolucion + "]";
    }
}
