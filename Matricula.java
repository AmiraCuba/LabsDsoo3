package javaapplication2;
public class Matricula {
    private Alumno alumno;
    private Curso curso;
    private String codigo;

    public Matricula(Alumno alumno, Curso curso, String codigo) {
        this.alumno = alumno;
        this.curso = curso;
        this.codigo = codigo;
    }
    
    public Alumno getAlumno(){
        return alumno;
    }
    public Curso getCurso(){
        return curso;
    }
    
    public String getCodigo(){
        return codigo;
    }
}