$(document).ready(function() {
    $('#registerForm').submit(function(e) {
        e.preventDefault();
        registerUser();
    });
})

function registerUser() {
    console.log("btn clicked");
    const username = document.getElementById('username').value;
    const emailRegister = document.getElementById('emailRegister').value;
    const passwordRegister = document.getElementById('passwordRegister').value;
    const role = document.getElementById('role').value;

    const data = {
        username: username,
        emailRegister: emailRegister,
        passwordRegister: passwordRegister,
        role: role
    };

    fetch('http://localhost:8081/api/v1/user/register', {
        method: 'POST',
        success: function(response) {
            console.log('Registration successful:', response);
            Swal.fire('User registered successfully');
            window.localStorage.setItem('token', response.data.token);
            console.log('Redirecting to login page...');
            window.location.href = 'login.html';
        },
        headers: {
            'Content-Type': 'application/json'
            // 'token': "eyJhbGciOiJIUzUxMiJ9.eyJyb2xlIjoiVVNFUiIsInN1YiI6InBhc2FuQGV4YW1wbGUuY29tIiwiaWF0IjoxNzQyMzE1MTEwLCJleHAiOjE3NDMzNTE5MTB9.KsuJvemTCHZ5qNYu9eFZtRUEj0riz69oI--udQzV4P1Ey3u8dLNCRqWhNbUDheiMgZgnkZ8P8Deg_2BdY402wg"
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