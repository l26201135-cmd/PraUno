import java.util.Scanner;

public class CentroMedico {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion;

        int ninos = 0;
        int adolescentes = 0;
        int adultos = 0;
        int adultosMayores = 0;

        int totalPacientes = 0;
        double totalRecaudado = 0;
        double totalDescuentos = 0;

        do {
            System.out.println("\n=== CENTRO MEDICO ===");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Ver reporte");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("Edad del paciente: ");
                    int edad = sc.nextInt();

                    System.out.print("Costo de consulta: $");
                    double costo = sc.nextDouble();

                    double descuento = 0;
                    String categoria;

                    if (edad < 12) {
                        categoria = "Niño";
                        ninos++;
                    } else if (edad <= 17) {
                        categoria = "Adolescente";
                        adolescentes++;
                    } else if (edad <= 59) {
                        categoria = "Adulto";
                        adultos++;
                    } else {
                        categoria = "Adulto Mayor";
                        adultosMayores++;

                        descuento = costo * 0.15;
                        costo -= descuento;
                    }

                    totalPacientes++;
                    totalRecaudado += costo;
                    totalDescuentos += descuento;

                    System.out.println("\nPaciente registrado");
                    System.out.println("Categoria: " + categoria);
                    System.out.println("Descuento: $" + descuento);
                    System.out.println("Pago final: $" + costo);

                    break;

                case 2:
                    System.out.println("\n=== REPORTE GENERAL ===");
                    System.out.println("Total de pacientes: " + totalPacientes);
                    System.out.println("Niños: " + ninos);
                    System.out.println("Adolescentes: " + adolescentes);
                    System.out.println("Adultos: " + adultos);
                    System.out.println("Adultos mayores: " + adultosMayores);
                    System.out.println("Total recaudado: $" + totalRecaudado);
                    System.out.println("Total descuentos: $" + totalDescuentos);

                    if (totalPacientes > 0) {
                        System.out.println("Promedio por paciente: $" +
                                (totalRecaudado / totalPacientes));
                    } else {
                        System.out.println("No hay pacientes registrados.");
                    }
                    break;

                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 3);

        sc.close();
    }
}