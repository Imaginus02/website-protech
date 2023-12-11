API :
GET /api/users :
get the list of all users

POST /api/users/new :
{
    "email" : "email",
    "username" "username",
    "password" : "password"
}

GET /api/sessions/{username}(/active or /archived (optional))

POST /api/sessions
name=nameOfTheSession&username=UsernameOfTheCreator&maxUser=NumberOfStudentConnectedAtTheSameTime&endDate=YYYY-MM-DD

A Session has only an end date : the start date is the actual time at which it was created.

GET /api/codes :
get the list of all codes

GET /api/codes/{id} :
get the code with the {id}

Request to run code :
POST /api/request
code=id

Maintenant pour se connecter il faut aller sur /login/professor et /login/student et non plus /login.html

Todo Code:
3 - Add a new page to the web App to see all registered code - J|T - OK
5 - Use the mobile App to send a POST a request to execute code - J|T
6 - Once a request is in the database we need to run it  --> Add a POST endpoint at /api/request - J|T
7 - Add Post and Update method to /api/users to be able to modify user profile - T
10 - Add a way to create new users and use them in Spring security - T
13 - Add a way to login as a student or as a professor (students without password) - T
14 - Add tests to make professors happy - J&T
16 - Change the way InteractArduino works by making it accept code, and when we submit the code, a new instance of code should be created then passed to InteractArduino

Todo Do :
1 - Complete the dictionary in JavaArduinoTranslator - J
2 - Add a function to save a new code in MonController - T - OK
4 - Add a controller to receive post request to /api/request - T - OK
8 - Add a Vue.js page to make a profile page - J OK - J'ai fait la page de création de session
9 - Add a register page for professor - J OK
11 - Add a login page for students and another one for teachers - J OK
12 - Add a save button on mainPage.html, when clicked it should open a dialog box where you can put a string, and another save button. If the text box is empty, no request should be sent - J OK
    <-- Pour 12, tu peux examiner le rendu dans le terminal (petit controller dans MonControleur l.89)
15 - Faire disjonction de cas code Arduino J

Todo Rendu :
1 - Finir le rapport
2 - Faire le diapo