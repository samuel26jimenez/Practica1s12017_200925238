/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matriz_Ortogonal;

/**
 *
 * @author Samuel
 */
public class Matriz {

    Ortogonal i, tempo2;

    public Matriz() {

    }

    public void insertar(Ortogonal nvo_Ndo) {
        if (!esVacio()) {
            i = tempo2 = nvo_Ndo;
        } else {
            Ortogonal tempo;
            Ortogonal tempo3;
            if (nvo_Ndo.y == 0) {
                tempo = i;
                tempo3 = i;
                while (tempo != null) {
                      tempo3 = tempo;
                      tempo = tempo.der;
                }
                
                tempo2 = nvo_Ndo;
                tempo = nvo_Ndo;
                tempo3.der = tempo;
                tempo.iz = tempo3;                
            } else {
                tempo = tempo2;
                tempo3 = tempo2;
                while (tempo != null) {
                    tempo3 = tempo;
                    tempo = tempo.ab;
                }
                tempo = nvo_Ndo;
                tempo3.ab = tempo;
                tempo.ar = tempo3;
            }
        }
    }

    public void apuntador_Hor() {
        Ortogonal in1;
        Ortogonal in2;
        
        Ortogonal baja1;
        Ortogonal baja2;
        
       in1=in2=i;
       while(in1.der != null){
           in2 = in1 ;
           in1 = in1.der;
           baja1 = in2.ab;
           baja2 = in1.ab;
           while(baja1 != null && baja2 != null){
               
               baja1.der = baja2;
               baja2.iz = baja1;
               baja1 = baja1.ab;
               baja2 = baja2.ab;               
           }
       }
    }
    
    

    public Boolean esVacio() {
        if (i == null) {
            return false;
        } else {
            return true;
        }
    }

}
