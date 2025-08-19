/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package VistaReportes;

import ControladorReportes.ControladorGenerarReporte;
import ControladorReportes.ReporteActividad;
import ControladorReportes.ReporteEvento;
import ControladorReportes.ReporteParticipante;
import GenerardorHTML.ReporteHTML;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author alejandro
 */
public class GenerarReportes extends javax.swing.JInternalFrame {

    private ReporteHTML reporteHTML;

    /**
     * Creates new form GenerarReportes
     */
    public GenerarReportes() {
        initComponents();
        reporteHTML = new ReporteHTML();
    }

    private void generarReporteParticipante() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Guardar Reporte de Participantes");
        chooser.setSelectedFile(new java.io.File("ReporteParticipantes.html"));

        int opcion = chooser.showSaveDialog(this);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            java.io.File archivo = chooser.getSelectedFile();
            String ruta = archivo.getAbsolutePath();

            ControladorGenerarReporte controlador = new ControladorGenerarReporte();
            List<ReporteParticipante> participantes = controlador.obtenerReporteParticipantes("", "", "");

            ReporteHTML html = new ReporteHTML();
            html.generarReporteParticipantes(participantes, ruta);

            JOptionPane.showMessageDialog(this, "Reporte generado correctamente en:\n" + ruta);
        }
    }

    private void generarReporteActividades() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Guardar Reporte de Actividades");
        chooser.setSelectedFile(new java.io.File("ReporteActividades.html"));

        int opcion = chooser.showSaveDialog(this);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            java.io.File archivo = chooser.getSelectedFile();
            String ruta = archivo.getAbsolutePath();

            ControladorGenerarReporte controlador = new ControladorGenerarReporte();
            List<ReporteActividad> actividades = controlador.obtenerActividadesParaReporte("", "", "");

            ReporteHTML html = new ReporteHTML();
            html.generarReporteActividades(actividades, ruta);

            JOptionPane.showMessageDialog(this, "Reporte generado correctamente en:\n" + ruta);
        }
    }
    
    private void generarReporteEventos() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Guardar Reporte de Eventos");
        chooser.setSelectedFile(new java.io.File("ReporteEvento.html"));

        int opcion = chooser.showSaveDialog(this);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            java.io.File archivo = chooser.getSelectedFile();
            String ruta = archivo.getAbsolutePath();

            ControladorGenerarReporte controlador = new ControladorGenerarReporte();
            List<ReporteEvento> eventos = controlador.obtenerReporteEventos();

            ReporteHTML html = new ReporteHTML();
            html.generarReporteEventos(eventos, ruta);

            JOptionPane.showMessageDialog(this, "Reporte generado correctamente en:\n" + ruta);
        }
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonParticipante = new javax.swing.JButton();
        jButtonEvento = new javax.swing.JButton();
        jButtonActividad = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jButtonParticipante.setText("Generar Reporte Participantes");
        jButtonParticipante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonParticipanteActionPerformed(evt);
            }
        });

        jButtonEvento.setText("Generar Reporte Eventos");
        jButtonEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEventoActionPerformed(evt);
            }
        });

        jButtonActividad.setText("Generar Reporte Actividades");
        jButtonActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActividadActionPerformed(evt);
            }
        });

        jLabel1.setText("Reportes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jButtonParticipante)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(jButtonActividad)
                .addGap(77, 77, 77)
                .addComponent(jButtonEvento)
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(419, 419, 419))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(111, 111, 111)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEvento)
                    .addComponent(jButtonActividad)
                    .addComponent(jButtonParticipante))
                .addContainerGap(124, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonParticipanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonParticipanteActionPerformed
        generarReporteParticipante();
    }//GEN-LAST:event_jButtonParticipanteActionPerformed

    private void jButtonActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActividadActionPerformed
        generarReporteActividades();
    }//GEN-LAST:event_jButtonActividadActionPerformed

    private void jButtonEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEventoActionPerformed
        generarReporteEventos();
    }//GEN-LAST:event_jButtonEventoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActividad;
    private javax.swing.JButton jButtonEvento;
    private javax.swing.JButton jButtonParticipante;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
