/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fichas_Jugador;

import Diccionario_Simple.Dic_Simple;
import static Varios.Pseudo_Scrabble.Lista_Cola_Letras;
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
public class Num_Fichas_Simple {

    public Nodo_Num_Fichas in;
    public Nodo_Num_Fichas fi;

    public int contar = 0;

    //public Cola_Letras letter;
    Nodo_Num_Fichas lis;

    public Num_Fichas_Simple() {
        in = fi = null;
    }

    /*public void Insertar(char c) {
        //Pseudo_Scrabble.gui.ij.llamar;

        lis = new Nodo_Num_Fichas(c);

        if (!esVacio()) {
            in = fi = lis;
        } else {
            Nodo_Num_Fichas tempo;
            tempo = in;
            while (tempo != null) {
                tempo = tempo.sig;
            }
            tempo = lis;
            fi = tempo;
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
         *
    }*/

    /*public void Eliminar_ficha_usu(char elim) {
        Nodo_Num_Fichas aux = in;
        Nodo_Num_Fichas aux2 = in;
        while (aux != null) {
            if (elim == aux.num_ficha) {
                contar--;
                if (in.sig == null) {
                    in = fi = null;
                } else if (aux == in) {
                    in = aux.sig;
                    aux.sig = null;
                    aux = null;
                } else if (aux == fi) {
                    fi = aux2;
                    fi.sig = null;
                } else {
                    aux2.sig = aux.sig;
                    aux.sig = null;
                    aux = null;
                }
                return;
            }
            aux2 = aux;
            aux = aux.sig;
        }
    }*/

    public int Contador_Fichas() {
        if (!esVacio()) {
            Nodo_Num_Fichas temp;
            temp = in;
            int contadorr = 0;
            while (temp != null) {
                contadorr++;
                temp = temp.sig;
            }
            return contadorr;
        }
        return 0;
    }

    public void Reajustar_Fichas_lista(){
        //if ((!esVacio()) || (Contador_Fichas() <= 7)) {
            //System.out.println("ENTRA IF "+Contador_Fichas());
            
            for (int i = Contador_Fichas(); i < 7; i++) {
                char c = Lista_Cola_Letras.obtener_char();
                lis = new Nodo_Num_Fichas(c);
                
                if (esVacio() == false) {
                    in = fi = lis;
                    //in.sig = null;
                    ///System.out.println("***INGRESA EL INICIO*** ");
                    
                } else {
                    /*Nodo_Num_Fichas tempo;
                    tempo = in;
                    while (tempo != null) {
                        tempo = tempo.sig;
                    }
                    tempo = lis;
                    tempo.sig = null;*/
                    fi.sig = lis;
                    fi = fi.sig;
                    fi.sig = null;
                    //System.out.println("***INGRESA EL SIGUIENTE*** ");
                }
                System.out.println("-----Tamaño: "+Contador_Fichas());
            }
        //} else {
        //    System.out.print("Cola Vacia" + "ó" + "Esta Llena");
        //}
    }

    public void Recorre_simple() {
        Nodo_Num_Fichas aux = in;
        while (aux != fi) {
            aux = aux.sig;
            System.out.println("maximo 7 fichas");
        }
        System.out.println("Lista_LLena");
    }

    public void Recorre_simple_lista() {
        Nodo_Num_Fichas aux = in;
        int tam = 0;
        if (!esVacio()) {
            System.out.println("Vacia la lista");
            return;
        }
        while (aux != null) {
            System.out.println(aux.num_ficha);
            aux = aux.sig;
            tam++;
        }
        System.out.println("00000000000000000000000000000000   " + tam);
    }

    boolean esVacio() {
        if (in == null) {
            return false;
        } else {
            return true;
        }
    }
    
     StringBuffer concat;

    public void GraficoDic_Simple() {
        try {
            //CAMBIAR DE NOMBRE DEL ARCHIVO PARA CADA GRAFICO
            String pInput = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "Fichas_Actual.txt";
            String pOutput = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "Fichas_Actual.jpg";

            concat = new StringBuffer();
            concat.append("\nDigraph G {\n");

            Nodo_Num_Fichas tempo = in;
            
            int num=0, num2=0;// si te eescucho bien...
            while (tempo != null) {//en vez de null va fin
                concat.append("Nodo" + num + "[label=\"" + tempo.getNum_ficha()+ "\", style=filled];\n");
                tempo = tempo.sig;
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
