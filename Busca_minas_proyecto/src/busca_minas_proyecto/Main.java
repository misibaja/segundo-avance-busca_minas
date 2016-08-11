/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busca_minas_proyecto;
import javax.swing.JOptionPane; // lo pienso retomar al final para retoques
/**
 **
 **@author user Minor Sibaja Calvo 
 **/ // 19/07/2016
public class Main {
    /**
     **@param args the command line arguments 
     **/
    public static void main(String[] args) {
        Juego juego=new Juego();
        juego.menu();
        juego.jugar();
    }
}
