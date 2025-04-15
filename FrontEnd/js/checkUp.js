$(document).ready(function () {
    getAllCheckUps();

    // Add click event listener to table rows
    $('#checkupTableBody').on('click', 'tr', function () {
        const row = $(this).children('td');
        $('#checkUpId').val($(this).data('id'));
        $('#name').val(row.eq(1).text());
        $('#type').val(row.eq(2).text());
        $('#price').val(row.eq(3).text());
        $('#duration').val(row.eq(4).text());
        $('#description').val(row.eq(5).text());
    });
});

function addCheckUp() {
    const file = $('#image')[0].files[0];
    const reader = new FileReader();
    reader.onloadend = function () {
        const base64Image = reader.result.split(',')[1];
        const checkUpData = {
            name: $('#name').val(),
            type: $('#type').val(),
            price: parseFloat($('#price').val()),
            duration: $('#duration').val(),
            description: $('#description').val(),
            image: base64Image
        };

        $.ajax({
            url: 'http://localhost:8081/api/v1/checkup/save',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(checkUpData),
            success: function () {
                alert('CheckUp added successfully!');
                $('#checkupForm')[0].reset();
                getAllCheckUps();
            },
            error: function (xhr, status, error) {
                alert('Failed to add CheckUp: ' + xhr.responseText);
            }
        });
    };
    reader.readAsDataURL(file);
}

function getAllCheckUps() {
    $.ajax({
        url: 'http://localhost:8081/api/v1/checkup/getAll',
        method: 'GET',
        success: function (response) {
            const checkUps = response.data;
            const tbody = $('#checkupTableBody');
            tbody.empty();
            checkUps.forEach(checkUp => {
                const row = `<tr data-id="${checkUp.checkUpId}">
                    <td><img src="data:image/jpeg;base64,${checkUp.image}" class="img-thumbnail" alt="CheckUp Image"></td>
                    <td>${checkUp.name}</td>
                    <td>${checkUp.type}</td>
                    <td>${checkUp.price}</td>
                    <td>${checkUp.duration}</td>
                    <td>${checkUp.description}</td>
                </tr>`;
                tbody.append(row);
            });
        },
        error: function (xhr, status, error) {
            console.error('Error details:', xhr, status, error); // Log full error details
            alert('Failed to load CheckUps: ' + (xhr.responseText || error));
        }
    });
}

function updateCheckUp() {
    const file = $('#image')[0].files[0];
    const reader = new FileReader();
    reader.onloadend = function () {
        const base64Image = reader.result.split(',')[1];
        const checkUpData = {
            checkUpId: $('#checkUpId').val(),
            name: $('#name').val(),
            type: $('#type').val(),
            price: parseFloat($('#price').val()),
            duration: $('#duration').val(),
            description: $('#description').val(),
            image: base64Image
        };

        $.ajax({
            url: 'http://localhost:8081/api/v1/checkup/update',
            method: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(checkUpData),
            success: function () {
                alert('CheckUp updated successfully!');
                $('#checkupForm')[0].reset();
                getAllCheckUps();
            },
            error: function (xhr, status, error) {
                alert('Failed to update CheckUp: ' + xhr.responseText);
            }
        });
    };
    if (file) {
        reader.readAsDataURL(file);
    } else {
        const checkUpData = {
            checkUpId: $('#checkUpId').val(),
            name: $('#name').val(),
            type: $('#type').val(),
            price: parseFloat($('#price').val()),
            duration: $('#duration').val(),
            description: $('#description').val(),
            image: $('#image').data('base64')
        };

        $.ajax({
            url: 'http://localhost:8081/api/v1/checkup/update',
            method: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(checkUpData),
            success: function () {
                alert('CheckUp updated successfully!');
                $('#checkupForm')[0].reset();
                getAllCheckUps();
            },
            error: function (xhr, status, error) {
                alert('Failed to update CheckUp: ' + xhr.responseText);
            }
        });
    }
}

function deleteCheckUp() {
    const checkUpId = $('#checkUpId').val();
    if (!checkUpId) {
        alert('Please select a CheckUp to delete.');
        return;
    }

    $.ajax({
        url: `http://localhost:8081/api/v1/checkup/delete/${checkUpId}`,
        method: 'DELETE',
        success: function () {
            alert('CheckUp deleted successfully!');
            $('#checkupForm')[0].reset();
            getAllCheckUps();
        },
        error: function (xhr, status, error) {
            alert('Failed to delete CheckUp: ' + xhr.responseText);
        }
    });
}