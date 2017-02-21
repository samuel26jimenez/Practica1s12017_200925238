/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista_letras_default;

/**
 *
 * @author Samuel
 */
public class lista_letras {
    nodo_letras ini;
    
    public lista_letras(){
        ini=null;
    }
    
    public void ingresar(nodo_letras nodo){
        if(esVacio()){
            ini = nodo;
        }else{
            nodo_letras tempo;
            nodo_letras tempo2;
            tempo = ini;
            tempo2 = ini;
            
            while(tempo != null){
                tempo2 = tempo;
                tempo = tempo.sig;
            }
            
            tempo = nodo;
            tempo2.sig = tempo;
            tempo.sig = null;
        }
    }
    
    public boolean esVacio(){
        if(ini == null){
            return true;
        }
        return false;
    }
    
    public char get_char_nodo(int pos){
        nodo_letras tempo;
        nodo_letras tempo2;
        tempo = tempo2 = ini;
        int n=0;
        char letra=' ';
        while((tempo != null) && (n < pos)){
            n++;
            tempo2 = tempo;
            tempo = tempo.sig;
        }
        
        if(n == pos){
            letra = tempo.getLetra();
        }
        
        if(tempo.sig != null){
            tempo2.sig = tempo.sig;
            tempo.sig = null;
            tempo = null;
            
        }else{
            tempo2.sig = null;
            tempo = null;
        }
        
        return letra;
    }
    
    public int t_lista(){
        if(!esVacio()){
            nodo_letras tempo;
            tempo = ini;
            int tamaño = 0;
            while(tempo != null){
                tamaño++;
                tempo = tempo.sig;
            }
            return tamaño;
        }
        return 0;
    }
}
