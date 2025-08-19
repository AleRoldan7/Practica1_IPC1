/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package VistaPago;

import ControladorInscrip.RegistroInscripcion;
import ControladorPago.RegistroPago;
import ControladorPago.TipoPago;
import DatosParticipanteEventos.ControladorGeneral;
import ModelosEntidad.EntidadInscripcion;
import ModelosEntidad.EntidadPago;
import javax.swing.JOptionPane;

/**
 *
 * @author alejandro
 */
public class RegistroPagoDatos extends javax.swing.JInternalFrame {

    private RegistroPago registroPago;
    private ControladorGeneral controladorGeneral = new ControladorGeneral();

    public RegistroPagoDatos() {
        initComponents();
        registroPago = new RegistroPago();
        controladorGeneral.mostrarEventos(jComboEvento);
        controladorGeneral.mostrarParticipantes(jComboCorreo);
        agregarTipoPago();
    }

    private void agregarTipoPago() {
        jComboTipoPago.removeAllItems();
        jComboTipoPago.addItem("Seleccione Tipo Pago");

        for (TipoPago tipoPago : TipoPago.values()) {
            jComboTipoPago.addItem(tipoPago.name());
        }
    }

    public void registrarPago() {
        try {
            String correo = jComboCorreo.getSelectedItem().toString();
            String evento = jComboEvento.getSelectedItem().toString();
            String tipo = jComboTipoPago.getSelectedItem().toString();
            double monto = Double.parseDouble(jTextMonto.getText());

            if (correo.equals("Seleccionar Correo") || evento.equals("Seleccionar Evento")
                    || tipo.equals("Seleccione Tipo Pago")) {
                JOptionPane.showMessageDialog(this, "Seleccione todos los campos correctamente.");
                return;
            }

            EntidadPago entidadPago = new EntidadPago(evento, correo, TipoPago.valueOf(tipo), monto);

            RegistroPago registroPago = new RegistroPago();
            boolean pagado = registroPago.registrarPago(entidadPago); // tu método corregido

            if (pagado) {
                JOptionPane.showMessageDialog(this, "✅ Pago registrado correctamente.");

                // Validar inscripción inmediatamente después del pago
                RegistroInscripcion registroInscripcion = new RegistroInscripcion();
                EntidadInscripcion entidadInscripcion = new EntidadInscripcion(evento, correo, null);
                boolean inscripcionValida = registroInscripcion.validarInscripcion(entidadInscripcion);

                if (inscripcionValida) {
                    JOptionPane.showMessageDialog(this, "✅ Inscripción validada automáticamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "⚠ No se pudo validar la inscripción automáticamente.");
                }

            } else {
                JOptionPane.showMessageDialog(this, "❌ No se completó el pago. Puede que ya exista un registro.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un monto válido.");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al procesar el pago.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboCorreo = new javax.swing.JComboBox<>();
        jComboEvento = new javax.swing.JComboBox<>();
        jComboTipoPago = new javax.swing.JComboBox<>();
        jTextMonto = new javax.swing.JTextField();
        jButtonPago = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("Pago Evento");

        jLabel2.setText("Correo Participante");

        jLabel3.setText("Codigo Evento");

        jLabel4.setText("Metodo Pago");

        jLabel5.setText("Monto");

        jComboCorreo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboEvento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboTipoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "EFECTIVO", "TRANSEFERENCIA", "TARJETA" }));

        jButtonPago.setText("Pagar");
        jButtonPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPagoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(337, 337, 337)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboCorreo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboEvento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboTipoPago, 0, 207, Short.MAX_VALUE)
                            .addComponent(jTextMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(367, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonPago)
                .addGap(343, 343, 343))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jComboTipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jTextMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jButtonPago)
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPagoActionPerformed
        registrarPago();
    }//GEN-LAST:event_jButtonPagoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPago;
    private javax.swing.JComboBox<String> jComboCorreo;
    private javax.swing.JComboBox<String> jComboEvento;
    private javax.swing.JComboBox<String> jComboTipoPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextMonto;
    // End of variables declaration//GEN-END:variables
}
