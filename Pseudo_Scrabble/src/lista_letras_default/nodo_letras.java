/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista_letras_default;

/**
 *
 * @author Samuel
 */
public class nodo_letras {
    char letra;
    nodo_letras sig;
    
    public nodo_letras(char letra){
        this.letra = letra;
    }
    
    public char getLetra(){
        return letra;
    }
}
