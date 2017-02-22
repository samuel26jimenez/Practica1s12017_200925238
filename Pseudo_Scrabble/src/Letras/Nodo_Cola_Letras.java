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
    int puntos;
    char letter;
    Nodo_Cola_Letras sig;
    
    public Nodo_Cola_Letras(int puntos, char letter){
        this.puntos = puntos;
        this.letter = letter;
    }
    
    public void set_letter(char letter){
        this.letter = letter;
    }
    
    public char get_letter(){
        return letter;
    }
    
    public int get_puntos(){
        return puntos;
    }
}
