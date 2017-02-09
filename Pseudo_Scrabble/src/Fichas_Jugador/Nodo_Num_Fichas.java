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
    char num_ficha;
    Nodo_Num_Fichas sig;
    
    public Nodo_Num_Fichas(char ficha){
        this.num_ficha = ficha;
    }
    
    public void setFicha(char ficha){
        this.num_ficha = ficha;
    }
    
    public char getFicha(){
        return num_ficha;
    }
}
