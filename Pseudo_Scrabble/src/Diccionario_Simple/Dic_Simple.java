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
public class Dic_Simple {
    Nodo_Dic in;
    //Nodo_Dic fi;
    
   public Dic_Simple(){
       in = null;
       //fi = null;
   }
   
   public void insertar_Dic_Pal(Nodo_Dic x){
       if(vacio_Simple()){
           in = x;
           in.sig1 = null;
       }else{
           Nodo_Dic temp;
           temp = in;
           while(temp.sig1 != null){
               temp = temp.sig1;
           }
           
           temp.sig1 = x;
           temp = temp.sig1;
           temp.sig1 = null;
       }
   }
   
   public void recorre(){
       Nodo_Dic temp;
       temp = in;
       while(temp != null){
           System.out.println(temp.Obtener_dic());
           temp = temp.sig1;
       }
   }
   
   
   Boolean vacio_Simple(){
       if(in == null){
           return true;
       }else {
           return false;
       }
   }
}
