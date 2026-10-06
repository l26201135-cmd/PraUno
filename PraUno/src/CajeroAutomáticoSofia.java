import java.util.Scanner;

public class CajeroAutomáticoSofia {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        final double LIMITE_RETIRO = 5000;

        double saldo;
        double retiro;
        double nuevoSaldo;

        System.out.print("Ingresa el saldo disponible: ");
        saldo = teclado.nextDouble();

        System.out.print("Ingresa la cantidad que deseas retirar de tu cuenta: ");
        retiro = teclado.nextDouble();

        if (retiro > 0 && retiro <= LIMITE_RETIRO && retiro <= saldo) {

            nuevoSaldo = saldo - retiro;

            System.out.println("Retiro aprovado.");
            System.out.println("Efectivo a dispocisión: $" + retiro);
            System.out.println("Saldo restante: $" + nuevoSaldo);

            if (nuevoSaldo < 500) {
                System.out.println("Advertencia: tu saldo ahora es menor a $500");
            }

        } else {
            System.out.println("Retiro no aprobado.");

            if (retiro <= 0) {
                System.out.println("La cantidad a retirar debe ser mayor a: $0.00");
            }

            if (retiro > LIMITE_RETIRO) {
                System.out.println("La cantidad ingresada supera el límite de retiro máximo: $5000");
            }

            if (retiro > saldo) {
                System.out.println("Lo sentimos, saldo insuficiente");
            }
        }

        teclado.close();
    }
}