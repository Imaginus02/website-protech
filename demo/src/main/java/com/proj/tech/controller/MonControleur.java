package com.proj.tech.controller;
import java.io.IOException;
import java.util.*;

import com.fazecast.jSerialComm.SerialPort;
import com.proj.tech.connectArduino.InteractArduino;
import com.proj.tech.connectArduino.JavaArduinoTranslator;
import com.proj.tech.dao.blocks.CodeDao;
import com.proj.tech.dao.blocks.InstructionDao;
import com.proj.tech.dto.blocks.Code;
import com.proj.tech.mapper.blocks.CodeMapper;
import com.proj.tech.model.blocks.CodeEntity;
import com.proj.tech.model.blocks.InstructionEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.GetMapping; // Si formulaire envoyé avec GET
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MonControleur {

    private final CodeDao codeDao;
    private final InstructionDao instructionDao;

    private final JavaArduinoTranslator javaArduinoTranslator = new JavaArduinoTranslator();

    public MonControleur(CodeDao codeDao, InstructionDao instructionDao) {
        this.codeDao = codeDao;
        this.instructionDao = instructionDao;
    }

    @PostMapping("/maPage") // "/maPage" correspond à <form action="/maPage" method="post">
    public String maPage(HttpServletRequest request) throws IOException, InterruptedException {
        Map<String, String[]> params = new LinkedHashMap<>(request.getParameterMap());
        params.remove("validForm") ;

        /*Map<String, String>
        * [
        *   "btnSave" => "Sauvegarder",
        *   "bloc1" => "Couleur Rouge",
        *   "bloc2" => "1 seconde"
        *   ...
        * ]
         */

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

    // Code que je viens d'ajouter pour traiter la sauvegarde du code
    // Tu peux voir dans la console le type de retour obtenu, je te laisse gérer avec le back-end.
    /*
    [
        "nameOfCode" => ....,
        "bloc1" => "Couleur Rouge",
        "bloc2 => "1 seconde"
        ...
    ]
     */
    @PostMapping("/savePage")
    public String save(HttpServletRequest request) throws IOException, InterruptedException {
        Map<String, String[]> params = new LinkedHashMap<>(request.getParameterMap());
        // params.remove("validForm");
//        for (String key : params.keySet()) {
//            String[] values = params.get(key);
//            for (String value : values) {
//                System.out.println("Paramètre " + key + " : " + value);
//            }
//        }
        saveCode(params);
        return "redirect:/mainPage.html" ;
    }

    // Je te laisse gérer le fait de mettre dans la BDD les données
    /*
    [
        "password"=>...,
        "password-confirm" => ...,
        "numberStudent" => ...
     ]
     */
//    @PostMapping("/newSessionPage")
//    public String newSession(HttpServletRequest request) throws IOException, InterruptedException {
//        Map<String, String[]> params = new LinkedHashMap<>(request.getParameterMap());
//        // params.remove("validForm");
//        for (String key : params.keySet()) {
//            String[] values = params.get(key);
//            for (String value : values) {
//                System.out.println("Paramètre " + key + " : " + value);
//            }
//        }
//        return "redirect:/mainPage.html" ;
//    }


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

    public Code saveCode(Map<String, String[]> params) {
        Set<InstructionEntity> instructions = new HashSet<>(Set.of());
        CodeEntity code = new CodeEntity(params.get("name")[0]);
        params.remove("name");
        int compteur = 0;
        for (String key : params.keySet()) {
            instructions.add(new InstructionEntity(params.get(key)[0], javaArduinoTranslator.translate(params.get(key)[0]),code, Long.valueOf(compteur)));
            compteur += 1;
        }
        instructionDao.saveAll(instructions);
        code.setInstructions(instructions);

        CodeEntity saved = codeDao.save(code);
        return new CodeMapper().of(saved);
    }
}
