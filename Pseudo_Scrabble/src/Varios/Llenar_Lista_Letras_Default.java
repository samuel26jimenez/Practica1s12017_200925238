/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Varios;
import static Varios.Pseudo_Scrabble.Lista_Letras;
import lista_letras_default.nodo_letras;

/**
 *
 * @author Samuel
 */
public class Llenar_Lista_Letras_Default {
    
    public Llenar_Lista_Letras_Default(){
        
    }
    
    public void llenar_lista(){
        for(int a=0; a<12; a++){
            Lista_Letras.ingresar(new nodo_letras(1,'A'));
        }
        for(int a=0; a<12; a++){
            Lista_Letras.ingresar(new nodo_letras(1,'E'));
        }
        for(int a=0; a<9; a++){
            Lista_Letras.ingresar(new nodo_letras(1,'O'));
        }
        for(int a=0; a<6; a++){
            Lista_Letras.ingresar(new nodo_letras(1,'I'));
        }
        for(int a=0; a<6; a++){
            Lista_Letras.ingresar(new nodo_letras(1,'S'));
        }
        for(int a=0; a<5; a++){
            Lista_Letras.ingresar(new nodo_letras(1,'N'));
        }
        for(int a=0; a<4; a++){
            Lista_Letras.ingresar(new nodo_letras(1,'L'));
        }
        for(int a=0; a<5; a++){
            Lista_Letras.ingresar(new nodo_letras(1,'R'));
        }
        for(int a=0; a<5; a++){
            Lista_Letras.ingresar(new nodo_letras(1,'U'));
        }
        for(int a=0; a<4; a++){
            Lista_Letras.ingresar(new nodo_letras(1,'T'));
        }
        for(int a=0; a<5; a++){
            Lista_Letras.ingresar(new nodo_letras(2,'D'));
        }
        for(int a=0; a<2; a++){
            Lista_Letras.ingresar(new nodo_letras(2,'G'));
        }
        for(int a=0; a<4; a++){
            Lista_Letras.ingresar(new nodo_letras(3,'C'));
        }
        for(int a=0; a<2; a++){
            Lista_Letras.ingresar(new nodo_letras(3,'B'));
        }
        for(int a=0; a<2; a++){
            Lista_Letras.ingresar(new nodo_letras(3,'M'));
        }
        for(int a=0; a<2; a++){
            Lista_Letras.ingresar(new nodo_letras(3,'P'));
        }
        for(int a=0; a<2; a++){
            Lista_Letras.ingresar(new nodo_letras(4,'H'));
        }
            
        Lista_Letras.ingresar(new nodo_letras(4,'F'));
        Lista_Letras.ingresar(new nodo_letras(4,'V'));
        Lista_Letras.ingresar(new nodo_letras(4,'Y'));        
        Lista_Letras.ingresar(new nodo_letras(5,'Q'));        
        Lista_Letras.ingresar(new nodo_letras(8,'J'));        
        Lista_Letras.ingresar(new nodo_letras(8,'Ñ'));        
        Lista_Letras.ingresar(new nodo_letras(8,'X'));        
        Lista_Letras.ingresar(new nodo_letras(10,'Z'));
    }
}
