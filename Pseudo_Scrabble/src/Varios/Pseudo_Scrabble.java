package Varios;


import Diccionario_Simple.Dic_Simple;
import Interfaz.Menu_Principal;
import Letras.Cola_Letras;
import Matriz_Ortogonal.Matriz;
import pseudo_scrabble.Jugador_Circular;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Samuel
 */

public class Pseudo_Scrabble {

    /**
     * @param args the command line arguments
     */
    
    
    public static Menu_Principal gui = new Menu_Principal();
    
    
    public static Cola_Letras Lista_Cola_Letras;
    public static Jugador_Circular Lista_Jugador;
    public static Dic_Simple Lista_Diccionario; 
    public static Matriz Matriz_Tablero;
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Enlaces();
        gui.setVisible(true);
        
        
    }    
    
    public static void Enlaces(){
        Lista_Cola_Letras = new Cola_Letras();
        Lista_Jugador = new Jugador_Circular();
        Lista_Diccionario = new Dic_Simple();
        Matriz_Tablero =  new Matriz();
        
    }
}
