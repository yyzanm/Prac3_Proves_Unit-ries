/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myutils;

/**
 *
 * @author Raúl 
 * Classe de funcions pròpies utils.
 */
public class MyUtils {

    /**
     *
     * @param cadena Strint cadena que es vol invertir
     * @return cadena invertida (null per cadenes nulls).
     */
    public static String inverteix(String cadena) {
        if (cadena == null) {
            return null;
        }
        // Utilitzem StringBuilder per millorar la eficiència en concatenar caràcters.
        StringBuilder resultat = new StringBuilder();
        for (int i = cadena.length() - 1; i >= 0; i--) {
            resultat.append(cadena.charAt(i));
        }
        return resultat.toString();
    }

    /**
     *
     * @param day int dia del naixement
     * @param month int mes del naixement
     * @param year int any del naixement
     * @return edat de la persona, per edat>150 retorna -1, per dates
     * impossibles retorna -2
     *
     */
    public static int edat(int day, int month, int year) {
        // Obtenim la data actual per a comparar-ho amb la data de naixement
        java.util.Calendar now = java.util.Calendar.getInstance();
        int currentYear = now.get(java.util.Calendar.YEAR);
        int currentMonth = now.get(java.util.Calendar.MONTH) + 1; // El mes comença des de 0
        int currentDay = now.get(java.util.Calendar.DAY_OF_MONTH);

        // Comprovem si la data de naixement és vàlida
        if (year < 0 || month < 1 || month > 12 || day < 1 || day > 31 || year > currentYear) {
            return -2; // Data de naixement impossible
        }

        // Calculem l'edat
        int edat = currentYear - year;
        if (month > currentMonth || (month == currentMonth && day > currentDay)) {
            edat--; // No ha fet l'aniversari encara
        }

        // Comprovem si l'edat és vàlida
        if (edat > 150) {
            return -1; // Edat no vàlida
        }

        return edat;
    }

    /**
     *
     * @param numero número del que es calcula el factorial
     * @return retorna el factorial d'un número. Si el nombre es negatiu retorna
     * -1.
     */
    public static double factorial(double numero) {
        if (numero < 0) {
            return -1; // Factorial de nombres negatius no està definit
        }
        if (numero == 0) {
            return 1;
        } else {
            double resultat = numero * factorial(numero - 1);
            return resultat;
        }
    }
}
