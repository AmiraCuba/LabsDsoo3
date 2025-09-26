package javaapplication2;
public class Alumno {
    private String codigo, nombres, apellidos;

    public Alumno(String codigo, String nombres, String apellidos) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public String getCodigo() { 
        return codigo; 
    }
    public String getNombres() { 
        return nombres; 
    }
    public String getApellidos() { 
        return apellidos; 
    }

    public String toString() {
        return codigo + " - " + nombres + " " + apellidos;
    }
}
