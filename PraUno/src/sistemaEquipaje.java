import java.util.Scanner;

public class sistemaEquipaje {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            final int PESO_MAXIMO = 30;
            final int PESO_LIGERO = 150;
            final int PESO_MEDIO = 300;
            final int PESO_PESADO = 500;

            System.out.print("Ingresa el nombre del pasajero: ");
            String nombre = sc.nextLine();

            System.out.print("Ingresa el peso de tu equipaje (kg): ");
            double peso = sc.nextDouble();

            int costo = 0;

            if (peso <= 15) {
                costo = 0;
                System.out.println("Pasajero: " + nombre);
                System.out.println("Peso: " + peso + " kg");
                System.out.println("No se aplica cargo extra");
            } else if (peso > 15 && peso <= 20) {
                costo = PESO_LIGERO;
                System.out.println("Pasajero: " + nombre);
                System.out.println("Peso: " + peso + " kg");
                System.out.println("Cargo aplicado: $" + costo);
            } else if (peso > 20 && peso <= PESO_MAXIMO) {
                costo = PESO_MEDIO;
                System.out.println("Pasajero: " + nombre);
                System.out.println("Peso: " + peso + " kg");
                System.out.println("Cargo aplicado: $" + costo);
            } else {
                costo = PESO_PESADO;
                System.out.println("Pasajero: " + nombre);
                System.out.println("Peso: " + peso + " kg");
                System.out.println("Cargo aplicado: $" + costo);
                System.out.println("⚠️ Advertencia: El equipaje supera el peso permitido.");
            }

            sc.close();
        }
    }
