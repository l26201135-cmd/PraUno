import java.util.Scanner;

public class CentroMedico2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion;

        // Contadores por categoría
        int ninos = 0;
        int adolescentes = 0;
        int adultos = 0;
        int adultosMayores = 0;

        // Acumuladores
        int totalPacientes = 0;
        double totalRecaudado = 0;
        double totalDescuentos = 0;

        do {
            System.out.println("\n=== CENTRO MÉDICO ===");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Ver reporte");
            System.out.println("3. Finalizar");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:

                    System.out.print("Edad del paciente: ");
                    int edad = sc.nextInt();

                    System.out.print("Costo de consulta: $");
                    double costo = sc.nextDouble();

                    String categoria;
                    double descuento = 0;

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

                        descuento = costo * 0.15; // 15% descuento
                        costo -= descuento;
                    }

                    totalPacientes++;
                    totalRecaudado += costo;
                    totalDescuentos += descuento;

                    System.out.println("\nPaciente registrado correctamente");
                    System.out.println("Categoría: " + categoria);
                    System.out.println("Descuento aplicado: $" + descuento);
                    System.out.println("Pago final: $" + costo);

                    break;

                case 2:

                    System.out.println("\n========= REPORTE GENERAL =========");
                    System.out.println("Total de pacientes: " + totalPacientes);

                    System.out.println("\nPacientes por categoría:");
                    System.out.println("Niños: " + ninos);
                    System.out.println("Adolescentes: " + adolescentes);
                    System.out.println("Adultos: " + adultos);
                    System.out.println("Adultos Mayores: " + adultosMayores);

                    System.out.println("\nTotal recaudado: $" + totalRecaudado);
                    System.out.println("Total descuentos aplicados: $" + totalDescuentos);

                    if (totalPacientes > 0) {
                        double promedio = totalRecaudado / totalPacientes;

                        System.out.println(
                                "Promedio pagado por paciente: $" + promedio);

                        System.out.printf(
                                "%% Niños: %.2f%%\n",
                                (ninos * 100.0) / totalPacientes);

                        System.out.printf(
                                "%% Adolescentes: %.2f%%\n",
                                (adolescentes * 100.0) / totalPacientes);

                        System.out.printf(
                                "%% Adultos: %.2f%%\n",
                                (adultos * 100.0) / totalPacientes);

                        System.out.printf(
                                "%% Adultos Mayores: %.2f%%\n",
                                (adultosMayores * 100.0) / totalPacientes);
                    } else {
                        System.out.println("No hay pacientes registrados.");
                    }

                    break;

                case 3:
                    System.out.println("Sistema finalizado.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 3);

        sc.close();
    }
}