import java.util.Scanner;

public class Numeros {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        final int DIVISOR = 4;

        int N;
        char repetir;

        do {

            System.out.print("Ingresa un número entero positivo: ");
            N = leer.nextInt();

            while (N <= 0) {
                System.out.print("Número no válido. Inténtalo de nuevo: ");
                N = leer.nextInt();
            }

            int sumaDiv4 = 0;
            int multiplos3 = 0;
            int ambos = 0;

            int pares = 0;
            int impares = 0;
            int multiplos5 = 0;

            for (int i = 1; i <= N; i++) {

                if (i % DIVISOR == 0) {
                    sumaDiv4 += i;
                }

                if (i % 3 == 0) {
                    multiplos3++;
                } else {
                    // requerido por el uso de if-else
                }

                if (i % DIVISOR == 0 && i % 3 == 0) {
                    ambos++;
                }

                if (i % 2 == 0) {
                    pares++;
                } else {
                    impares++;
                }

                if (i % 5 == 0) {
                    multiplos5++;
                }
            }

            System.out.println("\nResultados:");
            System.out.println("Suma de números divisibles entre 4: " + sumaDiv4);
            System.out.println("Cantidad de múltiplos de 3: " + multiplos3);
            System.out.println("Cantidad divisibles entre 3 y 4: " + ambos);

            System.out.println("\n¿Qué deseas ver?");
            System.out.println("1. Números pares");
            System.out.println("2. Números impares");
            System.out.println("3. Múltiplos de 5");
            System.out.print("Opción: ");
            int opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Cantidad de números pares: " + pares);
                    break;
                case 2:
                    System.out.println("Cantidad de números impares: " + impares);
                    break;
                case 3:
                    System.out.println("Cantidad de múltiplos de 5: " + multiplos5);
                    break;
                default:
                    System.out.println("Opción no válida");
            }

            System.out.print("\n¿Deseas hacer otro análisis? (s/n): ");
            repetir = leer.next().charAt(0);

        } while (repetir == 's' || repetir == 'S');

        leer.close();
    }
}