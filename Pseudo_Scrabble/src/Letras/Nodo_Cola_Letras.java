/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Letras;

/**
 *
 * @author Samuel
 */
public class Nodo_Cola_Letras {
    char letter;
    Nodo_Cola_Letras sig;
    
    public Nodo_Cola_Letras(char letter){
        this.letter = letter;
    }
    
    public void set_letter(char letter){
        this.letter = letter;
    }
    
    public char get_letter(){
        return letter;
    }
}
