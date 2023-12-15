package com.proj.tech.services.connectArduino;

import java.io.IOException;
import com.fazecast.jSerialComm.SerialPort;
import com.proj.tech.services.JavaArduinoTranslator;

import java.util.List;

public class InteractArduino {

    // private final List<String> params ;
    private final JavaArduinoTranslator translator;
    private final String port ;
    private final  SerialPort sp ;
    public InteractArduino(String port){
        this.port = port ;
        this.translator = new JavaArduinoTranslator();
        this.sp = SerialPort.getCommPort(this.port);

        sp.setComPortParameters(9600, 8, 1, 0);
        sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);
    }

    public void SendArduino(List<String> params) throws IOException, InterruptedException {
        // SerialPort sp = SerialPort.getCommPort(this.port);


        if (!sp.openPort()) {
            System.out.println("\nCOM port NOT available\n");
            return;
        }

        // GestionBlocs gestionBlocs = new GestionBlocs(params) ;
       // gestionBlocs.VerifyBlocs() ;

        // System.out.println("Je vais tout faire cligner");

        // Définir commands, qui serait ["couleur bleue", "1 seconde", "eteindre" ....]
        // Problème avec char : il faut que ce soit "b" et pas "Couleur bleue"


        for (String command : params) {
            System.out.println(this.translator.translate(command)) ;

            sp.getOutputStream().write(this.translator.translate(command));

            Thread.sleep(100); // Optionnel : Attente entre chaque commande
        }

        /* Code originel
               int blinks = 5 ;
            Thread.sleep(1500);
            sp.getOutputStream().write(blinks);
        */
    }
}

