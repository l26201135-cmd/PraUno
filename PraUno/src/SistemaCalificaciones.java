import java.util.Scanner;

public class SistemaCalificaciones {
    public static void main(String[] args) {
        Scanner dato = new Scanner(System.in);

        System.out.print("¿Cuántos estudiantes hay en el grupo? ");
        int cantidad = dato.nextInt();

        int[] calificaciones = new int[cantidad];

        for (int i = 0; i < cantidad; i++) {
            do {
                System.out.print("Ingresa la calificación del estudiante " + (i + 1) + ": ");
                calificaciones[i] = dato.nextInt();

                if (calificaciones[i] < 0 || calificaciones[i] > 100) {
                    System.out.println("La calificación debe estar entre 0 y 100.");
                }

            } while (calificaciones[i] < 0 || calificaciones[i] > 100);
        }

        int suma = 0;
        int aprobados = 0;
        int reprobados = 0;

        int mayor = calificaciones[0];
        int menor = calificaciones[0];

        for (int i = 0; i < cantidad; i++) {
            suma += calificaciones[i];

            if (calificaciones[i] > mayor) {
                mayor = calificaciones[i];
            }

            if (calificaciones[i] < menor) {
                menor = calificaciones[i];
            }

            if (calificaciones[i] >= 70) {
                aprobados++;
            } else {
                reprobados++;
            }
        }

        double promedio = (double) suma / cantidad;
        double porcentajeAprobacion = ((double) aprobados / cantidad) * 100;

        System.out.println("\n----- RESULTADOS -----");

        System.out.print("Calificaciones: ");
        for (int i = 0; i < cantidad; i++) {
            System.out.print(calificaciones[i] + " ");
        }

        System.out.println("\n");
        System.out.println("Promedio general: " + promedio);
        System.out.println("Calificación más alta: " + mayor);
        System.out.println("Calificación más baja: " + menor);
        System.out.println("Aprobados: " + aprobados);
        System.out.println("Reprobados: " + reprobados);
        System.out.printf("Porcentaje de aprobación: %.2f%%\n", porcentajeAprobacion);

        dato.close();
    }
}