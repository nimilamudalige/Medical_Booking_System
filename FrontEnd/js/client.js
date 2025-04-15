function addClient() {
    const client = {
        firstName: $('#firstName').val(),
        lastName: $('#lastName').val(),
        age: $('#age').val(),
        address: $('#address').val(),
        contactNo: $('#contact').val(), // Corrected field name
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
            $('#clientForm')[0].reset();
            getAllClients(); // Refresh the table with all clients
        },
        error: function () {
            alert('Error adding client. Please try again.');
        }
    });
}

function getAllClients() {
    $.ajax({
        url: 'http://localhost:8081/api/v1/client/getAll',
        method: 'GET',
        dataType: 'json',
        success: function (response) {
            console.log("Fetched clients:", response);  // Debugging

            const tbody = $('#clientTableBody');
            tbody.empty();

            // Assuming response.data contains the list of clients
            const clients = response.data;
            clients.forEach(client => {
                tbody.append(`<tr>
                  
                    <td>${client.firstName}</td>
                    <td>${client.lastName}</td>
                    <td>${client.age}</td>
                    <td>${client.address}</td>
                    <td>${client.contactNo}</td> <!-- Updated field name -->
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

// Add event listener to table rows
$(document).on('click', '#clientTableBody tr', function() {
    const row = $(this).children('td');
    $('#clientId').val(row.eq(7).text()); // Assuming clientId is stored in a hidden field
    $('#firstName').val(row.eq(0).text());
    $('#lastName').val(row.eq(1).text());
    $('#age').val(row.eq(2).text());
    $('#address').val(row.eq(3).text());
    $('#contact').val(row.eq(4).text());
    $('#email').val(row.eq(5).text());
    $('#gender').val(row.eq(6).text());
});

function updateClient() {
    const client = {
        clientId: $('#clientId').val(), // Assuming clientId is stored in a hidden field
        firstName: $('#firstName').val(),
        lastName: $('#lastName').val(),
        age: $('#age').val(),
        address: $('#address').val(),
        contactNo: $('#contact').val(),
        email: $('#email').val(),
        gender: $('#gender').val()
    };

    $.ajax({
        url: 'http://localhost:8081/api/v1/client/update',
        method: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(client),
        success: function () {
            alert('Client updated successfully!');
            $('#clientForm')[0].reset();
            getAllClients(); // Refresh the table with all clients
        },
        error: function () {
            alert('Error updating client. Please try again.');
        }
    });
}

// Call function when page loads
$(document).ready(getAllClients);

