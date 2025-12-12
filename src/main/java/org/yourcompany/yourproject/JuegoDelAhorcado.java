/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.yourcompany.yourproject;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author pc
 */
public class JuegoDelAhorcado {

    public static void main(String[] args) {

        String palabras = Obtenerpalabras();
        char[] estado = inicializar(palabras);
        int errores = 0;

        System.out.println("=====Juego del Ahorcado======");
        //  mostrarDibujo(0);
        while (errores < 6 && !palabraCompleta(estado)) {
            mostrarDibujo(errores);
            mostrarEstado(estado);

            char letra = pedirLetra();
            
            boolean acierto = actualizarEstado(estado, palabras, letra);
            if (!acierto) {
                errores++;
                System.out.println("La letra no esta! Error: " + errores);

                if(errores == 6) {
                    mostrarDibujo(errores);
                    System.out.println("La palabra era: " + palabras);
                }
            } else {
                System.out.println("Has acertado");
            }

            System.out.println();
           

        }
       
    }


    /**
     * Metodo que da la palabra aleatoriamente
     * 
     * @return la palabra random del array {@code palabra[posicion]}
     */
    public static String Obtenerpalabras() {
        String[] palabra = { "hola", "cadira", "tisores", "riu", "fotografia", "escala", "llibre", "ordinador",
                "ratoli", "armari", "pati", "programa", "columna" };
        Random random = new Random();
        int posicion = random.nextInt(palabra.length);

        return palabra[posicion];
    }

    /**
     * Metodo que guada los dibujos
     * 
     * @return el array de los dibujos {@code ahorcado}
     */
    public static String[] dibujo() {
        String[] ahorcado = {
                """
                           +---+
                               |
                               |
                               |
                              ===
                        """,
                """
                           +---+
                           O   |
                               |
                               |
                              ===
                        """,
                """
                           +---+
                           O   |
                           |   |
                               |
                              ===
                        """,
                """
                           +---+
                           O   |
                          /|   |
                               |
                              ===
                        """,
                """
                           +---+
                           O   |
                          /|\\  |
                               |
                              ===
                        """,
                """
                           +---+
                           O   |
                          /|\\  |
                          /    |
                              ===
                        """,
                """
                           +---+
                           O   |
                          /|\\  |
                          / \\  |
                              ===
                        """
        };
        return ahorcado;
    }

    public static void mostrarDibujo(int error) {
        String[] dibujos = dibujo();
        
            if (error < 0)
                error = 0;
            if (error >= dibujos.length - 1)
                error = dibujos.length - 1;
            System.out.println(dibujos[error]);
        

    }

    /**
     * Metodo para ingresar los caracteres validos
     * 
     * @return
     */
    public static char pedirLetra() {
        Scanner sc = new Scanner(System.in);
        char letra = 0;
        boolean fin = false;
        while (!fin) {
            System.out.println("introduce una letra (a-z): ");
            String entrada = sc.nextLine().toLowerCase();

            if (entrada.length() == 1) {
                char c = entrada.charAt(0);
                if (c >= 'a' && c <= 'z') {
                    letra = c;
                    fin = true;
                }
            } else {
                System.out.println("Caracter no valido");
            }

        }
        return letra;
    }

    /**
     * Metodo que inializa los espacios de la barra '_'
     * 
     * @param palabra
     * @return nos devuelve el array de caracteres {@code estado}
     */
    public static char[] inicializar(String palabra) {
        char[] estado = new char[palabra.length()];
        for (int i = 0; i < estado.length; i++) {
            estado[i] = '_';
        }
        return estado;
    }

    /**
     * Metodo que muestra el estado
     * 
     * @param estado
     * @param palabra
     * @param letra
     * @return true
     */
    public static boolean actualizarEstado(char[] estado, String palabra, char letra) {
        boolean encontrada = false;

        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == letra) {
                estado[i] = letra;
                encontrada = true;
            }
        }

        return encontrada;
    }

    /**
     * Metodo que muestra el estado recorriendo el array de caracteres
     * 
     * @param estat
     */
    public static void mostrarEstado(char[] estado) {
        for (char c : estado) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    /**
     * Metodo que comprueba si esta completada la palabra
     * 
     * @param estado
     * @return un false si no esta completada y un true si lo esta
     *         {@code completada}
     */
    public static boolean palabraCompleta(char[] estado) {
        for (int i = 0; i < estado.length; i++) {
            if (estado[i] == '_') {
                return false;
            }
        }
        return true;
    }
}
