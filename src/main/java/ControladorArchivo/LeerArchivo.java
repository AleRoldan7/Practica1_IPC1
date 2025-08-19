package ControladorArchivo;

import ControladorActividad.RegistrarActividad;
import ControladorActividad.TipoCharla;
import ControladorAsistencia.RegistrarAsistencia;
import ControladorEvento.RegistrarEvento;
import ControladorEvento.TipoEvento;
import ControladorInscrip.RegistroInscripcion;
import ControladorInscrip.TipoInscripcion;
import ControladorPago.RegistroPago;
import ControladorPago.TipoPago;
import ControladorParticipante.RegistroParticipante;
import ControladorParticipante.TipoParticipante;
import ModelosEntidad.EntidadActividad;
import ModelosEntidad.EntidadAsistencia;
import ModelosEntidad.EntidadEvento;
import ModelosEntidad.EntidadInscripcion;
import ModelosEntidad.EntidadPago;
import ModelosEntidad.EntidadParticipante;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author alejandro
 */
public class LeerArchivo {

    private final RegistrarEvento eventos = new RegistrarEvento();
    private final RegistroParticipante participantes = new RegistroParticipante();
    private final RegistroInscripcion inscripciones = new RegistroInscripcion();
    private final RegistroPago pagos = new RegistroPago();
    private final RegistrarActividad actividad = new RegistrarActividad();
    private final RegistrarAsistencia asistencia = new RegistrarAsistencia();

    public void leerArchivo(String ruta, int tiempo, JTextField textField) {
        Thread hilo = new Thread(() -> {
            try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    linea = linea.trim();
                    if (!linea.isEmpty()) {
                        procesarLinea(linea);

                        final String lineaActual = linea;
                        javax.swing.SwingUtilities.invokeLater(()
                                -> textField.setText(textField.getText() + "Procesando: \n" + lineaActual)
                        );

                        Thread.sleep(tiempo);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error leyendo el archivo: " + e.getMessage());
            } catch (InterruptedException e) {
                System.out.println("Ejecución interrumpida");
                Thread.currentThread().interrupt();
            }
        });
        hilo.start();
    }

    private void procesarLinea(String linea) {
        if (linea.isEmpty() || linea.startsWith("/*") || linea.startsWith("//")) {
            return;
        }

        int indice = linea.indexOf("(");
        if (indice == -1) {
            return;
        }

        if (linea.endsWith(";")) {
            linea = linea.substring(0, linea.length() - 1);
        }

        String accion = linea.substring(0, indice).trim();
        String contenido = linea.substring(indice + 1, linea.lastIndexOf(")"));
        List<String> datos = separarValores(contenido);

        switch (accion) {
            case "REGISTRO_EVENTO":
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                EntidadEvento evento = new EntidadEvento(
                        datos.get(0),
                        LocalDate.parse(datos.get(1), formato),
                        TipoEvento.valueOf(datos.get(2).toUpperCase()),
                        datos.get(3),
                        datos.get(4),
                        Integer.parseInt(datos.get(5)),
                        Double.parseDouble(datos.get(6))
                );
                eventos.agregarEvento(evento);
                System.out.println("Evento registrado: " + datos);
                break;

            case "REGISTRO_PARTICIPANTE":
                EntidadParticipante participante = new EntidadParticipante(
                        datos.get(0),
                        TipoParticipante.valueOf(datos.get(1).toUpperCase()),
                        datos.get(2),
                        datos.get(3)
                );
                participantes.agregarParticipante(participante);
                System.out.println("Participante registrado: " + datos);
                break;

            case "INSCRIPCION":
                EntidadInscripcion inscripcion = new EntidadInscripcion(
                        datos.get(0),
                        datos.get(1),
                        TipoInscripcion.valueOf(datos.get(2).toUpperCase())
                );
                inscripciones.agregarInscripcion(inscripcion);
                System.out.println("Inscripción registrada: " + datos);
                break;

            case "PAGO":
                EntidadPago pago = new EntidadPago(
                        datos.get(0),
                        datos.get(1),
                        TipoPago.valueOf(datos.get(2).toUpperCase()),
                        Double.parseDouble(datos.get(3))
                );
                pagos.pagoRegistrado(pago);
                System.out.println("Pago registrado: " + datos);
                break;

            case "VALIDAR_INSCRIPCION":

                System.out.println("Validar inscripción: " + datos);
                break;

            case "REGISTRO_ACTIVIDAD":
                DateTimeFormatter horaFormato = DateTimeFormatter.ofPattern("HH:mm");

                EntidadActividad entidadActividad = new EntidadActividad(
                        datos.get(0),
                        datos.get(1),
                        TipoCharla.valueOf(datos.get(2)),
                        datos.get(3),
                        datos.get(4),
                        LocalTime.parse(datos.get(5), horaFormato),
                        LocalTime.parse(datos.get(6), horaFormato),
                        Integer.parseInt(datos.get(7))
                );
                actividad.agregarActividad(entidadActividad);
                System.out.println("Actividad: " + datos);
                break;

            case "ASISTENCIA":
                EntidadAsistencia entidadAsistencia = new EntidadAsistencia(datos.get(0), datos.get(1));
                asistencia.agregarAsistencia(entidadAsistencia);
                System.out.println("Asistencia: " + datos);
                break;

            case "CERTIFICADO":
                System.out.println("Certificado: " + datos);
                break;

            case "REPORTE_PARTICIPANTES":
            case "REPORTE_ACTIVIDADES":
            case "REPORTE_EVENTOS":
                System.out.println("Reporte solicitado: " + accion + " " + datos);
                break;

            default:
                System.out.println("Acción desconocida: " + accion);
        }
    }

    private List<String> separarValores(String entrada) {
        List<String> lista = new ArrayList<>();
        StringBuilder actual = new StringBuilder();
        boolean dentroComillas = false;

        for (char c : entrada.toCharArray()) {
            if (c == '"') {
                dentroComillas = !dentroComillas;
            } else if (c == ',' && !dentroComillas) {
                lista.add(actual.toString().trim().replaceAll("^\"|\"$", ""));
                actual.setLength(0);
                continue;
            }
            actual.append(c);
        }
        if (actual.length() > 0) {
            lista.add(actual.toString().trim().replaceAll("^\"|\"$", ""));
        }
        return lista;
    }
}
