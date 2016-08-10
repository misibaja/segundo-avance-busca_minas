/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package busca_minas_proyecto;

import java.util.Scanner;
import javax.swing.JOptionPane; // lo pienso retomar al final para retoques

/**
 **
 **@author user Minor Sibaja Calvo 
 **/ // 19/07/2016
public class Busca_minas_proyecto {
    /**
     **@param args the command line arguments 
     **/
    public static void main(String[] args) {
        // Aqui vamos a implementar la parte de crear objetos necesariso para ejecutar el programa
    Scanner scan=new Scanner(System.in); 
    int filas;
    int columnas;
    int numMinas;
    int c=0;
    int contador;
    espacios [][] buscaminas;
    System.out.println("n"+"n"+"Buscaminas"+"n"+"n");
    System.out.println("Ingrese el numero de filas(6-36): "); // recursividad (""(6-36):)
    filas = scan.nextInt();
    if(filas<6 || filas>36){ //metodo para evaluar las filas van a ser or ....
    filas=10;
    c=0;
    }
    System.out.println("Ingrese el numero de columnas(6-36): ");
    columnas =scan.nextInt();
    if (columnas<6||columnas>36){ //metodo columnas va ser menor a 6 or columnas mayor a 36
    columnas=10;
    c=0;
    c++; // esto significa que el valor de c va ser al valor que se le asigne positivo
    if(c==2){
    System.out.println("n"+"Coordenadas fuera de rango tamaño predeterminado 6x6"+"n");
    }
    }
    numMinas = filas+columnas;
    contador = (filas+columnas)-(numMinas);
    System.out.println("n"+"El numero de minas es: "+numMinas+"n");
    System.out.println("n"+"A jugar!!!"+"n");
    buscaminas=new espacios[columnas][filas];
    buscaminas=new buscaminas().llenarTablero(buscaminas,0,0,columnas,filas);
    buscaminas=new buscaminas().colocarMinas(buscaminas,numMinas,columnas,filas);
    buscaminas=new buscaminas().minasAlrededor(buscaminas,0,0,columnas,filas);
    buscaminas=new buscaminas().juego(buscaminas,columnas,filas,contador);
    }

    
    
}  
