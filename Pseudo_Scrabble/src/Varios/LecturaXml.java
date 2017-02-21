package Varios;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jdom.Document;          
import org.jdom.Element;          
import org.jdom.JDOMException;    
import org.jdom.input.SAXBuilder; 

/**
 *
 * @author Samuel
 */
public class LecturaXml {

    public LecturaXml(){
        
    }
    public String[] Lectura_Palabras(String path) {
        //Se crea un SAXBuilder para poder parsear el archivo
        SAXBuilder builder = new SAXBuilder();
        //File xmlFile = new File("C:\\Users\\Samuel\\Desktop\\arch_entrada.xml");
        File xmlFile = new File(path);
        String [] Lista_Dato = null;
        try {
            //Se crea el documento a traves del archivo
            Document document = (Document) builder.build(xmlFile);

            //Se obtiene la raiz 'tables'
            Element rootNode = document.getRootElement();

            //Se obtiene la lista de hijos de la raiz 'tables'
            List list = rootNode.getChildren("diccionario");

            //Se recorre la lista de hijos de 'tables'         
            //for (int i = 0; i < list.size(); i++) {
                //Se obtiene el elemento 'tabla'
                Element tabla = (Element) list.get(0);

                //Se obtiene el atributo 'nombre' que esta en el tag 'tabla'
                //String nombreTabla = tabla.getAttributeValue("palabra");

                //System.out.println("Tabla: " + nombreTabla);

                //Se obtiene la lista de hijos del tag 'tabla'
                List lista_campos = tabla.getChildren();

                System.out.println("\tNombre\t\t");

                Lista_Dato = new String[lista_campos.size()];
                //Se recorre la lista de campos
                for (int j = 0; j < lista_campos.size(); j++) {
                    Element campo = (Element) lista_campos.get(j);
                    String nombre = campo.getValue();
                    System.out.println("\t" + nombre + "\t\t");
                    
                    Lista_Dato[j] = nombre;
                //}
            }
        } catch (IOException io) {
            System.out.println(io.getMessage());
        } catch (JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
        }
        return Lista_Dato;
    }
    
    public Direccion[] Lectura_Dobles(String path) {
        //Se crea un SAXBuilder para poder parsear el archivo
        SAXBuilder builder = new SAXBuilder();
        //File xmlFile = new File("C:\\Users\\Samuel\\Desktop\\arch_entrada.xml");
        File xmlFile = new File(path);
        
        Direccion[] Nodo_Direccion = null;
        try {
            //Se crea el documento a traves del archivo
            Document document = (Document) builder.build(xmlFile);

            //Se obtiene la raiz 'tables'
            Element rootNode = document.getRootElement();

            //Se obtiene la lista de hijos de la raiz 'tables'
            List list = rootNode.getChildren("dobles");

            //Se recorre la lista de hijos de 'tables'
            for (int i = 0; i < list.size(); i++) {
                //Se obtiene el elemento 'tabla'
                Element tabla = (Element) list.get(i);

                //Se obtiene el atributo 'nombre' que esta en el tag 'tabla'
                String nombreTabla = tabla.getAttributeValue("casilla");

                System.out.println("Tabla: " + nombreTabla);

                //Se obtiene la lista de hijos del tag 'tabla'
                List lista_campos = tabla.getChildren();

                System.out.println("\tX\t\tY");

                Nodo_Direccion = new Direccion[lista_campos.size()];
                //Se recorre la lista de campos
                for (int j = 0; j < lista_campos.size(); j++) {
                    Element campo = (Element) lista_campos.get(j);
                    int x = Integer.parseInt(campo.getChildTextTrim("x"));
                    int y = Integer.parseInt(campo.getChildTextTrim("y"));
                    
                    Nodo_Direccion[j]= new Direccion(x, y);
                    System.out.println("\t" + x + "\t\t" + y);
                }
            }
        } catch (IOException io) {
            System.out.println(io.getMessage());
        } catch (JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
        }
        return Nodo_Direccion;
    }
    
    
    
    public Direccion[] Lectura_Tres(String path) {
        //Se crea un SAXBuilder para poder parsear el archivo
        SAXBuilder builder = new SAXBuilder();
        //File xmlFile = new File("C:\\Users\\Samuel\\Desktop\\arch_entrada.xml");
        File xmlFile = new File(path);
        
        Direccion[] Nodo_Direccion = null;
        try {
            //Se crea el documento a traves del archivo
            Document document = (Document) builder.build(xmlFile);

            //Se obtiene la raiz 'tables'
            Element rootNode = document.getRootElement();

            //Se obtiene la lista de hijos de la raiz 'tables'
            List list = rootNode.getChildren("triples");

            //Se recorre la lista de hijos de 'tables'
            for (int i = 0; i < list.size(); i++) {
                //Se obtiene el elemento 'tabla'
                Element tabla = (Element) list.get(i);

                //Se obtiene el atributo 'nombre' que esta en el tag 'tabla'
                String nombreTabla = tabla.getAttributeValue("casilla");

                System.out.println("Tabla: " + nombreTabla);

                //Se obtiene la lista de hijos del tag 'tabla'
                List lista_campos = tabla.getChildren();

                System.out.println("\tX\t\tY");

                Nodo_Direccion = new Direccion[lista_campos.size()];
                //Se recorre la lista de campos
                for (int j = 0; j < lista_campos.size(); j++) {
                    Element campo = (Element) lista_campos.get(j);
                    int x = Integer.parseInt(campo.getChildTextTrim("x"));
                    int y = Integer.parseInt(campo.getChildTextTrim("y"));
                    
                    Nodo_Direccion[j]= new Direccion(x, y);
                    System.out.println("\t" + x + "\t\t" + y);
                }
            }
        } catch (IOException io) {
            System.out.println(io.getMessage());
        } catch (JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
        }
        return Nodo_Direccion;
    }
    
    public int Dimension(String path) {
        //Se crea un SAXBuilder para poder parsear el archivo
        SAXBuilder builder = new SAXBuilder();
        //File xmlFile = new File("C:\\Users\\Samuel\\Desktop\\arch_entrada.xml");
        File xmlFile = new File(path);
        int dimension=0;
        
        //Dimension[] Nodo_Dimension = null;
        try {
            //Se crea el documento a traves del archivo
            Document document = (Document) builder.build(xmlFile);

            //Se obtiene la raiz 'tables'
            Element rootNode = document.getRootElement();

            //Se obtiene la lista de hijos de la raiz 'tables'
            //List list = rootNode.getAttribute("dimension");
            
            //Element dim = (Element) list.get(0);
            
            dimension = Integer.parseInt(rootNode.getChildText("dimension"));

            
        } catch (IOException io) {
            System.out.println(io.getMessage());
        } catch (JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
        }
        return dimension;
        
    }
    
}
