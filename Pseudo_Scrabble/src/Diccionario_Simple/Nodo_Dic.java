/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diccionario_Simple;

/**
 *
 * @author Samuel
 */
public class Nodo_Dic {
    String pal;
    Nodo_Dic sig1;
    
    public Nodo_Dic(String pal){
        this.pal = pal;
    }
    
    public void Establecer_dic(String pal){
        this.pal = pal;
    }
    
    public String Obtener_dic(){
        return pal;
    }
}
