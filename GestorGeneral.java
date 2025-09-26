package javaapplication2;
import java.util.*;
class GestorGeneral {
    private ArrayList<Alumno> alumnos = new ArrayList<>();
    private ArrayList<Docente> docentes = new ArrayList<>();
    private ArrayList<Curso> cursos = new ArrayList<>();
    private ArrayList<Matricula> matriculas = new ArrayList<>();
    private HashMap<String, ArrayList<Double>> notas = new HashMap<>();

    // Registrar Alumno
    public void registrarAlumno(String codigo, String nombres, String apellidos) {
        if (buscarAlumno(codigo) == null) {
            alumnos.add(new Alumno(codigo, nombres, apellidos));
        } else {
            System.out.println("Alumno con código " + codigo + " ya existe.");
        }
    }

    // Registrar Docente
    public void registrarDocente(String dni, String nombres, String apellidos, String esp, int exp) {
        docentes.add(new Docente(dni, nombres, apellidos, esp, exp));
    }

    // Registrar Curso
    public void registrarCurso(String codigo, String nombre, Docente docente) {
        if (buscarCurso(codigo) == null) {
            cursos.add(new Curso(codigo, nombre, docente));
        } else {
            System.out.println("Curso con código " + codigo + " ya existe.");
        }
    }

    // Matricular
    public void matricularAlumno(Alumno alumno, Curso curso, String codigo) {
        matriculas.add(new Matricula(alumno, curso, codigo));
    }

    // Buscar
    public Alumno buscarAlumno(String codigo) {
        for (Alumno alumno : alumnos) 
            if (alumno.getCodigo().equals(codigo)) {
                return alumno;
            }
        return null;
    }

    public Curso buscarCurso(String codigo) {
        for (Curso curso : cursos) 
            if (curso.getCodigo().equals(codigo)) 
                return curso;
        return null;
    }

    // Registrar Notas
    public void registrarNotas(String codigoMatricula, double n1, double n2, double n3) {
        for (Matricula matricula : matriculas) {
            if (matricula.getCodigo().equals(codigoMatricula)) {
                ArrayList<Double> listaNotas = new ArrayList<>();
                listaNotas.add(n1);
                listaNotas.add(n2);
                listaNotas.add(n3);
                notas.put(matricula.getCodigo(), listaNotas);
                return;
            }
        }
        System.out.println("No existe matrícula para ese alumno y curso.");
    }

    public double calcularPromedio(String codigoMatricula){
        ArrayList<Double> listaNotas = notas.get(codigoMatricula);
        if (listaNotas == null || listaNotas.isEmpty()) 
            return 0;
        double suma = 0;
        for (double n : listaNotas) {
            suma += n;
        }
        return suma/listaNotas.size();
    }

    // Mostrar mejor alumno
    public void mostrarMejorAlumno() {
        double max=0;
        Matricula mejor = null;
        for (Matricula m : matriculas) {
            if (calcularPromedio(m.getCodigo()) > max) {
                max = calcularPromedio(m.getCodigo());
                mejor = m;
            }
        }
        if (mejor != null) 
    System.out.println("Mejor alumno: " + mejor.getAlumno().getNombres() + " " 
        + mejor.getAlumno().getApellidos());
    }

    // Listar aprobados y desaprobados
    public void listarResultados(String codigoCurso) {
        Curso curso = buscarCurso(codigoCurso);
        if (curso == null) {
            System.out.println("Curso no encontrado.");
            return;
        }
        System.out.println("Resultados del curso: " + curso.getNombre());
        for (Matricula matricula : matriculas) {
            if (matricula.getCurso().equals(curso)) {
                double prom = calcularPromedio(matricula.getCodigo());
                String estado = (prom >= 11) ? "Aprobado" : "Desaprobado";
                System.out.println(matricula.getAlumno() + " - Promedio: " + prom + " - " + estado);
            }
        }
    }
}
