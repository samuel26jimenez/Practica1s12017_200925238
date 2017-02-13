/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Letras;

/**
 *
 * @author Samuel
 */
public class Cola_Letras {

    Nodo_Cola_Letras in;
    Nodo_Cola_Letras fn;

    public Cola_Letras() {
        
    }

    public Boolean vacio_Cola() {
        if (in == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertar_cola(Nodo_Cola_Letras x) {
        if (vacio_Cola()) {
            in = fn = x;
            //in.sig = null;
        } else {
            fn.sig = x;
            fn = x;
            fn.sig = null;
        }
    }

    public char obtener_char() {
        //if ((in != fn) && (in.sig != null)) {
        if(in == null){
            return 0;
        }
        if ((in.sig != null)) {
            Nodo_Cola_Letras temp;
            temp = in;
            in = in.sig;
            char c = temp.get_letter();
            temp.sig = null;          
            temp = null;
            System.out.println(c);
            return c;
        } else {
            char c = in.get_letter();
            in = fn = null;
            System.out.println(c);
            return c;
        }       
    }
    
    public void recorre_Cola(){
        Nodo_Cola_Letras temp;
        temp = in;
        while(temp != null){
            System.out.println(temp.get_letter());
            temp = temp.sig;
        }
    }
}
