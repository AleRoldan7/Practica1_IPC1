/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package VistaInscripcion;

import ControladorInscrip.RegistroInscripcion;
import javax.swing.JOptionPane;

/**
 *
 * @author alejandro
 */
public class InscripcionDatos extends javax.swing.JInternalFrame {

    private RegistroInscripcion regiInscripcion;

    public InscripcionDatos() {
        initComponents();
        regiInscripcion = new RegistroInscripcion();
        agregarCorreo();
        agregarEvento();
    }

    public void agregarCorreo() {

        regiInscripcion.mostrarParticipantes(jComboCorreo);

    }

    public void agregarEvento() {
        regiInscripcion.mostrarEventos(jComboEvento);
    }

    public void inscribir() {
        if (jComboEvento.getSelectedIndex() == 0 || jComboCorreo.getSelectedIndex() == 0 || jComboTipoInscrip.getSelectedIndex() == 0) {

            JOptionPane.showMessageDialog(this, "Debe seleccionar todas las opciones.");
            return; 
        }
        String codigoEvento = jComboEvento.getSelectedItem().toString();
        String correoParticipante = jComboCorreo.getSelectedItem().toString();
        String tipoParticipante = jComboTipoInscrip.getSelectedItem().toString();

        boolean exito = regiInscripcion.agregarInscripcion(codigoEvento, correoParticipante, tipoParticipante);

        if (exito) {
            JOptionPane.showMessageDialog(this, "Inscripción registrada correctamente");
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar la inscripción");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboTipoInscrip = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jComboCorreo = new javax.swing.JComboBox<>();
        jComboEvento = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(868, 461));

        jLabel1.setText("Inscripción");

        jLabel2.setText("Correo Participante");

        jLabel3.setText("Código Evento");

        jLabel4.setText("Tipo Inscripción");

        jComboTipoInscrip.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "ASISTENTE", "CONFERENCISTA", "TALLERISTA", "OTRO" }));

        jButton1.setText("Inscribir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboCorreo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Correo" }));

        jComboEvento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboCorreo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(51, 51, 51)
                                .addComponent(jComboTipoInscrip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(167, 167, 167))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(366, 366, 366)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(357, 357, 357)
                        .addComponent(jButton1)))
                .addContainerGap(322, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboTipoInscrip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        inscribir();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboCorreo;
    private javax.swing.JComboBox<String> jComboEvento;
    private javax.swing.JComboBox<String> jComboTipoInscrip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
