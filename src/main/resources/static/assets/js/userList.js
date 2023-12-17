
function generateUserDiv(user) {
    var row = document.createElement('tr');
    var userId = document.createElement("td");
    var userEmail = document.createElement("td");
    var userUsername = document.createElement("td");

    userId.textContent = user.id;
    userEmail.textContent = user.email;
    userUsername.textContent = user.username;

    row.appendChild(userId);
    row.appendChild(userEmail);
    row.appendChild(userUsername);
    return row;
}


function retrieveUser() {
    var list = document.getElementById("userList");
    fetch('/users/json') // Replace with the correct URL of your endpoint
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json(); // Parse the JSON response
        })
        .then(users => {
            // Use the JSON data in your JavaScript code
            console.log(users);
            users.forEach(user => {
                list.appendChild(generateUserDiv(user));
            })
        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });
}

retrieveUser();