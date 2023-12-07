#include "Adafruit_TinyUSB.h"

bool ledState = LOW;  // État initial de la LED éteinte

void setup() {
  Serial.begin(9600);
  pinMode(7, OUTPUT);
}

void loop() {
  if (Serial.available() > 0) {
    char command = Serial.read();
    
    if (command == '1') { // Commande reçue pour allumer la LED
      digitalWrite(7, HIGH);
    } else if (command == '0') { // Commande reçue pour éteindre la LED
      digitalWrite(7, LOW);
    } else if (command == 'd') { // Commande reçue pour ajuster le délai
      int delayTime = Serial.parseInt();
      delay(delayTime);
    } else if (command == 'C') { // Commande pour exécuter plusieurs commandes
      while (Serial.available() > 0) {
        char subCommand = Serial.read();
        
        // Exécuter les sous-commandes reçues
        if (subCommand == '1') {
          digitalWrite(7, HIGH);
        } else if (subCommand == '0') {
          digitalWrite(7, LOW);
        } else if (subCommand == 'd') {
          int delayTime = Serial.parseInt();
          delay(delayTime);
        }
      }
    }
  }
}
