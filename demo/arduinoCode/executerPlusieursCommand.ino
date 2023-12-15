#include "Adafruit_TinyUSB.h"
#include "Adafruit_NeoPixel.h"

#define pinLED 5

bool ledState = LOW;  // État initial de la LED éteinte
Adafruit_NeoPixel strip (5, pinLED, NEO_GRB + NEO_KHZ800); 

void setup() {
  Serial.begin(9600);
  pinMode(pinLED, OUTPUT);

  strip.begin();
  strip.setBrightness(50);  // luminosité de la LED (maximum 255)
}

void loop() {
  if (Serial.available() > 0) {
      while (Serial.available() > 0) {
        char subCommand = Serial.read();
        
        // Exécuter les sous-commandes reçues
        if (subCommand == 'r') {
                strip.setPixelColor(5, strip.Color(255, 0, 0));
                strip.show();
        } else if (subCommand == 'b') {
                strip.setPixelColor(5, strip.Color(0, 0, 255));
                strip.show();
        } else if (subCommand == 'v') {
                strip.setPixelColor(5, strip.Color(0, 255, 0));
                strip.show();
        } else if (subCommand == 'w') {
                strip.setPixelColor(5, strip.Color(255, 255, 255));
                strip.show();

        } else if (subCommand == 'e') {
                strip.setPixelColor(5, strip.Color(0,0,0));
                strip.show();

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
