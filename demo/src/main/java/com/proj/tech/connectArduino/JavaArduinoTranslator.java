package com.proj.tech.connectArduino;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class JavaArduinoTranslator {
    private Dictionary<String,Character> dict = new Hashtable<String,Character>();

    public JavaArduinoTranslator() {
        dict.put("Couleur Rouge", 'r');
        dict.put("Couleur Bleue", 'b');
        dict.put("Couleur Verte", 'v');
        dict.put("Couleur Blanche", 'w');
        dict.put("Eteindre", 'e');
        dict.put("1 seconce", '1');
        dict.put("2 secondes", '2');
        dict.put("3 secondes", '3');
        dict.put("5 secondes", '5');
    }

    public Dictionary<String, Character> getDict() {
        return dict;
    }


    public Character translate(String key) {
        return dict.get(key);
    }
}
