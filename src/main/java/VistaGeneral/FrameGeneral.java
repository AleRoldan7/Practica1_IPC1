/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VistaGeneral;

import ConexionDBA.ConectarDBA;
import VistaActividad.RegistroActividadDatos;
import VistaAsistencia.RegistrarAsistenciaDatos;
import VistaCargarArchivo.CargarArchivo;
import VistaEvento.RegistrarEventoDatos;
import VistaInscripcion.InscripcionDatos;
import VistaPago.RegistroPagoDatos;
import VistaPago.ValidarInscripcion;
import VistaParticipante.RegistroParticipanteDatos;
import VistaReportes.GenerarCertificado;
import VistaReportes.GenerarReportes;
import javax.swing.JOptionPane;

/**
 *
 * @author alejandro
 */
public class FrameGeneral extends javax.swing.JFrame {

    /**
     * Creates new form FrameVista
     */
    public FrameGeneral(ConectarDBA conectarDBA) {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArchivo = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuRegistros = new javax.swing.JMenu();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItemParticipante = new javax.swing.JMenuItem();
        jMenuItemEvento = new javax.swing.JMenuItem();
        jMenuItemActividad = new javax.swing.JMenuItem();
        jMenuInscripcion = new javax.swing.JMenu();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItemInscripAgregar = new javax.swing.JMenuItem();
        jMenuItemPago = new javax.swing.JMenuItem();
        jMenuItemValidar = new javax.swing.JMenuItem();
        jMenuAsistencia = new javax.swing.JMenu();
        jMenuItemAsistencia = new javax.swing.JMenuItem();
        jMenuReportes = new javax.swing.JMenu();
        jMenuItemReportes = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1032, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );

        jMenuArchivo.setText("Cargar Archivo");
        jMenuArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuArchivoActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jSeparator1);

        jMenuItem1.setText("Cargar Archivo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItem1);

        jMenuBar1.add(jMenuArchivo);

        jMenuRegistros.setText("Registros");
        jMenuRegistros.add(jSeparator2);

        jMenuItemParticipante.setText("Registrar Participante");
        jMenuItemParticipante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemParticipanteActionPerformed(evt);
            }
        });
        jMenuRegistros.add(jMenuItemParticipante);

        jMenuItemEvento.setText("Registrar Evento");
        jMenuItemEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEventoActionPerformed(evt);
            }
        });
        jMenuRegistros.add(jMenuItemEvento);

        jMenuItemActividad.setText("Registrar Actividad");
        jMenuItemActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemActividadActionPerformed(evt);
            }
        });
        jMenuRegistros.add(jMenuItemActividad);

        jMenuBar1.add(jMenuRegistros);

        jMenuInscripcion.setText("Inscripcion");
        jMenuInscripcion.add(jSeparator3);

        jMenuItemInscripAgregar.setText("Inscripcion");
        jMenuItemInscripAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInscripAgregarActionPerformed(evt);
            }
        });
        jMenuInscripcion.add(jMenuItemInscripAgregar);

        jMenuItemPago.setText("Pago");
        jMenuItemPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPagoActionPerformed(evt);
            }
        });
        jMenuInscripcion.add(jMenuItemPago);

        jMenuItemValidar.setText("Validar Inscripcion");
        jMenuItemValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemValidarActionPerformed(evt);
            }
        });
        jMenuInscripcion.add(jMenuItemValidar);

        jMenuBar1.add(jMenuInscripcion);

        jMenuAsistencia.setText("Asistencia");
        jMenuAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAsistenciaActionPerformed(evt);
            }
        });

        jMenuItemAsistencia.setText("Asistencia");
        jMenuItemAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAsistenciaActionPerformed(evt);
            }
        });
        jMenuAsistencia.add(jMenuItemAsistencia);

        jMenuBar1.add(jMenuAsistencia);

        jMenuReportes.setText("Reportes");
        jMenuReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuReportesActionPerformed(evt);
            }
        });

        jMenuItemReportes.setText("Reportes");
        jMenuItemReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemReportesActionPerformed(evt);
            }
        });
        jMenuReportes.add(jMenuItemReportes);

        jMenuItem2.setText("Certificado");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenuReportes.add(jMenuItem2);

        jMenuBar1.add(jMenuReportes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuArchivoActionPerformed
        
    }//GEN-LAST:event_jMenuArchivoActionPerformed

    private void jMenuItemParticipanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemParticipanteActionPerformed
        jDesktopPane1.add(new RegistroParticipanteDatos()).setVisible(true);
    }//GEN-LAST:event_jMenuItemParticipanteActionPerformed

    private void jMenuItemEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEventoActionPerformed
        jDesktopPane1.add(new RegistrarEventoDatos()).setVisible(true);
    }//GEN-LAST:event_jMenuItemEventoActionPerformed

    private void jMenuItemActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemActividadActionPerformed
        jDesktopPane1.add(new RegistroActividadDatos()).setVisible(true);
    }//GEN-LAST:event_jMenuItemActividadActionPerformed

    private void jMenuItemInscripAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemInscripAgregarActionPerformed
        jDesktopPane1.add(new InscripcionDatos()).setVisible(true);
    }//GEN-LAST:event_jMenuItemInscripAgregarActionPerformed

    private void jMenuItemPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPagoActionPerformed
        jDesktopPane1.add(new RegistroPagoDatos()).setVisible(true);
    }//GEN-LAST:event_jMenuItemPagoActionPerformed

    private void jMenuItemValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemValidarActionPerformed
        jDesktopPane1.add(new ValidarInscripcion()).setVisible(true);
    }//GEN-LAST:event_jMenuItemValidarActionPerformed

    private void jMenuAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAsistenciaActionPerformed
        
    }//GEN-LAST:event_jMenuAsistenciaActionPerformed

    private void jMenuReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuReportesActionPerformed
        
    }//GEN-LAST:event_jMenuReportesActionPerformed

    private void jMenuItemAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAsistenciaActionPerformed
        jDesktopPane1.add(new RegistrarAsistenciaDatos()).setVisible(true);
    }//GEN-LAST:event_jMenuItemAsistenciaActionPerformed

    private void jMenuItemReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemReportesActionPerformed
        jDesktopPane1.add(new GenerarReportes()).setVisible(true);
    }//GEN-LAST:event_jMenuItemReportesActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       jDesktopPane1.add(new CargarArchivo()).setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        jDesktopPane1.add(new GenerarCertificado()).setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenuArchivo;
    private javax.swing.JMenu jMenuAsistencia;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuInscripcion;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItemActividad;
    private javax.swing.JMenuItem jMenuItemAsistencia;
    private javax.swing.JMenuItem jMenuItemEvento;
    private javax.swing.JMenuItem jMenuItemInscripAgregar;
    private javax.swing.JMenuItem jMenuItemPago;
    private javax.swing.JMenuItem jMenuItemParticipante;
    private javax.swing.JMenuItem jMenuItemReportes;
    private javax.swing.JMenuItem jMenuItemValidar;
    private javax.swing.JMenu jMenuRegistros;
    private javax.swing.JMenu jMenuReportes;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
