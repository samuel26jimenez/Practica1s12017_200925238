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
    String id;
    Nodo_Us sig;
    Num_Fichas_Simple lista;

    public Nodo_Us(String idt){
        this.id = idt;
        this.lista = new Num_Fichas_Simple();
        }

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


