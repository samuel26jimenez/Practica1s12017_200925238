/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fichas_Jugador;
import Letras.Cola_Letras;
import Letras.Nodo_Cola_Letras;
/**
 *
 * @author Samuel
 */
public class Num_Fichas_Simple {
    Nodo_Num_Fichas in;
    Nodo_Num_Fichas fi;
    
    Nodo_Cola_Letras letter;
    
    public void Insertar(Nodo_Num_Fichas j){       
        for(int i=0; i <=7; i++){
            j.num_ficha = letter.get_letter();
            in = fi = j;
            fi.sig = j;
            fi = fi.sig;
            fi.sig = null;            
        }
        
        /*
        if(esVacio()){
            in = fi = j;     
        }else{
            fi.sig = j;
            fi = fi.sig;
            fi.sig = null;
        }*/
    }
    
    
    Boolean esVacio(){
        if(in == null){
            return false;
        }else{
            return true;
        }
    }
}
