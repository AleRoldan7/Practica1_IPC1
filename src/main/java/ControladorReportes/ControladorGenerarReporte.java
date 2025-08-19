/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControladorReportes;

import ConexionDBA.ConectarDBA;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alejandro
 */
public class ControladorGenerarReporte extends ConectarDBA {

    public ControladorGenerarReporte() {
        super();
    }

    public List<ReporteParticipante> obtenerReporteParticipantes(String codigoEvento, String tipo, String institucion) {
        List<ReporteParticipante> lista = new ArrayList<>();

        String sql = "SELECT p.Correo AS Correo, "
                + "i.tipoInscripcion AS Tipo, "
                + "p.NombreParticipante AS NombreCompleto, "
                + "p.Institucion AS Institucion, "
                + "i.inscripcionValida AS Validado "
                + "FROM registro_participante p "
                + "JOIN inscripcion i ON p.idParticipante = i.idParticipante "
                + "WHERE (? = '' OR i.codigoEvento = ?) "
                + "AND (? = '' OR i.tipoInscripcion = ?) "
                + "AND (? = '' OR p.Institucion = ?)";

        try (PreparedStatement ps = getConnect().prepareStatement(sql)) {
            ps.setString(1, codigoEvento);
            ps.setString(2, codigoEvento);
            ps.setString(3, tipo);
            ps.setString(4, tipo);
            ps.setString(5, institucion);
            ps.setString(6, institucion);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new ReporteParticipante(
                        rs.getString("Correo"),
                        rs.getString("Tipo"),
                        rs.getString("NombreCompleto"),
                        rs.getString("Institucion"),
                        rs.getBoolean("Validado")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public List<ReporteActividad> obtenerActividadesParaReporte(String codigoEvento, String tipoActividad, String correoEncargado) {
        List<ReporteActividad> listaActividades = new ArrayList<>();

        String queryReporteActividades = "SELECT a.idActividad AS idAct, a.codigoEvento, a.tituloActividad, "
                + "p.NombreParticipante AS nombreEncargado, a.horaInicio, a.cupoMaximo, "
                + "COUNT(s.idParticipante) AS totalParticipantes "
                + "FROM registrar_actividad a "
                + "JOIN registro_participante p ON a.idParticipante = p.idParticipante "
                + "LEFT JOIN asistencia s ON a.idActividad = s.idActividad "
                + "WHERE a.codigoEvento = ?";

        if (tipoActividad != null && !tipoActividad.isEmpty()) {
            queryReporteActividades += " AND a.tipoActividad = ?";
        }
        if (correoEncargado != null && !correoEncargado.isEmpty()) {
            queryReporteActividades += " AND p.Correo = ?";
        }

        queryReporteActividades += " GROUP BY a.idActividad, a.codigoEvento, a.tituloActividad, p.NombreParticipante, a.horaInicio, a.cupoMaximo";

        try (PreparedStatement ps = getConnect().prepareStatement(queryReporteActividades)) {
            int indice = 1;
            ps.setString(indice++, codigoEvento);

            if (tipoActividad != null && !tipoActividad.isEmpty()) {
                ps.setString(indice++, tipoActividad);
            }
            if (correoEncargado != null && !correoEncargado.isEmpty()) {
                ps.setString(indice++, correoEncargado);
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String idActividad = rs.getString("idAct");
                String codigoEv = rs.getString("codigoEvento");
                String titulo = rs.getString("tituloActividad");
                String encargado = rs.getString("nombreEncargado");
                String hora = rs.getString("horaInicio");
                int cupo = rs.getInt("cupoMaximo");
                int participantes = rs.getInt("totalParticipantes");

                System.out.println("Actividad: " + idActividad + ", Evento: " + codigoEv
                        + ", Título: " + titulo + ", Encargado: " + encargado
                        + ", Hora: " + hora + ", Cupo: " + cupo
                        + ", Participantes: " + participantes);

                listaActividades.add(new ReporteActividad(
                        idActividad, codigoEv, titulo, encargado, hora, cupo, participantes
                ));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listaActividades;
    }

    public List<ReporteEvento> obtenerReporteEventos() {

        List<ReporteEvento> lista = new ArrayList<>();

        String queryReporteEvento = "SELECT e.Codigo AS codigoEvento, e.Fecha_Evento AS fechaEvento, e.Titulo AS titulo, "
                + "e.Tipo_Evento AS tipoEvento, e.Ubicacion AS ubicacion, e.Cupo_Maximo AS cupoMaximo, "
                + "p.Correo AS correoParticipante, p.NombreParticipante AS nombreParticipante, "
                + "p.TipoParticipante AS tipoParticipante, pay.tipoPago AS metodoPago, pay.monto AS monto "
                + "FROM registro_evento e "
                + "LEFT JOIN inscripcion i ON e.Codigo = i.codigoEvento "
                + "LEFT JOIN registro_participante p ON i.idParticipante = p.idParticipante "
                + "LEFT JOIN pago pay ON i.idParticipante = pay.idParticipante AND e.Codigo = pay.codigoEvento";

        try (PreparedStatement ps = getConnect().prepareStatement(queryReporteEvento)) {

            ResultSet rs = ps.executeQuery();
            int contador = 0;
            while (rs.next()) {
                contador++;
                System.out.println("Fila: " + contador + " -> Evento: " + rs.getString("codigoEvento")
                        + ", Participante: " + rs.getString("nombreParticipante"));

                lista.add(new ReporteEvento(
                        rs.getString("codigoEvento"),
                        rs.getString("fechaEvento"),
                        rs.getString("titulo"),
                        rs.getString("tipoEvento"),
                        rs.getString("ubicacion"),
                        rs.getInt("cupoMaximo"),
                        rs.getString("correoParticipante"),
                        rs.getString("nombreParticipante"),
                        rs.getString("tipoParticipante"),
                        rs.getString("metodoPago"),
                        rs.getDouble("monto")
                ));
            }

            if (contador == 0) {
                System.out.println("No se encontraron registros.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

}
