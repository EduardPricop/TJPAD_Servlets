document.addEventListener("DOMContentLoaded", function() {
    const form = document.getElementById('contactForm');

    form.addEventListener('input', function(event) {
        const target = event.target;

        if (target.validity.valid) {
            document.getElementById(`${target.id}-check`).style.visibility = 'visible';
        } else {
            document.getElementById(`${target.id}-check`).style.visibility = 'hidden';
        }
    });

    form.addEventListener('submit', function(event) {
        event.preventDefault();

        // Show confirmation dialog
        showConfirmationDialog();
    });

    function showConfirmationDialog() {
        const confirmationDialog = document.createElement('div');
        confirmationDialog.classList.add('confirmation-dialog');

        confirmationDialog.innerHTML = `
            <div class="dialog-content">
                <p>Are you sure you want to submit the form?</p>
                <button class="confirm">Yes</button>
                <button class="cancel">No</button>
            </div>
        `;
        document.body.appendChild(confirmationDialog);

        confirmationDialog.style.display = 'block';

        confirmationDialog.querySelector('.confirm').addEventListener('click', function() {
            form.submit();
            confirmationDialog.style.display = 'none';
        });

        confirmationDialog.querySelector('.cancel').addEventListener('click', function() {
            confirmationDialog.style.display = 'none';
        });
    }
});
