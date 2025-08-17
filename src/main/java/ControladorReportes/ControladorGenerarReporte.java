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

    public List<ReporteParticipante> reporteParticipantes(String codigoEvento, String tipo, String institucion) {

        List<ReporteParticipante> lista = new ArrayList<>();

        String queryReporteParticipante = "SELECT p.Correo AS Correo, "
                + "i.tipoInscripcion AS Tipo, "
                + "p.NombreParticipante AS NombreCompleto, "
                + "p.Institucion AS Institucion, "
                + "i.inscripcionValida AS Validado "
                + "FROM registro_participante p "
                + "JOIN inscripcion i ON p.idParticipante = i.idParticipante "
                + "WHERE (? = '' OR i.codigoEvento = ?) "
                + "AND (? = '' OR i.tipoInscripcion = ?) "
                + "AND (? = '' OR p.Institucion = ?)";

        try (PreparedStatement ps = getConnect().prepareStatement(queryReporteParticipante)) {
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

    public List<ReporteActividad> reporteActividades(String codigoEvento, String tipoActividad, String correoEncargado) {

        List<ReporteActividad> lista = new ArrayList<>();

        String queryReporteActividad = "SELECT a.codigoActividad, a.codigoEvento, a.tituloActividad, CONCAT(p.Nombre,' ',p.Apellido) AS Encargado, "
                + "a.horaInicio, a.cupoMaximo, COUNT(r.idParticipante) AS cantidadParticipantes "
                + "FROM registrar_actividad a "
                + "JOIN registro_participante p ON a.idParticipante = p.idParticipante "
                + "LEFT JOIN asistencia r ON a.codigoActividad = r.codigoActividad "
                + "WHERE a.codigoEvento = ? "
                + "AND (? = '' OR a.tipoActividad = ?) "
                + "AND (? = '' OR p.Correo = ?) "
                + "GROUP BY a.codigoActividad";
        try (PreparedStatement ps = getConnect().prepareStatement(queryReporteActividad)) {
            ps.setString(1, codigoEvento);
            ps.setString(2, tipoActividad);
            ps.setString(3, tipoActividad);
            ps.setString(4, correoEncargado);
            ps.setString(5, correoEncargado);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new ReporteActividad(
                        rs.getString("codigoActividad"),
                        rs.getString("codigoEvento"),
                        rs.getString("tituloActividad"),
                        rs.getString("Encargado"),
                        rs.getString("horaInicio"),
                        rs.getInt("cupoMaximo"),
                        rs.getInt("cantidadParticipantes")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<ReporteEvento> reporteEventos(String tipoEvento, String fechaInicio, String fechaFin, Integer cupoMin, Integer cupoMax) {

        List<ReporteEvento> lista = new ArrayList<>();

        String queryReporteEvento = "SELECT e.Codigo, e.Fecha_Evento, e.Titulo, e.Tipo_Evento, e.Ubicacion, e.Cupo_Maximo, "
                + "p.Correo, CONCAT(p.Nombre,' ',p.Apellido) AS NombreParticipante, i.tipoInscripcion, pay.tipoPago, pay.monto "
                + "FROM registro_evento e "
                + "LEFT JOIN inscripcion i ON e.Codigo = i.codigoEvento AND i.inscripcionValida = 1 "
                + "LEFT JOIN registro_participante p ON i.idParticipante = p.idParticipante "
                + "LEFT JOIN pago pay ON i.idParticipante = pay.idParticipante AND e.Codigo = pay.codigoEvento "
                + "WHERE (? = '' OR e.Tipo_Evento = ?) "
                + "AND (? = '' OR e.Fecha_Evento >= ?) "
                + "AND (? = '' OR e.Fecha_Evento <= ?) "
                + "AND (? IS NULL OR e.Cupo_Maximo >= ?) "
                + "AND (? IS NULL OR e.Cupo_Maximo <= ?)";
        try (PreparedStatement ps = getConnect().prepareStatement(queryReporteEvento)) {
            ps.setString(1, tipoEvento);
            ps.setString(2, tipoEvento);
            ps.setString(3, fechaInicio);
            ps.setString(4, fechaInicio);
            ps.setString(5, fechaFin);
            ps.setString(6, fechaFin);
            ps.setObject(7, cupoMin);
            ps.setObject(8, cupoMin);
            ps.setObject(9, cupoMax);
            ps.setObject(10, cupoMax);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new ReporteEvento(
                        rs.getString("Codigo"),
                        rs.getString("Fecha_Evento"),
                        rs.getString("Titulo"),
                        rs.getString("Tipo_Evento"),
                        rs.getString("Ubicacion"),
                        rs.getInt("Cupo_Maximo"),
                        rs.getString("Correo"),
                        rs.getString("NombreParticipante"),
                        rs.getString("tipoInscripcion"),
                        rs.getString("tipoPago"),
                        rs.getDouble("Pago_Evento")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
