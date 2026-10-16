import java.util.Scanner;

public class ComisionBanco{

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        final double COMISION = 10;
        final double LIMITE_RETIRO = 5000;

        double saldo;
        double retiro;

        System.out.print("Ingresa tu saldo: ");
        saldo = teclado.nextDouble();

        System.out.print("Ingrese catidad de retiro: ");
        retiro = teclado.nextDouble();

        if (retiro > 0 && retiro <= LIMITE_RETIRO && saldo >= retiro + COMISION) {

            double montoComision;
            double saldoFinal;

            montoComision = COMISION;
            saldoFinal = saldo - retiro - montoComision;

            System.out.println("\n**** RETIRO APROBADO ****");
            System.out.println("Monto de retiro: $" + retiro);
            System.out.println("Comisión: $" + montoComision);
            System.out.println("Saldo final: $" + saldoFinal);

        } else {
            System.out.println("\nRetiro no aprobado.");

            if (retiro <= 0) {
                System.out.println("El monto de retiro debe ser mayor que: $0.00.");
            }

            if (retiro > LIMITE_RETIRO) {
                System.out.println("Lo sentimos, su retiro máximo es de: $5000.0");
            }

            if (saldo < retiro + COMISION) {
                System.out.println("Lo sentimos, saldo insuficiente");
                System.out.println("Lo sentimos, saldo insuficiente");
            }
        }

        teclado.close();
    }
}
//