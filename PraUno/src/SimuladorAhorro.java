import java.util.Scanner;

public class SimuladorAhorro {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        double cantidadInicial;
        double meta;
        double ahorroMensual;
        char repetir;

        do {

            System.out.print("Ingrese la cantidad inicial: ");
            cantidadInicial = leer.nextDouble();

            while (cantidadInicial <= 0) {
                System.out.print("Valor inválido. Ingrese nuevamente: ");
                cantidadInicial = leer.nextDouble();
            }

            System.out.print("Ingrese la meta de ahorro: ");
            meta = leer.nextDouble();

            while (meta <= 0) {
                System.out.print("Valor inválido. Ingrese nuevamente: ");
                meta = leer.nextDouble();
            }

            System.out.print("Ingrese el ahorro mensual: ");
            ahorroMensual = leer.nextDouble();

            while (ahorroMensual <= 0) {
                System.out.print("Valor inválido. Ingrese nuevamente: ");
                ahorroMensual = leer.nextDouble();
            }

            System.out.println("\nSeleccione el plazo:");
            System.out.println("1. 6 meses");
            System.out.println("2. 12 meses");
            System.out.println("3. 24 meses");
            System.out.print("Opción: ");
            int opcion = leer.nextInt();

            int meses = 0;

            switch (opcion) {
                case 1:
                    meses = 6;
                    break;
                case 2:
                    meses = 12;
                    break;
                case 3:
                    meses = 24;
                    break;
                default:
                    System.out.println("Opción no válida. Se usarán 24 meses.");
                    meses = 24;
            }

            double saldo = cantidadInicial;
            double interesesGenerados = 0;
            int mesesNecesarios = 0;
            boolean metaAlcanzada = false;

            for (int i = 1; i <= meses; i++) {

                saldo += ahorroMensual;

                double interes = saldo * 0.01;
                saldo += interes;
                interesesGenerados += interes;

                if (!metaAlcanzada && saldo >= meta) {
                    metaAlcanzada = true;
                    mesesNecesarios = i;
                }
            }

            System.out.println("\nSaldo final: $" + saldo);
            System.out.println("Intereses generados: $" + interesesGenerados);

            if (metaAlcanzada) {
                System.out.println("Sí se alcanzó la meta.");
                System.out.println("Meses necesarios: " + mesesNecesarios);
            } else {
                System.out.println("No se alcanzó la meta.");
            }

            System.out.print("\n¿Desea realizar otra simulación? (s/n): ");
            repetir = leer.next().charAt(0);

        } while (repetir == 's' || repetir == 'S');

        leer.close();
    }
}