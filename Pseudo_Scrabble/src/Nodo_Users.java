/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Samuel
 */
public class Nodo_Users {
    String id;
    Nodo_Users sig;
    
    public Nodo_Users(String idt){
        this.id = idt;
    }
    
    public void set_Users(String idt){
        this.id = idt;
    }
    
    public String get_Users(){
        return id;
    } 
}
