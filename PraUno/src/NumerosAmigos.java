import java.util.Scanner;

public class NumerosAmigos {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        final int INICIO = 1;

        int num1, num2;
        char repetir;

        do {

            System.out.print("Ingrese el primer número positivo: ");
            num1 = leer.nextInt();

            while (num1 <= 0) {
                System.out.print("Número no válido. Intente nuevamente: ");
                num1 = leer.nextInt();
            }

            System.out.print("Ingrese el segundo número positivo: ");
            num2 = leer.nextInt();

            while (num2 <= 0) {
                System.out.print("Número no válido. Intente nuevamente: ");
                num2 = leer.nextInt();
            }

            int sumaDiv1 = 0;
            int sumaDiv2 = 0;

            int contadorDiv1 = 0;
            int contadorDiv2 = 0;

            for (int i = INICIO; i < num1; i++) {
                if (num1 % i == 0) {
                    sumaDiv1 += i;
                    contadorDiv1++;
                }
            }

            for (int i = INICIO; i < num2; i++) {
                if (num2 % i == 0) {
                    sumaDiv2 += i;
                    contadorDiv2++;
                }
            }

            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Mostrar suma de divisores");
            System.out.println("2. Mostrar solo si son amigos");
            System.out.print("Opción: ");
            int opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Suma de divisores de " + num1 + ": " + sumaDiv1);
                    System.out.println("Suma de divisores de " + num2 + ": " + sumaDiv2);
                    break;

                case 2:
                    System.out.println("Resultado de la comparación:");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

            if (sumaDiv1 == num2 && sumaDiv2 == num1) {
                System.out.println("Los números son amigos.");
            } else {
                System.out.println("Los números no son amigos.");
            }

            System.out.print("\n¿Desea analizar otra pareja? (s/n): ");
            repetir = leer.next().charAt(0);

        } while (repetir == 's' || repetir == 'S');

        leer.close();
    }
}