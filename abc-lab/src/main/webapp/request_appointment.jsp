<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Appointment</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="js/main.js"></script>
</head>

<body>

    <nav class="navbar navbar-expand-md navbar-dark fixed-top" style="background-color: #007bff; max-height: 60px;">

        <div class="navbar-brand">
            <img src="images/logowhite.png" alt="" width="200">
        </div>

        <!-- Navigation links centered -->
        <div class="navbar-nav mx-auto">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" target="_blank" href="#">My Appointment</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" target="_blank" href="#">New Appointment</a>
                </li>
            </ul>
        </div>

        <!-- Logout link on the right -->
        <div class="navbar-nav ml-auto">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" onclick='return Quit();' href="#">Log Out</a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-lg-6">
                <div class="myappointment-form">
                    <h3>Request For Appointment</h3>
                    <br>
                    <form action="" method="POST">

                        <div class="form-group">
                            <select class="form-control" required name="type" id="type" onchange="getType()" >
						    <option value="" selected disabled>Select Type</option>
						    <c:forEach items="${dropDownData}" var="option">
						        <option value="${option.id}">${option.label}</option>
						    </c:forEach>
						</select>
                        </div>

                        <br>
                        <div class="form-group">
                            <label for="date">Select Date</label>
                            <input type="date" class="form-control" id="date" name="date" placeholder="Select Date" required>
                        </div>

                        <div class="form-group">
                            <label for="Payment">Payment</label>
                            <input type="text" class="form-control" id="Payment" name="Payment" readonly>
                        </div>

                        <button type="submit" class="btn btn-primary btn-block">Request For Appointment</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    
    
</body>

</html>