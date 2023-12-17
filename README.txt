# DockerFile

Pour run Docker, il faut : 
- avoir installer Docker sur son PC : https://www.docker.com/products/docker-desktop/ 
- exécuter Docker Desktop sur son PC
- suivre les quelques étapes proposées par Docker Desktop (git clone ...)

Puis, aller dans le projet, puis : 
- cd demo
- docker build -t nom-image .
- docker run -p port:8080 nom-image (port modifiable)

API :

(ADMIN)
GET /api/users :
get the list of all users
(ADMIN)
GET /api/user/{id}
get the user with the right id

(ADMIN)
POST /api/users/new :
{
    "email" : "email",
    "username" "username",
    "password" : "password"
}

(ADMIN)
GET /api/sessions
get the list of all sessions

(ADMIN)
GET /api/sessions/{username}(/active or /archived (optional)):
get the list of sessions created by {username}

(ADMIN, PROFESSOR)
POST /api/sessions
name=nameOfTheSession&username=UsernameOfTheCreator&maxUser=NumberOfStudentConnectedAtTheSameTime&endDate=YYYY-MM-DD

A Session has only an end date : the start date is the actual time at which it was created.

(ADMIN)
GET /api/codes :
get the list of all codes

(ADMIN)
GET /api/codes/{id} :
get the code with the {id}

(ADMIN, MOBILE_APP)
GET /api/codes/{username} :
Get the codes created by {username}

(ADMIN, MOBILE_APP)
POST /api/request
code=id
Request to run code

(ADMIN, MOBILE_APP, ARDUINO)
GET /api/request
Get the code that we need to run

Maintenant pour se connecter il faut aller sur /login/professor et /login/student et non plus /login.html

Todo Code:
5 - Use the mobile App to send a POST a request to execute code - J|T

7 - Add Post and Update method to /api/users to be able to modify user profile - T
10 - Add a way to create new users and use them in Spring security - T - OK
13 - Add a way to login as a student or as a professor (students without password) - T
    --> In the /login/student remove the username case and pre-register "session"
14 - Add tests to make professors happy - J&T
16 - Change the way InteractArduino works by making it accept code, and when we submit the code, a new instance of code should be created then passed to InteractArduino
17 - Use the singleton pattern seen with Quentin RICHAUD with the Interact Arduino class - J|T

Done :
1 - Complete the dictionary in JavaArduinoTranslator - J - OK
2 - Add a function to save a new code in MonController - T - OK
3 - Add a new page to the web App to see all registered code - J|T - OK
4 - Add a controller to receive post request to /api/request - T - OK
6 - Once a request is in the database we need to run it  --> Add a POST endpoint at /api/request - J|T - OK
8 - Add a Vue.js page to make a profile page - J OK - J'ai fait la page de création de session
9 - Add a register page for professor - J OK
11 - Add a login page for students and another one for teachers - J OK
12 - Add a save button on mainPage.html, when clicked it should open a dialog box where you can put a string, and another save button. If the text box is empty, no request should be sent - J OK
    <-- Pour 12, tu peux examiner le rendu dans le terminal (petit controller dans MonControleur l.89)
15 - Faire disjonction de cas code Arduino J

Todo Rendu :
1 - Finir le rapport
2 - Faire le diapo