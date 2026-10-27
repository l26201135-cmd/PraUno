import java.util.Scanner;

public class Gasolinera {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion;
        int numCargas = 0;
        int cargasConDescuento = 0;

        double totalLitros = 0;
        double totalCobrado = 0;
        double totalDescuento = 0;


        do {
            System.out.println("\n=== GASOLINERA ===");
            System.out.println("1. Registrar carga");
            System.out.println("2. Ver reporte");
            System.out.println("3. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("Litros cargados: ");
                    double litros = sc.nextDouble();

                    if (litros <= 0) {
                        System.out.println("Cantidad de litros no valida.");
                        break;
                    }

                    System.out.print("Precio por litro: ");
                    double precio = sc.nextDouble();

                    double importe = litros * precio;
                    double descuento = 0;

                    if (litros >= 40) {
                        descuento = importe * 0.05;
                        cargasConDescuento++;
                    }

                    double totalPagar = importe - descuento;

                    System.out.println("\n--- TICKET ---");
                    System.out.println("Importe: $" + importe);
                    System.out.println("Descuento: $" + descuento);
                    System.out.println("Total a pagar: $" + totalPagar);

                    numCargas++;
                    totalLitros += litros;
                    totalCobrado += totalPagar;
                    totalDescuento += descuento;
                    break;

                case 2:
                    System.out.println("\n===== REPORTE =====");
                    System.out.println("Numero de cargas: " + numCargas);
                    System.out.println("Cargas con descuento: " + cargasConDescuento);
                    System.out.println("Total de litros vendidos: " + totalLitros);
                    System.out.println("Total cobrado: $" + totalCobrado);
                    System.out.println("Total descuentos: $" + totalDescuento);

                    if (numCargas > 0) {
                        System.out.println("Promedio por carga: $" + (totalCobrado / numCargas));
                    } else {
                        System.out.println("Aun no hay cargas registradas.");
                    }
                    break;

                case 3:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 3);

        sc.close();
    }
}