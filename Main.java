package javaapplication2;
public class Main {
    public static void main(String[] args) {
        GestorGeneral sistema = new GestorGeneral();

        // Registrar docentes
        Docente docente1 = new Docente("60435683", "Ana", "Lopez", "Matemáticas", 10);
        sistema.registrarDocente("43258939", "Luis", "Aragones", "Matematicas", 10);

        // Registrar alumnos
        sistema.registrarAlumno("A001", "Carlos", "Lopez");
        sistema.registrarAlumno("A002", "Maria", "Gomez");

        // Registrar curso
        sistema.registrarCurso("C001", "Algebra", docente1);

        // Matricular
        Alumno alumno1 = sistema.buscarAlumno("A001");
        Curso curso1 = sistema.buscarCurso("C001");
        sistema.matricularAlumno(alumno1, curso1, "M001");

        // Registrar notas
        sistema.registrarNotas("M001", 15, 18, 12);

        // Mostrar mejor alumno
        sistema.mostrarMejorAlumno();

        // Listar aprobados y desaprobados
        sistema.listarResultados("C001");
    }
}