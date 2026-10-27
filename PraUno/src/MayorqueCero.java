import java.util.Scanner;

public class MayorqueCero {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        final int MINIMO = 1;
        char respuesta;

        do {

            int numero;

            while (true) {
                System.out.print("Ingrese un número entero positivo mayor que 0: ");
                numero = sc.nextInt();

                if (numero >= MINIMO) {
                    break;
                }

                System.out.println("Error: el número debe ser mayor que 0.");
            }

            int sumaPares = 0;
            int sumaImpares = 0;
            int contadorPares = 0;
            int contadorImpares = 0;

            for (int i = 1; i <= numero; i++) {

                if (i % 2 == 0) {
                    sumaPares += i;
                    contadorPares++;
                } else {
                    sumaImpares += i;
                    contadorImpares++;
                }
            }

            System.out.println("\nRESULTADOS");
            System.out.println("Suma de pares: " + sumaPares);
            System.out.println("Cantidad de pares: " + contadorPares);
            System.out.println("Suma de impares: " + sumaImpares);
            System.out.println("Cantidad de impares: " + contadorImpares);

            System.out.print("\n¿Desea realizar otro cálculo? (S/N): ");
            respuesta = sc.next().toUpperCase().charAt(0);

        } while (respuesta == 'S');

        System.out.println("Programa finalizado.");
        sc.close();
    }
}