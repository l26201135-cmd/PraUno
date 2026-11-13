import java.util.Scanner;

public class GeneradorDeCurp {

    // Metodo para obtener la primera letra
    public static char obtenerPrimeraLetra(String texto) {
        return Character.toUpperCase(texto.charAt(0));
    }

    // Metodo para obtener la primera vocal interna
    public static char obtenerPrimeraVocal(String texto) {

        texto = texto.toUpperCase();

        for (int i = 1; i < texto.length(); i++) {

            char letra = texto.charAt(i);

            if (letra == 'A' || letra == 'E' || letra == 'I'
                    || letra == 'O' || letra == 'U') {

                return letra;
            }
        }

        return 'X';
    }

    // Metodo para obtener la primera consonante interna
    public static char obtenerPrimeraConsonante(String texto) {

        texto = texto.toUpperCase();

        for (int i = 1; i < texto.length(); i++) {

            char letra = texto.charAt(i);

            if (letra != 'A' && letra != 'E' && letra != 'I'
                    && letra != 'O' && letra != 'U') {

                return letra;
            }
        }

        return 'X';
    }

    // Metodo para separar dia, mes y año
    public static String[] obtenerFecha(String fecha) {

        String datos[] = fecha.split("/");

        return datos;
    }

    // Metodo para obtener la clave del estado
    public static String obtenerClaveEstado(String estado) {

        estado = estado.toUpperCase();

        if (estado.equals("HIDALGO")) {
            return "HG";
        } else if (estado.equals("PUEBLA")) {
            return "PL";
        } else if (estado.equals("VERACRUZ")) {
            return "VZ";
        } else if (estado.equals("TLAXCALA")) {
            return "TL";
        } else if (estado.equals("JALISCO")) {
            return "JC";
        } else {
            return "NE";
        }
    }

    // Metodo para generar la CURP
    public static String generarCURP(String nombre,
                                     String apellidoPaterno,
                                     String apellidoMaterno,
                                     String fecha,
                                     String sexo,
                                     String estado) {

        String datos[] = obtenerFecha(fecha);

        String dia = datos[0];
        String mes = datos[1];
        String anio = datos[2].substring(2);

        String curp = "";

        curp += obtenerPrimeraLetra(apellidoPaterno);
        curp += obtenerPrimeraVocal(apellidoPaterno);
        curp += obtenerPrimeraLetra(apellidoMaterno);
        curp += obtenerPrimeraLetra(nombre);

        curp += anio;
        curp += mes;
        curp += dia;

        curp += sexo.toUpperCase();

        curp += obtenerClaveEstado(estado);

        curp += obtenerPrimeraConsonante(apellidoPaterno);
        curp += obtenerPrimeraConsonante(apellidoMaterno);
        curp += obtenerPrimeraConsonante(nombre);

        // Dos caracteres finales
        curp += "A1";

        return curp;
    }

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        String nombre;
        String apellidoPaterno;
        String apellidoMaterno;
        String fecha;
        String sexo;
        String estado;
        String curp;

        System.out.println("====== GENERADOR DE CURP ======");

        System.out.print("Ingresa tu nombre o nommbres por favor: ");
        nombre = teclado.nextLine();

        System.out.print("Ingresa tu apellido paterno por favor: ");
        apellidoPaterno = teclado.nextLine();

        System.out.print("Ingresa tu apellido materno por favor: ");
        apellidoMaterno = teclado.nextLine();

        System.out.print("Ingresa tu fecha de nacimiento (dd/mm/aaaa): ");
        fecha = teclado.nextLine();

        System.out.print("Ingresa tu sexo (Hombre/Mujer): ");
        sexo = teclado.nextLine();

        System.out.print("Ingresa tu entidad federativa: ");
        estado = teclado.nextLine();

        curp = generarCURP(nombre, apellidoPaterno,
                apellidoMaterno, fecha, sexo, estado);

        System.out.println();
        System.out.println("CURP GENERADA: " + curp);

        teclado.close();
    }
}