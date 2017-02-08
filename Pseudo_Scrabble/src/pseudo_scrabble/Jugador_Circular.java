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
public class Jugador_Circular {
    
  Nodo_Us i;
  Nodo_Us f;
  
  public Jugador_Circular(Nodo_Us in, Nodo_Us fi){
      this.i = in;
      this.f = fi;
  }
    
  public void Inserta_jugador(Nodo_Us nuevo_Ju){      
   if(Vacio_Circular()){
       i = f = nuevo_Ju;
        }else{
       f.sig = nuevo_Ju;
       nuevo_Ju.sig = i;
       //f = f.sig;
       f = nuevo_Ju;
    }      
  }
  
  public void Recorre_Ju_Circular(){
      Nodo_Us tem = i;
      while(tem != f){
          System.out.println("Jugador: " + tem.Obtener());
          tem = tem.sig;
      }
      System.out.println("Jugador Final: " + tem.Obtener());
      
  }
  
  Boolean Vacio_Circular(){
      if(i == null){
          return true;
      }else{
          return false;
      }
  }
  
    
}

