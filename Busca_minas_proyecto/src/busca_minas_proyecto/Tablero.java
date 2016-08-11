/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busca_minas_proyecto;
/**
 **
 **@author user Minor Sibaja Calvo 
 **/ // 19/07/2016
public class Tablero {
    private String tablero[][];
    private int minas[][];
    private boolean elegidos[][];
    private int filas;
    private int columnas;
    /**
     **Constructor tablero
     **/
    public Tablero() {
        filas = 6;
        columnas = 6;
        tablero = new String[filas][columnas];// Me va reservar espacios en memoria tipo cadena.
        minas = new int[filas][columnas];// Me va reservar espacios en memoria tipo entero.
        elegidos = new boolean[filas][columnas];
       for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                elegidos[i][j] = false; // Esto me indica que cuando inicio ningun casillero es elegido.
            }
        }  
    }
    /**
     **Este metodo retorna un valor de tipo entero va hacer el valor del random entre 0 y 1.
     **@return
     **/
    public int lanzarDado() {
        int numero = 0;
        do {
            numero = (int) (Math.random() * 10);
        } while (numero < 1 || numero > 6);
        return numero;
    }
    /**
     ** Me va mostrar el numero seleccionado.
     **/
    public void mostrarNumeroAleatorios() {
        for (int i = 0; i < 10; i++) {
            System.out.println("numero:" + lanzarDado());
        }
    }
    /**No va retornar a nada 
     **Si seleccionamos y sale par, entonces asignaremos una mina en esa posicion.
     **/
    public void generarMinas() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (lanzarDado() % 2 == 0) {  // Si se seleccion % significa resta de una division entre enteros o conocido como "mod".
                    minas[i][j] = 1;          //mod resto de la division.0=no hay mina,1= hay mina.
                }
            }
        }
    }
    /**Cantidad de casillas sin minas 
     **
     ** @return
     **/
    public int cantidadCasillerosSinMinas(){
        int contador=0; //Entero contador=0
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) { //Para cero desde la columna.
                if(!tablero[i][j].equals("M")){ //Esto significa <>: diferente  compara los caracteres dentro del objeto 
                    contador++;                //El toString o operador == compara a nivel de objetos, diferencias entre ambos.
                }
            }
        }
        return contador;
    }
    /**Me va limpiar las minas.
     **
     **/
    public void limpiarMinas() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                minas[i][j] = 0;
            }
        }
    }

    /**Solo asigna las casillas donde hay minas y donde no hay minas.
     **Indica la cantida de minas que hay alrededor.
     **
     **/
    public void llenarTablero() {
        generarMinas();                             //Hace un llamado al generarMinas.
        int numMinasAlrededor = 0;                  //Entero numero alrededor.
        for (int i = 0; i < filas; i++) {           //para ir desde hasta filas.
            for (int j = 0; j < columnas; j++) {    //para ir desde columnas.
                if (minas[i][j] == 1) {             //si minas 0 y 1
                    tablero[i][j] = "M";            // retoma el equal o mod que se representa como M, mina.
                } else {                
                    if (i == 0 || i == 5) {
                        if (i == 0) {                //Aqui sumamos todas las casillas que estan en nuestro alrededor, si en la 
                            if (j == 0 || j == 5) {  // casilla hay una mina entonces tiene valor 1, de lo contrario 0.
                                if (j == 0) {                   
                                    tablero[i][j] = "" + (minas[i][j] + minas[i][j + 1] + minas[i + 1][j] + minas[i + 1][j + 1]);
                                }
                                if (j == 5) {
                                    tablero[i][j] = "" + (minas[i][j - 1] + minas[i][j] + minas[i + 1][j - 1] + minas[i + 1][j]);
                                }
                            } else {
                                tablero[i][j] = "" + (minas[i][j - 1] + minas[i][j] + minas[i][j + 1] + minas[i + 1][j - 1] + minas[i + 1][j] + minas[i + 1][j + 1]);
                            }
                        }
                        if (i == 5) {
                            if (j == 0 || j == 5) {
                                if (j == 0) {
                                    tablero[i][j] = "" + (minas[i - 1][j] + minas[i - 1][j + 1] + minas[i][j] + minas[i][j + 1]);
                                }
                                if (j == 5) {

                                    tablero[i][j] = "" + (minas[i - 1][j - 1] + minas[i - 1][j] + minas[i][j - 1] + minas[i][j]);
                                }
                            } else {

                                tablero[i][j] = "" + (minas[i - 1][j - 1] + minas[i - 1][j] + minas[i - 1][j + 1] + minas[i][j - 1] + minas[i][j] + minas[i][j + 1]);
                            }
                        }
                    } else {
                        if (j == 0 || j == 5) {
                            if (j == 0) {
                                tablero[i][j] = "" + (minas[i - 1][j] + minas[i - 1][j + 1] + minas[i][j] + minas[i][j + 1] + minas[i + 1][j] + minas[i + 1][j + 1]);
                            }
                            if (j == 5) {

                                tablero[i][j] = "" + (minas[i - 1][j - 1] + minas[i - 1][j] + minas[i][j - 1] + minas[i][j] + minas[i + 1][j - 1] + minas[i + 1][j]);
                            }
                        } else {
                            tablero[i][j] = "" + (minas[i - 1][j - 1] + minas[i - 1][j] + minas[i - 1][j + 1] + minas[i][j - 1] + minas[i][j] + minas[i][j + 1] + minas[i + 1][j - 1] + minas[i + 1][j] + minas[i + 1][j + 1]);
                        }
                    }
                }
            }
        }
    }
    /**Solo va mostrar por eso su retorno hacia vacio.
     **Metodo mostrar tablero: vacio.
     **/
    public void mostrarTablero() {
        //llenarTablero();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
               if (elegidos[i][j]==false) {        //solo muestra las casillas que el jugador ha elegido.
                    if (j == 5) {                  //El jugador elige la casilla y el tablero muestra el valor dde esa casilla.
                        System.out.println(" [" + tablero[i][j] + "]");
                    } else {
                        System.out.print(" [" + tablero[i][j] + "]");
                    }
                } else {                          //Sino se eligie una casilla, va mostrar "casilla vacia".
                   if (j == 5) {
                       System.out.println(" [ ]");
                    } else {
                        System.out.print(" [ ]");
                    }
                }
            }
        }
    }
    /**Este metodo me va indicar si el casilla es una mina "M"entonces ya no continue con el juego,false.
     **Si el valor de la casilla no es una mina "M" otro numero entonces continue con el jueg,.true.
     ** @param fila
     ** @param columna
     ** @return
     **/
    public boolean voltearCasillero(int fila, int columna) {
        boolean continuar=false;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (i == fila && j == columna) {
                    if(tablero[i][j].equals("M")){   //Nuevamente comparo los caracteres y continua.
                            continuar=false;
                    }else{
                        elegidos[i][j] = true;
                        continuar=true;
                    }
                }
            }
        }
        return continuar;
    }
}
