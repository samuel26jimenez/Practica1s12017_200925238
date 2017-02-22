/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pseudo_scrabble;

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
public class Jugador_Circular {

    public Nodo_Us i;
    public Nodo_Us f;

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

    public Boolean Ju_repetido(Nodo_Us nuevo_Ju){
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
    }

    Boolean Vacio_Circular() {
        if (i == null) {
            return true;
        } else {
            return false;
        }
    }
    
    StringBuffer Cir_Concate;

    public void GraficoJug_Circular() {
        try {            
            String pInput = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "jug_Circular.txt";
            String pOutput = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "jug_Circular.jpg";

            Cir_Concate = new StringBuffer();
            Cir_Concate.append("\nDigraph G {\n");

            //n0->n1->n2->n3
            Nodo_Us tempo = i;
            int num=0, num2=0;// si te eescucho bien...
            while (tempo != f) {//en vez de null va fin
                Cir_Concate.append("Nodo").append(num).append("[label=\"").append(tempo.Obtener()).append("\", style=filled];\n");

                Cir_Concate.append("Nodo").append(num).append(" -> Nodo").append(num + 1).append(";\n");
                Cir_Concate.append("{rank=same; Nodo").append(num).append(" Nodo").append(num + 1).append("}\n");
                tempo = tempo.sig;
                num++;
            }
            
            Cir_Concate.append("Nodo").append(num).append("[label=\"").append(tempo.Obtener()).append("\", style=filled];\n");
            
            Cir_Concate.append("Nodo").append(num).append(" -> Nodo0;\n");
            Cir_Concate.append("}");
            escribir_archivo(pInput, Cir_Concate.toString());

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
