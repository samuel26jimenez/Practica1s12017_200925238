/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fichas_Jugador;

/**
 *
 * @author Samuel
 */
public class Nodo_Num_Fichas {
    public char num_ficha;
    public Nodo_Num_Fichas sig;
    
    public Nodo_Num_Fichas(char ficha){
        this.num_ficha = ficha;
    }
    /*
    public void setFicha(char ficha){
        this.num_ficha = ficha;
    }
    
    public char getFicha(){
        return num_ficha;
    }
    */

    public char getNum_ficha() {
        return num_ficha;
    }

    public void setNum_ficha(char num_ficha) {
        this.num_ficha = num_ficha;
    }

    public Nodo_Num_Fichas getSig() {
        return sig;
    }

    public void setSig(Nodo_Num_Fichas sig) {
        this.sig = sig;
    }
    
    
}
