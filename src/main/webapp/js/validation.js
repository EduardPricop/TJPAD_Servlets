document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("contactForm");

    form.addEventListener("input", function (event) {
        const target = event.target;

        if (target.validity.valid) {
            document.getElementById(`${target.id}-check`).style.visibility = "visible";
        } else {
            document.getElementById(`${target.id}-check`).style.visibility = "hidden";
        }
    });

    form.addEventListener("submit", function (event) {
        event.preventDefault();
        disableForm(true);
        showConfirmationDialog();
    });

    function showConfirmationDialog() {
        const confirmationDialog = document.createElement("div");
        confirmationDialog.classList.add("confirmation-dialog");

        confirmationDialog.innerHTML = `
            <div class="dialog-content">
                <p>Are you sure you want to submit the form?</p>
                <button class="confirm">Yes</button>
                <button class="cancel">No</button>
            </div>
        `;
        document.body.appendChild(confirmationDialog);

        confirmationDialog.style.display = "flex";

        confirmationDialog.querySelector(".confirm").addEventListener("click", function () {
            confirmationDialog.remove();
            disableForm(false);
            sendFormData();
        });

        confirmationDialog.querySelector(".cancel").addEventListener("click", function () {
            confirmationDialog.remove();
            disableForm(false);
        });
    }

    function disableForm(disable) {
        const inputs = form.querySelectorAll("input, textarea, select, button");
        inputs.forEach((input) => {
            input.disabled = disable;
        });
    }

    function sendFormData() {
        const formData = new FormData(form);
        const xhr = new XMLHttpRequest();
        xhr.open("POST", "http://localhost:8080/TJPAD/second", true);

        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

        xhr.onload = function () {
            if (xhr.status === 200) {
                window.location.href = "second";
            } else {
                alert("Error: Unable to submit the form.");
            }
        };

        const urlEncodedData = new URLSearchParams();
        formData.forEach((value, key) => {
            urlEncodedData.append(key, value);
        });

        xhr.send(urlEncodedData.toString());
    }
});
