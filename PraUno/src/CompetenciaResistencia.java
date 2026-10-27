import java.util.Scanner;

public class CompetenciaResistencia {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        final int RONDAS = 5;
        char repetir;

        do {

            int participantes;

            System.out.print("Ingrese la cantidad de participantes: ");
            participantes = leer.nextInt();

            while (participantes <= 0) {
                System.out.print("Valor inválido. Intente nuevamente: ");
                participantes = leer.nextInt();
            }

            double mayorDistancia = 0;
            int mejorParticipante = 0;

            int bajo = 0;
            int medio = 0;
            int alto = 0;

            for (int i = 1; i <= participantes; i++) {

                double total = 0;

                System.out.println("\nParticipante " + i);

                for (int j = 1; j <= RONDAS; j++) {

                    double distancia;

                    System.out.print("Distancia de la ronda " + j + ": ");
                    distancia = leer.nextDouble();

                    while (distancia < 0) {
                        System.out.print("Ingrese una distancia válida: ");
                        distancia = leer.nextDouble();
                    }

                    total += distancia;

                    if (distancia < 2) {
                        bajo++;
                    } else if (distancia <= 4) {
                        medio++;
                    } else {
                        alto++;
                    }
                }

                double promedio = total / RONDAS;

                System.out.println("Total recorrido: " + total + " km");
                System.out.println("Promedio: " + promedio + " km");

                if (total > mayorDistancia) {
                    mayorDistancia = total;
                    mejorParticipante = i;
                }
            }

            System.out.println("\nSeleccione una estadística:");
            System.out.println("1. Rondas de rendimiento bajo");
            System.out.println("2. Rondas de rendimiento medio");
            System.out.println("3. Rondas de rendimiento alto");
            System.out.println("4. Mejor participante");
            System.out.print("Opción: ");
            int opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Rondas de rendimiento bajo: " + bajo);
                    break;
                case 2:
                    System.out.println("Rondas de rendimiento medio: " + medio);
                    break;
                case 3:
                    System.out.println("Rondas de rendimiento alto: " + alto);
                    break;
                case 4:
                    System.out.println("Participante con mayor distancia: " + mejorParticipante);
                    System.out.println("Distancia acumulada: " + mayorDistancia + " km");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

            System.out.print("\n¿Desea registrar otra competencia? (s/n): ");
            repetir = leer.next().charAt(0);

        } while (repetir == 's' || repetir == 'S');

        leer.close();
    }
}