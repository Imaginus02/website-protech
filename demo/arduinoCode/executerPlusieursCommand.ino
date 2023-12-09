#include "Adafruit_TinyUSB.h"
#define pinLED 7

bool ledState = LOW;  // État initial de la LED éteinte

void setup() {
  Serial.begin(9600);
  pinMode(pinLED, OUTPUT);
}

void loop() {
  if (Serial.available() > 0) {
      while (Serial.available() > 0) {
        char subCommand = Serial.read();
        
        // Exécuter les sous-commandes reçues
        if (subCommand == 'r') {
          digitalWrite(pinLED, HIGH);
        } else if (subCommand == 'b') {
          digitalWrite(pinLED, HIGH);
        } else if (subCommand == 'v') {
          digitalWrite(pinLED, HIGH);
        } else if (subCommand == 'w') {
          digitalWrite(pinLED, HIGH);
        } else if (subCommand == 'e') {
          digitalWrite(pinLED, HIGH);
        } else if (subCommand == '1') {
          delay(1000) ;
        } else if (subCommand == '2') {
          delay(2000) ;
        } else if (subCommand == '3') {
          delay(3000) ;
        } else if (subCommand == '5') {
          delay(5000) ;
        } 
      }
  }
}
