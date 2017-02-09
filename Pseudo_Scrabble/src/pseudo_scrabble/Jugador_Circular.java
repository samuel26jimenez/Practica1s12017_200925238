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

    public Jugador_Circular() {
        i=f=null;
    }

    public int Inserta_jugador(Nodo_Us nuevo_Ju) {
        if (Vacio_Circular()) {
            i = f = nuevo_Ju;
            return 1;
        } else {
            
            if (Ju_repetido(nuevo_Ju)) {
                f.sig = nuevo_Ju;
                nuevo_Ju.sig = i;
                //f = f.sig;
                f = nuevo_Ju;
                return 1;
            }else{
                //el usuario es repetido                
                System.out.println("Usuario Repetido");
                return 0;
            }
        }
        
    }

    public void Recorre_Ju_Circular() {
        Nodo_Us tem = i;
        while (tem != f) {
            System.out.println("Jugador: " + tem.Obtener());
            tem = tem.sig;
        }
        System.out.println("Jugador Final: " + tem.Obtener());
    }

    public Boolean Ju_repetido(Nodo_Us nuevo_Ju) {
        Nodo_Us temp = i;
        while (temp != f) {
            if (temp.id.toString().equals(nuevo_Ju.id.toString())) {
                return false;
            }
            temp = temp.sig;
        }
        if (temp.id.toString().equals(nuevo_Ju.id.toString())) {
            return false;
        }
        return true;
        /*Nodo_Us tempo2;
         tempo2 = i;
         while(tempo2.id.toString().equals(nuevo_Ju.id.toString())){
         System.out.println("Nombre Repetido");
         Inserta_jugador(nuevo_Ju);
         }*/
    }

    Boolean Vacio_Circular() {
        if (i == null) {
            return true;
        } else {
            return false;
        }
    }

}
