package ControladorArchivo;

import ControladorEvento.RegistrarEvento;
import ControladorEvento.TipoEvento;
import ModelosEntidad.EntidadEvento;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
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

    // Método que lanza el hilo para leer instrucciones
    public static void leerLineas(String rutaArchivo, int tiempo, JTextField textField) {
        Thread hilo = new Thread(() -> {
            try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    linea = linea.trim();
                    if (!linea.isEmpty()) {
                        procesarInstruccion(linea);
                        // Actualizar el JTextField en el hilo de Swing (para no romper la GUI)
                        final String lineaProcesada = linea;
                        javax.swing.SwingUtilities.invokeLater(() -> {
                            textField.setText(textField.getText() + "\nProcesando: " + lineaProcesada);
                        });
                        // Esperar el tiempo indicado
                        Thread.sleep(tiempo);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            } catch (InterruptedException e) {
                System.out.println("Ejecución interrumpida");
                Thread.currentThread().interrupt();
            }
        });
        hilo.start(); // Inicia el hilo
    }

    public static void procesarInstruccion(String linea) {
        linea = linea.trim();

        // Ignorar líneas vacías o comentarios
        if (linea.isEmpty() || linea.startsWith("/*") || linea.startsWith("//")) {
            return;
        }

        // Asegurarse que tenga paréntesis
        int indiceParentesis = linea.indexOf("(");
        if (indiceParentesis == -1) {
            return; // No es una instrucción válida
        }

        // Quitar el ; al final
        if (linea.endsWith(";")) {
            linea = linea.substring(0, linea.length() - 1);
        }

        // Acción = lo que está antes del primer paréntesis
        String accion = linea.substring(0, indiceParentesis).trim();

        // Argumentos = lo que está entre los paréntesis
        String datosBrutos = linea.substring(indiceParentesis + 1, linea.lastIndexOf(")"));
        java.util.List<String> datos = separarDatos(datosBrutos);

        // Procesar según la acción
        switch (accion) {
            case "REGISTRO_EVENTO":
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                EntidadEvento entidadEvento = new EntidadEvento(
                        datos.get(0), // código
                        LocalDate.parse(datos.get(1), formatter), // fecha
                        TipoEvento.valueOf(datos.get(2).toUpperCase()), // tipo evento
                        datos.get(3), // título
                        datos.get(4), // ubicación
                        Integer.parseInt(datos.get(5)), // cupo máximo
                        Double.parseDouble(datos.get(6)) // pago
                );
                RegistrarEvento registrarEvento = new RegistrarEvento();
                registrarEvento.agregarEvento(entidadEvento);
                System.out.println("Evento -> " + datos);
                break;
            case "REGISTRO_PARTICIPANTE":
                System.out.println("Participante -> " + datos);
                break;
            case "INSCRIPCION":
                System.out.println("Inscripción -> " + datos);
                break;
            case "PAGO":
                System.out.println("Pago -> " + datos);
                break;
            case "VALIDAR_INSCRIPCION":
                System.out.println("Validar inscripción -> " + datos);
                break;
            case "REGISTRO_ACTIVIDAD":
                System.out.println("Actividad -> " + datos);
                break;
            case "ASISTENCIA":
                System.out.println("Asistencia -> " + datos);
                break;
            case "CERTIFICADO":
                System.out.println("Certificado -> " + datos);
                break;
            case "REPORTE_PARTICIPANTES":
            case "REPORTE_ACTIVIDADES":
            case "REPORTE_EVENTOS":
                System.out.println("Reporte -> " + accion + " " + datos);
                break;
            default:
                System.out.println("Acción desconocida: " + accion);
        }
    }

    private static List<String> separarDatos(String entrada) {
        List<String> resultado = new ArrayList<>();
        StringBuilder actual = new StringBuilder();
        boolean dentroComillas = false;

        for (char c : entrada.toCharArray()) {
            if (c == '"') {
                dentroComillas = !dentroComillas; // Cambia estado
                actual.append(c);
            } else if (c == ',' && !dentroComillas) {
                resultado.add(actual.toString().trim().replaceAll("^\"|\"$", ""));
                actual.setLength(0);
            } else {
                actual.append(c);
            }
        }

        // Añadir el último valor
        if (actual.length() > 0) {
            resultado.add(actual.toString().trim().replaceAll("^\"|\"$", ""));
        }

        return resultado;
    }
}
