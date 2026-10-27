import java.util.Scanner;

public class cafeteria {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int clientes = 0;
        int suma = 0;
        int satisfechos = 0;
        int insatisfechos = 0;
        int mayor = 0;
        double promedio;

        // Validar cantidad de clientes
        while (clientes <= 0) {
            System.out.print("Ingrese la cantidad de clientes: ");
            clientes = sc.nextInt();

            if (clientes <= 0) {
                System.out.println("Error. Debe ser mayor que 0.");
            }
        }

        // Registro de calificaciones
        for (int i = 1; i <= clientes; i++) {

            int calificacion = 0;

            // Validar calificación
            while (calificacion < 1 || calificacion > 10) {
                System.out.print("Ingrese la calificación del cliente " + i + " (1-10): ");
                calificacion = sc.nextInt();

                if (calificacion < 1 || calificacion > 10) {
                    System.out.println("Calificación inválida.");
                }
            }

            suma += calificacion;

            if (calificacion >= 7) {
                satisfechos++;
            } else {
                insatisfechos++;
            }

            if (calificacion > mayor) {
                mayor = calificacion;
            }
        }

        promedio = (double) suma / clientes;

        // Evaluación del servicio
        String evaluacion;

        if (promedio >= 8) evaluacion = "Excelente servicio";
        else if (promedio >= 6) {
            evaluacion = "Servicio aceptable";
        } else {
            evaluacion = "Se requiere mejorar el servicio";
        }

        // Reporte final
        System.out.println("\n====== REPORTE FINAL ======");
        System.out.println("Clientes encuestados: " + clientes);
        System.out.println("Suma de calificaciones: " + suma);
        System.out.println("Promedio general: " + promedio);
        System.out.println("Clientes satisfechos: " + satisfechos);
        System.out.println("Clientes insatisfechos: " + insatisfechos);
        System.out.println("Calificación más alta: " + mayor);
        System.out.println("Evaluación del servicio: " + evaluacion);

        sc.close();
    }
}