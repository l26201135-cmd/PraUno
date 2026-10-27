import java.util.Scanner;

public class numerosparesimpares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N;

        do {
            System.out.print("Ingrese un número entero positivo: ");
            N = sc.nextInt();
        } while (N <= 0);

        int sumaPares = 0;
        int divisibles3 = 0;
        int sumaPrimos = 0;
        int cantidadPrimos = 0;

        System.out.println("\nNúmeros primos encontrados:");

        for (int i = 1; i <= N; i++) {

            if (i % 2 == 0) {
                sumaPares += i;
            }

            if (i % 3 == 0) {
                divisibles3++;
            }

            boolean esPrimo = true;

            if (i < 2) {
                esPrimo = false;
            } else {
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        esPrimo = false;
                        break;
                    }
                }
            }

            if (esPrimo) {
                System.out.print(i + " ");
                sumaPrimos += i;
                cantidadPrimos++;
            }
        }

        double promedioPrimos = 0;

        if (cantidadPrimos > 0) {
            promedioPrimos = (double) sumaPrimos / cantidadPrimos;
        }

        System.out.println("\n\nSuma de números pares: " + sumaPares);
        System.out.println("Cantidad de números divisibles entre 3: " + divisibles3);
        System.out.println("Promedio de números primos: " + promedioPrimos);

        sc.close();
    }
}