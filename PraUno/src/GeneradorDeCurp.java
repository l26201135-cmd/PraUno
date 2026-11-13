import java.util.Scanner;

public class GeneradorDeCurp {

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        String nombreCompleto, paterno, materno;
        String fecha, sexo, estado;

        System.out.println("*** GENERADOR DE CURP ***");
        System.out.print("Nombre(s): ");
        nombreCompleto = entrada.nextLine();
        System.out.print("Apellido paterno: ");
        paterno = entrada.nextLine();
        System.out.print("Apellido materno: ");
        materno = entrada.nextLine();
        System.out.print("Fecha de nacimiento (DD/MM/AAAA): ");
        fecha = entrada.nextLine();
        while (!validarFecha(fecha)) {
            System.out.print("Formato incorrecto. Escriba DD/MM/AAAA: ");
            fecha = entrada.nextLine();
        }
        System.out.print("Sexo (H/M): ");
        sexo = entrada.nextLine().trim().toUpperCase();
        while (!sexo.equals("H") && !sexo.equals("M")) {
            System.out.print("Escriba H o M: ");
            sexo = entrada.nextLine().trim().toUpperCase();
        }
        System.out.print("Entidad federativa: ");
        estado = normalizar(entrada.nextLine());
        while (obtenerClaveEstado(estado).equals("XX")) {
            System.out.print("Estado no reconocido. Intente de nuevo: ");
            estado = normalizar(entrada.nextLine());
        }

        String resultado = generarCURP(nombreCompleto, paterno, materno, fecha, sexo, estado);

        System.out.println("\n*** DATOS PROCESADOS ***");
        System.out.println("Nombre(s): " + nombreCompleto);
        System.out.println("Apellido paterno: " + paterno);
        System.out.println("Apellido materno: " + materno);
        System.out.println("Tu CURP generada es: " + resultado);
    }

    static String generarCURP(String nombre, String paterno, String materno, String fecha, String sexo, String estado) {

        String primerNombre = obtenerPrimerNombre(nombre);
        String resultado = "";

        resultado += obtenerPrimeraLetra(paterno);
        resultado += obtenerPrimeraVocal(paterno);
        resultado += obtenerPrimeraLetra(materno);
        resultado += obtenerPrimeraLetra(primerNombre);
        resultado += obtenerFecha(fecha);
        resultado += sexo;
        resultado += obtenerClaveEstado(estado);
        resultado += obtenerPrimeraConsonante(paterno);
        resultado += obtenerPrimeraConsonante(materno);
        resultado += obtenerPrimeraConsonante(primerNombre);
        resultado += generarCamposRandom();

        return resultado;
    }

    static String obtenerPrimerNombre(String nombreCompleto) {
        nombreCompleto = normalizar(nombreCompleto);
        String primerNombre = "";
        for (int i = 0; i < nombreCompleto.length(); i++) {
            if (nombreCompleto.charAt(i) == ' ') {
                break;
            }
            primerNombre += nombreCompleto.charAt(i);
        }
        return primerNombre;
    }

    static String obtenerPrimeraLetra(String palabra) {
        palabra = normalizar(palabra);
        return palabra.substring(0, 1);
    }

    static String obtenerPrimeraVocal(String palabra) {
        palabra = normalizar(palabra);
        for (int i = 1; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);
            if (letra == 'A' || letra == 'E' || letra == 'I' ||
                    letra == 'O' || letra == 'U') {
                return String.valueOf(letra);
            }
        }
        return "X";
    }

    static String obtenerPrimeraConsonante(String palabra) {
        palabra = normalizar(palabra);
        for (int i = 1; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);
            if (letra >= 'A' && letra <= 'Z' &&
                    letra != 'A' && letra != 'E' && letra != 'I' &&
                    letra != 'O' && letra != 'U') {
                return String.valueOf(letra);
            }
        }
        return "X";
    }

    static String obtenerFecha(String fecha) {
        String anio = fecha.substring(8, 10);
        String mes = fecha.substring(3, 5);
        String dia = fecha.substring(0, 2);
        return anio + mes + dia;
    }

    static boolean validarFecha(String fecha) {
        if (fecha.length() != 10 ||
                fecha.charAt(2) != '/' ||
                fecha.charAt(5) != '/') {
            return false;
        }
        for (int i = 0; i < fecha.length(); i++) {
            if (i != 2 && i != 5) {
                if (fecha.charAt(i) < '0' ||
                        fecha.charAt(i) > '9') {
                    return false;
                }
            }
        }

        int dia = Integer.parseInt(fecha.substring(0, 2));
        int mes = Integer.parseInt(fecha.substring(3, 5));
        int año = Integer.parseInt(fecha.substring(6, 10));

        if (año < 1 || mes < 1 || mes > 12 || dia < 1) {
            return false;
        }
        int diasMes = 31;
        if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            diasMes = 30;
        }
        else if (mes == 2) {
            if (año % 400 == 0 ||
                    (año % 4 == 0 && año % 100 != 0)) {
                diasMes = 29;
            } else {
                diasMes = 28;
            }
        }
        if (dia > diasMes) {
            return false;
        }
        return true;
    }

    static String obtenerClaveEstado(String estado) {
        String[] estados = {
                "AGUASCALIENTES", "BAJA CALIFORNIA",
                "BAJA CALIFORNIA SUR", "CAMPECHE",
                "COAHUILA", "COLIMA", "CHIAPAS",
                "CHIHUAHUA", "CIUDAD DE MÉXICO",
                "DURANGO", "GUANAJUATO", "GUERRERO",
                "HIDALGO", "JALISCO", "MÉXICO",
                "MICHOACÁN", "MORELOS", "NAYARIT",
                "NUEVO LEÓN", "OAXACA", "PUEBLA",
                "QUERETARO", "QUINTANA ROO",
                "SAN LUIS POTOSÍ", "SINALOA",
                "SONORA", "TABASCO", "TAMAULIPAS",
                "TLAXCALA", "VERACRUZ", "YUCATÁN",
                "ZACATECAS", "EXTRANJERO",
                "CDMX", "DISTRITO FEDERAL",
                "ESTADO DE MEXICO", "COAHUILA DE ZARAGOZA",
                "VERACRUZ DE IGNACIO DE LA LLAVE"
        };
        String[] claves = {
                "AS", "BC", "BS", "CC", "CL", "CM",
                "CS", "CH", "DF", "DG", "GT", "GR",
                "HG", "JC", "MC", "MN", "MS", "NT",
                "NL", "OC", "PL", "QT", "QR", "SP",
                "SL", "SR", "TC", "TS", "TL", "VZ",
                "YN", "ZS", "NE", "DF", "DF", "MC",
                "CL", "VZ"
        };

        estado = normalizar(estado);
        for (int i = 0; i < estados.length; i++) {
            if (estado.equals(estados[i])) {
                return claves[i];
            }
        }
        return "XX";
    }

    static String generarCamposRandom() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String campos = "";
        for (int i = 0; i < 2; i++) {
            int posicion = (int)(Math.random() * caracteres.length());
            campos += caracteres.charAt(posicion);
        }
        return campos;
    }

    static String normalizar(String texto) {

        texto = texto.trim().toUpperCase();

        texto = texto.replace("Á", "A");
        texto = texto.replace("É", "E");
        texto = texto.replace("Í", "I");
        texto = texto.replace("Ó", "O");
        texto = texto.replace("Ú", "U");
        texto = texto.replace("Ü", "U");
        texto = texto.replace("Ñ", "X");

        return texto;
    }
}