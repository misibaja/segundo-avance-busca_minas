/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busca_minas_proyecto;
import java.util.Scanner;//libreria scanner
/**
 **
 **@author user Minor Sibaja Calvo
 **///19/07/2016
public class Juego {
    private Tablero T;
    private Scanner leerDato;
    /**
     **Metodo del juego, lee los datos, Scanner.
     */
    public Juego() {
        T = new Tablero();
        leerDato = new Scanner(System.in);
    }
    /**
     **Menu para jugar.
     */
    public void menu() {
        for (;;) {
            System.out.println("---------------------------------");
            System.out.println("     *JUEGO BUSCA MINAS*           ");
            System.out.println("---------------------------------");
            System.out.println("JUGAR.........................[1]");
            System.out.println("SALIR.........................[2]");
            System.out.println("---------------------------------");
            System.out.println("Elige la opcion:");
            System.out.println("---------------------------------");
            int opcion = leerDato.nextInt();
            switch (opcion) {
                case 1:
                    jugar();
                    break;
                case 2:
                    System.exit(0);
            }
        }
    }
    /**El objeto T se crea con el constructor,ahora T es una instancia de la clase tablero.
     **En teoria T puede acceder a los metodos de la clase tablero
     **/
    public void jugar() {
        //System.out.println("Nombre del Jugador: ");
        T.llenarTablero();   //Espacio en memoria tipo cadena. 
        T.mostrarTablero(); //Espacio de menoria tipo entero.
        int fila, columna; //Variable para filas y columnas.
        int aciertos = 0; //Variable aciertos.
        int objetivo=T.cantidadCasillerosSinMinas(); //Este objeto seria volveado oh no mostrado, todas las casillas que tengan minas.
        boolean salir = false;
        System.out.println("cantidad de casillas sin minas: "+T.cantidadCasillerosSinMinas());
        do {
            System.out.println("Elige un casilla : ");
            System.out.println("Ingresando sus coordenadas");
            System.out.println("FILA: ");
            fila = leerDato.nextInt();
            System.out.println("Columna:");
            columna = leerDato.nextInt();
            System.out.println("La casilla elegida es: casilla[" + fila + "][" + columna + "]");
            if (T.voltearCasillero(fila, columna)) { //Si la casilla no es una mina, continua el juego.
                T.mostrarTablero();
                aciertos++;
                System.out.println("ACIERTOS: "+aciertos);//Cada hacierto es cuando volteamos una casilla y el valor que tiene no es una mina.
                if (aciertos ==objetivo ) {               //Entonces si el total de haciertos es igual al objeto indica que se a ganado
                    System.out.println("HAS GANADO EL JUEGO");
                    salir = true;
                }
            } else {
                System.out.println("HAS PERDIDO");
                salir=true;
            }
        } while (!salir);
    }
}
