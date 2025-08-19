/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorReportes;

import ConexionDBA.ConectarDBA;
import ModelosEntidad.EntidadCertificado;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author alejandro
 */
public class Certificado extends ConectarDBA {

    public Certificado() {
        super();
        connect();
    }

    public boolean generarCertificado(EntidadCertificado certificado) {

        String sql = "SELECT p.NombreParticipante, e.Titulo, e.Fecha_Evento, ra.codigoActividad "
                + "FROM registro_participante p "
                + "JOIN asistencia a ON p.idParticipante = a.idParticipante "
                + "JOIN registrar_actividad ra ON a.idActividad = ra.idActividad "
                + "JOIN registro_evento e ON ra.codigoEvento = e.Codigo "
                + "WHERE p.Correo = ? AND ra.codigoActividad = ? "
                + "LIMIT 1;";

        try (PreparedStatement ps = getConnect().prepareStatement(sql)) {

            ps.setString(1, certificado.getCorreoParticipante());
            ps.setString(2, certificado.getCodigoActividad());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                certificado.setNombreParticipante(rs.getString("NombreParticipante"));
                certificado.setTituloEvento(rs.getString("Titulo"));
                certificado.setFechaEvento(rs.getString("Fecha_Evento"));

                crearArchivoHTML(certificado);
                return true;
            } else {
                System.out.println("❌ No se puede generar certificado. El participante no asistió a ninguna actividad válida.");
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void crearArchivoHTML(EntidadCertificado certificado) throws IOException {
        // Abrir un JFileChooser para seleccionar dónde guardar el certificado
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar Certificado");
        fileChooser.setSelectedFile(new File("Certificado_" + certificado.getCorreoParticipante() + "_" + certificado.getCodigoActividad() + ".html"));
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos HTML", "html"));

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            try (FileWriter writer = new FileWriter(fileToSave)) {
                writer.write("<html>");
                writer.write("<head><title>Certificado de Participación</title></head>");
                writer.write("<body style='font-family: Comic Sans MS, Arial, sans-serif; text-align:center; margin:30px;'>");

                writer.write("<h1 style='color:blue;'>CERTIFICADO DE PARTICIPACIÓN</h1>");
                writer.write("<p>Este certificado se otorga a:</p>");
                writer.write("<h2 style='color:darkgreen;'>" + certificado.getNombreParticipante() + "</h2>");
                writer.write("<p>Por haber participado en la actividad:</p>");
                writer.write("<h3>" + certificado.getCodigoActividad() + " del evento " + certificado.getTituloEvento() + "</h3>");
                writer.write("<p>Que se llevó a cabo el día " + certificado.getFechaEvento() + "</p>");

                writer.write("<br><br>");
                writer.write("<p>-----------------------------------------</p>");
                writer.write("<p>Firma de la Organización</p>");

                writer.write("</body></html>");
            }

            System.out.println("✅ Certificado generado en: " + fileToSave.getAbsolutePath());
        } else {
            System.out.println("❌ Guardado cancelado por el usuario.");
        }

    }
}
