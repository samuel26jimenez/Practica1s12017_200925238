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
public class Ortogonal {
    public char le;
    public int x , y, premio;
   
    public Ortogonal ar;
    public Ortogonal ab;
    public Ortogonal iz;
    public Ortogonal der;
    
    
    public Ortogonal(int X, int Y){ 
        // Punteros
        this.x = X;
        this.y = Y;
        this.ar = null;
        this.ab = null;
        this.iz = null;
        this.der = null;
    }
    
    public void set(char let){
        this.le = let;
    }
    
    public char get(){
        return le;
    }
    
    public void set_Premio(int pre){
        this.premio = pre;        
    }
    
    public int get_Premio(){
        return premio;
    }    
}

