/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Letras.Cola_Letras;
import Matriz_Ortogonal.Ortogonal;
import Varios.Direccion;
import Varios.Enlaces;
import Varios.LecturaXml;
import Varios.Llenar_Lista_Letras_Default;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import static Varios.Pseudo_Scrabble.Lista_Diccionario;
import static Varios.Pseudo_Scrabble.Matriz_Tablero;

/**
 *
 * @author Samuel
 */
public class Carga_Masiva extends javax.swing.JFrame {    
    /**
     * Creates new form Carga_Masiva
     */
    public Ortogonal mini_Orto;
    public Cola_Letras llamar = new Cola_Letras();
    static public Tablero tablero = new Tablero();
    Llenar_Lista_Letras_Default llenaDef = new Llenar_Lista_Letras_Default();
    
    paraProbar pp = new paraProbar();
    public Carga_Masiva() {
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Cargar Archivo .xml");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jEditorPane1);

        jTabbedPane1.addTab("tab1", jScrollPane2);

        jScrollPane1.setViewportView(jTabbedPane1);

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Continuar ->");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(0, 296, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo Extension (*.xml)", "*.XML", "*xml", "XML");
        fc.setFileFilter(filtro);
        int selec_Us = fc.showOpenDialog(this);
        File file = null;
        if(selec_Us == JFileChooser.APPROVE_OPTION){
            //arch = fc.getSelectedFile();
            try{
                //jEditorPane1.setText(null);
                BufferedReader br;
                file = fc.getSelectedFile();
                br = new BufferedReader(new FileReader(file.getAbsolutePath()));
                
                String linea, contenido = "";
                while((linea = br.readLine()) != null){
                    contenido += linea  + "\n";
                }
                this.jEditorPane1.setText(contenido);
                br.close();
            }
            catch(IOException ex)
            {
                Logger.getLogger(Carga_Masiva.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
        
        /*
        *El metodo 
        *
        */
        Enlaces enlace = new Enlaces();
        enlace.Carga_Palabras(new LecturaXml().Lectura_Palabras(file.toString()));
        tablero.dimension = new LecturaXml().Dimension(file.toString());
        
        Direccion[] dir = new LecturaXml().Lectura_Dobles(file.toString());
        Direccion[] direccion = new LecturaXml().Lectura_Tres(file.toString());
        
        for (Direccion dir1 : dir) {
            tablero.matriz.Recorre_Ortogonal(dir1.getX(), dir1.getY(), 1, 2);
        }
        for(Direccion dir2 : direccion){
            tablero.matriz.Recorre_Ortogonal(dir2.getX(), dir2.getY(), 1, 3);
        }
        System.out.println("========\tLista Palabras de Diccionario\t===========");
        tablero.crear_matriz();
        //tablero.setVisible(true);
        tablero.tablero_xy();
        
        Lista_Diccionario.recorre();
        Lista_Diccionario.GraficoDic_Simple();
        llenaDef.llenar_lista();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        pp.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Menu_Principal mp = new Menu_Principal();
        mp.setVisible(true);
       
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Carga_Masiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Carga_Masiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Carga_Masiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Carga_Masiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Carga_Masiva().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
