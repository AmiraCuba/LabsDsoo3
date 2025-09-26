package javaapplication2;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorGeneral sistema = new GestorGeneral();
        System.out.println("Bienvenido al sistema de gestión académica");
        System.out.println("Ingrese que desea realizar:");
        System.out.println("1. Registrar Docente - 1");
        System.out.println("2. Registrar Alumno - 2");
        System.out.println("3. Registrar Curso - 3");
        System.out.println("4. Matricular Alumno - 4");
        System.out.println("5. Registrar Notas - 5");
        System.out.println("6. Mostrar Mejor Alumno - 6");
        System.out.println("7. Listar Aprobados y Desaprobados - 7");
        System.out.println("8. Salir - 8");
        while (true) {
            System.out.println("Seleccione una opción (1-8):");
            int opcion = sc.nextInt();
            if (opcion==8){
                System.out.println("Saliendo del sistema. ¡Hasta luego!");
                break;
            }
            if (opcion!=8){
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese DNI, Nombres, Apellidos, Especialidad, Experiencia:");
                    String dni = sc.next();
                    String nombresD = sc.next();
                    String apellidosD = sc.next();
                    String esp = sc.next();
                    int exp = sc.nextInt();
                    sistema.registrarDocente(dni, nombresD, apellidosD, esp, exp);
                    break;
                case 2:
                    System.out.println("Ingrese Código, Nombres, Apellidos:");
                    String codigoA = sc.next();
                    String nombresA = sc.next();
                    String apellidosA = sc.next();
                    sistema.registrarAlumno(codigoA, nombresA, apellidosA);
                    break;
                case 3:
                    System.out.println("Ingrese Código del Curso, Nombre del Curso y DNI del Docente:");
                    String codigoC = sc.next();
                    String nombreC = sc.next();
                    String dniDocente = sc.next();
                    Docente docente = null;
                    for (Docente docentes : sistema.docentes) {
                        if (docentes.getDni().equals(dniDocente)) {
                            docente = docentes;
                            break;
                        }
                    }
                    if (docente != null) {
                        sistema.registrarCurso(codigoC, nombreC, docente);
                    } else {
                        System.out.println("Docente no encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Ingrese Código del Alumno, Código del Curso y Código de Matricula:");
                    String codigoAlumno = sc.next();
                    String codigoCurso = sc.next();
                    String codigoMatricula = sc.next();
                    Alumno alumno = sistema.buscarAlumno(codigoAlumno);
                    Curso curso = sistema.buscarCurso(codigoCurso);
                    if (alumno != null && curso != null) {
                        sistema.matricularAlumno(alumno, curso, codigoMatricula);
                    } else {
                        System.out.println("Alumno o Curso no encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("Ingrese Código de Matricula y las tres notas:");
                    String codigoM = sc.next();
                    double n1 = sc.nextDouble();
                    double n2 = sc.nextDouble();
                    double n3 = sc.nextDouble();
                    sistema.registrarNotas(codigoM, n1, n2, n3);
                    break;
                case 6:
                    sistema.mostrarMejorAlumno();
                    break;
                case 7:
                    System.out.println("Ingrese Código del Curso para listar resultados:");
                    String codigoCursoResultados = sc.next();
                    sistema.listarResultados(codigoCursoResultados);
                    break;
                

    }
}
}
}
}