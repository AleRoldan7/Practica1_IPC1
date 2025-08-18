/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package VistaActividad;

import ControladorActividad.RegistrarActividad;
import ControladorActividad.TipoCharla;
import DatosParticipanteEventos.ControladorGeneral;
import ModelosEntidad.EntidadActividad;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author alejandro
 */
public class RegistroActividadDatos extends javax.swing.JInternalFrame {

    private RegistrarActividad registrarActividad;
    private ControladorGeneral controladorGeneral = new ControladorGeneral();

    public RegistroActividadDatos() {
        initComponents();
        registrarActividad = new RegistrarActividad();
        controladorGeneral.mostrarEventos(jComboEvento);
        controladorGeneral.mostrarParticipantes(jComboCorreo);
        agregarTipoCharla();
    }

    public void agregarTipoCharla() {
        jComboActividad.removeAllItems();
        for (TipoCharla tipoCharla : TipoCharla.values()) {
            jComboActividad.addItem(tipoCharla.name());
        }
    }

    public void agregarActividad() {
        // 1. Validar campos vacíos
        if (jTextCodigo.getText().isBlank()
                || jComboEvento.getSelectedIndex() == 0
                || jComboActividad.getSelectedIndex() == 0
                || jTextTitulo.getText().isBlank()
                || jComboCorreo.getSelectedIndex() == 0
                || jTextInicio.getText().isBlank()
                || jTextFin.getText().isBlank()
                || jTextCupo.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios");
            return;
        }

        // Validar código de actividad: formato ACT-XXXXXXXX
        String codigoActividad = jTextCodigo.getText().trim();
        if (!codigoActividad.matches("^ACT-\\d{8}$")) {
            JOptionPane.showMessageDialog(this, "Código de actividad inválido. Formato: ACT-00000000");
            jTextCodigo.requestFocus();
            return;
        }

        // 2. Validar código de actividad (opcional: ABC-00000000)
        String codigo = jTextCodigo.getText().trim();
        if (!codigo.matches("^[A-Z]{3}-\\d{8}$")) {
            JOptionPane.showMessageDialog(this, "Código de actividad inválido. Formato: ABC-00000000");
            jTextCodigo.requestFocus();
            return;
        }

        // 3. Validar horas
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime horaInicio, horaFin;
        try {
            horaInicio = LocalTime.parse(jTextInicio.getText().trim(), formatter);
            horaFin = LocalTime.parse(jTextFin.getText().trim(), formatter);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Formato de hora no válido. Use HH:mm");
            return;
        }

        if (!horaInicio.isBefore(horaFin)) {
            JOptionPane.showMessageDialog(this, "La hora de inicio debe ser menor que la hora de fin");
            return;
        }

        // 4. Validar cupo
        int cupo;
        try {
            cupo = Integer.parseInt(jTextCupo.getText().trim());
            if (cupo <= 0) {
                JOptionPane.showMessageDialog(this, "El cupo debe ser un número positivo");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Cupo inválido");
            return;
        }

        // 5. Validar título
        String titulo = jTextTitulo.getText().trim();
        if (titulo.length() < 3) {
            JOptionPane.showMessageDialog(this, "El título debe tener al menos 3 caracteres");
            return;
        }

        // 6. Crear la entidad
        EntidadActividad actividad = new EntidadActividad(
                codigo,
                jComboEvento.getSelectedItem().toString(),
                TipoCharla.valueOf(jComboActividad.getSelectedItem().toString()),
                titulo,
                jComboCorreo.getSelectedItem().toString(),
                horaInicio,
                horaFin,
                cupo
        );

        // 7. Llamar al controlador
        boolean agrego = registrarActividad.agregarActividad(actividad);

        if (agrego) {
            JOptionPane.showMessageDialog(this, "Actividad agregada correctamente");
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo agregar la actividad");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboEvento = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboActividad = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jTextTitulo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboCorreo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jTextInicio = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFin = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextCupo = new javax.swing.JTextField();
        jButtonActividad = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("Registro Actividades");

        jLabel2.setText("Codigo Actividad");

        jLabel3.setText("Codigo Evento");

        jComboEvento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Tipo Actividad");

        jComboActividad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Titulo Actividad");

        jLabel6.setText("Correo ");

        jComboCorreo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Hora Inicio");

        jLabel8.setText("Hora Fin");

        jLabel9.setText("Cupo Maximo");

        jButtonActividad.setText("Registrar Actividad");
        jButtonActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActividadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(335, 335, 335))
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel7)
                        .addComponent(jLabel6))
                    .addComponent(jLabel8))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboActividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jComboCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFin, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                        .addComponent(jTextInicio)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonActividad)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(35, 35, 35)
                        .addComponent(jTextCupo, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(83, 83, 83))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(jTextCupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jTextCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jComboActividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonActividad))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jComboCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(69, 69, 69)
                        .addComponent(jLabel8)))
                .addContainerGap(178, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActividadActionPerformed
        agregarActividad();
    }//GEN-LAST:event_jButtonActividadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActividad;
    private javax.swing.JComboBox<String> jComboActividad;
    private javax.swing.JComboBox<String> jComboCorreo;
    private javax.swing.JComboBox<String> jComboEvento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextCodigo;
    private javax.swing.JTextField jTextCupo;
    private javax.swing.JTextField jTextFin;
    private javax.swing.JTextField jTextInicio;
    private javax.swing.JTextField jTextTitulo;
    // End of variables declaration//GEN-END:variables
}
