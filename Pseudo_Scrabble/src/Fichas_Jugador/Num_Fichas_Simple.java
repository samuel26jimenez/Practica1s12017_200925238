/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fichas_Jugador;
import  Pseudo_Scrabble.*;
import Letras.Cola_Letras;
import Letras.Nodo_Cola_Letras;
/**
 *
 * @author Samuel
 */
public class Num_Fichas_Simple {
    Nodo_Num_Fichas in;
    Nodo_Num_Fichas fi;
    
    public int contar = 0;
    
    public Cola_Letras letter;
    Nodo_Num_Fichas lis;
    
    public void Insertar(char c){       
        //Pseudo_Scrabble.gui.ij.llamar;

        lis = new Nodo_Num_Fichas(c);
        
        if (!esVacio()) {
            in = fi = lis;
        } else {
            fi.sig = lis;
            fi = fi.sig;
            fi.sig = null;
        }
        contar++;
        
        /*
        for(int i = 0; i < 7; i++) {
            char c = letter.obtener_char();
            lis = new Nodo_Num_Fichas(c);
            if (esVacio()) {
                in = fi = lis;
            } else {
                fi.sig = lis;
                fi = fi.sig;
                fi.sig = null;
            }
        }
                */
    }
    
    public void Eliminar_ficha_usu(char elim){
        Nodo_Num_Fichas aux = in;
        Nodo_Num_Fichas aux2 = in;
        while(aux != null){
            if(elim == aux.num_ficha){
                contar--;
                if(in.sig == null ){
                    in = fi = null;
                }else if(aux == in){
                    in = aux.sig;
                    aux.sig = null;
                    aux = null;
                }else if(aux == fi){
                    fi = aux2;
                    fi.sig = null;
                }else{
                    aux2.sig = aux.sig;
                    aux.sig = null;
                    aux = null;
                }
                return;
            }
            aux2 = aux;
            aux = aux.sig;
        }
    }
    
    
    public int Contador_Fichas(){
        Nodo_Num_Fichas temp;
        temp = in;
        int contador=0;
        while(temp != null){
            contador =+ 1;
            temp = temp.sig;
        }
        return contador;
    }
    
    public void Reajustar_Fichas_lista(){
        if( !letter.vacio_Cola() && Contador_Fichas() < 7){
            for(int i = Contador_Fichas(); i <= 7; i++ ){
                 char c = letter.obtener_char();
             lis = new Nodo_Num_Fichas(c);
                if (esVacio()) {
                    in = fi = lis;
                } else {
                    fi.sig = lis;
                    fi = fi.sig;
                    fi.sig = null;
                }   
            }
        }
        else{
            System.out.print("Cola Vacia" + "ó" + "Esta Llena");
        }
    }
    
    public void Recorre_simple(){
        Nodo_Num_Fichas aux = in;
        while(aux != fi){
            aux = aux.sig;
            System.out.println("maximo 7 fichas");
        }
        System.out.println("Lista_LLena");
    }
    
    public void Recorre_simple_lista(){
        Nodo_Num_Fichas aux = in;
        if(!esVacio()){
            System.out.println("Vacia la lista");
            return;
        }
        while(aux != null){
            System.out.println(aux.num_ficha );
            aux = aux.sig;
        }
        System.out.println("00000000000000000000000000000000");
    }
    
    Boolean esVacio(){
        if(in == null){
            return false;
        }else{
            return true;
        }
    }
}
