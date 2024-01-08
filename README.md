# Canonical Documentation

## Main Theme

The goal of this project is to allow young children to do their first step with programmation. For that, we
have implement some basic instruction of an Arduino in this website.

Three types of people can access to this website, with different privilege :
- admin : can see all users, all session created
- professor : can create a session, can see is session, see and modified is own data
- student : can only use the session create bt the professor to interact with the Arduino.

## To run

### Website

You can access to this website with CleverCloud :
https://app-77695203-c7cc-4ac1-a3c0-52cece554898.cleverapps.io/choose

Or you can run it like java application, for that, run
`
src/main/java/com/proj/tech/ProjTechApplication
`

We have used java 17.

### Mobile application
Open the project with AndroidStudio, and run it.
`
ProjTech/ProjTechMobile
`

### Arduino Configuration

We use the Arduino Feather Bluefruit Sense nRF52840, and the LED WS2812B for this project, with this configuration

![Setup Arduino](setupArduino.jpg)

As you can see, we use the port 5, of the Arduino Card. It's important because we don't have implement the way to change that.

After that, go to ProjTech/arduinoCode/bonCode and open the Arduino Code with Arduino IDE and send this code to your Arduino.
## API

GET /api/users (ADMIN)
> Get the list of all users

GET /api/user/{id} (ADMIN)
> Get the user with the right id

POST /api/users/new : (ADMIN)
{
"email" : "email",
"username" "username",
"password" : "password"
}

GET /api/sessions (ADMIN, PROFESSOR)
> get the list of all sessions, if you are not the ADMIN, you will see only sessions you created

GET /api/sessions/{username}(/active or /archived (optional)): (ADMIN)
> get the list of sessions created by {username}

POST /api/sessions (ADMIN, PROFESSOR)
> name=nameOfTheSession&username=UsernameOfTheCreator&maxUser=NumberOfStudentConnectedAtTheSameTime&endDate=YYYY-MM-DD

A Session has only an end date : the start date is the actual time at which it was created.

GET /api/codes : (ADMIN)
> get the list of all codes

GET /api/codes/{id} : (ADMIN)
> get the code with the {id}

GET /api/codes/{username} : (ADMIN, MOBILE_APP)
> Get the codes created by {username}

POST /api/request (ADMIN, MOBILE_APP)
code=id
> Request to run code

GET /api/request (ADMIN, MOBILE_APP, ARDUINO)
> Get the code that we need to run





## DockerFile

Pour run Docker, il faut :
- avoir installer Docker sur son PC : https://www.docker.com/products/docker-desktop/
- exécuter Docker Desktop sur son PC
- suivre les quelques étapes proposées par Docker Desktop (git clone ...)

Puis, aller dans le projet, puis :
- git checkout withJava-v1
- cd demo
- docker build -t nom-image .
- docker run -p port:8080 nom-image (port modifiable)

## Javadoc

Le code pour générer la Javadoc se trouve à la fin dans build.gradle

A la racine du projet (ProjTech), exécuter la commande
gradle generateJavadoc

La javadoc se trouve alors ProjTech/javadoc/index.html