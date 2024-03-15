//nav bar hover
document.addEventListener("DOMContentLoaded", function () {
    // make it as accordion for smaller screens
    if (window.innerWidth > 992) {

        document.querySelectorAll('.navbar .nav-item').forEach(function (everyitem) {

            everyitem.addEventListener('mouseover', function (e) {

                let el_link = this.querySelector('a[data-bs-toggle]');

                if (el_link != null) {
                    let nextEl = el_link.nextElementSibling;
                    el_link.classList.add('show');
                    nextEl.classList.add('show');
                }

            });
            everyitem.addEventListener('mouseleave', function (e) {
                let el_link = this.querySelector('a[data-bs-toggle]');

                if (el_link != null) {
                    let nextEl = el_link.nextElementSibling;
                    el_link.classList.remove('show');
                    nextEl.classList.remove('show');
                }


            })
        });

    }
    // end if innerWidth
});


document.getElementById('registerForm').addEventListener('submit', function (event) {
    var password = document.getElementById('password').value;
    var reenterpass = document.getElementById('reenterpass').value;
    var passwordError = document.getElementById('passwordError');

    if (password !== reenterpass) {
        passwordError.style.display = 'block';
        event.preventDefault();
    } else {
        passwordError.style.display = 'none';
    }
});


function Quit() {
var result = confirm("Want to Quit?");
if (result) {
  return true;
  }
    else {
  return false;
 }
}


function getType(){
    var type = $("#type").val();
    $('#date').val("");
    $.ajax({
        url: "RequestAppointment?aptype=" + type, // Add equals sign after aptype
        type: "GET",
        success: function(response){
            $("#date").prop("min", response); // Assuming response is the value you want to set as min
            $('#Payment').val(price);
        },
        error: function(){
            alert("Error fetching data");
        }
    }); 
}

/*function getType() {
    var type = $("#type").val();
    $('#date').val("");
    $.ajax({
        url: "RequestAppointment?aptype=" + type,
        type: "GET",
        success: function(response) {
            var responseData = response.split(","); // Split response into an array
            var maxdate = responseData[0]; // Get the maxdate
            var price = responseData[1]; // Get the price
            $("#date").prop("min", maxdate); // Set the min attribute for the date input
            $('#Payment').val(price); // Set the value for the Payment input
        },
        error: function() {
            alert("Error fetching data");
        }
    }); 
}*/





