package com.proj.tech.controller;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.proj.tech.arduinoInteraction.ArduinoInteract;
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
        // request.getParameterMap() correspond POST : [clef => [valeur1, valeur2]]
        // LinkedHashMa^p permet de faire une copie de ce tableau, et par conséquent pouvoir remove "validForm" qui est le name de input type="submit"

        params.remove("validForm") ;

        // Pour affichage dans le Terminal
        for (String key : params.keySet()) {
            String[] values = params.get(key);
            for (String value : values) {
                System.out.println("Paramètre " + key + " : " + value);

                if(value.equals("Tourner à droite 3 fois")){
                    ArduinoInteract arduino = new ArduinoInteract("COM8") ;
                    System.out.println("Jes uis yuezfu");
                    arduino.SendArduino();
                }

            }
        }
        // /!\ Si tu fais plusieurs tests, params ne sera pas rebouté, mais en faisant CTRL + F5 sur ta page web ça reboute je crois
        return "redirect:/result.html";
    }
}
