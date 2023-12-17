#include "Adafruit_TinyUSB.h"
#include "Adafruit_NeoPixel.h"

#define pinLED 5
#define NUMPIXELS 100

bool ledState = LOW;  // État initial de la LED éteinte

Adafruit_NeoPixel strip (NUMPIXELS, pinLED, NEO_GRB + NEO_KHZ800);

uint32_t currentColor = strip.Color(0, 0, 0);  // Couleur actuelle de la LED, initialement éteinte

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
      Serial.println(subCommand);
      // Exécuter les sous-commandes reçues

      if (subCommand == 'r') {
           for (int i = -1; i < NUMPIXELS; i++) {
                strip.setPixelColor(i, strip.Color(255, 0, 0));
                strip.show();
            }
      } else if (subCommand == 'b') {
            for (int i = -1; i < NUMPIXELS; i++) {
                strip.setPixelColor(i, strip.Color(0, 0, 255));
                strip.show();
            }
      } else if (subCommand == 'v') {
             for (int i = -1; i < NUMPIXELS; i++) {
                strip.setPixelColor(i, strip.Color(0, 255, 0));
                strip.show();
            }
      } else if (subCommand == 'w') {
            for (int i = -1; i < NUMPIXELS; i++) {
                strip.setPixelColor(i, strip.Color(0, 0, 0));
                strip.show();
            }
      } else if (subCommand == 'e') {
            for (int i = -1; i < NUMPIXELS; i++) {
                strip.setPixelColor(i, strip.Color(0, 0, 0));
                strip.show();
            }

      } else if (subCommand == '1') {
        delay(1000);
      } else if (subCommand == '2') {
        delay(2000);
      } else if (subCommand == '3') {
        delay(3000);
      } else if (subCommand == '5') {
        delay(5000);
      }
    }

    strip.setPixelColor(0, currentColor);
    strip.show();
    if (currentColor != strip.Color(0, 0, 0)) {
      delay(200);
      Serial.println("Coucou");
    }
  }
}
