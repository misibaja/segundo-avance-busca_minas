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
public class espacios {
    private int minasAlrededor;
    private boolean esMina; //variable boolean tipo de valor true / false. el valor determinado es false
    private boolean revelado;
    
    /**
     **Este seria el constructor del espacio
     **/
    public espacios(){
    minasAlrededor =0;
    esMina=false;
    }

    /**
     **Este seria el encargado de decir a un espacio si es mina o no...
     **/
    public void colocarMina(){
    esMina= true;
    }

    /**
     **este se encarga de aumentar el numero de minas alrededor de este espacio
     **/
    public void aumentarMinas(){
    if(esMina==false){
      minasAlrededor++; 
    } 
  } 

    /**
     **Me va indicar si el espacio es una mina o no...
     **/ //metodo para retornar es mina devuelve el valor para evaluar el valor valga la redundancia
    public boolean verMina(){
    return esMina;
    }
    
    /**
     *Indica "si ya visitaste este espacio mientras estas jugando" sirve para saber si uno gana
     * @return
     */
    public boolean verRevelado(){
    return revelado;
    
    }
   
    /**
     *En el momento que visite el espacio el este cambia su estado a revelado
     */
    public void cambiarEstado(){
    revelado=true;
    }
//toString imprime en pantalla cuando le dices System.out.println
    @Override
    public String toString(){
    String res="*";
    if(revelado==true){
        res=""+minasAlrededor;
    }
    if(esMina==true&&revelado==true)
        res="X";
    return res;
    }
    
}



