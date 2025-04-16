$(document).ready(function () {
    // Attach submit event to the registration form
    $('#registerForm').submit(function (e) {
        e.preventDefault(); // Prevent default form submission
        registerUser(); // Call the registerUser function
    });
});

function registerUser() {
    // Collect form data
    const data = {
        username: $('#username').val(),
        email: $('#emailRegister').val(),
        password: $('#passwordRegister').val(),
        role: $('#role').val()
    };

    // Send data to the backend API
    fetch('http://localhost:8081/api/v1/user/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => {
            if (!response.ok) {
                return response.json().then(err => {
                    throw new Error(err.message || 'Failed to register user');
                });
            }
            return response.json();
        })
        .then(data => {
            if (data && data.data && data.data.token) {
                console.log('Registration successful:', data);
                Swal.fire('User registered successfully');
                window.location.href = 'login.html'; // Redirect to login page
            } else {
                throw new Error('Invalid response structure from server');
            }
        })
        .catch(error => {
            console.error('Error during registration:', error);
            Swal.fire('Registration failed: ' + error.message);
        });
}