$(document).ready(function () {
    loadCheckUpCards();

    // Add event listener for the search bar
    $('#searchBar').on('input', function () {
        const searchTerm = $(this).val().toLowerCase();
        filterCheckUpCards(searchTerm);
    });
});

function loadCheckUpCards() {
    $.ajax({
        url: 'http://localhost:8081/api/v1/checkup/getAll',
        method: 'GET',
        success: function (response) {
            const checkUps = response.data;
            const container = $('#checkupCardsContainer');
            container.empty(); // Clear existing cards

            checkUps.forEach(checkUp => {
                const card = `
                    <div class="col-md-4 checkup-card" data-name="${checkUp.name.toLowerCase()}">
                        <div class="card">
                            <img src="data:image/jpeg;base64,${checkUp.image}" class="card-img-top" alt="${checkUp.name}">
                            <div class="card-body">
                                <h5 class="card-title">${checkUp.name}</h5>
                                <p class="card-text">Type: ${checkUp.type}</p>
                                <p class="card-text">Price: $${checkUp.price.toFixed(2)}</p>
                                <p class="card-text">Duration: ${checkUp.duration}</p>
                                <p class="card-text">${checkUp.description}</p>
                                <button class="btn btn-primary mt-3" onclick="makeAppointment('${checkUp.checkUpId}')">Make Appointment</button>
                            </div>
                        </div>
                    </div>
                `;
                container.append(card);
            });
        },
        error: function (xhr, status, error) {
            console.error('Failed to load checkups:', xhr.responseText, status, error);
            alert('Failed to load checkups.');
        }
    });
}

function filterCheckUpCards(searchTerm) {
    $('.checkup-card').each(function () {
        const name = $(this).data('name');
        if (name.includes(searchTerm)) {
            $(this).show();
        } else {
            $(this).hide();
        }
    });
}

function makeAppointment(checkUpId) {
    alert(`Make Appointment clicked for CheckUp ID: ${checkUpId}`);
    // Add logic to handle appointment creation
}