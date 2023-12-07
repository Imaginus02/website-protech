package com.proj.tech.connectArduino;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestionBlocs {
    private List<String> allumer = new ArrayList<>(List.of("Couleur Rouge", "Couleur Bleue", "Couleur Verte", "Couleur Blanche", "Eteindre")) ;
    private List<String> eteindre = new ArrayList<>(List.of("1 seconde", "2 secondes", "3 secondes", "5 secondes"));
    private final List<String> params;
    public GestionBlocs(List<String> params){
        this.params = params ;
    }

    public boolean VerifyBlocs(){
        int k = 0 ;
        for(k=0; k< params.size() - 1; k++){
            for(int i=0 ; i< allumer.size() ; i++){
                if(allumer.get(i) == params.get(k)){
                    for(int j=0 ; j< allumer.size() ; j++){
                        if(allumer.get(j) == params.get(k+1)){
                            return false ;
                        }
                    }
                }
            }
            for(int i=0 ; i< eteindre.size() ; i++){
                if(eteindre.get(i) == params.get(k)){
                    for(int j=0 ; j< eteindre.size() ; j++){
                        if(eteindre.get(j) == params.get(k+1)){
                            return false ;
                        }
                    }
                }
            }
        }
        return true ;
    }

     /*

    public boolean VerifyBlocs(){
        int k = 0 ;
        for(k=0; k< params.size() - 1; k++){
            for(String key : params.keySet()){
                if(allumer.get(key) == params.get(k)){
                    for(int j=0 ; j< allumer.size() ; j++){
                        if(allumer.get(j) == params.get(k+1)){
                            return false ;
                        }
                    }
                }
            }
            for(int i=0 ; i< eteindre.size() ; i++){
                if(eteindre.get(i) == params.get(k)){
                    for(int j=0 ; j< eteindre.size() ; j++){
                        if(eteindre.get(j) == params.get(k+1)){
                            return false ;
                        }
                    }
                }
            }
        }
        return true ;
    }
*/
    // Faire un deuxieme code qui envoie blinks et delay a Arduino
}
