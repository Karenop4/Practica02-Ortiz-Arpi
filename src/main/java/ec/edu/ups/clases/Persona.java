package ec.edu.ups.clases;

public abstract class Persona {
    private String nombre;
    private String identificacion;
    
    //Constructores

    public Persona(String nombre, String identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
    }

    public Persona(String identificacion) {
        this.identificacion = identificacion;
    }

    public Persona() {
    }
    

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
        return "[Nombre: " + nombre + ", Identificacion: " + identificacion + "]";
    }
}
