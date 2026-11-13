import java.util.Scanner;

public class ControlVentas {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        double[][] ventas = new double[3][5];
        double totalEmpresa = 0;
        double mayorVenta = 0;
        int sucursalMayor = 0;

        // Capturar ventas
        for (int sucursal = 0; sucursal < 3; sucursal++) {
            System.out.println("Sucursal " + (sucursal + 1));

            for (int dia = 0; dia < 5; dia++) {
                System.out.print("Venta del día " + (dia + 1) + ": ");
                ventas[sucursal][dia] = teclado.nextDouble();
            }
        }

        // Mostrar tabla
        System.out.println("\nTabla de ventas");
        System.out.println("D1\tD2\tD3\tD4\tD5");

        for (int sucursal = 0; sucursal < 3; sucursal++) {
            System.out.print("S" + (sucursal + 1) + "\t");

            for (int dia = 0; dia < 5; dia++) {
                System.out.print(ventas[sucursal][dia] + "\t");
            }

            System.out.println();
        }

        System.out.println("\nTotal por sucursal:");

        // Total por sucursal y sucursal con mayores ventas
        for (int sucursal = 0; sucursal < 3; sucursal++) {
            double totalSucursal = 0;

            for (int dia = 0; dia < 5; dia++) {
                totalSucursal += ventas[sucursal][dia];
            }

            System.out.println("Sucursal " + (sucursal + 1) + ": " + totalSucursal);

            totalEmpresa += totalSucursal;

            if (totalSucursal > mayorVenta) {
                mayorVenta = totalSucursal;
                sucursalMayor = sucursal + 1;
            }
        }

        System.out.println("\nVentas totales de la empresa: " + totalEmpresa);
        System.out.println("Sucursal con mayores ventas: Sucursal " + sucursalMayor);

        // Promedio por día
        System.out.println("\nPromedio de ventas por día:");

        for (int dia = 0; dia < 5; dia++) {
            double sumaDia = 0;

            for (int sucursal = 0; sucursal < 3; sucursal++) {
                sumaDia += ventas[sucursal][dia];
            }

            double promedio = sumaDia / 3;
            System.out.println("Día " + (dia + 1) + ": " + promedio);
        }

        teclado.close();
    }
}