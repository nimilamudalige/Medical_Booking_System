function addDoctor() {
    const file = $('#image')[0].files[0];
    const reader = new FileReader();
    reader.onloadend = function() {
        const base64Image = reader.result.split(',')[1]; // Get Base64 string without the prefix
        const doctorData = {
            name: $('#name').val(),
            email: $('#email').val(),
            contact: $('#contact').val(),
            about: $('#about').val(),
            department: $('#department').val(),
            workingHours: $('#workingHours').val(),
            charge: $('#charge').val(),
            image: base64Image
        };

        $.ajax({
            url: 'http://localhost:8081/api/v1/doctor/save',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(doctorData),
            success: function() {
                alert('Doctor added successfully!');
                $('#doctorForm')[0].reset();
                getAllDoctors();
            },
            error: function(xhr, status, error) {
                alert('Failed to add doctor: ' + xhr.responseText);
            }
        });
    };
    reader.readAsDataURL(file);
}
$(document).ready(function() {
    getAllDoctors();

    // Add click event listener to table rows
    $('#doctorTableBody').on('click', 'tr', function() {
        const row = $(this).children('td');
        $('#docId').val($(this).data('id'));
        $('#name').val(row.eq(1).text());
        $('#email').val(row.eq(2).text());
        $('#contact').val(row.eq(3).text());
        $('#about').val(row.eq(4).text());
        $('#department').val(row.eq(5).text());
        $('#workingHours').val(row.eq(6).text());
        $('#charge').val(row.eq(7).text());
    });
});

function getAllDoctors() {
    $.ajax({
        url: 'http://localhost:8081/api/v1/doctor/getAll',
        method: 'GET',
        success: function(response) {
            const doctors = response.data;
            const tbody = $('#doctorTableBody');
            tbody.empty();
            doctors.forEach(doctor => {
                tbody.append(`<tr data-id="${doctor.docId}">
                    <td><img src="data:image/jpeg;base64,${doctor.image}" class="img-thumbnail" alt="Doctor Image"></td>
                    <td>${doctor.name}</td>
                    <td>${doctor.email}</td>
                    <td>${doctor.contact}</td>
                    <td>${doctor.about}</td>
                    <td>${doctor.department}</td>
                    <td>${doctor.workingHours}</td>
                    <td>${doctor.charge}</td>
                </tr>`);
            });
        }
    });
}
function updateDoctor() {
    const file = $('#image')[0].files[0];
    const reader = new FileReader();
    reader.onloadend = function() {
        const base64Image = reader.result.split(',')[1]; // Get Base64 string without the prefix
        const doctorData = {
            docId: $('#docId').val(),
            name: $('#name').val(),
            email: $('#email').val(),
            contact: $('#contact').val(),
            about: $('#about').val(),
            department: $('#department').val(),
            workingHours: $('#workingHours').val(),
            charge: $('#charge').val(),
            image: base64Image
        };

        $.ajax({
            url: 'http://localhost:8081/api/v1/doctor/update',
            method: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(doctorData),
            success: function() {
                alert('Doctor updated successfully!');
                $('#doctorForm')[0].reset();
                getAllDoctors(); // Refresh the UI table
            },
            error: function(xhr, status, error) {
                alert('Failed to update doctor: ' + xhr.responseText);
            }
        });
    };
    if (file) {
        reader.readAsDataURL(file);
    } else {
        // If no new image is selected, use the existing image
        const doctorData = {
            docId: $('#docId').val(),
            name: $('#name').val(),
            email: $('#email').val(),
            contact: $('#contact').val(),
            about: $('#about').val(),
            department: $('#department').val(),
            workingHours: $('#workingHours').val(),
            charge: $('#charge').val(),
            image: $('#image').data('base64') // Use existing Base64 image
        };

        $.ajax({
            url: 'http://localhost:8081/api/v1/doctor/update',
            method: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(doctorData),
            success: function() {
                alert('Doctor updated successfully!');
                $('#doctorForm')[0].reset();
                getAllDoctors(); // Refresh the UI table
            },
            error: function(xhr, status, error) {
                alert('Failed to update doctor: ' + xhr.responseText);
            }
        });
    }
}
function deleteDoctor() {
    const docId = $('#docId').val();
    if (!docId) {
        alert('Please select a doctor to delete.');
        return;
    }

    $.ajax({
        url: `http://localhost:8081/api/v1/doctor/delete/${docId}`,
        method: 'DELETE',
        success: function () {
            alert('Doctor deleted successfully!');
            $('#doctorForm')[0].reset();
            getAllDoctors(); // Refresh the UI table
        },
        error: function (xhr, status, error) {
            alert('Failed to delete doctor: ' + xhr.responseText);
        }
    });
}

$(document).ready(getAllDoctors);