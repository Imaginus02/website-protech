package com.proj.tech.connectArduino;

import java.io.IOException;
import com.fazecast.jSerialComm.SerialPort;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class InteractArduino {

    private final List<String> params ;
    private final String port ;
    public InteractArduino(String port, List<String> params){
        this.port = port ;
        this.params = params ;
    }

    public void SendArduino() throws IOException, InterruptedException {
        SerialPort sp = SerialPort.getCommPort(this.port);

        sp.setComPortParameters(9600, 8, 1, 0);
        sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);

        if (!sp.openPort()) {
            System.out.println("\nCOM port NOT available\n");
            return;
        }

        GestionBlocs gestionBlocs = new GestionBlocs(params) ;
        gestionBlocs.VerifyBlocs() ;

        System.out.println("Je vais tout faire cligner");

        // Définir commands, qui serait ["couleur bleue", "1 seconde", "eteindre" ....]
        // Problème avec char : il faut que ce soit "b" et pas "Couleur bleue"
        for (char command : params) {
            sp.getOutputStream().write(command);
            Thread.sleep(100); // Optionnel : Attente entre chaque commande
        }

        /* Code originel
               int blinks = 5 ;
            Thread.sleep(1500);
            sp.getOutputStream().write(blinks);
        */
    }
}

