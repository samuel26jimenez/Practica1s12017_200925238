/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diccionario_Simple;

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
public class Dic_Simple {
    Nodo_Dic in;
    //Nodo_Dic fi;
    
   public Dic_Simple(){
       in = null;
       //fi = null;
   }
   
   public int insertar_Dic_Pal(Nodo_Dic x){
       if(vacio_Simple()){
           in = x;
           in.sig1 = null;           
           return 1;
       }else{
           Nodo_Dic temp;
           temp = in;
           while(temp.sig1 != null){
               temp = temp.sig1;
           }           
           temp.sig1 = x;
           temp = temp.sig1;
           temp.sig1 = null;  
           return 1;
       }
       /*
       System.out.println("Palabra_Repetida");
       return 0;
       */     
   }
   
   public void recorre(){
       Nodo_Dic temp;
       temp = in;
       while(temp != null){
           System.out.println(temp.Obtener_dic());
           temp = temp.sig1;
       }
   }
   
   
   Boolean vacio_Simple(){
       if(in == null){
           return true;
       }else {
           return false;
       }
   }
   
   
   StringBuffer concat;

    public void GraficoDic_Simple() {
        try {
            //CAMBIAR DE NOMBRE DEL ARCHIVO PARA CADA GRAFICO
            String pInput = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "Dic_Simple.txt";
            String pOutput = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "Dic_Simple.jpg";

            concat = new StringBuffer();
            concat.append("\nDigraph G {\n");

            Nodo_Dic tempo = in;
            int num=0, num2=0;// si te eescucho bien...
            while (tempo != null) {//en vez de null va fin
                concat.append("Nodo" + num + "[label=\"" + tempo.Obtener_dic() + "\", style=filled];\n");
                tempo = tempo.sig1;
                num++;
            }
            
            /*if(num!=0){ //para tomar en cuaenta el ultimo
                concat.append("Nodo" + num + "[label=\"" + tempo.Obtener_dic() + "\", style=filled];\n");
                num++;
            }*/

            while (num2 < (num-1)) {//en vez de (num-1) solo va num
                concat.append("Nodo" + num2 + " -> Nodo" + (num2 + 1) + ";\n");
                concat.append("{rank=same; Nodo" + num2 + " Nodo" + (num2 + 1) + "}\n");
                num2++;
            }
            
            /*if(num2 != 0){
                concat.append("Nodo" + num2 + " -> Nodo0;\n");
                concat.append("{rank=same; Nodo" + num2 + " Nodo" + (num2 + 1) + "}\n");
            }*/

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
