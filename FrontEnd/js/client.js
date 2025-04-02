function addClient() {
    const client = {
        firstName: $('#firstName').val(),
        lastName: $('#lastName').val(),
        age: $('#age').val(),
        address: $('#address').val(),
        contact: $('#contact').val(),
        email: $('#email').val(),
        gender: $('#gender').val()
    };

    $.ajax({
        url: 'http://localhost:8081/api/v1/client/save',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(client),
        success: function () {
            alert('Client added successfully!');
            getAllClients();
            $('#clientForm')[0].reset();
        },
        error: function () {
            alert('Error adding client. Please try again.');
        }
    });
}

function getAllClients() {
    $.ajax({
        url: 'http://localhost:8081/api/v1/client/getAll', // ✅ Ensure correct URL
        method: 'GET',
        dataType: 'json',  // ✅ Ensure response is parsed as JSON
        success: function (response) {
            console.log("Fetched clients:", response);  // Debugging

            const tbody = $('#clientTableBody');
            tbody.empty();

            response.forEach(client => {
                tbody.append(`<tr>
                    <td>${client.clientId}</td>
                    <td>${client.firstName}</td>
                    <td>${client.lastName}</td>
                    <td>${client.age}</td>
                    <td>${client.address}</td>
                    <td>${client.contact}</td>
                    <td>${client.email}</td>
                    <td>${client.gender}</td>
                </tr>`);
            });
        },
        error: function (xhr) {
            console.error("Error fetching clients:", xhr.responseText);
            alert('Error fetching clients: ' + xhr.responseText);
        }
    });
}

// Call function when page loads
$(document).ready(getAllClients);