/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package VistaReportes;

import ControladorReportes.ControladorGenerarReporte;
import ControladorReportes.ReporteParticipante;
import GenerardorHTML.ReporteHTML;
import java.util.List;

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

        jButtonActividad.setText("Generar Reporte Actividades");

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
        // Seleccionar archivo con JFileChooser
        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
        fileChooser.setDialogTitle("Guardar Reporte Participantes");
        fileChooser.setSelectedFile(new java.io.File("ReporteParticipantes.html"));

        int seleccion = fileChooser.showSaveDialog(this);
        if (seleccion == javax.swing.JFileChooser.APPROVE_OPTION) {
            java.io.File archivo = fileChooser.getSelectedFile();
            String ruta = archivo.getAbsolutePath();

            ControladorGenerarReporte controlador = new ControladorGenerarReporte();
            List<ReporteParticipante> participantes = controlador.reporteParticipantes("", "", "");
            reporteHTML.generarReporteParticipantes(participantes, "ReporteParticipantes.html");

            // Mensaje de confirmación
            javax.swing.JOptionPane.showMessageDialog(this, "Reporte generado correctamente en:\n" + ruta);
        }
    }//GEN-LAST:event_jButtonParticipanteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActividad;
    private javax.swing.JButton jButtonEvento;
    private javax.swing.JButton jButtonParticipante;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
