/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matriz_Ortogonal;

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
public class Matriz {

    Ortogonal i, tempo2;

    public Matriz() {

    }
    /*
     n1->n2->n3->n4->n5
     |    |   |   |   |
     n1->n2->n3->n4->n5
     |    |   |   |   |
     n1->n2->n3->n4->n5
     |    |   |   |   |
     n1->n2->n3->n4->n5
    
     */

    public void insertar(Ortogonal nvo_Ndo) {
        if (!esVacio()) {
            i = tempo2 = nvo_Ndo;
        } else {
            Ortogonal tempo;
            Ortogonal tempo3;
            if (nvo_Ndo.y == 0) {
                tempo = i;
                tempo3 = i;
                while ( tempo != null ) {
                    tempo3 = tempo;
                    tempo = tempo.der;
                }

                tempo2 = nvo_Ndo;
                tempo = nvo_Ndo;
                tempo3.der = tempo;
                tempo.iz = tempo3;
            } else {
                tempo = tempo2;
                tempo3 = tempo2;
                while (tempo != null) {
                    tempo3 = tempo;
                    tempo = tempo.ab;
                }
                tempo = nvo_Ndo;
                tempo3.ab = tempo;
                tempo.ar = tempo3;
            }
        }
    }

    public void apuntador_Hor() {
        Ortogonal in1;
        Ortogonal in2;

        Ortogonal baja1;
        Ortogonal baja2;

        in1 = in2 = i;

        while (in1.der != null) {
            in2 = in1;
            in1 = in1.der;
            baja1 = in2.ab;
            baja2 = in1.ab;
            while (baja1 != null && baja2 != null) {

                baja1.der = baja2;
                baja2.iz = baja1;
                baja1 = baja1.ab;
                baja2 = baja2.ab;
            }
        }
    }

    public char Recorre_Ortogonal(int x, int y, int indicador, int premio) {
        Ortogonal in1;
        Ortogonal baja1;

        in1 = i;
        while (in1 != null) {
            if (x == in1.x && y == in1.y) {
                if (indicador == 1) {
                    in1.set_Premio(premio);
                }

                return in1.get();
            }
            baja1 = in1.ab;
            while (baja1 != null) {
                if (x == baja1.x && y == baja1.y) {
                    if (indicador == 1) {
                        baja1.set_Premio(premio);
                    }
                    return baja1.get();
                }
                baja1 = baja1.ab;
            }
            in1 = in1.der;
        }
        return '%';
    }

    public Boolean esVacio() {
        if (i == null) {
            return false;
        } else {
            return true;
        }
    }

    StringBuffer concat;

    public void Grafico_Matriz() {
        try {
            //CAMBIAR DE NOMBRE DEL ARCHIVO PARA CADA GRAFICO
            String pInput = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "Matriz_Orto.txt";
            String pOutput = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "Matriz_Orto.jpg";

            concat = new StringBuffer();
            concat.append("\nDigraph G {\n");

            Ortogonal temporal = i;//columnas
            Ortogonal temporal2 = i;//filas

            while (temporal != null) {//en vez de null va fin
                while (temporal2 != null) {
                    concat.append("\"Nodo" + temporal2.x +"-"+ temporal2.y + "\"[label=\"x=" + temporal2.x + " y=" + temporal2.y + "\", style=filled];\n");
                    temporal2 = temporal2.ab;
                }
                temporal = temporal.der;
                temporal2 = temporal;
            }

            temporal = temporal2 = i;

            while (temporal != null) {
                while (temporal2.ab != null) {
                    concat.append("\"Nodo" + temporal2.x +"-"+ temporal2.y + "\" -> \"Nodo" + temporal2.ab.x +"-"+ temporal2.ab.y + "\"[rankdir=UD];\n");
                    concat.append("\"Nodo" + temporal2.ab.x +"-"+ temporal2.ab.y + "\" -> \"Nodo" + temporal2.x +"-"+ temporal2.y + "\"[rankdir=UD];\n");                    
                    temporal2 = temporal2.ab;
                }
                temporal = temporal.der;
                temporal2 = temporal;
            }

            temporal = temporal2 = i;

            while (temporal2 != null) {//temporal2 recorre filas
                while (temporal.der != null) {
                    concat.append("\"Nodo" + temporal.x +"-"+ temporal.y + "\" -> \"Nodo" + temporal.der.x +"-"+ temporal.der.y + "\"[constraint=false];\n");
                    concat.append("\"Nodo" + temporal.der.x +"-"+ temporal.der.y + "\" -> \"Nodo" + temporal.x +"-"+ temporal.y + "\"[constraint=false];\n");
                    concat.append("{rank=same; \"Nodo" + temporal.x +"-"+ temporal.y + "\" \"Nodo" + temporal.der.x +"-"+ temporal.der.y + "\"}\n");
                    concat.append("{rank=same; \"Nodo" + temporal.der.x +"-"+ temporal.der.y + "\" \"Nodo" + temporal.x +"-"+ temporal.y + "\"}\n");
                    temporal = temporal.der;
                }
                temporal2 = temporal2.ab;
                temporal = temporal2;
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
