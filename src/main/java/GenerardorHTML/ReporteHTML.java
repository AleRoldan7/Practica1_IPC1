/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GenerardorHTML;

import ControladorReportes.ReporteActividad;
import ControladorReportes.ReporteEvento;
import ControladorReportes.ReporteParticipante;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author alejandro
 */
public class ReporteHTML {

    public void generarReporteParticipantes(List<ReporteParticipante> participantes, String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write("<html><head><title>Reporte Participantes</title></head><body>");
            writer.write("<h1>Reporte de Participantes</h1>");
            writer.write("<table border='1'>");
            writer.write("<tr>"
                    + "<th>Correo</th>"
                    + "<th>Tipo</th>"
                    + "<th>Nombre Completo</th>"
                    + "<th>Institución</th>"
                    + "<th>Validado</th>"
                    + "</tr>");

            for (ReporteParticipante p : participantes) {
                writer.write("<tr>");
                writer.write("<td>" + p.getCorreo() + "</td>");                  // Correo del participante
                writer.write("<td>" + p.getTipo() + "</td>");                    // Tipo de inscripción
                writer.write("<td>" + p.getNombreCompleto() + "</td>");          // Nombre completo
                writer.write("<td>" + p.getInstitucion() + "</td>");             // Institución
                writer.write("<td>" + (p.isValidado() ? "Sí" : "No") + "</td>"); // Inscripción validada
                writer.write("</tr>");
            }

            writer.write("</table></body></html>");
            System.out.println("Reporte generado en: " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generarReporteActividades(List<ReporteActividad> actividades, String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write("<html><head><title>Reporte Actividades</title></head><body>");
            writer.write("<h1>Reporte de Actividades</h1>");
            writer.write("<table border='1'>");
            writer.write("<tr><th>Código Actividad</th><th>Código Evento</th><th>Título</th><th>Encargado</th><th>Hora Inicio</th><th>Cupo Máximo</th><th>Participantes</th></tr>");
            for (ReporteActividad a : actividades) {
                writer.write("<tr>");
                writer.write("<td>" + a.getCodigoActividad() + "</td>");
                writer.write("<td>" + a.getCodigoEvento() + "</td>");
                writer.write("<td>" + a.getTitulo() + "</td>");
                writer.write("<td>" + a.getEncargado() + "</td>");
                writer.write("<td>" + a.getHoraInicio() + "</td>");
                writer.write("<td>" + a.getCupoMaximo() + "</td>");
                writer.write("<td>" + a.getCantidadParticipantes() + "</td>");
                writer.write("</tr>");
            }
            writer.write("</table></body></html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generarReporteEventos(List<ReporteEvento> eventos, String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write("<html><head><title>Reporte Eventos</title></head><body>");
            writer.write("<h1>Reporte de Eventos</h1>");
            writer.write("<table border='1'>");
            writer.write("<tr><th>Código Evento</th><th>Fecha</th><th>Título</th><th>Tipo</th><th>Ubicación</th><th>Cupo Máximo</th>"
                    + "<th>Correo Participante</th><th>Nombre Participante</th><th>Tipo Participante</th><th>Método de Pago</th><th>Monto</th></tr>");
            for (ReporteEvento e : eventos) {
                writer.write("<tr>");
                writer.write("<td>" + e.getCodigoEvento() + "</td>");
                writer.write("<td>" + e.getFechaEvento() + "</td>");
                writer.write("<td>" + e.getTitulo() + "</td>");
                writer.write("<td>" + e.getTipoEvento() + "</td>");
                writer.write("<td>" + e.getUbicacion() + "</td>");
                writer.write("<td>" + e.getCupoMaximo() + "</td>");
                writer.write("<td>" + e.getCorreoParticipante() + "</td>");
                writer.write("<td>" + e.getNombreParticipante() + "</td>");
                writer.write("<td>" + e.getTipoParticipante() + "</td>");
                writer.write("<td>" + e.getMetodoPago() + "</td>");
                // writer.write("<td>" + e.getMonto() + "</td>");
                writer.write("</tr>");
            }
            writer.write("</table></body></html>");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
