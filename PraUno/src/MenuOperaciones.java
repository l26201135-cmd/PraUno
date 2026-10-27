import java.util.Scanner;

public class MenuOperaciones {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        int opcion;

        do {

            System.out.println("\n--- ***MENÚ DE OPERACIONES*** ---");
            System.out.println("1. Calcular el cuadrado de un número");
            System.out.println("2. Calcular el cubo de un número");
            System.out.println("3. Determinar si un número es par o impar");
            System.out.println("4. Calcular la suma desde 1 hasta un número");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = leer.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese un número positivo: ");
                    int num1 = leer.nextInt();

                    if (num1 > 0) {
                        System.out.println("El cuadrado es: " + (num1 * num1));
                    } else {
                        System.out.println("El número debe ser positivo.");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese un número positivo: ");
                    int num2 = leer.nextInt();

                    if (num2 > 0) {
                        System.out.println("El cubo es: " + (num2 * num2 * num2));
                    } else {
                        System.out.println("El número debe ser positivo.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese un número: ");
                    int num3 = leer.nextInt();

                    if (num3 % 2 == 0) {
                        System.out.println("El número es par.");
                    } else {
                        System.out.println("El número es impar.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese un número positivo: ");
                    int num4 = leer.nextInt();

                    if (num4 > 0) {
                        int suma = 0;

                        for (int i = 1; i <= num4; i++) {
                            suma += i;
                        }

                        System.out.println("La suma es: " + suma);
                    } else {
                        System.out.println("El número debe ser positivo.");
                    }
                    break;

                case 5:
                    System.out.println("Gracias por utilizar el programa.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 5);

        leer.close();
    }
}