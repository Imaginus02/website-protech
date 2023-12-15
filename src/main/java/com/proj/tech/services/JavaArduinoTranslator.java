package com.proj.tech.services;

import java.util.Dictionary;
import java.util.Hashtable;

public class JavaArduinoTranslator {
    private final Dictionary<String, Character> dict = new Hashtable<String, Character>();

    private final Dictionary<Character, String> reverseDict = new Hashtable<Character, String>();
    public JavaArduinoTranslator() {
        dict.put("Couleur Rouge", 'r');
        dict.put("Couleur Bleue", 'b');
        dict.put("Couleur Verte", 'v');
        dict.put("Couleur Blanche", 'w');
        dict.put("Eteindre", 'e');
        dict.put("1 seconde", '1');
        dict.put("2 secondes", '2');
        dict.put("3 secondes", '3');
        dict.put("5 secondes", '5');

        reverseDict.put('r',"Couleur Rouge");
        reverseDict.put('b', "Couleur Bleue");
        reverseDict.put('v', "Couleur Verte");
        reverseDict.put('w', "Couleur Blanche");
        reverseDict.put('e', "Eteindre");
        reverseDict.put('1', "1 seconde");
        reverseDict.put('2', "2 secondes");
        reverseDict.put('3', "3 secondes");
        reverseDict.put('5', "5 secondes");
    }

    public Dictionary<String, Character> getDict() {
        return dict;
    }

    public void addToDict(String key, Character value) {
        dict.put(key, value);
    }


    public Character translate(String key) {
        return dict.get(key);
    }

    public String reverseTranslate(Character value) {
        return reverseDict.get(value);
    }
}
