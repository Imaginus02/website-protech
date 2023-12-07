void setup()
{
  Serial.begin(9600);
  pinMode(7, OUTPUT);
}
//--------------------------
void loop()
{
  byte inByte;
  if(Serial.available())
  {
    inByte = Serial.read();
    for(byte i=1; i<=inByte*2; i++)
    {
      digitalWrite(7, !digitalRead(7));
      delay(200);
    }
  }
}