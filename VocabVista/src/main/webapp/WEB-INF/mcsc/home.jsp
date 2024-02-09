<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<title>GQenius</title>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
	
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>
	<div class="container">
		<h3>Welcome to the QGenius !! </h3><!--   <a href="/list">Click here</a>to list your Items-->
		
		
		<form:form modelAttribute="examEvent"  method="POST" id="addform" class="mt-5">
	        <div class="form-group">
	            <label for="inputField">Input Text:</label>
	            <input type="text" class="form-control" id="inputField" name="inputField">
	        </div>
	
	        <button type="submit" class="btn btn-primary">Submit</button>
	    </form:form>
	</div>
	
	
	

</body>
</html>