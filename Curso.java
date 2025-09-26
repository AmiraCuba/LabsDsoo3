package javaapplication2;
public class Curso {
    private String codigo, nombre;
    private Docente docente;

    public Curso(String codigo, String nombre, Docente docente) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.docente = docente;
    }

    public String getCodigo() { 
        return codigo; 
    }
    public String getNombre() { 
        return nombre; 
    }
    public Docentes getDocente() { 
        return docente; 
    }

    public String toString() {
        return codigo + " - " + nombre + " | Docente: " + docente;
    }
}
