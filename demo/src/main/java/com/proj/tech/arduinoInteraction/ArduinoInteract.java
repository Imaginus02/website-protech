package com.proj.tech.arduinoInteraction;

import java.io.IOException;
import com.fazecast.jSerialComm.SerialPort;

public class ArduinoInteract {

    private final String port ;
    public ArduinoInteract(String port){
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

/*
    Scanner input = new Scanner(System.in);
        while (true) {
                System.out.print("\nEnter number of LED blinks (0 to exit): ");
                Integer blinks = input.nextInt();
                if (blinks == 0)
                break;
                Thread.sleep(1500);
                sp.getOutputStream().write(blinks.byteValue());
                }
                input.close();*/