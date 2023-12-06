package com.proj.tech.controller;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.GetMapping; // Si formulaire envoyé avec GET
import jakarta.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@Controller
public class MonControleur {

    @PostMapping("/maPage") // "/maPage" correspond à <form action="/maPage" method="post">
    public String maPage(HttpServletRequest request) {
        Map<String, String[]> params = new LinkedHashMap<>(request.getParameterMap());
        // request.getParameterMap() correspond POST : [clef => [valeur1, valeur2]]
        // LinkedHashMa^p permet de faire une copie de ce tableau, et par conséquent pouvoir remove "validForm" qui est le name de input type="submit"

        params.remove("validForm") ;

        // Pour affichage dans le Terminal
        for (String key : params.keySet()) {
            String[] values = params.get(key);
            for (String value : values) {
                //if(value != null){
                  //  Logger.getLogger(MonControleur.class.getName()).warning("Cette valeur n'est pas nulle");
                //}
                System.out.println("Paramètre " + key + " : " + value);
            }
        }
        // /!\ Si tu fais plusieurs tests, params ne sera pas rebouté, mais en faisant CTRL + F5 sur ta page web ça reboute je crois
        return "redirect:/result.html";
    }
}
