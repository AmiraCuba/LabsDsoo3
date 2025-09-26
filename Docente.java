package javaapplication2;
public class Docente {
    private String dni, nombres, apellidos, especialidad;
    private int aniosExp;

    public Docente(String dni, String nombres, String apellidos, String especialidad, int aniosExp) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.especialidad = especialidad;
        this.aniosExp = aniosExp;
    }

    public String getNombres() { 
        return nombres; 
    }
    public String getApellidos() { 
        return apellidos; 
    }
    
    public String toString() {
        return nombres + " " + apellidos + " (" + especialidad + ")";
    }
}
