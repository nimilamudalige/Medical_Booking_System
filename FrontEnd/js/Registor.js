function registerUser() {
    const username = document.getElementById('username').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const role = document.getElementById('role').value;

    const data = {
        username: username,
        email: email,
        password: password,
        role: role
    };

    fetch('http://localhost:8081/api/v1/user/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'token': "eyJhbGciOiJIUzUxMiJ9.eyJyb2xlIjoiVVNFUiIsInN1YiI6InBhc2FuQGV4YW1wbGUuY29tIiwiaWF0IjoxNzQyMzE1MTEwLCJleHAiOjE3NDMzNTE5MTB9.KsuJvemTCHZ5qNYu9eFZtRUEj0riz69oI--udQzV4P1Ey3u8dLNCRqWhNbUDheiMgZgnkZ8P8Deg_2BdY402wg"
        },
        body: JSON.stringify(data)
    })
        .then(response => response.json())
        .then(data => {
            alert(data.message);
        })
        .catch(error => {
            alert('Registration failed!');
            console.error('Error:', error);
        });
}