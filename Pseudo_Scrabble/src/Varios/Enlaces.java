package Varios;

import Diccionario_Simple.Nodo_Dic;
import static Varios.Pseudo_Scrabble.Lista_Diccionario;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Samuel
 */
public class Enlaces {
    
    public Enlaces(){
        
    }
    
    public void Carga_Palabras(String [] Palabras){
        for(int i = 0; i < Palabras.length; i++){
            Lista_Diccionario.insertar_Dic_Pal(new Nodo_Dic(Palabras[i]));
        }
    }
    
    
    
    
}
