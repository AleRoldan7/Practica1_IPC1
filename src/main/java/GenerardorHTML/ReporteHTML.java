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
            writer.write("<html><head><meta charset='UTF-8'><title>Reporte Participantes</title></head><body>");
            writer.write("<h1>Reporte de Participantes</h1>");
            writer.write("<table border='1' style='border-collapse:collapse;'>");
            writer.write("<tr>"
                    + "<th>Correo</th>"
                    + "<th>Tipo</th>"
                    + "<th>Nombre Completo</th>"
                    + "<th>Institución</th>"
                    + "<th>Validado</th>"
                    + "</tr>");

            for (ReporteParticipante p : participantes) {
                writer.write("<tr>");
                writer.write("<td>" + safeString(p.getCorreo()) + "</td>");
                writer.write("<td>" + safeString(p.getTipo()) + "</td>");
                writer.write("<td>" + safeString(p.getNombreCompleto()) + "</td>");
                writer.write("<td>" + safeString(p.getInstitucion()) + "</td>");
                writer.write("<td>" + (p.isValidado() ? "Sí" : "No") + "</td>");
                writer.write("</tr>");
            }

            writer.write("</table></body></html>");
            System.out.println("Reporte generado: " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generarReporteActividades(List<ReporteActividad> actividades, String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {

            writer.write("<html><head><meta charset='UTF-8'><title>Reporte de Actividades</title></head><body>");
            writer.write("<h1>Reporte de Actividades</h1>");

            writer.write("<table border='1' style='border-collapse: collapse;'>");
            writer.write("<tr>"
                    + "<th>Código Actividad</th>"
                    + "<th>Código Evento</th>"
                    + "<th>Título</th>"
                    + "<th>Encargado</th>"
                    + "<th>Hora Inicio</th>"
                    + "<th>Cupo Máximo</th>"
                    + "<th>Total Participantes</th>"
                    + "</tr>");

            for (ReporteActividad act : actividades) {
                writer.write("<tr>");
                writer.write("<td>" + safeString(act.getCodigoActividad()) + "</td>");
                writer.write("<td>" + safeString(act.getCodigoEvento()) + "</td>");
                writer.write("<td>" + safeString(act.getTitulo()) + "</td>");
                writer.write("<td>" + safeString(act.getEncargado()) + "</td>");
                writer.write("<td>" + safeString(act.getHoraInicio()) + "</td>");
                writer.write("<td>" + act.getCupoMaximo() + "</td>");
                writer.write("<td>" + act.getCantidadParticipantes() + "</td>");
                writer.write("</tr>");
            }

            writer.write("</table></body></html>");

            System.out.println("Reporte de actividades generado correctamente en: " + rutaArchivo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generarReporteEventos(List<ReporteEvento> eventos, String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write("<html><head><meta charset='UTF-8'><title>Reporte de Eventos</title></head><body>");
            writer.write("<h1>Reporte de Eventos</h1>");
            writer.write("<table border='1' style='border-collapse:collapse;'>");
            writer.write("<tr>"
                    + "<th>Código Evento</th>"
                    + "<th>Fecha</th>"
                    + "<th>Título</th>"
                    + "<th>Tipo</th>"
                    + "<th>Ubicación</th>"
                    + "<th>Cupo Máximo</th>"
                    + "<th>Correo Participante</th>"
                    + "<th>Nombre Participante</th>"
                    + "<th>Tipo Participante</th>"
                    + "<th>Método de Pago</th>"
                    + "<th>Monto Pagado</th>"
                    + "<th>Validado</th>"
                    + "</tr>");

            double montoTotal = 0;
            int participantesValidados = 0;
            int participantesNoValidados = 0;

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
                writer.write("<td>" + e.getMontoPagado() + "</td>");
                writer.write("<td>" + (e.getMontoPagado() > 0 ? "Sí" : "No") + "</td>");
                writer.write("</tr>");

                montoTotal += e.getMontoPagado();
                if (e.getMontoPagado() > 0) {
                    participantesValidados++;
                } else {
                    participantesNoValidados++;
                }
            }

            writer.write("</table>");
            writer.write("<p><strong>Monto Total:</strong> Q." + montoTotal + "</p>");
            writer.write("<p><strong>Participantes Validados:</strong> " + participantesValidados + "</p>");
            writer.write("<p><strong>Participantes No Validados:</strong> " + participantesNoValidados + "</p>");
            writer.write("</body></html>");

            System.out.println("Reporte generado: " + nombreArchivo);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private String safeString(String valor) {
        return valor != null ? valor : "";
    }
}
