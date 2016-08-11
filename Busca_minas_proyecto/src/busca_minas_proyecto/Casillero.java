/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busca_minas_proyecto;
/**
 **
 **@author user Minor Sibaja Calvo
 **/ //19/07/2016
//esta clase se encarga de hacer los cuadritos en el busca minas
public class Casillero {
    private int fila;
    private int columna;
    private int numero;
    private boolean elegido;
    /**
     *
     */
    public Casillero() {
        numero=0;        
        fila=0;
        columna=0;
        elegido=false;
    }
    /**
     *
     * @param fila
     * @param columna
     * @param numero
     */
    public Casillero(int fila, int columna, int numero) {
        this.fila = fila;
        this.columna = columna;
        this.numero = numero;
        this.elegido=false;
    }
    /**
     *
     * @return
     */
    public int getColumna() {
        return columna;
    }
    /**
     *
     * @param columna
     */
    public void setColumna(int columna) {
        this.columna = columna;
    }
    /**
     *
     * @return
     */
    public int getFila() {
        return fila;
    }
    /**
     *
     * @param fila
     */
    public void setFila(int fila) {
        this.fila = fila;
    }
    /**
     *
     * @return
     */
    public boolean isElegido() {
        return elegido;
    }
    /**
     *
     * @param elegido
     */
    public void setElegido(boolean elegido) {
        this.elegido = elegido;
    }
    /**
     *
     * @return
     */
    public int getNumero() {
        return numero;
    }
    /**
     *
     * @param numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
}


