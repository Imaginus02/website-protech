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
{
    "name" : "Name of the session",
    "username" : "Name of the user that created the session",
    "maxUser" : "Number of maximum user allowed at the same time",
    "endDate" : "2023-12-09T18:31:12.093+00:00"
}
The date will be in the same format as the one returned by (in JavaScript) :
const currentDate = new Date();
const formattedDate = currentDate.toISOString().replace('Z', '+00:00');

GET /api/codes :
get the list of all codes

GET /api/codes/{id} :
get the code with the {id}



A Session has only an end date : the start date is the actual time at which it was created.

Todo Code:
1 - Complete the dictionary in JavaArduinoTranslator - J
2 - Add a function to save a new code in MonController - T - OK
3 - Add a new page to the web App to see all registered code - J|T
4 - Add a controller to receive post request to /api/request - T - OK
5 - Use the mobile App to send a POST a request - J|T
6 - Once a request is in the database we need to run it - J|T
7 - Add Post and Update method to /api/users to be able to modify user profile - T
8 - Add a Vue.js page to make a profile page - J|T
9 - Add a register page for professor - J
10 - Add a way to create new users and use them in Spring security - T
11 - Add a login page for students and another one for teachers - J
12 - Add a save button on mainPage.html, when clicked it should open a dialog box where you can put a string, and another save button. If the text box is empty, no request should be sent - J
13 - Add a way to login as a student or as a professor (students without password) - T
14 - Add tests to make professors happy - J&T

Todo Rendu :
1 - Finir le rapport
2 - Faire le diapo