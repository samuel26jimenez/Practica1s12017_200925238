/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Letras;

import Diccionario_Simple.Dic_Simple;
import Diccionario_Simple.Nodo_Dic;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samuel
 */
public class Cola_Letras {

    public Nodo_Cola_Letras in;
    public Nodo_Cola_Letras fn;

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
    
    
    StringBuffer concat;

    public void Grafico_Ficha_Pend() {
        try {            
            String pInput = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "fichas_pend.txt";
            String pOutput = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "fichas_pend.jpg";

            concat = new StringBuffer();
            concat.append("\nDigraph G {\n");

            Nodo_Cola_Letras tempo = in;
            int num=0, num2=0;// si te eescucho bien...            
            while (tempo != null) {//en vez de null va fin
                concat.append("Nodo" + num + "[label=\"" + tempo.get_letter() + "\", style=filled];\n");                
                tempo = tempo.sig;
                num++;
            }                        

            while (num2 < (num-1)) {//en vez de (num-1) solo va num
                concat.append("Nodo" + num2 + " -> Nodo" + (num2 + 1) + ";\n");
                concat.append("{rank=same; Nodo" + num2 + " Nodo" + (num2 + 1) + "}\n");
                num2++;//201314038@ingenieria.usac.edu.gt
            }

            
            concat.append("}");
            escribir_archivo(pInput, concat.toString());

            try {
                //direccion donde se encuentra el dot.exe
                String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
                String fileInputPath = pInput;
                String fileOutputPath = pOutput;

                String tParam = "-Tjpg";
                String tOParam = "-o";

                String[] cmd = new String[5];
                cmd[0] = dotPath;
                cmd[1] = tParam;
                cmd[2] = fileInputPath;
                cmd[3] = tOParam;
                cmd[4] = fileOutputPath;

                Runtime rt = Runtime.getRuntime();
                rt.exec(cmd);

            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
            }

        } catch (Exception e) {
        }
    }

    synchronized void escribir_archivo(String pfichero, String pcontenido) {
        FileWriter file = null;

        try {
            file = new FileWriter(pfichero);
        } catch (IOException ex) {
            Logger.getLogger(Dic_Simple.class.getName()).log(Level.SEVERE, null, ex);
        }
        File a = new File(pfichero);
        if (!a.exists()) {
            return;
        }
        try (PrintWriter printwriter = new PrintWriter(file)) {
            printwriter.print(pcontenido);
            printwriter.close();
        }
    }
    
    
    
    
    
}
