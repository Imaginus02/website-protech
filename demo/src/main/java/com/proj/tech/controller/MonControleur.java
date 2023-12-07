package com.proj.tech.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fazecast.jSerialComm.SerialPort;
import com.proj.tech.connectArduino.InteractArduino;
import com.proj.tech.dto.User;
import com.proj.tech.dao.UserDao;
import com.proj.tech.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.GetMapping; // Si formulaire envoyé avec GET
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MonControleur {

    @Autowired
    private UserDao userDao;

    @PostMapping("/maPage") // "/maPage" correspond à <form action="/maPage" method="post">
    public String maPage(HttpServletRequest request) throws IOException, InterruptedException {
        Map<String, String[]> params = new LinkedHashMap<>(request.getParameterMap());
        params.remove("validForm") ;

        // Transformer ["bloc1" => "Couleur Bleue"] en [1:"Couleur Bleue"]
        int compt = 0 ;
        List<String> newList = new ArrayList<>() ;
        for (String key : params.keySet()) {
            newList.add(params.get(key)[0]) ;
        }

        // Pour affichage dans le Terminal
        InteractArduino arduino = new InteractArduino(PortOpen(), newList) ;
        arduino.SendArduino();

        /* ANCIEN Code
        for (String key : params.keySet()) {
            String[] values = params.get(key);
            for (String value : values) {
                System.out.println("Paramètre " + key + " : " + value);

                if(value.equals("Tourner à droite 3 fois")){
                    System.out.println("Coucou");
                }

            }
        }
         */

        /*
        Il faut, pour la gestion du code, mettre des conditions : par exemple, je pense que la personne doit respecter cette ordre :
        - un bloc "Allumer"
        - un bloc "Temps"
        Si le code n'est pas un ensemble de ce type de code, alors ce n'est pas bon !
         */

        return "redirect:/result.html";
    }

    public String PortOpen(){
        SerialPort[] ports = SerialPort.getCommPorts();
        for (SerialPort port : ports) {
            if (port.isOpen()) {
                System.out.println("- " + port.getSystemPortName());
                return port.getSystemPortName() ;
            }
        }
        System.exit(0); // Arrete toute l'appli, un peu vache mais pas grave
        return "Arret" ;
    }

//    @PostMapping("/login")
//    public String login(HttpServletRequest request) {
//        Map<String, String[]> params = new LinkedHashMap<>(request.getParameterMap());
//        params.remove("validForm");
//
//        for (String key : params.keySet()) {
//            String[] values = params.get(key);
//            for (String value : values) {
//                System.out.println("Paramètre " + key + " : " + value);
//            }
//        }
//
//        return "redirect:/mainPage.html";
//    }
}
