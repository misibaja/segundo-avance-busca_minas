/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busca_minas_proyecto;



/**
 **
 **@author user Minor Sibaja Calvo
 **///19/07/2016
public class buscaminas {

    /**esta  metodo se encarga de llenar el tablero de las minas con espacio vacios
     **
     **@param buscaminas
     **@param i
     **@param j
     **@param c
     **@param f
     **@return
     **/
    public espacios[][] llenarTablero(espacios[][] buscaminas, int i, int j, int c, int f) {
        if(j<f){
         
            if(i<c){ // si esta funcion se cumple el va retomar los valores y va llenar el tablero
                buscaminas[i][j]=new espacios();
                buscaminas=llenarTablero(buscaminas,++i,j,c,f);
            }
            else{
                i=0;
                buscaminas=llenarTablero(buscaminas,i,++j,c,f);
            }
       }
        return buscaminas;// retorna
    }
    
    /**esta metodo se encarga de colocar las minas 
     **
     **@param buscaminas
     **@param n
     **@param f
     **@param c
     **@return
     **/
    public espacios[][] colocarMinas(espacios[][] buscaminas, int n, int c, int f) {
        int azar1=(int)(Math.random()*(c-1)); //se encarga de retornar a un punto flotante, desde el cero() hasta el uno pero sin incluirlo(excluido)
        int azar2=(int)(Math.random()*(f-1));//el cual puede escalar hasta un rango deseado
        if(n>0){
            if(buscaminas[azar1][azar2].verMina()==false){//si se cumple la funcion se van a colocar las minas. ver minas
                buscaminas[azar1][azar2].colocarMina();// igualmente ppero en las columnas
                n--;
            }
            buscaminas=colocarMinas(buscaminas, n, c, f);
        }
        return buscaminas;
    }
    
    /**
     ** este metodo se encarga de averiguar cuantas minas alrededor tiene un espacio en el buscaminas 
     ** la parte mas dificil xD :S
     **@param buscaminas
     **@param i
     **@param j
     **@param c
     **@param f
     **@return
     **/
    public espacios[][] minasAlrededor(espacios[][] buscaminas, int i, int j, int c, int f) {
       
       if(j<f){
            if(i<c){
                if(buscaminas[i][j].verMina()==true){
                    if(i>0){
                        buscaminas[i-1][j].aumentarMinas();
                        if(j>0){
                            buscaminas[i-1][j-1].aumentarMinas();
                        }
                        if(j<f-1){
                            buscaminas[i-1][j+1].aumentarMinas();
                        }
                    }
                    if(i<c-1){
                        buscaminas[i+1][j].aumentarMinas();
                        if(j>0){
                            buscaminas[i+1][j-1].aumentarMinas();
                        }
                        if(j<f-1){
                            buscaminas[i+1][j+1].aumentarMinas();
                        }
                    }
                    if(j>0){
                        buscaminas[i][j-1].aumentarMinas();
                    }
                    if(j<f-1){
                        buscaminas[i][j+1].aumentarMinas();
                    }
                }
                buscaminas=minasAlrededor(buscaminas,++i,j,c,f);
            }
            else{
                i=0;
                buscaminas=minasAlrededor(buscaminas,i,++j,c,f);
            }
        }
        return buscaminas;
    } 

    /**
     *
     * @param buscaminas
     * @param j
     * @param c
     * @param f
     */
    public void imprimir(espacios [][]buscaminas,int j,int c,int f,int i){
        if(j<f){
            if(i<c){
            System.out.print(buscaminas[i][j]+" ");
            imprimir(buscaminas,++i,j,c,f);
        }
            else{
                i=0;
            System.out.println(" ");
            imprimir(buscaminas,i,++j,c,f);
            }
        } 
    }      
    /**este metodo que se encarga de hacer que el usuario juegue con el busca minas 
     **de forma recursiva 
     **@param buscaminas
     **@param columnas
     **@param filas
     **@param contador
     **@return
     **/
    public espacios[][] juego(espacios[][] buscaminas, int columnas, int filas, int contador) {
        
    }
    
}
