package com.proj.tech.connectArduino;

import java.io.IOException;
import com.fazecast.jSerialComm.SerialPort;
import java.util.Scanner;
public class InteractArduino {

    private final String port ;
    public InteractArduino(String port){
        this.port = port ;
    }

    public void SendArduino() throws IOException, InterruptedException {
        SerialPort sp = SerialPort.getCommPort(this.port);

        sp.setComPortParameters(9600, 8, 1, 0);
        sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);

        if (!sp.openPort()) {
            System.out.println("\nCOM port NOT available\n");
            return;
        }

        System.out.println("Je vais tout faire cligner");

        int blinks = 5 ;
        Thread.sleep(1500);
        sp.getOutputStream().write(blinks);
    }
}

