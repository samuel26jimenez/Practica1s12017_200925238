/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pseudo_scrabble;

import Fichas_Jugador.Num_Fichas_Simple;

/**
 *
 * @author Samuel
 */
public class Nodo_Us {
    public String id;
    public Nodo_Us sig;
    public Num_Fichas_Simple lista;

    public Nodo_Us(String idt){
        this.id = idt;
        this.lista = new Num_Fichas_Simple();
        this.lista.Reajustar_Fichas_lista();
        //llenar_lista();
        }
    
    /*public void llenar_lista(){
        for(int a=0; a<7; a++){
            lista.Insertar(Lista_Cola_Letras.obtener_char());
        }
    }*/

    public void Establecer(String idt){
        this.id= idt;
    }

    public String Obtener(){
        return id;
    }  
    
    public Num_Fichas_Simple Obtener_Lista(){
        return this.lista;
    }
}


