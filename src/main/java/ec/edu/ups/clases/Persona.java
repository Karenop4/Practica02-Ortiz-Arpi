package ec.edu.ups.clases;

public abstract class Persona {
    private String nombre;
    private String identificacion;

    //Getters and setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    
    //Metodos
    
    public abstract void mostrarInformacion();
    
    @Override
    public String toString(){
        return "Persona [nombre: " + nombre + ", identificacion: " + identificacion + "]";
    }
}
