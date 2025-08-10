/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Inicio;

import ConexionDBA.ConectarDBA;
import VistaGeneral.FrameGeneral;

/**
 *
 * @author alejandro
 */
public class Practica_IPC2 {

    public static void main(String[] args) {
        ConectarDBA co = new ConectarDBA();
        co.connect();
        FrameGeneral fr = new FrameGeneral();
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }
}
