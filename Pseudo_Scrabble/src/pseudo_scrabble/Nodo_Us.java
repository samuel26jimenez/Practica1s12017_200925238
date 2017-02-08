/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pseudo_scrabble;

/**
 *
 * @author Samuel
 */
public class Nodo_Us {
    String id;
    Nodo_Us sig;

    public Nodo_Us(String idt){
        this.id = idt;
        }

    public void Establecer(String idt){
        this.id= idt;
    }

    public String Obtener(){
        return id;
    }  
}


