import java.util.Scanner;

public class MaquinaExpendedora {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        int opcion;
        int totalRecaudado = 0;
        int unidadesVendidas = 0;

        do {

            System.out.println("\n--- *** ¿QUÉ GUSTAS CONSUMIR? *** ---");
            System.out.println("1. AGUA $15");
            System.out.println("2. JUGO $22");
            System.out.println("3. GALLETAS $18");
            System.out.println("4. SANDWICH $45");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = leer.nextInt();

            switch (opcion) {

                case 1:

                    int num1;
                    while (true) {
                        System.out.print("Ingrese la cantidad de botellas de agua: ");
                        num1 = leer.nextInt();

                        if (num1 > 0) {
                            break;
                        }

                        System.out.println("La cantidad debe ser positiva.");
                    }

                    int importe1 = num1 * 15;

                    System.out.println("Costo total: $" + importe1);

                    totalRecaudado += importe1;
                    unidadesVendidas += num1;

                    if (importe1 < 50) {
                        System.out.println("Compra pequeña");
                    } else if (importe1 <= 100) {
                        System.out.println("Compra mediana");
                    } else {
                        System.out.println("Compra grande");
                    }

                    break;

                case 2:

                    int num2;
                    while (true) {
                        System.out.print("Ingrese la cantidad de botellas de jugo: ");
                        num2 = leer.nextInt();

                        if (num2 > 0) {
                            break;
                        }

                        System.out.println("La cantidad debe ser positiva.");
                    }

                    int importe2 = num2 * 22;

                    System.out.println("Costo total: $" + importe2);

                    totalRecaudado += importe2;
                    unidadesVendidas += num2;

                    if (importe2 < 50) {
                        System.out.println("Compra pequeña");
                    } else if (importe2 <= 100) {
                        System.out.println("Compra mediana");
                    } else {
                        System.out.println("Compra grande");
                    }

                    break;

                case 3:

                    int num3;
                    while (true) {
                        System.out.print("Ingrese la cantidad de galletas: ");
                        num3 = leer.nextInt();

                        if (num3 > 0) {
                            break;
                        }

                        System.out.println("La cantidad debe ser positiva.");
                    }

                    int importe3 = num3 * 18;

                    System.out.println("Costo total: $" + importe3);

                    totalRecaudado += importe3;
                    unidadesVendidas += num3;

                    if (importe3 < 50) {
                        System.out.println("Compra pequeña");
                    } else if (importe3 <= 100) {
                        System.out.println("Compra mediana");
                    } else {
                        System.out.println("Compra grande");
                    }

                    break;

                case 4:

                    int num4;
                    while (true) {
                        System.out.print("Ingrese la cantidad de sandwiches: ");
                        num4 = leer.nextInt();

                        if (num4 > 0) {
                            break;
                        }

                        System.out.println("La cantidad debe ser positiva.");
                    }

                    int importe4 = num4 * 45;

                    System.out.println("Costo total: $" + importe4);

                    totalRecaudado += importe4;
                    unidadesVendidas += num4;

                    if (importe4 < 50) {
                        System.out.println("Compra pequeña");
                    } else if (importe4 <= 100) {
                        System.out.println("Compra mediana");
                    } else {
                        System.out.println("Compra grande");
                    }

                    break;

                case 5:

                    System.out.println("\nGracias por utilizar el programa.");
                    System.out.println("Total recaudado: $" + totalRecaudado);
                    System.out.println("Total de unidades vendidas: " + unidadesVendidas);

                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 5);

        leer.close();
    }
}