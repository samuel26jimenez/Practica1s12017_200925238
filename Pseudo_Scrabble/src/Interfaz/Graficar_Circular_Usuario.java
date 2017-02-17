/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Matriz_Ortogonal.Ortogonal;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import pseudo_scrabble.Nodo_Us;

/**
 *
 * @author Samuel
 */
public class Graficar_Circular_Usuario {
    Nodo_Us reco;
    
    File arc = new File("a.dot");
    FileWriter fw;
    PrintWriter pw;

    public Graficar_Circular_Usuario(Nodo_Us i, Nodo_Us f) throws IOException {
         
        Nodo_Us a;        
        this.fw = new FileWriter("a.dot");
        pw = new PrintWriter(fw);
        pw.println("digraph G{\n");        
        a= i;
        while(a != f){
            pw.println("nodo" + a.hashCode() + " -> nodo" + a.sig.hashCode());
            pw.println("{rank = same; nodo" + a.hashCode() + " nodo" + a.sig.hashCode()+ "}\n" );
            pw.println("nodo" + a.hashCode() + "[ label = \"" + a.id );
            pw.println("\", style=filled, fillcolor=\"#00FFFF\"]\n"); 
            pw.println();
            
        }
            pw.println("nodo" + a.hashCode() + "nodo" + a.sig.hashCode());
            pw.println("{rank = same; nodo" + a.hashCode() + " nodo" + a.sig.hashCode()+ "}\n" );
            pw.println("nodo" + a.hashCode() + "[ label = \"" + a.id );
            pw.println("\", style=filled, fillcolor=\"#00FFFF\"]\n"); 
            pw.println("}");        
            Process proceso = Runtime.getRuntime().exec("cmd /c dot -Tpng a.dot > a.png ");
    }
    
    
    
    
    
    
    
    
    
    
    
    public Boolean esVacio(){
        if( reco == null){
            return true;
        }else{
            return false;
        }
    }
    
    
    
}
