<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title><sitemesh:write property='title'></sitemesh:write></title>
	
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet">
  
  <!-- Custom CSS -->
  <style>
    body {
      background-color: #f4f4f4;
    }

    .navbar {
      background-color: #4CAF50; /* Green */
    }

    .navbar-brand {
      color: #ffffff;
      font-weight: bold;
    }

    .navbar-nav .nav-link {
      color: #ffffff;
    }

    .container {
      margin-top: 50px;
    }

    .card {
      margin-bottom: 20px;
    }

    .footer {
      background-color: #333; /* Dark Gray */
      color: #ffffff;
      padding: 20px 0;
    }

    .user-profile {
      display: flex;
      align-items: center;
      color: #ffffff;
      cursor: pointer;
    }

    .user-avatar {
      width: 40px;
      height: 40px;
      border-radius: 50%;
      margin-right: 10px;
    }

    .dropdown-menu a {
      color: #333; /* Dark Gray */
    }
  </style>
</head>
<body>

<!-- Navigation Bar -->
<nav class="navbar navbar-expand-lg navbar-dark">
  <div class="container-fluid">
  	
    <a class="navbar-brand" href="#"><img style="max-width: 10%" src="../resources/images/dic-icon.png" alt="Logo" class="img-fluid"> <span class="ms-2"> VocabVista </span></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav ms-auto">
        <li class="nav-item">
          <a class="nav-link" href="#">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">About</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Services</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Contact</a>
        </li>
      </ul>
      <!-- User Profile Dropdown -->
      <div class="user-profile dropdown">
        <img src="user-avatar.png" alt="User Avatar" class="user-avatar" id="userDropdown" data-bs-toggle="dropdown" aria-expanded="false">
        <div class="dropdown-menu" aria-labelledby="userDropdown">
          <a class="dropdown-item" href="#">Profile</a>
          <a class="dropdown-item" href="#">History</a>
          <a class="dropdown-item" href="#">Settings</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#" onclick="logout()">Logout</a>
        </div>
      </div>
    </div>
  </div>
</nav>

<!-- Main Content -->
<div class="container">
  <!-- Logo and Search Area -->
  <div class="row mb-4">
    <div class="col-md-6">
      Search
    </div>
    <div class="col-md-6">
      <!-- Search Bar -->
      <div class="input-group">
        <input type="text" class="form-control" placeholder="Search for a word..." aria-describedby="searchBtn">
        <button class="btn btn-success" type="button" id="searchBtn">Search</button>
      </div>
    </div>
  </div>

  <!-- Results -->
  <div id="results">
     <sitemesh:write property='body'/>
  </div>

</div>

<!-- Footer -->
<div class="footer text-center text-white" style="background-color: #4CAF50;">
  <div class="container">
    <div class="row">
      <!-- Social Media Icons -->
      <div class="col-md-6">
        <h5>Follow Us</h5>
        <a href="#" class="text-white me-3"><i class="fab fa-facebook-f"></i></a>
        <a href="#" class="text-white me-3"><i class="fab fa-twitter"></i></a>
        <a href="#" class="text-white me-3"><i class="fab fa-instagram"></i></a>
        <a href="#" class="text-white"><i class="fab fa-linkedin-in"></i></a>
      </div>
      <!-- Additional Information -->
      <div class="col-md-6">
        <h5>Contact Us</h5>
        <p>Email: info@dictionaryapp.com</p>
        <p>Phone: +1 (123) 456-7890</p>
        <p>&copy; 2024 Dictionary App. All rights reserved.</p>
      </div>
    </div>
  </div>
</div>


<!-- Bootstrap JS and Popper.js (required for Bootstrap components) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"></script>

<!-- Logout Function (Replace with actual logout logic) -->
<script>
  function logout() {
    alert("Logout function to be implemented");
  }
</script>

</body>
</html>
